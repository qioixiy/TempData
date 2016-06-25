<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
import="java.util.List"
import="cn.fingerdata.bean.Customer"
import="cn.fingerdata.biz.impl.CustomerBizImpl"
import="cn.fingerdata.bizz.CustomerBiz"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Customer> customers=(List<Customer>)request.getAttribute("customers"); 


if (customers == null) {
	CustomerBiz  customerBiz= new  CustomerBizImpl();
	customers = customerBiz.getAllCustomers();
	System.out.println(customers.size());
}

String search = request.getParameter("search");
System.out.println("search:" + search);

String page_s = request.getParameter("page");
if (page_s == null) page_s = "1";
System.out.println("page_s:" + page_s);

int page_index = Integer.valueOf(page_s);
if (page_index < 1) page_index = 1;

int page_size = 10;
int page_skip = page_index - 1;
int count = customers.size();

int page_start = 1;
int page_end = (count + page_size - 1)/page_size;
int page_back = page_index - 1;
if (page_back < page_start) page_back = page_start;
int page_front = page_index + 1;
if (page_front > page_end) page_front = page_end;
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

<link href="<%=basePath %>/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript" src="<%=basePath %>/js/ajax.js" > </script>
<link href="<%=basePath %>/css/style.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>

function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
	return false;
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
	return false;
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
          <td height="62" background="TempData/WebRoot/images/nav04.gif">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0"   >
		    <tr>
			  <td width="24"><img src="<%=basePath %>/images/ico07.gif" width="20" height="18" /></td>
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
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0"  background="<%=basePath %>/images/nav04.gif">
          	 <tr>
               <td height="35"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
		           <input name="Submit" type="button" class="right-button08" value="删除所选人员" style="height: 21px; width: 100px"/> &nbsp;&nbsp;&nbsp;<input name="Submit" type="button" class="right-button08" value="添加人员信息"   style="height: 21px; width: 100px"onclick="link1();  " />
		          <input type="file" id="file" name="myfile" />
		          <input name="Submit" type="button" class="right-button08" value="导入数据" style="height:21px; width:100px" onclick="import_package();" />
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
                    <td  bgcolor="#FFFFFF"   align="left">
                        <input type="button"  style="width:40px;height:25px;" value="判读"   onclick="showInter(<%=customer.getUserid()%>)" />
                        <input type="button" style="width:40px;height:25px;"  value="采集"   onclick="showCollect(<%=customer.getId()%>)" />
                        <input type="button" style="width:40px;height:25px;"  value="分析"  onclick="showAnalysis(<%=customer.getId()%>)" />
                        <input type="button" style="width:65px;height:25px;" value="导出数据" onclick="export_package(<%=customer.getUserid()%>);" />
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
          <td height="6"><img src="<%=basePath %>/images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
              <%
              String url = request.getScheme()+"://"+ request.getServerName()+ ":" + request.getServerPort()+request.getRequestURI();
              	System.out.println("url:" + url);
              	String url_front = url + "?page=" + page_front;
              	String url_back = url + "?page=" + page_back;
              	String url_start = url + "?page=" + page_start;
              	String url_end = url + "?page=" + page_end;
              %>
                <td width="50%">共 <span class="right-text09"><%=page_end %></span> 页 | 第 <span class="right-text09"><%=page_index %></span> 页</td>
                <td width="49%" align="right">[<a href="<%=url_start %>" class="right-font08">首页</a> | <a href="<%=url_back %>" class="right-font08">上一页</a> | <a href="<%=url_front %>" class="right-font08">下一页</a> | <a href="<%=url_end %>" class="right-font08">末页</a>]</td>
                
              </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
</body>
</html>
	