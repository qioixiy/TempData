<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page  import="cn.fingerdata.bean.TempInter"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userid = request.getParameter("userid");
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

<link href="<%=basePath%>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>/js/xiangmu.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ajax.js"></script>
</head>
<SCRIPT language=JavaScript>

function save_data()
{
	var select_zhiwei = document.getElementById("select_zhiwei").selectedIndex;
	var select_wenxing = document.getElementById("select_wenxing").selectedIndex;
	if (select_zhiwei == 0) {
		alert("请选择指位");
		return;
	}
	if (select_wenxing == 0) {
		alert("请选择纹形");
		return;
	}
	
	var index = 1;
	var zhiwei = new Array();
	zhiwei[index++] = "L1";
	zhiwei[index++] = "L2";
	zhiwei[index++] = "L3";
	zhiwei[index++] = "L4";
	zhiwei[index++] = "L5";
	zhiwei[index++] = "R1";
	zhiwei[index++] = "R2";
	zhiwei[index++] = "R3";
	zhiwei[index++] = "R4";
	zhiwei[index++] = "R5";
	index = 1;
	var wenxing = new Array();
	wenxing[index++] = "Ws";
	wenxing[index++] = "Wt";
	wenxing[index++] = "We";
	wenxing[index++] = "Wc";
	wenxing[index++] = "Wd";
	wenxing[index++] = "Wi";
	wenxing[index++] = "Wu";
	wenxing[index++] = "UC";
	wenxing[index++] = "Wr";
	wenxing[index++] = "Rc";
	wenxing[index++] = "Lu";
	wenxing[index++] = "Lr";
	wenxing[index++] = "Rf";
	wenxing[index++] = "Lf";
	wenxing[index++] = "As";
	wenxing[index++] = "Ae";
	wenxing[index++] = "At";
	wenxing[index++] = "AU";
	wenxing[index++] = "Ar";
	wenxing[index++] = "Xw";
	wenxing[index++] = "Xu";
	wenxing[index++] = "Xa";
	wenxing[index++] = "Mf";
	wenxing[index++] = "Ma";
	
	//alert(zhiwei[select_zhiwei] + wenxing[select_wenxing]);

	var RCL = document.getElementById("input_RCL").value;
	var RCR = document.getElementById("input_RCR").value;
	
	var param = "&zhiwei="+zhiwei[select_zhiwei] + "&wenxing=" + wenxing[select_wenxing];
	param = param + "&RCL=" + RCL + "&RCR=" + RCR;
	ajax_request("<%=basePath%>", "saveRcData", param);
}

function select_onchange(value)
{
	//http://localhost:8080/TempData/ListFinType?detail=L2
	//alert(value);
	var url = "<%=basePath%>/ListFinType?detail=" + value + "&userid=" + <%=userid%>;
	//alert(url);
	url_request(url);
}
	function link2() {
		document.getElementById("fom").action = "files/Finanalysis.jsp";
		document.getElementById("fom").submit();
	}

	function on_load() {
		var loadingmsg = document.getElementById("loadingmsg");
		var mainpage = document.getElementById("mainpage");
		loadingmsg.style.display = "";
		mainpage.style.display = "none";

		loadingmsg.style.display = "none";
		mainpage.style.display = "";
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
				    
                    <td width="260px" height="300px" align="center" bgcolor="#5F9EA0">
						<img id="FinBmpL" width="100%" height="100%"/>
					</td>
                    <td width="260px" height="300px"  align="center"  bgcolor="#5F9EA0">
						<img id="FinBmpC" width="100%" height="100%"/>
					</td>
                    <td   width="260px" height="300px"  align="center" bgcolor="#5F9EA0">
						<img id="FinBmpR" width="100%" height="100%"/>
					</td> 
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
                       <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" style="height: 162px;">
                           <tr>
                              <select id="select_zhiwei" name="temp" style="width: 225px; height: 29px"  onchange="select_onchange(this.value);">
                           	 	<option selected="selected">请选择指位</option>
                            	<option>L1</option>
                            	<option>L2</option>
                            	<option>L3</option>
                            	<option>L4</option>
                            	<option>L5</option>
                            	<option>R1</option>
                            	<option>R2</option>
                            	<option>R3</option>
                            	<option>R4</option>
                            	<option>R5</option>
                            </select>
                             <select id="select_wenxing" name="temp" style="width: 225px; height: 29px">
                            	<option selected="selected" >请选择纹型</option>
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
                              <td width="10%" height="40%" align="center" bgcolor="#FFFFFF">&nbsp;</td>
                              <td width="6%" height="40%" align="right" bgcolor="#FFFFFF"><font  size="4">左RC:</font></td>
                              <td width="10%" height="40%" align="left" bgcolor="#FFFFFF">
                                <input id="input_RCL" type="text" class="text" name="RCL" style="width: 74px" value=""/>
                                 </td>
                              <td width="6%" height="40%" align="right" bgcolor="#FFFFFF"><font  size="4">右RC:</font></td>
                              <td width="10%" height="40%" align="left" bgcolor="#FFFFFF">
                                  <input id="input_RCR" type="text"  class="text" name="RCR" style="width: 61px" value=""/>
                                </td>
                              <td width="15%" height="40%" align="center" bgcolor="#FFFFFF">
                                   <input type="button" name="submit" value="保存" class="right-button08" onclick="save_data()"/>
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
