![CircleCI](https://circleci.com/gh/imosonyi/bvtech.svg?style=shield&circle-token=d8a913b469faff7e6c146acc10eed4cc0839f55b) ![JakartaEE](https://img.shields.io/badge/JakartaEE-8.0.0-orange?logo=java) ![SpringBoot](https://img.shields.io/badge/SpringBoot-2.2.6.RELEASE-green?logo=spring) ![Angular](https://img.shields.io/badge/Angular-8.0.6-red?logo=angular)
# BVTECH Interview Task
### Software Engineer - Java
Solution(s) to the Java Software Engineer role interview task at BVTECH. The exercise was to create a server application that makes requests to the [RandomText's API](http://www.randomtext.me/) and calculates the

 - most frequent word
 - average paragraph size
 - average processing time for a single paragraph
 - total processing time

and returns it as a JSON.

For most of my career I developed mainly [Java EE](https://www.oracle.com/java/technologies/java-ee-glance.html) applications, but recently I started to learn about [Spring Boot microservices](https://spring.io/microservices). So I decided to implement a solution for this task with both technologies.
### Comparison
Both applications use the same instance of [MySQL](https://www.mysql.com/) database.

The [Jakarta EE](https://jakarta.ee/) project has a "monolithic" architecture, wheras the Spring Boot application is using the microservices architecture and is distributed as follows:
 - bvtech-analyzer:
 -- contains the `/betvictor/text` rest endpoint
 -- calculates the statistics of the paragraphs
 -- sends the result to the db application
 - bvtech-db:
 -- contains the `/betvictor/history` rest endpoint
 -- stores the analysis reports in the database
 - bvtech-gateway:
 -- a single endpoint gateway to the other two microservices

To be honest, maybe the bvtech-analyzer and bvtech-db microservices should not have been separated, but it was a great practice to implement the communication between these two via JMS with [ActiveMQ](https://activemq.apache.org/).

The Jakarta EE project compared to the Spring Boot project is
 - faster(ish) - Makes more multi-threaded calculations with the paragraphs which results in a hardly noticeable time advantage, but
 - not memory efficient - I mean... not at all, so please take care of how many requests you would like to make to the RandomText API :).

Whereas learning from this the Spring Boot application has
 - optimized memory usage - It uses the least amount of memory that is needed to create the response in a single synchronized object, so feel free to send large numbers in the request :), but be aware that it also has
 - a slower(ish) runtime - If you read the description carefully so far, you can have a guess why. Yes! Because it needs synchronized calculations after the requests to the RandomText API were made.

### Front-end with Angular
Being a back-end developer who loves to play around with the front end too, I created a simple page application with [Angular](https://angular.io/) just for fun. On the UI you can
 - choose to which server application to send the requests
 - send the `/betvictor/text` request and see the result, and
 - see the result of the last 10 execution in an automatically refreshed list.


### How to run
To run these applications you are going to need to have an up and running instance of:
 - [Docker](https://www.docker.com/products/docker-desktop) with [Docker Compose](https://docs.docker.com/compose/)

and that's all!
#### Running simultaneously
Each application can be run simultaneously and individually. To run all the applications together, just run
```bash
docker-compose up --build
```
in a command line tool of your choice and wait for a few moments. This will download the necessary dependencies, build and deploy all the applications in their own container after which they can be used all together in perfect harmony. When all the containers are up and running, you can choose to
 - open a browser and hit [localhost](http://localhost) to test both the Jakarta EE and Spring Boot server applications through the Angular front end.
 - test each service manually with HTTP requests.
 -- The Jakarta EE application runs on the port 8080
 -- The Spring Boot application runs on the port 8081

#### Running individually
All the applications (Jakarta EE, Spring Boot, Angular) can be run alone, for this please refer to the README.md in the subdirectories.

### How to build
The build instructions can be found in the README.md files in the subdirectories.
### Me
If you have any queries or remarks please do not hesitate to contact me!
#### István Mosonyi
mosonyi15p@yahoo.com
