<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import=" cn.fingerdata.bean.Customer" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
       <base href="<%=basePath%>">
    
    <title>客户基本信息录入</title>
    
	<meta http-equiv="Content-Type" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />


<script language="JavaScript" type="text/javascript">
function tishi()
{
  var a=confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
  if(a!=true)return false;
  window.open("冲突页.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}

function check()
{
document.getElementById("aa").style.display="";
}

function link1(){
    document.getElementById("form").action="Fincollect.jsp";
   document.getElementById("form").submit();
}

function on_load(){
	var loadingmsg=document.getElementById("loadingmsg");
	var mainpage=document.getElementById("mainpage");
	loadingmsg.style.display="";
	mainpage.style.display="none";
	
	loadingmsg.style.display="none";
	mainpage.style.display="";
}

</script>
<style type="text/css">
<!--
.atten {font-size:18px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body onload="on_load()">

  <form   name="form"   id="form" action="addCusServlet" method="post">
  
<div class="MainDiv">

<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent"   style="background-image:url(../images/nav04.gif)" >
  <tr>
      <th class="tablestyle_title" >客户基本信息录入</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="button" name="Submit" value="保存" class="button" onclick="alert('保存成功！');"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
		</td></tr>
				<TR>
			<TD width="100%"   border="10">
				<fieldset style="height:100%;">
				<legend>客户基本信息录入</legend>
					  <table border="4" cellpadding="2" cellspacing="1" style="width:100%"  bordercolor="#8FBC8F">
					 
					  <tr  bordercolor="#8FBC8F">
					    <td nowrap align="right" width="10%" style="height: 47px; ">编&nbsp;&nbsp;&nbsp;&nbsp;号:</td>
					    <td style="width:180px; height: 22px"><input  type="text" class="text" name="userid" style="width: 205px" value=""/></td>
					    <td  align="right"  style="width: 8px; ">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
					    <td width="10%"  nowrap="nowrap" style="width: 59px; "><input   type="text" name="name" style="width:205px" value=""></td>
					    <td width="20%" style="width: 25px;"  align="right">性&nbsp;&nbsp;&nbsp;&nbsp;别:</td>
					    <td  width="20%" style="width: 190px; "><select   id="gender"  name="gender" style="width: 102px; ">
                            <option selected="selected">==请选择==</option>
                            <option  value="男">男</option>
                            <option  value="女">女</option>
                        </select></td>
					  </tr>
					   <tr bordercolor="#8FBC8F">
					    <td nowrap align="right" width="10%" style="height: 47px; ">出身日期:</td>
					    <td style="width:180px; height: 22px"><input  type="text" class="text" name="birthday" style="width: 205px" value=""/></td>
					    <td  align="right"  style="width: 8px; ">年&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
					    <td width="10%"  nowrap="nowrap" style="width: 59px; "><input  type="text" class="text" name="age" style="width:205px" value=""></td>
					    <td width="20%" style="width: 25px;"  align="right">版&nbsp;&nbsp;&nbsp;&nbsp;本:</td>
					    <td  width="20%" style="width: 190px; "><select  id="version" name="version" style="width: 102px; ">
                            <option   value="成人">成人</option>
                            <option   value="儿童">儿童</option>
                           
                        </select></td>
					  </tr>
					  
					    <tr bordercolor="#8FBC8F">
					    <td nowrap align="right" width="10%" style="height: 47px; ">采集日期:</td>
					    <td style="width:180px; height: 22px"><input   type="text" class="text" name="collDate" style="width: 205px" value=""/></td>
					    <td  align="right"  style="width: 8px; ">星&nbsp;&nbsp;&nbsp;&nbsp;座：</td>
					    <td width="10%"  nowrap="nowrap" style="width: 59px; "><select  id="constellation" name="constellation" style="width: 210px; ">
                            <option selected="selected">==请选择==</option>
                            <option  value="1">摩羯座</option>
                            <option  value="2">水瓶座</option>
                            <option  value="3">双鱼座</option>
                            <option  value="4">白羊座</option>
                            <option   value="5">金牛座</option>
                            <option  value="6">双子座</option>
                            <option  value="7">巨蟹座</option>
                            <option  value="8">狮子座</option>
                            <option  value="9">处女座</option>
                            <option  value="10">天蝎座</option>
                            <option   value="11">射手座</option>
                        </select></td>
					    
					    <td width="20%" style="width: 25px;"  align="right">血&nbsp;&nbsp;&nbsp;&nbsp;型:</td>
					    <td  width="20%" style="width: 190px; "><select  id="bloodtype" name="bloodtype"  style="width: 111px; ">
                            <option selected="selected">==请选择==</option>
                            <option>A型</option>
                            <option>B型</option>
                            <option>AB型</option>
                            <option>O型</option>
                        </select></td>
					  </tr>
					  
					    <tr  bordercolor="#8FBC8F">
					    <td nowrap align="right" width="10%" style="height: 47px; ">父亲姓名:</td>
					    <td style="width:180px; height: 22px"><input  type="text" class="text" name="fatherName" style="width: 205px" value=""/></td>
					    <td  align="right"  style="width: 8px; ">出生日期：</td>
					    <td width="10%"  nowrap="nowrap" style="width: 59px; "><input  ttype="text" class="text" name="farBirthday" style="width:205px" value=""></td>
					    <td width="20%" style="width: 25px;"  align="right">手&nbsp;&nbsp;&nbsp;&nbsp;机:</td>
					    <td  width="20%" style="width: 190px; "><input  type="text"  class="text" name="fphone" style="width: 161px" value=""></td>
					  </tr>
					  
					    <tr bordercolor="#8FBC8F">
					    <td nowrap align="right" width="10%" style="height: 47px; ">母亲姓名:</td>
					    <td style="width:180px; height: 22px"><input type="text"  class="text" name="matherName" style="width: 205px" value=""/></td>
					    <td  align="right"  style="width: 8px; ">出生日期：</td>
					    <td width="10%"  nowrap="nowrap" style="width: 59px; "><input  type="text" class="text" name="marBirthday" style="width:205px" value=""></td>
					    <td width="20%" style="width: 25px;"  align="right">手&nbsp;&nbsp;&nbsp;&nbsp;机:</td>
					    <td  width="20%" style="width: 190px; "><input   type="text"   class="text" name=" mphone" style="width: 161px" value=""></td>
					  </tr>
					  
					    <tr bordercolor="#8FBC8F">
					    <td nowrap align="right" width="10%" style="height: 47px; ">职&nbsp;&nbsp;&nbsp;&nbsp;业:</td>
					    <td style="width:180px; height: 22px"><input  type="text" class="text" name="career" style="width: 205px" value=""/></td>
					    <td  align="right"  style="width: 8px; ">家庭住址：</td>
					    <td width="10%"  nowrap="nowrap" style="width: 59px; "  colspan="3"><input  type="text" class="text" name=" address" style="width: 422px; height: 26px" value=""></td>
					    
					  </tr>
					    <tr  bordercolor="#8FBC8F">
					    <td nowrap align="right" width="10%" style="height: 47px; ">电&nbsp;&nbsp;&nbsp;&nbsp;话:</td>
					    <td style="width:180px; height: 22px"><input  type="text" class="text" name="phone" style="width: 205px" value=""/></td>
					    <td  align="right"  style="width: 8px; ">QQ：</td>
					    <td width="10%"  nowrap="nowrap" style="width: 59px; "><input  type="text" class="text" name="QQ" style="width:205px" value=""></td>
					    <td width="20%" style="width: 25px;"  align="right">MSN:</td>
					    <td  width="20%" style="width: 190px; "><input  type="text" class="text" name="MSN" style="width: 161px" value="">
					  </tr>
					  
					  
					    <tr bordercolor="#8FBC8F">
					    <td nowrap align="right" width="10%" style="height: 47px; ">左ATD角:</td>
					    <td style="width:180px; height: 22px"><input  type="text" class="text" name="leftATD;" style="width: 205px" value=""/></td>
					    <td  align="right"  style="width: 8px; ">右ATD角：</td>
					    <td width="10%"  nowrap="nowrap" style="width: 59px; "><input type="text" class="text" name="rightATD" style="width:205px" value=""></td>
					    <td width="20%" style="width: 25px;"  align="right">备&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
					    <td  width="20%" style="width: 190px; "><input  type="text" class="text" name="note" style="width: 161px" value="">
					  </tr>
					  
					  </table>
			  <br />
				</fieldset>			</TD>
			
		</TR>
		
		
		
		<TR>
			<TD width="100%"   border="7"  bordercolor="#A9A9A9">
				<fieldset style="height:100%;">
				<legend>操作信息</legend>
					  <table border="4" cellpadding="2" cellspacing="0" style="width:100%"  >
					 
					  <tr  bordercolor="#8FBC8F">
					    <td nowrap align="right" width="10%" style="height: 47px; ">采集师编号:</td>
					    <td style="width: 197px; height: 22px"><input  type="text" class="text" name="collId" style="width: 205px" value=""/></td>
					    <td  align="right"  style="width: 43px; ">采集师姓名：</td>
					    <td width="10%"  nowrap="nowrap" style="width: 59px; "><input  type="text" class="text" name="collName" style="width:205px" value=""></td>
					    <td width="20%" style="width: 45px;"  align="right">采样日期</td>
					    <td  width="20%" style="width: 190px; "><input  type="text" class="text" name="colldate" style="width: 161px" value=""></td>
					  </tr>
					   <tr  bordercolor="#8FBC8F">
					    <td nowrap align="right" width="10%" style="height: 47px; ">判读师编号:</td>
					    <td style="width:180px; height: 22px"><input  type="text" class="text" name=" disId"  style="width: 205px" value=""/></td>
					    <td  align="right"  style="width: 8px; ">判读师姓名：</td>
					    <td width="10%"  nowrap="nowrap" style="width: 59px; "><input   type="text" class="text" name="disName" style="width:205px" value=""></td>
					    <td width="20%" style="width: 56px;"  align="right">判读日期</td>
					    <td  width="20%" style="width: 190px; "><input  type="text" class="text" name="disdate" style="width: 161px" value=""></td>
					  </tr>
					  
					  
					  </table>
			  <br />
				</fieldset>			</TD>
			
		</TR>
		
		

		
		
		
		</TABLE>
	
	
	 </td>
  </tr>
  
  
		
		
		
		<TR>
			<TD colspan="3" align="center" height="50px">
			<input type="submit" name="submit" value="添加" class="button" onclick="alert('保存成功！');" style="width: 71px; "/>　
			
			<input name="Submit" type="button" class="right-button08" value="开&nbsp;始&nbsp;采&nbsp;集"   onclick="link1();  " />&nbsp;&nbsp;
			<input type="submit" name="Submit" value="返回" class="button" onclick="window.history.go(-1);" style="width: 62px; "/></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  </table>

</div>
</form>
</body>
</html>
