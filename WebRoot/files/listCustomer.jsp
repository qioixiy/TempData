<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page  import="java.util.List" %>
<%@page  import="cn.fingerdata.bean.Customer" %>
<%
List<Customer> customers=(List<Customer>)request.getAttribute("customers"); 
   
 %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
       <base href="<%=basePath%>">
    <title>My JSP 'listCustomer.jsp' starting page</title>
    
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
<script type="text/JavaScript" src="<%=basePath %>/js/ajax.js" > </script>
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

function link1(){
    document.getElementById("fom").action="files/addCustomer.jsp";
   document.getElementById("fom").submit();
}

function  showInter(id){
     location.href="/TempData/CustomerServlet?type=Inter&id="+id;
}

function   showCollect(id){
    location.href="/TempData/CustomerServlet?type=Collect&id="+id;
}

function   showAnalysis(id){
    location.href="/TempData/CustomerServlet?type=Analysis&id="+id;
}



function export_package(Userid)
{
	ajax_request("<%=basePath%>", "exportPackage", "&Userid="+Userid);
}

function import_package()
{
	UpladFile();
}

</SCRIPT>

<body>
<form name="fom" id="fom" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="TempData/WebRoot/images/nav04.gif">cc
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0"   >
		    <tr>
			  <td width="24"><img src="../images/ico07.gif" width="20" height="18" /></td>
			  <td width="600"><select name="select4" style="width: 118px; height: 19px">
				    <option>编号</option>
				    <option>性别</option>
				    <option>姓名</option>
				    <option>版本</option>
				    <option>年龄</option>
				    <option>出生日期</option>
				    <option>采集师编号</option>
				    <option>采集师</option>
				    <option>采集日期</option>
			      </select>&nbsp;
			   <input name="textfield" type="text" size="35" />	
			   <input name="Submit" type="button" class="right-button02" value="查 询" /></td>
			   <td width="679" align="left">
			     &nbsp;&nbsp;&nbsp;&nbsp;

			   </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>	
		    </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0"   >
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0"  background="../images/nav04.gif">
          	 <tr>
               <td height="35"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
		           <input name="Submit" type="button" class="right-button08" value="删除所选人员" style="height: 21px; width: 100px"/> &nbsp;&nbsp;&nbsp;<input name="Submit" type="button" class="right-button08" value="添加人员信息"   style="height: 21px; width: 100px"onclick="link1();  " />
		          <input type="file" id="file" name="myfile" />
		          <input name="Submit" type="submit" class="right-button08" value="导入数据" style="height:21px; width:100px" onclick="import_package();" />
	              </td>
          </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="1" cellpadding="4" cellspacing="1" bgcolor="#5F9EA0"  bordercolor="#8FBC8F"  class="newfont03"  >

					                  <tr>
                    <td height="30" colspan="15" align="center" bgcolor="#5F9EA0" bordercolor="#8FBC8F" class="tablestyle_title"> <center>人员信息列表</center></td>
                    </tr>
                 <tr  bgcolor="#5F9EA0"   bordercolor="#8FBC8F" >
				    <td width="6%" align="center"   bordercolor="#FEEEEE" >选择</td>
				  
					 <td width="9%" height="20"      bordercolor="#FEEEEE"  align="center" >唯一编号</td>
                    <td width="9%" align="center"    bordercolor="#FEEEEE">真实姓名</td>
                  
					<td width="6%" align="center"    bordercolor="#FEEEEE" >版本</td>
					
					<td width="4%" align="center"     bordercolor="#FEEEEE" >性别</td>
					<td width="4%" align="center"     bordercolor="#FEEEEE">年龄</td>
					<td width="11%" align="center"    bordercolor="#FEEEEE"  >出生年月</td>
					<td width="10%" align="center"    bordercolor="#FEEEEE">采样师编号</td>
					 <td width="9%" align="center"    bordercolor="#FEEEEE" >采集师</td>
					<td width="11%" align="center"    bordercolor="#FEEEEE">采集日期</td>
                    <td width="19%" align="center"    bordercolor="#FEEEEE">操作</td>
                  </tr>
                  
                  
                  
                  <%for(Customer  customer:customers) {%>
                  
                  
                  <tr   bordercolor="#8FBC8F">
				    <td bgcolor="#FFFFFF"  bordercolor="#FEEEEE" ><input type="checkbox" name="delid"/></td>
				   
					<td height="20" bgcolor="#FFFFFF"  bordercolor="#FEEEEE"   align="center"><%=customer.getUserid()%></td>
                    <td bgcolor="#FFFFFF"   bordercolor="#FEEEEE"  align="center"><%=customer.getName()%></a></td>
                  
                    <td bgcolor="#FFFFFF"  bordercolor="#FEEEEE"   align="center"><%=customer.getVersion() %></td>
                    
					<td height="20" bgcolor="#FFFFFF"   bordercolor="#FEEEEE"   bordercolor="#FEEEEE"  align="center"><%=customer.getGender()%></td>
					<td height="20" bgcolor="#FFFFFF"   bordercolor="#FEEEEE"  align="center"><%=customer.getAge() %></td>
					<td height="20" bgcolor="#FFFFFF"   bordercolor="#FEEEEE"   align="center"><%=customer.getBirthday() %></td>
					<td height="20" bgcolor="#FFFFFF"   bordercolor="#FEEEEE" align="center"><%=customer.getCollId() %></td>
					<td height="20" bgcolor="#FFFFFF"   bordercolor="#FEEEEE"  align="center"><%=customer.getCollName() %></td>
					<td height="20" bgcolor="#FFFFFF"   bordercolor="#FEEEEE"  align="center"><%=customer.getColldate() %></td>
                    <td  bgcolor="#FFFFFF"   align="center">&nbsp;&nbsp;
                        <input  type="button"   value="判读"   onclick="showInter(<%=customer.getUserid()%>)" /> &nbsp;
                        <input  type="button"   value="采集"   onclick="showCollect(<%=customer.getId()%>)" />&nbsp;
                        <input  type="button"   value="分析"  onclick="showAnalysis(<%=customer.getId()%>)" />
                        <input  type="button" value="导出数据" onclick="export_package(<%=customer.getUserid()%>);" />
                        </td>
                    
                 
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
                <td width="50%">共 <span class="right-text09">15</span> 页 | 第 <span class="right-text09">1</span> 页</td>
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
	