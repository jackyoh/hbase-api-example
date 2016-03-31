package org.apache.hbase.coprocessor;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.junit.BeforeClass;
import org.junit.Test;

public class CoprocessorManagerTest {
	private static HBaseAdmin admin;
	
	@BeforeClass
	public static void before(){
		try{
			Configuration config = HBaseConfiguration.create();
			config.set("hbase.zookeeper.quorum", "server-a1");
			admin = new HBaseAdmin(config);
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Test
	public void testdropCoprocessor(){
		CoprocessorManager manager = new CoprocessorManager(admin);
		manager.dropCoprocessor("table100");
	}
	
	@Test
	public void testaddCoprocessor(){
		CoprocessorManager manager = new CoprocessorManager(admin);
		String hdfsJarFilePath = "hdfs://server-a1:9000/tmp/haredb35.jar";
		String className = "com.haredb.hbase.hive.coprocessor.BaseHiveQLEndpoint";
		manager.addCoprocessor("table100", hdfsJarFilePath, className);
	}
}
