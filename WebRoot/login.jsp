<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>D&B数据采集系统</title>
<style type="text/css">

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

input {
	margin: 10px;
	width: 150px;
}

</style>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>/js/ajax.js"></script>
<script>
function login()
{
	var username = document.getElementById("username");
	if (username.value == "") {
		alert("用户名不能为空");
		return;
	}
	var password = document.getElementById("password");
	if (password.value == "") {
		alert("密码不能为空");
		return;
	}

	ajax_request("<%=basePath%>", "login", "&username=" + username.value + "&password=" + password.value);
}

function clear_input()
{
	document.getElementById("username").value = "";
	document.getElementById("password").value = "";
}
</script>
</head>

<body>
<form  action=""   method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="147" background="images/top02.gif"><img src="images/top03.gif" width="776" height="147" /></td>
  </tr>
</table>
<table width="562" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
  <tr>
    <td width="221"><table width="95%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
      
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
          <tr>
            <td align="center"><img src="images/ico13.gif" width="107" height="97" /></td>
          </tr>
          <tr>
            <td height="40" align="center">&nbsp;</td>
          </tr>
          
        </table></td>
        <td><img src="images/line01.gif" width="5" height="292" /></td>
      </tr>
    </table></td>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="31%" height="35" class="login-text02">用户名<br /></td>
        <td width="69%"><input id="username" name="textfield" type="text" size="30" /></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">密　码<br /></td>
        <td><input id="password" name="password" type="password" size="33" /></td>
      </tr>
      <tr>
        <td height="35">&nbsp;</td>
        <td>
        	<input name="Submit" type="button" class="right-button01" value="登陆" onclick="login()" />
          	<input name="clear" type="button" class="right-button02" value="重 置" onclick="clear_input()" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>

</html>