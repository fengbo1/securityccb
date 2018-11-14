<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 
String strPtname = request.getParameter("url");

strPtname = new String(strPtname.getBytes("ISO-8859-1"), "UTF-8");

String url = new String( request.getParameter("url").getBytes("iso8859-1"), "gb2312"); 
    

%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>   

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">




  </head>  
  <body >
<input type="button" value="返  回" onclick="javascript:history.go(-1);"/>  

<p style="padding-left: 60"><img src="<%=path%>/upload/upload_area/<%=url%>" width="1071"  ><br></p>
<%if(url.equals("")){ %>图示暂未上传…………<%} %>
  </body>
 <%} %> 
</html>
