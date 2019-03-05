<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String position = (String)request.getSession().getAttribute("position");
   
%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
<link href="<%=path%>/css/buttons.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>总行直属机构机构</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	background-color: #ffffff;
}
-->
</style>
<script type="text/javascript">
$(document).ready(function(){ 

$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
});

</script>

<link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
</head>
<body>
非现场检查->总行直属机构
	<form name="data" method="post">
		<table   height="161" align="center" cellpadding="0" cellspacing="2" style="margin-top: 30px; border: 0px;">
			<tr><td	style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="4" align="center" bordercolor="#FFFFFF"><b>总行直属机构</b>
			</td></tr>

		<tr><td colspan="4" align="center">
		<a class="button small blue" href="<%=path%>/jigouaddbefore.action">新增机构</a>
		
		</td></tr>
			<tr class="表格表头背景1" id="hang" >
			<td width="60" height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
				<p>序号</p></div>
			</td>
			<td width="300" height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
				<p>机构</p></div>
			</td>
			<td width="400" height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
				<p>可非现场检查的机构</p></div>
			</td>
			<td width="100" height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
				<p>修改</p></div>
			</td>
			</tr>
			<c:forEach items="${list}" var="jg" varStatus="status">
			<tr height="20" class="btbj" id="hang" style="height:20px">
				<td height="30" width="60" align="left">
				<div align="center">
					${status.index+1}
					</div>
				</td>
				<td  width="300"  height="30" align="center">
					<div align="center">
					${jg.jigou}
					</div>
				</td>
				<td  width="300"  height="30" align="center">
					<div align="center">
					${jg.xiaji}
					</div>
				</td>
				<td  width="100"  height="30" align="center">
					<div align="center">
					 <a href="<%=path%>/jigoutomod.action?id=${jg.id}">修改</a> 
					</div>
				</td>
         	</tr>
         	</c:forEach>
		</table>
	</form>
</body>
<%} %>
</html>