package org.apache.hbase.coprocessor.main;

import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hbase.coprocessor.CoprocessorManager;
import org.apache.hbase.coprocessor.factory.ConfigurationFactory;

public class RegisterAllTableCoprocessor {
	
	public static void main(String args[]) throws Exception{
		if(args.length <= 2){
			throw new RuntimeException("Please input hbase hdfsJarFilePath, className");
		}
		String hdfsJarFilePath = args[0];
		String className = args[1];
		
		HBaseAdmin admin = new HBaseAdmin(ConfigurationFactory.getHBaseConfiguration());
		CoprocessorManager manager = new CoprocessorManager(admin);
		manager.addAllTableCoprocessor(hdfsJarFilePath, className);
	}

}
