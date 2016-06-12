package cn.fingerdata.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.fingerdata.bean.Customer;
import cn.fingerdata.biz.impl.CustomerBizImpl;
import cn.fingerdata.bizz.CustomerBiz;

public class addCusServlet extends HttpServlet  implements Action {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String result=this.execute(request, response);
		request.getRequestDispatcher(result).forward(request,response);
	
		
	}
	
	public  String   execute(HttpServletRequest  request,
			HttpServletResponse  response)throws  ServletException,IOException{
		
		
		Integer  userid=Integer.valueOf(request.getParameter("userid"));
		String   name=request.getParameter("name");
		String   gender=request.getParameter("gender");
		String   birthday=request.getParameter("birthaday");
		String   age=request.getParameter("age");
		String   version=request.getParameter("version");
		String   collectDate=request.getParameter("collectDate");
		String   constellation=request.getParameter("constellation");
		String   bloodtype=request.getParameter("bloodtype");
		String   fatherName=request.getParameter("fatherName");
		String   farBirthday=request.getParameter("farBirthday");
		String   fphone=request.getParameter("fphone");
		String   matherName=request.getParameter("matherName");
	    String   marBirthday=request.getParameter("marBirthday");
	    String   mphone=request.getParameter("mphone");
	    String   career=request.getParameter("career");
	    String   address=request.getParameter("address");
	    String   phone=request.getParameter("phone");
	    String   QQ=request.getParameter("QQ");
	    String   MSN=request.getParameter("MSN");
	    String   leftATD=request.getParameter("leftAtD");
	    String   rightATD=request.getParameter("rightATD");
	    String   note=request.getParameter("note");
	    Integer  collId=Integer.valueOf(request.getParameter("collId"));
	    String   collName=request.getParameter("collName");
	    String   colldate=request.getParameter("colldate");
	    Integer  disId=Integer.valueOf(request.getParameter("disId"));
	    String   disName=request.getParameter("disName");
	    String   disdate=request.getParameter("disdate");
	    
	    CustomerBiz  customerBiz=new  CustomerBizImpl();
	    Customer   customer=new  Customer();
	    
	    customer.setUserid(userid);
	    customer.setName(name);
	    customer.setGender(gender);
	    customer.setBirthday(birthday);
	    customer.setAge(age);
	    customer.setVersion(version);
	    customer.setCollectDate(collectDate);
	    customer.setBloodtype(bloodtype);
	    customer.setFatherName(fatherName);
	    customer.setFarBirthday(farBirthday);
	    customer.setFphone(fphone);
	    customer.setMatherName(matherName);
	    customer.setMarBirthday(marBirthday);
	    customer.setMphone(mphone);
	    customer.setCareer(career);
	    customer.setPhone(phone);
	    customer.setQQ(QQ);
	    customer.setMSN(MSN);
	    customer.setLeftATD(leftATD);
	    customer.setRightATD(rightATD);
	    customer.setNote(note);
	    customer.setCollId(collId);
	    customer.setCollName(collName);
	    customer.setColldate(colldate);
	    customer.setDisId(disId);
	    customer.setDisName(disName);
	    customer.setDisdate(disdate);
	    
	    boolean  isSuccessed=customerBiz.add(customer);
	    String  msg="";
	    if(isSuccessed){
	    	msg="添加信息成功！";
	    }else{
	    	msg="添加信息失败！";
	    }
	    
	    System.out.println(msg);
	    request.setAttribute("msg", msg);
	    RequestDispatcher  rd=request.getRequestDispatcher("CustomerView.jsp");
	    rd.forward(request, response);
	    return  msg;

		
	}
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
