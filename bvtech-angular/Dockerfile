# Build project
FROM node:latest AS build
WORKDIR /usr/src/app
COPY package.json ./
RUN npm install
COPY . .
RUN npm run build

# Run project
from nginx:latest
COPY --from=build /usr/src/app/dist/bvtech-angular /usr/share/nginx/html

