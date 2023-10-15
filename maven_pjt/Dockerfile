FROM openjdk:17-jdk-alpine
VOLUME /tmp
ADD /target/*.jar maven_pjt-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/maven_pjt-0.0.1-SNAPSHOT.jar"]