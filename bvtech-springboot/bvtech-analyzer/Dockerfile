# Build project
FROM maven:latest AS build
VOLUME maven-repo /root/.m2
WORKDIR /usr/src/app
COPY . .
RUN mvn clean verify

# Run project
FROM adoptopenjdk/openjdk11
COPY --from=build /usr/src/app/target/bvtech-springboot-analyzer.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
