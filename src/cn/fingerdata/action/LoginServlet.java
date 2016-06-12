package cn.fingerdata.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.fingerdata.bean.Account;
import cn.fingerdata.biz.impl.AccountBizImpl;
import cn.fingerdata.bizz.AccountBiz;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	    String    result=this.execute(request,response);
		request.getRequestDispatcher(result).forward(request, response);
	}

	private String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String  result="";
		String  accountname=request.getParameter("accountname");
		String  password=request.getParameter("password");
		AccountBiz  accountBiz=new  AccountBizImpl();
		Account  account=accountBiz.login(accountname,password);
		if(account==null){
			request.setAttribute("message", "账号或密码不正确");
			result="login.jsp";
		}else{
			request.getSession().setAttribute("login",account);
			result="index.html";
			
		}
		
		
		
		return result;
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
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
