<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page  import="cn.fingerdata.bean.TempInter"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <base href="<%=basePath%>">
   
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





function link1(){
    document.getElementById("fom").action="/TempData/ListCusServlet";
   document.getElementById("fom").submit();
}

function link2(){
    document.getElementById("fom").action="files/Finanalysis.jsp";
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
<form name="fom" id="fom" action="InterServlet"  method="post" >
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
               <td height="62" background="../images/nav04.gif">
            
		            <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		                  <tr>
			                     <td width="35%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                         <input name="Submit" type="submit" class="right-button08" value="打&nbsp;开&nbsp;记&nbsp;录"   style="height: 21px; width: 100px"onclick="link1();  " />
			                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                          <input name="Submit" type="submit" class="right-button08" value="判&nbsp;读&nbsp;分&nbsp;析"   style="height: 21px; width: 100px"onclick="link2();  " />
			                           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                          <input type="button" name="Submit2" value="返回" class="right-button02" onclick="window.history.go(-1);" />
			                     </td >
			                      <td width="35%" "><center><h1>指&nbsp;纹&nbsp;判&nbsp;读&nbsp;区&nbsp;域</h1></center></td>
			                     <td width="30%" align="center">&nbsp;</td>
			    	
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
                              <td width="8%" height="60%" align="center" bgcolor="#FFFFFF"><label><input  name="L1"   type="radio"   value="L1"/>L1</label></td>
                              <td width="8%" height="60%" align="center" bgcolor="#FFFFFF"><label><input  name="L2"   type="radio"   value="L2"/>L2</label></td>
                              <td width="8%" height="60%" align="center" bgcolor="#FFFFFF"><label><input  name="L3"   type="radio"   value="L3"/>L3</label></td>
                              <td width="8%" height="60%" align="center" bgcolor="#FFFFFF"><label><input  name="L4"   type="radio"   value="L4"/>L4</label></td>
                              <td width="8%" height="60%" align="center" bgcolor="#FFFFFF"><label><input  name="L5"   type="radio"   value="L5"/>L5</label></td>
                              <td width="10%" height="60%" align="center" bgcolor="#FFFFFF" >&nbsp;</td>
                              <td width="6%" height="60%" align="right" bgcolor="#FFFFFF"><font  size="4">纹型：</font></td>
                              <td width="15%" height="60%" align="left" bgcolor="#FFFFFF" colspan="4">
                                  <select   id="temp" name="temp" style="width: 225px; height: 29px">
                            <option selected="selected">--------选择--------</option>
                            <option>螺旋斗(Ws)</option>
                            <option>靶心斗(Wt)</option>
                             <option>伸长斗(We)</option>
                            <option>双斗(Wc)</option>
                             <option>双箕(Wd)</option>
                            <option>内破斗(Wi)</option>
                             <option>尺偏斗(Wu)</option>
                            <option>闭口尺箕(UC)</option>
                            <option>桡偏斗(Wr)</option>
                            <option>闭口桡箕（Rc）</option>
                             <option>正箕（Lu）</option>
                            <option>反箕(Lr)</option>
                             <option>桡下降箕（Rf）</option>
                            <option>尺下降箕（Lf）</option>
                             <option>简单孤(As)</option>
                            <option>围住孤(Ae)</option>
                            <option>帐弧(At) </option>
                            <option>孤带正箕(AU) </option>
                             <option>孤带反箕(Ar) </option>
                            <option>斗变形(Xw )</option>
                             <option>箕变形 (Xu)</option>
                            <option>孤变形(Xa ) </option>
                             <option>无形纹(Mf)</option>
                            <option>断指纹(Ma)</option>
                           
                        </select>
                              </td>
                              
                              
                          </tr>
                             <tr>
                             
                              <td width="8%" height="0%" align="center" bgcolor="#FFFFFF"><label><input  name="R1"   type="radio"   value="R1"/>R1</label></td>
                              <td width="8%" height="40%" align="center" bgcolor="#FFFFFF"><label><input  name="R2"   type="radio"   value="R2"/>R2</label></td>
                              <td width="8%" height="40%" align="center" bgcolor="#FFFFFF"><label><input  name="R3"   type="radio"   value="R3"/>R3</label></td>
                              <td width="8%" height="40%" align="center" bgcolor="#FFFFFF"><label><input  name="R4"   type="radio"   value="R4"/>R4</label></td>
                              <td width="8%" height="40%" align="center" bgcolor="#FFFFFF"><label><input  name="R5"   type="radio"   value="R5"/>R5</label></td>
                              <td width="10%" height="40%" align="center" bgcolor="#FFFFFF">&nbsp;</td>
                              <td width="6%" height="40%" align="right" bgcolor="#FFFFFF"><font  size="4">左RC:</font></td>
                              <td width="10%" height="40%" align="left" bgcolor="#FFFFFF">
                                <input    type="text" class="text" name="L1RCL" style="width: 74px" value=""/>
                                 </td>
                              <td width="6%" height="40%" align="right" bgcolor="#FFFFFF"><font  size="4">右RC:</font></td>
                              <td width="10%" height="40%" align="left" bgcolor="#FFFFFF">
                                  <input  type="text"  class="text" name="L1RCR" style="width: 61px" value=""/>
                                </td>
                              <td width="15%" height="40%" align="center" bgcolor="#FFFFFF">
                                   <input type="submit" name="submit" value="保存" class="right-button08" />　
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


</body>
</html>
