
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Date date = new Date();
SimpleDateFormat bartDateFormat = new SimpleDateFormat("YYYY");
String yyyear = bartDateFormat.format(date);
%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'authorityfailed.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Refresh" content="0; url='<%=path%>/fankuilist.action?position=${position}&newnumber=${newnumber}'">
	<link rel="stylesheet" type="text/css" href="styles.css">
  </head>
  <body>
    	<b style="color:red"></b>
  </body>
</html>

