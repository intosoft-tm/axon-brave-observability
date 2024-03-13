package me.tmarciniak.axon.observability

import io.micrometer.common.KeyValues
import io.micrometer.common.docs.KeyName
import io.micrometer.observation.Observation
import io.micrometer.observation.ObservationConvention
import io.micrometer.observation.docs.ObservationDocumentation

enum class AxonSenderObservation : ObservationDocumentation {
    TEMPLATE_OBSERVATION {
        override fun getDefaultConvention(): Class<out ObservationConvention<out Observation.Context>> {
            return DefaultAxonCommandObservationConvention::class.java
        }

        override fun getPrefix(): String = "spring.axon.command"

        override fun getLowCardinalityKeyNames(): Array<KeyName> {
            return TemplateLowCardinalityTags.entries.toTypedArray()
        }
    }, ;

    enum class TemplateLowCardinalityTags : KeyName {
        BEAN_NAME {
            override fun asString(): String = "spring.axon.name"
        },
    }

    class DefaultAxonCommandObservationConvention : AxonSenderObservationConvention {
        override fun getLowCardinalityKeyValues(context: AxonMessageSenderContext): KeyValues {
            return KeyValues.of(
                TemplateLowCardinalityTags.BEAN_NAME.asString(),
                context.commandName,
            )
        }

        override fun getContextualName(context: AxonMessageSenderContext): String = context.destination + " send"

        override fun getName(): String = "spring.axon.sender"

        companion object {
            /**
             * A singleton instance of the convention.
             */
            val INSTANCE = DefaultAxonCommandObservationConvention()
        }
    }
}
