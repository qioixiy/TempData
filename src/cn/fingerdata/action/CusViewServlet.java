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

public class CusViewServlet extends HttpServlet {



	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
	     response.setCharacterEncoding("UTF-8");
	     response.setContentType("text/html");
	     PrintWriter out = response.getWriter();
	     
		 RequestDispatcher  rd=null;
		 String  type=request.getParameter("type");

		 int id=Integer.valueOf(request.getParameter("id"));
		 
	     CustomerBiz  customerBiz=new  CustomerBizImpl();
	     List<Customer> customers = customerBiz.getAllCustomers();
	     Customer  customer = null;
	     //Customer  customer=customerBiz.getCustomer(id);
	     
	     for (int i = 0; i < customers.size(); i++) {
	    	 if (id == customers.get(i).getUserid()) {
	    		 customer = customers.get(i);
	    	 }
	     }
	     
	     request.setAttribute("customer",customer);
	    /*
	     * 根据id类型不同进行跳转
	     */
	     if(type.equals("CusInfo")){
				rd=request.getRequestDispatcher("files/CustomerInfo.jsp");
			}else  if(type.equals("Collect")){
				rd=request.getRequestDispatcher("files/Fincollect.jsp");
			}else  if(type.equals("Inter")){
				rd=request.getRequestDispatcher("files/FinInter.jsp");
			
			}
			
			rd.forward(request, response);
		
		}


	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}



}
