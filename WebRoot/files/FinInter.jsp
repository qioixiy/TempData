<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   
    <title>My JSP 'FinInter.jsp' starting page</title>
    
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
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/xiangmu.js"></script>
</head>
<SCRIPT language=JavaScript>
function sousuo(){
	window.open("","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
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
    document.getElementById("fom").action="xiangmu.htm";
   document.getElementById("fom").submit();
}

function link1(){
    document.getElementById("fom").action="listCustomer13.jsp";
   document.getElementById("fom").submit();
}

function link2(){
    document.getElementById("fom").action="Finanalysis.jsp";
   document.getElementById("fom").submit();
}

function on_load(){
	var loadingmsg=document.getElementById("loadingmsg");
	var mainpage=document.getElementById("mainpage");
	loadingmsg.style.display="";
	mainpage.style.display="none";
	
	loadingmsg.style.display="none";
	mainpage.style.display="";
}
</SCRIPT>

<body onload="on_load()">
<form name="fom" id="fom" method="post" action="">
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
               <td height="62" background="../images/nav04.gif">
            
		            <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		                  <tr>
			                     <td width="25%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                         <input name="Submit" type="button" class="right-button08" value="打&nbsp;开&nbsp;记&nbsp;录"   style="height: 21px; width: 100px"onclick="link1();  " />
			                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                          <input name="Submit" type="button" class="right-button08" value="判&nbsp;读&nbsp;分&nbsp;析"   style="height: 21px; width: 100px"onclick="link2();  " />
			                           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                          <input type="button" name="Submit2" value="返回" class="right-button02" onclick="window.history.go(-1);" />
			                     </td >
			                      <td width="570" "><center><h1>指&nbsp;纹&nbsp;判&nbsp;读&nbsp;区&nbsp;域</h1></center></td>
			                     <td width="110" align="center">&nbsp;</td>
			    	
		                 </tr>
                    </table>
                 </td>
            </tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0"  bordercolor="#8FBC8F">

        <tr  bordercolor="#8FBC8F">
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0"  bordercolor="#8FBC8F">

          	 
              <tr  bordercolor="#8FBC8F">
                <td height="40" class="font42"><table width="100%"       border="10"  bordercolor="#FFFFFF"cellpadding="0" cellspacing="5" class="newfont03" style="height: 511px; ">
                     
					 <tr bordercolor="#8FBC8F">
                    <td height="5" colspan="3" align="center" bordercolor="#8FBC8F" > <center>&nbsp;</center></center></td>
                    </tr>
                  <tr  bordercolor="#8FBC8F">
				    
                    <td width="25%" height="55%" align="center" bgcolor="#5F9EA0">&nbsp;</td>
                    <td width="25%" height="55%  align="center"  bgcolor="#5F9EA0">&nbsp;</td>
                    <td width="25%" height="55%   align="center" bgcolor="#5F9EA0">&nbsp;</td> 
                  </tr>
                  <tr  bordercolor="#8FBC8F">
                     <td width="25%" height="10%" align="center" bordercolor="#8FBC8F" >
                         <input name="Submit" type="button" class="right-button08" value="左&nbsp;&nbsp;面"   onclick="links();  " />
                     </td>
                     <td width="25%" height="10%" align="center" bordercolor="#8FBC8F">
                           <input name="Submit" type="button" class="right-button08" value="正&nbsp;&nbsp;面"   onclick="links();  " />
                      </td>
                     <td width="25%" height="10%" align="center" bordercolor="#8FBC8F">
                           <input name="Submit" type="button" class="right-button08" value="反&nbsp;&nbsp;面"   onclick="links();  " />
                     </td>
                  
                  </tr>
                  <tr>
                    <td  colspan="3" >
                       <table    width="95%" border="0" align="center" cellpadding="0" cellspacing="0" style="height: 162px;">
                           <tr>
                              <td width="8%" height="60%" align="center" bgcolor="#FFFFFF"   rowspan="2"><font  size="5">指位</font></td>
                              <td width="8%" height="60%" align="center" bgcolor="#FFFFFF"><label><input  name="1"   type="radio"   value=""/>L1</label></td>
                              <td width="8%" height="60%" align="center" bgcolor="#FFFFFF"><label><input  name="1"   type="radio"   value=""/>L2</label></td>
                              <td width="8%" height="60%" align="center" bgcolor="#FFFFFF"><label><input  name="1"   type="radio"   value=""/>L3</label></td>
                              <td width="8%" height="60%" align="center" bgcolor="#FFFFFF"><label><input  name="1"   type="radio"   value=""/>L4</label></td>
                              <td width="8%" height="60%" align="center" bgcolor="#FFFFFF"><label><input  name="1"   type="radio"   value=""/>L5</label></td>
                              <td width="10%" height="60%" align="center" bgcolor="#FFFFFF" >&nbsp;</td>
                              <td width="6%" height="60%" align="right" bgcolor="#FFFFFF"><font  size="4">纹型：</font></td>
                              <td width="15%" height="60%" align="left" bgcolor="#FFFFFF" colspan="4">
                                  <select name="select2" style="width: 225px; height: 29px">
                            <option selected="selected">正箕纹</option>
                            <option>反箕纹</option>
                            <option>下降箕</option>
                             <option>反下降箕</option>
                            <option>下降箕</option>
                             <option>简单弧</option>
                            <option>围住弧</option>
                             <option>帐弧纹</option>
                            <option>弧带正箕</option>
                        </select>
                              </td>
                              
                              
                          </tr>
                             <tr>
                             
                              <td width="8%" height="0%" align="center" bgcolor="#FFFFFF"><label><input  name="1"   type="radio"   value=""/>R1</label></td>
                              <td width="8%" height="40%" align="center" bgcolor="#FFFFFF"><label><input  name="1"   type="radio"   value=""/>R2</label></td>
                              <td width="8%" height="40%" align="center" bgcolor="#FFFFFF"><label><input  name="1"   type="radio"   value=""/>R3</label></td>
                              <td width="8%" height="40%" align="center" bgcolor="#FFFFFF"><label><input  name="1"   type="radio"   value=""/>R4</label></td>
                              <td width="8%" height="40%" align="center" bgcolor="#FFFFFF"><label><input  name="1"   type="radio"   value=""/>R5</label></td>
                              <td width="10%" height="40%" align="center" bgcolor="#FFFFFF">&nbsp;</td>
                              <td width="6%" height="40%" align="right" bgcolor="#FFFFFF"><font  size="4">左RC:</font></td>
                              <td width="10%" height="40%" align="left" bgcolor="#FFFFFF">
                                <input class="text" name='datevalue21' style="width: 74px" value=""/>
                                 </td>
                              <td width="6%" height="40%" align="right" bgcolor="#FFFFFF"><font  size="4">右RC:</font></td>
                              <td width="10%" height="40%" align="left" bgcolor="#FFFFFF">
                                  <input class="text" name='datevalue21' style="width: 61px" value=""/>
                                </td>
                              <td width="15%" height="40%" align="center" bgcolor="#FFFFFF">
                                   <input type="button" name="Submit" value="保存" class="right-button08" onclick="alert('保存成功！');"/>　
                              </td>
                              
                          </tr>
                       </table>
                    
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
        
      </table></td>
  </tr>
</table>
</form>

<div id="loadingmsg" style="width:100px; height:18px; top:0px; display:none;">
	<img src="file:///F|/项目管理相关资料/项目管理系统页面/images/loadon.gif" />
</div>

</body>
</html>
