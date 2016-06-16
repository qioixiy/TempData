<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page  import="java.util.List" %>
<%@page  import="cn.fingerdata.bean.Customer"%>
<%
List<Customer> customers = (List<Customer>)request.getAttribute("customers"); 
 System.out.println(customers + " this is a");
 %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
       
     <base href="<%=basePath%>">
    <title>D&B数据采集系统 by www.mycodes.net</title>
    
	<meta http-equiv="pragma" content="no-cache">
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

<link href="../css/css.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">

</script>
<style type="text/css">
.cusTop{
	width:100%;
	height:100px;
	border:1px solid red;
	background-image: url("/images/nav04.gif");
}
<!--
.STYLE1 {color: #FF0000}
-->
</style>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>

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

function link(){
    document.getElementById("fom").action="files/addCustomer.jsp";
   document.getElementById("fom").submit();
}

function showCusInfo(id){
     location.href="http://localhost:8080/TempData/CusViewServlet?type=CusInfo&id="+id;
}

function showCollect(id){
     location.href="/TempData/CusViewServlet?type=Collect&id="+id;
}

function showInter(id){
     location.href="/TempData/CusViewServlet?type=Inter&id="+id;
}


</SCRIPT>

<body>
<form name="fom" id="fom" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
 
  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="cusTop" height="62">
           
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="24"><img src="../images/ico07.gif" width="20" height="18" /></td>
			  <td width="600"><select name="select4">
				    <option>编号</option>
				    <option>性别</option>
				    <option>姓名</option>
				    <option>版本</option>
				    <option>采集师</option>
				    <option>判别师</option>
				    <option>生日</option>
				    <option>年龄</option>
			      </select>&nbsp;
			   <input name="textfield" type="text" size="35" >	
			   <input name="Submit" type="button" class="right-button02" value="查 询" /></td>
			   <td width="679" align="left">&nbsp; </td>	
		    </tr>
          </table></td>
        </tr>
    </table></td></tr>
    
    <tr>
    <td><table  width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="35"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a><a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
		           <input name="Submit" type="button" class="right-button08" value="删除所选人员" style="height: 21px; width: 100px"/> &nbsp;&nbsp;&nbsp; <a href="addCustomer.jsp" target="mainFrame" class="left-font03" onClick="tupian('21');"><input name="Submit" type="button" class="right-button08" value="添加人员信息"   style="height: 21px; width: 100px"onclick="link();  " />
		           &nbsp;&nbsp;&nbsp;&nbsp; 
		           <input type="button" name="Submit2" value="返回" class="right-button02" onclick="window.history.go(-1);"/>
		          
		           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	              </td>
          </tr>
  <tr>
    <td><table  width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="98%" border="1"    bordercolor="#8FBC8F" align="center" cellpadding="0" cellspacing="0">
	
					                  <tr>
                    <td height="30" colspan="9" align="center"  bgcolor="#5F9EA0"   bordercolor="#8FBC8F" class="tablestyle_title"><center>客户记录列表</center></td>
                    </tr>
              <tr   bordercolor="#8FBC8F"   bordercolor="#8FBC8F"   >
                <td height="40" class="font42"><table width="100%" border="1"    bordercolor="#8FBC8F"  cellpadding="4" cellspacing="1"  >
                  <tr    bgcolor="#5F9EA0"   bordercolor="#8FBC8F">
                     <td width="5%" align="center"  >选择</td>
                    <td width="6%" height="20" align="center"  >编号</td>
                    <td width="6%" align="center" >姓名</td>
                    <td width="6%" align="center" >性别</td>
                    <td width="5%" align="center" >版本</td>
                    <td width="10%" align="center" >出生日期</td>
                    <td width="6%" align="center" >年龄</td>
                    <td width="8%" align="center" >联系电话</td>
                    <td width="8%" align="center" >采集师编号</td>
                    <td width="8%" align="center" >采集师</td>
                  
                    <td width="10%" align="center" >采集日期</td>

                    <td width="30%" align="center" >操作</td>
                  </tr>
                  <% for(Customer customer:customers){  %> 
                   
                  
                  
                 
                  <tr   bordercolor="#8FBC8F">
				    <td ><input type="checkbox" name="delid"/></td>
                    <td height="20" ><div align="center"><%=customer.getUserid()%></div> </td>
                    <td ><div align="center"><%=customer.getName()%></div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><%=customer.getGender()%></div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><%=customer.getVersion() %></div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><%=customer.getBirthday() %></div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><%=customer.getAge() %></div></td>
                    <td bgcolor="#FFFFFF"><div align="center" ><%=customer.getPhone() %></div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><%=customer.getCollId() %></div></td>
                     <td bgcolor="#FFFFFF"><div align="center"><%=customer.getCollName() %></div></td>
                     
                     <td bgcolor="#FFFFFF"><div align="center"><%=customer.getColldate() %></div></td>
                     
                    <td bgcolor="#FFFFFF"><div align="center"><input  type="button"   value="查看"   onclick="showCusInfo(<%=customer.getId()%>)" />&nbsp;&nbsp;
                                                              <input  type="button"   value="采集"   onclick="showCollect(<%=customer.getId()%>)" />&nbsp;&nbsp;
                                                              <input  type="button"   value="判读"   onclick="showInter(<%=customer.getId()%>)"  /></div></td>
                  </tr>
				
                   
                  <%} %>
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="../images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">共 <span class="right-text09">5</span> 页 | 第 <span class="right-text09">1</span> 页</td>
                <td width="49%" align="right">[<a href="#" class="right-font08">首页</a> | <a href="#" class="right-font08">上一页</a> | <a href="#" class="right-font08">下一页</a> | <a href="#" class="right-font08">末页</a>] 转至：</td>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%"><input name="textfield3" type="text" class="right-textfield03" size="1" /></td>
                      <td width="87%"><input name="Submit23222" type="submit" class="right-button06" value=" " />
                      </td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
</body>
</html>
 