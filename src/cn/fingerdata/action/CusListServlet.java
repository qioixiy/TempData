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

public class CusListServlet extends HttpServlet {


	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 request.setCharacterEncoding("UTF-8");
	     response.setCharacterEncoding("UTF-8");
	     response.setContentType("text/html");
	     PrintWriter out = response.getWriter();
	     
		 RequestDispatcher  rd=null;
		 String  type=request.getParameter("type");
		 int   id=Integer.valueOf(request.getParameter("id"));
	     CustomerListBiz  customerListBiz=new  CustomerListBizImpl();
	     Customer  customer=customerListBiz.getCustomer(id);
	     request.setAttribute("customer",customer);
	 
 
	    /*
	     * 根据id类型不同进行跳转
	     */
	     if(type.equals("Inter")){
				rd=request.getRequestDispatcher("files/FinInter.jsp");
			}else  if(type.equals("Analysis")){
				rd=request.getRequestDispatcher("/IntAnalyServlet?Inter_id=" + customer.getId()+"&type="+"Analysis");
			}
			
			rd.forward(request, response);
		
		}

	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
