package me.tmarciniak.axon.observability.observation.dispatcher

import io.micrometer.observation.transport.Propagator
import io.micrometer.observation.transport.SenderContext

class AxonMessageDispatcherContext(val operationName: String, val payloadType: String) :
    SenderContext<MutableMap<String, Any>>(
        Propagator.Setter { carrier: MutableMap<String, Any>?, key: String, value: String ->
            carrier?.let { it[key] = value }
        }
    ) {
    init {
        setCarrier(mutableMapOf())
        remoteServiceName = "axon"
    }
}