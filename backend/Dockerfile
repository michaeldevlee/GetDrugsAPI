FROM maven:3.9.6-amazoncorretto-17-debian-bookworm AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

FROM amazoncorretto:17-alpine3.19-jdk

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
