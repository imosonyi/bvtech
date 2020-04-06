# BVTECH MySQL
### How to run
To run this application, you are going to need to have an up and running instance of [Docker](https://www.docker.com/products/docker-desktop).
If that is sorted out, just run
```bash
docker build -t bvtech-mysql .
docker container run -p 3306:3306 bvtech-mysql
```
in a command line tool of your choice and wait for a few moments. This will create a mysql container with the required users, privileges, schemas and tables, which will have its :3306 port exposed to [localhost:3306](http://localhost:3306/).
##### Note: the Jakarta EE and the Spring Boot applications are using this container as a dependency. If you are planning to start those applications individually, please make sure to have this container started first.
