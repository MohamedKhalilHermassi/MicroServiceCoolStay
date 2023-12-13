FROM openjdk:17
EXPOSE 8087
ADD target/User-0.0.1-SNAPSHOT.jar UserMS-docker.jar
ENTRYPOINT ["java", "-jar", "UserMS-docker.jar"]