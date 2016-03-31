package org.apache.hbase.coprocessor.main;

import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hbase.coprocessor.CoprocessorManager;
import org.apache.hbase.coprocessor.factory.ConfigurationFactory;

public class DropAllTableCoprocessorMain {
	
	public static void main(String args[]) throws Exception{
		HBaseAdmin admin = new HBaseAdmin(ConfigurationFactory.getHBaseConfiguration());
		CoprocessorManager manager = new CoprocessorManager(admin);
		manager.dropAllTableCoprocessor();
		admin.close();
		
	}
	

}
