package com.havenliu.document;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.xxx.utils.DyMethodUtil;
import com.xxx.utils.algorithm;

import cn.fingerdata.bean.Customer;
import cn.fingerdata.dao1.BaseDataBaseDao;

public class MakeDetail {
	private Customer mCustomer;
	private algorithm.algorithmOutput output;
	
	public MakeDetail(Customer mCustomer, algorithm.algorithmOutput output)
	{
		this.mCustomer = mCustomer;
		this.output = output;
	}
	
	// 先天学习潜能
	public String Get_xiantianxuexiqianneng_fenxi()
	{
		String id = null;
		id = "1";
		
		String ret = null;
		Connection conn = BaseDataBaseDao.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();

			String sql = String.format("SELECT * FROM `doc_qianneng_jifa_fangshi` WHERE `id` = '%s'", id);
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) { // find
				System.out.println("executeQuery ok," + sql);
				ret = rs.getString("fenxi");
			} else {
				System.out.println("can not find where id = " + id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public String Get_caozuominruidu_fenxi() {
		int left = Integer.valueOf(mCustomer.getLeftATD());
		int right = Integer.valueOf(mCustomer.getRightATD());
		System.out.println("left:" + left + ",right:" + right);
		
		String ret = null;
		Connection conn = BaseDataBaseDao.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();

			String sql = String.format("SELECT * FROM `doc_caozuo_minruidu` WHERE 1");
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) { // loop
				String condition = rs.getString("condition");
				System.out.println("condition:" + condition);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("left", left);
				map.put("right", right);
				System.out.println(DyMethodUtil.invokeMethod(condition, map));
				ret = rs.getString("fenxi");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}
