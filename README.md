axon-brave-observability
==========================

## About The Project

This project provides integration between Axon Framework and Spring Observability using Brave.

Provides implementation (adapter) for org.axonframework.tracing.SpanFactory and org.axonframework.tracing.SpanFactory.

Integrates Axon Framework with Micrometer and Spring Observability to enhance tracing and metrics collection.

## Usage

Add dependency.

Maven:

```
<dependency>
  <groupId>me.tmarciniak</groupId>
  <artifactId>axon-brave-observability</artifactId>
  <version>0.1.0</version>
</dependency>
```

Gradle:
```
implementation 'me.tmarciniak:axon-brave-observability:0.1.0'
```
## How it works

When the Axon Framework handles queries, commands, and events, it uses a SpanFactory to create and manage spans, allowing for distributed tracing. The framework takes responsibility for starting spans, making them the current active span, and stopping them. Additionally, it can record exceptions when needed.

Given that Axon operates with events, commands, and queries, tracing information must be propagated through the metadata of Axon messages (org.axonframework.tracing.SpanFactory.propagateContext).

## Reactive

If your application is using webflux, Spring will discover me.tmarciniak.axon.observability.configuration.AxonObservabilityAutoConfiguration.axonObservabilityConfigurerModule as component so steaming query will also log traces.

## Tips for other integrations

1. If you deal with messages/event you need to propagate context in headers or metadata. Sender and receiver tracing observation handlers will use Propagator.Getter and Propagator.Sender to inject/restore tracing context to/from message.  
2. Remember span/observation has to be made current to propagate context (it invokes propagating handlers).

### Reference Documentation

* https://github.com/micrometer-metrics/micrometer/wiki/Migrating-to-new-1.10.0-Observation-API#you-need-to-copy-sleuths-code-to-your-project-and-rewrite-the-sleuths-tracer-api-to-micrometers-observation-api

## License
Distributed under the Creative Commons Attribution-NonCommercial 4.0 International Public License. See `LICENSE` for more information.