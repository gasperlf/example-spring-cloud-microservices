FROM openjdk:8
MAINTAINER Lewis Florez
ADD target/notification-service-2.0.0.jar notification-service.jar
EXPOSE 7004
ENTRYPOINT ["java" , "-Dconfig-server.uri=http://localhost:8888", "-Djava.security.egd=file:/dev/./urandom", "-jar", "notification-service.jar"]