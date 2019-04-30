FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8195
ADD build/libs/spring-bootstrap-gradle-profiles-docker-1.0.jar profiles-demo.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/profiles-demo.jar"]
