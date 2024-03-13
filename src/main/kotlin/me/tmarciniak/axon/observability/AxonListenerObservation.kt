package me.tmarciniak.axon.observability

import io.micrometer.common.KeyValues
import io.micrometer.common.docs.KeyName
import io.micrometer.observation.Observation
import io.micrometer.observation.ObservationConvention
import io.micrometer.observation.docs.ObservationDocumentation

enum class AxonListenerObservation : ObservationDocumentation {
    LISTENER_OBSERVATION {
        override fun getDefaultConvention(): Class<out ObservationConvention<out Observation.Context>> {
            return DefaultAxonReceiverObservationConvention::class.java
        }

        override fun getPrefix(): String = "spring.axon.receiver"

        override fun getLowCardinalityKeyNames(): Array<KeyName> {
            return ListenerLowCardinalityTags.entries.toTypedArray()
        }
    }, ;

    enum class ListenerLowCardinalityTags : KeyName {
        LISTENER_ID {
            override fun asString(): String = "spring.axon.receiver.id"
        },
    }

    class DefaultAxonReceiverObservationConvention : AxonReceiverObservationConvention {
        override fun getLowCardinalityKeyValues(context: AxonMessageReceiverContext): KeyValues {
            return KeyValues.of(
                ListenerLowCardinalityTags.LISTENER_ID.asString(),
                context.source,
            )
        }

        override fun getContextualName(context: AxonMessageReceiverContext): String = context.source + " receive"

        override fun getName(): String = "spring.axon.receiver"

        companion object {
            val INSTANCE = DefaultAxonReceiverObservationConvention()
        }
    }
}
