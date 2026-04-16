# WHY FROM openjdk:17? → We need Java 17 to run our app.
# 'slim' version = smaller image size (faster download)
FROM openjdk:17-jdk-slim

# WHY WORKDIR? → Sets the working directory inside the container.
# All subsequent commands run from this path.
WORKDIR /app

# WHY COPY? → Copies our compiled JAR file into the container.
# Maven puts the JAR in target/ folder after 'mvn package'
COPY target/food-delivery-1.0.jar food-delivery.jar

# WHY EXPOSE 8080? → Documents that our app listens on port 8080.
# (Doesn't actually open the port — just documentation + Kubernetes uses this info)
EXPOSE 8080

# WHY ENTRYPOINT? → The command that runs when container starts.
# java -jar runs our JAR file.
ENTRYPOINT ["java", "-jar", "food-delivery.jar"]