<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String newnumber=(String) request.getSession().getAttribute("newnumber");
String name=(String) request.getSession().getAttribute("name");

   

   
%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
<link href="<%=path%>/css/buttons.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>值班登记主要页面</title>
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



</script>
<script type="text/javascript">
function checkAll() {  
var newnumber=document.getElementById('newnumber').value;
var newnumber1=document.getElementById('newnumber1').value;
var newnumber2=document.getElementById('newnumber2').value;


var one=document.getElementsByName('checkname[]');//获取到复选框的名称  
var flag = true ;
//因为获得的是数组，所以要循环 为每一个checked赋值  
for(var i=0;i<one.length;i++){  
 if(!one[i].checked){
     alert("有未完成事项！！");
     return false;
                    }
}


if((newnumber!=newnumber1 && newnumber!=newnumber2)&& !($("#flag").is(':checked'))){
   alert("您不在值班计划中无法值班");
     return false;
                    

}
alert("值班成功！");
 document.forms[0].submit();	
}  
</script>
<script type="text/javascript">
		$(document).ready(function(){
			$("#cover2").hide();
			$("#flag").click(function(){
			if($("#flag").is(':checked'))
				{
				$("#cover2").show();
				$("#cover1").hide();
				}
			else
				{
				$("#cover1").show();
				$("#cover2").hide();
				}
			});
			});
		</script>

<link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
</head>
<body>
值班管理->值班登记
	<form name="fm1" method="post" action="<%=path%>/zhibanareaadd.action?" >
		<table   height="161" align="center" cellpadding="0" cellspacing="2" style="margin-top: 30px; border: 0px;">
			<tr><td	style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF"><b>值班登记</b>
			</td></tr>
			
			<tr>
			<td colspan="2">	责任区名称：${areaname }				</td>
			<td>责任区区域：${area }				</td>
			</tr>
			<tr>
			<td colspan="2">			排班人员1：${name1 }		</td>
		<td>	排班人员2：${name2 }						</td>
			</tr>
			<tr>
			<td colspan="2">
			值班人员：<a id="cover1"><%=name %></a><input id="name" name="name" type="hidden" value="<%=name %>">
			<input value="<%=newnumber %>" type="hidden" id ="newnumber" name ="newnumber">
			<input value="${newnumber1}" type="hidden" id ="newnumber1" name ="newnumber1">
			<input value="${newnumber2}" type="hidden" id ="newnumber2" name ="newnumber2">
			<input value="${areaid}" type="hidden" id ="areaid" name="areaid">
			</td>
			<td>是否代值班：	<input id="flag" type="checkbox" name="ifcover"/>	</td>
	</tr>	<tr>
			<td id="cover2" colspan="2"><%=name %>代			
			<select  id="covernewnumber"  name="covernewnumber">
						 <option value ="">请选择</option>
						 <option value ="${newnumber1}">${name1 }</option>
                         <option value ="${newnumber2}">${name2 }</option>
  
               </select>值班
			
			
			
			</td>
			
			</tr>
		
			<tr class="表格表头背景1" id="hang" >
			<td width="60" height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
				<p>序号</p></div>
			</td>
			<td width="300" height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
				<p>责任事项</p></div>
			</td>
			<td width="300" height="30" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
				<p>是否完成</p></div>
			</td>
			</tr>
			
			<s:iterator value="zbnrlist" status="L">
			<tr height="20" class="btbj" id="hang" style="height:20px">
				<td height="30" width="60" align="left">
				<div align="center">
					<s:property value="%{#L.getIndex()+1}"/></div>
				</td>
				<td  width="300"  height="30" align="center">
					<div align="center">
					<s:property value="zhibanneirong"/></div>
				</td>
				<td  width="300"  height="30" align="center">
					<div align="center">
					<input type="checkbox" name="checkname[]"value="<s:property value="%{#L.getIndex()+1}"/>"/>已确认
					</div>
				
				</td>
			
				
        </tr>
         	</s:iterator>
         	<tr>
            <td bgcolor="#C0D3FD">备注：</td> 
            <td bgcolor="#C0D3FD" align="center"><input id="remarek" type="text"></td>
			<td bgcolor="#C0D3FD" align="center">
				<input type="hidden" name="position" value="${position }"/>
				<input type="button"  onclick="checkAll()" value="提 交" > 
				<input type="button" value="返 回"onclick="javascript:history.go(-1);"/>
			</td>
			 </tr>	      
				
		</table>
	
	</form>

	
</body>
<%} %>
</html>