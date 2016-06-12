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
import cn.fingerdata.biz.impl.CustomerListBizImpl;
import cn.fingerdata.bizz.CustomerListBiz;

public class CustomerS extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CustomerS() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("进入CustomerS");
		CustomerListBiz  customerListBiz= new  CustomerListBizImpl();
		List<Customer> customers=customerListBiz.getAllCustomers();
		System.out.println(customers.size());
		request.setAttribute("customers", customers);
		
		RequestDispatcher  drDispatcher=request.getRequestDispatcher("files/listCustomer.jsp");
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
