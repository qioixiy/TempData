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
import cn.fingerdata.bean.TempInter;
import cn.fingerdata.biz.impl.CustomerListBizImpl;
import cn.fingerdata.biz.impl.IntAnalyBizImpl;
import cn.fingerdata.bizz.CustomerListBiz;
import cn.fingerdata.bizz.IntAnalyBiz;

public class IntAnalyS extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public IntAnalyS() {
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
		String suserid = request.getParameter("userid");
		int userid  = Integer.valueOf(suserid);
		
		System.out.println("进入IntAnalyS " + "userid:" + userid);

		IntAnalyBiz intAnalyBiz=new  IntAnalyBizImpl();  
		
		List<TempInter> tempInters=intAnalyBiz.getAllTempInters();
		System.out.println("tempInters.size()=" + tempInters.size());
		request.setAttribute("tempInters", tempInters);

		TempInter tempInter = intAnalyBiz.getTempInter(userid);
		for (TempInter item : tempInters) {
			if (item.getUserid() == userid) {
				tempInter = item;
				break;
			}
		}
		request.setAttribute("tempInter", tempInter);
		System.out.println("tempInters:" + tempInter);
		
		CustomerListBiz  customerListBiz=new  CustomerListBizImpl();
	     Customer  customer= customerListBiz.getCustomer(userid);
	     request.setAttribute("customer:",customer);
	     
		System.out.println("进入files/Finanalysis.jsp");
		
		RequestDispatcher  drDispatcher=request.getRequestDispatcher("files/Finanalysis.jsp");
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
