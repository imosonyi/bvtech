# BVTECH Angular
### How to run
To run this application, you are going to need to have an up and running instance of [Docker](https://www.docker.com/products/docker-desktop).
If that is sorted out, just run
```bash
docker build -t bvtech-angular .
docker container run -p 80:80 bvtech-angular
```
in a command line tool of your choice and wait for a few moments. This will build the project and deploy it in a docker container, which will have its :80 port exposed to [localhost](http://localhost:80/).
### Development
#### Development server
Run `ng serve` for a dev server. Navigate to [localhost:4200](http://localhost:4200/), and the app will automatically reload if you change any of the source files.
#### Build
Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.
