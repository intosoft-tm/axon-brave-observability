package me.tmarciniak.axon.observability

import io.micrometer.observation.Observation
import mu.KotlinLogging
import org.axonframework.tracing.Span
import reactor.core.publisher.Mono
import java.util.concurrent.Callable
import java.util.function.Consumer
import java.util.function.Supplier

class BraveSpan(private val observation: Observation) : Span {
    private val log = KotlinLogging.logger {}

    override fun start(): Span {
        observation.start()
        return this
    }

    override fun wrapRunnable(runnable: Runnable): Runnable {
        return observation.wrap(runnable)
    }

    override fun <T : Any?> wrapCallable(callable: Callable<T>): Callable<T> {
        try {
            observation.wrap(Supplier { callable.call() })
        } catch (e: Exception) {
            recordException(e)
            throw e
        }
        return callable
    }

    override fun <T : Any?> wrapSupplier(supplier: Supplier<T>): Supplier<T> {
        return super.wrapSupplier(supplier)
    }

    override fun <T : Any?> runConsumer(
        supplier: Consumer<T>,
        consumedObject: T,
    ) {
        try {
            observation.observe(Supplier { supplier })
        } catch (e: Exception) {
            recordException(e)
            throw e
        }
    }

    override fun <T : Any?> wrapConsumer(supplier: Consumer<T>): Consumer<T> {
        try {
            observation.wrap(Supplier { supplier })
        } catch (e: Exception) {
            recordException(e)
            throw e
        }
        return supplier
    }

    override fun <T : Any?> runSupplier(supplier: Supplier<T>): T? {
        start()
        try {
            return observation.observe(Supplier { supplier.get() })
        } catch (e: java.lang.Exception) {
            recordException(e)
            throw e
        } finally {
            end()
        }
    }

    @Throws(java.lang.Exception::class)
    override fun <T> runCallable(callable: Callable<T>): T? {
        return try {
            observation.observe(Supplier { callable.call() })
        } catch (e: java.lang.Exception) {
            recordException(e)
            throw e
        }
    }

    override fun run(runnable: Runnable) {
        observation.observe { Mono.fromRunnable<Unit>(runnable).subscribe() }
    }

    override fun end() {
        observation.stop()
    }

    override fun recordException(throwable: Throwable): Span {
        log.error("Span exception", throwable)
        return this
    }
}
