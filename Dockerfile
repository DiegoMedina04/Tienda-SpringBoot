FROM openjdk:17-jdk-alpine
# ARG JAR_FILE=target/*.jar
COPY target/*.jar demo-store-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","demo-store-0.0.1-SNAPSHOT.jar"]

# FROM openjdk:17-jdk-alpine
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar
# COPY wait-for-it.sh /wait-for-it.sh
# RUN chmod +x /wait-for-it.sh
# ENTRYPOINT ["/wait-for-it.sh", "java_db:5432", "--", "java", "-jar", "/app.jar"]


# FROM openjdk:17-jdk-alpine
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]

# FROM openjdk:17-jdk-alpine
# COPY target/demo-store-0.0.1-SNAPSHOT.jar java-app.jar
# ENTRYPOINT ["java", "-jar", "java-app.jar"]