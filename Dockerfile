# Stage 1: Build the application
FROM maven:3.9.3-eclipse-temurin-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file and download the dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the application source code
COPY src ./src

# Package the application without running tests
RUN mvn clean package -DskipTests

# Stage 2: Create a smaller runtime image
FROM eclipse-temurin:17-jre-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/aprs-pta-svc-0.0.1.jar aprs.jar

# Expose port 8080 to the outside world
EXPOSE 8090

ENV SERVER_PORT=8090

# Run the JAR file
ENTRYPOINT ["java", "-jar", "aprs.jar"]
