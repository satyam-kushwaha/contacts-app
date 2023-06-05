FROM openjdk:17
EXPOSE 8080
ADD target/contacts-app.jar contacts-app.jar 
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]