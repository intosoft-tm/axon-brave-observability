package me.tmarciniak.axon.observability

import io.micrometer.observation.Observation
import io.micrometer.observation.ObservationRegistry
import org.axonframework.messaging.Message
import org.axonframework.tracing.Span
import org.axonframework.tracing.SpanAttributesProvider
import org.axonframework.tracing.SpanFactory
import java.util.function.Supplier

class BraveSpanFactory(
    private val observationRegistry: ObservationRegistry,
) : SpanFactory {
    private val spanAttributesProviders: MutableList<SpanAttributesProvider> = mutableListOf()

    override fun createRootTrace(operationNameSupplier: Supplier<String>): Span =
        BraveSpan(
            Observation.createNotStarted(
                operationNameSupplier.get(),
                observationRegistry,
            ).parentObservation(observationRegistry.currentObservation),
        )

    override fun createHandlerSpan(
        operationNameSupplier: Supplier<String>,
        parentMessage: Message<*>,
        isChildTrace: Boolean,
        vararg linkedParents: Message<*>,
    ): Span = BraveSpan(observation(parentMessage).parentObservation(observationRegistry.currentObservation))

    override fun createDispatchSpan(
        operationNameSupplier: Supplier<String>,
        parentMessage: Message<*>,
        vararg linkedSiblings: Message<*>,
    ): Span =
        BraveSpan(
            Observation.createNotStarted("axon.dispatch", observationRegistry)
                .parentObservation(observationRegistry.currentObservation),
        )

    override fun createInternalSpan(operationNameSupplier: Supplier<String>): Span =
        BraveSpan(Observation.createNotStarted(operationNameSupplier.get(), observationRegistry))

    override fun createInternalSpan(
        operationNameSupplier: Supplier<String>,
        message: Message<*>,
    ): Span = BraveSpan(observation(message).parentObservation(observationRegistry.currentObservation))

    @Suppress("UNCHECKED_CAST")
    override fun <M : Message<*>> propagateContext(message: M): M {
        return mutableMapOf<String, Any>().let {
            observation(it).start()
            message.withMetaData(it) as M
        }
    }

    override fun registerSpanAttributeProvider(provider: SpanAttributesProvider) {
        spanAttributesProviders.add(provider)
    }

    private fun observation(commandMessage: Message<*>): Observation {
        val observation =
            AxonListenerObservation.LISTENER_OBSERVATION.observation(
                null,
                AxonListenerObservation.DefaultAxonReceiverObservationConvention.INSTANCE,
                {
                    val axonMessageReceiverContext = AxonMessageReceiverContext(commandMessage)
                    axonMessageReceiverContext.remoteServiceName = "axon"
                    axonMessageReceiverContext
                },
                observationRegistry,
            )
        return observation
    }

    private fun observation(mutableMap: MutableMap<String, Any>): Observation {
        return AxonSenderObservation.TEMPLATE_OBSERVATION.observation(
            null,
            AxonSenderObservation.DefaultAxonCommandObservationConvention.INSTANCE,
            {
                val axonMessageMapSenderContext = AxonMessageSenderContext(mutableMap, "no command name")
                axonMessageMapSenderContext.remoteServiceName = "axon"
                axonMessageMapSenderContext
            },
            observationRegistry,
        )
    }
}
