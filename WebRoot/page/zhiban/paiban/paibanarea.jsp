<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
		
		<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js"></script>
		
<link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/css/buttons.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
$(document).ready(function(){ 
$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$('#year').attr('value',${year});
});
</script>
<script language="javascript">
function del_sure(){
 var gnl=confirm("确定删除吗?");
 if (gnl==true){
  return true;
 }
 else{
  return false;
 }
}
</script>
<script language="javascript">
function pagego(){
var number = document.getElementById('page').value;
var href = document.getElementById('pagego').href;
var page = document.getElementById('pagego');
page.href=href+number;
}
</script>
</head>
  
  <body>
     值班管理->安防排班     
     <table   height="161" align="center" cellpadding="0"cellspacing="2" style="margin-top: 30px; border: 0px;">
			<tr><td	style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF"><b>安防排班</b>
			</td></tr>
			
			<tr>
			<td colspan="9" align="center"><div>
			<form name="fm2" method="post" action="PaiBanArea.action">
			年份：<select id="year" name="year">
								<c:forEach items="${listyear}" var="y" varStatus="status">
									<option value="${y}">${y}</option> 
								</c:forEach>
								</select>
			姓名：<input size="5" type="text" name="name1" value="${name1}">
			<input type="submit"value="搜 索" />
			<input type="hidden" name="areaid" value="${areaid}" >
			
			</form>
			</div>
			</td>
								
			</tr>
			<c:if test="${fb:canpaiban(newnumber)}">
			<tr> 
				<td>
				<!-- <a	 class="button small blue"  href="<%=path%>/paibantoadd.action?areaid=${areaid}&areaname=${areaname }&area=${area }&chushi=${chushi}">新增</a> -->
				<a	 class="button small blue"  href="<%=path%>/page/zhiban/paiban/paiban_add.jsp?areaid=${areaid}&areaname=${areaname }&area=${area }&chushi=${chushi}">新增</a>
				  	</td>
	        	<td ><a	 class="button small blue"  href="<%=path%>/paibanaction.action?currentPage=1&position=${position}>">返回</a></td>
				</tr></c:if>
				<tr>
				<td colspan="6"></td>
				 
			</tr>
			<tr class="表格表头背景1" id="hang" >
			<td width="60" height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
				<p>序号</p></div>
			</td>
			<td width="100" height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
				<p>值班开始时间</p></div>
			</td>
			<td width="100" height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
				<p>值班结束时间</p></div>
			</td>
			<td  width="100"  height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
				<p>值班人员1</p></div>
			</td>
			<td  width="100"  height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
				<p>联系方式</p></div>
			</td>
			<td  width="100"  height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
				<p>值班人员2</p></div>
			</td>
			<td  width="100"  height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
				<p>联系方式</p></div>
			</td>
			
			<td  width="100"  height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
				<p>备注</p></div>
			</td>
			<c:if test="${fb:canpaiban(newnumber)}">
			<td  width="40"  height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
				<p>删除</p></div>
			</td>
			</c:if>
			</tr>
		
			<s:iterator value="list" status="L">
			<tr height="20" class="btbj" id="hang" style="height:20px">
				<td height="30" width="60" align="left">
				<div align="center">
					<s:property value="%{#L.getIndex()+1}"/></div>
				</td>
				<td  width="100"  height="30" align="center">
					<div align="center">
					
					<fmt:formatDate value="${begindate}" pattern="yyyy-MM-dd"/> </div>
				</td>
				<td  width="100"  height="30" align="center">
					<div align="center">
					<fmt:formatDate value="${enddate}" pattern="yyyy-MM-dd"/>
				</div>
				</td>
				<td  width="100"  height="30" align="center">
					<div align="center">
					<s:property value="remark2"/></div>
				</td>
				<td  width="100"  height="30" align="center">
					<div align="center">
					<s:property value="tel1"/></div>
				</td>
				<td  width="100"  height="30" align="center">
					<div align="center">
					<s:property value="remark3"/></div>
				</td>
				<td  width="100"  height="30" align="center">
					<div align="center">
					<s:property value="tel2"/></div>
				</td>
				<td  width="100"  height="30" align="center">
					<div align="center">
					<s:property value="remark"/></div>
				</td>
				<c:if test="${fb:canpaiban(newnumber)}">
				<td  width="40" height="30" align="left"><div align="center">
					<a class="ui" href="<%=path%>/paibandel.action?year=2&areaid=${areaid}&id=<s:property value="id"/>">删除</a>	
					</div>
				</td></c:if>
         	</tr>
         	
			</s:iterator>
			<tr class="表格表头背景">
			
						</tr>
	
		</table>
	
                         
 
  </body>

</html>
