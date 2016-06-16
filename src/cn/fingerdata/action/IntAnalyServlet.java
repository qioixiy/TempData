package cn.fingerdata.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.fingerdata.bean.Customer;
import cn.fingerdata.bean.TempInter;
import cn.fingerdata.biz.impl.CustomerBizImpl;
import cn.fingerdata.biz.impl.CustomerListBizImpl;
import cn.fingerdata.biz.impl.IntAnalyBizImpl;
import cn.fingerdata.bizz.CustomerBiz;
import cn.fingerdata.bizz.CustomerListBiz;
import cn.fingerdata.bizz.IntAnalyBiz;

public class IntAnalyServlet extends HttpServlet {

	
	public IntAnalyServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 request.setCharacterEncoding("UTF-8");
	     response.setCharacterEncoding("UTF-8");
	     response.setContentType("text/html");
	     PrintWriter out = response.getWriter();
	     
	     
	     
			   
	     
			    System.out.println("转Servlet" );
		        String Inter_id=request.getParameter("Inter_id");
		        System.out.println("转Servlet" + Inter_id);
		        IntAnalyBiz   intAnalyBiz=new   IntAnalyBizImpl();
		        TempInter tempInter=intAnalyBiz.getTempInter(Integer.parseInt(Inter_id));
		        System.out.println("yichuan");
	            request.setAttribute("tempInter",tempInter);
	            
	    	/*	String    L1temp=request.getParameter("L1temp");
	    		Integer   L1RCL=Integer.valueOf(request.getParameter("L1RCL"));
	    		Integer   L1RCR=Integer.valueOf(request.getParameter("L1RCR"));
	    		String    L2temp=request.getParameter("L2temp");
	    		Integer   L2RCL=Integer.valueOf(request.getParameter("L2RCL"));
	    		Integer   L2RCR=Integer.valueOf(request.getParameter("L2RCR"));
	    		String    L3temp=request.getParameter("L3temp");
	    		Integer   L3RCL=Integer.valueOf(request.getParameter("L3RCL"));
	    		Integer   L3RCR=Integer.valueOf(request.getParameter("L3RCR"));
	    		String    L4temp=request.getParameter("L4temp");
	    		Integer   L4RCL=Integer.valueOf(request.getParameter("L4RCL"));
	    		Integer   L4RCR=Integer.valueOf(request.getParameter("L4RCR"));
	    		String    L5temp=request.getParameter("L5temp");
	    		Integer   L5RCL=Integer.valueOf(request.getParameter("L5RCL"));
	    		Integer   L5RCR=Integer.valueOf(request.getParameter("L5RCR"));
	    		String    R1temp=request.getParameter("R1temp");
	    		Integer   R1RCL=Integer.valueOf(request.getParameter("R1RCL"));
	    		Integer   R1RCR=Integer.valueOf(request.getParameter("R1RCR"));
	    		String    R2temp=request.getParameter("R2temp");
	    		Integer   R2RCL=Integer.valueOf(request.getParameter("R2RCL"));
	    		Integer   R2RCR=Integer.valueOf(request.getParameter("R2RCR"));
	    		String    R3temp=request.getParameter("R3temp");
	    		Integer   R3RCL=Integer.valueOf(request.getParameter("R3RCL"));
	    		Integer   R3RCR=Integer.valueOf(request.getParameter("R3RCR"));
	    		String    R4temp=request.getParameter("R4temp");
	    		Integer   R4RCL=Integer.valueOf(request.getParameter("R4RCL"));
	    		Integer   R4RCR=Integer.valueOf(request.getParameter("R4RCR"));
	    		String    R5temp=request.getParameter("R5temp");
	    		Integer   R5RCL=Integer.valueOf(request.getParameter("R5RCL"));
	    		Integer   R5RCR=Integer.valueOf(request.getParameter("R5RCR"));*/
	    		
	     
	     
	            RequestDispatcher rd = request.getRequestDispatcher("files/Finanalysis.jsp");
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
