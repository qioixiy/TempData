<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	import="cn.fingerdata.dao1.BaseDataBaseDao"
	import="java.sql.*"
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String url = request.getScheme()+"://"+ request.getServerName()+ ":" + request.getServerPort()+request.getRequestURI();

String search = request.getParameter("search");
if (search != null) {
	search = new String(search.getBytes("ISO-8859-1"), "UTF-8");
}
String search_type = request.getParameter("search_type");
if (search_type != null) {
	search_type = new String(search_type.getBytes("ISO-8859-1"), "UTF-8");
}
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
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath %>/css/css.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath %>/css/style.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript" src="<%=basePath%>/js/ajax.js"></script>
<script language=JavaScript>

function search_id()
{
	var search_type_i = document.getElementById("select_search_type").selectedIndex;
	var search_type_t = new Array()
	search_type_t[0] = "userid";
	search_type_t[1] = "gender";
	search_type_t[2] = "name";
	search_type_t[3] = "version";
	search_type_t[4] = "age";
	search_type_t[5] = "birthday";
	search_type_t[6] = "collId";
	search_type_t[7] = "collName";
	search_type_t[8] = "colldate";
	var search_type = search_type_t[search_type_i];
	
	var str = document.getElementById("input_search").value;
	
	if (str == "") {
		alert("请输入关键字");
		return false;
	}
	
	var url = "<%=url%>" + "?search_type=" + search_type + "&search=" + str;
	//alert(url);
	window.location=url;
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

function  showData(id, Userid){
    location.href="/TempData/DataCusServlet?type=Data&id="+id + "&Userid="+Userid;
}

</script>

<body>
<form name="fom" id="fom" method="post">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
    		<td height="30">
    		<table width="100%" border="0" cellspacing="0" cellpadding="0">
    			<tr>
		          	<td height="62" background="<%=basePath %>/images/nav04.gif">
				   	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
				    	<tr>
					  		<td width="24"><img src="<%=basePath %>/images/ico07.gif" width="20" height="18" /></td>
					  		<td width="519">
					  			<select id="select_search_type" name="select4" style="width: 118px; height: 19px">
						   			<option>编号</option>
								    <option>性别</option>
								    <option>姓名</option>
								    <option>版本</option>
								    <option>年龄</option>
								    <option>出生日期</option>
								    <option>采集师编号</option>
								    <option>采集师</option>
								    <option>采集日期</option>
			      				</select>
					  			<input id="input_search" name="text" type="text" /></input>
					    		<input name="submit" type="button" class="right-button02" value="查 询" onclick="search_id();"/>
					    	</td>
					   		<td width="679" align="left"></td>	
				    	</tr>
		          	</table>
		          	</td>
				</tr>
    		</table>
    		</td>
    	</tr>
  		<tr>
    		<td>
    			<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        		<tr>
          			<td>
          				<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
              			<tr>
                			<td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
								<tr>
                    				<td height="20" colspan="14" align="center" bgcolor="#EEEEEE"class="tablestyle_title">客户记录列表</td>
                    			</tr>
                  				<tr>
				    				<td width="2%" align="center" bgcolor="#EEEEEE">选择</td>
					 				<td width="4%" height="20" align="center" bgcolor="#EEEEEE">编号</td>
				                    <td width="8%" align="center" bgcolor="#EEEEEE">真实姓名</td>
				                    <td width="4%" align="center" bgcolor="#EEEEEE">版本</td>
				                    <td width="4%" align="center" bgcolor="#EEEEEE">性别</td>
								    <td width="4%" align="center" bgcolor="#EEEEEE">年龄</td>
									<td width="9%" align="center" bgcolor="#EEEEEE">出生年月</td>
									<td width="10%" align="center" bgcolor="#EEEEEE">采样师编号</td>
									<td width="5%" align="center" bgcolor="#EEEEEE">采集师</td>
									<td width="6%" align="center" bgcolor="#EEEEEE">采集日期</td>
				                    <td width="15%" align="center" bgcolor="#EEEEEE">操作</td>
                  				</tr>
<%
while(ret.next()) {
  	String Userid = ret.getString("userid");
  	String name = ret.getString("name");
  	String version = ret.getString("version");
  	String gender = ret.getString("gender");
  	String birthday = ret.getString("birthday");
  	String age = ret.getString("age");
  	String fphone = ret.getString("fphone");
  	String collId = ret.getString("collId");
  	String collName = ret.getString("collName");
  	String colldate = ret.getString("colldate");
  	String id = ret.getString("id");
  	String userid = ret.getString("userid");
%>
                  			<tr>
					    		<td bgcolor="#FFFFFF"  align="center" ><input id="index_id<%=userid %>" type="checkbox" name="delid"/></td>
								<td height="18" bgcolor="#EEEEEE"  align="center"><div id="index_id<%=userid %>div" > <%=userid %> </div></td>
	                    		<td bgcolor="#FFFFFF"  align="center"><a href=""><%=name %></a></td>
	                    		<td height="20" bgcolor="#FFFFFF"  align="center"><%=version %></td>
	                    		<td bgcolor="#FFFFFF"   align="center"><%=gender %></td>
	                    		<td bgcolor="#FFFFFF"   align="center"><%=age %></td>
	                    		<td bgcolor="#FFFFFF"   align="center"><%=birthday %></td>
	                    		<td bgcolor="#FFFFFF"   align="center"><%=collId %></td>
	                    		<td bgcolor="#FFFFFF"   align="center"><%=collName %></td>
	                    		<td bgcolor="#FFFFFF"   align="center"><%=colldate %></td>
								<td  bgcolor="#FFFFFF"   align="left">
			                        <input  type="button"   value="数据分析"  onclick="showData(<%=id%>, <%=Userid%>)" />
			                    </td>
                  			</tr>
<%}%>
                	</table>
                </td>
			</tr>
       					</table>
       				</td>
        		</tr>
      			</table>
      			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        		<tr>
          			<td height="6"><img src="<%=basePath %>/images/spacer.gif" width="1" height="1" /></td>
        		</tr>
        		<tr>
          			<td height="33">
          				<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              			<tr>
<%
              	System.out.println("url:" + url);
              	String url_front = url + "?page=" + page_front;
              	String url_back = url + "?page=" + page_back;
              	String url_start = url + "?page=" + page_start;
              	String url_end = url + "?page=" + page_end;
%>
                			<td width="50%">共 <span class="right-text09"><%=page_end %></span> 页 | 第 <span class="right-text09"><%=page_index %></span> 页</td>
                			<td width="49%" align="right">[
                				<a href="<%=url_start %>" class="right-font08">首页</a> | 
                				<a href="<%=url_back %>" class="right-font08">上一页</a> | 
                				<a href="<%=url_front %>" class="right-font08">下一页</a> | 
                				<a href="<%=url_end %>" class="right-font08">末页</a>]
                			</td>
                
              			</tr>
          				</table>
          			</td>
        		</tr>
      			</table>
      		</td>
  		</tr>
	</table>
</form>
</body>
</html>
