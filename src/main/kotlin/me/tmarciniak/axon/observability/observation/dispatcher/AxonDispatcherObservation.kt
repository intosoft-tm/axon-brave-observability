package me.tmarciniak.axon.observability.observation.dispatcher

import io.micrometer.common.KeyValues
import io.micrometer.common.docs.KeyName
import io.micrometer.observation.docs.ObservationDocumentation
import me.tmarciniak.axon.observability.observation.ContextualNameConverter

/**
 * @author Tomasz Marciniak
 */
enum class AxonDispatcherObservation : ObservationDocumentation {
    DISPATCHER_OBSERVATION {
        override fun getDefaultConvention() = DefaultAxonDispatcherObservationConvention::class.java

        override fun getPrefix() = "reactor.axon.dispatcher"

        override fun getLowCardinalityKeyNames() = SenderLowCardinalityTags.entries.toTypedArray()
    };

    enum class SenderLowCardinalityTags : KeyName {
        DISPATCHER_PAYLOAD {
            override fun asString() = "reactor.axon.dispatcher.payload"
        },

        DISPATCHER_OPERATION {
            override fun asString() = "reactor.axon.dispatcher.operation"
        }
    }

    class DefaultAxonDispatcherObservationConvention : AxonDispatcherObservationConvention {
        override fun getLowCardinalityKeyValues(context: AxonMessageDispatcherContext): KeyValues =
            KeyValues.of(
                SenderLowCardinalityTags.DISPATCHER_PAYLOAD.withValue(context.payload),
                SenderLowCardinalityTags.DISPATCHER_OPERATION.withValue(context.operationName)
            )

        override fun getContextualName(context: AxonMessageDispatcherContext) =
            ContextualNameConverter.camelAndDotToSpaceSeparated(context.operationName)

        override fun getName(): String = "spring.axon.dispatcher"

        companion object {
            /**
             * A singleton instance of the convention.
             */
            val INSTANCE = DefaultAxonDispatcherObservationConvention()
        }
    }
}