package me.tmarciniak.axon.observability

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.micrometer.observation.Observation
import io.micrometer.observation.ObservationRegistry
import io.mockk.spyk
import io.mockk.verify

class BraveSpanTest :
    BehaviorSpec({

        isolationMode = IsolationMode.InstancePerLeaf

        context("observation registry is available") {
            val observationRegistry = ObservationRegistry.create()

            given("observation is created") {
                val observation = spyk(Observation.createNotStarted("sample-observation", observationRegistry))

                `when`("span is started") {
                    BraveSpan(observation)
                        .start()

                    then("it starts observation but does not make it current") {
                        verify(exactly = 1) { observation.start() }
                        observationRegistry.currentObservation.shouldBeNull()
                    }
                }

                `when`("span is started and made active") {
                    BraveSpan(observation)
                        .start()
                        .makeCurrent()

                    then("it starts observation and makes it current") {
                        verify(exactly = 1) { observation.start() }
                        observationRegistry.currentObservation.shouldNotBeNull()
                    }
                }

                `when`("span is started and ended") {
                    BraveSpan(observation)
                        .start()
                        .end()

                    then("it stops observation but does not close the scope") {
                        verify(exactly = 1) { observation.stop() }
                        observationRegistry.currentObservation!!.openScope().shouldNotBeNull()
                    }
                }

                `when`("span is started, made active and ended") {
                    BraveSpan(observation)
                        .start()
                        .also { it.makeCurrent() }
                        .also { it.end() }

                    then("it ends span event when spans are still current") {
                        verify(exactly = 1) { observation.stop() }
                    }
                }
                `when`("span is started and exception is recorded") {
                    val exception = IllegalArgumentException("This is my exception message")

                    BraveSpan(observation)
                        .start()
                        .recordException(exception)

                    then("records exceptions on observation") {
                        verify(exactly = 1) { observation.error(exception) }
                    }
                }
            }
        }
    })