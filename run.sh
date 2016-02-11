#! /bin/sh
STORM_HOME=$PWD/apache-storm-0.9.6/

NIMBUS_ADDRESS=127.0.0.1
NIMBUS_PORT=6627

#49627
# -Djava.net.preferIPv4Stack=true
${STORM_HOME}/bin/storm jar ${STORM_HOME}/examples/storm-starter/storm-starter-topologies-0.9.6.jar storm.starter.RollingTopWords topology remote -c nimbus.host=${NIMBUS_ADDRESS} -c nimbus.thrift.port=${NIMBUS_PORT}
