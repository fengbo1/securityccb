<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

    String position= (String) request.getSession().getAttribute("position");
    String role= (String) request.getSession().getAttribute("role");
    String jigouid=position.substring(0,3);
    String newnumber= (String) request.getSession().getAttribute("newnumber"); 
   

%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>   

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
    <title>值班内容页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>

<link href="<%=path%>/css/buttons.css" rel="stylesheet" type="text/css">
 <style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	background-color: #ffffff;
}
-->
</style>
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


<script type="text/javascript">
 $(document).ready(function(){ 

$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
});
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body >
  值班管理->值班内容
  <br/>
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="5" align="center" bordercolor="#FFFFFF"><b>值班内容</b>						
							</td>
							
						</tr>

						<c:if test="${fb:canoperate(newnumber)}">
						<tr >
						<td colspan="3">  <a class="button small blue" href="<%=path%>/zhibanneirongaddfind.action?jigouid=<%=jigouid %>">新增</a>
					   	  <a class="button small blue" href="<%=path%>/page/zhiban/zhibanneirong/zbnrup.jsp?jigouid=<%=jigouid %>">批量上传</a>
					      <a class="button small blue" href="<%=path%>/downfile/down_example/zbnr.xls">模板下载</a></td>
	 
					  
					  
					    </tr>
					    </c:if>
						<tr height="50px" class="表格表头背景1" id="hang">
					
							<td  width="150px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>处室名称</p>
								</div></td>
							<td  width="150px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>责任区名称</p>
								</div></td>
							<td  width="500px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>值班内容</p>
								</div></td>	
								<c:if test="${fb:canoperate(newnumber)}">							
							<td  width="50px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>删除</p>
								</div></td>	
							<td  width="50px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>修改</p>
								</div></td>	
								</c:if>								
						</tr>
							<c:forEach items="${zbnrlist}" var="z" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								<c:if test="${z.rowsp1!='0'}">							
								<td rowspan="${z.rowsp1}" width="150px" height="25" align="center" valign="middle" nowrap>
									<div align="center">${z.chushi }
									</div>
								</td>
								</c:if>
								<c:if test="${z.rowsp2!='0'}">		
								<td rowspan="${z.rowsp2}" width="150px" height="25" align="center" valign="middle" nowrap>
									<div align="center">${z.areaname }
									</div>
								</td>			
								</c:if>
								<td width="500px" height="25" align="center" valign="middle" nowrap>
									<div align="left">${z.zhibanneirong }
									</div>
								</td>								
								<c:if test="${fb:canoperate(newnumber)}">	
								<td width="50px" height="25" align="center" valign="middle" nowrap>
								<div><a class="ui" href="<%=path%>/zbnrDel.action?id=${z.id }&&position=${position}"  onclick="javascript:return del_sure();">删除</a>	
											</div>
											</td>
								<td width="50px" valign="middle" align="center">
								<div> <a class="ui" href="<%=path%>/zbnr_change.action?id=${z.id }&position=${position }&areaname=${z.areaname}">修改</a></div>
								</td>	
								</c:if>
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
							<td colspan="5">
								<div align="center">
	
									
									
								</div></td>
						</tr>
		</table>
		
  </body>
 <%} %> 
</html>
