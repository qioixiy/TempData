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
				String UserName = request.getParameter("UserName");
				String UserNumber = request.getParameter("UserNumber");
				System.out.println(
						"FingerPostion:" + FingerPostion + ",UserName:" + UserName + ",UserNumber:" + UserNumber);

				String fileName = UserName + UserNumber + FingerPostion;

				String date = MyDate.getFormatDate();
				String BmpFileName = fileName + date + ".bmp";
				String BmpPath = FprCap_data + "/" + BmpFileName;
				System.out.println("BmpPath:" + BmpPath);
				if (0 == FprCap.GetFrame(BmpPath)) {
					System.out.println("GetFrame complete");
					response.getWriter().append(basePath + "/images/FprCap/data/" + BmpFileName);
				} else {
					System.out.println("GetFrame field");
					response.getWriter().append("filed");
					File file = new File(BmpPath);
					if (file.isFile() && file.exists()) {
						file.delete();
					}
				}
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
