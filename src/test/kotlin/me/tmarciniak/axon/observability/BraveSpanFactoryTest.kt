package me.tmarciniak.axon.observability

import brave.Tracing
import brave.propagation.B3Propagation
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.equals.shouldBeEqual
import io.micrometer.observation.Observation
import io.micrometer.observation.ObservationRegistry
import io.micrometer.observation.tck.TestObservationRegistry
import io.micrometer.observation.transport.ReceiverContext
import io.micrometer.observation.transport.SenderContext
import io.micrometer.tracing.brave.bridge.BraveCurrentTraceContext
import io.micrometer.tracing.brave.bridge.BravePropagator
import io.micrometer.tracing.brave.bridge.BraveTracer
import io.micrometer.tracing.handler.DefaultTracingObservationHandler
import io.micrometer.tracing.handler.PropagatingReceiverTracingObservationHandler
import io.micrometer.tracing.handler.PropagatingSenderTracingObservationHandler
import io.mockk.every
import io.mockk.mockk
import me.tmarciniak.axon.observability.observation.dispatcher.AxonMessageDispatcherContext
import me.tmarciniak.axon.observability.observation.internal.AxonMessageInternalContext
import org.assertj.core.api.Assertions.assertThat
import org.axonframework.eventhandling.EventMessage
import org.axonframework.eventhandling.GenericEventMessage
import org.axonframework.messaging.Message
import org.axonframework.tracing.SpanAttributesProvider
import java.util.Collections

