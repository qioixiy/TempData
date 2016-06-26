<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	import="java.util.List"
	import="cn.fingerdata.bean.Customer"
	import="cn.fingerdata.dao1.BaseDataBaseDao"
	import="java.sql.*"
	import="cn.fingerdata.biz.impl.CustomerListBizImpl"
	import="cn.fingerdata.bizz.*"
%>
<%
List<Customer> customers=(List<Customer>)request.getAttribute("customers");

if (customers == null) {
	CustomerListBiz  customerListBiz= new  CustomerListBizImpl();
	customers=customerListBiz.getAllCustomers();
	System.out.println(customers.size());
}

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String url = request.getScheme()+"://"+ request.getServerName()+ ":" + request.getServerPort()+request.getRequestURI();

String search = request.getParameter("search");
String search_type = request.getParameter("search_type");
System.out.println("search:" + search + ",search_type:" + search_type);

String page_s = request.getParameter("page");
if (page_s == null) page_s = "1";
System.out.println("page_s:" + page_s);

int page_index = Integer.valueOf(page_s);
if (page_index < 1) page_index = 1;

int page_size = 10;

int page_skip = page_index - 1;

Connection conn = BaseDataBaseDao.getConnection();
Statement stmt;
stmt = conn.createStatement();

String sql = String.format("SELECT count( * ) as rowCount FROM customer");
if (search != null && search != "") {
	sql = String.format("SELECT count( * ) as rowCount FROM customer where %s = '%s'",
			search_type, search);
}
System.out.println(sql);
ResultSet ret = stmt.executeQuery(sql);
int count = 0;
if (ret.next()) {
	count = ret.getInt("rowCount");
}
System.out.println("count:" + count);

int page_start = 1;
int page_end = (count + page_size - 1)/page_size;
int page_back = page_index - 1;
if (page_back < page_start) page_back = page_start;
int page_front = page_index + 1;
if (page_front > page_end) page_front = page_end;

int from = page_skip * page_size;
sql = String.format("SELECT * FROM `customer` WHERE 1 LIMIT %d , %d", from, page_size);
if (search != null && search != "") {
	sql = String.format("SELECT * FROM `customer` WHERE %s = '%s' LIMIT %d , %d",
			search_type, search, from, page_size);
}
System.out.println(sql);
ret = stmt.executeQuery(sql);
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
<link href="<%=basePath %>/css/style.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
function sousuo(){
	
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

function link(){
    document.getElementById("fom").action="files/addCustomer.jsp";
    document.getElementById("fom").submit();
}

function  showCollect(id){
     location.href="/FPC/CollectServlet?type=Collect&id="+id;
}

function   showListtype(id){
    location.href="/FPC/CollectServlet?type=Listtype&id="+id;
}



</SCRIPT>

<body>
<form name="fom" id="fom" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="<%=basePath %>/images/nav04.gif">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
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
			   <input name="textfield" type="text" size="35" readonly="readonly"/>	
			   <input name="Submit" type="button" class="right-button02" value="查 询" /></td>
			   <td width="679" align="left">
			   </td>	
		    </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="35"><span class="newfont07">
		           <input type="button" name="Submit2" value="返回" class="right-button02" onclick="window.history.go(-1);"/>
		       </td>
          </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="1" cellpadding="4" cellspacing="1"  class="newfont03">

					                  <tr>
                    <td height="30" colspan="15" align="center"  bgcolor="#5F9EA0"  bordercolor="#8FBC8F"> <center>客&nbsp;户&nbsp;记&nbsp;录&nbsp;列&nbsp;表</center></td>
                    </tr>
                   <tr  bgcolor="#5F9EA0"   bordercolor="#8FBC8F">
				    <td width="6%" align="center" >选择</td>
				  
					 <td width="9%" height="20" align="center"> 唯一编号</td>
                    <td width="9%" align="center" >真实姓名</td>
                  
					<td width="6%" align="center" >版本</td>
					
					<td width="4%" align="center" >性别</td>
					<td width="4%" align="center" >年龄</td>
					<td width="11%" align="center" >出生年月</td>
					<td width="10%" align="center" >采样师编号</td>
					 <td width="9%" align="center" >采集师</td>
					<td width="11%" align="center" >采集日期</td>
                    <td width="19%" align="center" >操作</td>
                  </tr>
                  
                  <% while(ret.next()) {
                  	String Userid = ret.getString("userid");
                  	String name = ret.getString("name");
                  	String version = ret.getString("version");
                  	String gender = ret.getString("gender");
                  	String birthday = ret.getString("birthday");
                  	String age = ret.getString("age");
                  	String collId = ret.getString("collId");
                  	String collName = ret.getString("collName");
                  	String colldate = ret.getString("colldate");
                  	String id = ret.getString("id");
                  	String userid = ret.getString("userid");
                	  
                  %>
                  
                  <tr  bordercolor="#8FBC8F">
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
				   
					<td height="20" bgcolor="#FFFFFF"   align="center"><%=Userid%></td>
                    <td bgcolor="#FFFFFF"   align="center"><%=name%></a></td>
                  
                    <td bgcolor="#FFFFFF"    align="center"><%=version %></td>
                    
					<td height="20" bgcolor="#FFFFFF"   align="center"><%=gender%></td>
					<td height="20" bgcolor="#FFFFFF"    align="center"><%=age %></td>
					<td height="20" bgcolor="#FFFFFF"   align="center"><%=birthday%></td>
					<td height="20" bgcolor="#FFFFFF"   align="center"><%=collId%></td>
					<td height="20" bgcolor="#FFFFFF"   align="center"><%=collName%></td>
					<td height="20" bgcolor="#FFFFFF"   align="center"><%=colldate%></td>
                    <td  bgcolor="#FFFFFF"   align="center">
                        <input  type="button"   value="采集指纹"  onclick="showCollect(<%=id%>)" /> &nbsp;&nbsp;&nbsp;&nbsp;
                         <input  type="button"   value="查看纹型"  onclick="showListtype(<%=userid%>)" />
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
	