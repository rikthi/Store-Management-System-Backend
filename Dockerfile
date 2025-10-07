FROM maven:3.9.5-openjdk-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk
COPY --from=build /target/store-management-system-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]