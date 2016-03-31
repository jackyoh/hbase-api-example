package org.apache.hbase.coprocessor.common;

public class ServerCommonInfo {
	
	public static String getZookeeperHost(){
		String zookeeper = System.getenv("zookeeperHost");
		if(zookeeper == null){
			throw new RuntimeException("Please setting zookeeperHost environment variable");
		}
		return zookeeper;
	}
	
	public static String getZookeeperPort(){
		String zookeeperPort = System.getenv("zookeeperPort");
		if(zookeeperPort == null){
			return "2181";
		} else {
			return zookeeperPort;
		}
	}
	
}
