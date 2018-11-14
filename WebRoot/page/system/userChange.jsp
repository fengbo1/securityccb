<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String quanxian= (String) request.getSession().getAttribute("quanxianrole");
    String zhufenbiaozhi= (String) request.getSession().getAttribute("zhufenbiaozhi");
    

%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员修改页面</title>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>

<style type="text/css">
.aa {
	color: #FFF;
	font-weight: bold;
	text-align: center;
}
</style>
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
var quanxian = document.getElementById('quanxian').value;
if (name==""){
  alert("新增人员姓名不得为空");
  return false ;
}
if (newnumber==""){
  alert("新增人员新一代员工编号不得为空");
  return false ;
}
if(isNaN(newnumber))  
{  
        alert("新一代员工编号必须为纯数字！");  
         document.getElementById("newnumber").value="";
        return false;  
}   
 
 
if (chushiid==""){
  alert("请选择新增人员所在处室");
  return false ;
}
if (zhiwu==""){
  alert("请选择新增人员职务");
  return false ;
}
if (quanxian==""){
  alert("请选择新增人员系统权限");
  return false ;
}	
}
</script>

</head>
<body>
系统管理->人员信息修改
<form name="fm1" action="<%=path%>/UserChangeok.action?" method="post" >
<table height="80" align="center" cellpadding="0"		cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF"><b>人员信息修改</b>						
							</td>						

<td><input type="hidden" value="${id}"  name="id"></td></tr>

	<tr  class="aa">
	<td height="40" bgcolor="#188BE8" width="200px">员工姓名</td>
	<td bgcolor="#F0F0F0">
		<input name="name" type="text" id="name" value="${name}">
	</td>		
	</tr>
	<tr  class="aa">
	<td height="40" bgcolor="#188BE8" width="200px">新一代员工编号：</td>
	<td bgcolor="#F0F0F0">
		<input name="newnumber" type="text" id="newnumber" onchange="newnumbercheck()" value="${newnumber}">
	</td>		
	</tr>
	<tr  class="aa">
	<td height="40" bgcolor="#188BE8" width="200px">系统密码：</td>
	<td bgcolor="#F0F0F0">
		<input name="password" type="text" id="password"  value="${password}">
	</td>		
	</tr>
	
	
	
	
	<tr  class="aa">
	<td height="40" bgcolor="#188BE8" width="200px">处室名称：</td>
	<td bgcolor="#F0F0F0" width="90px"  >	
		<select id="chushiid" name="chushiid"   style="width:170px">  
								<option value="">请选择所在处室 </option>  
                                <c:forEach var="chu" items="${chulist}" varStatus="status">  
                                <option  value="${chu.chushiid}"  <c:if  test="${chu.chushiid  eq chushiid }" > selected="selected"</c:if>>${chu.chushi}</option>  
                                </c:forEach>  
        </select> 
    </td>		
	</tr>	
	<tr  class="aa">
	<td height="40" bgcolor="#188BE8" width="200px">系统角色：</td>
	<td bgcolor="#F0F0F0" width="170px"  align="center">
		<select id="zhiwu" name="zhiwu"  style="width:170px">       
		 <option value="">请选择系统角色</option>                           
            <option value="13"  <c:if test="${quanxian=='13'}">selected = "selected"</c:if>>机构主要负责人</option>
             <option value="14"  <c:if test="${quanxian=='14'}">selected = "selected"</c:if>>机构主要负责人（兼分管安保）</option> 
            <option value="23"  <c:if test="${quanxian=='23'}">selected = "selected"</c:if>>机构其他负责人</option>   
            
            <option value="24"  <c:if test="${quanxian=='24'}">selected = "selected"</c:if>>机构其他负责人（分管安保）</option> 
           
            <option value="33"  <c:if test="${quanxian=='33'}">selected = "selected"</c:if>>综合部门负责人</option> 
            <option value="51"  <c:if test="${quanxian=='51'}">selected = "selected"</c:if>>机构安全岗</option> 
            <option value="52"  <c:if test="${quanxian=='52'}">selected = "selected"</c:if>>处室安全岗</option> 
            <option value="53"  <c:if test="${quanxian=='53'}">selected = "selected"</c:if>>普通员工</option> 
                        
                         
        </select> 
	</td>		
	</tr>	

	<tr>     
    <td height="40" align="center"  colspan="3" bgcolor="#C0D3FD"><input type="submit" value="修 改 "   >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value="返 回"onclick="javascript:history.go(-1);"/></td>
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