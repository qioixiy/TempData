package com.xxx.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FprCap.*;

import cn.fingerdata.bean.Customer;
import cn.fingerdata.biz.impl.CustomerListBizImpl;
import cn.fingerdata.bizz.CustomerListBiz;
import com.xxx.db.*;
import java.sql.*;

/**
 * Servlet implementation class ListFinType
 */
@WebServlet("/ListFinType")
public class ListFinType extends HttpServlet {
	String TAG = "ListFinType";
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletCtx = config.getServletContext();
		
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListFinType() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String detail = request.getParameter("detail");
		String userid = request.getParameter("userid");

		System.out.println(TAG + " userid:" + userid + ",detail:" + detail);
				
		String sql = String.format("SELECT * FROM `tempimage` WHERE userid = %s", userid);
		System.out.println(sql);

		String L1L = null, L1R = null, L1C = null, L2L = null, L2R = null, L2C = null, L3L = null, L3R = null, L3C = null, L4L = null, L4R = null, L4C = null, L5L = null, L5R = null, L5C = null;
		String R1L = null, R1R = null, R1C = null, R2L = null, R2R = null, R2C = null, R3L = null, R3R = null, R3C = null, R4L = null, R4R = null, R4C = null, R5L = null, R5R = null, R5C = null;
		try{
			Connection conn=(new jdbc()).GetConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				L1L = rs.getString("L1left");
				L1R = rs.getString("L1right");
				L1C = rs.getString("L1post");
				L2L = rs.getString("L2left");
				L2R = rs.getString("L2right");
				L2C = rs.getString("L2post");
				L3L = rs.getString("L3left");
				L3R = rs.getString("L3right");
				L3C = rs.getString("L3post");
				L4L = rs.getString("L4left");
				L4R = rs.getString("L4right");
				L4C = rs.getString("L4post");
				L5L = rs.getString("L5left");
				L5R = rs.getString("L5right");
				L5C = rs.getString("L5post");
				
				R1L = rs.getString("R1left");
				R1R = rs.getString("R1right");
				R1C = rs.getString("R1post");
				R2L = rs.getString("R2left");
				R2R = rs.getString("R2right");
				R2C = rs.getString("R2post");
				R3L = rs.getString("R3left");
				R3R = rs.getString("R3right");
				R3C = rs.getString("R3post");
				R4L = rs.getString("R4left");
				R4R = rs.getString("R4right");
				R4C = rs.getString("R4post");
				R5L = rs.getString("R5left");
				R5R = rs.getString("R5right");
				R5C = rs.getString("R5post");

			}

			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

			Map<String, String> urls = new HashMap<String, String>();
			urls.put("L1L", basePath + "images/FprCap/data/" + L1L);
			urls.put("L1R", basePath + "images/FprCap/data/" + L1R);
			urls.put("L1C", basePath + "images/FprCap/data/" + L1C);
			urls.put("L2L", basePath + "images/FprCap/data/" + L2L);
			urls.put("L2R", basePath + "images/FprCap/data/" + L2R);
			urls.put("L2C", basePath + "images/FprCap/data/" + L2C);
			urls.put("L3L", basePath + "images/FprCap/data/" + L3L);
			urls.put("L3R", basePath + "images/FprCap/data/" + L3R);
			urls.put("L3C", basePath + "images/FprCap/data/" + L3C);
			urls.put("L4L", basePath + "images/FprCap/data/" + L4L);
			urls.put("L4R", basePath + "images/FprCap/data/" + L4R);
			urls.put("L4C", basePath + "images/FprCap/data/" + L4C);
			urls.put("L5L", basePath + "images/FprCap/data/" + L5L);
			urls.put("L5R", basePath + "images/FprCap/data/" + L5R);
			urls.put("L5C", basePath + "images/FprCap/data/" + L5C);
			

			urls.put("R1L", basePath + "images/FprCap/data/" + R1L);
			urls.put("R1R", basePath + "images/FprCap/data/" + R1R);
			urls.put("R1C", basePath + "images/FprCap/data/" + R1C);
			urls.put("R2L", basePath + "images/FprCap/data/" + R2L);
			urls.put("R2R", basePath + "images/FprCap/data/" + R2R);
			urls.put("R2C", basePath + "images/FprCap/data/" + R2C);
			urls.put("R3L", basePath + "images/FprCap/data/" + R3L);
			urls.put("R3R", basePath + "images/FprCap/data/" + R3R);
			urls.put("R3C", basePath + "images/FprCap/data/" + R3C);
			urls.put("R4L", basePath + "images/FprCap/data/" + R4L);
			urls.put("R4R", basePath + "images/FprCap/data/" + R4R);
			urls.put("R4C", basePath + "images/FprCap/data/" + R4C);
			urls.put("R5L", basePath + "images/FprCap/data/" + R5L);
			urls.put("R5R", basePath + "images/FprCap/data/" + R5R);
			urls.put("R5C", basePath + "images/FprCap/data/" + R5C);
			
			System.out.println(urls);
			
			if (detail != null) {
				String ret = urls.get(detail + "L") + "|" + urls.get(detail + "R") + "|" + urls.get(detail + "C");
				response.getWriter().append(ret);
				System.out.println("detail:" + detail + ":" + ret);
			} else {
				request.setAttribute("urls", urls);
			
				RequestDispatcher drDispatcher = request.getRequestDispatcher("files/listFintype.jsp");
				drDispatcher.forward(request, response);
			}
		}catch(Exception  e){
			e.printStackTrace();
		}finally {
			;
		}
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

}
