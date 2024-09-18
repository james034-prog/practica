FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/practica.jar practica.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "practica.jar"]
