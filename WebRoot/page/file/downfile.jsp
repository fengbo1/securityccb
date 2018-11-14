<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String url1 = request.getParameter("url1");

//url=new String(url.getBytes("iso-8859-1"),"utf-8");

String title = request.getParameter("title");
//title=new String(title.getBytes("iso-8859-1"),"utf-8");

String arr[]=url1.split("\\|");
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

<!-- <a   href="page/file/dodown.jsp?a  -->
	
  </head>
  
  <body >
  <table>
  <tr>
  <td>《<%=title %>》</td></tr>
 <tr>
  <td>下载内容： </td>
  </tr>
  
  <%for (int i=0;i<arr.length;i++){
 // String brr[]=arr[i].split("\\_");
  //String ccc=brr[1];
  
   %>
  <tr>
<td><a   href="<%=path%>/upload/upload_file/<%=arr[i]%>"><%=arr[i]%></a></td>
  </tr>
  <%} %>
  
  </table>
  
  
  
  
 	
  </body>
</html>