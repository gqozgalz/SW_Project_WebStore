FROM adoptopenjdk/openjdk11:alpine-jre

ADD target/webstore-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
