FROM openjdk:17
EXPOSE 8080
COPY target/axio-test-task-0.0.1-SNAPSHOT.jar axio-test-task-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "axio-test-task-0.0.1-SNAPSHOT.jar"]
