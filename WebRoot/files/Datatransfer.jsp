<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  
    
    <title>My JSP 'Datatransfer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="text/html">
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
</head>

<body class="ContentBody">
  <form action="" method="post" enctype="multipart/form-data" name="form" target="sypost" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >采集数据转移</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="button" name="Submit" value="保存" class="button" onclick="alert('保存成功！');"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
		</td></tr>
		<tr align="center">
          <td class="TablePanel">&nbsp;</td>
		  </tr>
		<TR>
			<TD width="75%"   bgcolor="#5F9EA0">
				<fieldset style="height:100%;">
				<legend>采集数据转移</legend>
				 <center><h1>采集数据转移</h1></center>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr >
					    <td nowrap align="right" width="35%"><font  size="4">目标服务器:</font></td>
					    <td width="35%"><input name='txt3' type="text" class="text" style="width:154px" value="" />
				        <span class="red">*</span></td>
				         <td width="35%">&nbsp;</td>
					    </tr>
					    <tr >
					    <td nowrap align="right" width="35%">&nbsp;</td>
					    <td width="35%">&nbsp;</td>
				         <td width="35%">&nbsp;</td>
					    </tr>
					    
					   
						
						<tr>
					    <td nowrap align="right" width="35%"><font  size="4">目标数据库:</font></td>
					    <td width="35%"><input name='txt3' type="text" class="text" style="width:154px" value="" />				        </td>
				        			        </td>
				        <td width="35%">&nbsp;</td>	
						</tr>
						
						 <tr >
					    <td nowrap align="right" width="35%">&nbsp;</td>
					    <td width="35%">&nbsp;</td>
				         <td width="35%">&nbsp;</td>
					    </tr>
						
						
						<tr>	
							<td nowrap align="right" width="35%"><font  size="4">用&nbsp;&nbsp;&nbsp;户&nbsp;&nbsp;&nbsp;名:</font></td>
							<td width="35%">
								<input name='txt3' type="text" class="text" style="width:154px" value="" />	</td>						
							
							 <td width="35%">&nbsp;</td>
							 
				        </tr>
				        
				         <tr >
					    <td nowrap align="right" width="35%">&nbsp;</td>
					    <td width="35%">&nbsp;</td>
				         <td width="35%">&nbsp;</td>
					    </tr>
						
				        
						<tr>	
							<td nowrap align="right" width="30%"><font  size="4">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</font></td>
							<td width="35%"><input name='txt3' type="text" class="text" style="width:154px" value="" />	</td>						</td>
							<td width="35%">&nbsp;</td>             
						</tr>
						
						 <tr >
					    <td nowrap align="right" width="35%">&nbsp;</td>
					    <td width="35%">&nbsp;</td>
				         <td width="35%">&nbsp;</td>
					    </tr>
						
						 
						
					  <tr>
					    <td  width="35%" nowrap align="right"><font  size="4">上&nbsp;传&nbsp;资&nbsp;料:</font></td>
					    <td width="35%">
					          <table  width="100%"   height="140" border="1">
					               <tr  height="70">
					                   <td   width="50%"  align="center" >
					                   <label><input  name="1"  type="radio"  value=""/><font  size="4">仅上传未传资料</font></label>
					                   </td>
					                   <td   width="50%">&nbsp;</td>
					               </tr>
					               
					                <tr  height="70">
					                   <td   width="50%"    align="center">
					                   <lable><input  name="1"  type="radio"  value=""/><font  size="4">全部重新上传</font></lable>
					                   
					                   </td>
					                   <td    width="50%"><input name="xxx" type="file" class="button" id="xxx" size="35" /></td>
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
			<input type="button" name="Submit" value="确定" class="button" onclick="alert('保存成功！');"/>　
			
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
