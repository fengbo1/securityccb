<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String jigouid=new String(request.getParameter("jigouid").getBytes("iso-8859-1"),"utf-8");

System.out.println("jigouid值在chuAdd.jsp页面："+jigouid); 
   

%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加处室</title>
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
   系统管理->新增处室
<form name="fm1" action="<%=path%>/chuAdd.action?" method="post" >

					<table height="80" align="center" cellpadding="0"		cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF"><b>新增处室</b>						
							</td>
							
						</tr>
					  
   
	<tr class="aa">
	<td width="300" height="40" bgcolor="#188BE8">新增处室名称：</td>
	<td width="300" bgcolor="#188BE8"><input name="chushi" type="text" id="chushi" ><input name="jigouid" type="hidden" id="jigouid" value="<%=jigouid %>" ></td>	
	
	</tr>	
	<tr class="aa">
	<td width="300" height="40" bgcolor="#188BE8">是否为负责机构安全管理部门：</td>
	<td width="300" bgcolor="#188BE8">是<input name="anbaobiaozhi" type="checkbox" id="anbaobiaozhi" ></td>	
	
	</tr>	
	<tr>  

    <td bgcolor="#C0D3FD"  align="center" colspan="2" ><input type="button" value="新 增 " onclick="checkValue()"/ > <input type="button" value="返 回"onclick="javascript:history.go(-1);"/></td>
	</tr>
	
</table>
</form>

<script type="text/javascript">
function checkValue()
{
   var chushi=document.getElementById('chushi');
   
   if(chushi.value==""){
   
    alert("处室名称不能为空");
   return false;
   }else{
    document.forms[0].submit();	
    return true;
   }
   
}
</script>
</body>
<%} %>
</html>