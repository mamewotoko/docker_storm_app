Submit topology to dockerized storm
===================================

Usage
-----
1. download storm binary
```bash
sh setup.sh
```
2. start new terminal and start zookeeper
```bash
cd docker-storm
docker-compose -p storm -f ./docker-zookeeper.yml up
```bash
3. start new terminal and start storm
cd docker-storm
docker-compose -p storm -f ./docker-storm.yml up
```
4. submit topology 
```bash
sh run.sh
```

References
----------
- [stormをdockerで動かす](http://qiita.com/lambda-knight/items/553304ec0add145c2cce)

Memo
----
I cannot start wurstmeister/storm-docker.

----
Takashi Masuyama < mamewotoko@gmail.com >  
http://mamewo.ddo.jp/

