package me.tmarciniak.axon.observability.observation.dispatcher

import io.micrometer.observation.Observation
import io.micrometer.observation.ObservationConvention

/**
 * @author Tomasz Marciniak
 */
interface AxonDispatcherObservationConvention : ObservationConvention<AxonMessageDispatcherContext> {
    override fun supportsContext(context: Observation.Context) = context is AxonMessageDispatcherContext

    override fun getName(): String = "spring.axon.dispatcher"
}