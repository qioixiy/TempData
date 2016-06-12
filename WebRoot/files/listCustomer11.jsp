<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
     
    <title>My JSP 'listCustomer.jsp' starting page</title>
    
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
			  <td width="600"><select name="select4" style="width: 118px; height: 19px">
				    <option>编号</option>
				    <option>性别</option>
				    <option>姓名</option>
				    <option>年龄</option>
			      </select>&nbsp;
			   <input name="textfield" type="text" size="35" readonly="readonly"/>	
			   <input name="Submit" type="button" class="right-button02" value="查 询" /></td>
			   <td width="679" align="left"><a href="#" onclick="sousuo()">
			     <input name="Submit" type="button" class="right-button07" value="高级搜索" />&nbsp;&nbsp;&nbsp;&nbsp;

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
		           <input name="Submit" type="button" class="right-button08" value="删除所选人员" style="height: 21px; width: 100px"/> &nbsp;&nbsp;&nbsp;<input name="Submit" type="button" class="right-button08" value="添加人员信息"   style="height: 21px; width: 100px"onclick="link();  " />&nbsp;&nbsp;&nbsp;
		            &nbsp;&nbsp;&nbsp;&nbsp; 
		           <input type="button" name="Submit2" value="返回" class="right-button02" onclick="window.history.go(-1);"/>
		           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		          &nbsp;&nbsp;&nbsp;
		          
		           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	              </td>
          </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="30" colspan="15" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> <center>客&nbsp;户&nbsp;记&nbsp;录&nbsp;列&nbsp;表</center></td>
                    </tr>
                  <tr>
				    <td width="6%" align="center" bgcolor="#EEEEEE">选择</td>
				    <td width="6%" align="center" bgcolor="#EEEEEE">序号</td>
					 <td width="9%" height="20" align="center" bgcolor="#EEEEEE">唯一编号</td>
                    <td width="9%" align="center" bgcolor="#EEEEEE">真实姓名</td>
                  
					<td width="9%" align="center" bgcolor="#EEEEEE">版本</td>
					
					<td width="4%" align="center" bgcolor="#EEEEEE">性别</td>
					<td width="4%" align="center" bgcolor="#EEEEEE">年龄</td>
					<td width="11%" align="center" bgcolor="#EEEEEE">出生年月</td>
					<td width="10%" align="center" bgcolor="#EEEEEE">采样师编号</td>
					<td width="11%" align="center" bgcolor="#EEEEEE">采集日期</td>
                    <td width="19%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
				    <td width="6%" align="center" bgcolor="#EEEEEE">1</td>
					<td height="20" bgcolor="#FFFFFF"   align="center"><a href="listyuangongmingxi.html">1235</a></td>
                    <td bgcolor="#FFFFFF"   align="center"><a href="listyuangongmingxi.html">张三</a></td>
                  
                    <td bgcolor="#FFFFFF"    align="center">实习</td>
                    
					<td height="20" bgcolor="#FFFFFF"   align="center">男</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">22</td>
					<td height="20" bgcolor="#FFFFFF"   align="center">1985-04-06</td>
					<td height="20" bgcolor="#FFFFFF"   align="center">123456789</td>
					<td height="20" bgcolor="#FFFFFF"   align="center">2016-05-01</td>
                    <td bgcolor="#FFFFFF"   align="center"><a href="Fincollect.jsp">采&nbsp;&nbsp;集&nbsp;&nbsp;指&nbsp;&nbsp;纹</a></td>
                  </tr>
                  <tr>
				   	<td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
				   	 <td width="6%" align="center" bgcolor="#EEEEEE">2</td>   
					<td height="20" bgcolor="#FFFFFF"    align="center">1235</td>
                    <td bgcolor="#FFFFFF"    align="center"><a href="listyuangongmingxi.html">张三</a></td>
                   
                    <td bgcolor="#FFFFFF"    align="center" >实习</td>
                   
					<td height="20" bgcolor="#FFFFFF"     align="center">男</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">22</td>
					<td height="20" bgcolor="#FFFFFF"     align="center">1985-04-06</td>
					<td height="20" bgcolor="#FFFFFF"     align="center">123456789</td>
					<td height="20" bgcolor="#FFFFFF"     align="center">2016-05-01</td>
                     <td bgcolor="#FFFFFF"    align="center"><a href="Fincollect.jsp">采&nbsp;&nbsp;集&nbsp;&nbsp;指&nbsp;&nbsp;纹</a></td></td>
                  </tr>
                  <tr>
				    	    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
				     <td width="6%" align="center" bgcolor="#EEEEEE">3</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">1235</td>
                    <td bgcolor="#FFFFFF"    align="center"><a href="listyuangongmingxi.html">张三</a></td>
                   
                    <td bgcolor="#FFFFFF"    align="center">成人</td>
                    
					<td height="20" bgcolor="#FFFFFF"    align="center">男</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">22</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">1985-04-06</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">123456789</td>
					<td height="20" bgcolor="#FFFFFF"     align="center">2016-05-01</td>
                     <td bgcolor="#FFFFFF"     align="center"><a href="Fincollect.jsp">采&nbsp;&nbsp;集&nbsp;&nbsp;指&nbsp;&nbsp;纹</a></td>
                  </tr>
                  <tr>
				      <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>	  
					<td width="6%" align="center" bgcolor="#EEEEEE">4</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">1235</td>
                    <td bgcolor="#FFFFFF"    align="center"><a href="listyuangongmingxi.html">张三</a></td>
                   
                    <td bgcolor="#FFFFFF"     align="center">儿童</td>
                    
					<td height="20" bgcolor="#FFFFFF"   align="center">男</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">22</td>
					<td height="20" bgcolor="#FFFFFF"     align="center">1985-04-06</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">123456789</td>
					<td height="20" bgcolor="#FFFFFF"     align="center">2016-05-01</td>
                     <td bgcolor="#FFFFFF"    align="center"><a href="Fincollect.jsp">采&nbsp;&nbsp;集&nbsp;&nbsp;指&nbsp;&nbsp;纹</a></td>
                  </tr>
                  <tr>
				    	    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
				    <td width="6%" align="center" bgcolor="#EEEEEE">5</td>	    
					<td height="20" bgcolor="#FFFFFF"   align="center"  >1235</td>
                    <td bgcolor="#FFFFFF"    align="center"><a href="listyuangongmingxi.html">张三</a></td>
         
                    <td bgcolor="#FFFFFF"     align="center">成人</td>
                
					<td height="20" bgcolor="#FFFFFF"    align="center">男</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">22</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">1985-04-06</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">123456789</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">2016-05-01</td>
                     <td bgcolor="#FFFFFF"    align="center"><a href="Fincollect.jsp">采&nbsp;&nbsp;集&nbsp;&nbsp;指&nbsp;&nbsp;纹</a></td>
                  </tr>
                  <tr>
				    	    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
					<td width="6%" align="center" bgcolor="#EEEEEE">6</td>
					<td height="20" bgcolor="#FFFFFF"   align="center">1235</td>
                    <td bgcolor="#FFFFFF"    align="center"><a href="listyuangongmingxi.html">张三</a></td>
                 
                    <td bgcolor="#FFFFFF"    align="center">儿童</td>
                   
					<td height="20" bgcolor="#FFFFFF"    align="center">男</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">22</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">1985-04-06</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">123456789</td>
                    <td height="20" bgcolor="#FFFFFF"     align="center">2016-05-01</td>
                     <td bgcolor="#FFFFFF"     align="center"><a href="Fincollect.jsp">采&nbsp;&nbsp;集&nbsp;&nbsp;指&nbsp;&nbsp;纹</a></td>
                  </tr>
                  <tr>
				    	    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
					<td width="6%" align="center" bgcolor="#EEEEEE">7</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">1235</td>
                    <td bgcolor="#FFFFFF"     align="center"><a href="listyuangongmingxi.html">张三</a></td>
                   
                    <td bgcolor="#FFFFFF"    align="center">成人</td>
                  
					<td height="20" bgcolor="#FFFFFF"    align="center">男</td>
					<td height="20" bgcolor="#FFFFFF"     align="center">22</td>
					<td height="20" bgcolor="#FFFFFF"     align="center">1985-04-06</td>
					<td height="20" bgcolor="#FFFFFF"      align="center">123456789</td>
					<td height="20" bgcolor="#FFFFFF"       align="center">2016-05-01</td>
                     <td bgcolor="#FFFFFF"         align="center"><a href="Fincollect.jsp">采&nbsp;&nbsp;集&nbsp;&nbsp;指&nbsp;&nbsp;纹</a></td>
                  </tr>
                  <tr>
				   	    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
					<td width="6%" align="center" bgcolor="#EEEEEE">8</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">1235</td>
                    <td bgcolor="#FFFFFF"     align="center"><a href="listyuangongmingxi.html">张三</a></td>
                  
                    <td bgcolor="#FFFFFF"   align="center" >成人</td>
                  
					<td height="20" bgcolor="#FFFFFF"    align="center">男</td>
					<td height="20" bgcolor="#FFFFFF"    align="center" >22</td>
					<td height="20" bgcolor="#FFFFFF"      align="center">1985-04-06</td>
					<td height="20" bgcolor="#FFFFFF"     align="center" >123456789</td>
					<td height="20" bgcolor="#FFFFFF"      align="center">2016-05-01</td>
                    <td bgcolor="#FFFFFF"    align="center" ><a href="Fincollect.jsp">采&nbsp;&nbsp;集&nbsp;&nbsp;指&nbsp;&nbsp;纹</a></td>
                  </tr>
                  <tr>
				   	    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
					<td width="6%" align="center" bgcolor="#EEEEEE">9</td>
					<td height="20" bgcolor="#FFFFFF"   align="center">1235</td>
                    <td bgcolor="#FFFFFF"     align="center"><a href="listyuangongmingxi.html">张三</a></td>
                  
                    <td bgcolor="#FFFFFF"    align="center">儿童</td>
                 
					<td height="20" bgcolor="#FFFFFF"   align="center" >男</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">22</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">1985-04-06</td>
					<td height="20" bgcolor="#FFFFFF"   align="center" >123456789</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">2016-05-01</td>
                    <td bgcolor="#FFFFFF"    align="center"><a href="Fincollect.jsp">采&nbsp;&nbsp;集&nbsp;&nbsp;指&nbsp;&nbsp;纹</a></a></td>
                  </tr>
                   <tr>
				   	    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
					<td width="6%" align="center" bgcolor="#EEEEEE">10</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">1235</td>
                    <td bgcolor="#FFFFFF"   align="center"  ><a href="listyuangongmingxi.html">张三</a></td>
                  
                    <td bgcolor="#FFFFFF"   align="center">儿童</td>
                 
					<td height="20" bgcolor="#FFFFFF"    align="center">男</td>
					<td height="20" bgcolor="#FFFFFF"     align="center">22</td>
					<td height="20" bgcolor="#FFFFFF"       align="center">1985-04-06</td>
					<td height="20" bgcolor="#FFFFFF"       align="center">123456789</td>
					<td height="20" bgcolor="#FFFFFF"       align="center">2016-05-01</td>
                   <td bgcolor="#FFFFFF"   align="center" ><a href="Fincollect.jsp">采&nbsp;&nbsp;集&nbsp;&nbsp;指&nbsp;&nbsp;纹</a></td>
                  </tr>
                   <tr>
				   	    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
					<td width="6%" align="center" bgcolor="#EEEEEE">11</td>
					<td height="20" bgcolor="#FFFFFF"   align="center">1235</td>
                    <td bgcolor="#FFFFFF"    align="center"><a href="listyuangongmingxi.html">张三</a></td>
                  
                    <td bgcolor="#FFFFFF"     align="center">儿童</td>
                 
					<td height="20" bgcolor="#FFFFFF"   align="center">男</td>
					<td height="20" bgcolor="#FFFFFF"   align="center">22</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">1985-04-06</td>
					<td height="20" bgcolor="#FFFFFF"     align="center">123456789</td>
					<td height="20" bgcolor="#FFFFFF"     align="center">2016-05-01</td>
                    <td bgcolor="#FFFFFF"     align="center"><a href="Fincollect.jsp">采&nbsp;&nbsp;集&nbsp;&nbsp;指&nbsp;&nbsp;纹</a></a></td>
                  </tr>
                   <tr>
				   	    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
					<td width="6%" align="center" bgcolor="#EEEEEE">12</td>
					<td height="20" bgcolor="#FFFFFF"   align="center" >1235</td>
                    <td bgcolor="#FFFFFF"    align="center"><a href="listyuangongmingxi.html">张三</a></td>
                  
                    <td bgcolor="#FFFFFF"    align="center">儿童</td>
                 
					<td height="20" bgcolor="#FFFFFF"   align="center" >男</td>
					<td height="20" bgcolor="#FFFFFF"    align="center">22</td>
					<td height="20" bgcolor="#FFFFFF"     align="center">1985-04-06</td>
					<td height="20" bgcolor="#FFFFFF"      align="center">123456789</td>
					<td height="20" bgcolor="#FFFFFF"     align="center">2016-05-01</td>
                    <td bgcolor="#FFFFFF"     align="center"><a href="Fincollect.jsp">采&nbsp;&nbsp;集&nbsp;&nbsp;指&nbsp;&nbsp;纹</a></td>
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
                <td width="50%">共 <span class="right-text09">15</span> 页 | 第 <span class="right-text09">1</span> 页</td>
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
	