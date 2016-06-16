<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page  import="cn.fingerdata.bean.Customer"%>

<%
  Customer   customer = (Customer)request.getAttribute("customer");
%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  
     <base href="<%=basePath%>">
    <title>My JSP 'CustomerInfo.jsp' starting page</title>
    
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
    document.getElementById("fom").action="xuqiumingxi.html";
   document.getElementById("fom").submit();
}



 function  doSubmit(){
    document.getElementById("fom").submit();
 
 }



</SCRIPT>

<body  onload='init()'>
<form name="fom" id="fom"   action="" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="../images/nav04.gif">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="21">&nbsp;</td>
			  </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
         
              <tr>
                <td height="40" class="font42"  ><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					 <tr>
                    <td height="20" colspan="5" align="center"bgcolor="#5F9EA0"  bordercolor="#8FBC8F"    class="tablestyle_title"><center>客户资料详细信息</center> </td>
                    </tr>
                                    <tr>
                                        <td   width="30%" height="20" align="right" bgcolor="#FFFFFF">编号:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getUserid()%></td>
                                        <td   width="15%" height="20" align="right" bgcolor="#FFFFFF">姓名:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getName()%></td>
                                         <td   width="15%" bgcolor="#FFFFFF">&nbsp;</td>
                                      </tr>
                                  <tr>
                                        <td   width="30%" height="20" align="right" bgcolor="#FFFFFF">性别:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getGender()%></td>
                                        <td   width="15%" height="20" align="right" bgcolor="#FFFFFF">出生年月:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getBirthday()%></td>
                                         <td   width="15%" bgcolor="#FFFFFF">&nbsp;</td>
                                      </tr>
				     <tr>
                                        <td   width="30%" height="20" align="right" bgcolor="#FFFFFF">年龄:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getAge()%></td>
                                        <td   width="15%" height="20" align="right" bgcolor="#FFFFFF">版本:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getVersion()%></td>
                                         <td   width="15%" bgcolor="#FFFFFF">&nbsp;</td>
                                      </tr>
                   <tr>
                                        <td   width="30%" height="20" align="right" bgcolor="#FFFFFF">父亲姓名:</td>
                                        <td   width="16%" bgcolor="#FFFFFF"  align="left"><%=customer.getFatherName()%></td>
                                        <td   width="10%" height="20" align="right" bgcolor="#FFFFFF">出生年月:</td>
                                        <td   width="16%" bgcolor="#FFFFFF"  align="left"><%=customer.getFarBirthday()%></td>
                                         <td   width="28%" bgcolor="#FFFFFF">&nbsp;</td>
                                      </tr>
                    <tr>
                                        <td   width="30%" height="20" align="right" bgcolor="#FFFFFF">手机:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getFphone()%></td>
                                        <td   width="15%" height="20" align="right" bgcolor="#FFFFFF">母亲姓名:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getMatherName()%></td>
                                         <td   width="15%" bgcolor="#FFFFFF">&nbsp;</td>
                                      </tr>
                    <tr>
                                        <td   width="30%" height="20" align="right" bgcolor="#FFFFFF">出生年月:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getUserid()%></td>
                                        <td   width="15%" height="20" align="right" bgcolor="#FFFFFF">手机:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getMarBirthday()%></td>
                                         <td   width="15%" bgcolor="#FFFFFF">&nbsp;</td>
                                      </tr>
                 <tr>
                                        <td   width="30%" height="20" align="right" bgcolor="#FFFFFF">星座:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getConstellation()%></td>
                                        <td   width="15%" height="20" align="right" bgcolor="#FFFFFF">血型:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getBloodtype()%></td>
                                         <td   width="15%" bgcolor="#FFFFFF">&nbsp;</td>
                                      </tr>
                   <tr>
                                        <td   width="30%" height="20" align="right" bgcolor="#FFFFFF">职业:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getCareer()%></td>
                                        <td   width="15%" height="20" align="right" bgcolor="#FFFFFF">电话:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getPhone()%></td>
                                         <td   width="15%" bgcolor="#FFFFFF">&nbsp;</td>
                                      </tr>
                   <tr>
                                        <td   width="30%" height="20" align="right" bgcolor="#FFFFFF">QQ:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getQQ()%></td>
                                        <td   width="15%" height="20" align="right" bgcolor="#FFFFFF">MSN:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getMSN()%></td>
                                         <td   width="15%" bgcolor="#FFFFFF">&nbsp;</td>
                                      </tr>
                    <tr>
                                        <td   width="30%" height="20" align="right" bgcolor="#FFFFFF">左ATD:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getLeftATD()%></td>
                                        <td   width="15%" height="20" align="right" bgcolor="#FFFFFF">右ATD角:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getRightATD()%></td>
                                         <td   width="15%" bgcolor="#FFFFFF">&nbsp;</td>
                                      </tr>
                <tr>
                                        <td   width="30%" height="20" align="right" bgcolor="#FFFFFF">家庭住址:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getAddress()%></td>
                                        <td   width="15%" height="20" align="right" bgcolor="#FFFFFF">备注:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getNote()%></td>
                                         <td   width="15%" bgcolor="#FFFFFF">&nbsp;</td>
                                      </tr>
                   <tr>
                                        <td   width="30%" height="20" align="right" bgcolor="#FFFFFF">采集师编号:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getCollId()%></td>
                                        <td   width="15%" height="20" align="right" bgcolor="#FFFFFF">采集师姓名:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getCollName()%></td>
                                         <td   width="15%" bgcolor="#FFFFFF">&nbsp;</td>
                                      </tr>
                 <tr>
                                        <td   width="30%" height="20" align="right" bgcolor="#FFFFFF">采集日期:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getColldate()%></td>
                                        <td   width="15%" height="20" align="right" bgcolor="#FFFFFF">判读师编号:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getDisId()%></td>
                                         <td   width="15%" bgcolor="#FFFFFF">&nbsp;</td>
                                      </tr>
                <tr>
                                        <td   width="30%" height="20" align="right" bgcolor="#FFFFFF">判读师姓名:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getDisName()%></td>
                                        <td   width="15%" height="20" align="right" bgcolor="#FFFFFF">判读日期:</td>
                                        <td   width="20%" bgcolor="#FFFFFF"  align="left"><%=customer.getDisdate()%></td>
                                         <td   width="15%" bgcolor="#FFFFFF">&nbsp;</td>
                                      </tr>
                                   
                                    <tr>
                                        <td   width="100%"  height="65" align="center" bgcolor="#FFFFFF"   colspan="5">
                                        <input  type='button'  onclick='doSubmit()'   value='修改' />
                                      
                                       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                         <input  type='button'  onclick='history.back(-1)' value='返回'/>
                                         </td>
                                       
                                   </tr>
                 
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
                <td width="50%">共 <span class="right-text09">5</span> 页 | 第 <span class="right-text09">1</span> 页</td>
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
