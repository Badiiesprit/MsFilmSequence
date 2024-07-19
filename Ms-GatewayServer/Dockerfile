# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR into the container at /app
COPY target/msgatewayserver.jar /app/msgatewayserver.jar

# Make port 9092 available to the world outside this container
EXPOSE 9092

# Run the JAR file
ENTRYPOINT ["java", "-jar", "msgatewayserver.jar"]
