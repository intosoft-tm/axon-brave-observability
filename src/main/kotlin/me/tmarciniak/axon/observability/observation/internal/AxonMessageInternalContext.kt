package me.tmarciniak.axon.observability.observation.internal

import io.micrometer.observation.Observation
import io.micrometer.observation.ObservationView

/**
 * @author Tomasz Marciniak
 */
class AxonMessageInternalContext(
    val payloadName: String?,
    val operationName: String,
    private val isRootTrace: Boolean
) : Observation.Context() {
    override fun getParentObservation(): ObservationView? = if (isRootTrace) null else super.getParentObservation()
}