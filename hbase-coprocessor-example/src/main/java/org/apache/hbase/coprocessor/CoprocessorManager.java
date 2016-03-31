package org.apache.hbase.coprocessor;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.Coprocessor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.util.Bytes;

public class CoprocessorManager {
	private static final Log LOG = LogFactory.getLog(CoprocessorManager.class.getName());

	private HBaseAdmin admin;
	
	public CoprocessorManager(HBaseAdmin admin){
		this.admin = admin;
	}
	
	public void dropAllTableCoprocessor(){
		try{
			TableName []tableNames = this.admin.listTableNames();
			for(TableName tableName : tableNames){
				this.dropCoprocessor(tableName.getNameAsString());
			}
			LOG.info("DROP ALL TABLE COPERCOESSOR FINISH");
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public void dropCoprocessor(String tableName){
		try{
			LOG.info("drop " + tableName + " table coprocessor");
			HTableDescriptor htableDescriptor = this.admin.getTableDescriptor(Bytes.toBytes(tableName));
			List<String> coprocessors = htableDescriptor.getCoprocessors();
			for(String coprocessor : coprocessors){
				htableDescriptor.removeCoprocessor(coprocessor);
			}	
			this.admin.modifyTable(tableName, htableDescriptor);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public void addAllTableCoprocessor(String hdfsJarFilePath, String className){
		try{
			TableName []tableNames = this.admin.listTableNames();
			for(TableName tableName : tableNames){
				addCoprocessor(tableName.getNameAsString(), hdfsJarFilePath, className);
			}
			LOG.info("ADD ALL TABLE COPROCESSOR FINISH");
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public void addCoprocessor(String tableName, String hdfsJarFilePath, String className){
		try{
			LOG.info("Add " + tableName + " table coprocessor");
			HTableDescriptor htableDescriptor = this.admin.getTableDescriptor(Bytes.toBytes(tableName));
			htableDescriptor.addCoprocessor(className, new Path(hdfsJarFilePath), Coprocessor.PRIORITY_USER, null);
			this.admin.modifyTable(tableName, htableDescriptor);
	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
