FROM openjdk:17
EXPOSE 8083
ADD target/ReservationMS-0.0.1-SNAPSHOT.jar ReservationMS-docker.jar
ENTRYPOINT ["java", "-jar", "ReservationMS-docker.jar"]