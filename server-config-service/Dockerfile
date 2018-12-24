FROM openjdk:8
MAINTAINER Lewis Florez
ADD target/server-config-service-2.0.0.jar  server-config-service.jar
EXPOSE 8888
ENTRYPOINT ["java","-Dgit.uri=https://github.com/gasperlf/example-spring-cloud-microservices.git", "-Dapi.profiles.mode=git","-Dgit.branch=master", "-Dgit.username=gasperlf", "-Dgit.password=****", "-Dgit.searchPaths=/workspace/local/","-Dnative.searchLocation=none", "-Djava.security.egd=file:/dev/./urandom" ,"-jar", "server-config-service.jar"]