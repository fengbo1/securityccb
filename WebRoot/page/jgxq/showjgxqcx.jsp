<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%request.setCharacterEncoding("utf-8");%> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>acceptance_data</title>
		<link href="<%=path%>/css/add.css" type="text/css"
			rel="stylesheet" />
				<style type="text/css">
			textarea{
					width:600px;
					height:150px;
					font-size:16px;
					font-family:"宋体";
			}
			.rd{
					color:red;
			}
		</style>
		<script type="text/javascript">
		function new_open(url,title)
		{
			title=encodeURI(title);
			window.open("<%=path%>/page/jgxq/download.jsp?url="+url+"&title="+title,"","height=300,width=500,top=400,left=600"); 
		}
		</script> 
	</head>
	<body>
	系统管理->机构详情
		<form name="jgxq" action="jgxqedit.action" method="post" enctype="multipart/form-data">
			<div class="layout" >
				<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
				align="center">
					<b>基本情况</b>
				</div>

				
				<div align="center">
						<textarea style="width:800px;height:300px" readonly="readonly">${jgxq.getJigoudesc()}</textarea>
					<div class="clear"></div>
					</div>
					<br/><br/>
				<div class="two_columns">
					<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
				align="center">
					<b>安全管理工作总结</b>
				</div>
					<div align="center">
				
					<c:forEach items="${zjlist}" var="zj" varStatus="status">
					<tr>
						<td>${status.index+1}.</td>
						
						<td><a href="#" onclick="new_open('${zj.rtitle}','${zj.rtitle}')"/>${zj.rtitle}</a></td>
					</tr>
					</c:forEach>
				
				</div>
				</div>
				
				<br/><br/>
				<div class="two_columns">
					<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
				align="center">
					<b>安全管理工作计划</b>
				</div>
				<div align="center">
				
					<c:forEach items="${jhlist}" var="jh" varStatus="status">
					<tr>
						<td>${status.index+1}.</td>
						
						<td><a href="#" onclick="new_open('${jh.ptitle}','${jh.ptitle}')"/>${jh.ptitle}</a></td>
					</tr>
					</c:forEach>
			
				</div>
				</div>
		<div align="center">	<br/>	<input type="button" onclick="javascript:history.go(-1);" value="返  回" /></div>
			</div>
		</form>
	</body>

</html>


