package org.apache.hbase.coprocessor.factory;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hbase.coprocessor.common.ServerCommonInfo;

public class ConfigurationFactory {
	
	public static Configuration getHBaseConfiguration(){
		Configuration config = HBaseConfiguration.create();
		config.set("hbase.zookeeper.quorum", ServerCommonInfo.getZookeeperHost());
		config.set("hbase.zookeeper.property.clientPort", ServerCommonInfo.getZookeeperPort());
		return config;
	}
	
}
