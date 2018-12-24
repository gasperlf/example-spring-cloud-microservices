FROM openjdk:8
MAINTAINER Lewis Florez
ADD target/security-service-2.0.0.jar security-service.jar
EXPOSE 7002
ENTRYPOINT ["java" , "-Dconfig-server.uri=http://localhost:8888", "-Djava.security.egd=file:/dev/./urandom", "-jar", "security-service.jar"]