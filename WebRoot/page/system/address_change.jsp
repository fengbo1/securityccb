<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String newnumber= (String) request.getSession().getAttribute("newnumber");
    String position= (String) request.getSession().getAttribute("position");
    

%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息修改</title>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>

<style type="text/css">
.aa {
	color: #FFF;
	font-weight: bold;
	text-align: center;
}
</style>


</head>
<body>
应急管理->员工应急联络修改
<form name="fm1" action="<%=path%>/AddressChangeok.action?" method="post" >
<table height="80" align="center" cellpadding="0"		cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF"><b>员工应急联络修改</b>						
							</td>	
							<td><input type="hidden" value="${id}"  name="id">
							<input type="hidden" value="${position}"  name="position">
							</td>					
</tr>
	<tr  class="aa">
	<td height="30" bgcolor="#188BE8" width="220px">员工姓名：</td>
	
		<td height="30" bgcolor="#188BE8" width="250px">${ui.name}</td>
			
	</tr>
	

	<tr  class="aa">
	<td height="80" bgcolor="#188BE8" >居住地址：</td>
	<td bgcolor="#F0F0F0">
		<textarea name="address" id="address"  style="height: 80px;width:250px;overflow:hidden">${ui.address}</textarea>
	</td>		
	</tr>
	<tr  class="aa">
	<td height="30" bgcolor="#188BE8" >本人联系电话：</td>
	<td bgcolor="#F0F0F0">
		<input name="tel" type="text" id="tel"  value="${ui.tel}">
	</td>		
	</tr>
	
	
	
	
	<tr  class="aa">
	<td height="30" bgcolor="#188BE8">紧急联系人姓名：</td>
	<td bgcolor="#F0F0F0"  >	
		<input name="namesos" type="text" id="namesos"  value="${ui.namesos}">
    </td>		
	</tr>	
	<tr  class="aa">
	<td height="30" bgcolor="#188BE8">紧急联系人联系方式：</td>
	<td bgcolor="#F0F0F0">
		<input name="telsos" type="text" id="telsos"  value="${ui.telsos}">

	</td>		
	</tr>	
	<tr  class="aa">
	<td height="30" bgcolor="#188BE8">紧急联系人关系：</td>
	<td bgcolor="#F0F0F0">
		<input name="relation" type="text" id="relation"  value="${ui.relation}">

	</td>		
	</tr>	

		
	<tr  >     
    <td colspan="2" bgcolor="#C0D3FD" align="center" ><input type="submit" value="修 改 "   >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value="返 回"onclick="javascript:history.go(-1);"/></td>
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