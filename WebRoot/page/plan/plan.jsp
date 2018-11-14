<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


    String position= (String) request.getSession().getAttribute("position");
    String role= (String) request.getSession().getAttribute("role");
    String newnumber= (String) request.getSession().getAttribute("newnumber");
    String jigouid=position.substring(0,2);

%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>   

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    
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
-->
</style>
<script language="javascript">
function del_sure(){
 var gnl=confirm("请确定是否删除?");
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
     <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
 
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
   工作计划
   <form action="<%=path%>/plan1.action" method="post">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF"><b>工作计划</b>
							</td>
							
						</tr>
				         <tr>
						<td colspan="7"  align="center">
						<c:if test="${fb:canoperate(newnumber)}">	
						 <a class="button small blue" href="<%=path%>/page/plan/plan_add.jsp">新增</a>
						 <a class="button small blue" href="<%=path%>/downplan.action?position=<%=position %>">下载</a>				
						<a	 class="button small blue" href="<%=path%>/page/plan/planaddup.jsp?position=<%=position %>&jigouid=<%=jigouid %>">上传</a>
						<a class="button small blue" href="<%=path%>/downfile/down_example/plan.xls">模板下载</a>	
						</c:if>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	年&nbsp;&nbsp;<input style="width:50px"  type="text" name="year" id="boss_date" value="${year }" class="Wdate" onClick="WdatePicker()"  onfocus="WdatePicker({dateFmt: 'yyyy'})">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	月 <input style="width:50px"  type="text" name="month" id="boss_date" value="${month }" class="Wdate" onClick="WdatePicker()"  onfocus="WdatePicker({dateFmt: 'MM'})">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	周  <select  name="week" >
                                     <option value ="">请选择</option>
                                     <option value ="1">第一周</option>
                                     <option value ="2">第二周</option>
                                     <option value ="3">第三周</option>
                                     <option value ="4">第四周</option>
                            
                                     <option value ="6">常规事项</option>
                                     <option value ="7">待定事项</option>
                                     									 
								</select>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;工作内容&nbsp;&nbsp;&nbsp;<input size="9" type="text" name="content" id="content" value="${content }">
						  <input type="hidden" name="position" value="${position}"/>
						 <input type="submit"value="搜 索" />
						 </td>
						
						
						
						
						</tr>
				
						<tr height="50px" class="表格表头背景1" id="hang">
					
							<td   colspan="3" width="160px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>计划时间</p>
								</div></td>
							<td  width="500px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>工作内容</p>
								</div></td>

					<!--  		<td  width="200px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>工作结果</p>
								</div></td>	-->
	
							<td  width="90px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>相关责任人</p>
								</div></td>	
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>计划完成时间</p>
								</div></td>
					<!-- 		<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>实际完成时间</p>
								</div></td> -->
							<td  width="200px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>备注</p>
								</div></td>
					       <c:if test="${fb:canoperate(newnumber)}">
							
							<td  width="40px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>删除</p>
								</div></td>	
							<td  width="40px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>修改</p>
								</div></td>	
							
								</c:if>				
						</tr>
							<s:iterator value="plist" status="L">
							<tr class="btbj" id="hang" style="height:20px">								
								<td width="50px" height="25" align="center" valign="middle" nowrap>
									<div align="center"><s:property value="year"/>
									</div>
								</td>
								<td width="50px" height="25" align="center" valign="middle" nowrap>
									<div align="center">
									<s:if test='month=="01"'>一月</s:if>
									<s:if test='month=="02"'>二月</s:if>
									<s:if test='month=="03"'>三月</s:if>
									<s:if test='month=="04"'>四月</s:if>
									<s:if test='month=="05"'>五月</s:if>
									<s:if test='month=="06"'>六月</s:if>
									<s:if test='month=="07"'>七月</s:if>
									<s:if test='month=="08"'>八月</s:if>
									<s:if test='month=="09"'>九月</s:if>
									<s:if test='month=="10"'>十月</s:if>
									<s:if test='month=="11"'>十一月</s:if>
									<s:if test='month=="12"'>十二月</s:if>								
									</div>
								</td>
								<td width="60px" height="25" align="center" valign="middle" nowrap>
									<div align="center">
									<s:if test='week=="1"'>第一周</s:if>
									<s:if test='week=="2"'>第二周</s:if>
									<s:if test='week=="3"'>第三周</s:if>
									<s:if test='week=="4"'>第四周</s:if>
						<!--			<s:if test='week=="5"'>第五周</s:if>  -->
									<s:if test='week=="6"'>常规事项</s:if>
									<s:if test='week=="7"'>待定事项</s:if>
									
									</div>
								</td>
								<td width="500px" height="25" align="center" valign="middle" nowrap>
									<div align="left"><s:property value="content"/>
									</div>
								</td>

						<!-- 		<td width="200px" height="25" align="center" valign="middle" nowrap>
									<div align="left"><s:property value="result"/>
									</div>
								</td>	 -->						
								<td width="70px" height="25" align="center" valign="middle" nowrap>
									<div align="center"><s:property value="people"/>
									</div>
								</td>	
								<td width="90px" height="25" align="center" valign="middle" nowrap>
									<div align="center">
									<s:date name="plandate" format="yyyy-MM-dd"/>
									</div>
								</td>	
						<!--   		<td width="100px" height="25" align="center" valign="middle" nowrap>
									<div align="center"><s:property value="overdate" />
									</div>
								</td>	 -->
								<td width="200px" height="25" align="center" valign="middle" nowrap>
									<div align="center"><s:property value="remark"/>
									</div>
								</td>
								<c:if test="${fb:canoperate(newnumber)}">
					            <td width="40px" align="center" valign="middle"><div>
									<a  class="ui" href="<%=path%>/plandel.action?id=<s:property value="id"/>" onclick="javascript:return del_sure();">删除</a>
								</div></td>	
							
								<td width="40px" align="center" valign="middle"><div>
									<a class="ui" href="<%=path%>/plan_change.action?id=<s:property value="id"/>"/>修改</a>
								</div></td>	</c:if>
							</tr>
							</s:iterator>
		</table>
		</form>
  </body>
  <%} %>
</html>
