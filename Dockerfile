# stage 1 pick base image of meaven which creates jar files
FROM maven:3.9.6-eclipse-temurin-17 AS build
# the app folder make inside container where all commands executes
WORKDIR /app
# copies all the dependendies from pom.xms
COPY pom.xml .
# copies source code
COPY src ./src
# creare artifacts
RUN mvn clean package -DskipTests


# stage 2
# in this stage that is run and final stage so use small image of java
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/user-service-1.0.0.jar app.jar


EXPOSE 8080


ENTRYPOINT ["java", "-jar", "app.jar"]