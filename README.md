# Countries reactive REST API

[![CircleCI](https://circleci.com/gh/lucabaggi/reactive-countries.svg?style=shield)](https://circleci.com/gh/lucabaggi/reactive-countries) [![codecov](https://codecov.io/gh/lucabaggi/reactive-countries/branch/master/graph/badge.svg)](https://codecov.io/gh/lucabaggi/reactive-countries)

Reactive REST web service that returns all countries whose name matches a given search text. 
The project is based on [Spring Boot 2](https://spring.io/projects/spring-boot) with [Spring WebFlux](https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html), which is built on top of [Project Reactor](https://projectreactor.io/)

## Application running

It is possible to run the application in different ways:
* using [Spring Boot Maven Plugin](https://docs.spring.io/spring-boot/docs/current/maven-plugin/index.html) 
* creating a jar bundle and running it with java
* building a [Docker](https://www.docker.com/) image and running it as a container

Depending on the above choice, these are the requirements you need to install on the executing environment:
* JDK11+, in first two cases (open source versions are fine, e.g. [AdoptOpenJDK](https://adoptopenjdk.net/))
* Docker, for the last one

### Spring Boot Maven Plugin

To run the application using Spring Boot Maven plugin, it is sufficient to run the following command using Maven wrapper available with this project:
```
./mvnw spring-boot:run
```

### Running with Java

To run the application using java, firstly you need to create a jar bundle using Maven:
```
mvn clean package
```

And then:
```
java -jar target/countries-0.0.1-SNAPSHOT.jar
```

### Docker container

It is possible to build a Docker image using [Jib Maven Plugin](https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin):
```
mvn compile jib:dockerBuild
```
This will produce a Docker image named `reactive-countries:latest` based on `adoptopenjdk/openjdk12:alpine-jre`. 
Then to run the container:
```
docker run -d -p 8080:8080 reactive-countries:latest
```


Once application is up and running, it will be possible to invoke the REST endpoint:
```
curl http://localhost:8080/countries/italy
```

## Testing

Both unit and integration tests are included and their execution is managed inside Maven lifecycle using [Surefire](http://maven.apache.org/surefire/maven-surefire-plugin/) and [Failsafe](http://maven.apache.org/surefire/maven-failsafe-plugin/) maven plugins.

To run unit tests:
```
./mvnw test
```

To run unit and integration tests:

`./mvnw integration-test` or `./mvnw verify`

It is possible to skip unit or integration tests using `-Dskip.unit.test=true` or `-Dskip.integration.test=true`

