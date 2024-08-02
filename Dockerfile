FROM openjdk:21-jdk-slim
WORKDIR /app
COPY gradlew ./
COPY gradle/ gradle/
COPY build.gradle ./
COPY settings.gradle ./
COPY src/ ./src/
RUN chmod +x gradlew
RUN ./gradlew spotlessApply
RUN ./gradlew clean build -x test
ARG JAR=./build/libs/*.jar
COPY $JAR app.jar
ENTRYPOINT java -jar app.jar
