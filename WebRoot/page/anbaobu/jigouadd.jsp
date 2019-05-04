<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
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
		<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
		<style type="text/css">
textarea {
	width: 600px;
	height: 150px;
	font-size: 16px;
	font-family: "宋体";
}

.rd {
	color: red;
}
</style>

	</head>
	<body>
		<form name="filename" action="jigouadd.action" method="post"
			enctype="multipart/form-data">
			<div class="layout">
				<div
					style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
					align="center">
					<b>新增机构</b>
				</div>

				<div id="content">

					<div class="four_columns">
						<div class="two_columns_text">
							机构名称:&nbsp;
						</div>
						<div class="four_columns_input">
							<input type="text" name="jigouname" id="jigouname">
						</div>
						<div class="clear"></div>
					</div>
					<div class="two_columns">
						<div class="two_columns_text">
							主中心（母公司）&nbsp;
						</div>
						<div class="two_columns_input">
							<select id="shangji" name="shangji" style="width: 260px">
								<option value="wu">
									无
								</option>
								<c:forEach items="${list}" var="jg" varStatus="status">
									<option value="${jg.jigouid}">
										${jg.jigou}
									</option>
								</c:forEach>
							</select>
						</div>
						<div class="clear"></div>
					</div>
					<div style="padding-left: 440px">
						<input type="submit" value="提 交" />
						<input type="button" value="返 回"
							onclick="javascript:history.go(-1);" />
						<br>
						<div class="clear"></div>
					</div>
				</div>
			</div>
		</form>
	</body>

</html>


