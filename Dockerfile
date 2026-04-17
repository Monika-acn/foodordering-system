FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY target/food-delivery-1.0.jar food-delivery.jar
ENTRYPOINT ["java","-jar","food-delivery.jar"]
