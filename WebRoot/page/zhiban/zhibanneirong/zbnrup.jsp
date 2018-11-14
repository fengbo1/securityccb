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
    值班管理->值班内容上传
     <form action="<%=path%>/zbnr_up.action" method="post" enctype="multipart/form-data" > 
     <input type="hidden" id="jigouid" name="jigouid" value="<%=jigouid %>"/>
     <table align="center">
    <tr><td	style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF"><b>值班内容上传</b>
			</td></tr>
	<tr class="aa">
	<tr>
	<td height="30" bgcolor="#C0D3FD">请选择值班内容上传:</td>
		<td bgcolor="#C0D3FD"><input name="file" type="file" id="file" >
	</td>
	</tr>
	
	<tr>
    <td bgcolor="#C0D3FD" align="center"><input type="submit"  value="提 交" ></td>
    <td bgcolor="#C0D3FD" align="center"><input type="button"  value="返 回"onclick="javascript:history.go(-1);"/></td>
	</tr>
	
</table> 
		
</form>
   
  
    </body>  
</html>