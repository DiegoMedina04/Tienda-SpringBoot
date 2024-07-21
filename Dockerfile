FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY target/*.jar demo-store-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app.jar"]

# FROM openjdk:17-jdk-alpine
# # ARG JAR_FILE=target/*.jar
# COPY target/*.jar demo-store-0.0.1-SNAPSHOT.jar
# ENTRYPOINT ["java","-jar","demo-store-0.0.1-SNAPSHOT.jar"]

