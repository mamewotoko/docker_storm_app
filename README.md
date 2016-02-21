Submit topology to dockerized storm
===================================

Usage: use storm-starter
------------------------
0. install [docker-compose](https://docs.docker.com/compose/install/)

1. clone submodules
```
git submodule init
git submodule update
```
2. download storm binary
```
sh setup.sh
```
3. start new terminal and start zookeeper
```
cd docker-storm
docker-compose -p storm -f ./docker-zookeeper.yml up
```
4. start new terminal and start storm
```
cd docker-storm
docker-compose -p storm -f ./docker-storm.yml up
```
5. submit topology 
```
sh run.sh
```
6. browse storm ui and check that submitted topology is listed in table
http://localhost:8080

Usage: use sample app in src directory
--------------------------------------
1. do 1-3 of "Usage: use storm-starter"
2. build
```
ant
```
3. submit topology, which is named "print"
```
sh myrun.sh
```
4. browse storm ui
5. check topology log written with logger
```
docker exec -it storm_supervisor_1 /bin/bash
cd /usr/share/apache-storm/logs
tail print-*.log
```

Stop Topology
-------------
Kill topology using storm ui

References
----------
- [fhussonnois/docker-storm](https://github.com/fhussonnois/docker-storm)

TODO
----
* use multiple nimbus and supervisor containers
* use logviewer

Memo
----
* docker-storm does not work as background container???
* I cannot start wurstmeister/storm-docker...

----
Takashi Masuyama < mamewotoko@gmail.com >  
http://mamewo.ddo.jp/
