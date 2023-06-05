FROM amazoncorretto:11-alpine-jdk
COPY target/contacts-app-0.0.1-SNAPSHOT.jar contacts-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/message-server-1.0.0.jar"]