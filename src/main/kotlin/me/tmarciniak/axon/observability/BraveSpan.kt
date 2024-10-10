package me.tmarciniak.axon.observability

import io.micrometer.observation.Observation
import org.axonframework.tracing.Span
import org.axonframework.tracing.SpanScope

/**
 * In Micrometer Observability the observation is equivalent to tracing span.
 *
 * https://github.com/micrometer-metrics/micrometer/wiki/Migrating-to-new-1.10.0-Observation-API#you-need-to-copy-sleuths-code-to-your-project-and-rewrite-the-sleuths-tracer-api-to-micrometers-observation-api
 *
 * @author Tomasz Marciniak
 */
class BraveSpan(private val observation: Observation) : Span {
    override fun start() = also { observation.start() }

    override fun makeCurrent(): SpanScope = observation.openScope().let { return SpanScope { it.close() } }

    override fun end() = let { observation.stop() }

    override fun recordException(throwable: Throwable) = also { observation.error(throwable) }
}