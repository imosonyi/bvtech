FROM jboss/wildfly:latest

ENV CONFIG_HOME /opt/jboss/wildfly/config
RUN mkdir $CONFIG_HOME

ADD ./* $CONFIG_HOME/

RUN bash $CONFIG_HOME/download_mysql_connectorj.sh
RUN bash $CONFIG_HOME/setup_wildfly.sh

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
