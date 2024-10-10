package me.tmarciniak.axon.observability

import io.micrometer.observation.Observation
import io.micrometer.observation.ObservationRegistry
import me.tmarciniak.axon.observability.observation.dispatcher.AxonDispatcherObservation.DISPATCHER_OBSERVATION
import me.tmarciniak.axon.observability.observation.dispatcher.AxonDispatcherObservation.DefaultAxonDispatcherObservationConvention
import me.tmarciniak.axon.observability.observation.dispatcher.AxonMessageDispatcherContext
import me.tmarciniak.axon.observability.observation.handler.AxonHandlerObservation.DefaultAxonHandlerObservationConvention
import me.tmarciniak.axon.observability.observation.handler.AxonHandlerObservation.HANDLER_OBSERVATION
import me.tmarciniak.axon.observability.observation.handler.AxonMessageHandlerContext
import me.tmarciniak.axon.observability.observation.internal.AxonInternalObservation
import me.tmarciniak.axon.observability.observation.internal.AxonInternalObservation.INTERNAL_OBSERVATION
import me.tmarciniak.axon.observability.observation.internal.AxonMessageInternalContext
import org.axonframework.messaging.Message
import org.axonframework.tracing.SpanAttributesProvider
import org.axonframework.tracing.SpanFactory
import java.util.function.Supplier

/**
 * Implementation of AxonFramework's SpanFactory that creates spans using Micrometer's Observation API.
 * The spans are wrapped using [BraveSpan] which adapts the Observation to Axon's Span interface.
 *
 * @property observationRegistry registry used to create and manage observations/spans
 *
 * @author Tomasz Marciniak
 */
class BraveSpanFactory(
    private val observationRegistry: ObservationRegistry
) : SpanFactory {
    private val spanAttributesProviders = mutableListOf<SpanAttributesProvider>()

    /**
     * Creates a root trace span with the given operation name.
     */
    override fun createRootTrace(operationNameSupplier: Supplier<String>): BraveSpan =
        BraveSpan(createInternalObservation(operationName = operationNameSupplier.get(), isRootTrace = true))

    /**
     * Creates a handler span that processes the given message.
     */
    override fun createHandlerSpan(
        operationNameSupplier: Supplier<String>,
        parentMessage: Message<*>,
        isChildTrace: Boolean,
        vararg linkedParents: Message<*>
    ): BraveSpan {
        val observation =
            createHandlerObservation(
                message = parentMessage,
                operationName = operationNameSupplier.get()
            )
        addMessageAttributes(observation = observation, message = parentMessage)
        return BraveSpan(observation)
    }

    /**
     * Creates a dispatch span for sending the given message.
     */
    override fun createDispatchSpan(
        operationNameSupplier: Supplier<String>,
        parentMessage: Message<*>,
        vararg linkedSiblings: Message<*>
    ): BraveSpan {
        val observation =
            createDispatcherObservation(
                operationName = operationNameSupplier.get(),
                payloadType = parentMessage.payloadType.name
            )
        addMessageAttributes(observation = observation, message = parentMessage)
        return BraveSpan(observation)
    }

    /**
     * Creates an internal span with the given operation name.
     */
    override fun createInternalSpan(operationNameSupplier: Supplier<String>): BraveSpan =
        BraveSpan(createInternalObservation(operationName = operationNameSupplier.get()))

    /**
     * Creates an internal span for the given message.
     */
    override fun createInternalSpan(
        operationNameSupplier: Supplier<String>,
        message: Message<*>
    ): BraveSpan {
        val observation =
            createInternalObservation(
                payloadName = message.payloadType.name,
                operationName = operationNameSupplier.get()
            )
        addMessageAttributes(observation = observation, message = message)
        return BraveSpan(observation)
    }

    /**
     * Propagates the current trace context to the given message by copying it to the message metadata.
     */
    override fun <M : Message<*>> propagateContext(message: M): M {
        val carrier = getAxonMessageDispatcherContextCarrier()
        val messageWithMetadata = addMetadata(carrier, message)
        return castToMessage(messageWithMetadata, message)
    }

    /**
     * Registers a provider that can add custom attributes to spans.
     */
    override fun registerSpanAttributeProvider(provider: SpanAttributesProvider) {
        spanAttributesProviders.add(provider)
    }

    private fun getAxonMessageDispatcherContextCarrier(): MutableMap<String, Any>? {
        val currentObservation = observationRegistry.currentObservation
        if (currentObservation != null) {
            val context = currentObservation.context
            if (context is AxonMessageDispatcherContext) {
                return context.carrier
            }
        }
        return null
    }

    private fun addMessageAttributes(
        observation: Observation,
        message: Message<*>?
    ) {
        if (message != null) {
            addAttributes(message, observation)
        }
    }

    private fun addAttributes(
        message: Message<*>,
        observation: Observation
    ) {
        for (provider in spanAttributesProviders) {
            val attributes = provider.provideForMessage(message)
            for (attribute in attributes) {
                observation.lowCardinalityKeyValue(attribute.key, attribute.value)
            }
        }
    }

    private fun createDispatcherObservation(
        operationName: String,
        payloadType: String
    ): Observation =
        DISPATCHER_OBSERVATION.observation(
            null,
            DefaultAxonDispatcherObservationConvention.INSTANCE,
            { AxonMessageDispatcherContext(payloadType, operationName) },
            observationRegistry
        )

    private fun createHandlerObservation(
        message: Message<*>,
        operationName: String
    ): Observation =
        HANDLER_OBSERVATION.observation(
            null,
            DefaultAxonHandlerObservationConvention.INSTANCE,
            { AxonMessageHandlerContext(message, operationName) },
            observationRegistry
        )

    private fun createInternalObservation(
        payloadName: String? = null,
        operationName: String,
        isRootTrace: Boolean = false
    ): Observation =
        INTERNAL_OBSERVATION.observation(
            null,
            AxonInternalObservation.DefaultAxonInternalObservationConvention.INSTANCE,
            { AxonMessageInternalContext(payloadName, operationName, isRootTrace) },
            observationRegistry
        )
}

private fun <M : Message<*>> castToMessage(
    messageToConvert: Message<out Any>?,
    originalMessage: M
): M {
    if (messageToConvert == null) {
        return originalMessage
    }
    return originalMessage.javaClass.cast(messageToConvert)
}

private fun addMetadata(
    carrier: MutableMap<String, *>?,
    message: Message<*>
): Message<out Any>? {
    if (carrier == null) {
        return null
    }
    return message.andMetaData(carrier)
}