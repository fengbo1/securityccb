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
		function checkdate()
		{
			var ltmd = '<%=request.getParameter("ltmd")%>';
			var date=document.getElementById("date").value;
			ltmd = ltmd.replace(/-/g,"/");
			date = date.replace(/-/g,"/");
			var ltmd = new Date(ltmd);
			var date = new Date(date);
			if(date<ltmd)
			{
				alert('完成日期只能上推三个月，补录时间不能超过三个月。');
				document.getElementById("date").focus();
			}
		}
		</script>
		<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
	</head>
	<body>
	工作日志->修改
		<form name="filename" action="modrecord.action" method="post" enctype="multipart/form-data">
			<div class="layout" >
				<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
				align="center">
					<b>修改工作日志内容</b>
				</div>

				<div id="content">
					
					<div class="four_columns">
						<div class="two_columns_text">
							完成日期:&nbsp;
						</div>
						<div class="four_columns_input">
						 	<input type="text" name="date" id="date" class="Wdate" onClick="WdatePicker()" onchange="checkdate()" value="${record.date}">
						</div>
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns">
						
					<div class="two_columns_text">
							工作内容:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea name="content1" >${record.content1}</textarea>
					</div>
						
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							相关责任人:&nbsp;
					</div>
					<div class="two_columns_input">
						<input name="people" type="text" value="${record.people}"/>
					</div>
					<div class="clear"></div>
				</div>
				<br/>
				</div>
				<br/>
				<div class="two_columns">
					<div class="two_columns_text">
							备注:&nbsp;
					</div>
					<div class="two_columns_input">
						<input type="text" name="remark" style="width:600px" value="${record.remark}"/>
					</div>
					<div class="clear"></div>
				</div>
				<div style="padding-left:440px" >
					<input type="hidden" name="position" value="${position}"/>
					<input type="hidden" name="bid" value="${bid}"/>
					<input type="hidden" name="eid" value="${eid}"/>
    				<input type="submit" value="提 交"/>
    				<input type="button" value="返 回"onclick="javascript:history.go(-1);"/><br>
					<div class="clear"></div>
				</div>
				</div>
			</div>
		</form>
	</body>

</html>


