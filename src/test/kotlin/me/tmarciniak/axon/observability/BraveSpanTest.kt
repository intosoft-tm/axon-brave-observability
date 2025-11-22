package me.tmarciniak.axon.observability

import io.kotest.core.spec.style.BehaviorSpec
import io.micrometer.observation.Observation
import io.micrometer.observation.tck.TestObservationRegistry
import io.micrometer.observation.tck.TestObservationRegistryAssert
import io.mockk.spyk
import io.mockk.verify
import java.util.UUID

class BraveSpanTest :
    BehaviorSpec({

        context("observation registry is available") {
            val observationRegistry = TestObservationRegistry.create()

            given("observation is created") {

//                `when`("span is started") {
//                    val observation = spyk(Observation.createNotStarted(UUID.randomUUID().toString(), observationRegistry))
//                    BraveSpan(observation)
//                        .start()
//
//                    then("it starts observation but does not make it current") {
//                        verify(exactly = 1) { observation.start() }
//                        TestObservationRegistryAssert.assertThat(observationRegistry).doesNotHaveRemainingCurrentObservationSameAs(observation)
//                    }
//                }

                `when`("span is started and made active") {
                    val observation = spyk(Observation.createNotStarted("span-started-active", observationRegistry))
                    val span = BraveSpan(observation)
                    span.start()
                    span.makeCurrent().use { }

                    then("it starts observation and makes it current") {
                        verify(exactly = 1) { observation.start() }
                        verify(exactly = 1) { observation.openScope() }
                        TestObservationRegistryAssert.assertThat(observationRegistry).hasSingleObservationThat().isSameAs(span)
                    }
                }
//
//                `when`("span is started and ended") {
//                    val observation = spyk(Observation.createNotStarted("span-started-ended", observationRegistry))
//                    BraveSpan(observation)
//                        .start()
//                        .end()
//
//                    then("it stops observation but does not close the scope") {
//                        verify(exactly = 1) { observation.stop() }
//                        TestObservationRegistryAssert.assertThat(observationRegistry).hasSingleObservationThat().isEqualTo(observation)
//                    }
//                }
//
//                `when`("span is started, made active and ended") {
//                    val observation =
//                        spyk(Observation.createNotStarted("span-started-active-ended", observationRegistry))
//                    val span = BraveSpan(observation)
//                    span.start()
//                    span.makeCurrent().use { }
//                    span.end()
//
//                    then("it ends span event when spans are still current") {
//                        TestObservationRegistryAssert.assertThat(observationRegistry).doesNotHaveAnyObservation()
//                    }
//                }
//                `when`("span is started and exception is recorded") {
//                    val observation = spyk(Observation.createNotStarted("span-exception", observationRegistry))
//                    val exception = IllegalArgumentException("This is my exception message")
//
//                    BraveSpan(observation)
//                        .start()
//                        .recordException(exception)
//
//                    then("records exceptions on observation") {
//                        verify(exactly = 1) { observation.error(exception) }
//                    }
//                }
            }
        }
    })