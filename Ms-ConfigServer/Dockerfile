# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR into the container at /app
COPY target/msconfigserver.jar /app/msconfigserver.jar

# Make port 9093 available to the world outside this container
EXPOSE 9093

# Run the JAR file
ENTRYPOINT ["java", "-jar", "msconfigserver.jar"]