FROM amazoncorretto:11-alpine-jdk
MAINTAINER hafares
COPY target/fizzbuzz-1.0.0.jar fizzbuzz-1.0.0.jar
ENTRYPOINT ["java","-jar","/fizzbuzz-1.0.0.jar"]