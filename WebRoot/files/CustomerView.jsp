<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
import="java.util.List"
import="cn.fingerdata.bean.Customer"
import="cn.fingerdata.biz.impl.CustomerBizImpl"
import="cn.fingerdata.bizz.CustomerBiz"%>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

List<Customer> customers = (List<Customer>)request.getAttribute("customers"); 
System.out.println(customers);

if (customers == null) {
	CustomerBiz  customerBiz= new  CustomerBizImpl();
	customers = customerBiz.getAllCustomers();
	System.out.println(customers.size());
}

String search = request.getParameter("search");
System.out.println("search:" + search);

String page_s = request.getParameter("page");
if (page_s == null) page_s = "1";
System.out.println("page_s:" + page_s);

int page_index = Integer.valueOf(page_s);
if (page_index < 1) page_index = 1;

int page_size = 10;
int page_skip = page_index - 1;
int count = customers.size();

int page_start = 1;
int page_end = (count + page_size - 1)/page_size;
int page_back = page_index - 1;
if (page_back < page_start) page_back = page_start;
int page_front = page_index + 1;
if (page_front > page_end) page_front = page_end;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
       
     <base href="<%=basePath%>">
    <title>D&B数据采集系统 </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<link href="<%=basePath %>/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>/css/style.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>

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
    document.getElementById("fom").action="files/addCustomer.jsp";
   document.getElementById("fom").submit();
}

function showCusInfo(id){
     location.href="http://localhost:8080/TempData/CusViewServlet?type=CusInfo&id="+id;
}

function showCollect(id){
     location.href="/TempData/CusViewServlet?type=Collect&id="+id;
}

function showInter(id){
     location.href="/TempData/CusViewServlet?type=Inter&id="+id;
}

function searchConditions(){
  //获取多选框中的内容
  //获取主节点
  var s4 = document.getElementById("select4");
  var sValue = document.getElementById("textfield").value;
  
  for(var i = 0 ; i < s4.childNodes.length;i++){
   if(s4.childNodes.item(i).selected){
   alert(s4.childNodes.item(i).value+ " " +sValue);
    location.href="http://localhost:8080/TempData/CustomerS?conditions="+s4.childNodes.item(i).value+"&param="+sValue;
   }
  }
};


</SCRIPT>

<body>
<form name="fom" id="fom" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
 
  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="cusTop" height="62">
           
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="24"><img src="<%=basePath %>/images/ico07.gif" width="20" height="18" /></td>
			  <td width="600"><select id="select4" name="select4">
			        <option value="全部">全部</option>
				    <option value="编号">编号</option>
				    <option value="性别">性别</option>
				    <option value="姓名">姓名</option>
				    <option value="版本">版本</option>
				    <option value="采集师">采集师</option>
				    <option value="判别师">判别师</option>
				    <option value="生日">生日</option>
				    <option value="年龄">年龄</option>
			      </select>&nbsp;
			   <input id="textfield" name="textfield" type="text" size="35" >	
			   <input name="Submit" type="button" class="right-button02" onclick="searchConditions()" value="查 询" /></td>
			   <td width="679" align="left">&nbsp; </td>	
		    </tr>
          </table></td>
        </tr>
    </table></td></tr>
    
    <tr>
    <td><table  width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="35"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
		           <input name="Submit" type="button" class="right-button08" value="删除所选人员" style="height: 21px; width: 100px" onclick="del_user()"/> &nbsp;&nbsp;&nbsp;
		           <input name="Submit" type="button" class="right-button08" value="添加账户信息"   style="height: 21px; width: 100px" onclick="link();  " />
		           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	              </td>
          </tr>
  <tr>
    <td><table  width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="98%" border="1"    bordercolor="#8FBC8F" align="center" cellpadding="0" cellspacing="0">
	
					                  <tr>
                    <td height="30" colspan="9" align="center"  bgcolor="#5F9EA0"   bordercolor="#8FBC8F" class="tablestyle_title"><center>客户记录列表</center></td>
                    </tr>
              <tr   bordercolor="#8FBC8F"   bordercolor="#8FBC8F"   >
                <td height="40" class="font42"><table width="100%" border="1"    bordercolor="#8FBC8F"  cellpadding="4" cellspacing="1"  >
                  <tr    bgcolor="#5F9EA0"   bordercolor="#8FBC8F">
                     <td width="5%" align="center"  >选择</td>
                    <td width="6%" height="20" align="center"  >编号</td>
                    <td width="6%" align="center" >姓名</td>
                    <td width="6%" align="center" >性别</td>
                    <td width="5%" align="center" >版本</td>
                    <td width="10%" align="center" >出生日期</td>
                    <td width="6%" align="center" >年龄</td>
                    <td width="8%" align="center" >联系电话</td>
                    <td width="8%" align="center" >采集师编号</td>
                    <td width="8%" align="center" >采集师</td>
                  
                    <td width="10%" align="center" >采集日期</td>

                    <td width="30%" align="center" >操作</td>
                  </tr>
                  <%
                  int skip_count = page_skip * page_size;
                  int show_count = 0;
                  for(Customer customer:customers){
                   if(skip_count != 0) {
                   	skip_count--;
                   	continue;
                   } 
                   if (show_count++ >= page_size) {
                	   break;
                   }
                   %> 
                 
                  <tr   bordercolor="#8FBC8F">
				    <td ><input type="checkbox" name="delid"/></td>
                    <td height="20" ><div align="center"><%=customer.getUserid()%></div> </td>
                    <td ><div align="center"><%=customer.getName()%></div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><%=customer.getGender()%></div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><%=customer.getVersion() %></div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><%=customer.getBirthday() %></div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><%=customer.getAge() %></div></td>
                    <td bgcolor="#FFFFFF"><div align="center" ><%=customer.getPhone() %></div></td>
                    <td bgcolor="#FFFFFF"><div align="center"><%=customer.getCollId() %></div></td>
                     <td bgcolor="#FFFFFF"><div align="center"><%=customer.getCollName() %></div></td>
                     
                     <td bgcolor="#FFFFFF"><div align="center"><%=customer.getColldate() %></div></td>
                     
                    <td bgcolor="#FFFFFF"><div align="center">
                    <input  type="button"   value="查看"   onclick="showCusInfo(<%=customer.getUserid()%>)" />&nbsp;&nbsp;
                    <input  type="button"   value="采集"   onclick="showCollect(<%=customer.getUserid()%>)" />&nbsp;&nbsp;
                    <input  type="button"   value="判读"   onclick="showInter(<%=customer.getUserid()%>)"  /></div></td>
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
              <%
              String url = request.getScheme()+"://"+ request.getServerName()+ ":" + request.getServerPort()+request.getRequestURI();
              	System.out.println("url:" + url);
              	String url_front = url + "?page=" + page_front;
              	String url_back = url + "?page=" + page_back;
              	String url_start = url + "?page=" + page_start;
              	String url_end = url + "?page=" + page_end;
              %>
                <td width="50%">共 <span class="right-text09"><%=page_end %></span> 页 | 第 <span class="right-text09"><%=page_index %></span> 页</td>
                <td width="49%" align="right">[<a href="<%=url_start %>" class="right-font08">首页</a> | <a href="<%=url_back %>" class="right-font08">上一页</a> | <a href="<%=url_front %>" class="right-font08">下一页</a> | <a href="<%=url_end %>" class="right-font08">末页</a>]</td>
                
              </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
</body>
</html>
 