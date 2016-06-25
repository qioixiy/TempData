<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page  import="cn.fingerdata.bean.Customer" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Customer customer= (Customer)request.getAttribute("customer");

if (customer == null) {
	customer = new Customer();
    customer.setUserid(-1);
	customer.setName("");
	customer.setGender("");
    customer.setBirthday("");
    customer.setCollId(-1);
    customer.setCollName("");
    customer.setColldate("");
}

String sUserid = String.valueOf(customer.getUserid());
String sCollId = String.valueOf(customer.getCollId());
if (customer.getUserid() == -1){
	sUserid = "";
}
if (customer.getCollId() == -1){
	sCollId = "";
}

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <title>My JSP 'Fincollect.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="<%=basePath%>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>/js/ajax.js"></script>

<script language="JavaScript" type="text/javascript">

var FingerPostion = "";
function updateFP(postion)
{
	FingerPostion = postion;
}

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

function captureFrame()
{
	UserName = document.getElementById("Input22").value;
	UserNumber = document.getElementById("UserNumber").value;
	if (FingerPostion == "") {
		alert("请选择采集对应的手指");
		return;
	}
	if (UserName == "") {
		alert("用户名不能为空");
		return;
	}
	if (UserNumber == "") {
		alert("编号不能为空");
		return;
	}
	url_param = "&FingerPostion=" + FingerPostion + "&UserName=" + UserName + "&UserNumber=" + UserNumber;
	ajax_request("<%=basePath%>", "captureFrame", url_param);
}


function link0(){
alert('保存成功！');
    document.getElementById("fom").action="";
   document.getElementById("fom").submit();
}

function link1(){
    document.getElementById("fom").action="addCustomer.jsp";
   document.getElementById("fom").submit();
}

function link2(){
    document.getElementById("fom").action="CollectS";
   document.getElementById("fom").submit();
}

