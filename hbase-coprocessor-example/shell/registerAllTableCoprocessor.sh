#!/bin/bash
export zookeeperHost=server-a1

java -cp $HBASE_HOME/lib/*:hbase-coprocessor-example.jar:. org.apache.hbase.coprocessor.main.RegisterAllTableCoprocessorMain hdfs://server-a1:9000/tmp/haredb35.jar com.haredb.hbase.hive.coprocessor.BaseHiveQLEndpoint
