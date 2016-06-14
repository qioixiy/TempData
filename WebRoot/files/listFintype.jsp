<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

Map<String, String> urls = (Map<String, String>)request.getAttribute("urls");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

  
    
    <title>My JSP 'listFintype.jsp' starting page</title>
    
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
    document.getElementById("fom").action="Fincollect.jsp";
   document.getElementById("fom").submit();
}

function link1(){
    document.getElementById("fom").action="listCustomer12.jsp";
   document.getElementById("fom").submit();
}


</SCRIPT>

<body>
<form name="fom" id="fom" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

 <tr>
      <td height="30">     
         <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
               <td height="62" background="../images/nav04.gif">
            
		            <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		                  <tr>
			                     <td width="5%">&nbsp;&nbsp;&nbsp;
			                     <input name="Submit" type="button" class="right-button08" value="打&nbsp;开&nbsp;记&nbsp;录"   style="height: 21px; width: 100px"onclick="link1();  " />
			                     </td >
			                     <td  width="15%" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                    <input name="Submit" type="button" class="right-button08" value="采&nbsp;集&nbsp;指&nbsp;纹"   style="height: 21px; width: 100px"onclick="link();  " />
			                     &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
		           <input type="button" name="Submit2" value="返回" class="right-button02" onclick="window.history.go(-1);"/>
			                     </td>
			                    
			                      <td width="550"><center><h1>查&nbsp;看&nbsp;所&nbsp;有&nbsp;纹&nbsp;型</h1></center></td>
			                     <td width="120" align="center"> </td>
			    	
		                 </tr>
                    </table>
                 </td>
            </tr>
          </table>
        </td>
    
  </tr>
 <tr  bordercolor="#FFFFFF">
    <td   width="100%"  height="300" class="font42">
         <table width="100%"   height="300"    border="10"   bordercolor="#5F9EA0"cellpadding="0" cellspacing="1" class="newfont03" style="height: 511px; ">
              <tr   width="100%"    bordercolor="#8FBC8F">
                 <td  width="11%"  bgcolor="#5F9EA0">&nbsp;</td> 
                 <td  width="36%">
                     <table  width="100%"  border="4"  bordercolor="#5F9EA0"  bgcolor="#5F9EA0"  cellpaddding="0"  cellspacing="5">
                         <tr  width="100%" height="8"   bgcolor="#5F9EA0"  bordercolor="#8FBC8F"  align="center"> 
                            <td colspan="3"  >左&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手</td>
                         </tr>
                         <tr  width="100%" height="70"  bgcolor="#FFFFFF"  bordercolor="#8FBC8F"  align="center"> 
                            <td  width="15%"><img id="L1L" width="70" height="70" src="<%=urls.get("L1L")%>"/></td>
                            <td  width="15%"><img id="L1C" width="70" height="70" src="<%=urls.get("L1C")%>"/></td>
                            <td  width="15%"><img id="L1R" width="70" height="70" src="<%=urls.get("L1R")%>"/></td>
                         </tr>
                         <tr  width="100%" height="5"  bordercolor="#8FBC8F"   align="center">
                             <td   width="15%">L1左面</td>
                             <td   width="15%">L1正面</td>
                             <td   width="15%">L1右面 </td>
                         </tr> 
                          <tr  width="100%" height="70"  bgcolor="#FFFFFF"  bordercolor="#8FBC8F"  align="center"> 
                            <td  width="15%"><img id="L2L" width="70" height="70" src="<%=urls.get("L2L")%>"/></td>
                            <td  width="15%"><img id="L2C" width="70" height="70" src="<%=urls.get("L2C")%>"/></td>
                            <td  width="15%"><img id="L2R" width="70" height="70" src="<%=urls.get("L2R")%>"/></td>
                         </tr>
                         <tr  width="100%" height="5"  bordercolor="#8FBC8F"   align="center">
                             <td   width="15%">L2左面</td>
                             <td   width="15%">L2正面</td>
                             <td   width="15%">L2右面 </td>
                         </tr> 
                          <tr  width="100%" height="70"  bgcolor="#FFFFFF"  bordercolor="#8FBC8F"  align="center">
                            <td  width="15%"><img id="L3L" width="70" height="70" src="<%=urls.get("L3L")%>"/></td>
                            <td  width="15%"><img id="L3C" width="70" height="70" src="<%=urls.get("L3C")%>"/></td>
                            <td  width="15%"><img id="L3R" width="70" height="70" src="<%=urls.get("L3R")%>"/></td>
                         </tr>
                         <tr  width="100%" height="5"  bordercolor="#8FBC8F"   align="center">
                             <td   width="15%">L3左面</td>
                             <td   width="15%">L3正面</td>
                             <td   width="15%">L3右面 </td>
                         </tr> 
                          <tr  width="100%" height="70"  bgcolor="#FFFFFF"  bordercolor="#8FBC8F" align="center">
                            <td  width="15%"><img id="L4L" width="70" height="70" src="<%=urls.get("L4L")%>"/></td>
                            <td  width="15%"><img id="L4C" width="70" height="70" src="<%=urls.get("L4C")%>"/></td>
                            <td  width="15%"><img id="L4R" width="70" height="70" src="<%=urls.get("L4R")%>"/></td>
                         </tr>
                         <tr  width="100%" height="5"  bordercolor="#8FBC8F"   align="center">
                             <td   width="15%">L4左面</td>
                             <td   width="15%">L4正面</td>
                             <td   width="15%">L4右面 </td>
                         </tr> 
                          <tr  width="100%" height="70"  bgcolor="#FFFFFF"  bordercolor="#8FBC8F" align="center">
                            <td  width="15%"><img id="L5L" width="70" height="70" src="<%=urls.get("L5L")%>"/></td>
                            <td  width="15%"><img id="L5C" width="70" height="70" src="<%=urls.get("L5C")%>"/></td>
                            <td  width="15%"><img id="L5R" width="70" height="70" src="<%=urls.get("L5R")%>"/></td>
                         </tr>
                         <tr  width="100%" height="5"  bordercolor="#8FBC8F"   align="center">
                             <td   width="15%">L5左面</td>
                             <td   width="15%">L5正面</td>
                             <td   width="15%">L5右面 </td>
                         </tr> 
                    
                     </table>
                 
                 
                 
                 </td>
                 
                 
           <td  width="6%"  bgcolor="#5F9EA0">&nbsp;</td> 
       <td  widyh="36%">
             <table  width="100%"  border="4"  bordercolor="#5F9EA0" bgcolor="#5F9EA0"  cellpaddding="0"  cellspacing="5">
                         <tr  width="100%" height="8"  bgcolor="#5F9EA0"  bordercolor="#8FBC8F"  align="center"> 
                            <td colspan="3"  >右&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手</td>
                         </tr>
                         <tr  width="100%" height="70"  bgcolor="#FFFFFF"  bordercolor="#8FBC8F"  align="center">
                            <td  width="15%"><img id="R1L" width="70" height="70" src="<%=urls.get("R1L")%>"/></td>
                            <td  width="15%"><img id="R1C" width="70" height="70" src="<%=urls.get("R1C")%>"/></td>
                            <td  width="15%"><img id="R1R" width="70" height="70" src="<%=urls.get("R1R")%>"/></td>
                         </tr>
                         <tr  width="100%" height="5"  bordercolor="#8FBC8F"   align="center">
                             <td   width="15%">R1左面</td>
                             <td   width="15%">R1正面</td>
                             <td   width="15%">R1右面 </td>
                         </tr> 
                          <tr  width="100%" height="70"  bgcolor="#FFFFFF"  bordercolor="#8FBC8F"  align="center">
                            <td  width="15%"><img id="R2L" width="70" height="70" src="<%=urls.get("R2L")%>"/></td>
                            <td  width="15%"><img id="R2C" width="70" height="70" src="<%=urls.get("R2C")%>"/></td>
                            <td  width="15%"><img id="R2R" width="70" height="70" src="<%=urls.get("R2R")%>"/></td>
                         </tr>
                         <tr  width="100%" height="5"  bordercolor="#8FBC8F"   align="center">
                             <td   width="15%">R2左面</td>
                             <td   width="15%">R2正面</td>
                             <td   width="15%">R2右面 </td>
                         </tr> 
                          <tr  width="100%" height="70"  bgcolor="#FFFFFF"  bordercolor="#8FBC8F"  align="center">
                            <td  width="15%"><img id="R3L" width="70" height="70" src="<%=urls.get("R3L")%>"/></td>
                            <td  width="15%"><img id="R3C" width="70" height="70" src="<%=urls.get("R3C")%>"/></td>
                            <td  width="15%"><img id="R3R" width="70" height="70" src="<%=urls.get("R3R")%>"/></td>
                         </tr>
                         <tr  width="100%" height="5"  bordercolor="#8FBC8F"   align="center">
                             <td   width="15%">R3左面</td>
                             <td   width="15%">R3正面</td>
                             <td   width="15%">R3右面 </td>
                         </tr> 
                          <tr  width="100%" height="70"  bgcolor="#FFFFFF"  bordercolor="#8FBC8F" align="center">
                            <td  width="15%"><img id="R4L" width="70" height="70" src="<%=urls.get("R4L")%>"/></td>
                            <td  width="15%"><img id="R4C" width="70" height="70" src="<%=urls.get("R4C")%>"/></td>
                            <td  width="15%"><img id="R4R" width="70" height="70" src="<%=urls.get("R4R")%>"/></td>
                         </tr>
                         <tr  width="100%" height="5"  bordercolor="#8FBC8F"   align="center">
                             <td   width="15%">R4左面</td>
                             <td   width="15%">R4正面</td>
                             <td   width="15%">R4右面 </td>
                         </tr> 
                          <tr  width="100%" height="70"  bgcolor="#FFFFFF"  bordercolor="#8FBC8F" align="center">
                            <td  width="15%"><img id="R5L" width="70" height="70" src="<%=urls.get("R5L")%>"/></td>
                            <td  width="15%"><img id="R5C" width="70" height="70" src="<%=urls.get("R5C")%>"/></td>
                            <td  width="15%"><img id="R5R" width="70" height="70" src="<%=urls.get("R5R")%>"/></td>
                         </tr>
                         <tr  width="100%" height="5"  bordercolor="#8FBC8F"   align="center">
                             <td   width="15%">R5左面</td>
                             <td   width="15%">R5正面</td>
                             <td   width="15%">R5右面 </td>
                         </tr> 
                    
                     </table>
    
                 </td>
                 
          <td  width="12%"  bgcolor="#5F9EA0">&nbsp;</td>        
              </tr>
					
					
		</table>
	</td>		
 </tr>                  
</table>
</form>
</body>
</html>
