<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 
    
    <title>D&B数据采集系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>

<script type="text/javascript" src="<%=basePath%>/js/ajax.js"></script>
<script>
function input_submit()
{
	var uid = document.getElementById("input_uid").value;
	var username = document.getElementById("input_username").value;
	var fullname = document.getElementById("input_fullname").value;
	var password1 = document.getElementById("input_password1").value;
	var password2 = document.getElementById("input_password2").value;
	
	var privilege = document.getElementById("select_privilege").selectedIndex;
	
	var param = "&uid=" + uid
			+ "&username=" + username 
			+ "&fullname=" + fullname 
			+ "&password1=" + password1
			+ "&password2=" + password2 
			+ "&privilege=" + privilege;
	//alert(param);
	if (privilege == 0) {
		alert("请选择正确的权限");
		return;
	}
	if (password1 != "" && (password1 != password2)) {
		alert("密码不正确");
		document.getElementById("input_password2").value = "";
		return;
	}
	ajax_request("<%=basePath%>", "add_user", param);
}

</script>

</head>

<body class="ContentBody">
  <form action="" method="post" enctype="multipart/form-data" name="form" target="sypost" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >新增账户信息</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr align="center">
          <td class="TablePanel">&nbsp;</td>
		  </tr>
		<TR>
			<TD width="75%"   bgcolor="#5F9EA0">
				<fieldset style="height:100%;">
				<legend>新增账户信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr >
					    <td nowrap align="right" width="35%"><h3>编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</h4></td>
					    <td width="35%"><input id="input_uid" name='txt3' type="text" class="text" style="width:154px" value="" />
				        <span class="red">*</span></td>
				         <td width="35%">&nbsp;</td>
					    </tr>
						<tr>
					    <td nowrap align="right" width="35%"><h3>用&nbsp;&nbsp;户&nbsp;&nbsp;名:</h3></td>
					    <td width="35%"><input id="input_username" name='txt3' type="text" class="text" style="width:154px" value="" /><span class="red">*</span>				        </td>
				        			      
				        <td width="35%">&nbsp;</td>	
						</tr>
						<tr>
					    <td nowrap align="right" width="35%"><h3>姓&nbsp;&nbsp;&nbsp;&nbsp;名:</h3></td>
					    <td width="35%"><input id="input_fullname" name='txt3' type="text" class="text" style="width:154px" value="" /><span class="red">*</span>				        </td>
				        			      
				        <td width="35%">&nbsp;</td>	
						</tr>
										        
						<tr>	
							<td nowrap align="right" width="30%"><h3>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</h3></td>
							<td width="35%"><input id="input_password1" name='txt3' type="password" class="text" style="width:154px" value="" />	<span class="red">*</span></td>						</td>
							<td width="35%">&nbsp;</td>             
						</tr>
						
						<tr>	
							<td nowrap align="right" width="30%"><h3>确&nbsp;认密码:</h3></td>
							<td width="35%"><input id="input_password2" name='txt3' type="password" class="text" style="width:154px" value="" /><span class="red">*</span>	</td>						</td>
							<td width="35%">&nbsp;</td>             
						</tr>
						<tr>	
							<td nowrap align="right" width="30%"><h3>权&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;限:</h3></td>
							<td width="35%">
								<select id="select_privilege" name="temp" style="width: 154px;">
		                           	 	<option selected="selected">请选择用户权限</option>
		                            	<option>采样</option>
		                            	<option>判读</option>
		                            	<option>所有人</option>
		                            	<option>系统</option>
		                            </select>
									<span class="red">*</span>
							</td>						</td>
							<td width="35%">&nbsp;</td>             
						</tr> 
						
					  </table>
			  <br />
				</fieldset>			</TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  		<TR  bgcolor="#5F9EA0">
			<TD colspan="2" align="center" height="50px">
			<input type="button" name="Submit" value="确定" class="button" onclick="input_submit();"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
</html>

</html>
