<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="securityccb.score.pojo.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String position= (String) request.getSession().getAttribute("position");
String scores = (String)request.getSession().getAttribute("scores");

System.out.print("13"+scores);

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
<script type="text/javascript">
 $(document).ready(function(){ 
pingfen();
$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
});
 </script>
<script language="javascript">
function del_sure(){
 var gnl=confirm("你真的确定要删除吗?");
 if (gnl==true){
  return true;
 }
 else{
  return false;
 }
}
</script>
<script language="javascript">
function pingfen(){

var scores=document.getElementById('scores').value;
var xiugaibz=document.getElementById('xiugaibz').value;



var arr = new Array();

arr=scores.split("+");


for(var i=0;i<39;i++){

document.getElementsByName("pingfen")[i].value=arr[i];

}
if(xiugaibz==""){
	for(var i=0;i<39;i++){
		document.getElementsByName("pingfen")[i].readOnly=true;

	    }
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



 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body> 
  
  <form action="score.action" method="post" name="fm1" id="form1">
   <input id="newnumber" name="newnumber" type="hidden" value="${newnumber}"/>
      <input id="jigouid" name="jigouid" type="hidden" value="${jigouid}"/>
       <input id="scores" name="jigouid" type="hidden" value="${scores}"/>
       <input id="xiugaibz" name="xiugaibz" type="hidden" value="${xiugaibz}"/>
       
      
   
					<table height="80" align="center" cellpadding="0"	cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF"><b>年度自评</b>						
							</td>
							
						</tr>
					  
					
						<tr>
					
					
					  
						<tr height="50px" class="表格表头背景1" id="hang">
					
							<td  width="70px" align="center" valign="middle" nowrap	bordercolor=none><div align="center">
									<p>考核项目</p>
								</div></td>
							<td  width="50px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="400px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>考核内容</p>
								</div></td>	
							<td  width="300px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>评分方法标准</p>
								</div></td>	
						
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>备注</p>
								</div></td>
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>评分渠道</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>自评得分</p>
								</div></td>	
							
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>查看详情</p>
								</div></td>								
																		
						</tr>
													
							<tr class="btbj" id="hang" style="height:20px">									
								<td rowspan="3" width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[0].khxm}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">1</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[0].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[0].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[0].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[0].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
							
							<tr class="btbj" id="hang" style="height:20px">									
								 
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">2</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[1].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[1].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[1].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[1].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
							<tr class="btbj" id="hang" style="height:20px">									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">3</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[2].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[2].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[2].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[2].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
														<tr class="btbj" id="hang" style="height:20px">									
								<td rowspan="3" width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[3].khxm}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">4</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[3].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[3].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[3].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[3].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
														<tr class="btbj" id="hang" style="height:20px">									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">5</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[4].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[4].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[4].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[4].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
														<tr class="btbj" id="hang" style="height:20px">									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">6</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[5].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[5].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[5].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[5].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
														<tr class="btbj" id="hang" style="height:20px">									
								<td rowspan="1" width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[6].khxm}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">7</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[6].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[6].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[6].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[6].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
														<tr class="btbj" id="hang" style="height:20px">									
								<td rowspan="3" width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[7].khxm}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">8</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[7].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[7].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[7].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[7].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
														<tr class="btbj" id="hang" style="height:20px">									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">9</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[8].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[8].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[8].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[8].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
														<tr class="btbj" id="hang" style="height:20px">									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">10</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[9].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[9].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[9].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[9].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
														<tr class="btbj" id="hang" style="height:20px">									
								<td rowspan="3" width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[10].khxm}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">11</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[10].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[10].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[10].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[10].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
														<tr class="btbj" id="hang" style="height:20px">									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">12</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[11].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[11].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[11].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[11].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
														<tr class="btbj" id="hang" style="height:20px">									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">13</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[12].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[12].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[12].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[12].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
														<tr class="btbj" id="hang" style="height:20px">									
								<td rowspan="2" width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[13].khxm}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">14</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[13].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[13].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[13].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[13].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
														<tr class="btbj" id="hang" style="height:20px">									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">15</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[14].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[14].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[14].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[14].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
														<tr class="btbj" id="hang" style="height:20px">									
								<td rowspan="3" width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[15].khxm}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">16</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[15].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[15].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[15].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[15].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
														<tr class="btbj" id="hang" style="height:20px">									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">17</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[16].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[16].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[16].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[16].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
														<tr class="btbj" id="hang" style="height:20px">									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">18</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[17].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[17].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[17].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[17].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
														<tr class="btbj" id="hang" style="height:20px">									
								<td rowspan="3" width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[18].khxm}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">19</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[18].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[18].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[18].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[18].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
														<tr class="btbj" id="hang" style="height:20px">									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">20</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[19].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[19].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[19].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[19].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
														<tr class="btbj" id="hang" style="height:20px">									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">21</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[20].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[20].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[20].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[20].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
																					<tr class="btbj" id="hang" style="height:20px">									
								<td rowspan="3" width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[21].khxm}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">22</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[21].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[21].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[21].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[21].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
																					<tr class="btbj" id="hang" style="height:20px">									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">23</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[22].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[22].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[22].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[22].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
							
																												<tr class="btbj" id="hang" style="height:20px">									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">24</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[23].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[23].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[23].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[23].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
							
																												<tr class="btbj" id="hang" style="height:20px">									
								<td rowspan="3" width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[24].khxm}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">25</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[24].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[24].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[24].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[24].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
							
																												<tr class="btbj" id="hang" style="height:20px">									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">26</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[25].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[25].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[25].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[25].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
							
																												<tr class="btbj" id="hang" style="height:20px">									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">27</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[26].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[26].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[26].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[26].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
							
																												<tr class="btbj" id="hang" style="height:20px">									
								<td rowspan="2" width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[27].khxm}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">28</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[27].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[27].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[27].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[27].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
							
																												<tr class="btbj" id="hang" style="height:20px">									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">29</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[28].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[28].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[28].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[28].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
							
																												<tr class="btbj" id="hang" style="height:20px">									
								<td rowspan="2" width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[29].khxm}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">30</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[29].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[29].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[29].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[29].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
							
																												<tr class="btbj" id="hang" style="height:20px">									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">31</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[30].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[30].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[30].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[30].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
																																			<tr class="btbj" id="hang" style="height:20px">									
								<td rowspan="2" width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[31].khxm}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">32</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[31].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[31].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[31].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[31].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
																																			<tr class="btbj" id="hang" style="height:20px">									
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">33</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[32].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[32].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[32].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[32].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
																																			<tr class="btbj" id="hang" style="height:20px">									
								<td rowspan="1" width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[33].khxm}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">34</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[33].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[33].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[33].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[33].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
																																			<tr class="btbj" id="hang" style="height:20px">									
								<td rowspan="1" width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[34].khxm}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">35</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[34].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[34].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[34].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[34].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
																																			<tr class="btbj" id="hang" style="height:20px">									
								<td rowspan="1" width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[35].khxm}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">36</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[35].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[35].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[35].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[35].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
																																			<tr class="btbj" id="hang" style="height:20px">									
								<td rowspan="1" width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[36].khxm}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">37</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[36].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[36].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[36].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[36].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
																																			<tr class="btbj" id="hang" style="height:20px">									
								<td rowspan="1" width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[37].khxm}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">38</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[37].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[37].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[37].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[37].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
																																			<tr class="btbj" id="hang" style="height:20px">									
								<td rowspan="1" width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[38].khxm}</div></td>
								<td width="50px" height="25" align="center" valign="middle" ><div align="center">39</div></td>
								<td width="400px" height="25" align="center" valign="middle" ><div align="center">${kpxm[38].khnr}</div></td>
								<td width="300px" height="25" align="center" valign="middle" ><div align="center">${kpxm[38].pfbz}</div></td>
					            <td width="100px" height="25" align="center" valign="middle" ><div align="center">${kpxm[38].remark}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${kpxm[38].pfqd}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center"><input name="pingfen" type="text"  style="width:55px;" />	</div></td>
								<td width="10px" height="25" align="center" valign="middle" ><div align="center">		</div></td>													
							</tr>
<tr>
	<td colspan="5">
    				
    				<input type="button" onclick="javascript:history.go(-1);" value="返  回" />
    			</td></tr>
		</table>
</form>	
  </body>

</html>
<%} %>
