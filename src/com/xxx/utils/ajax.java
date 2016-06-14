package com.xxx.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FprCap.*;
import com.FprCap.FprCap;
import com.xxx.zip.Zip;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
