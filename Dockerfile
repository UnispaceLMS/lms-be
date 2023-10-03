#
# Build stage
#
FROM maven:3.8.5-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM eclipse-temurin:17-jre-focal
COPY --from=build /home/app/target/lms-be-0.0.1-SNAPSHOT.jar lms-be-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/lms-be-0.0.1.jar", "--spring.profiles.active=staging"]