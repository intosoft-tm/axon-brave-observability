package me.tmarciniak.axon.observability.observation.dispatcher

import io.micrometer.observation.transport.Propagator
import io.micrometer.observation.transport.SenderContext
import org.axonframework.messaging.Message

class AxonMessageDispatcherContext(message: Message<*>, val operationName: String) :
    SenderContext<MutableMap<String, Any>>(
        Propagator.Setter { carrier: MutableMap<String, Any>?, key: String, value: String ->
            carrier?.let { it[key] = value }
        }
    ) {
    val payload: String

    init {
        setCarrier(mutableMapOf())
        this.payload = message.payloadType.name
        remoteServiceName = "axon"
    }
}