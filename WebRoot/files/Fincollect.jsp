<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />
	<script type="text/javascript" src="<%=basePath%>/js/ajax.js"></script>

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

function captureFrame()
{
	ajax_request("<%=basePath%>", "captureFrame");
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

function link3(){
    document.getElementById("fom").action="files/listFintype.jsp";
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
	              <input  name="Submit" type="button" class="right-button08" value="查看所有纹型" onclick="link3();"/>&nbsp;&nbsp;
	              
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
					    <td  align="left"   width="10%"><input name="text" class="text" style="width: 109px" type="text" size="40" />
				              <span class="red"> *</span></td>
					    <td align="right" width="5%">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</td>
					    <td width="10%"><input name="Input22" id="Input22" class="text" style="width:115px" /></td>
					    <td nowrap align="right" width="5%">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</td>
					    <td nowrap align="left" width="10%">
					       <input name="Input22" id="Input22" class="text" style="width:80px" />
					    </td>
					    <td nowrap align="right" width="6%">出生日期:</td>
					    <td nowrap align="left" width="10%">
					        <input name="Input22" id="Input22" class="text" style="width:115px" />
					    </td> 
					 </tr>
					 
					 <tr  bordercolor="#5F9EA0">
					  <td nowrap align="right" width="5%">采集师编号:</td>
					    <td  align="left"   width="10%"><input name="text" class="text" style="width: 109px" type="text" size="40" />
				              <span class="red"> *</span></td>
					    <td align="right" width="5%">采集师姓名:</td>
					    <td width="10%"><input name="Input22" id="Input22" class="text" style="width:115px" /></td>
					    <td nowrap align="right" width="5%"  colspan="2">&nbsp;</td>
					    
					    <td nowrap align="right" width="6%">采集日期:</td>
					    <td nowrap align="left" width="10%">
					        <input name="Input22" id="Input22" class="text" style="width:115px" />
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
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick=''/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick=''/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick=''/></td>
					                           
					                        </tr>
					                  </table>
					             
					             </td>
					           </tr>
					           
					          <tr bordercolor="#8FBC8F"  height="70" >
					             <td    align="center" >
					                  <table    width="100%"     height="70"   border="1"    bordercolor="#8FBC8F">
					                        <tr   height="35"  align="center"   bordercolor="#8FBC8F">
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick=''/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick=''/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick=''/></td>
					                           
					                        </tr>
					                  </table>
					             
					             </td>
					           </tr>
					           
					          <tr bordercolor="#8FBC8F"  height="70" >
					             <td    align="center" >
					                  <table    width="100%"     height="70"   border="1"    bordercolor="#8FBC8F">
					                        <tr   height="35"  align="center"   bordercolor="#8FBC8F">
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick=''/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick=''/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick=''/></td>
					                           
					                        </tr>
					                  </table>
					             
					             </td>
					           </tr>
					           
					           
					         <tr bordercolor="#8FBC8F"  height="70" >
					             <td    align="center" >
					                  <table    width="100%"     height="70"   border="1"    bordercolor="#8FBC8F">
					                        <tr   height="35"  align="center"   bordercolor="#8FBC8F">
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick=''/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick=''/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick=''/></td>
					                           
					                        </tr>
					                  </table>
					             
					             </td>
					           </tr>
					           
					            <tr bordercolor="#8FBC8F"  height="70" >
					             <td    align="center" >
					                  <table    width="100%"     height="70"   border="1"    bordercolor="#8FBC8F">
					                        <tr   height="35"  align="center"   bordercolor="#8FBC8F">
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick=''/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick=''/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick=''/></td>
					                           
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
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick=''/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick=''/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick=''/></td>
					                           
					                        </tr>
					                  </table>
					             
					             </td>
					           </tr>
					           
					           
					          <tr bordercolor="#8FBC8F"  height="70" >
					             <td    align="center" >
					                  <table    width="100%"     height="70"   border="1"    bordercolor="#8FBC8F">
					                        <tr   height="35"  align="center"   bordercolor="#8FBC8F">
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick=''/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick=''/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick=''/></td>
					                           
					                        </tr>
					                  </table>
					             
					             </td>
					           </tr>
					           
					           
					           <tr bordercolor="#8FBC8F"  height="70" >
					             <td    align="center" >
					                  <table    width="100%"     height="70"   border="1"    bordercolor="#8FBC8F">
					                        <tr   height="35"  align="center"   bordercolor="#8FBC8F">
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick=''/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick=''/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick=''/></td>
					                           
					                        </tr>
					                  </table>
					             
					             </td>
					           </tr>
					           
					            <tr bordercolor="#8FBC8F"  height="70" >
					             <td    align="center" >
					                  <table    width="100%"     height="70"   border="1"    bordercolor="#8FBC8F">
					                        <tr   height="35"  align="center"   bordercolor="#8FBC8F">
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick=''/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick=''/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick=''/></td>
					                           
					                        </tr>
					                  </table>
					             
					             </td>
					           </tr>
					           
					           
					           <tr bordercolor="#8FBC8F"  height="70" >
					             <td    align="center" >
					                  <table    width="100%"     height="70"   border="1"    bordercolor="#8FBC8F">
					                        <tr   height="35"  align="center"   bordercolor="#8FBC8F">
					                            <td  width="40%"  rowspan="2"><input type='button'  name='Submit2' value='正面' class='right-button02' onclick=''/></td>
					                            <td  width="60%"><input type='button'  name='Submit2' value='左面' class='right-button02' onclick=''/></td>
					                        </tr>
					                         <tr   height="35"  align="center"  bordercolor="#8FBC8F">
					                            <td  width="60%"  ><input type='button'  name='Submit2' value='右面' class='right-button02' onclick=''/></td>
					                           
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

