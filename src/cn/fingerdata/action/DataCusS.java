package cn.fingerdata.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.fingerdata.bean.Customer;
import cn.fingerdata.biz.impl.CustomerBizImpl;
import cn.fingerdata.bizz.CustomerBiz;

public class DataCusS extends HttpServlet {


	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("进入DataCusS");
		CustomerBiz  customerBiz= new  CustomerBizImpl();
		List<Customer> customers=customerBiz.getAllCustomers();
		System.out.println(customers.size());
		request.setAttribute("customers", customers);
		
		RequestDispatcher  drDispatcher=request.getRequestDispatcher("files/listCustomer14.jsp");
		drDispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	        doGet(request, response);
	}




}
