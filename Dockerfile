# --- Stage 1: Build the application ---
FROM maven:3.9.6-eclipse-temurin-21-jammy AS build
WORKDIR /app

# Cache Maven dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build WAR package
COPY src ./src
RUN mvn clean package -DskipTests

# --- Stage 2: Create the runtime image ---
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Copy the built WAR file
COPY --from=build /app/target/*.war /app/app.war

# Expose container port
EXPOSE 2426

# Force Spring Boot to listen on 0.0.0.0 and port 2426
ENTRYPOINT ["java", "-Dserver.address=0.0.0.0", "-Dserver.port=2426", "-jar", "app.war"]