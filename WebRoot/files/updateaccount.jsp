<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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

<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
  <form action="" method="post" enctype="multipart/form-data" name="form" target="sypost" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >修改账户信息</th>
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
				<legend>修改账户信息</legend>
				 <center><h1>修改账户信息</h1></center>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr >
					    <td nowrap align="right" width="35%"><h3>编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</h4></td>
					    <td width="35%"><input name='txt3' type="text" class="text" style="width:154px" value="" />
				        <span class="red">*</span></td>
				         <td width="35%">&nbsp;</td>
					    </tr>
					    
					   
						
						<tr>
					    <td nowrap align="right" width="35%"><h3>用&nbsp;&nbsp;户&nbsp;&nbsp;名:</h3></td>
					    <td width="35%"><input name='txt3' type="text" class="text" style="width:154px" value="" /><span class="red">*</span>				        </td>
				        			      
				        <td width="35%">&nbsp;</td>	
						</tr>
						
						
						<tr>	
							<td nowrap align="right" width="35%"><h3>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</h3></td>
							<td width="35%">
								<input name='txt3' type="text" class="text" style="width:154px" value="" />	<span class="red">*</span></td>						
							
							 <td width="35%">&nbsp;</td>
				        </tr>
				        
						<tr>	
							<td nowrap align="right" width="30%"><h3>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</h3></td>
							<td width="35%"><input name='txt3' type="text" class="text" style="width:154px" value="" />	<span class="red">*</span></td>						</td>
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
							</td>
					        </tr>
					          </table>
					   </td>
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
			<input type="button" name="Submit" value="修改" class="button" onclick="alert('修改成功！');"/>　
			
			<input type="button" name="Submit2" value="取消" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
</html>
