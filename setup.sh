#! /bin/sh

if [ ! -d "docker-storm" ]; then
    git submodule init
    git submodule update
fi
if [ ! -d "apache-storm-0.9.6" ]; then
    wget http://ftp.jaist.ac.jp/pub/apache/storm/apache-storm-0.9.6/apache-storm-0.9.6.tar.gz
    tar xfz apache-storm-0.9.6.tar.gz
fi


