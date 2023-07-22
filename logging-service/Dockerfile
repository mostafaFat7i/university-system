FROM openjdk:8
WORKDIR /app
COPY target/logging-service-0.0.1-SNAPSHOT.jar .
EXPOSE 8099
ENTRYPOINT ["java", "-jar", "logging-service-0.0.1-SNAPSHOT.jar"]
