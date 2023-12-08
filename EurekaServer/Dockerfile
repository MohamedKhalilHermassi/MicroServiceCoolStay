FROM openjdk:17
EXPOSE 8761
ADD target/EurekaServer-0.0.1-SNAPSHOT.jar EurekaMS-docker.jar
ENTRYPOINT ["java", "-jar", "EurekaMS-docker.jar"]