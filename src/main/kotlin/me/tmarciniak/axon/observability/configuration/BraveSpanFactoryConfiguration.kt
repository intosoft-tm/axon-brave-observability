package me.tmarciniak.axon.observability.configuration

import io.micrometer.observation.ObservationRegistry
import me.tmarciniak.axon.observability.BraveEventBusSpanFactory
import me.tmarciniak.axon.observability.BraveSpanFactory
import org.axonframework.eventhandling.EventBusSpanFactory
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@AutoConfiguration
@Configuration
class BraveSpanFactoryConfiguration(
    private val observationRegistry: ObservationRegistry,
) {
    @Bean
    fun braveSpanFactory(): BraveSpanFactory = BraveSpanFactory(observationRegistry)

    @Bean
    fun braveEventSpanFactory(): EventBusSpanFactory {
        return BraveEventBusSpanFactory(observationRegistry)
    }
}
