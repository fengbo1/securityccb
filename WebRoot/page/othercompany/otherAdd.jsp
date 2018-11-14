<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String position=new String(request.getParameter("position").getBytes("iso-8859-1"),"utf-8");
   

%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
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
应急管理->外部单位应急联络->新增
<form name="fm1" action="<%=path%>/otherAdd.action?" method="post" >

					<table height="80" align="center" cellpadding="0"		cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF"><b>外部应急联系单位新增</b>						
							</td>
							
						</tr>
					  
 
	<tr class="aa">
	<td width="300" height="40" bgcolor="#188BE8">新增外部单位名称：</td>
	<td width="300" bgcolor="#188BE8"><input name="company" type="text" id="company"">
	     <input name="position" type="hidden" id="position" value="<%=position %>" >
	     </td>	
	</tr>	
	
	<tr class="aa">
	<td width="300" height="40" bgcolor="#188BE8">新增外部单位部门：</td>
	<td width="300" bgcolor="#188BE8"><input name="department" type="text" id="department" ></td>	
	</tr>	

	<tr class="aa">
	<td width="300" height="40" bgcolor="#188BE8">相关人员职务：</td>
	<td width="300" bgcolor="#188BE8"><input name="job" type="text" id="job" ></td>	
	</tr>
	
	<tr class="aa">
	<td width="300" height="40" bgcolor="#188BE8">相关人员姓名：</td>
	<td width="300" bgcolor="#188BE8"><input name="name" type="text" id="name" ></td>	
	</tr>

	<tr class="aa">
	<td width="300" height="40" bgcolor="#188BE8">相关人员固定电话：</td>
	<td width="300" bgcolor="#188BE8"><input name="tel" type="text" id="tel"  ></td>	
	</tr>
	
	<tr class="aa">
	<td width="300" height="40" bgcolor="#188BE8">相关人员手机：</td>
	<td width="300" bgcolor="#188BE8"><input name="phone" type="text" id="phone"  ></td>	
	</tr>
	
	<tr class="aa">
	<td width="300" height="40" bgcolor="#188BE8">备注：</td>
	<td width="300" bgcolor="#188BE8"><input name="remark" type="text" id="remark"  ></td>	
	</tr>
	

	<tr>  
    <td bgcolor="#C0D3FD">	
    </td>
    <td bgcolor="#C0D3FD"><input type="submit" value="新 增 " / > <input type="button" value="返 回"onclick="javascript:history.go(-1);"/></td>
	</tr>
	
</table>
</form>

<script type="text/javascript">
function checkValue()
{
   //var chushi=document.getElementById('chushi');
   
  // if(chushi.value==""){
   
  //  alert("处室名称不能为空");
  // return false;
 //  }else{
    document.forms[0].submit();	
   // return true;
   }
   
}
</script>
</body>
<%} %>
</html>