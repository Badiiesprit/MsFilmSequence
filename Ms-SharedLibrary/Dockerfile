# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR into the container at /app
COPY target/mssharedlibrary.jar /app/mssharedlibrary.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "mssharedlibrary.jar"]
