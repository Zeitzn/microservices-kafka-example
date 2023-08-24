FROM openjdk:17-jdk-slim AS build

COPY target/ms02-0.0.1-SNAPSHOT.jar ms02-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/ms02-0.0.1-SNAPSHOT.jar"]