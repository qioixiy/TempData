package com.xxx.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.FprCap.*;
import com.FprCap.FprCap;
import com.havenliu.document.GenTableAllData;
import com.mysql.jdbc.PreparedStatement;
import com.xxx.zip.UnZip;
import com.xxx.zip.Zip;

import cn.fingerdata.bean.Customer;
import cn.fingerdata.dao.impl.CustomerDaoImpl;
import cn.fingerdata.dao1.BaseDataBaseDao;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ajax
 */
@WebServlet("/ajax")
public class ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String FprCap_Root = "";
	private String FprCap_data = FprCap_Root + "/data";
	private String FprCap_tmp = FprCap_Root + "/tmp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ajax() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletCtx = config.getServletContext();
		// 初始化路径
		FprCap_Root = servletCtx.getRealPath("/images/FprCap");
		FprCap_data = servletCtx.getRealPath("/images/FprCap/data");
		FprCap_tmp = servletCtx.getRealPath("/images/FprCap/tmp");
		System.out.println("FprCap_Root:" + FprCap_Root);
		System.out.println("FprCap_data:" + FprCap_data);
		System.out.println("FprCap_tmp:" + FprCap_tmp);

		if (!(new java.io.File(FprCap_Root).isDirectory())) {
			new java.io.File(FprCap_Root).mkdir();
			System.out.println("create dir " + FprCap_Root);
		}
		if (!(new java.io.File(FprCap_data).isDirectory())) {
			new java.io.File(FprCap_data).mkdir();
			System.out.println("create dir " + FprCap_data);
		}
		if (!(new java.io.File(FprCap_tmp).isDirectory())) {
			new java.io.File(FprCap_tmp).mkdir();
			System.out.println("create dir " + FprCap_tmp);
		}
	}

	private boolean saveRcData(HttpServletRequest request, HttpServletResponse response)
	{
		boolean ret = false;
		
		//http://localhost:8080/FPC//ajax?subFunc=saveRcData&zhiwei=L2&wenxing=As&RCL=1&RCR=2
		String userid = request.getParameter("userid");
		String zhiwei = request.getParameter("zhiwei");
		String wenxing_code = request.getParameter("wenxing");
		String wenxing[] = new String[30];
		int index = 1;
		wenxing[index++] = "Ws";
		wenxing[index++] = "Wt";
		wenxing[index++] = "We";
		wenxing[index++] = "Wc";
		wenxing[index++] = "Wd";
		wenxing[index++] = "Wi";
		wenxing[index++] = "Wu";
		wenxing[index++] = "UC";
		wenxing[index++] = "Wr";
		wenxing[index++] = "Rc";
		wenxing[index++] = "Lu";
		wenxing[index++] = "Lr";
		wenxing[index++] = "Rf";
		wenxing[index++] = "Lf";
		wenxing[index++] = "As";
		wenxing[index++] = "Ae";
		wenxing[index++] = "At";
		wenxing[index++] = "AU";
		wenxing[index++] = "Ar";
		wenxing[index++] = "Xw";
		wenxing[index++] = "Xu";
		wenxing[index++] = "Xa";
		wenxing[index++] = "Mf";
		wenxing[index++] = "Ma";
		int wenxingNum = 1;
		for (int i = 1; i < wenxing.length && wenxing[i] != null; i++) {
			System.out.println("wenxing[i]:" + wenxing[i] + ",wenxing_code:" + wenxing_code);
			if (wenxing[i].equals(wenxing_code)) {
				wenxingNum = i;
			}
		}
		System.out.println("wenxingNum:" + wenxingNum);
		String RCL = request.getParameter("RCL");
		String RCR = request.getParameter("RCR");
		
		System.out.println("userid:" + userid + ",zhiwei:" + zhiwei + ",wenxing:" + wenxing_code + ",RCL:" + RCL + ",RCR:" + RCR);
		
		try {
			Connection conn = BaseDataBaseDao.getConnection();
			Statement stmt;
			stmt = conn.createStatement();
			String sql = null;
			// find ?
			sql = String.format("SELECT count( * ) as rowCount FROM tempinter where userid = %s", userid);
			ResultSet result = stmt.executeQuery(sql);
			int count = 0;
			if (result.next()) {
				System.out.println("result.next() == true");
				count = result.getInt("rowCount");
			}
			if (count == 0) {
				// insert
				sql = String.format("INSERT INTO `tempinter` (`userid`, `%stemp`, `%sRCL`, `%sRCR`) VALUES (%s, '%d', %s, %s);",
						zhiwei, zhiwei, zhiwei,
						userid, wenxingNum, RCL, RCR);
			} else {
				//update
				sql = String.format("UPDATE `tempinter` SET `%stemp` = '%d',`%sRCL` = '%s',`%sRCR` = '%s' WHERE `tempinter`.`userid` =%s;",
						zhiwei, wenxingNum,
						zhiwei, RCL,
						zhiwei, RCR,
						userid);
			}
			
			System.out.println(sql);
			
			int result_i = stmt.executeUpdate(sql);
			if(result_i>0) {
				System.out.println("executeQuery ok");
				ret = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
	}
	
	@SuppressWarnings("static-access")
	int importPackage(HttpServletRequest request, HttpServletResponse response
			,String filePath, String targetPath)
	{
		int ret = -1;
		//unpackage
		String zipFilePath = filePath;
		String destDir = targetPath;
		UnZip.unZip(zipFilePath, destDir);
		
		//Userid
		String DirName =  (new File(zipFilePath)).getName();
		DirName = DirName.substring(0, DirName .lastIndexOf("."));
		
		// read json string
		String jsonFile = destDir + "/" + DirName + "/export.json";
		FileInputStream freader;  
		String jsonString = null;
        try {  
            freader = new FileInputStream(jsonFile);  
            @SuppressWarnings("resource")
			ObjectInputStream objectInputStream = new ObjectInputStream(freader);
            jsonString = (String)objectInputStream.readObject();
             System.out.println("jsonString:" + jsonString);
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }

        // import into database
        Connection conn = BaseDataBaseDao.getConnection();
        Statement stmt;
		try {
			boolean customer_find = false;
			boolean tempimage_find = false;
			boolean tempinter_find = false;
			
			stmt = conn.createStatement();
			// customer_find
			String sql = String.format("SELECT * FROM `customer` WHERE userid = %s", DirName);
			System.out.println(sql);
			ResultSet result = stmt.executeQuery(sql);
			if (result.next()) {
				customer_find = true;
			}
			// tempimage_find
			sql = String.format("SELECT * FROM `tempimage` WHERE userid = %s", DirName);
			System.out.println(sql);
			result = stmt.executeQuery(sql);
			if (result.next()) {
				tempimage_find = true;
			}
			// tempinter_find
			sql = String.format("SELECT * FROM `tempinter` WHERE userid = %s", DirName);
			System.out.println(sql);
			result = stmt.executeQuery(sql);
			if (result.next()) {
				tempinter_find = true;
			}
			// insert
			if (!customer_find && !tempimage_find && !tempinter_find) {
				System.out.println("insert start");
				System.out.println("jsonString:" + jsonString);
				JSONObject josnObject = JSONObject.fromObject(jsonString);
				JSONObject obj = josnObject.getJSONObject("customer");
				JSONObject obj2 = josnObject.getJSONObject("tempimage");
				JSONObject obj3 = josnObject.getJSONObject("tempinter");
				System.out.println("josnObject:" + josnObject);
				System.out.println(obj);
				System.out.println(obj2);
				System.out.println(obj3);
				
				// customer
				String insert_sql = String.format("INSERT INTO customer (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) VALUES (%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d, '%s', '%s', %d, '%s', '%s')",
						//"id",
						"userid",
						"name",
						"gender",
						"birthday",
						"age",
						"version",
						"collectDate",
						"constellation",
						"bloodtype",
						"fatherName",
						"farBirthday",
						"fphone",
						"matherName",
						"marBirthday",
						"mphone",
						"career",
						"address",
						"phone",
						"QQ",
						"MSN",
						"leftATD",
						"rightATD",
						"note",
						"collId",
						"collName",
						"colldate",
						"disId",
						"disName",
						"disdate",
						
						//obj.getInt("id"),
						obj.getInt("userid"),
						obj.getString("name"),
						obj.getString("gender"),
						obj.getString("birthday"),
						obj.getString("age"),
						obj.getString("version"),
						obj.getString("collectDate"),
						obj.getString("constellation"),
						obj.getString("bloodtype"),
						obj.getString("fatherName"),
						obj.getString("farBirthday"),
						obj.getString("fphone"),
						obj.getString("matherName"),
						obj.getString("marBirthday"),
						obj.getString("mphone"),
						obj.getString("career"),
						obj.getString("address"),
						obj.getString("phone"),
						obj.getString("QQ"),
						obj.getString("MSN"),
						obj.getString("leftATD"),
						obj.getString("rightATD"),
						obj.getString("note"),
						obj.getInt("collId"),
						obj.getString("collName"),
						obj.getString("colldate"),
						obj.getInt("disId"),
						obj.getString("disName"),
						obj.getString("disdate"));
				System.out.println(insert_sql);
				if (stmt.executeUpdate(insert_sql) > 0) {
					System.out.println("customer 插入成功");
					ret = 0;
				} else {
					System.out.println("customer 插入失败");
					try {
						response.getWriter().append("插入数据失败，已经存在该信息？");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				// tempimage
				insert_sql = String.format("INSERT INTO tempimage (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) VALUES (%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
						"userid", 
						"L1post", "L1left", "L1right",
						"L2post", "L2left", "L2right",
						"L3post", "L3left", "L3right",
						"L4post", "L4left", "L4right",
						"L5post", "L5left", "L5right",
						"R1post", "R1left", "R1right",
						"R2post", "R2left", "R2right",
						"R3post", "R3left", "R3right",
						"R4post", "R4left", "R4right",
						"R5post", "R5left", "R5right",
						obj2.getInt("userid"), 
						obj2.getString("L1post"), obj2.getString("L1left"), obj2.getString("L1right"),
						obj2.getString("L2post"), obj2.getString("L2left"), obj2.getString("L2right"),
						obj2.getString("L3post"), obj2.getString("L3left"), obj2.getString("L3right"),
						obj2.getString("L4post"), obj2.getString("L4left"), obj2.getString("L4right"),
						obj2.getString("L5post"), obj2.getString("L5left"), obj2.getString("L5right"),
						obj2.getString("R1post"), obj2.getString("R1left"), obj2.getString("R1right"),
						obj2.getString("R2post"), obj2.getString("R2left"), obj2.getString("R2right"),
						obj2.getString("R3post"), obj2.getString("R3left"), obj2.getString("R3right"),
						obj2.getString("R4post"), obj2.getString("R4left"), obj2.getString("R4right"),
						obj2.getString("R5post"), obj2.getString("R5left"), obj2.getString("R5right"));
				System.out.println(insert_sql);
				if (stmt.executeUpdate(insert_sql) > 0) {
					System.out.println("tempimage 插入成功");
					ret = 0;
				} else {
					System.out.println("tempimage 插入失败");
					try {
						response.getWriter().append("插入数据失败，已经存在该信息？");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				// tempinter
				insert_sql = String.format("INSERT INTO tempinter (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) VALUES (%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
						
						"userid",
						"name",
						"L1temp",
						"L1RCL",
						"L1RCR",
						"L2temp",
						"L2RCL",
						"L2RCR",
						"L3temp",
						"L3RCL",
						"L3RCR",
						"L4temp",
						"L4RCL",
						"L4RCR",
						"L5temp",
						"L5RCL",
						"L5RCR",
						"R1temp",
						"R1RCL",
						"R1RCR",
						"R2temp",
						"R2RCL",
						"R2RCR",
						"R3temp",
						"R3RCL",
						"R3RCR",
						"R4temp",
						"R4RCL",
						"R4RCR",
						"R5temp",
						"R5RCL",
						"R5RCR",
						
				//obj3.get("Inter_id"),
				obj3.get("userid"),
				obj3.get("name"),
				obj3.get("L1temp"),
				obj3.get("L1RCL"),
				obj3.get("L1RCR"),
				obj3.get("L2temp"),
				obj3.get("L2RCL"),
				obj3.get("L2RCR"),
				obj3.get("L3temp"),
				obj3.get("L3RCL"),
				obj3.get("L3RCR"),
				obj3.get("L4temp"),
				obj3.get("L4RCL"),
				obj3.get("L4RCR"),
				obj3.get("L5temp"),
				obj3.get("L5RCL"),
				obj3.get("L5RCR"),
				obj3.get("R1temp"),
				obj3.get("R1RCL"),
				obj3.get("R1RCR"),
				obj3.get("R2temp"),
				obj3.get("R2RCL"),
				obj3.get("R2RCR"),
				obj3.get("R3temp"),
				obj3.get("R3RCL"),
				obj3.get("R3RCR"),
				obj3.get("R4temp"),
				obj3.get("R4RCL"),
				obj3.get("R4RCR"),
				obj3.get("R5temp"),
				obj3.get("R5RCL"),
				obj3.get("R5RCR"));
				System.out.println(insert_sql);
				if (stmt.executeUpdate(insert_sql) > 0) {
					System.out.println("tempinter 插入成功");
					ret = 0;
				} else {
					System.out.println("tempinter 插入失败");
					try {
						response.getWriter().append("插入数据失败，已经存在该信息？");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				// update ?
				System.out.println("customer find");
				try {
					response.getWriter().append("插入数据失败，已经存在该信息");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	int exportCustomerInfo(String Userid, String Dir)
	{
		int ret = 0;
		Connection conn = BaseDataBaseDao.getConnection();

		JSONObject jsonObjectRoot = new JSONObject();
		JSONObject jsonObject = new JSONObject();
		JSONObject jsonObject1 = new JSONObject();
		JSONObject jsonObject2 = new JSONObject();
		Statement stmt;
		ResultSet result = null;
		try { 
			// customer
			stmt = conn.createStatement();
			String sql = String.format("SELECT * FROM `customer` WHERE userid = %s", Userid);
			System.out.println(sql);
			result = stmt.executeQuery(sql);
			if(result.next()) {
				System.out.println("executeQuery ok");
				//id 	userid 	name 	gender 	birthday 	age 	version 	collectDate
				// constellation 	bloodtype 	fatherName 	farBirthday 	fphone 	matherName 	
				// marBirthday 	mphone 	career 	address 	phone 	QQ 	MSN 	leftATD 	rightATD 	
				// note 	collId 	collName 	colldate 	disId 	disName 	disdate
				int id = result.getInt("id");
				int userid = result.getInt("userid");
				String name = result.getString("name");
				String gender = result.getString("gender");
				String birthday = result.getString("birthday");
				String age = result.getString("age");
				String version = result.getString("version");
				String collectDate = result.getString("collectDate");;
				String constellation = result.getString("constellation");
				String bloodtype = result.getString("bloodtype");
				String fatherName = result.getString("fatherName");
				String farBirthday = result.getString("farBirthday");
				String fphone = result.getString("fphone");
				String matherName = result.getString("matherName");
				String marBirthday = result.getString("marBirthday");
				String mphone = result.getString("mphone");
				String career = result.getString("career");
				String address = result.getString("address");
				String phone = result.getString("phone");
				String QQ = result.getString("QQ");
				String MSN = result.getString("MSN");
				String leftATD = result.getString("leftATD");
				String rightATD = result.getString("rightATD");
				String note = result.getString("note");
				int collId = result.getInt("collId");
				String collName = result.getString("collName");
				String colldate = result.getString("colldate");
				int disId = result.getInt("disId");
				String disName = result.getString("disName");
				String disdate = result.getString("disdate");
				
				jsonObject.put("id", id);
				jsonObject.put("userid", userid);
				jsonObject.put("name", name);
				jsonObject.put("gender", gender);
				jsonObject.put("birthday", birthday);
				jsonObject.put("age", age);
				jsonObject.put("version", version);
				jsonObject.put("collectDate", collectDate);
				jsonObject.put("constellation", constellation);
				jsonObject.put("bloodtype", bloodtype);
				jsonObject.put("fatherName", fatherName);
				jsonObject.put("farBirthday", farBirthday);
				jsonObject.put("fphone", fphone);
				jsonObject.put("matherName", matherName);
				jsonObject.put("marBirthday", marBirthday);
				jsonObject.put("mphone", mphone);
				jsonObject.put("career", career);
				jsonObject.put("address", address);
				jsonObject.put("phone", phone);
				jsonObject.put("QQ", QQ);
				jsonObject.put("MSN", MSN);
				jsonObject.put("leftATD", leftATD);
				jsonObject.put("rightATD", rightATD);
				jsonObject.put("note", note);
				jsonObject.put("collId", collId);
				jsonObject.put("collName", collName);
				jsonObject.put("colldate", colldate);
				jsonObject.put("disId", disId);
				jsonObject.put("disName", disName);
				jsonObject.put("disdate", disdate);
			} else {
				System.out.println("can't find customer");
				ret = -1;
			}
			
			// tempimage
			sql = String.format("SELECT * FROM `tempimage` WHERE userid = %s", Userid);
			System.out.println(sql);
			if (result != null) result.close();
			stmt.close();
			stmt = conn.createStatement();
			result = stmt.executeQuery(sql);
			if(result.next()) {
				System.out.println("executeQuery tempimage ok ");
				int Image_id = result.getInt("Image_id");
				int userid = result.getInt("userid");
				String L1post = result.getString("L1post");
				String L1left = result.getString("L1left");
				String L1right = result.getString("L1right");
				String L2post = result.getString("L2post");
				String L2left = result.getString("L2left");
				String L2right = result.getString("L2right");
				String L3post = result.getString("L3post");
				String L3left = result.getString("L3left");
				String L3right = result.getString("L3right");
				String L4post = result.getString("L4post");
				String L4left = result.getString("L4left");
				String L4right = result.getString("L4right");
				String L5post = result.getString("L5post");
				String L5left = result.getString("L5left");
				String L5right = result.getString("L5right");
				String R1post = result.getString("R1post");
				String R1left = result.getString("R1left");
				String R1right = result.getString("R1right");
				String R2post = result.getString("R2post");
				String R2left = result.getString("R2left");
				String R2right = result.getString("R2right");
				String R3post = result.getString("R3post");
				String R3left = result.getString("R3left");
				String R3right = result.getString("R3right");
				String R4post = result.getString("R4post");
				String R4left = result.getString("R4left");
				String R4right = result.getString("R4right");
				String R5post = result.getString("R5post");
				String R5left = result.getString("R5left");
				String R5right = result.getString("R5right");
				
				jsonObject1.put("Image_id", Image_id);
				jsonObject1.put("userid", userid);
				jsonObject1.put("L1post", L1post);
				jsonObject1.put("L1left", L1left);
				jsonObject1.put("L1right", L1right);
				jsonObject1.put("L2post", L2post);
				jsonObject1.put("L2left", L2left);
				jsonObject1.put("L2right", L2right);
				jsonObject1.put("L3post", L3post);
				jsonObject1.put("L3left", L3left);
				jsonObject1.put("L3right", L3right);
				jsonObject1.put("L4post", L4post);
				jsonObject1.put("L4left", L4left);
				jsonObject1.put("L4right", L4right);
				jsonObject1.put("L5post", L5post);
				jsonObject1.put("L5left", L5left);
				jsonObject1.put("L5right", L5right);
				jsonObject1.put("R1post", R1post);
				jsonObject1.put("R1left", R1left);
				jsonObject1.put("R1right", R1right);
				jsonObject1.put("R2post", R2post);
				jsonObject1.put("R2left", R2left);
				jsonObject1.put("R2right", R2right);
				jsonObject1.put("R3post", R3post);
				jsonObject1.put("R3left", R3left);
				jsonObject1.put("R3right", R3right);
				jsonObject1.put("R4post", R4post);
				jsonObject1.put("R4left", R4left);
				jsonObject1.put("R4right", R4right);
				jsonObject1.put("R5post", R5post);
				jsonObject1.put("R5left", R5left);
				jsonObject1.put("R5right", R5right);
			} else {
				System.out.println("executeQuery tempimage fail ");
				//return -2;
			}
			
			// tempinter
			sql = String.format("SELECT * FROM `tempinter` WHERE userid = %s", Userid);
			System.out.println(sql);
			if (result != null)
				result.close();
			stmt.close();
			stmt = conn.createStatement();
			result = stmt.executeQuery(sql);
			if (result.next()) {
				// Inter_id 	userid 	name 	L1temp 	L1RCL 	L1RCR 	L2temp 	L2RCL 	L2RCR 	L3temp 	L3RCL 	L3RCR 	L4temp 	L4RCL 	L4RCR 	L5temp 	L5RCL 	L5RCR
				// R1temp 	R1RCL 	R1RCR 	R2temp 	R2RCL 	R2RCR 	R3temp 	R3RCL 	R3RCR 	R4temp 	R4RCL 	R4RCR 	R5temp 	R5RCL 	R5RCR
				System.out.println("executeQuery tempinter ok ");
				
				int Inter_id = result.getInt("Inter_id");
				int userid = result.getInt("userid");
				String name = result.getString("name");
				String L1temp = result.getString("L1temp");
				String L1RCL = result.getString("L1RCL");
				String L1RCR = result.getString("L1RCR");
				String L2temp = result.getString("L2temp");
				String L2RCL = result.getString("L2RCL");
				String L2RCR = result.getString("L2RCR");
				String L3temp = result.getString("L3temp");
				String L3RCL = result.getString("L3RCL");
				String L3RCR = result.getString("L3RCR");
				String L4temp = result.getString("L4temp");
				String L4RCL = result.getString("L4RCL");
				String L4RCR = result.getString("L4RCR");
				String L5temp = result.getString("L5temp");
				String L5RCL = result.getString("L5RCL");
				String L5RCR = result.getString("L5RCR");
				String R1temp = result.getString("R1temp");
				String R1RCL = result.getString("R1RCL");
				String R1RCR = result.getString("R1RCR");
				String R2temp = result.getString("R2temp");
				String R2RCL = result.getString("R2RCL");
				String R2RCR = result.getString("R2RCR");
				String R3temp = result.getString("R3temp");
				String R3RCL = result.getString("R3RCL");
				String R3RCR = result.getString("R3RCR");
				String R4temp = result.getString("R4temp");
				String R4RCL = result.getString("R4RCL");
				String R4RCR = result.getString("R4RCR");
				String R5temp = result.getString("R5temp");
				String R5RCL = result.getString("R5RCL");
				String R5RCR = result.getString("R5RCR");

				jsonObject2.put("Inter_id", Inter_id);
				jsonObject2.put("userid", userid);
				jsonObject2.put("name", name);
				jsonObject2.put("L1temp", L1temp);
				jsonObject2.put("L1RCL", L1RCL);
				jsonObject2.put("L1RCR", L1RCR);
				jsonObject2.put("L2temp", L2temp);
				jsonObject2.put("L2RCL", L2RCL);
				jsonObject2.put("L2RCR", L2RCR);
				jsonObject2.put("L3temp", L3temp);
				jsonObject2.put("L3RCL", L3RCL);
				jsonObject2.put("L3RCR", L3RCR);
				jsonObject2.put("L4temp", L4temp);
				jsonObject2.put("L4RCL", L4RCL);
				jsonObject2.put("L4RCR", L4RCR);
				jsonObject2.put("L5temp", L5temp);
				jsonObject2.put("L5RCL", L5RCL);
				jsonObject2.put("L5RCR", L5RCR);
				jsonObject2.put("R1temp", R1temp);
				jsonObject2.put("R1RCL", R1RCL);
				jsonObject2.put("R1RCR", R1RCR);
				jsonObject2.put("R2temp", R2temp);
				jsonObject2.put("R2RCL", R2RCL);
				jsonObject2.put("R2RCR", R2RCR);
				jsonObject2.put("R3temp", R3temp);
				jsonObject2.put("R3RCL", R3RCL);
				jsonObject2.put("R3RCR", R3RCR);
				jsonObject2.put("R4temp", R4temp);
				jsonObject2.put("R4RCL", R4RCL);
				jsonObject2.put("R4RCR", R4RCR);
				jsonObject2.put("R5temp", R5temp);
				jsonObject2.put("R5RCL", R5RCL);
				jsonObject2.put("R5RCR", R5RCR);
			} else {
				System.out.println("executeQuery tempinter fail ");
				//return -2;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (result != null) result.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		jsonObjectRoot.put("customer", jsonObject);
		jsonObjectRoot.put("tempimage", jsonObject1);
		jsonObjectRoot.put("tempinter", jsonObject2);
		
		String jsonFile = Dir + "/export.json";
		String jsonString = jsonObjectRoot.toString();
		System.out.println(jsonString);
		FileOutputStream outStream = null;
		try {
			outStream = new FileOutputStream(jsonFile);
			try {
				@SuppressWarnings("resource")
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream);
				objectOutputStream.writeObject(jsonString);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				outStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileInputStream freader;  
        try {  
            freader = new FileInputStream(jsonFile);  
            @SuppressWarnings("resource")
			ObjectInputStream objectInputStream = new ObjectInputStream(freader);
            String jsonString1 = (String)objectInputStream.readObject();
             System.out.println("jsonString1:" + jsonString1);
             
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
		return ret;
	}
	
	int exportPackage(HttpServletRequest request, HttpServletResponse response, String basePath)
	{
		String Userid = request.getParameter("Userid");
		System.out.println(Userid);
		
		CustomerDaoImpl mCustomerDaoImpl = new CustomerDaoImpl();
		Customer mCustomer = mCustomerDaoImpl.getByuserid(Integer.parseInt(Userid));
		String UserName = mCustomer.getName();
		System.out.println("Userid:" + Userid + ", UserName:" + UserName);

		String fileName = UserName + "_" + Userid;
		String zipFile = FprCap_data + "/" + fileName + ".zip";
		String zipDir = FprCap_data + "/" + Userid;
		
		System.out.println("zipFile:" + zipFile);
		System.out.println("zipDir:" + zipDir);
		
		if (!(new File(zipDir)).isDirectory()) {
			System.out.println(zipDir + " is not a dir");
			return -1;
		}
		
		exportCustomerInfo(Userid, zipDir);
		
		Zip.zip(zipDir, zipFile);
		String url = basePath + "images/FprCap/data/" + fileName + ".zip";
		System.out.println("zip url " + url);
		try {
			String url_utf8 = URLEncoder.encode(url.toString(),"UTF-8");
			System.out.println("url_utf8:" + url_utf8);
			
			response.getWriter().append(url_utf8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	int login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("username:" + username + ",password:" + password);
		
		Connection conn = BaseDataBaseDao.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();

			String sql = String.format("SELECT * FROM `account` WHERE `username` = '%s' and `password` = '%s'",
					username, password);
			System.out.println(sql);
			ResultSet ret = stmt.executeQuery(sql);
			if(ret.next()) { // find
				System.out.println("executeQuery ok," + sql);
				System.out.println("find user");
				response.getWriter().append("success");
				HttpSession session = request.getSession(); 
				session.setAttribute("username", username);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}


	int add_user(HttpServletRequest request, HttpServletResponse response) {
		
		String uid = request.getParameter("uid");
		String username = request.getParameter("username");
		String fullname = request.getParameter("fullname");
		try {
			username = new String(username.getBytes("ISO-8859-1"), "GBK");
			fullname = new String(fullname.getBytes("ISO-8859-1"), "GBK");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return -1;
		}
		String password = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String privilege = request.getParameter("privilege");

		System.out.println("uid:" + uid
				+ ",username:" + username
				+ ",fullname:" + fullname
				+ ",password=" + password
				+ ",password2=" + password2
				+ ",privilege=" + privilege);
		
		Connection conn = BaseDataBaseDao.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();

			String sql = String.format("SELECT * FROM `account` WHERE `accountId` = '%s'",
					uid);
			System.out.println(sql);
			ResultSet ret = stmt.executeQuery(sql);
			if(ret.next()) { // find
				System.out.println("executeQuery ok," + sql);
				System.out.println("find user, but !!");
				response.getWriter().append("fail_uid");
				return -1;
			}
			
			sql = String.format("SELECT * FROM `account` WHERE `username` = '%s'",
					username);
			System.out.println(sql);
			ret = stmt.executeQuery(sql);
			if(ret.next()) { // find
				System.out.println("executeQuery ok," + sql);
				System.out.println("find user, but !!");
				response.getWriter().append("fail_username");
				return -2;
			}
			// insert
			 	 	 	
			sql = String.format("INSERT INTO account (%s, %s, %s, %s, %s) VALUES ('%s', '%s', '%s', '%s', '%s')"
					,"accountId", "username", "fullname", "password", "privilege"
					,uid , username, fullname, password, privilege);
			System.out.println(sql);
			if (stmt.executeUpdate(sql) > 0) {
				System.out.println("insert account success");
				response.getWriter().append("success");
			} else {
				System.out.println("insert account fail");
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	int delete_user(HttpServletRequest request, HttpServletResponse response) {
		
		String ids = request.getParameter("ids");

		System.out.println("ids:" + ids);
		
		String id_arr[] = ids.split(",");
		System.out.println("id_arr:" + id_arr.length);
		System.out.println("id_arr:" + id_arr[id_arr.length-1]);
		
		Connection conn = BaseDataBaseDao.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			
			int flag = 1;
			for (int i = 0;  i < id_arr.length; i++) {
				String id = id_arr[i];
				String sql = String.format("DELETE FROM `tempdata`.`account` WHERE `account`.`id` = %s",
						id);
				System.out.println(sql);
				if (stmt.executeUpdate(sql) > 0) {
					System.out.println("del account success");
				} else {
					flag = 0;
					System.out.println("del account fail");
				}
				if (flag == 1) {
					response.getWriter().append("success");
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	int update_userinfo(HttpServletRequest request, HttpServletResponse response) {
		
		String uid = request.getParameter("uid");
		String accountId = request.getParameter("accountId");
		String username = request.getParameter("username");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		String privilege = request.getParameter("privilege");
		try {
			fullname = new String(fullname.getBytes("ISO-8859-1"), "GBK");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return -1;
		}

		System.out.println("uid:" + uid
				+ ",accountId:" +accountId
				+ ",username:" + username
				+ ",fullname:" + fullname
				+ ",password=" + password
				+ ",privilege=" + privilege);
		
		Connection conn = BaseDataBaseDao.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String sql = String.format("UPDATE `account` SET `%s` = '%s', %s='%s', %s='%s', %s='%s', %s='%s' WHERE `id` ='%s'",
					"accountId", accountId,
					"username", username,
					"fullname",  fullname,
					"password", password, 
					"privilege", privilege,
					uid);
			System.out.println(sql);
			int ret = stmt.executeUpdate(sql);
			if(ret > 0) { // find
				System.out.println("executeQuery ok," + sql);
				System.out.println("update ok");
				response.getWriter().append("success");
				return 0;
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	int add_customer(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			String bianhao_s = (new String(request.getParameter("bianhao").getBytes("ISO-8859-1"), "GBK")).trim();
			System.out.println("bianhao_s:" + bianhao_s);
			if (bianhao_s ==null || bianhao_s == "") {
				return -3;
			}
			int bianhao = Integer.parseInt(bianhao_s);
			String xingming = new String(request.getParameter("xingming").getBytes("ISO-8859-1"), "GBK");
			String xingbie = new String(request.getParameter("xingbie").getBytes("ISO-8859-1"), "GBK");
			String chushenriqi = new String(request.getParameter("chushenriqi").getBytes("ISO-8859-1"), "GBK");
			String nianling = new String(request.getParameter("nianling").getBytes("ISO-8859-1"), "GBK");
			String banben = new String(request.getParameter("banben").getBytes("ISO-8859-1"), "GBK");
			String caijiriqi = new String(request.getParameter("caijiriqi").getBytes("ISO-8859-1"), "GBK");
			String xingzuo = new String(request.getParameter("xingzuo").getBytes("ISO-8859-1"), "GBK");
			String xuexing = new String(request.getParameter("xuexing").getBytes("ISO-8859-1"), "GBK");
			String fuqinxingming = new String(request.getParameter("fuqinxingming").getBytes("ISO-8859-1"), "GBK");
			String fuqinchushenriqi = new String(request.getParameter("fuqinchushenriqi").getBytes("ISO-8859-1"),
					"GBK");
			String fuqinshouji = new String(request.getParameter("fuqinshouji").getBytes("ISO-8859-1"), "GBK");
			String muqinxingming = new String(request.getParameter("muqinxingming").getBytes("ISO-8859-1"), "GBK");
			String muqinchushenriqi = new String(request.getParameter("muqinchushenriqi").getBytes("ISO-8859-1"),
					"GBK");
			String muqinshouji = new String(request.getParameter("muqinshouji").getBytes("ISO-8859-1"), "GBK");
			String zhiye = new String(request.getParameter("zhiye").getBytes("ISO-8859-1"), "GBK");
			String jiatingzhuzhi = new String(request.getParameter("jiatingzhuzhi").getBytes("ISO-8859-1"), "GBK");
			String dianhua = new String(request.getParameter("dianhua").getBytes("ISO-8859-1"), "GBK");
			String qq = new String(request.getParameter("qq").getBytes("ISO-8859-1"), "GBK");
			String msn = new String(request.getParameter("msn").getBytes("ISO-8859-1"), "GBK");
			String zuoatd = new String(request.getParameter("zuoatd").getBytes("ISO-8859-1"), "GBK");
			String youatd = new String(request.getParameter("youatd").getBytes("ISO-8859-1"), "GBK");
			String beizhu = new String(request.getParameter("beizhu").getBytes("ISO-8859-1"), "GBK");
			String caijishibianhao_s = new String(request.getParameter("caijishibianhao").getBytes("ISO-8859-1"),"GBK");
			if (caijishibianhao_s == "") caijishibianhao_s = "1";
			int caijishibianhao = Integer.parseInt(caijishibianhao_s);
			String caijishixingming = new String(request.getParameter("caijishixingming").getBytes("ISO-8859-1"),
					"GBK");
			String caiyangriqi = new String(request.getParameter("caiyangriqi").getBytes("ISO-8859-1"), "GBK");
			String pandushibianhao_s = new String(request.getParameter("pandushibianhao").getBytes("ISO-8859-1"), "GBK");
			if (pandushibianhao_s == "") pandushibianhao_s = "1";
			int pandushibianhao = Integer.parseInt(pandushibianhao_s);
			String pandushixingming = new String(request.getParameter("pandushixingming").getBytes("ISO-8859-1"),
					"GBK");
			String panduriqi = new String(request.getParameter("panduriqi").getBytes("ISO-8859-1"), "GBK");

			System.out.println("bianhao:" + bianhao);
			System.out.println("xingming:" + xingming);
			System.out.println("xingbie:" + xingbie);
			System.out.println("chushenriqi:" + chushenriqi);
			System.out.println("nianling:" + nianling);
			System.out.println("banben:" + banben);
			System.out.println("caijiriqi:" + caijiriqi);
			System.out.println("xingzuo:" + xingzuo);
			System.out.println("xuexing:" + xuexing);
			System.out.println("fuqinxingming:" + fuqinxingming);
			System.out.println("fuqinchushenriqi:" + fuqinchushenriqi);
			System.out.println("fuqinshouji:" + fuqinshouji);
			System.out.println("muqinxingming:" + muqinxingming);
			System.out.println("muqinchushenriqi:" + muqinchushenriqi);
			System.out.println("muqinshouji:" + muqinshouji);
			System.out.println("zhiye:" + zhiye);
			System.out.println("jiatingzhuzhi:" + jiatingzhuzhi);
			System.out.println("dianhua:" + dianhua);
			System.out.println("qq:" + qq);
			System.out.println("msn:" + msn);
			System.out.println("zuoatd:" + zuoatd);
			System.out.println("youatd:" + youatd);
			System.out.println("beizhu:" + beizhu);
			System.out.println("caijishibianhao:" + caijishibianhao);
			System.out.println("caijishixingming:" + caijishixingming);
			System.out.println("caiyangriqi:" + caiyangriqi);
			System.out.println("pandushibianhao:" + pandushibianhao);
			System.out.println("pandushixingming:" + pandushixingming);
			System.out.println("panduriqi:" + panduriqi);

			Connection conn = BaseDataBaseDao.getConnection();
			Statement stmt;
			try {
				stmt = conn.createStatement();
				String sql = String.format("SELECT * FROM `customer` WHERE `userid` = '%s'",
						bianhao);
				System.out.println(sql);
				ResultSet ret = stmt.executeQuery(sql);
				if(ret.next()) { // find
					System.out.println("executeQuery ok," + sql);
					System.out.println("find user, but !!");
					response.getWriter().append("fail_uid");
					return -1;
				}
				
				/* userid 	name 	gender 	birthday 	age 	version 	collectDate 	constellation 	bloodtype
				fatherName 	farBirthday 	fphone 	matherName 	marBirthday 	mphone 	career 	address 	phone
				QQ 	MSN 	leftATD 	rightATD 	note 	collId 	collName 	colldate 	disId 	disName 	disdate
				//*/
				// insert
				sql = String.format("INSERT INTO customer (%s, %s, %s, %s, %s,%s, %s, %s, %s, %s,%s, %s, %s, %s, %s,%s, %s, %s, %s, %s,%s, %s, %s, %s, %s,%s, %s, %s, %s) VALUES (%d, '%s', '%s', '%s', '%s','%s', '%s', '%s', '%s', '%s','%s', '%s', '%s', '%s', '%s','%s', '%s', '%s', '%s', '%s','%s', '%s', '%s', %d, '%s','%s', %d, '%s', '%s')",
						"userid",
						"name",
						"gender",
						"birthday",
						"age",
						"version",
						"collectDate",
						"constellation",
						"bloodtype",
						"fatherName",
						"farBirthday",
						"fphone",
						"matherName",
						"marBirthday",
						"mphone",
						"career",
						"address",
						"phone",
						"QQ",
						"MSN",
						"leftATD",
						"rightATD",
						"note",
						"collId",
						"collName",
						"colldate",
						"disId",
						"disName",
						"disdate",
						
						bianhao,
				xingming,
				xingbie,
				chushenriqi,
				nianling,
				banben,
				caijiriqi,
				xingzuo,
				xuexing,
				fuqinxingming,
				fuqinchushenriqi,
				fuqinshouji,
				muqinxingming,
				muqinchushenriqi,
				muqinshouji,
				zhiye,
				jiatingzhuzhi,
				dianhua,
				qq,
				msn,
				zuoatd,
				youatd,
				beizhu,
				caijishibianhao,
				caijishixingming,
				caiyangriqi,
				pandushibianhao,
				pandushixingming,
				panduriqi);
				
				System.out.println(sql);
				
				if (stmt.executeUpdate(sql) > 0) {
					System.out.println("插入成功");

					response.getWriter().append("success");
				} else {
					System.out.println("插入失败");
					try {
						response.getWriter().append("插入数据失败，已经存在该信息？");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
int del_customer(HttpServletRequest request, HttpServletResponse response) {
		
		String ids = request.getParameter("ids");

		System.out.println("ids:" + ids);
		
		String id_arr[] = ids.split(",");
		System.out.println("id_arr:" + id_arr.length);
		System.out.println("id_arr:" + id_arr[id_arr.length-1]);
		
		Connection conn = BaseDataBaseDao.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			
			int flag = 1;
			for (int i = 0;  i < id_arr.length; i++) {
				String id = id_arr[i];
				String sql = String.format("DELETE FROM `tempdata`.`customer` WHERE `userid` = %s",
						id);
				System.out.println(sql);
				if (stmt.executeUpdate(sql) > 0) {
					System.out.println("del customer success");
				} else {
					flag = 0;
					System.out.println("del customer fail");
				}
				if (flag == 1) {
					response.getWriter().append("success");
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

int export_doc(HttpServletRequest request, HttpServletResponse response) {
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/";
	System.out.println("export_doc start");
	GenTableAllData mGenTableAllData = new GenTableAllData();
	String userid = request.getParameter("userid");
		
	try {
		mGenTableAllData.run(userid, FprCap_tmp + "/export_doc/");
	} finally {
		System.out.println("export_doc end");
	}

	try {
		System.out.println("make export_doc zip package start ");
		String Userid = request.getParameter("userid");
		System.out.println("Userid:" + Userid);
		
		CustomerDaoImpl mCustomerDaoImpl = new CustomerDaoImpl();
		Customer mCustomer = mCustomerDaoImpl.getByuserid(Integer.parseInt(Userid));
		String UserName = mCustomer.getName();
		System.out.println("Userid:" + Userid + ", UserName:" + UserName);

		String fileName = UserName + "_" + Userid;
		String zipFile = FprCap_tmp + "/" + fileName + ".zip";
		String zipDir = FprCap_tmp + "/export_doc/";
		
		System.out.println("zipFile:" + zipFile);
		System.out.println("zipDir:" + zipDir);
		
		if (!(new File(zipDir)).isDirectory()) {
			System.out.println(zipDir + " is not a dir");
			return -1;
		}
		
		exportCustomerInfo(Userid, zipDir);
		
		Zip.zip(zipDir, zipFile);
		String path1 = "images/FprCap/tmp/" + fileName + ".zip";
		String url = basePath + path1;
		System.out.println("zip url " + url);
		response.getWriter().append(path1);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(); 
		String mCollectUserID = (String)session.getAttribute("CollectUserID");
		if (mCollectUserID == null) {
			//System.out.println("CollectUserID == null");
			//return;
		}

		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";

		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		String subFunc = request.getParameter("subFunc");
		System.out.println("subFunc:" + subFunc);
		if (null != subFunc) {
			switch (subFunc) {
			case "captureFrame":

				String FingerPostion = request.getParameter("FingerPostion");
				String _UserName = request.getParameter("UserName");
				String _UserNumber = request.getParameter("UserNumber");
				String UserName = new String(_UserName.getBytes("ISO-8859-1"), "GBK");
				String UserNumber = new String(_UserNumber.getBytes("ISO-8859-1"), "GBK");
				System.out.println(
						"FingerPostion:" + FingerPostion + ",UserName:" + UserName + ",UserNumber:" + UserNumber);

				String DirName = /*UserName + */UserNumber;
				
				String RealDirName = FprCap_data + "/" + DirName;
				if (!(new java.io.File(RealDirName).isDirectory())) {
					new java.io.File(RealDirName).mkdir();
					System.out.println("create dir " + RealDirName);
				}
				
				String fileName = FingerPostion + "_" + MyDate.getFormatDate() + ".bmp";

				String LocalFilePath = FprCap_data + "/" + DirName + "/" + fileName;
				System.out.println("LocalFilePath:" + LocalFilePath);
				
				String tmpFilePath = FprCap_tmp + "";
				if (0 == FprCap.GetFrame(LocalFilePath)) {
					String url = basePath + "/images/FprCap/data/" + DirName + "/" + fileName;
					System.out.println("image url " + url);
					response.getWriter().append(url);
				} else {
					System.out.println("GetFrame field");
					response.getWriter().append("filed");
					File file = new File(LocalFilePath);
					if (file.isFile() && file.exists()) {
						file.delete();
					}

					return;
				}

				Map<String, String> map = new HashMap<String, String>();
				map.put("L1R", "L1right");
				map.put("L1L", "L1left");
				map.put("L1C", "L1post");
				map.put("L2R", "L2right");
				map.put("L2L", "L2left");
				map.put("L2C", "L2post");
				map.put("L2R", "L2right");
				map.put("L3L", "L3left");
				map.put("L3C", "L3post");
				map.put("L3R", "L3right");
				map.put("L4L", "L4left");
				map.put("L4C", "L4post");
				map.put("L4R", "L4right");
				map.put("L5L", "L5left");
				map.put("L5C", "L5post");
				map.put("L5R", "L5right");

				map.put("R1R", "R1right");
				map.put("R1L", "R1left");
				map.put("R1C", "R1post");
				map.put("R2R", "R2right");
				map.put("R2L", "R2left");
				map.put("R2C", "R2post");
				map.put("R2R", "R2right");
				map.put("R3L", "R3left");
				map.put("R3C", "R3post");
				map.put("R3R", "R3right");
				map.put("R4L", "R4left");
				map.put("R4C", "R4post");
				map.put("R4R", "R4right");
				map.put("R5L", "R5left");
				map.put("R5C", "R5post");
				map.put("R5R", "R5right");
				
				// L1post
				String postion = FingerPostion;
				postion = map.get(FingerPostion);
				String filePath = String.format("/%s/%s", _UserNumber, fileName);
				System.out.println("filePath:" + filePath);
				try {
					int result = 0;
					Connection conn = BaseDataBaseDao.getConnection();
					Statement stmt;
					stmt = conn.createStatement();

					String sql = String.format("SELECT * FROM `tempimage` WHERE `userid` =%s", _UserNumber);
					System.out.println(sql);
					ResultSet ret = stmt.executeQuery(sql);
					if(ret.next()) { // find
						System.out.println("executeQuery ok," + sql);
						System.out.println("find update");
						// update
						sql = String.format("UPDATE `tempimage` SET `%s` = '%s' WHERE `userid` =%s;",
								postion, filePath, _UserNumber);
						System.out.println(sql);
						result = stmt.executeUpdate(sql);
						if(result>0) {
							System.out.println("executeUpdate ok");
						} else {
							System.out.println("executeUpdate fail");
						}
					} else { // not find
						Connection conn_insert = BaseDataBaseDao.getConnection();
						Statement stmt_insert = conn_insert.createStatement();
						//not find need insert
						System.out.println("not find need insert");
						sql = String.format("INSERT INTO tempimage (userid, %s) VALUES ('%s', '%s')"
								, postion, _UserNumber, filePath);
						System.out.println(sql);
						java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
						//pstmt.setString(1, _UserNumber);
						//pstmt.setString(2, filePath);
						result = pstmt.executeUpdate();
						if(result>0) {
							System.out.println("executeUpdate ok");
						} else {
							System.out.println("executeUpdate fail");
						}
						//*/
					}
				
					if(result>0) {
						System.out.println("executeQuery ok");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "exportPackage":
				if (0 != exportPackage(request, response, basePath)) {
					response.getWriter().append("fail");
				}
				break;
			case "importPackage":
				String importPackageFilePath = request.getParameter("file_path");
				System.out.println("importPackage start, importPackageFilePath=" + importPackageFilePath);
				int ret = importPackage(request, response, importPackageFilePath, FprCap_data);
				if (ret < 0) {
					response.getWriter().append("importPackage fail");
					System.out.println("importPackage fail");
				} else {
					response.getWriter().append("success");
				}
				System.out.println("importPackage end");
				break;
			case "saveRcData":
				if (saveRcData(request, response)) {
					response.getWriter().append("success");
					System.out.println("saveRcData ok");
				} else{
					System.out.println("saveRcData error");
				}
				break;
			case "login":
				login(request, response);
				break;
			case "add_user":
				add_user(request, response);
				break;
			case "del_user":
				delete_user(request, response);
				break;
			case "update_userinfo":
				update_userinfo(request, response);
				break;
			case "add_customer":
				add_customer(request, response);
				break;
			case "del_customer":
				del_customer(request, response);
				break;
			case "export_doc":
				export_doc(request, response);
				break;
			default:
				System.out.println("unkown command");
			}
		}
		response.getWriter().append("");
		
		System.gc();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doHead(HttpServletRequest, HttpServletResponse)
	 */
	protected void doHead(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doTrace(HttpServletRequest, HttpServletResponse)
	 */
	protected void doTrace(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
