<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

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
background-color:#ffffff;
position:relative;
top:expression((this.offsetParent.scrollTop>this.parentElement.parentElement.offsetTop?this.offsetParent.scrollTop-this.parentElement.parentElement.offsetTop-1:0)-1);
}
-->
</style>
<script language="javascript">
function del_sure(){
 var gnl=confirm("删除人员将会删除其应急联系方式，请确认是否删除?");
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

	 $("tr.btbjodd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
	 $("tr.btbjeven").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
var x=document.getElementsByName("para");
$('#chushiid').attr('value',x[0].value);
$('#zhiwu').attr('value',x[1].value);
});

 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body >
     系统管理->人员管理
	<form action="<%=path%>/userinfo.action" method="post" name="fm1">
  	<table id="pol_table_list" cellspacing="0" align="center" style="width: 1150px;height:100px" >
			<tr class="locktop">
			<th>
					<table height="80" align="center" cellpadding="0"	cellspacing="2" border="0px">
						<tr>
							<td width="1000px"
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="7" align="center" bordercolor="#FFFFFF"><b>人员管理</b>						
							</td>
							
						</tr>
						<tr height="10px">
						<td colspan="7"  align="center">	 
							
							处室：<select id="chushiid" name="chushiid"  >  
	                             <option value="">请选择处室 </option>  
                                  <c:forEach var="chu" items="${chulist}" varStatus="status">  
                                  <option  value="${chu.chushiid}"  >${chu.chushi}</option>  
                                      </c:forEach>  
                                       </select>&nbsp;		
						  姓名：<input size="9" type="text" name="name" id="name">&nbsp;
						  新一代员工编号：<input size="9" type="text" name="newnumber" id="newnumber" >&nbsp;
						系统角色：<select name="zhiwu" id="zhiwu">
                                     <option value="">请选择系统角色</option>                           
         							 <option value="13">机构主要负责人</option>  
         							 <option value="14">机构主要负责人（分管安保）</option>
           							 <option value="23">机构其他负责人</option>
           							 <option value="24">机构其他负责人（分管安保）</option> 
           							<option value="33">综合部门负责人</option> 
            						<option value="51">机构安全岗</option> 
            						<option value="52">处室安全岗</option> 
            						<option value="53">普通员工</option>  									 
								</select>&nbsp;										
						
						 <input type="submit"value="搜 索" />
						 <input type="hidden" name="para" value="${chushiid}"/>
						 <input type="hidden" name="para" value="${zhiwu}"/>
						 <input type="hidden" name="position" value="${position}"/>
						 </td>
						</tr>
						<tr height="10px">
						<td colspan="7" >
						<a class="button small blue" href="<%=path%>/page/system/UserAddFind.action?jigouid=${jigouid}">新增</a>					
						<a class="button small blue" href="<%=path%>/page/system/useraddup.jsp?jigouid=${jigouid}&type=add">批量上传</a>	
			         	<a class="button small blue" href="<%=path%>/downuserinfo.action?jigouid=${jigouid}&position=${position}">下载</a>
					   	<a class="button small blue" href="<%=path%>/downfile/down_example/userinfo.xls">模板下载</a>
					   
					     </td>
					     </tr>	
						<tr height="50px" class="表格表头背景1" id="hang">
					
								<td  width="53px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="267px" align="center" valign="middle" nowrap	bordercolor=none><div align="center">
									<p>处室名称</p>
								</div></td>
							
							<td  width="106px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>姓名</p>
								</div></td>	
							<td  width="160px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>新一代员工编号</p>
								</div></td>	
							<td  width="267px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>系统角色</p>
								</div></td>
							<td  width="67px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>删除</p>
								</div></td>
							<td  width="68px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>修改</p>
								</div></td>
						</tr>
		</table>
		</th>
			</tr>
			<tr>
			<td style="padding-left:1px">
		<table height="80" align="center" cellpadding="0"	cellspacing="2" border="0px">
							<c:forEach items="${mylist}" var="wb" varStatus="status">
							
							<tr class="btbj" id="hang" style="height:20px">								
								<td width="53px" height="25" align="center" valign="middle" nowrap>
									<div align="center">${status.index+1}
									</div>
								</td>
								<td width="267px" height="25" align="center" valign="middle" nowrap>
									<div align="center">
									${wb.zw_chu}
									</div>
								</td>	
								<td width="106px" height="25" align="center" valign="middle" nowrap>
									<div align="center">${wb.name}
									</div>
								</td>
								<td width="160px" height="25" align="center" valign="middle" nowrap>
									<div align="center">
									${wb.newnumber}</div>
								</td>		
								
										
								<td width="267px" height="25" align="center" valign="middle" nowrap>
									<div align="center">
									${wb.zw_role}						
									</div>
						  		</td>
					
								<td width="67px" height="25" align="center" valign="middle" nowrap>
								<div><a class="ui" href="<%=path%>/userDel.action?newnumber=${wb.newnumber}"  onclick="javascript:return del_sure();">删除</a>	
											</div>
											</td>
								<td width="68px" valign="middle" align="center">
								<div> <a class="ui" href="<%=path%>/userChange.action?newnumber=${wb.newnumber}">修改</a></div>
								</td>	
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
