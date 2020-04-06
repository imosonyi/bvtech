# BVTECH Jakarta EE
### How to run
To run this application, you are going to need to have an up and running instance of [Docker](https://www.docker.com/products/docker-desktop) with [Docker Compose](https://docs.docker.com/compose/).
If that is sorted out, just run
```bash
docker-compose up --build
```
in a command line tool of your choice and wait for a few moments. This will build the project and deploy it in a docker container, which will have its :8080 port exposed to [localhost:8080](http://localhost:8080/).
##### Note: it uses a database and the deployment will be unsuccessful if there is no running database container for this dependency. Please check out the `../bvtech-mysql` folder for more information.
### Development
#### Build
To build this application, you are going to need to have [JDK11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) and [Maven](https://maven.apache.org/download.cgi) installed.
If that is sorted out, just run
```bash
mvn clean package
```
in a command line tool of your choice. Optionally, if you do not want to run the tests, you can add the `-p skipTests` profile. This will generate a deployable `bvtech-jakartaee.war` file in the `/target` directory.
#### Test
Run
```bash
mvn clean verify
```
to run the tests and generate the [JaCoCo](https://www.eclemma.org/jacoco/) code coverage reports in the `/target/site/jacoco` directory.
