FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/*.jar /app/maven_pjt-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","maven_pjt-0.0.1-SNAPSHOT.jar"]