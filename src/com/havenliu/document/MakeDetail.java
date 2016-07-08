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
	
	// ����ѧϰǱ��
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
				Object r = DyMethodUtil.invokeMethod(condition, map);
				System.out.println(r);
				if ((boolean)r == true) {
					ret = rs.getString("fenxi");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	//˼άϰ��
	public String Get_siweixiguan_fenxi_duiren() {
		float lixing = Float.valueOf(output.reason1);
		float ganxing = Float.valueOf(output.Sensibility1);
		System.out.println("lixing:" + lixing + ",ganxing:" + ganxing);
		
		String ret = null;
		Connection conn = BaseDataBaseDao.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();

			String sql = String.format("SELECT * FROM `doc_siweixiguan` WHERE `type` = '����' AND `���` = '����' ");
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) { // loop
				String condition = rs.getString("condition");
				System.out.println("condition:" + condition);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("lixing", lixing);
				map.put("ganxing", ganxing);
				Object r = DyMethodUtil.invokeMethod(condition, map);
				System.out.println(r);
				if ((boolean)r == true) {
					ret = rs.getString("����");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	public String Get_siweixiguan_fenxi_duishi() {
		float lixing = Float.valueOf(output.reason2);
		float ganxing = Float.valueOf(output.Sensibility2);
		System.out.println("lixing:" + lixing + ",ganxing:" + ganxing);
		
		String ret = null;
		Connection conn = BaseDataBaseDao.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();

			String sql = String.format("SELECT * FROM `doc_siweixiguan` WHERE `type` = '����' AND `���` = '����' ");
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) { // loop
				String condition = rs.getString("condition");
				System.out.println("condition:" + condition);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("lixing", lixing);
				map.put("ganxing", ganxing);
				Object r = DyMethodUtil.invokeMethod(condition, map);
				System.out.println(r);
				if ((boolean)r == true) {
					ret = rs.getString("����");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	public String Get_siweixiguan_fenxi_duizhiti() {
		float lixing = Float.valueOf(output.reason3);
		float ganxing = Float.valueOf(output.Sensibility4);
		System.out.println("lixing:" + lixing + ",ganxing:" + ganxing);
		
		String ret = null;
		Connection conn = BaseDataBaseDao.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();

			String sql = String.format("SELECT * FROM `doc_siweixiguan` WHERE `type` = '����' AND `���` = '��֫��' ");
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) { // loop
				String condition = rs.getString("condition");
				System.out.println("condition:" + condition);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("lixing", lixing);
				map.put("ganxing", ganxing);
				Object r = DyMethodUtil.invokeMethod(condition, map);
				System.out.println(r);
				if ((boolean)r == true) {
					ret = rs.getString("����");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	public String Get_siweixiguan_fenxi_duishengyin() {
		float lixing = Float.valueOf(output.reason4);
		float ganxing = Float.valueOf(output.Sensibility4);
		System.out.println("SELECT * FROM `doc_siweixiguan` WHERE 1");
		
		String ret = null;
		Connection conn = BaseDataBaseDao.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();

			String sql = String.format("SELECT * FROM `doc_siweixiguan` WHERE `type` = '����' AND `���` = '������' ");
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) { // loop
				String condition = rs.getString("condition");
				System.out.println("condition:" + condition);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("lixing", lixing);
				map.put("ganxing", ganxing);
				Object r = DyMethodUtil.invokeMethod(condition, map);
				System.out.println(r);
				if ((boolean)r == true) {
					ret = rs.getString("����");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	public String Get_siweixiguan_fenxi_duituxiang() {
		float lixing = Float.valueOf(output.reason5);
		float ganxing = Float.valueOf(output.Sensibility5);
		System.out.println("lixing:" + lixing + ",ganxing:" + ganxing);
		
		String ret = null;
		Connection conn = BaseDataBaseDao.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();

			String sql = String.format("SELECT * FROM `doc_siweixiguan` WHERE `type` = '����' AND `���` = '��ͼ��' ");
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) { // loop
				String condition = rs.getString("condition");
				System.out.println("condition:" + condition);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("lixing", lixing);
				map.put("ganxing", ganxing);
				Object r = DyMethodUtil.invokeMethod(condition, map);
				System.out.println(r);
				if ((boolean)r == true) {
					ret = rs.getString("����");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public String Get_xiantianxingweidongji_fenxi() {
		float dongji = Float.valueOf(output.motivation);
		System.out.println("dongji:" + dongji);
		
		String ret = null;
		Connection conn = BaseDataBaseDao.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();

			String sql = String.format("SELECT * FROM `doc_xingwei_dongji` WHERE `type` = '����'");
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) { // loop
				String condition = rs.getString("condition");
				System.out.println("condition:" + condition);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("dongji", dongji);
				Object r = DyMethodUtil.invokeMethod(condition, map);
				System.out.println(r);
				if ((boolean)r == true) {
					ret = rs.getString("fenxi");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public String[] Get_xiantianxuexifengge() {
		float shijue = output.Visual;
		float tingjue = output.AuditorySense;
		float tijue = output.Somatosensory;
		
		System.out.println("shijue:" + shijue + ",tingjue:" + tingjue + ",tijue:" + tijue);
		
		String ret[] = new String[2];
		Connection conn = BaseDataBaseDao.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();

			String sql = String.format("SELECT * FROM `doc_xuexifengge` WHERE `type` = '����'");
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) { // loop
				String condition = rs.getString("condition");
				System.out.println("condition:" + condition);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("shijue", shijue);
				map.put("tingjue", tingjue);
				map.put("tijue", tijue);
				Object r = DyMethodUtil.invokeMethod(condition, map);
				System.out.println(r);
				if ((boolean)r == true) {
					ret[0] = rs.getString("fenlei");
					ret[1] = rs.getString("fenxi"); 
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public String Get_gexingtezhi1() {
		float shijue = output.Visual;
		float tingjue = output.AuditorySense;
		float tijue = output.Somatosensory;
		
		System.out.println("shijue:" + shijue + ",tingjue:" + tingjue + ",tijue:" + tijue);
		
		String ret = null;
		Connection conn = BaseDataBaseDao.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();

			String sql = String.format("SELECT * FROM `doc_suoyou_xingge_miaosu` WHERE 1");
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) { // loop
				String condition = rs.getString("condition");
				System.out.println("condition:" + condition);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("shijue", shijue);
				map.put("tingjue", tingjue);
				map.put("tijue", tijue);
				Object r = DyMethodUtil.invokeMethod(condition, map);
				System.out.println(r);
				if ((boolean)r == true) {
					ret = rs.getString("fenlei");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}
