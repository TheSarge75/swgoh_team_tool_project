FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} swgohartifact-1.0.jar
ENTRYPOINT ["java","-jar","/swgohartifact-1.0.jar"]