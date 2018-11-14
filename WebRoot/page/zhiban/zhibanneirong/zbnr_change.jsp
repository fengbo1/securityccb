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
<title>值班内容修改页面</title>
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
值班管理->值班内容修改
<form name="fm1" action="<%=path%>/zbnr_changeok.action?" method="post" >

		<table height="80" align="center" cellpadding="0" cellspacing="2" border: 0px;">
				<tr>
							
					<td style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"	colspan="11" align="center" bordercolor="#FFFFFF">
						<b>值班内容修改</b>						
					</td>
							
				</tr>

	<tr  class="aa" >	
	
	<td height="50"  bgcolor="#188BE8" align="center" >责任区名称：</td>	
	<td   bgcolor="#188BE8" align="center" width="300">	<div >${areaname } </div> 
	</td>	
	</tr>
	<tr  class="aa"  >
	
	<td height="50" bgcolor="#188BE8"  align="center">责任区安防内容：</td>
		<td bgcolor="#F0F0F0">
		
		<input type="hidden" name="id" value="${zbnrlist[0].id }"/>
		<input type="hidden" name="position" value="${position}"/>
		<input type="hidden" name="areaid" value="${zbnrlist[0].areaid }"/>
		
		<textarea  name="zhibanneirong"  id="zhibanneirong" style="overflow:hidden;width:300px; height=30px;"/>${zbnrlist[0].zhibanneirong }</textarea>
	</td>	
	</tr>
	
	

	<tr  >
    <td colspan="2" bgcolor="#C0D3FD" align="center"><input type="submit" value="修 改 " >
	&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value="返 回"onclick="javascript:history.go(-1);"/></td>
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