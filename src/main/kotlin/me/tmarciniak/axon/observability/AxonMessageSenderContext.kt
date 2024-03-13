package me.tmarciniak.axon.observability

import io.micrometer.observation.transport.Propagator
import io.micrometer.observation.transport.SenderContext

class AxonMessageSenderContext(mutableMap: MutableMap<String, Any>, messageName: String) :
    SenderContext<MutableMap<String, Any>>(
        Propagator.Setter { carrier: MutableMap<String, Any>?, key: String, value: String ->
            carrier!![key] = value
        },
    ) {
    val commandName: String
    private val mutableMap: MutableMap<String, Any>

    init {
        setCarrier(mutableMap)
        this.commandName = messageName
        this.mutableMap = mutableMap
        remoteServiceName = "axon"
    }

    val destination: String get() = commandName
}
