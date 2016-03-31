package org.apache.hbase.coprocessor.main;

import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hbase.coprocessor.CoprocessorManager;
import org.apache.hbase.coprocessor.factory.ConfigurationFactory;

public class DropOneTableCoprocessorMain {
	
	public static void main(String args[]) throws Exception{
		if(args.length <= 0){
			throw new RuntimeException("Please input hbase table name");
		}
		String tableName = args[0];
		
		HBaseAdmin admin = new HBaseAdmin(ConfigurationFactory.getHBaseConfiguration());
		CoprocessorManager manager = new CoprocessorManager(admin);
		manager.dropCoprocessor(tableName);
		
		admin.close();
	}
}
