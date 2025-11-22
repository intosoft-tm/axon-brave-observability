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
class BraveSpan(
    private val observation: Observation
) : Span {
    override fun start(): BraveSpan {
        observation.start()
        return this
    }

    override fun makeCurrent(): SpanScope {
        val scope = observation.openScope()
        return SpanScope {
            scope.close()
        }
    }

    override fun end() {
        observation.stop()
    }

    override fun recordException(throwable: Throwable): BraveSpan {
        observation.error(throwable)
        return this
    }
}