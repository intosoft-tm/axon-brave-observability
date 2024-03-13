package me.tmarciniak.axon.observability

import io.micrometer.observation.Observation
import mu.KotlinLogging
import org.axonframework.tracing.Span
import org.axonframework.tracing.SpanScope

private val log = KotlinLogging.logger {}

/**
 * In Micrometer Observability the observation is equivalent of tracing span.
 *
 * https://github.com/micrometer-metrics/micrometer/wiki/Migrating-to-new-1.10.0-Observation-API#you-need-to-copy-sleuths-code-to-your-project-and-rewrite-the-sleuths-tracer-api-to-micrometers-observation-api
 *
 * @author Tomasz Marciniak
 */
class BraveSpan(private val observation: Observation) : Span {
    override fun start() = also { observation.start() }

    override fun makeCurrent(): SpanScope = observation.openScope().let { return SpanScope { it.close() } }

    override fun end() = let { observation.stop() }

    override fun recordException(throwable: Throwable) = also { log.error(throwable) { "Span exception!" } }
}