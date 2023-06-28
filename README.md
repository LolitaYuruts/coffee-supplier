# Coffee supplier

## Introduction

Coffee supplier is a RESTful web service developed to be used as an API gateway for requests for available coffees and 
at the same time it is a highly scalable event-driven microservice connected with a shared messaging system (**RabbitMQ** 
is used as a binder with the possibility to switch to **Apache Kafka**) for publishing info about available coffees.

It provides HTTP API that can be consumed by other services and is able to publish messages via **Spring Cloud Stream** 
based on standard interfaces such as _Supplier<T>_.

## Technologies

- Java 11
- H2
- Spring Data
- Domain-Driven Design
- REST Architecture
- Spring Cloud Stream
- RabbitMQ