FROM openjdk:11
ADD target/demo-0.0.1-SNAPSHOT.jar petstore.jar
ENTRYPOINT ["java", "-jar", "petstore.jar"]
EXPOSE 8080