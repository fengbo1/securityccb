<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + path + "/";		

%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
<link href="<%=path%>/css/buttons.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>值班查询</title>
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

	$("tr.btbj1:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
	$("tr.btbj1:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
	$("tr.btbj2:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
	$("tr.btbj2:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
	
	});
</script>
<script language="javascript">
function pagego(){
var number = document.getElementById('page').value;
var href = document.getElementById('pagego').href;
var page = document.getElementById('pagego');
page.href=href+number;
}
</script>

<link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
</head>
<body>
值班管理->值班查询
 <form action="<%=path%>/zhibanfind.action" method="post" onsubmit="return validateForm()">
					<table width="100%" height="161" align="center" cellpadding="0"
						cellspacing="2" style="margin-top: 30px; border: 0px;">

						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="9" align="center" bordercolor="#FFFFFF"><b>值班记录查询</b>
							</td>
						</tr>
						<tr><td ><a	class="button small blue" href="<%=path%>/zhibanfindarea.action?position=${position}">返回</a></td>
						
						<td colspan="8" align="center">
						开始日期
								<input style="width: 100px" type="text" name="btime" id="btime" class="Wdate" value="${btime}" onClick="WdatePicker()" >
							结束日期
								<input style="width: 100px" type="text" name="etime" id="etime" class="Wdate" value="${etime}" onClick="WdatePicker()" >
							
							<input type="submit" value="查 询"/>
							<input type="hidden" name="areaid" value="${areaid }"/>
						</td>
						</tr>
						<tr class="表格表头背景1" id="hang">
							<td width="50" height="50px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td width="100" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>日期</p>
								</div></td>
							<td width="100" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>值班情况</p>
								</div></td>
							
							<td width="100" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>是否代班</p>
								</div></td>	
							<td width="100" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>实际值班人员</p>
								</div></td>
							<td width="100" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>提交时间</p>
								</div></td>
							<td width="100" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>备注</p>
								</div></td>			
							<td width="120" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>排班计划</p>
								</div></td>	
							<td width="215" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>检查意见</p>
								</div></td>			
																		
						</tr>
							<s:iterator value="zlist" status="L">
							<tr class="btbj1" id="hang" style="height:20px">
								
								<td rowspan="2" height="35" align="center" valign="middle" nowrap><div
										align="center"><s:property value="#L.index+1"/></div></td>
								
								<td rowspan="2" align="center" valign="middle" nowrap><div
										align="center"><s:property value="date"/></div></td>
								
								<td height="35" align="center" valign="middle" nowrap><div
										align="center"><s:property value="zhiban1"/></div></td>								
								
								<td align="center" valign="middle" nowrap><div
										align="center"><s:property value="ifcover1"/></div></td>
								
								<td align="center" valign="middle" nowrap><div
										align="center"><s:property value="name1"/> <s:if test='ifcover1=="是"'><br>(<s:property value="covername1"/>)</s:if></div></td>
							
								<td align="center" valign="middle" nowrap><div
										align="center"><s:property value="time1"/></div></td>
							
								<td align="center" valign="middle" nowrap><div
										align="center"><s:property value="remark1"/></div></td>			
							
								<td rowspan="2" width="120" align="center" valign="middle" nowrap><div
										align="center"><s:property value="namejihua1"/></div><br><div
										align="center"><s:property value="namejihua2"/></div></td>
							
								
								<td rowspan="2" width="220" align="center" valign="middle" nowrap><div
										align="center"><s:property value="jcyj"/></div></td>												
							</tr>
							<tr class="btbj2" id="hang" style="height:20px">
								<td height="35" align="center" valign="middle" nowrap><div
										align="center"><s:property value="zhiban2"/></div></td>
								<td align="center" valign="middle" nowrap><div
										align="center"><s:property value="ifcover2"/></div></td>
								<td align="center" valign="middle" nowrap><div
										align="center"><s:property value="name2"/><s:if test='ifcover2=="是"'><br>(<s:property value="covername2"/>)</s:if></div></td>
								<td align="center" valign="middle" nowrap><div
										align="center"><s:property value="time2"/></div></td>
								<td align="center" valign="middle" nowrap><div
										align="center"><s:property value="remark2"/></div></td>				
							</tr>
							</s:iterator>
						</table>
	</form>					
</body>
<%} %>
</html>