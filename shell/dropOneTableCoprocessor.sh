#!/bin/bash

export zookeeperHost=server-a1

java -cp $HBASE_HOME/lib/*:hbase-api-example.jar:. org.apache.hbase.coprocessor.main.DropAllTableCoprocessorMain table100
