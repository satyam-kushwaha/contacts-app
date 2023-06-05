FROM adoptopenjdk/openjdk11-openj9:alpine
ADD target/contacts-app.jar /myapp/contacts-app.jar
EXPOSE 8080
ENTRYPOINT java -jar /myapp/contacts-app.jar