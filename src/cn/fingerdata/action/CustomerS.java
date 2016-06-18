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
import cn.fingerdata.biz.impl.CustomerListBizImpl;
import cn.fingerdata.bizz.CustomerBiz;
import cn.fingerdata.bizz.CustomerListBiz;

public class CustomerS extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String conditions = request.getParameter("conditions");
		String param = request.getParameter("param");
		
		conditions = "全部";
		
		CustomerListBiz  customerListBiz= new  CustomerListBizImpl();
		CustomerBiz cbz = new CustomerBizImpl();
		List<Customer> customers = null;
		System.out.println("conditions:" + conditions);
		 if(conditions.equals("全部")){
			 System.out.println("全部");
			 System.out.println(conditions + "--" + param);
			 customers = customerListBiz.getAllCustomers();
		 }else{
			 System.out.println("其他");
			 customers = cbz.getCustomer8Conditions(conditions, param);
		 }
		request.setAttribute("customers", customers);
		
		RequestDispatcher  drDispatcher=request.getRequestDispatcher("files/CustomerView.jsp");
		drDispatcher.forward(request, response);
	}
		

	
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
