# BVTECH Spring Boot Gateway Microservice
### How to run
To run this application, you are going to need to have an up and running instance of [Docker](https://www.docker.com/products/docker-desktop).
If that is sorted out, just run
```bash
docker build -t bvtech-springboot-gateway .
docker container run -p 8081:8081 bvtech-springboot-gateway
```
in a command line tool of your choice and wait for a few moments. This will build the project and deploy it in a docker container, which will have its :8081 port exposed to [localhost:8081](http://localhost:8081/).
### Development
#### Build
To build this application, you are going to need to have [JDK11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) and [Maven](https://maven.apache.org/download.cgi) installed.
If that is sorted out, just run
```bash
mvn clean package
```
in a command line tool of your choice. Optionally, if you do not want to run the tests, you can add the `-p skipTests` profile. This will generate a runnable `bvtech-springboot-gateway.war` file in the `/target` directory. To run this file just execute the following command:
```bash
java -jar bvtech-springboot-gateway.jar
```
#### Test
Run
```bash
mvn clean verify
```
to run the tests and generate the [JaCoCo](https://www.eclemma.org/jacoco/) code coverage reports in the `/target/site/jacoco` directory.
