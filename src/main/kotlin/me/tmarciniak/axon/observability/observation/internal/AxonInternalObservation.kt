package me.tmarciniak.axon.observability.observation.internal

import io.micrometer.common.KeyValues
import io.micrometer.common.docs.KeyName
import io.micrometer.observation.docs.ObservationDocumentation
import me.tmarciniak.axon.observability.observation.ContextualNameConverter

/**
 * @author Tomasz Marciniak
 */
enum class AxonInternalObservation : ObservationDocumentation {
    INTERNAL_OBSERVATION {
        override fun getDefaultConvention() = DefaultAxonInternalObservationConvention::class.java

        override fun getPrefix() = "reactor.axon.internal"

        override fun getLowCardinalityKeyNames() = SenderLowCardinalityTags.entries.toTypedArray()
    };

    enum class SenderLowCardinalityTags : KeyName {
        INTERNAL_PAYLOAD {
            override fun asString() = "spring.axon.handler.payload"
        },

        INTERNAL_OPERATION {
            override fun asString() = "reactor.axon.internal.operation"
        }
    }

    class DefaultAxonInternalObservationConvention : AxonInternalObservationConvention {
        override fun getLowCardinalityKeyValues(context: AxonMessageInternalContext): KeyValues =
            KeyValues.of(SenderLowCardinalityTags.INTERNAL_OPERATION.withValue(context.operationName))
                .and(context.payloadName?.let {
                    SenderLowCardinalityTags.INTERNAL_PAYLOAD.withValue(context.payloadName)
                })

        override fun getContextualName(context: AxonMessageInternalContext) =
            ContextualNameConverter.camelAndDotToSpaceSeparated(context.operationName)

        override fun getName(): String = "spring.axon.internal"

        companion object {
            /**
             * A singleton instance of the convention.
             */
            val INSTANCE = DefaultAxonInternalObservationConvention()
        }
    }
}