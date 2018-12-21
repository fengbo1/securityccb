<%@taglib prefix="s" uri="/struts-tags"%>  
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String jigouid= (String) request.getParameter("jigouid"); 
   String type= (String) request.getParameter("type"); 
   System.out.print("useraddup.jsp 页面1"+jigouid+"2"+type);
  
%>
<html>  
    <head>  
    	<meta http-equiv="cache-control" content="no-cache">
       
        <title>中心员工信息 上传页面  <%=path%></title>  
    </head>      
    <body>  
    系统管理->人员管理->员工信息上传
     <form action="<%=path%>/userinfo_up.action" method="post" enctype="multipart/form-data" >  
		<input type="hidden" id="jigouid" name="jigouid" value="<%=jigouid %>"/>
		<input type="hidden" id="type" name="type" value="<%=type %>"/>
        <table>
        <tr>
    
    <td>请选择员工信息上传:<s:file name="file"></s:file></td>  
    </tr>  
    
    <tr>  
    <td align="left"><s:submit name="submit" value="提交"></s:submit><br></td>  
    </tr>  
    </table>
    </form>  
   <input type="button" value="返 回"onclick="javascript:history.go(-1);"/><br></br>
   
  
    </body>  
</html>