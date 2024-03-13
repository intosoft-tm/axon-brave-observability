package me.tmarciniak.axon.observability.observation.handler

import io.micrometer.observation.Observation
import io.micrometer.observation.ObservationConvention

/**
 * @author Tomasz Marciniak
 */
interface AxonHandlerObservationConvention : ObservationConvention<AxonMessageHandlerContext> {
    override fun supportsContext(context: Observation.Context) = context is AxonMessageHandlerContext

    override fun getName() = "spring.axon.handler"
}