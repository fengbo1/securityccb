<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String url = request.getParameter("url");
String title = request.getParameter("title");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'derivedetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<%
String u=new String(title.getBytes("ISO-8859-1"),"UTF-8");
//title=new String(title.getBytes("ISO-8859-1"),"UTF-8");
%>
	
  </head>
  <body >
  <table>
  <tr>
  <td>《<%=title %>》</td></tr>
 <tr>
  <td>下载内容： </td>
  </tr>
  

  <tr>
<td><a   href="<%=path%>/page/jgxq/dodown.jsp?a=upload/upload_jgxq/<%=title%>"><%=title%></a></td>
  </tr>

  
  </table>
  
  
  
  
 	
  </body>
</html>