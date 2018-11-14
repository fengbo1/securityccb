<%@taglib prefix="s" uri="/struts-tags"%>  
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String position= (String) request.getSession().getAttribute("position");

%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%}%>   

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>  
    <head>  
    <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
    	<meta http-equiv="cache-control" content="no-cache">    	     
        <title></title>  
<style type="text/css">
.aa {
	color: #FFF;
	font-weight: bold;
	text-align: center;
}
</style>
    </head>    
    <body>    
    工作计划->修改
    <form action="<%=path%>/planchangeok.action" method="post" enctype="multipart/form-data" > 
    <input type="hidden" name="position" value="<%=position %>">  
    <input type="hidden" name="id" value="${id }">  
    
	<table height="80" align="center" cellpadding="0"		cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF"><b>修改工作计划</b>						
							</td>						
</tr>
		<tr class="aa"> 
			<td  width="150" height="40" bgcolor="#188BE8">计划时间：</td>		
			<td  width="70" height="40" bgcolor="#188BE8">年份:<input value="${year }" type="text" name="year" id="boss_date" class="Wdate" onClick="WdatePicker()"  onfocus="WdatePicker({dateFmt: 'yyyy'})"></td>
			<td  width="70" height="40" bgcolor="#188BE8">月份:<input value="${month }"  type="text" name="month" id="boss_date" class="Wdate" onClick="WdatePicker()"  onfocus="WdatePicker({dateFmt: 'MM'})"></td>			
            <td  width="70" height="40" bgcolor="#188BE8"> 周：  <select  name="week" headerKey="" headerValue="周">
                                     <option value ="">请选择</option>
                                     <option value ="1"  <c:if test="${week=='1'}">selected="selected"</c:if>>第一周</option>
                                     <option value ="2"  <c:if test="${week=='2'}">selected="selected"</c:if>>第二周</option>
                                     <option value ="3"  <c:if test="${week=='3'}">selected="selected"</c:if>>第三周</option>
                                     <option value ="4"  <c:if test="${week=='4'}">selected="selected"</c:if>>第四周</option>

                                     <option value ="6"  <c:if test="${week=='6'}">selected="selected"</c:if>>常规事项</option>
                                     <option value ="7"  <c:if test="${week=='7'}">selected="selected"</c:if>>待定事项</option>
					
					
								</select></td>
       
       
        </tr>
        <tr class="aa">        
       		<td  width="100" height="40" bgcolor="#188BE8">工作内容：</td>
       		<td  width="100" height="40" bgcolor="#188BE8">
       		<input type="text" name="content" size="9" value="${content}"> </td>
       
        	<td  width="100" height="40" bgcolor="#188BE8">相关责任人：</td>
        	<td  width="100" height="40" bgcolor="#188BE8">
        	<input type="text"  name="people" value="${people}"></td>
        </tr>

        <tr class="aa">
        	<td  width="100" height="40" bgcolor="#188BE8">计划完成时间：</td>
        	<td  width="100" height="40" bgcolor="#188BE8">
        	
        	<input  type="text" name="plandate" id="plandte" class="Wdate" onClick="WdatePicker()" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd'})" value="${plandate}" > </td>
       
        	<td  width="100" height="40" bgcolor="#188BE8">备注：</td>
        	
        	<td  width="100" height="40" bgcolor="#188BE8">
        	<input type="text"  name="remark" value="${remark }"></td>
        </tr>
       
    <tr>  
    <td colspan="4" align="center"><input type="submit" name="submit" value="提 交">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="返 回"onclick="javascript:history.go(-1);"/></td>  
   
    </tr>  
    </table>
    </form>  
    </body>  
  
</html>