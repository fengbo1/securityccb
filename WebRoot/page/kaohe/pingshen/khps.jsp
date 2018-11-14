<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
    <title>My JSP 'authorityfailed.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
	<script type="text/javascript">
	

	
	 function tijiao() {
		 var radio=document.getElementsByName("radio");
		  var xuanze = document.getElementById("xuanze").value;
		  var message = "确认提交？";
		  if(radio[0].checked!=true&&radio[1].checked!=true)
			{
				alert("请选择审批意见");
			}
		  else if(xuanze=="wu"&&radio[0].checked==true)
			{
				alert("请选择下一级审批人");
			}
			else
			{
				if (window.confirm(message)) {
					with(document.forms[0]) {
						action='khps.action';
						method="post";
						submit();
					}
				}
			}
	  }
	 function send() {
		 
					with(document.forms[0]) {
						action='khps.action';
						method="post";
						submit();
	  }}
	 function trim(str){ //删除左右两端的空格
		    return str.replace(/(^\s*)|(\s*$)/g, "");
		}  
	 function sel(o)
	  {
		  if(o==11)
		  {
			  document.getElementById("xuanze").style.display="inline-block";
				
			}else{
				alert("请确认您选择的意见是【退回】");
				document.getElementById("xuanze").style.display="none"; 
			} 
		} 
</script>
  <style type="text/css">
  .as {
	text-align: center;
}
b{
	color:red;
}
  </style>
  </head>
  
  <body>
    <form action="khps.action" method="post">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong><font id="bu" style="display:none;"></font>${jigouc}${year}年度考核表</strong><strong> </strong></p>
        <table width="860" height="398" border="1" align="center" cellpadding="1" cellspacing="0">
    		
    		<tr>
    			
    			<td width="150" class="as">
    				提交日期：${khps.date}
    			</td>
    			<td width="250" class="as">
    				${fb:jigouidtoname(khps.jigouid)}
    			</td>
    			<td width="150" class="as">
    				提交人：	${khps.name}
    			</td>
    		   		
    			<td width="150" class="as" >
    				分数：${khps.score}
    			</td>
    		
    		<c:if test="${lasttime==0}">
    			<td class="as">	
                <a href="<%=path%>/scorefind.action?pnumber=${khps.pnumber}&xiugaibz=${xiugaibz}&lasttime=${lasttime}&thisunder=${thisunder}&chaxunbz=${chaxunbz}">详情</a><b></b>
    			</td>
    			</c:if>
    			<c:if test="${lasttime==1}">
    			<td class="as">	
                <a href="<%=path%>/scorefind.action?pnumber=${khps.pnumber}&xiugaibz=${xiugaibz}&lasttime=${lasttime}&thisunder=${thisunder}&chaxunbz=${chaxunbz}">评分</a><b></b>
    			</td>
    			</c:if>
    			 	</tr><tr>
    			<td class="as">
    				审批流程
    			</td>
    			<td colspan="4">
    				<c:forEach items="${oplist}" var="op" varStatus="status">
    				${fb:jigouidtoname(op.jigouid)}&nbsp;&nbsp;${op.viewername}&nbsp;&nbsp;${op.odate}
    				    &nbsp;&nbsp;${op.otime}&nbsp;&nbsp;${fb:optiontostring(op.viewoption)}
    				   &nbsp;&nbsp;${op.remark1} &nbsp;&nbsp;${op.score}分
   				<br/><br/>
    				</c:forEach>
    			</td>
    		</tr>
    		
    		
    		<c:if test="${chaxunbz==0}"> 
    		<c:if test="${lasttime==0}">
    		<tr>
    		<td  class="as">审核意见</td>
    		<td colspan="5">
    		<input type="radio" name="radio" value="agree" onclick="sel(11)">
        						同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        				<c:if test="${tuihuibz==1}"> 
        				<input type="radio" name="radio" value="disagree" onclick="sel(22)">
        						退回
        						</c:if>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：<input type="text" name="textfield" >
    		</td>
    		</tr>
    		 
    		<tr>
    			<td class="as">
    				选择审核人
    			</td>
    			<td colspan="5">
    				<select name="thisunder" id="xuanze">
        				<option value="wu">请选择下一级审核人</option>
        					<c:forEach items="${list}" var="user" varStatus="status">
        						<option value="${user.newnumber}">${user.name}</option>
        					</c:forEach>
        			</select>
    			</td></tr>
    			<tr>
    			<td colspan="5">
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    				<input type="hidden" name="nextunder" value="${user.newnumber}"/>
    				<input type="hidden" name="pnumber" value="${khps.pnumber}"/>
    				<input type="hidden" name="item" value="${khps.item}"/>
    				<input type="hidden" name="score" value="${khps.score}"/>
    				<div align="center">
    				<input style="width:70px" type="button" onclick="tijiao()" value="提  交"/>
    				 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="button" onclick="javascript:history.go(-1);" value="返  回" /></div>
    				
    			</td></tr>
    		
    		</c:if>
    		</c:if>
    		<c:if test="${chaxunbz==0}">
    		<c:if test="${lasttime==1}"> 
    		<input id="xuanze" name="thisunder" type="hidden" value="${thisunder}">
    		<input type="hidden" type="radio" name="radio" value="agree" >
    		<tr>
    			<td colspan="5">
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    				<input type="hidden" name="nextunder" value="${user.newnumber}"/>
    				<input type="hidden" name="pnumber" value="${khps.pnumber}"/>
    				<input type="hidden" name="item" value="${khps.item}"/>
    				<input type="hidden" name="score" value="${khps.score}"/>
    				<div align="center">
    				<input style="width:70px" type="button" onclick="send()" value="提  交"/>
    				 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="button" onclick="javascript:history.go(-1);" value="返  回" /></div>
    			</td></tr>
    		</c:if></c:if>
    		<tr>    			
    			
    		</tr>
    
    	<c:if test="${chaxunbz==1}"> 
    	<tr>
    			
    			<td colspan="5">
    				<div align="center">
    				<input type="button" onclick="javascript:history.go(-1);" value="返  回" /></div>
    			</td>
    		</tr>
    	</c:if>
    	
    	</table>
    </form>
  </body>
</html>
