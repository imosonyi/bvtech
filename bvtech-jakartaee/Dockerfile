FROM jboss/wildfly:latest

ENV CONFIG_HOME /opt/jboss/wildfly/config
RUN mkdir $CONFIG_HOME

ADD ./docker/* $CONFIG_HOME/

RUN bash $CONFIG_HOME/download_mysql_connectorj.sh
RUN bash $CONFIG_HOME/setup_wildfly.sh

ADD ./target/bvtech-jakartaee.war /opt/jboss/wildfly/standalone/deployments/

ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.2.1/wait /wait
USER root
RUN chmod +x /wait
USER jboss

CMD /wait && /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0
