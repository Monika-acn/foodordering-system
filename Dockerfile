FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/food-delivery-1.0.jar food-delivery.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "food-delivery.jar"]
