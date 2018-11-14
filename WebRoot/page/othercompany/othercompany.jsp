<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String position= (String) request.getSession().getAttribute("position");
    String newnumber= (String) request.getSession().getAttribute("newnumber");   
  
%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>  

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>


<link href="<%=path%>/css/buttons.css" rel="stylesheet" type="text/css"> <style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	background-color: #ffffff;
}
-->
</style>
<script language="javascript">
function pagego(){
var number = document.getElementById('page').value;
var href = document.getElementById('pagego').href;
var page = document.getElementById('pagego');
page.href=href+number;
}
</script>
<script language="javascript">
function del_sure(){
 var gnl=confirm("请确定是否删除?");
 if (gnl==true){
  return true;
 }
 else{
  return false;
 }
}
</script>
<script type="text/javascript">
 $(document).ready(function(){ 

$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
});
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  应急管理->外部单位应急联络
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" >
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF"><b>外部单位应急联络</b>
							</td>
							
						</tr>
<c:if test="${fb:canoperate(newnumber)}">
						<tr>
						<td >  <a class="button small blue" href="<%=path%>/page/othercompany/otherAdd.jsp?position=<%=position %>">新增</a></td>
					     
					    
					    </tr></c:if>
						<tr height="50px" class="表格表头背景1" id="hang">
					
							<td  width="40px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="200px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>外部单位名称</p>
								</div></td>
							<!-- 
							<td  width="120px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>部门</p>
								</div></td>	
							
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>职务</p>
								</div></td>	
						 -->		
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>姓名</p>
								</div></td>
							
							
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>电话</p>
								</div></td>	
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>手机</p>
								</div></td>	
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>备注</p>
								</div></td>							
						<c:if test="${fb:canoperate(newnumber)}">
							<td  width="40px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>删除</p>
								</div></td>
							<td  width="40px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>修改</p>
								</div></td>
								</c:if>							
						</tr>
							<c:forEach items="${olist}" var="ad" varStatus="status">
							
							<tr class="btbj" id="hang" style="height:20px">								
								<td width="40px" height="25" align="center" valign="middle" nowrap>
									<div align="center">${status.index + 1}
									</div>
								</td>
								<td width="200px" height="25" align="center" valign="middle" nowrap>
									<div align="center">${ad.company }
									</div>
								</td>
								<!-- 
								<td width="120px" height="25" align="center" valign="middle" nowrap>
									<div align="center">${ad.department}
									   
									</div>
								</td>
								
								<td width="100px" height="25" align="center" valign="middle" nowrap>
									<div align="left">${ad.job}
									</div>
								</td>
								 -->
								<td width="100px" height="25" align="center" valign="middle" nowrap>
									<div align="center">${ad.name}
									</div>
								</td>
							
								<td width="100px" height="25" align="center" valign="middle" nowrap>
									<div align="center">${ad.tel}
									</div>
								</td>
								<td width="100px" height="25" align="center" valign="middle" nowrap>
									<div align="center">${ad.phone}
									</div>
								</td>
								<td width="100px" height="25" align="center" valign="middle" nowrap>
									<div align="center">${ad.remark}
									</div>
								</td>
								<c:if test="${fb:canoperate(newnumber)}">
								<td width="40px" height="25" align="center" valign="middle" nowrap>
								<div align="center">
							
								<a class="ui" href="<%=path%>/otherdel.action?id=${ad.id}&position=<%=position %>" onclick="javascript:return del_sure();">删除</a>
									
								</div>
								</td>
								<td width="40px" height="25" align="center" valign="middle" nowrap>
								<div align="center">
							
								<a class="ui" href="<%=path%>/otherchange.action?id=${ad.id}&position=<%=position %>" >修改</a>
									
											</div>
											</td>
											</c:if>
								
							</tr>
				</c:forEach>				
						
		</table>
		
  </body>
<%} %>
</html>

  
    
   
  