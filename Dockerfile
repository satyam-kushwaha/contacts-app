
#
# Package stage
#
FROM openjdk:17-jdk-slim-buster
COPY --from=build /target/contacts-app-0.0.1-SNAPSHOT.jar contacts-app.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","contacts-app.jar"]