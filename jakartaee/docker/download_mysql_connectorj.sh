#!/bin/bash

cd /tmp \
  && curl -L -O "https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.19.tar.gz" \
  && tar -zxf mysql-connector-java-8.0.19.tar.gz \
  && mv mysql-connector-java-8.0.19/mysql-connector-java-8.0.19.jar $CONFIG_HOME \
  && chmod 644 $CONFIG_HOME/mysql-connector-java-8.0.19.jar \
  && rm -rf /tmp/mysql-*
