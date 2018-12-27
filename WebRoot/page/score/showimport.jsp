<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" errorPage="../public/error.jsp"%>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
<title>子公司考核评分数据管理</title>
</head>
<body>
	<c:if test="${jigou=='000'}">
	<div class="layout">
		<form name="filename" method="post" action="scoreimport.action"
			enctype="multipart/form-data">
			<div class="title">子公司考核评分数据导入</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="上传">
						 <b style="color:red">在导入评分前，请务必备份数据库</b>
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
	</div>
	</c:if>
	<form name="filename" method="post" action="scoreexport.action"
			enctype="multipart/form-data">
			<div class="title">考核评分数据导出</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_input">
						年度
						 <input type="text" name="year" value="">
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit" value="导出">
						 <input type="hidden" name="position" value="${position}">
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
</body>
</html>