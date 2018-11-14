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
 alert('在年度自评前请选择本机构年度考核项目！');

 	function showbox(id,xz)
 	{
	var kuang = "<textarea style='width:160px;height:70px' name='reason'></textarea>";
	if(xz==1)
	{
		document.getElementById("div"+id).innerHTML=kuang;
	}
	else
	{
		document.getElementById("div"+id).innerHTML="";
	}
	 }

 	function tijiao()
	{
 		var message="请各机构按照考核年度安全管理实际情况选择考核项目，请如实填写不参与考核项目理由，如发现隐瞒、虚报选择等情况，总行将按照《中国建设银行直属机构安全管理工作考核办法》中“违规处理”条款内容严肃处理。";
 		var reason=document.getElementsByName("reason");
 		for(var i=0;i<reason.length;i++)
 		{
			var content = reason[i].value;
			if(content=='')
			{
				alert("请输入不参与考核理由");
				reason[i].focus();
				return;
			}
 	 	}
 		if (window.confirm(message)) {
			with(document.forms[0]) {
				action='chushihuascore.action';
				method="post";
				submit();
			}
		}
	}	
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body >
  考核管理->考评项目
  <form action="chushihuascore.action" method="post" name="fm1" id="form1">
  	<table id="pol_table_list" cellspacing="0" align="center" style="width: 1150px;height:500px">
			<tr class="locktop">
			<th>
					<table height="80" align="center" cellpadding="0"	cellspacing="2" border="0px">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="8" align="center" bordercolor="#FFFFFF"><b>生成${year}年度安全管理考核项目</b>						
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
							<td  width="200px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>评分方法标准</p>
								</div></td>	
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>备注</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>选择要考核<br/>的项目</p>
								</div></td>	
							<td  width="170px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>填写不参与考核理由</p>
								</div></td>	
						</tr>
		</table>
		</th>
			</tr>
			<tr>
			<td style="padding-left:1px">
		<table height="80" align="center" cellpadding="0"	cellspacing="2" border="0px">
						<c:forEach items="${listsb}" var="sb" varStatus="status">
							<c:if test="${status.index<35}">
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
								<td width="200px" height="25" align="left" valign="middle" ><div align="left">${sb.std}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${sb.rmk}</div></td>
								<td width="100px" height="25" align="center" valign="middle" ><div align="center">
								<input type="radio" name="rd${status.index+1}" value="y" checked onclick="showbox(${status.index+1},0)"/>&nbsp;&nbsp;是
								<br/>
								<input type="radio" name="rd${status.index+1}" value="n" onclick="showbox(${status.index+1},1)"/>&nbsp;&nbsp;否
								</div></td>
								<td width="170px" height="25" align="center" valign="middle" ><div align="center" id="div${status.index+1}">
								</div></td>
							</tr>
							</c:if>
        				</c:forEach>
        				<tr class="btbj" id="hang" style="height:20px">									
								<td colspan="8">
								<div align="center">
								<button type="button" onclick="tijiao()">提  交</button>
								<input type="hidden" name="jigouid" value="${jigouid}"/>
								<input type="button" value="返  回" onclick="javascript:history.go(-1);"/>
								</div>
								</td>
							</tr>				
		</table>
		</td>
			</tr>	
		</table>	
</form>	
  </body>
</html>
<%} %>
