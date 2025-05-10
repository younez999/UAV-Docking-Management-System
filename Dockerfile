# Base image with JDK  21
FROM eclipse-temurin:21-jdk AS builder

# Set the working directory
WORKDIR /app

# Copy Maven wrapper and POM
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make the Maven wrapper script executable
RUN chmod +x ./mvnw

# Copy source code
COPY src src

# Build the application inside Docker
RUN ./mvnw clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:21-jre

WORKDIR /app

# Install wget for downloading wait-for-it
RUN apt-get update && apt-get install -y wget

# Download wait-for-it script to ensure database is up before starting the app
RUN wget -O /usr/local/bin/wait-for-it.sh https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh \
    && chmod +x /usr/local/bin/wait-for-it.sh

# Copy the built jar file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application directly since we're connecting to the host's database
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "app.jar"]
