package com.xxx.utils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.xxx.zip.Zip;

import cn.fingerdata.dao1.BaseDataBaseDao;

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
		// ³õÊ¼»¯Â·¾¶
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
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
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
				break;
			case "exportPackage":
				int userid = 2;
				String zipFile = FprCap_data + ".zip";
				Zip.zip(FprCap_data, zipFile);
				String url = basePath + "images/FprCap/data.zip";
				System.out.println("zip url " + url);
				response.getWriter().append(url);
				break;
			case "importPackage":
				break;
			case "saveRcData":
				saveRcData(request, response);
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
