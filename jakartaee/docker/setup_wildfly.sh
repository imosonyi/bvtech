#!/bin/bash

JBOSS_HOME=/opt/jboss/wildfly
JBOSS_CLI=$JBOSS_HOME/bin/jboss-cli.sh
JBOSS_PROFILE=standalone.xml

function wait_for_server() {
  until `$JBOSS_CLI -c "ls /deployment" &> /dev/null`; do
    sleep 1
  done
}

echo "Starting WildFly..."
$JBOSS_HOME/bin/standalone.sh -c $JBOSS_PROFILE > /dev/null &
wait_for_server

echo "Configuring WildFly..."
$JBOSS_CLI -c --file=$CONFIG_HOME/wildfly_config.cli

echo "Shutting down WildFly..."
$JBOSS_CLI -c ":shutdown"
