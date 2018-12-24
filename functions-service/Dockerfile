FROM openjdk:8
MAINTAINER Lewis Florez
ADD target/functions-service-2.0.0.jar functions-service.jar
EXPOSE 7003
ENTRYPOINT ["java" , "-Dconfig-server.uri=http://localhost:8888", "-Djava.security.egd=file:/dev/./urandom", "-jar", "functions-service.jar"]