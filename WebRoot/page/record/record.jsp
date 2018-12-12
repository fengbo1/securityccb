<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%request.setCharacterEncoding("utf-8");%> 
<%
String newnumber= (String) request.getSession().getAttribute("newnumber");
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
-->
</style>
<script language="javascript">
function download(f)
{
	var Path = f;
	 window.open("<%=path%>/upload/upload_record/"+f,"","height=450,width=600,top=350,left=500"); 
}
function del(a,url)
{
	var message="请确定是否删除?";
	if (window.confirm(message)) {
		with(document.forms[0]) {
			window.location='<%=path%>/delrecordurl.action?idd='+a+'&url='+url;
		}
	}
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
  日常管理->工作日志
   <form action="record.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF"><b>工作日志</b>						
							</td>
							
						</tr>
					  	<tr><td colspan="10" align="center">
						
						  起始日期：<input size="9" type="text" name="beginDate" id="boss_date" class="Wdate" onClick="WdatePicker()" value="${beginDate}">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						  截止日期：<input size="9" type="text" name="endDate" id="boss_date" class="Wdate" onClick="WdatePicker()" value="${endDate}">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						考核项：<select name="type">
									<option value ="all">全部</option>
									<option value ="zzld">组织领导</option>
									<option value ="gljg">管理机构</option>
									<option value ="zrls">责任落实</option>
									<option value ="gzzd">规章制度</option>
									<option value ="yhpc">隐患排查</option>
									<option value ="yjya">应急预案</option>
									<option value ="barygl">保安人员管理</option>
									<option value ="jfgl">技防管理</option>
									<option value ="xfgl">消防管理</option>
									<option value ="jtaq">交通安全</option>
									<option value ="aqbm">安全保密</option>
									<option value ="aqjy">安全教育</option>
									<option value ="xxbs">信息报送</option>
									<option value ="wwgl">外委管理</option>
									<option value ="zdtfsj">突发事件处置</option>
									<option value ="ndaqgz">年度安全检查</option>								 
								</select>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
						 工作内容：<input size="5" type="text" name="content1" value="${content1}">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						 相关责任人：<input size="5" type="text" name="people" value="${people}">					
						<input type="hidden" name="position" value="${position}"/>
						 <input type="submit"value="搜 索" />					
						</td></tr>
						<c:if test="${quanxian!='3'&&quanxian!='4'}">
						<tr>
						<td colspan="3">  <a class="button small blue" href="<%=path%>/page/record/record_add.jsp?ltmd=${last_three_month_date}">新增</a>
						
						</td>
					    </td></tr></c:if>
					    <%} %>
						<tr height="50px" class="表格表头背景1" id="hang">
					
							<td  width="40px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="80px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>记录日期</p>
								</div></td>	
							<td  width="80px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>完成日期</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>对应考核项</p>
								</div></td>	
							<td  width="300px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>工作内容</p>
								</div></td>	
							<td  width="140px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>相关责任人</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>备注</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>附件</p>
								</div></td>	
							<c:if test="${fb:canoperate(newnumber)}">
							<td  width="50px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>删除</p>
								</div></td>	</c:if>
																		
						</tr>
							<c:forEach items="${rlist}" var="r" varStatus="status">						
							<tr class="btbj" id="hang" style="height:20px">								
								<td  height="25" align="center" valign="middle" nowrap>
									<div align="center">${status.index+1}
									</div>
								</td>
								<td  height="25" align="center" valign="middle" nowrap>
									<div align="center">${fb:datetostandard(r.remark2)}
									</div>
								</td>
								<td  height="25" align="center" valign="middle" nowrap>
									<div align="center"><fmt:formatDate value="${r.date}" pattern="yyyy-MM-dd"/>
									</div>
								</td>
								<td width="100px"   height="25" align="center" valign="middle">
									<div align="center">
									${fb:khxmitemtostring(r.type)}
									</div>
								</td>
								<td  width="300px" height="25" align="center" valign="middle">
									<div align="left">${r.content1}
									</div>
								</td>
								<td height="25" align="center" valign="middle">
									<div align="center">${r.people}
									</div>
								</td>
								<td height="25" align="center" valign="middle">
									<div align="center">${r.remark }
									</div>
								</td>
								
								<td  height="25" align="center" valign="middle" nowrap>
									<div align="center">
									<c:if test="${r.url1!='--'&&r.url1!=null}">
										<a href="#" onclick="download('${r.url1}')">附件一</a>
										<c:if test="${fb:canoperate(newnumber)}">
										<a href="#" onclick="del('${r.id}','url1')">删除</a><br/></c:if>
									</c:if>
									<c:if test="${r.url2!='--'&&r.url2!=null}">
										<a href="#" onclick="download('${r.url2}')">附件二</a>
										<c:if test="${fb:canoperate(newnumber)}">
										<a href="#" onclick="del('${r.id}','url2')">删除</a><br/></c:if>
									</c:if>
									<c:if test="${r.url3!='--'&&r.url3!=null}">
										<a href="#" onclick="download('${r.url3}')">附件三</a>
										<c:if test="${fb:canoperate(newnumber)}">
										<a href="#" onclick="del('${r.id}','url3')">删除</a><br/></c:if>
									</c:if>
									<c:if test="${r.url4!='--'&&r.url4!=null}">
										<a href="#" onclick="download('${r.url4}')">附件四</a>
										<c:if test="${fb:canoperate(newnumber)}">
										<a href="#" onclick="del('${r.id}','url4')">删除</a><br/></c:if>
									</c:if>
									<c:if test="${r.url5!='--'&&r.url5!=null}">
										<a href="#" onclick="download('${r.url5}')">附件五</a>
										<c:if test="${fb:canoperate(newnumber)}">
										<a href="#" onclick="del('${r.id}','url5')">删除</a><br/></c:if>
									</c:if>
									<c:if test="${r.url6!='--'&&r.url6!=null}">
										<a href="#" onclick="download('${r.url6}')">附件六</a>
										<c:if test="${fb:canoperate(newnumber)}">
										<a href="#" onclick="del('${r.id}','url6')">删除</a><br/></c:if>
									</c:if>
									<c:if test="${r.url7!='--'&&r.url7!=null}">
										<a href="#" onclick="download('${r.url7}')">附件七</a>
										<c:if test="${fb:canoperate(newnumber)}">
										<a href="#" onclick="del('${r.id}','url7')">删除</a><br/></c:if>
									</c:if>
									<c:if test="${r.url8!='--'&&r.url8!=null}">
										<a href="#" onclick="download('${r.url8}')">附件八</a>
										<c:if test="${fb:canoperate(newnumber)}">
										<a href="#" onclick="del('${r.id}','url8')">删除</a></c:if>
									</c:if>
									</div>
								</td>
									<c:if test="${fb:canoperate(newnumber)}">
								<td height="25" align="center" valign="middle" nowrap>
									<div align="center"><a href="#" onclick="del('${r.id}','record')">删除</a>
									</div>
								</td></c:if>
							</tr>
						</c:forEach>
		</table>
	</form> 	
  </body>

</html>
