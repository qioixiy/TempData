package com.havenliu.document;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xxx.db.jdbc;
import com.xxx.utils.ComputeResult;
import com.xxx.utils.algorithm;

import cn.fingerdata.bean.Customer;
import cn.fingerdata.dao.impl.CustomerDaoImpl;

public class GenTableAllData {
	
	public void run(String userid) {
		int userid_i = Integer.parseInt(userid);
		
		CustomerDaoImpl mCustomerDaoImpl = new CustomerDaoImpl();
		Customer mCustomer = mCustomerDaoImpl.getByuserid(userid_i);
			
		ComputeResult mComputeResult = new ComputeResult();
		algorithm.algorithmOutput output = mComputeResult.UseAlgorithm(userid);

		genShujuZongbiao(mCustomer, output);
		ChengrenBaobiao(mCustomer, output);
	}
	
	private void genShujuZongbiao(Customer mCustomer, algorithm.algorithmOutput output)
	{
		System.out.println("genShujuZongbiao start");
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		dataMap.put("xx1", mCustomer.getName());
		dataMap.put("xx2", mCustomer.getGender());
		String birthday = mCustomer.getBirthday();
		
		String birthday_year = birthday.split("-")[0];
		String birthday_mouth = birthday.split("-")[1];
		dataMap.put("xx3", birthday_year);
		dataMap.put("xx4", birthday_mouth);
		
		dataMap.put("xx5", output.L1temp);
		dataMap.put("xx6", output.L2temp);
		dataMap.put("xx7", output.L3temp);
		dataMap.put("xx8", output.L4temp);
		dataMap.put("xx9", output.L5temp);
		dataMap.put("xx10", output.R1temp);
		dataMap.put("xx11", output.R2temp);
		dataMap.put("xx12", output.R3temp);
		dataMap.put("xx13", output.R4temp);
		dataMap.put("xx14", output.R5temp);
		dataMap.put("xx15", "xx");
		dataMap.put("xx16", "xx");
		dataMap.put("xx17", output.reason1 + "/" + output.Sensibility1);
		dataMap.put("xx18", output.reason2 + "/" + output.Sensibility2);
		dataMap.put("xx19", output.reason3 + "/" + output.Sensibility3);
		dataMap.put("xx20", output.reason4 + "/" + output.Sensibility4);
		dataMap.put("xx21", output.reason5 + "/" + output.Sensibility5);
		dataMap.put("xx22", "xx");
		dataMap.put("xx23", "xx");
		dataMap.put("xx24", "xx");
		dataMap.put("xx25", "xx");
		dataMap.put("xx26", "xx");
		dataMap.put("xx27", "xx");
		dataMap.put("xx28", "xx");
		dataMap.put("xx29", "xx");
		dataMap.put("xx30", "xx");
		dataMap.put("xx31", "xx");
		dataMap.put("xx32", "xx");
		dataMap.put("xx33", "xx");
		dataMap.put("xx34", "xx");

		MDoc mdoc = new MDoc();
		try {
			mdoc.createDoc(dataMap, "C:/Users/Mu/Desktop/shujuzongbiao.doc", "shujuzongbiao.xml");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("genShujuZongbiao end");
	}
	
	private void ChengrenBaobiao(Customer mCustomer, algorithm.algorithmOutput output)
	{
		;
	}
	
	private void ErtongBaobiao(Customer mCustomer, algorithm.algorithmOutput output)
	{
		;
	}
}
