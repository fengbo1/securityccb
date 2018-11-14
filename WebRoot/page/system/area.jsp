<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

    String position= (String) request.getSession().getAttribute("position");
    String role= (String) request.getSession().getAttribute("role");
    String jigouid=position.substring(0, 3);
    System.out.println("position值在area.jsp页面："+position); 
    System.out.println("jigouid值在area.jsp页面："+jigouid); 
   

%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>   

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
    <title>系统管理    责任区管理页面</title>
    
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
 var gnl=confirm("请确认是否删除?");
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
  系统管理->责任区管理
					<table height="80" align="center" cellpadding="0" cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF"><b>责任区管理</b>						
							</td>
							
						</tr>
					  
						
						<tr>
						<td >  <a class="button small blue" href="<%=path%>/page/system/areafindchushi.action?jigouid=<%=jigouid %>">新增</a></td>
					     <td colspan="2" >  <!-- <a class="button small blue" href="<%=path%>/page/record/record_down.jsp">下载</a>
					       <a class="button small blue" href="<%=path%>/page/record/record_up.jsp">上传</a>--></td>
					    
					    </tr><tr height="5px"><td></td></tr>
						<tr height="50px" class="表格表头背景1" id="hang">
					
							<td  width="40px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
						
							<td  width="200px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>处室名称</p>
								</div></td>	
								<td  width="200px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>责任区名称</p>
								</div></td>	
								<td  width="300px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>责任区域具体范围<br/>(点击查看图示)</p>
								</div></td>							
							<td  width="50px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>删除</p>
								</div></td>	
							<td  width="50px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>修改</p>
								</div></td>	
																
						</tr>
							<s:iterator value="arealist" status="L">
							<tr class="btbj" id="hang" style="height:20px">								
								<td width="40px" height="25" align="center" valign="middle" nowrap>
									<div align="center"><s:property value="%{#L.getIndex()+1}"/>
									</div>
								</td>
						
								<td width="200px" height="25" align="center" valign="middle" nowrap>
									<div align="center"><s:property value="chushi"/>
									</div>
								</td>	
								<td width="200px" height="25" align="center" valign="middle" nowrap>
									<div align="center"><s:property value="areaname"/>
									</div>
								</td>							
								<td width="300px" height="25" align="center" valign="middle" nowrap>
									<div align="center">
									<a class="ui" href="<%=path%>/page/system/areashow.jsp?url=<s:property value="url"/>">
									<s:property value="area"/>
									</a>
									</div>
								</td>	

								<td width="50px" height="25" align="center" valign="middle" nowrap>
								<div><a class="ui" href="<%=path%>/areaDel.action?areaid=<s:property value="areaid"/>&position=<s:property value="position"/>"  onclick="javascript:return del_sure();">删除</a>	
											</div>
											</td>
								<td width="50px" valign="middle" align="center">
								<div> <a class="ui" href="<%=path%>/areaUpdate.action?position=<%=position%>&areaid=<s:property value="areaid"/>">修改</a></div>
								</td>	
							</tr>
							</s:iterator>
							<tr class="表格表头背景">
							<td colspan="10">
								<div align="center">
	
									
									
								</div></td>
						</tr>
		</table>
		
  </body>
 <%} %> 
</html>
