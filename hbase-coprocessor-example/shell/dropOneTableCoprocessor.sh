#!/bin/bash

export zookeeperHost=server-a1

java -cp $HBASE_HOME/lib/*:hbase-coprocessor-example.jar:. org.apache.hbase.coprocessor.main.DropOneTableCoprocessorMain table100
