package me.tmarciniak.axon.observability

import io.micrometer.observation.Observation
import io.micrometer.observation.ObservationRegistry
import me.tmarciniak.axon.observability.observation.dispatcher.AxonDispatcherObservation
import me.tmarciniak.axon.observability.observation.dispatcher.AxonMessageDispatcherContext
import me.tmarciniak.axon.observability.observation.handler.AxonHandlerObservation
import me.tmarciniak.axon.observability.observation.handler.AxonMessageHandlerContext
import me.tmarciniak.axon.observability.observation.internal.AxonInternalObservation
import me.tmarciniak.axon.observability.observation.internal.AxonMessageInternalContext
import org.axonframework.messaging.Message
import org.axonframework.tracing.SpanAttributesProvider
import org.axonframework.tracing.SpanFactory
import java.util.function.Consumer
import java.util.function.Supplier

/**
 * @author Tomasz Marciniak
 */
class BraveSpanFactory(
    private val observationRegistry: ObservationRegistry
) : SpanFactory {
    private val spanAttributesProviders = mutableListOf<SpanAttributesProvider>()

    override fun createRootTrace(operationNameSupplier: Supplier<String>): BraveSpan =
        BraveSpan(createInternalObservation(operationName = operationNameSupplier.get(), isRootTrace = true))

    override fun createHandlerSpan(
        operationNameSupplier: Supplier<String>,
        parentMessage: Message<*>,
        isChildTrace: Boolean,
        vararg linkedParents: Message<*>
    ): BraveSpan =
        BraveSpan(
            createHandlerObservation(
                message = parentMessage,
                operationName = operationNameSupplier.get()
            ).also { addMessageAttributes(observation = it, message = parentMessage) }
        )

    override fun createDispatchSpan(
        operationNameSupplier: Supplier<String>,
        parentMessage: Message<*>,
        vararg linkedSiblings: Message<*>
    ): BraveSpan =
        BraveSpan(
            createDispatcherObservation(
                operationName = operationNameSupplier.get(),
                payloadType = parentMessage.payloadType.name
            ).also { addMessageAttributes(observation = it, message = parentMessage) }
        )

    override fun createInternalSpan(operationNameSupplier: Supplier<String>): BraveSpan =
        BraveSpan(createInternalObservation(operationName = operationNameSupplier.get()))

    override fun createInternalSpan(
        operationNameSupplier: Supplier<String>,
        message: Message<*>
    ): BraveSpan =
        BraveSpan(
            createInternalObservation(
                payloadName = message.payloadType.name,
                operationName = operationNameSupplier.get()
            ).also { addMessageAttributes(it, message) }
        )

    override fun <M : Message<*>> propagateContext(message: M): M =
        getAxonMessageDispatcherContextCarrier()
            .addMetadata(message)
            .castToMessage(message)

    override fun registerSpanAttributeProvider(provider: SpanAttributesProvider): Unit =
        Unit.also { spanAttributesProviders.add(provider) }

    private fun getAxonMessageDispatcherContextCarrier(): MutableMap<String, Any>? =
        (observationRegistry.currentObservation?.context as? AxonMessageDispatcherContext)?.carrier

    private fun addMessageAttributes(
        observation: Observation,
        message: Message<*>?
    ): Unit? = message?.let { addAttributes(it, observation) }

    private fun addAttributes(
        message: Message<*>,
        observation: Observation
    ) = spanAttributesProviders.forEach(
        Consumer { supplier: SpanAttributesProvider ->
            val attributes = supplier.provideForMessage(message)
            attributes.forEach { observation.lowCardinalityKeyValue(it.key, it.value) }
        }
    )

    private fun createDispatcherObservation(
        operationName: String,
        payloadType: String
    ): Observation =
        AxonDispatcherObservation.DISPATCHER_OBSERVATION.observation(
            null,
            AxonDispatcherObservation.DefaultAxonDispatcherObservationConvention.INSTANCE,
            { AxonMessageDispatcherContext(payloadType, operationName) },
            observationRegistry
        )

    private fun createHandlerObservation(
        message: Message<*>,
        operationName: String
    ): Observation =
        AxonHandlerObservation.HANDLER_OBSERVATION.observation(
            null,
            AxonHandlerObservation.DefaultAxonHandlerObservationConvention.INSTANCE,
            { AxonMessageHandlerContext(message, operationName) },
            observationRegistry
        )

    private fun createInternalObservation(
        payloadName: String? = null,
        operationName: String,
        isRootTrace: Boolean = false
    ): Observation =
        AxonInternalObservation.INTERNAL_OBSERVATION.observation(
            null,
            AxonInternalObservation.DefaultAxonInternalObservationConvention.INSTANCE,
            { AxonMessageInternalContext(payloadName, operationName, isRootTrace) },
            observationRegistry
        )
}

private fun <M : Message<*>> Message<out Any>?.castToMessage(message: M): M = message.javaClass.cast(this) ?: message

private fun MutableMap<String, *>?.addMetadata(message: Message<*>): Message<out Any>? =
    this?.let { message.andMetaData(this) }