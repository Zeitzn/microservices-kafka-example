FROM openjdk:17-jdk-slim AS build

COPY target/ms04-0.0.1-SNAPSHOT.jar ms04-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/ms04-0.0.1-SNAPSHOT.jar"]