#! /bin/sh
STORM_HOME=$PWD/apache-storm-0.9.6/

# nimbus port forwarded to host
NIMBUS_ADDRESS=127.0.0.1
NIMBUS_PORT=6627

# -c nimbus.host=${NIMBUS_ADDRESS} -c nimbus.thrift.port=${NIMBUS_PORT}
${STORM_HOME}/bin/storm jar topology.jar com.mamewo.printapp.PrintTopology print
