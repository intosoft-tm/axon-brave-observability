package me.tmarciniak.axon.observability.observation.handler

import io.micrometer.common.KeyValues
import io.micrometer.common.docs.KeyName
import io.micrometer.observation.docs.ObservationDocumentation
import me.tmarciniak.axon.observability.observation.ContextualNameConverter

/**
 * @author Tomasz Marciniak
 */
enum class AxonHandlerObservation : ObservationDocumentation {
    HANDLER_OBSERVATION {
        override fun getDefaultConvention() = DefaultAxonHandlerObservationConvention::class.java

        override fun getPrefix() = "reactor.axon.handler"

        override fun getLowCardinalityKeyNames() = ListenerLowCardinalityTags.entries.toTypedArray()
    };

    enum class ListenerLowCardinalityTags : KeyName {
        HANDLER_PAYLOAD {
            override fun asString() = "spring.axon.handler.payload"
        },

        HANDLER_OPERATION {
            override fun asString() = "reactor.axon.handler.operation"
        }
    }

    class DefaultAxonHandlerObservationConvention : AxonHandlerObservationConvention {
        override fun getLowCardinalityKeyValues(context: AxonMessageHandlerContext): KeyValues =
            KeyValues.of(
                ListenerLowCardinalityTags.HANDLER_PAYLOAD.asString(),
                context.payload,
                ListenerLowCardinalityTags.HANDLER_OPERATION.asString(),
                context.operationName
            )

        override fun getContextualName(context: AxonMessageHandlerContext) =
            ContextualNameConverter.camelAndDotToSpaceSeparated(context.operationName)

        override fun getName() = "spring.axon.handler"

        companion object {
            val INSTANCE = DefaultAxonHandlerObservationConvention()
        }
    }
}