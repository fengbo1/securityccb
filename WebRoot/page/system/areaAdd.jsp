<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";



//String jigou=new String(request.getParameter("jigou").getBytes("iso-8859-1"),"utf-8");


//System.out.print("areaAdd中jigou值=："+jigou);



%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>责任区新增页面</title>
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
  系统管理->责任区管理->责任区新增
<form name="fm1" action="<%=path%>/areaAdd.action?" method="post" enctype="multipart/form-data"  >

<table height="80" align="center" cellpadding="0" cellspacing="2" border: 0px;">
    <tr>
	<td	style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"	colspan="11" align="center" bordercolor="#FFFFFF">
	   <b>责任区新增</b>						
	</td>
	</tr>


	<tr  class="aa">
	<td height="30" bgcolor="#C0D3FD">处室名称：</td>
	<td bgcolor="#F0F0F0" >	
		<select id="chushiid" name="chushiid" >  
           <option value=" "> 请选择 </option>
	 <s:iterator value="chulist" status="L">   
     <option value="<s:property value="chushiid"/>"><s:property value="chushi"/></option>  
      </s:iterator>	                  
        </select> 
    </td>	     	
	</tr>
	
	<tr  class="aa">
	<td height="30" bgcolor="#C0D3FD">责任区名称：</td>
	<td bgcolor="#F0F0F0">
		<input name="areaname" type="text" id="areaname" >	
	</td>	
	</tr>	
    <tr  class="aa">
	<td height="30" bgcolor="#C0D3FD">责任区域具体内容：</td>
	<td bgcolor="#F0F0F0">
		<input name="area" type="text" id="area" >
	</td>		
	</tr>	
	
	
	<tr  class="aa">
	<td height="30" bgcolor="#C0D3FD">责任区展示：</td>
	<td bgcolor="#F0F0F0">
		<input name="file" type="file"  >
	</td>		
	</tr>
	
	
		
	<tr>     
    <td colspan="2" bgcolor="#C0D3FD" align="center"><input type="submit" value="提交" > &nbsp; &nbsp; &nbsp;<input type="button" value="返 回"onclick="javascript:history.go(-1);"/></td>
	</tr>
	
</table>
</form>

</body>
<%} %>
</html>