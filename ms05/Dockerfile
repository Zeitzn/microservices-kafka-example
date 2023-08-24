FROM openjdk:17-jdk-slim AS build

COPY target/ms05-0.0.1-SNAPSHOT.jar ms05-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/ms05-0.0.1-SNAPSHOT.jar"]