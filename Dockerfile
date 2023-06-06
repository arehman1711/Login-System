# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file to the working directory
COPY pom.xml .

# Download the project dependencies
RUN mvn dependency:go-offline -B

# Copy the project source code to the container
COPY src ./src

COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar
# Build the application
RUN mvn package -DskipTests

# Set the entrypoint command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "target/your-app.jar"]
