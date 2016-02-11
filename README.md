Submit topology to dockerized storm
===================================

Usage: use storm-starter
------------------------
1. download storm binary
    ```bash
    sh setup.sh
    ```
2. start new terminal and start zookeeper
    ```bash
    cd docker-storm
    docker-compose -p storm -f ./docker-zookeeper.yml up
    ```
3. start new terminal and start storm
    ```bash
    cd docker-storm
    docker-compose -p storm -f ./docker-storm.yml up
    ```
4. submit topology 
    ```bash
    sh run.sh
    ```
5. browse storm ui and check that submitted topology is listed in table
http://localhost:8080

Usage: use sample app in src directory
--------------------------------------
1. do 1-3 of "Usage: use storm-starter"
2. build
    ```bash
    ant
    ```
3. submit topology, which is named "print"
    ```bash
    sh myrun.sh
    ```
4. browse storm ui
5. check topology log written with logger
    ```bash
    docker exec -it storm_supervisor_1 /bin/bash
    cd /usr/share/apache-storm/logs
    tail print-*.log
    ```

Stop Topology
-------------
Kill topology using storm ui

References
----------
- [stormをdockerで動かす](http://qiita.com/lambda-knight/items/553304ec0add145c2cce)

TODO
----
* use multiple nimbus and supervisor containers

Memo
----
* I cannot start wurstmeister/storm-docker...

----
Takashi Masuyama < mamewotoko@gmail.com >  
http://mamewo.ddo.jp/

