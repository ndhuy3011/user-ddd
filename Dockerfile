FROM openjdk:17-oracle
VOLUME /tmp
COPY target/user-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]