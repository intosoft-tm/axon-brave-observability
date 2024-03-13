package me.tmarciniak.axon.observability

import io.micrometer.observation.Observation
import io.micrometer.observation.ObservationConvention

interface AxonSenderObservationConvention : ObservationConvention<AxonMessageSenderContext> {
    override fun supportsContext(context: Observation.Context): Boolean = context is AxonMessageSenderContext

    override fun getName(): String = "spring.axon.sender"
}
