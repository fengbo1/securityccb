<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String areaid = (String)request.getParameter("areaid");
//String chushi = new String(request.getParameter("chushi").getBytes("ISO-8859-1"),"utf-8");
String chushi = (String)request.getParameter("chushi");
String areaname = (String)request.getParameter("areaname");
String area = (String)request.getParameter("area");
System.out.print("看看新增值班页面有没有 areaid"+areaid);
%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript"> window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增排班计划</title>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>

<style type="text/css">
.aa {
	color: #FFF;
	font-weight: bold;
	text-align: center;
}
</style>

<script type="text/javascript">
function checkname1()
{
var name1=document.getElementById('name1').value;
var name1 = encodeURI(encodeURI(name1));
var names = document.getElementById('name1').value;
var areaid = document.getElementById('areaid').value;

var xmlhttp;
var xx;

	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			xx=xmlhttp.responseText;
			var arr=xx.split("￠");				
			
			if (arr[1]==0){
			   alert("您输入的姓名: "+names+" 不在本处室");
			   document.getElementById("name1").value="";
			   document.getElementById("tel1").value="";
			   document.getElementById("newnumber1").value="";
			}else{
			    document.getElementById("tel1").value=arr[2];
			    document.getElementById("newnumber1").value=arr[1];
			}		
			
		}				
	} 
	xmlhttp.open("GET","paibancheckname.action?name="+name1+"&areaid="+areaid,true);
	xmlhttp.send();
	
}

</script>

<script type="text/javascript">

function checkname2() 
{
var name2=document.getElementById('name2').value;
var name2 = encodeURI(encodeURI(name2));
var names  = document.getElementById('name2').value;
var areaid = document.getElementById('areaid').value;
var xmlhttp;
var xx;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			xx=xmlhttp.responseText;
			var arr=xx.split("￠");				
			
			if (arr[1]==0){
			   alert("您输入的姓名: "+names+" 不在本处室");
			   document.getElementById("name2").value="";
			   document.getElementById("tel2").value="";
			   document.getElementById("newnumber2").value="";
			}else{
			    document.getElementById("tel2").value=arr[2];
			    document.getElementById("newnumber2").value=arr[1];
			}		
			
		}				
	} 
	xmlhttp.open("GET","paibancheckname.action?name="+name2+"&areaid="+areaid,true);
	xmlhttp.send();
	
}
</script>

<script type="text/javascript">
function tijiao() {

var areaid = document.getElementById('areaid').value;  
var newnumber1=document.getElementById('newnumber1').value;
var newnumber2=document.getElementById('newnumber2').value;
var begindate=document.getElementById('begindate').value;
var enddate=document.getElementById('enddate').value;
var name1=document.getElementById('name1').value;
var name2=document.getElementById('name2').value;
	
	if(begindate==""){
		alert("值班开始时间不得为空");
		return false ;
	}
	if(enddate==""){
		alert("值班结束时间不得为空");
		return false ;
	}
	 if(enddate<begindate){
		alert("值班结束时间早于值班开始时间");
		return false ;
	}
	if(name1=="" && name2==""){
		alert("值班人员不得为空");
		return false ;
	}


 
var xmlhttp;
var returns;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			returns=xmlhttp.responseText;			
			var arr=returns.split("￠");	
			   
			if(arr[1]=="havepaiban"){
		      alert("此时间段内已排班，此次排班失败！");
		       return false ;
	        }
	       
	       if(arr[1]=="yes"){        
	        
	        
		      document.forms[0].submit();					 
			   
			   return true ;
		       }
			
		}					
		}				
	 
	xmlhttp.open("GET","paibancheck.action?begindate="+begindate+"&enddate="+enddate+"&areaid="+areaid,true);
	xmlhttp.send();
	
}
</script>
</head>
<body>
值班管理->新增排班计划
<form  name="fm1" action="<%=path%>/paibanadd.action?year=2" method="post" >
<table align="center">
    <input name="areaid" type="hidden" id="areaid"  value="<%=areaid %>">
    <tr><td	style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF"><b>新增排班计划</b>
			</td></tr>
	<tr class="aa">
	<td width="120" height="40" bgcolor="#188BE8">责任单位：</td>
	  <td width="220" bgcolor="#188BE8"><%=chushi %></td>
	
	<td width="120" bgcolor="#188BE8">责任区域：</td>
		<td width="180" bgcolor="#188BE8"><%=area %> </td>      
	</tr>
	
	<tr>
	<td height="30" bgcolor="#C0D3FD">值班开始日期：</td>
		<td bgcolor="#C0D3FD"> <input type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()">​</td>
	
	<td bgcolor="#C0D3FD">值班结束日期：</td>
		<td bgcolor="#C0D3FD"> <input type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()">​</td>
	</tr>
	
	<tr>
	<td height="30" bgcolor="#F0F0F0">值班人员1：</td>
	
	<td bgcolor="#F0F0F0"><input name="name1" type="text" id="name1" onchange="checkname1();">
	<input name="newnumber1" type="hidden" id="newnumber1" ></td>
	
	<td bgcolor="#F0F0F0">联系方式：</td>
		<td bgcolor="#F0F0F0"><input name="tel1" type="text" id="tel1"></td>
	</tr>
	
	<tr>
	<td height="30" bgcolor="#C0D3FD">值班人员2：</td>
		<td bgcolor="#C0D3FD"><input name="name2" type="text" id="name2" onchange="checkname2();" >
		<input name="newnumber2" type="hidden" id="newnumber2" ></td>
	
	<td bgcolor="#C0D3FD">联系方式：</td>
		<td bgcolor="#C0D3FD"><input name="tel2" type="text" id="tel2"></td>
	</tr>
	
	<tr>
	<td bgcolor="#F0F0F0" >备注：</td>
		<td bgcolor="#F0F0F0"><input name="remark" type="text" id="remark"></td>
		<td bgcolor="#F0F0F0"></td><td bgcolor="#F0F0F0"></td>
    </tr>
	
	<tr>
	<td bgcolor="#C0D3FD"></td>
    <td bgcolor="#C0D3FD" align="center"><input type="button"  onclick="tijiao()" value="提 交" ></td>
    <td bgcolor="#C0D3FD" align="center"><input type="button"  value="返 回"onclick="javascript:history.go(-1);"/></td>
    <td bgcolor="#C0D3FD"></td>
	</tr>
	
</table>
</form>

<script type="text/javascript">
function checkValue()
{
   if($(":text").value==null)
    alert("输入值不能为空");
   return;
}
</script>
</body>
<%} %>
</html>