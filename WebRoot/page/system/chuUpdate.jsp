<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


String j = request.getParameter("j");

String jigou=request.getParameter("jigou");
String chushi=request.getParameter("chushi");
String chushiid=request.getParameter("chushiid");

%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改处室名称</title>
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
   系统管理->处室管理->修改处室
<form name="fm1" action="<%=path%>/chuUpdate.action?" method="post" >
					<table height="80" align="center" cellpadding="0"		cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF"><b>修改处室</b>						
							</td>
							
						</tr>
					  
   
	<tr class="aa">
	<td width="120" height="40" bgcolor="#188BE8">中心名称：</td>
	  <td width="220" bgcolor="#188BE8"><%=jigou %></td>	
	
	</tr>
	
	<tr  class="aa">
	<td height="30" bgcolor="#188BE8">处室名称：</td>
	<td bgcolor="#F0F0F0"><input size="15" name="chushi" type="text" id="chushi" value=<%=chushi%>></td>	
	
	</tr>
	<tr>  
    <td bgcolor="#C0D3FD">	<input name="chushiid" type="hidden" id="chushiid" value=<%=chushiid%> /> 
    </td>
    <td bgcolor="#C0D3FD" ><input type="submit" value="修 改" > <input type="button" value="返 回"onclick="javascript:history.go(-1);"/></td>
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