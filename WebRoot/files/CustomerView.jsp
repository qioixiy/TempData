<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page  import="java.util.List" %>
<%@page  import="cn.fingerdata.bean.Customer"%>
<%
List<Customer> customers = (List<Customer>)request.getAttribute("customers"); 
 System.out.println(customers + " this is a");
 %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
       
    
    <title>D&B数据采集系统 by www.mycodes.net</title>
    
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
<style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->
</style>
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
    document.getElementById("fom").action="addCustomer.jsp";
   document.getElementById("fom").submit();
}

</SCRIPT>

<body>
<form name="fom" id="fom" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
 
  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="../images/nav04.gif">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="24"><img src="../images/ico07.gif" width="20" height="18" /></td>
			  <td width="600"><select name="select4">
				    <option>编号</option>
				    <option>性别</option>
				    <option>姓名</option>
				    <option>版本</option>
				    <option>采集师</option>
				    <option>判别师</option>
				    <option>生日</option>
				    <option>年龄</option>
			      </select>&nbsp;
			   <input name="textfield" type="text" size="35" readonly="readonly"/>	
			   <input name="Submit" type="button" class="right-button02" value="查 询" /></td>
			   <td width="679" align="left"><a href="#" onclick="sousuo()">
			    
			   </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>	
		    </tr>
          </table></td>
        </tr>
    </table></td></tr>
    
    <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="35"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
		           <input name="Submit" type="button" class="right-button08" value="删除所选人员" style="height: 21px; width: 100px"/> &nbsp;&nbsp;&nbsp; <a href="addCustomer.jsp" target="mainFrame" class="left-font03" onClick="tupian('21');"><input name="Submit" type="button" class="right-button08" value="添加人员信息"   style="height: 21px; width: 100px"onclick="link();  " />
		           &nbsp;&nbsp;&nbsp;&nbsp; 
		           <input type="button" name="Submit2" value="返回" class="right-button02" onclick="window.history.go(-1);"/>
		          
		           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	              </td>
          </tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="1" align="center" cellpadding="0" cellspacing="0">
	
					                  <tr>
                    <td height="30" colspan="9" align="center" bgcolor="#EEEEEE"class="tablestyle_title"><center>客户记录列表</center></td>
                    </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="1"    bordercolor="#8FBC8F"  cellpadding="4" cellspacing="0"  >
                  <tr  bgcolor="#AFEEEE">
                     <td width="5%" align="center"   bgcolor="#AFEEEE">选择</td>
				    <td width="4%" align="center"  bgcolor="#AFEEEE">序号</td>
                    <td width="6%" height="20" align="center"  bgcolor="#AFEEEE">编号</td>
                    <td width="6%" align="center"  bgcolor="#AFEEEE">姓名</td>
                    <td width="4%" align="center" bgcolor="#AEEEEE">性别</td>
                    <td width="5%" align="center" bgcolor="#AEEEEE">版本</td>
                    <td width="8%" align="center" bgcolor="#AEEEEE">出生日期</td>
                    <td width="6%" align="center" bgcolor="#AEEEEE">年龄</td>
                    <td width="8%" align="center" bgcolor="#AEEEEE">联系电话</td>
                    <td width="8%" align="center" bgcolor="#AEEEEE">采集师编号</td>
                    <td width="8%" align="center" bgcolor="#AEEEEE">采集师</td>
                  
                    <td width="8%" align="center" bgcolor="#AEEEEE">采集日期</td>
                    <td width="8%" align="center" bgcolor="#AEEEEE">判别师</td>
                    <td width="20%" align="center" bgcolor="#AEEEEE">操作</td>
                  </tr>
                  <% for(Customer customer:customers){  %> 
                   
                  
                  
                 
                  <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
				    <td bgcolor="#EEEEEE"><div align="center">1</div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center"><%=customer.getUserid()%></div> </td>
                    <td bgcolor="#FFFFFF"><div align="center"><%=customer.getName()%></div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><%=customer.getGender()%></div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><%=customer.getVersion() %></div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><%=customer.getBirthday() %></div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><%=customer.getAge() %></div></td>
                    <td bgcolor="#FFFFFF"><div align="center" ><%=customer.getPhone() %></div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><%=customer.getCollId() %></div></td>
                     <td bgcolor="#FFFFFF"><div align="center"><%=customer.getCollName() %></div></td>
                     
                     <td bgcolor="#FFFFFF"><div align="center"><%=customer.getColldate() %></div></td>
                     <td bgcolor="#FFFFFF"><div align="center"><%=customer.getDisName() %></div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><a href="CustomerInfo.jsp">查看</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;<a href="Fincollect.jsp">采集</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="FinInter.jsp">判读</a></div></td>
                  </tr>
				 <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
				    <td bgcolor="#EEEEEE"><div align="center">2</div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center">001</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">张三</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">男</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">成人</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">1990-01-11</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">18301756442</div></td>
                    <td bgcolor="#FFFFFF"><div align="center" class="top-font01">已采集</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">admin</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                  
                     <td bgcolor="#FFFFFF"><div align="center">adk</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><a href="listYuanGongGongZi.htm">查看</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">采集</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="listxianagmuxinxin.htm">判别</a></div></td>
                  </tr>
				  <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
				    <td bgcolor="#EEEEEE"><div align="center">3</div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center">001</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">张三</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">男</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">成人</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">1990-01-11</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">18301756442</div></td>
                    <td bgcolor="#FFFFFF"><div align="center" class="STYLE1">已采集</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">admin</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                    
                     <td bgcolor="#FFFFFF"><div align="center">adk</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><a href="listYuanGongGongZi.htm">查看</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">采集</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">判别</a></div></td>
                  </tr>
				 <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
				    <td bgcolor="#EEEEEE"><div align="center">4</div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center">001</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">张三</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">男</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">成人</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">1990-01-11</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">18301756442</div></td>
                    <td bgcolor="#FFFFFF"><div align="center"  class="top-font01">已采集</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">admin</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                    
                     <td bgcolor="#FFFFFF"><div align="center">adk</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><a href="listYuanGongGongZi.htm">查看</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">采集</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">判别</a></div></td>
                  </tr>
				 <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
				    <td bgcolor="#EEEEEE"><div align="center">5</div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center">001</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">张三</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">男</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">成人</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">1990-01-11</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">18301756442</div></td>
                    <td bgcolor="#FFFFFF"><div align="center" class="STYLE1">已采集</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">admin</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                    
                     <td bgcolor="#FFFFFF"><div align="center">adk</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><a href="listYuanGongGongZi.htm">查看</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">采集</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">判别</a></div></td>
                  </tr>
				 <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
				    <td bgcolor="#EEEEEE"><div align="center">6</div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center">001</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">张三</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">男</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">成人</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">1990-01-11</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">18301756442</div></td>
                    <td bgcolor="#FFFFFF"><div align="center" class="STYLE1">已采集</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">admin</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                    
                     <td bgcolor="#FFFFFF"><div align="center">adk</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><a href="listYuanGongGongZi.htm">查看</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">采集</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">判别</a></div></td>
                  </tr>
                   <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
				    <td bgcolor="#EEEEEE"><div align="center">7</div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center">001</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">张三</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">男</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">成人</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">1990-01-11</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">18301756442</div></td>
                    <td bgcolor="#FFFFFF"><div align="center" class="top-font01">已采集</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">admin</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                   
                     <td bgcolor="#FFFFFF"><div align="center">adk</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><a href="listYuanGongGongZi.htm">查看</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">采集</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">判别</a></div></td>
                  </tr>
                   <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
				    <td bgcolor="#EEEEEE"><div align="center">8</div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center">001</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">张三</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">男</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">成人</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">1990-01-11</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">18301756442</div></td>
                    <td bgcolor="#FFFFFF"><div align="center" class="STYLE1">已采集</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">admin</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                  
                     <td bgcolor="#FFFFFF"><div align="center">adk</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><a href="listYuanGongGongZi.htm">查看</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">采集</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">判别</a></div></td>
                  </tr>
                   <tr>
                   <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
				    <td bgcolor="#EEEEEE"><div align="center">9</div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center">001</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">张三</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">男</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">成人</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">1990-01-11</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">18301756442</div></td>
                    <td bgcolor="#FFFFFF"><div align="center" class="STYLE1">已采集</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">admin</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                   
                     <td bgcolor="#FFFFFF"><div align="center">adk</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><a href="listYuanGongGongZi.htm">查看</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">采集</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">判别</a></div></td>
                  </tr>
                   <tr>
                   <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
				    <td bgcolor="#EEEEEE"><div align="center">10</div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center">001</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">张三</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">男</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">成人</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">1990-01-11</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">18301756442</div></td>
                    <td bgcolor="#FFFFFF"><div align="center" class="top-font01">已采集</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">admin</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                   
                     <td bgcolor="#FFFFFF"><div align="center">adk</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><a href="listYuanGongGongZi.htm">查看</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">采集</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">判别</a></div></td>
                  </tr>
                   <tr>
                   <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
				    <td bgcolor="#EEEEEE"><div align="center">11</div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center">001</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">张三</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">男</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">成人</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">1990-01-11</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">18301756442</div></td>
                    <td bgcolor="#FFFFFF"><div align="center" class="STYLE1">已采集</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">admin</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                    
                     <td bgcolor="#FFFFFF"><div align="center">adk</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><a href="listYuanGongGongZi.htm">查看</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">采集</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">判别</a></div></td>
                  </tr>
                   <tr>
                   <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
				    <td bgcolor="#EEEEEE"><div align="center">12</div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center">001</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">张三</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">男</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">成人</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">1990-01-11</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">18301756442</div></td>
                    <td bgcolor="#FFFFFF"><div align="center" class="STYLE1">已采集</div></td>
                    <td bgcolor="#FFFFFF"><div align="center">admin</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                   
                     <td bgcolor="#FFFFFF"><div align="center">adk</div></td>
                     <td bgcolor="#FFFFFF"><div align="center">2016-04-30</div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><a href="listYuanGongGongZi.htm">查看</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">采集</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">判别</a></div></td>
                  </tr>
                   
                  <%} %>
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
 