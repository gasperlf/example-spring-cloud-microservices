FROM openjdk:8
ADD target/financial-service-1.0.0.jar financial-service-1.0.0.jar
EXPOSE 7000
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "financial-service-1.0.0.jar"]

