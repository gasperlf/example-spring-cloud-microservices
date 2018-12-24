FROM openjdk:8
ADD target/customer-service-2.0.0.jar customer-service.jar
EXPOSE 7001
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "customer-service.jar"]