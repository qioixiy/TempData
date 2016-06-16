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
import cn.fingerdata.biz.impl.TempInterBizImpl;
import cn.fingerdata.bizz.CustomerBiz;
import cn.fingerdata.bizz.TempInterBiz;

public class InterServlet extends HttpServlet   implements Action {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String result=this.execute(request, response);
		request.getRequestDispatcher(result).forward(request,response);
	
		
		
	}
	
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Integer   userid=Integer.valueOf(request.getParameter("userid"));
		String    name=request.getParameter("name");
		String    L1temp=request.getParameter("L1temp");
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
		Integer   R5RCR=Integer.valueOf(request.getParameter("R5RCR"));
		
	    
	    TempInterBiz  tempInterBiz=new  TempInterBizImpl();
	    TempInter   tempInter=new   TempInter();
	  
	    tempInter.setUserid(userid);
	    tempInter.setL1temp(L1temp);
	    tempInter.setL1RCL(L1RCL);
	    tempInter.setL1RCR(L1RCR);
	    tempInter.setL1temp(L1temp);
	    tempInter.setL1RCL(L1RCL);
	    tempInter.setL1RCR(L1RCR);
	    tempInter.setL2temp(L2temp);
	    tempInter.setL2RCL(L2RCL);
	    tempInter.setL2RCR(L2RCR);
	    tempInter.setL3temp(L3temp);
	    tempInter.setL3RCL(L3RCL);
	    tempInter.setL3RCR(L3RCR);
	    tempInter.setL4temp(L4temp);
	    tempInter.setL4RCL(L4RCL);
	    tempInter.setL4RCR(L4RCR);
	    tempInter.setL5temp(L5temp);
	    tempInter.setR1RCL(R1RCL);
	    tempInter.setR1RCR(R1RCR);
	    tempInter.setR2temp(R2temp);
	    tempInter.setR2RCL(R2RCL);
	    tempInter.setR2RCR(R2RCR);
	    tempInter.setR3temp(R3temp);
	    tempInter.setR3RCL(R3RCL);
	    tempInter.setR3RCR(R3RCR);
	    tempInter.setR4temp(R4temp);
	    tempInter.setR4RCL(R4RCL);
	    tempInter.setR4RCR(R4RCR);
	    tempInter.setR5temp(R5temp);
	    tempInter.setR5RCL(R5RCL);
	    tempInter.setR5RCR(R5RCR);
	    
	   
	    
	    boolean  isSuccessed=tempInterBiz.add(tempInter);
	    String  msg="";
	    if(isSuccessed){
	    	msg="添加信息成功！";
	    }else{
	    	msg="添加信息失败！";
	    }
	    
	    System.out.println(msg);
	    request.setAttribute("msg", msg);
	    RequestDispatcher  rd=request.getRequestDispatcher("Finanalysis.jsp");
	    rd.forward(request, response);
	    return  msg;

		
		
		
	
	}

	
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	


}
