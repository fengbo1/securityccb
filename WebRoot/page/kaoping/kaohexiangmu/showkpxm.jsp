<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String position= (String) request.getSession().getAttribute("position");


%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>   

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
    <title>My JSP 'list.jsp' starting page</title>
    
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

tr.locktop{
background-color:#FFFFFF;
position:relative;
top:expression((this.offsetParent.scrollTop>this.parentElement.parentElement.offsetTop?this.offsetParent.scrollTop-this.parentElement.parentElement.offsetTop-1:0)-1);
}
-->
</style>

<script type="text/javascript">
 $(document).ready(function(){ 

	 $("tr.btbjodd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
	 $("tr.btbjeven").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
});

 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body >
  年度考核->考评项目
  <form action="submitscore.action" method="post" name="fm1" id="form1">
  	<table id="pol_table_list" cellspacing="0" align="center" style="width: 1150px;height:500px">
			<tr class="locktop">
			<th>
					<table height="80" align="center" cellpadding="0"	cellspacing="2" border="0px">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="7" align="center" bordercolor="#FFFFFF"><b>直属机构安全管理年度自评</b>						
							</td>
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
					
								<td  width="50px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td colspan="2" width="120px" align="center" valign="middle" nowrap	bordercolor=none><div align="center">
									<p>考核项目</p>
								</div></td>
							
							<td  width="400px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>考核内容</p>
								</div></td>	
							<td  width="300px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>评分方法标准</p>
								</div></td>	
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>备注</p>
								</div></td>
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>评分渠道</p>
								</div></td>
						</tr>
		</table>
		</th>
			</tr>
			<tr>
			<td style="padding-left:1px">
		<table height="80" align="center" cellpadding="0"	cellspacing="2" border="0px">
						<c:forEach items="${listsb}" var="sb" varStatus="status">
        						<tr 
        						<c:if test="${sb.beijing==0}">class="btbjodd"</c:if>
        						<c:if test="${sb.beijing==1}">class="btbjeven"</c:if>
        						 id="hang" style="height:20px">
        						<c:if test="${sb.rowsp!='0'}">
        							<td rowspan="${sb.rowsp}" width="50px" height="25" align="center" valign="middle" ><div align="center">${sb.xuhao}</div></td>
        							<td rowspan="${sb.rowsp}" width="70px" height="25" align="center" valign="middle" ><div align="center">${sb.itemc}</div></td>
        						</c:if>									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">${status.index+1}</div></td>
								<td width="400px" height="25" align="left" valign="middle" ><div align="left">${sb.cont}</div></td>
								<td width="300px" height="25" align="left" valign="middle" ><div align="left">${sb.std}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${sb.rmk}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${sb.qudao}</div></td>
							</tr>
        				</c:forEach>				
		</table>
		</td>
			</tr>	
		</table>	
</form>	
  </body>
</html>
<%} %>
