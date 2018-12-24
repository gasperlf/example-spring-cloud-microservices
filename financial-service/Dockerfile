FROM openjdk:8
MAINTAINER Lewis Florez
ADD target/financial-service-2.0.0.jar financial-service.jar
EXPOSE 7000
ENTRYPOINT ["java", "-Dconfig-server.uri=http://localhost:8888", "-Djava.security.egd=file:/dev/./urandom", "-jar", "financial-service.jar"]