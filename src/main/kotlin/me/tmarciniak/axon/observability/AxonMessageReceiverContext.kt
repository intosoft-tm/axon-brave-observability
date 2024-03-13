package me.tmarciniak.axon.observability

import io.micrometer.observation.transport.Propagator
import io.micrometer.observation.transport.ReceiverContext
import org.axonframework.messaging.Message

class AxonMessageReceiverContext(message: Message<*>) :
    ReceiverContext<Message<*>>(
        Propagator.Getter { carrier: Message<*>, key: String ->
            carrier.metaData[key] as String?
        },
    ) {
    val record: Message<*>

    init {
        carrier = message
        record = message

        remoteServiceName = "axon"
    }

    val source: String get() = record.payloadType.getName()
}
