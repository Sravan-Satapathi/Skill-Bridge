# # Build stage
# FROM maven:3.9-eclipse-temurin-21-alpine AS builder
# WORKDIR /app

# # Copy pom and download dependencies (cached unless pom changes)
# COPY pom.xml .
# RUN mvn dependency:go-offline -B

# # Copy source and build
# COPY src src
# RUN mvn package -DskipTests -B

# # Run stage
# FROM eclipse-temurin:21-jre-alpine
# WORKDIR /app

# # Create non-root user
# RUN addgroup -S appgroup && adduser -S appuser -G appgroup
# USER appuser

# # Copy JAR from builder
# COPY --from=builder /app/target/Skill-Bridge-0.0.1-SNAPSHOT.jar app.jar

# EXPOSE 8080

# ENTRYPOINT ["java", "-jar", "app.jar"]

# ---------- Build Stage ----------
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /app

# Copy pom and download dependencies (cached layer)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source and build
COPY src ./src
RUN mvn clean package -DskipTests

# ---------- Run Stage ----------
FROM eclipse-temurin:21-jre
WORKDIR /app

# Create non-root user
RUN useradd -m appuser
USER appuser

# Copy JAR (dynamic name)
COPY --from=builder /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Run app
ENTRYPOINT ["java", "-jar", "app.jar"]
