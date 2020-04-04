FROM adoptopenjdk/openjdk11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.2.1/wait /wait
RUN chmod +x /wait

CMD /wait && java -jar /app.jar
