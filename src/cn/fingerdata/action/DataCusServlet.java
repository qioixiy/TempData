package cn.fingerdata.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.fingerdata.bean.Customer;
import cn.fingerdata.biz.impl.CustomerListBizImpl;
import cn.fingerdata.bizz.CustomerListBiz;

public class DataCusServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DataCusServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		RequestDispatcher rd = null;
		String type = request.getParameter("type");
		String sid = request.getParameter("id");
		String Userid = request.getParameter("Userid");
		int id = Integer.valueOf(sid);
		CustomerListBiz customerListBiz = new CustomerListBizImpl();
		Customer customer = customerListBiz.getCustomer(id);
		request.setAttribute("customer", customer);
		request.setAttribute("id ", sid);
		request.setAttribute("Userid ", Userid);

		/*
		 * 根据id类型不同进行跳转
		 */
		System.out.println("forward to files/FinData.jsp");
		if (type.equals("Data")) {
			rd = request.getRequestDispatcher("/FinData");
		}

		rd.forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
