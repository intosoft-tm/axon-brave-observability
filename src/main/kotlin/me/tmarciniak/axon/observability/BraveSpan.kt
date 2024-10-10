package me.tmarciniak.axon.observability

import io.micrometer.observation.Observation
import org.axonframework.tracing.Span
import org.axonframework.tracing.SpanScope

/**
 * In Micrometer Observability the observation is equivalent to tracing span.
 *
 * A wrapper class that adapts Micrometer's Observation to Axon's Span interface.
 * This class provides tracing functionality by delegating operations to a Micrometer Observation.
 *
 * https://github.com/micrometer-metrics/micrometer/wiki/Migrating-to-new-1.10.0-Observation-API#you-need-to-copy-sleuths-code-to-your-project-and-rewrite-the-sleuths-tracer-api-to-micrometers-observation-api
 *
 * @author Tomasz Marciniak
 */
class BraveSpan(
    private val observation: Observation
) : Span {
    /**
     * Starts the span by starting the underlying observation.
     * @return this instance for method chaining
     */
    override fun start(): BraveSpan {
        observation.start()
        return this
    }

    /**
     * Creates a scope for this span, making it the current active span.
     * The scope should be closed when no longer needed.
     * @return a SpanScope that can be used in a 'use' block
     */
    override fun makeCurrent(): SpanScope {
        val scope = observation.openScope()
        return SpanScope {
            scope.close()
        }
    }

    /**
     * Ends the span by stopping the underlying observation.
     *
     * It's important to note that this method should only be called after any associated
     * scope has been closed. Failing to close the scope before ending the span may result
     * in incorrect tracing behavior.
     */
    override fun end() {
        observation.stop()
    }

    /**
     * Records an exception that occurred during the span's lifetime.
     * @param throwable the exception to record
     * @return this instance for method chaining
     */
    override fun recordException(throwable: Throwable): BraveSpan {
        observation.error(throwable)
        return this
    }
}