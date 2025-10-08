# Build stage
FROM maven:3.9.8-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Package stage
FROM eclipse-temurin:21-jre-jammy
COPY --from=build /target/store-management-system-backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
