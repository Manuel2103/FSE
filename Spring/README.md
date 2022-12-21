# FSE

Dokumentation und Mitschrift für fortgeschrittene Software Entwicklung.

Manuel Foidl

# Inhaltsverzeichnis

- [FSE](#fse)
- [Inhaltsverzeichnis](#inhaltsverzeichnis)
- [Spring Boot](#spring-boot)
  - [SpassMitSpringBoot Intro](#spassmitspringboot-intro)

# Spring Boot

Spring Boot dient zur Entwicklung von Full-Stack Anwendungen, die in eine Datei (.jar)  umgewandelt werden und funktionieren.

## SpassMitSpringBoot Intro

Für die Initialisierung des Projekts wird Spring Initializr verwendet (https://start.spring.io/)

Als Builttool wird Maven verwendet und es wurden folgende Dependencies hinzugefügt:
 * Lombok (Java annotation library which helps to reduce boilerplate code.)
 * Spring Web (Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.)
 * Spring Data JPA (Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.)
 * H2 Database (Provides a fast in-memory database that supports JDBC API and R2DBC access, with a small (2mb) footprint. Supports embedded and server modes as well as a browser based console application.)
 * Validation (Bean Validation with Hibernate validator.)

Nachdem, das Projekt in IntelliJ geöffnet wurde und alle Dependencies geladen sind, wird unter resources -> application.properties der Datenbankzugriff konfiguriert.
```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```





















