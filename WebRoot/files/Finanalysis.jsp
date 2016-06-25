<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page  import="cn.fingerdata.bean.Customer" %>
<%@page  import="cn.fingerdata.bean.TempInter" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	Customer customer = (Customer) request.getAttribute("customer");
	TempInter tempInter = (TempInter) request.getAttribute("tempInter");
	
	System.out.println("customer:" + customer);
	System.out.println("tempInter:" + tempInter);
	
	if (customer == null || tempInter == null) {
		return;
	}
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Finanalysis.jsp' starting page</title>
    
	<meta http-equiv="Content-Type"  content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="<%=basePath%>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/css/style.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
function sousuo(){
	window.open("","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}
function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}

function link1(){
    document.getElementById("fom").action="/TempData/ListCusServlet";
   document.getElementById("fom").submit();
}
function link2(){
    document.getElementById("fom").action="FinInter.jsp";
   document.getElementById("fom").submit();
}

function on_load(){
	var loadingmsg=document.getElementById("loadingmsg");
	var mainpage=document.getElementById("mainpage");
	loadingmsg.style.display="";
	mainpage.style.display="none";
	
	loadingmsg.style.display="none";
	mainpage.style.display="";
}
</SCRIPT>

<body class="on_load()">
  <form action="" method="post"  name="fom" id="fom"  >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent" height="100%"    background="../images/nav04.gif">
  <tr>
      <th class="tablestyle_title" >纹型分析</th>
  </tr>
  <tr>  <td class="CPanel"></td></tr>
  <tr>
      <td class="CPanel" width="5%">	&nbsp;&nbsp;&nbsp;&nbsp;
		 <input name="Submit" type="button" class="right-button08" value="打&nbsp;开&nbsp;记&nbsp;录"   style="height: 21px; width: 100px"onclick="link1();  " />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 <input name="Submit" type="button" class="right-button08" value="判&nbsp;读&nbsp;指&nbsp;纹"   style="height: 21px; width: 100px"onclick="link2();  " />
	     &nbsp;&nbsp;&nbsp;&nbsp;
	     <input type="button" name="Submit2" value="返回" class="right-button02" onclick="window.history.go(-1);" />
	  </td >
			       
  </tr>
    </td>
</tr>
		<tr>
			<TD width="100%" >
				<fieldset >
				<legend>基本信息</legend>
				 <table    width="100%"  border="1" cellpadding="2" cellspacing="2"   bordercolor="#5F9EA0"  ">
					 
			      <tr  bordercolor="#5F9EA0">
					    <td nowrap align="right" width="5%"    >编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</td>
					    <td  align="center"   width="10%"><%=customer.getUserid()%> </td>
				    	 <td align="right" width="5%"   >姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</td>
					    <td width="10%"   align="center"><%=customer.getName()%></td>
					    <td  align="right" width="5%" >性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</td>
					    <td  align="center" width="10%"><%=customer.getGender()%>
					       
					    </td>
					    <td nowrap align="right" width="6%"   >出生日期:</td>
					    <td nowrap align="center" width="10%">
					     <%=customer.getBirthday() %>   
					    </td> 
					 </tr>
					 
					 <tr  bordercolor="#5F9EA0">
					  <td nowrap align="right" width="5%"  >判读师编号:</td>
					    <td align="center"  width="10%"><%=customer.getDisId() %>
				              <span class="red"> *</span></td>
					    <td align="right" width="5%"  >判读师:</td>
					    <td width="10%"   align="center"><%=customer.getDisName() %></td>
					    <td nowrap align="right" width="5%"  colspan="2">&nbsp;</td>
					    
					    <td  align="right" width="6%"    >判读日期:</td>
					    <td   align="center"width="10%">
					     <%=customer.getDisdate() %>   
					    </td> 
					 </tr>
					 </table>
			</fieldset>	
					 </td>
			</tr>
			<tr>
			<TD width="100%"  height="310">
				<fieldset >
				<legend>判读数据 </legend>
				 <table    width="100%"  border="1" cellpadding="2" cellspacing="0"   bordercolor="#E0FFFF" >
				 <tr>
				    <td  width="2%">&nbsp;</td>
				    <td  width="45%">
				       <table    width="100%"  border="1" cellpadding="2" cellspacing="1"   bordercolor="#8FBC8F">
				         <tr  bordercolor="#8FBC8F"  height="35"  bgcolor="#AFEEEE">
				            <td  align="center"  width="23%"  >左手</td>
				            <td  align="center"  width="26%">纹型</td>
				            <td  align="center"  width="27%">RC/L</td>
				            <td  align="center"  withd="26%">RC/R</td>
				          </tr>
				          <tr  bordercolor="#8FBC8F"   height="55">
				            <td  align="center"  width="23%"     bgcolor="#AFEEEE">拇指(L1)</td>
				            <td  align="center"  width="26%"><%=tempInter.getL1temp()%></td>
				            <td  align="center"  width="27%"><%=tempInter.getL1RCL()%></td>
				            <td  align="center"  withd="26%"><%=tempInter.getL1RCR()%></td>
				          </tr>
				           <tr  bordercolor="#8FBC8F"  height="55" >
				            <td  align="center"  width="23%"    bgcolor="#AFEEEE" >食指(L2)</td>
				            <td  align="center"  width="26%"><%=tempInter.getL2temp()%></td>
				            <td  align="center"  width="27%"><%=tempInter.getL2RCL()%></td>
				            <td  align="center"  withd="26%"><%=tempInter.getL2RCR()%></td>
				          </tr>
				           <tr  bordercolor="#8FBC8F"   height="55">
				            <td  align="center"  width="23%"    bgcolor="#AFEEEE" >中指(L3)</td>
				            <td  align="center"  width="26%"><%=tempInter.getL3temp()%></td>
				            <td  align="center"  width="27%"><%=tempInter.getL3RCL()%></td>
				            <td  align="center"  withd="26%"><%=tempInter.getL3RCR()%></td>
				          </tr>
				           <tr  bordercolor="#8FBC8F"  height="55">
				            <td  align="center"  width="23%"    bgcolor="#AFEEEE">环指(L4)</td>
				            <td  align="center"  width="26%"><%=tempInter.getL4temp()%></td>
				            <td  align="center"  width="27%"><%=tempInter.getL4RCL()%></td>
				            <td  align="center"  withd="26%"><%=tempInter.getL4RCR()%></td>
				          </tr>
				           <tr  bordercolor="#8FBC8F"  height="55">
				            <td  align="center"  width="23%"    bgcolor="#AFEEEE" >尾指(L5)</td>
				            <td  align="center"  width="26%"><%=tempInter.getL5temp()%></td>
				            <td  align="center"  width="27%"><%=tempInter.getL5RCL()%></td>
				            <td  align="center"  withd="26%"><%=tempInter.getL5RCR()%></td>
				          </tr>
				       
				       </table>
				    </td>
				    <td  width="6%">&nbsp;</td>
				    <td  width="45%">
				       <table    width="100%"  border="1" cellpadding="2" cellspacing="1"   bordercolor="#8FBC8F">
				         <tr  bordercolor="#8FBC8F"  height="35"  bgcolor="#AFEEEE">
				            <td  align="center"  width="23%"  >右手</td>
				            <td  align="center"  width="26%">纹型</td>
				            <td  align="center"  width="27%">RC/L</td>
				            <td  align="center"  withd="26%">RC/R</td>
				          </tr>
				          <tr  bordercolor="#8FBC8F"   height="55">
				            <td  align="center"  width="23%"    bgcolor="#AFEEEE" >拇指(R1)</td>
				            <td  align="center"  width="26%"><%=tempInter.getR1temp()%></td>
				            <td  align="center"  width="27%"><%=tempInter.getR1RCL()%></td>
				            <td  align="center"  withd="26%"><%=tempInter.getR1RCR()%></td>
				          </tr>
				           <tr  bordercolor="#8FBC8F"  height="55" >
				            <td  align="center"  width="23%"    bgcolor="#AFEEEE" >食指(R2)</td>
				            <td  align="center"  width="26%"><%=tempInter.getR2temp()%></td>
				            <td  align="center"  width="27%"><%=tempInter.getR2RCL()%></td>
				            <td  align="center"  withd="26%"><%=tempInter.getR2RCR()%></td>
				          </tr>
				           <tr  bordercolor="#8FBC8F"   height="55">
				            <td  align="center"  width="23%"   bgcolor="#AFEEEE" >中指(R3)</td>
				            <td  align="center"  width="26%"><%=tempInter.getR3temp()%></td>
				            <td  align="center"  width="27%"><%=tempInter.getR3RCL()%></td>
				            <td  align="center"  withd="26%"><%=tempInter.getR3RCR()%></td>
				          </tr>
				           <tr  bordercolor="#8FBC8F"  height="55">
				            <td  align="center"  width="23%"    bgcolor="#AFEEEE">环指(R4)</td>
				            <td  align="center"  width="26%"><%=tempInter.getR4temp()%></td>
				            <td  align="center"  width="27%"><%=tempInter.getR4RCL()%></td>
				            <td  align="center"  withd="26%"><%=tempInter.getR4RCR()%></td>
				          </tr>
				           <tr  bordercolor="#8FBC8F"  height="55">
				            <td  align="center"  width="23%"   bgcolor="#AFEEEE" >尾指(R5)</td>
				            <td  align="center"  width="26%"><%=tempInter.getR5temp()%></td>
				            <td  align="center"  width="27%"><%=tempInter.getR5RCL()%></td>
				            <td  align="center"  withd="26%"><%=tempInter.getR5RCR()%></td>
				          </tr>
				       
				       </table>
				    </td>
				    <td   width="2%">&nbsp;</td>
				   </tr>
					 
			     
				</table>
				</fieldset>	    
	       </td>
					 
		 </tr>
		 </br>
			 </table>
		 <table  width="100%"  height="100%"  border="0" cellpadding="0" cellspacing="0" >
		         <tr  align="center"><td align="center">&nbsp;
			         </td>
			       </tr>
			        <tr  align="center"><td align="center">
			        <input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/> </td>
			       </tr>
          </table>
</div>
</form>
</body>
</html>

