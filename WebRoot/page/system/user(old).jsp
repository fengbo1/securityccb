<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

    String position= (String) request.getSession().getAttribute("position");
    String role= (String) request.getSession().getAttribute("role");
    String jigouid=position.substring(0, 2);
    System.out.println("position值在user.jsp页面："+position); 
    System.out.println("jigouid值在user.jsp页面："+jigouid); 
    String message= (String) request.getParameter("message");
  
   

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
<script language="javascript">
function del_sure(){
 var gnl=confirm("删除员工将会同时删除该员工应急联系方式，你真的确定要删除吗?");
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
     系统管理->人员管理
					<table height="80" align="center" cellpadding="0" cellspacing="2" border: 0px;">
					
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF"><b>人员管理</b>						
							</td>
						</tr>
						<tr height="10px">
						<td colspan="7" align="center">	 
						<form action="<%=path%>/userfind.action?position=<%=position%>" method="post" name="fm1">
						
							处室：<select id="chushiid" name="chushiid"  >  
	                             <option value="">请选择处室 </option>  
                                  <c:forEach var="chu" items="${chulist}" varStatus="status">  
                                  <option  value="${chu.chushiid}"  >${chu.chushi}</option>  
                                      </c:forEach>  
                                       </select>&nbsp;
								
						  姓名：<input size="9" type="text" name="name" id="name" >&nbsp;
						  新一代员工编号：<input size="9" type="text" name="newnumber" id="newnumber"  >&nbsp;
						系统角色：<select name="zhiwu">
                                     <option value="">请选择系统角色</option>                           
         							 <option value="13">机构主要负责人</option>  
           							 <option value="23">机构分管领导</option> 
            						 <option value="23">机构主要负责人（兼分管领导）</option> 
           							 <option value="33">综合部门负责人</option> 
          							 <option value="51">机构安全岗</option> 
        							 <option value="52">处室安全岗</option> 
        							 <option value="53">普通员工</option>  									 
								</select>&nbsp;										
						 <input type="submit"value="搜 索" />					
						</form> 
						</td>
						</tr>
						
						<tr height="10px">
						<td colspan="5" >
						<a class="button small blue" href="<%=path%>/page/system/UserAddFind.action?jigouid=<%=jigouid %>">新增</a>					
						<a class="button small blue" href="<%=path%>/page/system/useraddup.jsp?jigouid=<%=jigouid %>&type=add">批量上传</a>	
			         	<a class="button small blue" href="<%=path%>/downuserinfo.action?jigouid=<%=jigouid %>&position=<%=position %>">下载</a>
					   	<a class="button small blue" href="<%=path%>/page/file/dodown.jsp?a=/<%=path%>/downfile/down_example/userinfo.xls">模板下载</a>
					   
					     </td>
					     </tr>
					    <tr height="5px"><td></td></tr>
						<tr height="50px" class="表格表头背景1" id="hang">
					
							<td  width="50px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="200px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>处室名称</p>
								</div></td>	
								<td  width="80px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>姓名</p>
								</div></td>	
								<td  width="120px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>新一代员工编号</p>
								</div></td>	
									
					
							<td  width="300px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>系统角色</p>
								</div></td>		
						<!--  	<td  width="300px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>权限</p>
								</div></td>	-->						
							<td  width="50px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>删除</p>
								</div></td>	
							<td  width="50px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>修改</p>
								</div></td>	
																
						</tr>
							<s:iterator value="mylist" status="L">
							<tr class="btbj" id="hang" style="height:20px">								
								<td width="50px" height="25" align="center" valign="middle" nowrap>
									<div align="center"><s:property value="%{#L.getIndex()+1}"/>
									</div>
								</td>
								<td width="200px" height="25" align="center" valign="middle" nowrap>
									<div align="center">
									 <s:if test='role!="1"&&role!="2"'><s:property value="chushi"/></s:if>
									</div>
								</td>	
								<td width="80px" height="25" align="center" valign="middle" nowrap>
									<div align="center"><s:property value="name"/>
									</div>
								</td>
								<td width="120px" height="25" align="center" valign="middle" nowrap>
									<div align="center">
									<s:property value="newnumber"/></div>
								</td>		
								
										
								<td width="300px" height="25" align="center" valign="middle" nowrap>
									<div align="center">
								<s:if test='role=="1"&&quanxian=="3"'>机构主要负责人</s:if>
								<s:if test='role=="2"&&quanxian=="3"&&zhufenbiaozhi=="1"'>机构分管领导</s:if>
								<s:if test='role=="2"&&quanxian=="3"&&zhufenbiaozhi=="2"'>机构主要负责人<br/>（兼分管领导）</s:if>
								<s:if test='role=="3"&&quanxian=="3"'>综合部门负责人</s:if>
								<s:if test='role=="5"&&quanxian=="1"'>机构安全岗</s:if>
								<s:if test='role=="5"&&quanxian=="2"'>处室安全岗</s:if>	
								<s:if test='role=="5"&&quanxian=="3"'>普通员工</s:if>								
									</div>
						  		</td>
					
								<td width="50px" height="25" align="center" valign="middle" nowrap>
								<div><a class="ui" href="<%=path%>/userDel.action?newnumber=<s:property value="newnumber"/>"  onclick="javascript:return del_sure();">删除</a>	
											</div>
											</td>
								<td width="50px" valign="middle" align="center">
								<div> <a class="ui" href="<%=path%>/userChange.action?newnumber=<s:property value="newnumber"/>">修改</a></div>
								</td>	
							</tr>
							</s:iterator>
							<tr class="表格表头背景">
							<td colspan="10">
								<div align="center">
								<input type="hidden" id="message" value="${message}">
	
									
									
								</div></td>
						</tr>
		</table>
		
  </body>
 <%} %> 
</html>
