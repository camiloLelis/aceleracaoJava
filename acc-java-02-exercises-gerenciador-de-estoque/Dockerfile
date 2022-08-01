FROM openjdk:11.0-jdk as build-image
RUN mkdir -p /app
WORKDIR /app
COPY . .
RUN ./mvnw clean package

FROM openjdk:11.0-jre
COPY --from=build-image /app/target/*.jar /app/app.jar

EXPOSE 8888
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]
