package me.tmarciniak.axon.observability

import io.micrometer.observation.Observation
import io.micrometer.observation.ObservationRegistry
import me.tmarciniak.axon.observability.observation.dispatcher.AxonDispatcherObservation
import me.tmarciniak.axon.observability.observation.dispatcher.AxonMessageDispatcherContext
import me.tmarciniak.axon.observability.observation.handler.AxonHandlerObservation
import me.tmarciniak.axon.observability.observation.handler.AxonMessageHandlerContext
import me.tmarciniak.axon.observability.observation.internal.AxonInternalObservation
import me.tmarciniak.axon.observability.observation.internal.AxonMessageInternalContext
import mu.KotlinLogging
import org.axonframework.messaging.Message
import org.axonframework.tracing.SpanAttributesProvider
import org.axonframework.tracing.SpanFactory
import java.util.function.Supplier

private val log = KotlinLogging.logger {}

/**
 * @author Tomasz Marciniak
 */
class BraveSpanFactory(private val observationRegistry: ObservationRegistry) : SpanFactory {
    private val spanAttributesProviders = mutableListOf<SpanAttributesProvider>()

    override fun createRootTrace(operationNameSupplier: Supplier<String>): BraveSpan =
        BraveSpan(internalObservation(operationNameSupplier.get()))

    override fun createHandlerSpan(
        operationNameSupplier: Supplier<String>,
        parentMessage: Message<*>,
        isChildTrace: Boolean,
        vararg linkedParents: Message<*>
    ): BraveSpan = BraveSpan(handlerObservation(parentMessage, operationNameSupplier.get()))

    override fun createDispatchSpan(
        operationNameSupplier: Supplier<String>,
        parentMessage: Message<*>,
        vararg linkedSiblings: Message<*>
    ): BraveSpan = BraveSpan(dispatcherObservation(parentMessage, operationNameSupplier.get()))

    override fun createInternalSpan(operationNameSupplier: Supplier<String>): BraveSpan =
        BraveSpan(internalObservation(operationNameSupplier.get()))

    override fun createInternalSpan(
        operationNameSupplier: Supplier<String>,
        message: Message<*>
    ): BraveSpan = BraveSpan(internalObservation(operationNameSupplier.get(), message.payloadType.name))

    override fun <M : Message<*>> propagateContext(message: M): M =
        (observationRegistry.currentObservation?.context as? AxonMessageDispatcherContext).let { context ->
            context?.carrier?.let { message.javaClass.cast(message.andMetaData(it as MutableMap<String, *>)) }
        } ?: message

    override fun registerSpanAttributeProvider(provider: SpanAttributesProvider): Unit =
        spanAttributesProviders.add(provider).let { }

    private fun dispatcherObservation(
        message: Message<*>,
        operationName: String
    ): Observation =
        AxonDispatcherObservation.DISPATCHER_OBSERVATION.observation(
            null,
            AxonDispatcherObservation.DefaultAxonDispatcherObservationConvention.INSTANCE,
            { AxonMessageDispatcherContext(message, operationName) },
            observationRegistry
        )

    private fun handlerObservation(
        message: Message<*>,
        operationName: String
    ): Observation =
        AxonHandlerObservation.HANDLER_OBSERVATION.observation(
            null,
            AxonHandlerObservation.DefaultAxonHandlerObservationConvention.INSTANCE,
            { AxonMessageHandlerContext(message, operationName) },
            observationRegistry
        )

    private fun internalObservation(
        operationName: String,
        payloadName: String? = null
    ): Observation =
        AxonInternalObservation.INTERNAL_OBSERVATION.observation(
            null,
            AxonInternalObservation.DefaultAxonInternalObservationConvention.INSTANCE,
            { AxonMessageInternalContext(operationName, payloadName) },
            observationRegistry
        )
}