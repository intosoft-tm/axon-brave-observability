package me.tmarciniak.axon.observability.configuration

import io.micrometer.observation.ObservationRegistry
import me.tmarciniak.axon.observability.BraveSpanFactory
import me.tmarciniak.axon.observability.observation.ObservationInterceptor
import org.axonframework.config.ConfigurerModule
import org.axonframework.lifecycle.Phase
import org.axonframework.messaging.Message
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type
import org.springframework.context.annotation.Bean

/**
 * @author Tomasz Marciniak
 *
 * Registers ObservationInterceptor which allows to track streaming queries in Axon
 */
@AutoConfiguration
class AxonObservabilityAutoConfiguration(
    private val observationRegistry: ObservationRegistry
) {
    @Bean
    fun braveSpanFactory() = BraveSpanFactory(observationRegistry)

    @Bean
    @ConditionalOnWebApplication(type = Type.REACTIVE)
    fun axonObservabilityConfigurerModule() =
        ConfigurerModule {
            it.onInitialize { config ->
                config.onStart(
                    Phase.INSTRUCTION_COMPONENTS,
                    Runnable {
                        val observationInterceptor = ObservationInterceptor<Message<*>>(observationRegistry)
                        val queryBus = config.queryBus()
                        queryBus.registerDispatchInterceptor(observationInterceptor)
                        queryBus.registerHandlerInterceptor(observationInterceptor)
                    }
                )
            }
        }
}