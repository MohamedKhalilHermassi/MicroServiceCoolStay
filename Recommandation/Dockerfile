FROM openjdk:17
EXPOSE 8088
ADD target/Recommandation-0.0.1-SNAPSHOT.jar Recommandation-docker.jar
ENTRYPOINT ["java","-jar","Recommandation-docker.jar"]