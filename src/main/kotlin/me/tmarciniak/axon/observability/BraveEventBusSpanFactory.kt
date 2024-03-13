package me.tmarciniak.axon.observability

import io.micrometer.observation.Observation
import io.micrometer.observation.ObservationRegistry
import org.axonframework.eventhandling.EventBusSpanFactory
import org.axonframework.eventhandling.EventMessage
import org.axonframework.tracing.Span

class BraveEventBusSpanFactory(
    private val observationRegistry: ObservationRegistry,
) : EventBusSpanFactory {
    override fun createPublishEventSpan(eventMessage: EventMessage<*>): Span =
        BraveSpan(
            Observation.createNotStarted("axon.publish.event", observationRegistry)
                .parentObservation(observationRegistry.currentObservation!!),
        )

    override fun createCommitEventsSpan(): Span =
        BraveSpan(
            Observation.createNotStarted(
                "createCommitEventsSpan",
                observationRegistry,
            ).parentObservation(observationRegistry.currentObservation),
        )

    override fun <T : Any?> propagateContext(eventMessage: EventMessage<T>): EventMessage<T> {
        return mutableMapOf<String, Any>().let {
            observation(it, eventMessage.identifier).start()
            eventMessage.withMetaData(it)
        }
    }

    private fun observation(
        mutableMap: MutableMap<String, Any>,
        name: String,
    ): Observation {
        return AxonSenderObservation.TEMPLATE_OBSERVATION.observation(
            null,
            AxonSenderObservation.DefaultAxonCommandObservationConvention.INSTANCE,
            {
                val axonMessageMapSenderContext = AxonMessageSenderContext(mutableMap, name)
                axonMessageMapSenderContext.remoteServiceName = "axon"
                axonMessageMapSenderContext
            },
            observationRegistry,
        )
    }
}
