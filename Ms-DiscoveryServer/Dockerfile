# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR into the container at /app
COPY target/Ms-DiscoveryServer-0.0.1-SNAPSHOT.jar /app/msdiscoveryserver.jar

# Make port 8761 available to the world outside this container
EXPOSE 8761

# Run the JAR file
ENTRYPOINT ["java", "-jar", "msdiscoveryserver.jar"]
