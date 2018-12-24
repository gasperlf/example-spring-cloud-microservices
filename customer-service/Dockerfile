FROM openjdk:8
MAINTAINER Lewis Florez
ADD target/customer-service-2.0.0.jar customer-service.jar
EXPOSE 7001
ENTRYPOINT ["java" , "-Dconfig-server.uri=http://localhost:8888", "-Djava.security.egd=file:/dev/./urandom", "-jar", "customer-service.jar"]