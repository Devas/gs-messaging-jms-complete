FROM openjdk:8-jre-alpine
ADD target/sms-docker.jar sms-docker.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "sms-docker.jar"]