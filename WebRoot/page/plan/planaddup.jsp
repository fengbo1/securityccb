<%@taglib prefix="s" uri="/struts-tags"%>  
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String jigouid= (String) request.getParameter("jigouid"); 
   String type= (String) request.getParameter("type"); 
   
%>
<html>  
    <head>  
    	<meta http-equiv="cache-control" content="no-cache">
       
        <title>  <%=path%></title>  
    </head>      
    <body>  
    工作计划->工作计划上传
     <form action="<%=path%>/plan_up.action" method="post" enctype="multipart/form-data" >  
		<input type="hidden" id="jigouid" name="jigouid" value="<%=jigouid %>"/>
        <table height="160px" align="center" cellpadding="0" cellspacing="2" border="0px">
        <tr style="height:80px">
					<td style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"	colspan="2" align="center" bordercolor="#FFFFFF">
						<b>工作计划上传</b>						
					</td>
				</tr>
		<tr  >
	<td bgcolor="#C0D3FD" align="center">请选择工作计划:</td>	
	<td style="width:400px" bgcolor="#F0F0F0"  align="center">
		<input type="file" name="file"/>
	</td>	
	</tr>		
    <tr>
    <td bgcolor="#C0D3FD" align="center"><input type="button" value="返 回"onclick="javascript:history.go(-1);"/></td>
	 <td bgcolor="#C0D3FD" align="center"> <input type="submit" value="新 增 " >
	 </td>
	</tr>
    </table>
    </form>  
    </body>  
</html>