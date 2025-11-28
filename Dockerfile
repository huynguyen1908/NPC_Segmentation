# ---------- Stage 1: Build ----------
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy toàn bộ source vào container
COPY . .

# Build project
RUN mvn clean package -DskipTests


# ---------- Stage 2: Run ----------
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy file jar từ stage build sang stage run
COPY --from=builder /app/target/*.jar app.jar

# Expose port app
EXPOSE 8087

# Run app
ENTRYPOINT ["java", "-jar", "app.jar"]
