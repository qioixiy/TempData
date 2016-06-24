<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	import="cn.fingerdata.dao1.BaseDataBaseDao"
	import="java.sql.*"
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
	
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
	
	String sql = String.format("SELECT count( * ) as rowCount FROM account");
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
	sql = String.format("SELECT * FROM `account` WHERE 1 LIMIT %d , %d", from, page_size);
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
<link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
function sousuo(){
	window.open("gaojisousuo.htm","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
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
    document.getElementById("fom").action="register.html";
   document.getElementById("fom").submit();
}

</SCRIPT>

<body>
<form name="fom" id="fom" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="../images/nav04.gif">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="24"><img src="../images/ico07.gif" width="20" height="18" /></td>
			  <td width="519"><label>编号:
			      <input name="text" type="text" nam="gongs" />
			  </label>
			    </input>
			    <input name="Submit" type="button" class="right-button02" value="查 询" /></td>
			   <td width="679" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>	
		    </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="35"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
		           <input name="Submit" type="button" class="right-button08" value="删除所选人员" style="height: 21px; width: 100px"/> &nbsp;&nbsp;&nbsp;<input name="Submit" type="button" class="right-button08" value="添加账户信息"   style="height: 21px; width: 100px"onclick="link();  " />
		           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	              </td>
          </tr>
         
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="14" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;账户信息列表&nbsp;</td>
                    </tr>
                  <tr>
				    <td width="8%" align="center" bgcolor="#EEEEEE">选择</td>
					 <td width="7%" height="20" align="center" bgcolor="#EEEEEE">序号</td>
                    <td width="11%" align="center" bgcolor="#EEEEEE">编号</td>
                    <td width="14%" align="center" bgcolor="#EEEEEE">用户名</td>
                    <td width="14%" align="center" bgcolor="#EEEEEE">姓名</td>
				    <td width="9%" align="center" bgcolor="#EEEEEE">采样</td>
					<td width="9%" align="center" bgcolor="#EEEEEE">判读</td>
					<td width="9%" align="center" bgcolor="#EEEEEE">所有人</td>
					<td width="9%" align="center" bgcolor="#EEEEEE">系统</td>
                    <td width="11%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <%
                  while(ret.next()) {
                	  String id = ret.getString("id");
                	  String accountId = ret.getString("accountId");
                	  String username = ret.getString("username");
                	  String fullname = ret.getString("fullname");
                	  String privilege = ret.getString("privilege");
                	  System.out.println("id:" + id
                			  + ",accountId:" + accountId
                			  + ",username:" + username
                			  + ",fullname:" + fullname
                			  + ",privilege:" + privilege);
                
                	  String c1 = "";
                	  String c2 = "";
                	  String c3 = "";
                	  String c4 = "";//checked="checked"
                	  
                	switch(Integer.valueOf(privilege)) {
                	case 1: c1 = "checked=\"checked\""; break;
                	case 2: c2 = "checked=\"checked\""; break;
                	case 3: c3 = "checked=\"checked\""; break;
                	case 4: c4 = "checked=\"checked\""; break;
                	}
                	  %>
                  <tr>
				    <td bgcolor="#FFFFFF"  align="center" ><input type="checkbox" name="delid"/></td>
					<td height="18" bgcolor="#EEEEEE"  align="center"><%=id %></td>
                    <td bgcolor="#FFFFFF"  align="center"><a href=""><%=accountId %></a></td>
                    <td height="20" bgcolor="#FFFFFF"  align="center"><%=username %></td>
                    <td bgcolor="#FFFFFF"   align="center"><%=fullname %></td>
                    <td bgcolor="#FFFFFF"  align="center" ><input type="checkbox" name="rest" <%=c1 %>/></td>
                     <td bgcolor="#FFFFFF"   align="center"><input type="checkbox" name="rest" <%=c2 %>/></td>
                      <td bgcolor="#FFFFFF"   align="center"><input type="checkbox" name="rest" <%=c3 %>/></td>
                       <td bgcolor="#FFFFFF"   align="center"><input type="checkbox" name="rest" <%=c4 %>/></td>
					<td bgcolor="#FFFFFF"   align="center"><a href="updateaccount.jsp">修&nbsp;&nbsp;&nbsp;改</a></td>
                  </tr>
                <% }%>
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
              <%
              	String url = request.getScheme()+"://"+ request.getServerName()+ ":" + request.getServerPort()+request.getRequestURI();
              	System.out.println("url:" + url);
              	String url_front = url + "?page=" + page_front;
              	String url_back = url + "?page=" + page_back;
              	String url_start = url + "?page=" + page_start;
              	String url_end = url + "?page=" + page_end;
              %>
                <td width="50%">共 <span class="right-text09"><%=page_end %></span> 页 | 第 <span class="right-text09"><%=page_index %></span> 页</td>
                <td width="49%" align="right">[<a href="<%=url_start %>" class="right-font08">首页</a> | <a href="<%=url_back %>" class="right-font08">上一页</a> | <a href="<%=url_front %>" class="right-font08">下一页</a> | <a href="<%=url_end %>" class="right-font08">末页</a>] 转至：</td>
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
