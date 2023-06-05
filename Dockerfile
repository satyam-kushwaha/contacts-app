#
# Build stage
#
FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/contacts-app-0.0.1-SNAPSHOT.jar contacts-app.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","contacts-app.jar"]