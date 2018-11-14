<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员新增页面</title>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>

<style type="text/css">
.aa {
	color: #FFF;
	font-weight: bold;
	text-align: center;
}
</style>
<script type="text/javascript">
function findareaname()
{
var chushiid=document.getElementById("chushiid").value
//alert("获取到处室id"+chushiid ) 
var areaname;
var areaid;	

var xmlhttp;	
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			//document.getElementById("newp").innerHTML=xmlhttp.responseText;
			areaname=xmlhttp.responseText;		
			//alert("查询结果"+areaname ) 
			var arr=areaname.split("￠");
			//alert("查询结果d"+arr[1] ) 
			document.getElementById("areaname").innerHTML=arr[1]
		    //document.getElementById("area").innerHTML=arr[2]
			
		}				
	} 
	xmlhttp.open("GET","UserAddAjax.action?chushiid="+chushiid,true);
	xmlhttp.send();
	
	
}
</script>
<script type="text/javascript">
function newnumbercheck()
{
 
var newnumber = document.getElementById('newnumber').value;
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
			   alert("新一代员工编号: "+newnumber+" 已存在！");
	
			   document.getElementById("newnumber").value="";
			}			
		}				
	} 
	xmlhttp.open("GET","useraddfindnewnumber.action?newnumber="+newnumber,true);
	xmlhttp.send();
	
}
</script>
<script type="text/javascript">
function tijiaocheck()
{ 
var name = document.getElementById('name').value;
var newnumber = document.getElementById('newnumber').value;
var chushiid = document.getElementById('chushiid').value;
var zhiwu = document.getElementById('zhiwu').value;
//var quanxian = document.getElementById('quanxian').value;
if (name==""){
  alert("新增人员姓名不得为空");
  return false ;
}
if (newnumber==""){
  alert("新增人员新一代员工编号不得为空");
  return false ;
}
//if(isNaN(newnumber))  
//{  
//        alert("新一代员工编号必须为纯数字！");  
 //        document.getElementById("newnumber").value="";
//        return false;  
//}   
//if(newnumber.match(/\d/g).length!=8)  
//{  
 //       alert("新一代员工编号必须为8位!");  
 //       document.getElementById("newnumber").value="";
 //        return false;  
//} 
 
if (chushiid==""){
  alert("请选择新增人员所在处室");
  return false ;
}
if (zhiwu==""){
  alert("请选择新增人员系统角色");
  return false ;
}
 document.forms[0].submit();
//if (quanxian==""){
 // alert("请选择新增人员系统权限");
 // return false ;
//}	
}
</script>

</head>
<body>
系统管理->人员管理->新增
<form name="fm1" action="<%=path%>/UserAdd.action?" method="post" >

<table height="80" align="center" cellpadding="0" cellspacing="2" border: 0px;">
    <tr>
	<td	style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"	colspan="11" align="center" bordercolor="#FFFFFF">
	   <b>人员新增</b>						
	</td>
	</tr>

	<tr  class="aa">
	<td height="40" bgcolor="#188BE8">员工姓名：</td>
	<td bgcolor="#F0F0F0">
		<input name="name" type="text" id="name" >
	</td>		
	</tr>
	<tr  class="aa">
	<td height="40" bgcolor="#188BE8" >新一代员工编号：</td>
	<td bgcolor="#F0F0F0">
		<input name="newnumber" type="text" id="newnumber" onchange="newnumbercheck()">
	</td>		
	</tr>
	<tr  class="aa">
	<td height="40" bgcolor="#188BE8">处室名称：</td>
	<td bgcolor="#F0F0F0"  >	
		<select id="chushiid" name="chushiid"  style="width:170px">  
								<option value="">请选择所在处室 </option>  
                                <c:forEach var="chu" items="${chulist}" varStatus="status">  
                                <option  value="${chu.chushiid}">${chu.chushi}</option>  
                                </c:forEach>  
        </select> 
    </td>		
	</tr>	
	<tr  class="aa">
	<td height="40" bgcolor="#188BE8" width="170px">系统角色：</td>
	<td bgcolor="#F0F0F0" width="170px" align="center">
		<select id="zhiwu" name="zhiwu" style="width:170px">       
		 <option value="">请选择系统角色</option>                           
            <option value="13">机构主要负责人</option>  
            <option value="14">机构主要负责人（分管安保）</option> 
            <option value="23">机构其他负责人</option> 
            <option value="24">机构其他负责人（分管安保）</option> 
            
            <option value="33">综合部门负责人</option> 
            <option value="51">机构安全岗</option> 
            <option value="52">处室安全岗</option> 
            <option value="53">普通员工</option> 
                         
        </select> 
	</td>		
	</tr>	
<!--  	<tr  class="aa">
	<td height="30" bgcolor="#C0D3FD">系统权限：</td>
	<td bgcolor="#F0F0F0">
		<select id="quanxian" name="quanxian" >   
		    <option value="">请选择系统权限</option>                                
            <option value="1">机构安全岗</option>  
            <option value="2">处室安全岗</option> 
            <option value="3">普通员工</option> 
                                     
        </select> 
	</td>		
	</tr>	
-->
		
	<tr>     
    <td colspan="2" bgcolor="#C0D3FD"  align="center">
    <input type="button"  onclick="tijiaocheck()" value="新 增 " > &nbsp;&nbsp;   
    <input type="button" value="返 回"onclick="javascript:history.go(-1);"/></td>
	</tr>
	<tr height="5"><td>&nbsp;</td></tr>
	<tr><td  colspan="2">注：1.机构主要负责人、机构其他负责人、机构其他负责人（分管安保）、机构
	<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;主要负责人（分管安保）所在处室请选择本机构综合管理部门。
	<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.每个机构确保配一名分管安保的领导。
	<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.当机构只有一名负责人时，请将其配备为机构主要负责人（分管安保）。
	</td></tr>
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