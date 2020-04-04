# Build project
FROM maven:latest AS build
VOLUME maven-repo /root/.m2
WORKDIR /usr/src/app
COPY . .
RUN mvn clean verify

# Run project
FROM adoptopenjdk/openjdk11
COPY --from=build /usr/src/app/target/bvtech-springboot-db.jar app.jar

ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.2.1/wait /wait
RUN chmod +x /wait

CMD /wait && java -jar /app.jar
