FROM node:latest
FROM openjdk:13-alpine

RUN apk update && apk upgrade && apk add curl bash && rm /var/cache/apk/*

ENV MAVEN_VERSION 3.6.3
ENV MAVEN_HOME /usr/lib/mvn

RUN cd /tmp \
  && curl -O "http://www.mirrorservice.org/sites/ftp.apache.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz" \
  && tar -zxf "apache-maven-$MAVEN_VERSION-bin.tar.gz" \
  && mv "apache-maven-$MAVEN_VERSION" "$MAVEN_HOME" \
  && ln -s "$MAVEN_HOME/bin/mvn" /usr/bin/mvn \
  && rm /tmp/apache-maven-*

VOLUME /root/.m2

RUN apk add --update nodejs npm

