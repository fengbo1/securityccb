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
		function del_sure(){
			 var gnl=confirm("请确定是否删除?");
			 if (gnl==true){
			  return true;
			 }
			 else{
			  return false;
			 }
			}
		function changetext()
		{
			document.getElementById("desc").readOnly=false;
			document.getElementById("desc").style.backgroundColor="white";
		}
		</script> 
		<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
	</head>
	<body>
	系统管理->机构详情
		<form name="jgxq" action="jgxqedit.action" method="post" enctype="multipart/form-data">
			<div class="layout" >
				<div style="color: #1778C2; padding-top: 10px; padding-bottom: 5px; border: 0px; font-size: 26px; font-family: '黑体';"
				align="center">
					<b>基本情况</b><p style="font-size:14px;font-family: '黑体'">提示：基本情况包括机构职责、发展情况，机构领导、人员等情况，机构三防三建情况等内容。</p>
				</div>
                <div align="center">
						<textarea style="width:800px;height:300px;background-color:#CCCCCC" name="desc" id="desc" readonly="readonly" >${jgxq.getJigoudesc().trim()}</textarea>
					
					</div>
					<br/>
				<div style="padding-left:440px" >
					<input type="hidden" name="jigouid" value="${jigouid}"/>
    				<input type="button" value="编 辑" onclick="changetext();"/>
    				<input type="button" value="提 交" onclick="submit();"/>
    				
					<div class="clear"></div><br/>
				</div>
				</div></form>
					
					
				<form name="ndzj" action="ndzjedit.action" method="post" enctype="multipart/form-data">
				<div class="layout" >
				<div class="two_columns">
					<div style="color: #1778C2; padding-top: 10px; padding-bottom: 10px; border: 0px; font-size: 26px; font-family: '黑体';"
				align="center">
					<b>安全管理工作总结</b><p style="font-size:14px;font-family: '黑体'">文件命名规范:《***机构***年安全管理工作总结》</p>
				</div>
				<div align="center">
				<table border="1px">
					<tr>
						<td width="50px">序号</td>
						<td width="150px">上传日期</td>
						<td width="350px">文件名称</td>
						<td width="50px">操作</td>
					</tr>
					<c:forEach items="${zjlist}" var="zj" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<td>${zj.date }</td>
						<td><a href="#" onclick="new_open('${zj.rtitle}','${zj.rtitle}')"/>${zj.rtitle}</a></td>
						<td><a href="<%=path%>/ndzjdel.action?rtitle=${zj.rtitle}" onclick="javascript:return del_sure();">删除</a></td>
					</tr>
					</c:forEach>
				</table>
				<br/>
				
					<div class="two_columns_input" align="center">
						<input type="file" name="rfile" size="42">&nbsp;&nbsp;&nbsp;
						<input type="hidden" name="jigouid" value="${jigouid}"/>
    				<input type="button" value="提 交" onclick="submit();"/>
					</div>
				</div>
				<div style="padding-left:440px" >
					<div class="clear"></div>
				</div></div>
		</form>
		
		<form name="gzjh" action="gzjhedit.action" method="post" enctype="multipart/form-data">
				<div class="layout" >
				<div class="two_columns">
					<div style="color: #1778C2; padding-top: 10px; padding-bottom: 10px; border: 0px; font-size: 26px; font-family: '黑体';"
				align="center">
					<b>安全管理工作计划</b><p style="font-size:14px;font-family: '黑体'">文件命名规范:《***机构***年安全管理工作计划》</p>
				</div>
				
				<div align="center">
				<table border="1px">
					<tr>
						<td width="50px">序号</td>
						<td width="150px">上传日期</td>
						<td width="350px">文件名称</td>
						<td width="50px">操作</td>
					</tr>
					<c:forEach items="${jhlist}" var="jh" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<td>${jh.date }</td>
						<td><a href="#" onclick="new_open('${jh.ptitle}','${jh.ptitle}')"/>${jh.ptitle}</a></td>
						<td><a href="<%=path%>/gzjhdel.action?ptitle=${jh.ptitle}" onclick="javascript:return del_sure();">删除</a></td>
					</tr>
					</c:forEach>
				</table>
				<br/>
				</div>
					<div class="two_columns_input" align="center">
						<input type="file" name="pfile" size="42">&nbsp;&nbsp;&nbsp;
						<input type="hidden" name="jigouid" value="${jigouid}"/>
    				<input type="button" value="提交" onclick="submit();"/>
					</div>
					<br/>
				</div>
				
				<div style="padding-left:440px" >
					<div class="clear"></div>
				</div></div>
		</form>
	</body>

</html>


