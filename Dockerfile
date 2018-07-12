FROM openjdk:8-jre-alpine
ADD target/gs-messaging-jms.jar sms.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "sms.jar"]