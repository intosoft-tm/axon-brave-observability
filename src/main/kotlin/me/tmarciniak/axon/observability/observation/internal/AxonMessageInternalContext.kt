package me.tmarciniak.axon.observability.observation.internal

import io.micrometer.observation.Observation

/**
 * @author Tomasz Marciniak
 */
class AxonMessageInternalContext(val operationName: String, val payloadName: String?) :
    Observation.Context()