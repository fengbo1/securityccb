<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String newnumber= (String) request.getSession().getAttribute("newnumber"); 
%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
<link href="<%=path%>/css/buttons.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>值班登记主要页面</title>
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
});



</script>
<script language="javascript">

function check_area(x){


var jieguo=x;

          	if(jieguo==3){
		
		    alert("您已经完成值班。");		
		     return  false;
	      }
	        if(jieguo==2){
		
		           alert("此责任区已完成值班。");		
		     return  false;
	       }
	        if(jieguo==99){
	    		
		           alert("此区域未排班。");		
		     return  false;
	       }		






}

</script>
<link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
</head>
<body>
值班管理->值班登记
	<form name="data" method="post">
		<table   height="161" align="center" cellpadding="0" cellspacing="2" style="margin-top: 30px; border: 0px;">
			<tr><td	style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF"><b>值班登记</b>
			</td></tr>
		
			<tr class="表格表头背景1" id="hang" >
			<td width="60" height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
				<p>序号</p></div>
			</td>
			<td width="150" height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
				<p>责任处室</p></div>
			</td>
			<td width="200" height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
				<p>责任单位</p></div>
			</td>
			<td  width="450"  height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center" style="padding:0 margin:0">
				<p>责任区域<br/>(点击查看责任区示意图)</p>
				</div>
			</td>
			</tr>
			<input type="hidden" name="jieguo" id="jieguo" />

			<c:forEach var="chu" items="${pbalist}" varStatus="status">  
			<tr height="20" class="btbj" id="hang" style="height:20px">
				<td height="30" width="60" align="left">
				<div align="center">
					${status.index+1 }</div>
				</td>
				<td  height="30" align="center">
					<div align="center">
					${chu.chushiname}</div>
				</td>
				<td  height="30" align="center">
				 
				  <input type="hidden" id="jsareaid" value="${chu.areaid}">
					<div align="center">
					<c:if test="${fb:zhibanarea(newnumber,chu.areaid)=='0'}">
					<a name="caname"  href="<%=path%>/ZhiBanArea.action?areaid=${chu.areaid }&position=${ position }"/>
					${ chu.areaname}
					</a>										
					</c:if>
					
					<c:if test="${fb:zhibanarea(newnumber,chu.areaid)=='3'}">
					<a name="caname" onclick="return check_area(3)" href="<%=path%>/ZhiBanArea.action?areaid=${chu.areaid }&position=${ position }"/>
					${ chu.areaname}
					</a>										
					</c:if>
					
					<c:if test="${fb:zhibanarea(newnumber,chu.areaid)=='4'}">
						<a name="caname"  href="<%=path%>/ZhiBanArea.action?areaid=${chu.areaid }&position=${ position }"/>
							${ chu.areaname}
						</a>										
					</c:if>
					
					<c:if test="${fb:zhibanarea(newnumber,chu.areaid)=='2'}">
						<a name="caname" onclick="return check_area(2)" href="<%=path%>/ZhiBanArea.action?areaid=${chu.areaid }&position=${ position }"/>
							${ chu.areaname}
						</a>										
					</c:if>					
					<c:if test="${fb:zhibanarea(newnumber,chu.areaid)=='99'}">
						<a name="caname" onclick="return check_area(99)" href="#"/>
							${ chu.areaname}
						</a>										
					</c:if>
					
					</div>
				</td>
				<td  height="30" align="left">
					<a class="ui" href="<%=path%>/page/system/areashow.jsp?url=${chu.url}">
					${chu.area}
					</a>
				</td>
         	</tr>
         	</c:forEach>
		</table>
	</form>
</body>
<%} %>
</html>