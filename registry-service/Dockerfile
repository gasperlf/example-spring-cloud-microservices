FROM openjdk:8
MAINTAINER Lewis Florez
ADD target/registry-service-2.0.0.jar registry-service.jar
EXPOSE 8000
ENTRYPOINT ["java", "-Dconfig-server.uri=http://localhost:8888" , "-Djava.security.egd=file:/dev/./urandom" ,"-jar", "registry-service.jar"]