FROM openjdk:8
MAINTAINER Lewis Florez
ADD target/rabbit-bus-service-2.0.0.jar rabbit-bus-service.jar
EXPOSE 7005
ENTRYPOINT ["java" , "-Dconfig-server.uri=http://localhost:8888", "-Djava.security.egd=file:/dev/./urandom", "-jar", "rabbit-bus-service.jar"]