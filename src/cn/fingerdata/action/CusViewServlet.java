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

	/**
	 * Constructor of the object.
	 */
	public CusViewServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
	     response.setCharacterEncoding("UTF-8");
	     response.setContentType("text/html");
	     PrintWriter out = response.getWriter();
	     
		 RequestDispatcher  rd=null;
		 String  type=request.getParameter("type");
		 int   id=Integer.valueOf(request.getParameter("id"));
		 System.out.println(type+"type");
		 System.out.println(id+"++");
         CustomerBiz cbz = new CustomerBizImpl();
	     List<Customer> cs = cbz.getCustomer8Conditions("姓名", "小");
	     
	     System.out.println("通过条件获取的结果:" + cs.get(0).getName());
	     System.out.println("通过条件获取的结果:" + cs.get(1).getName());
		 
	     CustomerBiz  customerBiz=new  CustomerBizImpl();
	     Customer  customer=customerBiz.getCustomer(id);
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
