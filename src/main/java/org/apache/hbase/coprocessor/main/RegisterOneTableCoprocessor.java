package org.apache.hbase.coprocessor.main;

import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hbase.coprocessor.CoprocessorManager;
import org.apache.hbase.coprocessor.factory.ConfigurationFactory;

public class RegisterOneTableCoprocessor {

	public static void main(String args[]) throws Exception{
		
		if(args.length <= 3){
			throw new RuntimeException("Please input hbase table name, hdfsJarFilePath, className");
		}
		String tableName = args[0];
		String hdfsJarFilePath = args[1];
		String className = args[2];
		
		HBaseAdmin admin = new HBaseAdmin(ConfigurationFactory.getHBaseConfiguration());
		CoprocessorManager manager = new CoprocessorManager(admin);
		manager.addCoprocessor(tableName, hdfsJarFilePath, className);
		
	}
}
