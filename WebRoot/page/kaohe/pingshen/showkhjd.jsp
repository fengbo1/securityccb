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
    
    <title>e</title>
    
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
function tijiao() 
{
	var message="是否确认提交?";
	   if (window.confirm(message)) 
		{
			with(document.forms[0]) 
			{
				action='sendkhps.action?newnumber=${newnumber}';
				method="post";
				submit();
			}
		}
  }

function xiazai() 
{
	
	with(document.forms[0]) 
	{
		action='xiazaikhps.action?newnumber=${newnumber}';
		method="post";
		submit();
	}
			
}

 </script>

 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
年度考核->考核进度
  <form action="sendall.action" method="post" >
					<table height="80" align="center" cellpadding="0" cellspacing="2" >
					  	<tr>
							 <td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="12" align="center" bordercolor="#FFFFFF"><b>未完成考核评分机构</b>
							</td>
							
						</tr>
						
					<tr>
			        <td style="padding-left:1px">
						<table height="80" align="center" cellpadding="0" cellspacing="2" >
						<tr height="50px" class="表格表头背景1" id="hang">
							
							<td  width="120px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="270px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>机构名称</p>
								</div></td>
							<td  width="220px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>状态</p>
								</div></td>	
																
						</tr>
						</table>
						</td>
					</tr>
					
					<tr>
			        <td style="padding-left:1px">
			         <div id="scroll1" align="center" style="overflow-y: scroll; overflow-x: hidden;height:200px">
					<table  align="center" style="border: 0px; " cellpadding="0" cellspacing="2" >
					<c:forEach items="${waitlist}" var="wb" varStatus="status">
					<tr class="btbj" id="hang" style="height:25px">
								
								<td  width="110px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1}</div></td>
															
								<td width="260px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:jigouidtoname(wb.jigouid)}</div></td>
									
								<td width="220px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:findstatusbyjgid(wb.jigouid)}</div></td>
										
								</tr>
								</c:forEach>
					<c:forEach items="${liuzhuanlist}" var="lb" varStatus="status">
					<tr class="btbj" id="hang" style="height:25px">
								
								<td  width="110px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+waitlist.size()+1}</div></td>
															
								<td width="260px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:jigouidtoname(lb.jigouid)}</div></td>
									
								<td width="220px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:statustoname(lb.status,lb)}</div></td>
								</tr>
								</c:forEach>
		</table>
		<br><br><br><br><br></div></td></tr>
						<tr>
							 <td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="12" align="center" bordercolor="#FFFFFF"><b>已完成考核评分机构</b>
							</td>
						</tr>
						
					<tr>
			        <td style="padding-left:1px">
						<table height="80" align="center" cellpadding="0" cellspacing="2" >
						<tr height="50px" class="表格表头背景1" id="hang">
							
							<td  width="80px" align="center" valign="middle" nowrap
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
						
							<td  width="120px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>状态</p>
								</div></td>	
							<td  width="120px"  align="center" valign="middle" nowrap
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
					<c:forEach items="${unflist}" var="sb" varStatus="status">
					<tr class="btbj" id="hang" style="height:25px">
								
								<td  width="80px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1}</div></td>
																
								<td width="160px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:jigouidtoname(sb.jigouid)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${sb.score}</div></td>
										
								<td width="120px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:statustoname(sb.status,sb)}</div></td>
								<td width="120px" height="25" align="center" valign="middle" nowrap><div align="center">
							<a href="<%=path%>/singlekhps.action?pnumber=${sb.pnumber}&newnumber=<%=newnumber%>&chaxunbz=1">详情</a></div>
							</td>
						</tr>
								</c:forEach>
								
								<c:forEach items="${flist}" var="nb" varStatus="status">
					           <tr class="btbj" id="hang" style="height:25px">
								
								<td  width="80px" height="25" align="center" valign="middle" nowrap><div
										align="center">${unflist.size()+status.index+1}</div></td>
																
								<td width="160px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:jigouidtoname(nb.jigouid)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${nb.score}</div></td>
										
								<td width="120px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:statustoname(nb.status,nb)}</div></td>
								<td width="120px" height="25" align="center" valign="middle" nowrap><div align="center">
							<a href="<%=path%>/singlekhps.action?pnumber=${nb.pnumber}&newnumber=<%=newnumber%>&chaxunbz=1">详情</a></div>
							</td>
						</tr>
								</c:forEach>
								<c:forEach items="${waitsplist}" var="wp" varStatus="status">
					           <tr class="btbj" id="hang" style="height:25px">
								
								<td  width="80px" height="25" align="center" valign="middle" nowrap><div
										align="center">${unflist.size()+flist.size()+status.index+1}</div></td>
																
								<td width="160px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:jigouidtoname(wp.jigouid)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wp.score}</div></td>
										
								<td width="120px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:statustoname(wp.status,wp)}</div></td>
								<td width="120px" height="25" align="center" valign="middle" nowrap><div align="center">
							<a href="<%=path%>/singlekhps.action?pnumber=${wp.pnumber}&newnumber=<%=newnumber%>&chaxunbz=1">详情</a></div>
							</td>
						</tr>
								</c:forEach>
												
		</table>
		<br><br><br><br><br></div></td></tr>
		<tr><td colspan="2" align="center">
		<input style="width:140px" type="button" onclick='tijiao()' value='提交部领导审批' >
		</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
		<tr><td>&nbsp;&nbsp;</td></tr>
		<!-- 
        <c:if test="${tuisongbz==0}">
		<tr><td colspan="2" align="center">
		<input style="width:140px;color:gray" type="button" onclick='' value='提交部领导审批'>
		</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
		<tr><td>&nbsp;&nbsp;</td></tr></c:if>
		 -->
		<c:if test="${flist.size()>0}">
		<tr><td colspan="2" align="center">
		<input type="hidden" name="year" value="${flist.get(0).getRemark3()}"/>
		<input style="width:140px" type="button" onclick='xiazai()' value='下载审批结果'>
		</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></c:if>
		<c:if test="${flist.size()==0}">
		<tr><td colspan="2" align="center">
		<input style="width:140px;color:gray" type="button" onclick='' value='下载审批结果'>
		</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></c:if>
		
							</table>
		</form>
  </body>
</html>
