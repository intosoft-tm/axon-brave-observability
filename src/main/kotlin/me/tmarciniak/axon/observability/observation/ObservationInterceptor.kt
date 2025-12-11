package me.tmarciniak.axon.observability.observation

import io.micrometer.observation.ObservationRegistry
import io.micrometer.observation.contextpropagation.ObservationThreadLocalAccessor
import org.axonframework.messaging.InterceptorChain
import org.axonframework.messaging.Message
import org.axonframework.messaging.MessageDispatchInterceptor
import org.axonframework.messaging.MessageHandlerInterceptor
import org.axonframework.messaging.unitofwork.UnitOfWork
import reactor.core.publisher.Flux
import java.util.function.BiFunction

/**
 * @author Tomasz Marciniak
 */
class ObservationInterceptor<T : Message<*>>(
    private val observationRegistry: ObservationRegistry
) : MessageDispatchInterceptor<T>,
    MessageHandlerInterceptor<T> {
    override fun handle(messages: List<T>) = BiFunction<Int, T, T> { _, message -> message }

    @Throws(Exception::class)
    override fun handle(
        unitOfWork: UnitOfWork<out T>,
        interceptorChain: InterceptorChain
    ): Any = enrichResultWithObservationIfReturnedResultIsFlux(interceptorChain.proceed())

    private fun enrichResultWithObservationIfReturnedResultIsFlux(returnResult: Any): Any =
        (returnResult as? Flux<*>)?.let {
            observationRegistry.currentObservation?.let {
                returnResult.contextWrite { context -> context.put(ObservationThreadLocalAccessor.KEY, it) }
            }
        } ?: returnResult
}