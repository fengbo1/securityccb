<%@taglib prefix="s" uri="/struts-tags"%>  
<%@ page language="java" import="java.text.SimpleDateFormat"%>

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
.WdateDiv {
  background-color: #FFFFFF;
  border: 1px solid #BBBBBB;
  padding: 2px;
  width: 50px; // 改此处
}

</style>
    </head>    
    <body>    
    工作计划->新增
    <form action="<%=path%>/plan_add.action" method="post" enctype="multipart/form-data" > 
    <input type="hidden" name="position" value="<%=position %>">  
	<table height="80" align="center" cellpadding="0"		cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF"><b>新增工作计划</b>						
							</td>						
                      </tr>
		<tr class="aa"> 
			<td  width="200" height="40" bgcolor="#188BE8">计划时间：</td>		
			<td  width="195" height="40" bgcolor="#188BE8">年:<input  type="text" name="year" id="boss_date" class="Wdate" onClick="WdatePicker()"  onfocus="WdatePicker({dateFmt: 'yyyy'})"></td>
			<td  width="195" height="40" bgcolor="#188BE8">月:<input  type="text" name="month" id="boss_date" class="Wdate" onClick="WdatePicker()"  onfocus="WdatePicker({dateFmt: 'MM'})"></td>			
            <td  width="125" height="40" bgcolor="#188BE8"> 周：  <select  name="week" headerKey="" headerValue="周">
                                     <option value ="">请选择</option>
                                     <option value ="1">第一周</option>
                                     <option value ="2">第二周</option>
                                     <option value ="3">第三周</option>
                                     <option value ="4">第四周</option>
                            <!--           <option value ="5">第五周</option>-->
                                     <option value ="6">常规事项</option>
                                     <option value ="7">待定事项</option>
                                     									 
								</select></td>
       
       
        </tr>
        <tr class="aa">        
       		<td  width="200" height="40" bgcolor="#188BE8">工作内容：</td>
       		<td colspan="3"  width="100" height="40" bgcolor="#F0F0F0">
       		
       		<textarea name="content" id="content"  style="height: 80px;width:500px;overflow:hidden"></textarea></td>
        </tr>       
          
     <!--   <tr>
        	<td>工作结果：<input type="text" name="result"></td>
        </tr>-->
        <tr class="aa" align="center">
        	<td  width="200" height="40" bgcolor="#188BE8">相关责任人：</td>
        	<td  colspan="3" width="100" height="40" bgcolor="#F0F0F0">
        	<input type="text"  name="people" ></td>
        </tr>

        <tr class="aa">
        	<td  width="200" height="40" bgcolor="#188BE8">计划完成时间：</td>
        	<td colspan="3" width="100" height="40" bgcolor="#F0F0F0">
        	<input  type="text" name="plandate" id="plandte" class="Wdate" onClick="WdatePicker()"  > </td>
        </tr>
       <!--  <tr>
        	<td>实际完成时间：<input  type="text" name="overdate" id="overdate" class="Wdate" onClick="WdatePicker()"  > </td>
        </tr>-->
        <tr class="aa">
        	<td  width="200" height="40" bgcolor="#188BE8">备注：</td>
        	
        	<td colspan="3" width="100" height="40" bgcolor="#F0F0F0">
        	<input type="text"  name="remark"></td>
        </tr>
       
    <tr>  
    <td colspan="4" align="center"><input type="submit" name="submit" value="提 交">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="返 回"onclick="javascript:history.go(-1);"/></td>    
   
    </tr>  
    </table>
    </form>  
    </body>  
  
</html>