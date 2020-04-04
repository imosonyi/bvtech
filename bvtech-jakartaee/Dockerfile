# Build project
FROM maven:latest AS build
VOLUME maven-repo /root/.m2
WORKDIR /usr/src/app
COPY . .
RUN mvn clean verify

# Run project
FROM jboss/wildfly:latest

ENV CONFIG_HOME /opt/jboss/wildfly/config
RUN mkdir $CONFIG_HOME

ADD ./docker/* $CONFIG_HOME/

RUN bash $CONFIG_HOME/download_mysql_connectorj.sh
RUN bash $CONFIG_HOME/setup_wildfly.sh

COPY --from=build /usr/src/app/target/bvtech-jakartaee.war /opt/jboss/wildfly/standalone/deployments/

ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.2.1/wait /wait
USER root
RUN chmod +x /wait
USER jboss

CMD /wait && /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0
