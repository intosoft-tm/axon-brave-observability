package me.tmarciniak.axon.observability.observation.handler

import io.micrometer.observation.transport.Propagator
import io.micrometer.observation.transport.ReceiverContext
import org.axonframework.messaging.Message

/**
 * @author Tomasz Marciniak
 */
class AxonMessageHandlerContext(message: Message<*>, val operationName: String) :
    ReceiverContext<Message<*>>(
        Propagator.Getter { carrier: Message<*>, key: String ->
            carrier.metaData[key] as String?
        }
    ) {
    val payload: String

    init {
        carrier = message
        this.payload = message.payloadType.name
        remoteServiceName = "axon"
    }
}