function link3(id){
    document.getElementById("fom").action="/TempData/CollectServlet?type=Listtype&id=" + id;
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

</script>
<style type="text/css">
<!--
.atten {font-size:18px;font-weight:normal;color:;}
-->
</style>
</head>

<body onload="on_load()">
  <form action="" method="post"  name="fom" id="fom"  >
<div class="MainDiv">

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="CContent" >
  
  
  <tr>
      <th class="tablestyle_title" >指纹采集</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		   <table  width="100%"  height="100%"  border="0" cellpadding="0" cellspacing="0" >
		         <tr>
                    
                  <td height="15">&nbsp;&nbsp;&nbsp;&nbsp;
	              <input  name="Submit" type="button" class="right-button08" value="打&nbsp;开&nbsp;记&nbsp;录"   onclick="link2();"/>&nbsp;&nbsp;&nbsp;&nbsp;
	              <input  name="Submit" type="button" class="right-button08" value="查看所有纹型" onclick="link3(<%=sUserid%>);"/>&nbsp;&nbsp;
	              
		          <input type="button" name="Submit2" value="返回" class="right-button02" onclick="window.history.go(-1);"/>
		        
	              </td>
              
               </tr>
               <tr><td>&nbsp;</td></tr>
		
		
		<tr>
			<TD width="100%" >
				<fieldset >
				<legend>基本信息</legend>
				 <table    width="100%"  border="1" cellpadding="2" cellspacing="0"  bordercolor="#5F9EA0" ">
					 
			      <tr  bordercolor="#5F9EA0">
					    <td nowrap align="right" width="5%">编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</td>
					    <td  align="left"   width="10%"><input id="UserNumber" name="text" class="text" style="width:109px" type="text" size="40" value="<%=sUserid%>"/>
				              <span class="red"> *</span></td>
					    <td align="right" width="5%">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</td>
					    <td width="10%"><input name="Input22" id="Input22" class="text" style="width:115px" value="<%=customer.getName()%>"/></td>
					    <td nowrap align="right" width="5%">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</td>
					    <td nowrap align="left" width="10%"> <%=customer.getGender()%> </td>
					    <td nowrap align="right" width="6%">出生日期:</td>
					    <td nowrap align="left" width="10%"> <%=customer.getBirthday()%> </td> 
					 </tr>
					 
					 <tr  bordercolor="#5F9EA0">
					  <td nowrap align="right" width="5%">采集师编号:</td>
					    <td  align="left"   width="10%"> <%=sCollId%> </td>
					    <td align="right" width="5%">采集师姓名:</td>
					    <td width="10%"><%=customer.getCollName()%></td>
					    <td nowrap align="right" width="5%"  colspan="2">&nbsp;</td>
					    
					    <td nowrap align="right" width="6%">采集日期:</td>
					    <td nowrap align="left" width="10%"><%=customer.getColldate()%>
					    </td> 
					 </tr>
					 </table>
			</fieldset>	
		  </td>
			</tr>
			
			
			<tr   height="350">
			<TD width="100%"   height="350" >
				<fieldset >
				<legend>采集扫描 </legend>
				 <table    width="100%"  height="350"  border="1" cellpadding="2" cellspacing="0"   bordercolor="#8FBC8F"  >
					 
			      <tr  bordercolor="#AFEEEE"   height="350" >
					    <td   width="8%" >&nbsp;</td>
					    <td   width="6%"  >
					      <table    width="100%"   height="350" border="1" cellpadding="0" cellspacing="0"  bordercolor="#8FBC8F"  > 
					        <tr bordercolor="#8FBC8F"  height="70" >
					             <td    align="center" >
					                  <table    width="100%"     height="70"   border="1"    bordercolor="#8FBC8F">
					                        <tr   height="35"  align="center"   bordercolor="#8FBC8F">
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick="updateFP('L1C')"/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick="updateFP('L1L')"/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick="updateFP('L1R')"/></td>
					                           
					                        </tr>
					                  </table>
					             
					             </td>
					           </tr>
					           
					          <tr bordercolor="#8FBC8F"  height="70" >
					             <td    align="center" >
					                  <table    width="100%"     height="70"   border="1"    bordercolor="#8FBC8F">
					                        <tr   height="35"  align="center"   bordercolor="#8FBC8F">
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick="updateFP('L2C')"/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick="updateFP('L2L')"/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick="updateFP('L2R')"/></td>
					                           
					                        </tr>
					                  </table>
					             
					             </td>
					           </tr>
					           
					          <tr bordercolor="#8FBC8F"  height="70" >
					             <td    align="center" >
					                  <table    width="100%"     height="70"   border="1"    bordercolor="#8FBC8F">
					                        <tr   height="35"  align="center"   bordercolor="#8FBC8F">
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick="updateFP('L3C')"/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick="updateFP('L3L')"/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick="updateFP('L3R')"/></td>
					                           
					                        </tr>
					                  </table>
					             
					             </td>
					           </tr>
					           
					           
					         <tr bordercolor="#8FBC8F"  height="70" >
					             <td    align="center" >
					                  <table    width="100%"     height="70"   border="1"    bordercolor="#8FBC8F">
					                        <tr   height="35"  align="center"   bordercolor="#8FBC8F">
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick="updateFP('L4C')"/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick="updateFP('L4L')"/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick="updateFP('L4R')"/></td>
					                           
					                        </tr>
					                  </table>
					             
					             </td>
					           </tr>
					           
					            <tr bordercolor="#8FBC8F"  height="70" >
					             <td    align="center" >
					                  <table    width="100%"     height="70"   border="1"    bordercolor="#8FBC8F">
					                        <tr   height="35"  align="center"   bordercolor="#8FBC8F">
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick="updateFP('L5C')"/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick="updateFP('L5L')"/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick="updateFP('L5R')"/></td>
					                           
					                        </tr>
					                  </table>
					             
					             </td>
					           </tr>
					           
					       </table>
					    
					    </td>
					    <td   width="2%"  >&nbsp;</td>
					    <td   width="20%" >
					         <table    width="100%"   height="350" border="0" cellpadding="0" cellspacing="0" bordercolor="#8FBC8F" >
					             <tr bordercolor="#8FBC8F"  height="330">
					                  <td  colspan="2"   bgcolor="#000000">
					                  	<img id="captureBmp" style="visibility:hidden;" width="100%" height="350"/>
									  </td>
					                  </tr>
					                 
					              <tr  bordercolor="#8FBC8F"   height="10">
					                  <td  width="40%"   align="left">
					      <select name="select2" style="width: 225px; height: 29px">
                            <option selected="selected">Dual  Mode  USB  Came</option>
                            <option>Dual  Mode  USB  Came</option>
                            <option>Dual  Mode  USB  Came</option>
                             <option>Dual  Mode  USB  Came</option>
                            <option>Dual  Mode  USB  Came</option>
                             <option>Dual  Mode  USB  Came</option>
                            <option>Dual  Mode  USB  Came</option>
                             <option>Dual  Mode  USB  Came</option>
                            <option>Dual  Mode  USB  Came</option>
                        </select>
					                  </td>
					                   <td width="40%"    align="right">
					                         <input name="Submit" type="button"  class="right-button08" value="采&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;集"  onclick="captureFrame();  " />
					                   </td>
					                  </tr>
					               <tr  bordercolor="#8FBC8F"  height="10">
					                  <td  width="40%"    align="left">
					                        &nbsp;
					                  </td>
					                   <td width="40%"  height="35"  align="right">
					                         &nbsp;
					                   </td>
					                  </tr>
					            </table>
					    
           </td>
					    <td   width="2%"  >&nbsp;</td>
					    <td   width="6%"   >
					      <table    width="100%"   height="350" border="1" cellpadding="0" cellspacing="0"  bordercolor="#8FBC8F" > 
					        <tr bordercolor="#8FBC8F"  height="70" >
					             <td    align="center" >
					                  <table    width="100%"     height="70"   border="1"    bordercolor="#8FBC8F">
					                        <tr   height="35"  align="center"   bordercolor="#8FBC8F">
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick="updateFP('R1C')"/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick="updateFP('R1L')"/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick="updateFP('R1R')"/></td>
					                           
					                        </tr>
					                  </table>
					             
					             </td>
					           </tr>
					           
					           
					          <tr bordercolor="#8FBC8F"  height="70" >
					             <td    align="center" >
					                  <table    width="100%"     height="70"   border="1"    bordercolor="#8FBC8F">
					                        <tr   height="35"  align="center"   bordercolor="#8FBC8F">
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick="updateFP('R2C')"/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick="updateFP('R2L')"/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick="updateFP('R2R')"/></td>
					                           
					                        </tr>
					                  </table>
					             
					             </td>
					           </tr>
					           
					           
					           <tr bordercolor="#8FBC8F"  height="70" >
					             <td    align="center" >
					                  <table    width="100%"     height="70"   border="1"    bordercolor="#8FBC8F">
					                        <tr   height="35"  align="center"   bordercolor="#8FBC8F">
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick="updateFP('R3C')"/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick="updateFP('R3L')"/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick="updateFP('R3R')"/></td>
					                           
					                        </tr>
					                  </table>
					             
					             </td>
					           </tr>
					           
					            <tr bordercolor="#8FBC8F"  height="70" >
					             <td    align="center" >
					                  <table    width="100%"     height="70"   border="1"    bordercolor="#8FBC8F">
					                        <tr   height="35"  align="center"   bordercolor="#8FBC8F">
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick="updateFP('R4C')"/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick="updateFP('R4L')"/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick="updateFP('R4R')"/></td>
					                           
					                        </tr>
					                  </table>
					             
					             </td>
					           </tr>
					           
					           
					           <tr bordercolor="#8FBC8F"  height="70" >
					             <td    align="center" >
					                  <table    width="100%"     height="70"   border="1"    bordercolor="#8FBC8F">
					                        <tr   height="35"  align="center"   bordercolor="#8FBC8F">
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick="updateFP('R5C')"/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick="updateFP('R5L')"/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick="updateFP('R5R')"/></td>
					                           
					                        </tr>
					                  </table>
					             
					             </td>
					           </tr>
					       </table>
					    </td>
				        <td   width="8%"    bordercolor="#8FBC8F">&nbsp;</td>
					   
					 </tr>
					 
					
					 </table>
					 </fieldset>	
					 </td>
			</tr>
			
					
					 
					         
					         </table>
					    
					    </td>
					 
					 </tr>
					   
			
			 <br />
	<tr> 
	   <td   width="100%">
		<table  width="100%"  height="100%"  border="0" cellpadding="0" cellspacing="0" >
		         <tr><td align="center">
		              <input type="button" name="Submit" value="保存" class="button" onclick="alert('保存成功！');"/>　
			
			        <input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/> </td></tr>
    	 
	  </table>	
	</td>
 </tr>	
  
</table>
</div>
</form>
</body>
</html>

