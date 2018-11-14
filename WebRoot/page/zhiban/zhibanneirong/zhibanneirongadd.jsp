<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<% if (null == session.getAttribute("islogin"))  {%>
<script type="text/javascript">window.parent.parent.location.href="<%=basePath%>index.jsp";</script>
<%} else{%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>值班内容新增页面</title>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>

<style type="text/css">
.aa {
	color: #FFF;
	font-weight: bold;
	text-align: center;
}
</style>
<script type="text/javascript">
function findareaname()
{
var chushiid=document.getElementById("chushiid").value
//alert("获取到处室id"+chushiid ) 
var areaname;
var areaid;	

var xmlhttp;	
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			//document.getElementById("newp").innerHTML=xmlhttp.responseText;
			areaname=xmlhttp.responseText;		
			//alert("查询结果"+areaname ) 
			var arr=areaname.split("￠");
			//alert("查询结果d"+arr[1] ) 
			document.getElementById("areaname").innerHTML=arr[1]
		    //document.getElementById("area").innerHTML=arr[2]
			
		}				
	} 
	xmlhttp.open("GET","UserAddAjax.action?chushiid="+chushiid,true);
	xmlhttp.send();
	
	
}
</script>

</head>
<body>
值班管理->新增值班内容
<form name="fm1" action="<%=path%>/zhibanneirongAdd.action?" method="post" >

		<table height="80" align="center" cellpadding="0" cellspacing="2" border: 0px;">
				<tr>
							
					<td style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"	colspan="11" align="center" bordercolor="#FFFFFF">
						<b>值班内容新增</b>						
					</td>
							
				</tr>
	<tr  >
	<td height="30" bgcolor="#C0D3FD"  align="center">处室名称：</td>
	
	<td bgcolor="#F0F0F0"  align="center">
		<select id="chushiid" name="chushiid" onchange="findareaname()">  
								<option value=" "> 请选择     </option>  
                                <c:forEach var="chu" items="${chushilist}" varStatus="status">  
                                <option  value="${chu.chushiid}">${chu.chushi}  </option>  
                                </c:forEach>                                   
        </select>       
 
	</td>
	
	
	
	</tr>
	<tr  >
	
		
	
	<td height="30" bgcolor="#C0D3FD" align="center">责任区名称：</td>	
	<td bgcolor="#F0F0F0"  align="center">
		<div id="areaname" >                     
        </div> 
	</td>	
	</tr>
	<tr  >
	
	<td height="30" bgcolor="#C0D3FD"  align="center">责任区安防内容：</td>
		<td bgcolor="#F0F0F0">
		<input  name="zbnr" type="text" id="zbnr"  style="width:150px; height=20px;"/>
	</td>	
	</tr>
	
	

	<tr  >
    <td bgcolor="#C0D3FD" align="center"><input type="submit" value="新 增 " ></td>
	 <td bgcolor="#C0D3FD" align="center"> <input type="button" value="返 回"onclick="javascript:history.go(-1);"/>
	 <input type="hidden" name="position" value="${position}"/>
	 </td>
	</tr>
	
</table>
</form>

<script type="text/javascript">
function checkValue()
{
   if($(":text").value==null)
    alert("输入值不能为空");
   return;
}
</script>
</body>
<%} %>
</html>