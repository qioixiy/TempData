package com.xxx.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import com.mysql.jdbc.PreparedStatement;
import com.xxx.zip.UnZip;
import com.xxx.zip.Zip;

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
		// ��ʼ��·��
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
		
		//http://localhost:8080/TempData//ajax?subFunc=saveRcData&zhiwei=L2&wenxing=As&RCL=1&RCR=2
		String CollectUserID = "2";
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
		for (int i = 1; i < wenxing.length; i++) {
			if (wenxing[i] == wenxing_code) {
				wenxingNum = i;
			}
		}
		String RCL = request.getParameter("RCL");
		String RCR = request.getParameter("RCR");
		
		System.out.println("zhiwei:" + zhiwei + ",wenxing:" + wenxing_code + ",RCL:" + RCL + ",RCR:" + RCR);
		
		Connection conn = BaseDataBaseDao.getConnection();
		String sql = String.format("SELECT * FROM `tempinter` WHERE userid = %s", CollectUserID);
		sql = String.format("UPDATE `tempdata`.`tempinter` SET `%stemp` = '%d',`%sRCL` = '%s',`%sRCR` = '%s' WHERE `tempinter`.`userid` =%s;",
				zhiwei, wenxingNum,
				zhiwei, RCL,
				zhiwei, RCR,
				CollectUserID);
		System.out.println(sql);
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if(result>0) {
				System.out.println("executeQuery ok");
				ret = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
	}
	
	int importPackage(HttpServletRequest request, HttpServletResponse response
			,String filePath, String targetPath)
	{
		int ret = 0;
		//unpackage
		String zipFilePath = filePath;
		String destDir = targetPath;
		UnZip.unZip(zipFilePath, destDir);
		
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
		Statement stmt;
		ResultSet result = null;
		try {
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
				String age = result.getString("birthday");
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
				jsonObject.put("birthday", birthday);
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
				System.out.println("can't find");
				ret = -1;
			}
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
				return -2;
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
		String zipFile = FprCap_data + "/" + Userid + ".zip";
		String zipDir = FprCap_data + "/" + Userid;
		
		System.out.println("zipFile:" + zipFile);
		System.out.println("zipDir:" + zipDir);
		
		if (!(new File(zipDir)).isDirectory()) {
			System.out.println(zipDir + " is not a dir");
			return -1;
		}
		
		exportCustomerInfo(Userid, zipDir);
		
		Zip.zip(zipDir, zipFile);
		String url = basePath + "images/FprCap/data/" + Userid + ".zip";
		System.out.println("zip url " + url);
		try {
			response.getWriter().append(url);
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
				String UserName = new String(_UserName.getBytes("ISO-8859-1"), "UTF-8");
				String UserNumber = new String(_UserNumber.getBytes("ISO-8859-1"), "UTF-8");
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
				importPackage(request, response, importPackageFilePath, FprCap_data);
				response.getWriter().append("importPackage");
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
			default:
				System.out.println("unkown command");
			}
		}
		response.getWriter().append("");
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
