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
import cn.fingerdata.biz.impl.CustomerBizImpl;
import cn.fingerdata.biz.impl.CustomerListBizImpl;
import cn.fingerdata.bizz.CustomerBiz;
import cn.fingerdata.bizz.CustomerListBiz;
import com.xxx.db.*;
import com.xxx.utils.ComputeResult;
import com.xxx.utils.algorithm;
import com.xxx.utils.algorithm.FINGER_TYPE;
import com.xxx.utils.algorithm.algorithmInput;

import java.sql.*;

/**
 * Servlet implementation class FinData
 */
@WebServlet("/FinData")
public class FinData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletCtx = config.getServletContext();
		
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FinData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("FinData enter");
		String sid = request.getParameter("id");
		String sUserid = request.getParameter("Userid");
		System.out.println("id:" + sid +",Userid:" + sUserid);
		
		String userid = sUserid;
		
		CustomerListBiz  customerListBiz=new  CustomerListBizImpl();
		Customer  customer= null;
		if (sid != null) {
	      customer= customerListBiz.getCustomer(Integer.valueOf(sid));
		}
	     request.setAttribute("customer",customer);
		
	     ComputeResult mComputeResult = new ComputeResult();
	     algorithm.algorithmOutput output = mComputeResult.UseAlgorithm(userid);
		

		request.setAttribute("FinData", output);
				
		RequestDispatcher drDispatcher = request.getRequestDispatcher("files/FinData.jsp");
		drDispatcher.forward(request, response);

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
