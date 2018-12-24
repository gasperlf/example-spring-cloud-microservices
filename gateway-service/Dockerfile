FROM openjdk:8
MAINTAINER Lewis Florez
ADD target/gateway-service-2.0.0.jar gateway-service.jar
EXPOSE 8080
ENTRYPOINT ["java" , "-Dconfig-server.uri=http://localhost:8888", "-Djava.security.egd=file:/dev/./urandom", "-jar", "gateway-service.jar"]