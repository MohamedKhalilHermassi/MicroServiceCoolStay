FROM openjdk:17
EXPOSE 8082
ADD target/HebergementMS-0.0.1-SNAPSHOT.jar HebergementMS-docker.jar
ENTRYPOINT ["java", "-jar", "HebergementMS-docker.jar"]