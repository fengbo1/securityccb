<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

    String position= (String) request.getSession().getAttribute("position");
    String message= (String) request.getSession().getAttribute("message");
    
    String role= (String) request.getSession().getAttribute("role");
    String jigouid=position.substring(0, 3);
    System.out.println("position值在chu.jsp页面："+position); 
    System.out.println("jigouid值在chu.jsp页面："+jigouid); 
   

%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>   

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
    <title>系统管理    处室管理页面</title>
    
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

<script type="text/javascript">
 $(document).ready(function(){ 

$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
});
function download(f)
{
	var Path = f;
	 window.open("<%=path%>/downfile/down_userinfo/"+f,"","height=450,width=600,top=350,left=500"); 
}
function del(id)
{
	var message="请确定是否删除?";
	if (window.confirm(message)) {
			window.location='<%=path%>/fankuidel.action?id='+id;
	}
}
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body >
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border="0px">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="6" align="center" bordercolor="#FFFFFF"><b>留言反馈</b>						
							</td>
						</tr>
						<tr>
						<td >  <a class="button small blue" href="<%=path%>/page/system/fankuiadd.jsp">新增</a></td>
					    </tr>
						<tr height="50px" class="表格表头背景1" id="hang">
					
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>

							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>日期</p>
								</div></td>								
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>标题</p>
								</div></td>	
							<td  width="400px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>内容</p>
								</div></td>	
							<td  width="50px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>附件</p>
								</div></td>	
							<td  width="50px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>删除</p>
								</div></td>									
						</tr>
							<c:forEach items="${list}" var="f" varStatus="status">	
							<tr class="btbj" id="hang" style="height:20px">								
								<td width="70px" height="25" align="center" valign="middle" nowrap>
									<div align="center">${status.index+1}
									</div>
								</td>
								<td height="25" align="center" valign="middle" nowrap>
									<div align="center">${f.date}
									</div>
								</td>
								<td height="25" align="center" valign="middle" nowrap>
									<div align="center">${f.title}
									</div>
								</td>							
								<td height="25" align="center" valign="middle" nowrap>
									<div align="center">${f.content}
									</div>
								</td>		
								<td height="25" align="center" valign="middle" nowrap>
									<div align="center">
									<c:if test="${f.fujian!='--'&&f.fujian!=null}">
										<a href="#" onclick="download('${f.fujian}')">附件</a>
									</c:if>
									</div>
								</td>
								<td height="25" align="center" valign="middle" nowrap>
									<div align="center">
											<a href="#" onclick="del('${f.id}')">删除</a>
									</div>
								</td>		
							</tr>
							</c:forEach>
		</table>
		
  </body>
 <%} %> 
</html>
