FROM openjdk:17-jdk-slim AS build

COPY target/ms01-0.0.1-SNAPSHOT.jar ms01-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/ms01-0.0.1-SNAPSHOT.jar"]