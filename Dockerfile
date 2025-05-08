# Build
FROM gradle:8.5-jdk21 AS build
COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project
RUN gradle clean build --no-daemon && cp build/libs/CICD-*-SNAPSHOT.jar app.jar

# Run
FROM eclipse-temurin:21-jre
COPY --from=build /home/gradle/project/app.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
