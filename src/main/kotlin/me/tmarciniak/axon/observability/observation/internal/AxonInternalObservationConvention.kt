package me.tmarciniak.axon.observability.observation.internal

import io.micrometer.observation.Observation
import io.micrometer.observation.ObservationConvention

/**
 * @author Tomasz Marciniak
 */
interface AxonInternalObservationConvention : ObservationConvention<AxonMessageInternalContext> {
    override fun supportsContext(context: Observation.Context) = context is AxonMessageInternalContext

    override fun getName() = "spring.axon.internal"
}