class BraveSpanFactoryTest : BehaviorSpec(
    {

        isolationMode = IsolationMode.InstancePerLeaf

        context("span factory is available") {
            given("message is created") {
                val observation: Observation = mockk()
                val observationRegistry: ObservationRegistry = mockk()
                val braveSpanFactory = BraveSpanFactory(observationRegistry)

                val message = GenericEventMessage.asEventMessage<Any>("sample-event")

                every {
                    observation.context
                } returns
                    AxonMessageDispatcherContext(message.payloadType.name, "test").also {
                        it.carrier?.set("trace-id", "00000000")
                    }
                every { observationRegistry.currentObservation } returns observation

                `when`("factory propagates context to message") {
                    val messageWithPropagatedContext: EventMessage<Any> = braveSpanFactory.propagateContext(message)

                    then("metadata is injected to the message") {
                        messageWithPropagatedContext.metaData["trace-id"]!!.shouldBeEqual("00000000")
                    }
                }
            }

            given("observation registry is created") {
                val observationRegistry: ObservationRegistry = TestObservationRegistry.create()

                val tracer: Tracing = createTracer()
                val braveTracer = createBraveTracer(tracer)

                observationRegistry.addObservationHandlers(braveTracer, tracer)

                val parentSpan = "44616e69656c2057"
                val traceId = "697320746f74616c207375636b657221-$parentSpan-1"

                val message: Message<*> =
                    GenericEventMessage.asEventMessage<Any>("my-event")
                        .andMetaData(Collections.singletonMap("b3", traceId))

                `when`("handler span and root trace is started and made current") {
                    BraveSpanFactory(observationRegistry)
                        .createChildHandlerSpan({ "my-span" }, message).start().makeCurrent()

                    BraveSpanFactory(observationRegistry)
                        .createRootTrace { "root-trace" }
                        .start()
                        .makeCurrent()

                    then("parent is not set to parent observation and context kind is internal") {
                        assertThat(observationRegistry.currentObservation!!.contextView.parentObservation).isNull()
                        assertThat(
                            observationRegistry.currentObservation!!.context
                        ).isInstanceOf(AxonMessageInternalContext::class.java)
                        assertThat(braveTracer.currentSpan().context().parentId()).isNotEqualTo(parentSpan)
                    }
                }

                `when`("handler span is created, started and made current") {
                    BraveSpanFactory(observationRegistry)
                        .createChildHandlerSpan({ "my-span" }, message).start().makeCurrent()

                    then("parent span is set") {
                        assertThat(observationRegistry.currentObservation!!.contextView.parentObservation).isNotNull()
                        assertThat(braveTracer.currentSpan().context().parentId()).isEqualTo(parentSpan)
                    }
                }

                `when`("linked span is created, started and made current") {
                    BraveSpanFactory(observationRegistry)
                        .createLinkedHandlerSpan({ "my-span" }, message).start().makeCurrent()

                    then("parent span is set") {
                        assertThat(observationRegistry.currentObservation!!.contextView.parentObservation).isNotNull()
                        assertThat(braveTracer.currentSpan().context().parentId()).isEqualTo(parentSpan)
                    }
                }

                `when`("dispatch span is created, started and made current") {
                    val parentObservation = Observation.createNotStarted("my-span", observationRegistry)
                    BraveSpan(parentObservation).start().makeCurrent()
                    val parentTraceId = braveTracer.currentSpan().context().traceId()
                    val parentSpanId = braveTracer.currentSpan().context().spanId()

                    val eventMessage = GenericEventMessage.asEventMessage<Any>("my-event")

                    BraveSpanFactory(observationRegistry)
                        .createDispatchSpan({ "my-span" }, eventMessage).start().makeCurrent()

                    then("parent context is set, parent trace is same as current but spans are different") {
                        assertThat(
                            observationRegistry.currentObservation!!.contextView.parentObservation
                        ).isEqualTo(parentObservation)
                        assertThat(braveTracer.currentSpan().context().traceId()).isEqualTo(parentTraceId)
                        assertThat(braveTracer.currentSpan().context().spanId()).isNotEqualTo(parentSpanId)
                    }
                }
            }

            given("span attribute provider is available") {
                val observationRegistry: ObservationRegistry = TestObservationRegistry.create()
                val tracer: Tracing = createTracer()
                val braveTracer = createBraveTracer(tracer)

                observationRegistry.addObservationHandlers(braveTracer, tracer)

                val spanAttributesProvider: SpanAttributesProvider = mockk()
                val braveSpanFactory = BraveSpanFactory(observationRegistry)

                braveSpanFactory.registerSpanAttributeProvider(spanAttributesProvider)
                every { spanAttributesProvider.provideForMessage(any()) } returns sampleAttributes()

                val message = GenericEventMessage.asEventMessage<Any>("sample-event")

                `when`("create handler span adds attributes") {
                    braveSpanFactory.createLinkedHandlerSpan({ "MyRootTrace" }, message).start().makeCurrent()

                    then("attributes are present") {
                        assertThat(
                            observationRegistry.currentObservation!!.context.getLowCardinalityKeyValue("MyKey")
                        ).isNotNull()
                    }
                }

                `when`("create dispatch span adds attributes") {
                    braveSpanFactory.createDispatchSpan({ "MyRootTrace" }, message).start().makeCurrent()

                    then("attributes are present") {
                        assertThat(
                            observationRegistry.currentObservation!!.context.getLowCardinalityKeyValue("MyKey")
                        ).isNotNull()
                    }
                }

                `when`("create internal span adds attributes") {
                    braveSpanFactory.createInternalSpan({ "MyRootTrace" }, message).start().makeCurrent()

                    then("attributes are present") {
                        assertThat(
                            observationRegistry.currentObservation!!.context.getLowCardinalityKeyValue("MyKey")
                        ).isNotNull()
                    }
                }
            }
        }
    }
) {
    companion object {
        private fun createBraveTracer(tracer: Tracing) =
            BraveTracer(
                tracer.tracer(),
                BraveCurrentTraceContext(tracer.currentTraceContext())
            )

        private fun createTracer(): Tracing =
            Tracing.newBuilder()
                .propagationFactory(
                    B3Propagation.newFactoryBuilder().injectFormat(B3Propagation.Format.SINGLE).build()
                )
                .traceId128Bit(true)
                .build()

        private fun ObservationRegistry.addObservationHandlers(
            braveTracer: BraveTracer,
            tracer: Tracing
        ) {
            this.observationConfig()
                .observationHandler(DefaultTracingObservationHandler(braveTracer))
                .observationHandler(
                    PropagatingReceiverTracingObservationHandler<ReceiverContext<*>>(
                        braveTracer,
                        BravePropagator(tracer)
                    )
                )
                .observationHandler(
                    PropagatingSenderTracingObservationHandler<SenderContext<*>>(braveTracer, BravePropagator(tracer))
                )
        }
    }
}

private fun sampleAttributes(): MutableMap<String, String> = Collections.singletonMap("MyKey", "MyValue")