<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String newnumber = (String)request.getSession().getAttribute("newnumber");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	background-color: #ffffff;
}
-->
</style>
<script type="text/javascript">
$(document).ready(function(){ 

$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
   var length1=document.getElementById("listwb1").value;
   var length2=document.getElementById("listwb2").value;
   var length3=document.getElementById("listwb3").value;
   var length4=document.getElementById("listwb4").value;
   var isneedalert = document.getElementById("isneedalert").value;
   
 
 });


 </script>

 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
年度考核->考核情况查询
  <form action="commitall.action" method="post" >
					<table height="80" align="center" cellpadding="0" cellspacing="2" >
					<tr>
							 <td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="12" align="center" bordercolor="#FFFFFF"><b>考核事项查询</b>
							</td>
						</tr>
					<tr>
			        <td style="padding-left:1px">
						<table height="80" align="center" cellpadding="0" cellspacing="2" >
						<tr height="50px" class="表格表头背景1" id="hang">
							
							<td  width="50px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
						
							<td  width="170px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>机构名称</p>
								</div></td>	
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>总分数</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>上一级审批人</p>
								</div></td>
							<td  width="120px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>状态</p>
								</div></td>	
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>详情</p>
								</div></td>												
						</tr>
						</table>
						</td>
					</tr>
		<tr>
			        <td style="padding-left:1px">
			         <div id="scroll1" align="center" style="overflow-y: scroll; overflow-x: hidden;height:200px">
					<table  align="center" style="border: 0px; " cellpadding="0" cellspacing="2" >
					<c:forEach items="${flist}" var="kh" varStatus="status">
					<tr class="btbj" id="hang" style="height:25px">
								
								<td  width="50px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1}</div></td>
								
								<td width="170px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:jigouidtoname(kh.jigouid)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${kh.score}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:idtoname(kh.preunder)}</div></td>		
								<td width="120px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:statustoname(kh.status,kh)}</div></td>
								<c:if test="${!ifanbaobz}">
								<td width="130px" height="25" align="center" valign="middle" nowrap><div align="center">
							<a href="<%=path%>/singlekhps.action?pnumber=${kh.pnumber}&newnumber=<%=newnumber%>&chaxunbz=1">详情</a></div></td>
							</c:if>	
							<c:if test="${ifanbaobz}">
								<td width="130px" height="25" align="center" valign="middle" nowrap><div align="center">
							 <a href="<%=path%>/scorefind.action?pnumber=${kh.pnumber}&xiugaibz=0&lasttime=0&thisunder=''&chaxunbz=1">详情</a><b></b></div></td>
							</c:if>	
										
						</tr>
									
									</c:forEach>
												
		</table>
		<br><br><br><br><br></div></td></tr></table>
		</form>
  </body>
</html>
