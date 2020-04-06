# BVTECH Spring Boot Microservices
### How to run
To run these applicationa, you are going to need to have an up and running instance of [Docker](https://www.docker.com/products/docker-desktop) with [Docker Compose](https://docs.docker.com/compose/).
If that is sorted out, just run
```bash
docker-compose up --build
```
in a command line tool of your choice and wait for a few moments. This will build all the microservices and deploy in their own docker container, which will have its :8081 port exposed to [localhost:8081](http://localhost:8081/).
### Build & Test
The build and testing instructions can be found in the README.md files in the subdirectories.
