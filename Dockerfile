# ---- Step 1: Build stage ----
FROM gradle:8.5-jdk21 AS build
COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project
RUN gradle clean build --no-daemon

# ---- Step 2: Run stage ----
FROM eclipse-temurin:21-jre
COPY --from=build /home/gradle/project/build/libs/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
