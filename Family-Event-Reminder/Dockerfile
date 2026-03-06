# Stage 1: Build jar
FROM eclipse-temurin:17-jdk-focal AS builder
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN apt-get update && apt-get install -y maven \
    && mvn clean package -DskipTests

# Stage 2: Run app
FROM eclipse-temurin:17-jdk-focal
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]