package me.tmarciniak.axon.observability

import io.micrometer.observation.Observation
import io.micrometer.observation.ObservationConvention

interface AxonReceiverObservationConvention : ObservationConvention<AxonMessageReceiverContext> {
    override fun supportsContext(context: Observation.Context): Boolean {
        return context is AxonMessageReceiverContext
    }

    override fun getName(): String? {
        return "spring.axon.receiver"
    }
}
