#! /bin/sh
STORM_HOME=$PWD/apache-storm-0.9.6/

# nimbus port forwarded to host
NIMBUS_ADDRESS=127.0.0.1
NIMBUS_PORT=6627

# -c nimbus.host=${NIMBUS_ADDRESS} -c nimbus.thrift.port=${NIMBUS_PORT}
${STORM_HOME}/bin/storm jar ${STORM_HOME}/examples/storm-starter/storm-starter-topologies-0.9.6.jar storm.starter.ExclamationTopology exclaim 

#${STORM_HOME}/bin/storm jar ${STORM_HOME}/examples/storm-starter/storm-starter-topologies-0.9.6.jar storm.starter.RollingTopWords topology remote -c nimbus.host=${NIMBUS_ADDRESS} -c nimbus.thrift.port=${NIMBUS_PORT}
