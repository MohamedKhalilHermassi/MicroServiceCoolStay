FROM openjdk:17
EXPOSE 8182
ADD target/swiggy-gateway-0.0.1-SNAPSHOT.jar swiggy-gateway-docker.jar
ENTRYPOINT ["java", "-jar", "swiggy-gateway-docker.jar"]