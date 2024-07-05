package me.tmarciniak.axon.observability.configuration

import io.micrometer.observation.ObservationRegistry
import me.tmarciniak.axon.observability.BraveSpanFactory
import me.tmarciniak.axon.observability.ObservationInterceptor
import org.axonframework.config.ConfigurerModule
import org.axonframework.lifecycle.Phase
import org.axonframework.messaging.Message
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type
import org.springframework.context.annotation.Bean

/**
 * @author Tomasz Marciniak
 */
@AutoConfiguration
class AxonObservabilityAutoConfiguration(
    private val observationRegistry: ObservationRegistry
) {
    @Bean
    fun braveSpanFactory() = BraveSpanFactory(observationRegistry)

    @Bean
    @ConditionalOnWebApplication(type = Type.REACTIVE)
    fun observationInterceptor() = ObservationInterceptor<Message<*>>(observationRegistry)

    @Bean
    fun axonObservabilityConfigurerModule(observationInterceptor: ObservationInterceptor<Message<*>>) =
        ConfigurerModule {
            it.onInitialize { config ->
                config.onStart(
                    Phase.INSTRUCTION_COMPONENTS,
                    Runnable {
                        val commandBus = config.commandBus()

                        commandBus.registerHandlerInterceptor(observationInterceptor)
                        commandBus.registerDispatchInterceptor(observationInterceptor)

                        val eventBus = config.eventBus()
                        eventBus.registerDispatchInterceptor(observationInterceptor)

                        val queryBus = config.queryBus()
                        queryBus.registerDispatchInterceptor(observationInterceptor)
                        queryBus.registerHandlerInterceptor(observationInterceptor)
                    }
                )
            }
        }
}