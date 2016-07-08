<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" import="com.xxx.utils.*" %>
<%@page  import="cn.fingerdata.bean.Customer" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

algorithm.algorithmOutput FinData = (algorithm.algorithmOutput)request.getAttribute("FinData");
Customer customer = (Customer)request.getAttribute("customer");

if(customer == null) {
	%><h1>请先打开客户记录</h1><%
	return;
}

int userid = customer.getUserid();

if (FinData == null) {
	System.out.print("FinData == null");
	%><h1>请先进行一次完整的指纹判读</h1><%
	return;
}

if (customer == null) {
	System.out.print("customer == null");
	return;
}

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
     <base href="<%=basePath%>">
    
    <title>My JSP 'FinData.jsp' starting page</title>
    
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
	font-size: 18px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 18px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 18px;
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

<link href="<%=basePath %>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>/js/xiangmu.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/ajax.js"></script>
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

function openlist(){
    document.getElementById("fom").action="/FPC/files/MyCustomerDataView.jsp";
   document.getElementById("fom").submit();
}
function interAnaly(){
    document.getElementById("fom").action="/FPC/CustomerServlet?type=Analysis&userid="+<%=userid%>;
   document.getElementById("fom").submit();
}

function finint(){
    document.getElementById("fom").action="/FPC/CustomerServlet?type=Inter&userid="+<%=userid%>;
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

function gen_word_pkg() {
	alert("开始生成文档");
	ajax_request("<%=basePath%>", "export_doc", "&userid="+<%=userid%>);
}

</SCRIPT>

<body onload="on_load()">
<form name="fom" id="fom" method="post" action="">
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0" >

  <tr>
     <td height="30">
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
             <tr>
                <td height="62" background="<%=basePath %>/images/nav04.gif">
          
		           <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		                 <tr>
			                 <td width="21"><img src="<%=basePath %>/images/ico07.gif" width="20" height="18" /></td>
			                  <td width="550">
			                       <select name="select2" style="width: 138px; height: 25px">
                                        <option>成人版</option>
                                        <option>儿童版</option>
                                        <option>成人版(无页眉)</option>
                                         <option>儿童版(无页眉)</option>
                           
                                   </select>&nbsp;&nbsp;&nbsp;	
			                       <input name="Submit2" type="button" class="right-button08" value="生成报表" onclick="gen_word_pkg();"/>
			                </td>
			                <td width="132" align="left">&nbsp;
			                        </a></td>	
		                    </tr>
                    </table>
                  </td>
            </tr>
       </table>
      </td>
  </tr>
  <tr>
      <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

          	 <tr>
               <td height="15">
	              <input name="Submit" type="button" class="right-button08" value="打开记录"   onclick="openlist();"/>&nbsp;&nbsp;
	              <input name="Submit2" type="button" class="right-button08" value="判读分析" onclick="interAnaly();"/>&nbsp;&nbsp;
	               <input name="Submit2" type="button" class="right-button08" value="指纹判读" onclick="finint();"/>
	               &nbsp;&nbsp;&nbsp;&nbsp;
	               <input type="button" name="Submit2" value="返回" class="right-button02" onclick="window.history.go(-1);" "/>
	              </td>
          	 </tr>
              </td>
              </tr>
            </table></td>
        </tr>
      </table>
    </tr>
 <tr>
			<TD width="100%" >
				<fieldset >
				<legend>基本信息</legend>
				 <table    width="100%"  border="1" cellpadding="4" cellspacing="2"   bordercolor="#5F9EA0" ">
					 
			      <tr  bordercolor="#5F9EA0">
					    <td nowrap align="right" width="5%">编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</td>
					    <td  align="center"   width="10%"><%=customer.getUserid()%>
				             </td>
					    <td align="right" width="5%">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</td>
					    <td width="10%"  align="center"><%=customer.getName()%></td>
					    <td nowrap align="right" width="5%">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</td>
					    <td align="center" width="10%">
					       <%=customer.getGender()%>
					    </td>
					    <td nowrap align="right" width="6%">出生日期:</td>
					    <td align="center" width="10%">
					        <%=customer.getBirthday() %>
					    </td> 
					 </tr>
					 
					 <tr  bordercolor="#5F9EA0">
					  <td nowrap align="right" width="5%">判读师编号:</td>
					    <td align="center"   width="10%"><%=customer.getDisId() %>
				            </td>
					    <td align="right" width="5%">判读师:</td>
					    <td width="10%"  align="center"><%=customer.getDisName() %></td>
					    <td nowrap align="right" width="5%"  colspan="2">&nbsp;</td>
					    
					    <td nowrap align="right" width="6%">判读日期:</td>
					    <td nowrap align="center" width="10%">
					        <%=customer.getDisdate() %>
					    </td> 
					 </tr>
					 </table>
			</fieldset>	
					 </td>
</tr>
 <tr>
	<TD width="100%"  height="605">
		<fieldset >
		<legend>数据报表</legend>
			 <table    width="100%"  border="1" cellpadding="2" cellspacing="0"  bordercolor="#8FBC8F" >
				<tr height="100"  align="center"  bordercolor="#8FBC8F">
				   <td  width="100%">
				         <table    width="100%"  border="1" cellpadding="4" cellspacing="1"  bordercolor="#8FBC8F" >
				              
				              <tr  height="40"   bordercolor="#8FBC8F"  align="center"  bgcolor="#5F9EA0">
				                 <td  width="12%"  bgcolor="#5F9EA0">脑区</td>
				                 <td  width="9%"   colspan="5"><font  size="4">右&nbsp;&nbsp;脑</font></td>
				                
				                 <td  width="9%"   colspan="5"><font  size="4">左&nbsp;&nbsp;脑</font></td>
				                
				              </tr>
				              
				              <tr  height="40"   bordercolor="#8FBC8F"  align="center"  bgcolor="#5F9EA0">
				                 <td  width="12%"  bgcolor="#5F9EA0">指位</td>
				                 <td  width="9%">L1</td>
				                 <td  width="9%">L2</td>
				                 <td  width="9%">L3</td> 
				                 <td  width="9%">L4</td>
				                 <td  width="9%">L5</td>
				                 <td  width="9%">R1</td>
				                 <td  width="9%">R2</td>
				                 <td  width="9%">R3</td> 
				                 <td  width="9%">R4</td>
				                 <td  width="8%">R5</td>
				              </tr>
				             <tr  height="40"   bordercolor="#8FBC8F"  align="center">
				                 <td  width="12%"   bgcolor="#5F9EA0">纹型代码</td>
				                  <td  width="9%"><%=FinData.L1temp %></td>
				                 <td  width="9%"><%=FinData.L2temp %></td>
				                 <td  width="9%"><%=FinData.L3temp %></td> 
				                 <td  width="9%"><%=FinData.L4temp %></td>
				                 <td  width="9%"><%=FinData.L5temp %></td>
				                 <td  width="9%"><%=FinData.R1temp %></td>
				                 <td  width="9%"><%=FinData.R2temp %></td>
				                 <td  width="9%"><%=FinData.R3temp %></td> 
				                 <td  width="9%"><%=FinData.R4temp %></td>
				                 <td  width="8%"><%=FinData.R5temp %></td>
				              </tr>
				        <tr  height="40"   bordercolor="#8FBC8F"  align="center">
				                 <td  width="12%"  bgcolor="#5F9EA0">强度排序</td>
				                 <td  width="9%"><%=FinData.intensityL1 %></td>
				                 <td  width="9%"><%=FinData.intensityL2 %></td>
				                 <td  width="9%"><%=FinData.intensityL3 %></td> 
				                 <td  width="9%"><%=FinData.intensityL4 %></td>
				                 <td  width="9%"><%=FinData.intensityL5 %></td>
				                 <td  width="9%"><%=FinData.intensityR1 %></td>
				                 <td  width="9%"><%=FinData.intensityR2 %></td>
				                 <td  width="9%"><%=FinData.intensityR3 %></td> 
				                 <td  width="9%"><%=FinData.intensityR4 %></td>
				                 <td  width="8%"><%=FinData.intensityR5 %></td>
				              </tr>
				             <tr  height="25"   bordercolor="#8FBC8F">
				                 <td  width="9%"  colspan="11">&nbsp;</td>
				                
				              </tr>
				        
				        
				         </table>
				   </td>
				
				</tr>
				
				<tr height="105"  align="center"  bordercolor="#8FBC8F">
				   <td  width="100%">
				      <table    width="100%"  border="1" cellpadding="2" cellspacing="0"  bordercolor="#8FBC8F" >
				              <tr  height="40"   bordercolor="#8FBC8F"  align="center" >
				                 <td  width="12%"   bgcolor="#5F9EA0">ATD角(L/R)</td>
				                 <td  width="44%"  bgcolor="#5F9EA0">ATD(L)</td>
				                
				                 <td  width="44%"  bgcolor="#5F9EA0">ATD(R)</td>
				               
				              </tr>
				                <tr  height="40"   bordercolor="#8FBC8F"  align="center" >
				                 <td  width="12%"   bgcolor="#5F9EA0">角度</td>
				                 <td  width="44%" ><%=customer.getLeftATD()%></td>
				                
				                 <td  width="44%"  ><%=customer.getRightATD()%></td>
				               
				              </tr>
				               <tr  height="25"   bordercolor="#8FBC8F"  align="center"  >
				                 <td  width="12%"   colspan="5">&nbsp;</td>
				                
				              </tr>
				     </table>
				   
				   
				   </td>
				
				</tr> 
				 
				<tr height="105"  align="center"  bordercolor="#8FBC8F">
				   <td  width="100%">
				        <table    width="100%"  border="1" cellpadding="4" cellspacing="2"  bordercolor="#8FBC8F" >
				              <tr  height="40"   bordercolor="#8FBC8F"  align="center"  bgcolor="#5F9EA0">
				                 <td  width="12%">思想倾向</td>
				                 <td  width="44%" ><font  size="4">左&nbsp;&nbsp;脑</font></td>
				                 
				                 <td  width="44%" ><font  size="4">右&nbsp;&nbsp;脑</font></td>
				               
				              </tr>
				                <tr  height="40"   bordercolor="#8FBC8F"  align="center"  >
				                 <td  width="12%"  bgcolor="#5F9EA0">百分比</td>
				                 <td  width="44%" ><%=FinData.LeftBrain%></td>
				                 
				                 <td  width="44%" ><%=FinData.RightBrain%></td>
				               
				              </tr>
				               <tr  height="25"   bordercolor="#8FBC8F"  align="center"  >
				                 <td  width="12%"   colspan="3">&nbsp;</td>
				                
				              </tr>
				     </table>
				   </td>
				
				</tr> 
				
				
				<tr height="105"  align="center"  bordercolor="#8FBC8F">
				   <td  width="100%">
				        <table    width="100%"  border="1" cellpadding="2" cellspacing="0"  bordercolor="#8FBC8F" >
				              <tr  height="40"   bordercolor="#8FBC8F"  align="center"  bgcolor="#5F9EA0">
				                 <td  width="12%">细化</td>
				                 <td  width="18%">对人</td>
				                 <td  width="18%">对事</td>
				                 <td  width="18%">对肢体</td>
				                 <td  width="18%">对声音</td>
				                 <td  width="17%">对视像</td>
				              </tr>
				              
				               
				               <tr  height="40"   bordercolor="#8FBC8F"  align="center" >
				                 <td  width="12%"    bgcolor="#5F9EA0">理性/感性</td>
				                  <td  width="18%"><%=FinData.reason1%>/<%=FinData.Sensibility1%></td>
				                 <td  width="18%"><%=FinData.reason2%>/<%=FinData.Sensibility2%></td>
				                 <td  width="18%"><%=FinData.reason3%>/<%=FinData.Sensibility3%></td>
				                 <td  width="18%"><%=FinData.reason4%>/<%=FinData.Sensibility4%></td>
				                 <td  width="18%"><%=FinData.reason5%>/<%=FinData.Sensibility5%></td>
				              </tr>
				               <tr  height="25"   bordercolor="#8FBC8F"  align="center"  >
				                 <td  width="12%"   colspan="6">&nbsp;</td>
				                
				              </tr>
				     </table>
				   </td>
				
				</tr> 
				<tr height="105"  align="center"  bordercolor="#8FBC8F">
				   <td  width="100%">
				     <table    width="100%"  border="1" cellpadding="2" cellspacing="0"  bordercolor="#8FBC8F" >
				              <tr  height="40"   bordercolor="#8FBC8F"  align="center"  bgcolor="#5F9EA0">
				                 <td  width="12%">学习风格</td>
				                 <td  width="29%">视觉</td>
				                 <td  width="29%">听觉</td>
				                 <td  width="30%">体觉</td>
				                 
				              </tr>
				               <tr  height="40"   bordercolor="#8FBC8F"  align="center">
				                 <td  width="12%" bgcolor="#5F9EA0" >百分比</td>
				               <td  width="29%"><%=FinData.Visual%></td>
				                 <td  width="29%"><%=FinData.AuditorySense%></td>
				                 <td  width="30%"><%=FinData.Somatosensory%></td>
				                 
				              </tr>
				               <tr  height="25"   bordercolor="#8FBC8F"  align="center"  >
				                 <td  width="12%"  colspan="4"></td>
				               
				              </tr>
				      
				      
				      </table>
				 
				</td>
				</tr> 
				
				
				<tr height="105"  align="center"  bordercolor="#8FBC8F">
				   <td  width="100%">
				      <table    width="100%"  border="1" cellpadding="2" cellspacing="0"  bordercolor="#8FBC8F" >
				              <tr  height="40"   bordercolor="#8FBC8F"  align="center" >
				                 <td  width="12%"   bgcolor="#5F9EA0">学习动机</td>
				                 <td  width="44%"  bgcolor="#5F9EA0">动机</td>
				                
				                 <td  width="44%"  bgcolor="#5F9EA0">构思</td>
				               
				              </tr>
				                <tr  height="40"   bordercolor="#8FBC8F"  align="center" >
				                 <td  width="12%"   bgcolor="#5F9EA0">百分比</td>
				                 <td  width="44%" ><%=FinData.motivation%></td>
				                
				                 <td  width="44%"  ><%=FinData.Idea%>AFRC</td>
				               
				              </tr>
				               <tr  height="25"   bordercolor="#8FBC8F"  align="center"  >
				                 <td  width="12%"   colspan="5">&nbsp;</td>
				              </tr>
				     </table>
				   </td>
				</tr> 
				<tr height="120"  align="center"  bordercolor="#8FBC8F">
				   <td  width="100%"><br />
				       <table    width="100%"  border="1" cellpadding="2" cellspacing="0"  bordercolor="#8FBC8F" >
				              <tr  height="40"   bordercolor="#8FBC8F"  align="center"  bgcolor="#5F9EA0">
				                 <td  width="12%"  bgcolor="#5F9EA0">多元智能</td>
				                 <td  width="11%">人际智能</td>
				                 <td  width="11%">内省智能</td>
				                 <td  width="11%">音乐智能</td> 
				                 <td  width="11%">语文智能</td>
				                 <td  width="11%">数学逻辑</td>
				           
				                 <td  width="11%">视觉空间</td>
				                 <td  width="11%">肢体运动</td> 
				                 <td  width="11%">自然观察</td> 
				              </tr>
				             <tr  height="40"   bordercolor="#8FBC8F"  align="center">
				                 <td  width="12%"  bgcolor="#5F9EA0">数值</td>
				                 <td  width="11%"><%=FinData.N1%></td>
				                 <td  width="11%"><%=FinData.N2%></td>
				                 <td  width="11%"><%=FinData.N3%></td> 
				                 <td  width="11%"><%=FinData.N4%></td>
				                 <td  width="11%"><%=FinData.N5%></td> 
				                 <td  width="11%"><%=FinData.N6%></td>
				                 <td  width="11%"><%=FinData.N7%></td> 
				                 <td  width="11%"><%=FinData.N8%></td> 
				              </tr>
				        <tr  height="40"   bordercolor="#8FBC8F"  align="center">
				                 <td  width="12%"  bgcolor="#5F9EA0">排序</td>
				                  <td  width="11%"><%=FinData.I1%></td>
				                 <td  width="11%"><%=FinData.I2%></td>
				                 <td  width="11%"><%=FinData.I3%></td>
				                 <td  width="11%"><%=FinData.I4%></td> 
				                 <td  width="11%"><%=FinData.I5%></td>
				                 <td  width="11%"><%=FinData.I6%></td>
				                 <td  width="11%"><%=FinData.I7%></td>
				                 <td  width="11%"><%=FinData.I8%></td>
				              </tr>
				         </table>
				   </td>
				
				</tr>
			</table>
  <br/>    
      
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="../images/spacer.gif" width="1" height="1" /></td>
        </tr>
       
      </table>
  
</form>

<div id="loadingmsg" style="width:100px; height:18px; top:0px; display:none;">
	<img src="file:///F|/项目管理相关资料/项目管理系统页面/images/loadon.gif" />
</div>

</body>
</html>
	
