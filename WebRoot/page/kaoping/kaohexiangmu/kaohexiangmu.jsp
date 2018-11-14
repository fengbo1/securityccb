<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
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

tr.locktop{
background-color:#FFFFFF;
position:relative;
top:expression((this.offsetParent.scrollTop>this.parentElement.parentElement.offsetTop?this.offsetParent.scrollTop-this.parentElement.parentElement.offsetTop-1:0)-1);
}

.grey{
font-family: 黑体;
font-size: 14px;
font-weight:lighter;
background-color:#858585;
}
-->
</style>

<script type="text/javascript">
 $(document).ready(function(){ 

	 $("tr.btbjodd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
	 $("tr.btbjeven").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
});

 function tijiao() {
	 var xuanze= document.getElementById("xuanze").value;
	 var message="确认提交？";
	 if(xuanze=="wu"||xuanze=="")
	  {
		  alert("请选择下一级审批人");
		  return;
		}
	 if (window.confirm(message)) {
			with(document.forms[0]) {
				action='submitscore.action';
				method="post";
				submit();
			}
		}
	}
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body >
  年度考核->年度自评
  <form action="submitscore.action" method="post" name="fm1" id="form1">
  	<table id="pol_table_list" cellspacing="0" align="center" style="width: 1150px;height:500px">
			<tr class="locktop">
			<th>
					<table height="80" align="center" cellpadding="0"	cellspacing="2" border="0px">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="8" align="center" bordercolor="#FFFFFF"><b>${jigouc}${year}年度自评</b>						
							</td>
							
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
					
								<td  width="50px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td colspan="2" width="120px" align="center" valign="middle" nowrap	bordercolor=none><div align="center">
									<p>考核项目</p>
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
									<p>自评得分${fb:doubleto1(sumscore)}</p>
								</div></td>	
						</tr>
		</table>
		</th>
			</tr>
			<tr>
			<td style="padding-left:1px">
		<table height="80" align="center" cellpadding="0"	cellspacing="2" border="0px">
						<c:forEach items="${listsb}" var="sb" varStatus="status">
						<c:if test="${sb.xuhao<17}">
        						<tr 
        						<c:if test="${sb.beijing==0}">class="btbjodd"</c:if>
        						<c:if test="${sb.beijing==1}">class="btbjeven"</c:if>
        						 id="hang" style="height:20px">
        						<c:if test="${sb.rowsp!='0'}">
        							<td rowspan="${sb.rowsp}" width="50px" height="25" align="center" valign="middle" ><div align="center">${sb.xuhao}</div></td>
        							<td rowspan="${sb.rowsp}" width="70px" height="25" align="center" valign="middle" ><div align="center">${sb.itemc}</div></td>
        						</c:if>
        						<c:if test="${sb.ifxz==0&&sb.itemc!='reason'}">
									<td rowspan="2" class="grey" width="50px" height="25" align="center" valign="middle" ><div align="center">${sb.indx+1}</div></td>
								</c:if>									
								<c:if test="${sb.ifxz!=0}">
									<td <c:if test="${sb.ifxz==0}">class="grey"</c:if> width="50px" height="25" align="center" valign="middle" ><div align="center">${sb.indx+1}</div></td>
								</c:if>	
								<td <c:if test="${sb.ifxz==0}">class="grey"</c:if> width="400px" height="25" align="left" valign="middle" ><div align="left">${sb.cont}</div></td>
								<td <c:if test="${sb.ifxz==0}">class="grey"</c:if> width="300px" height="25" align="left" valign="middle" ><div align="left">
									<c:if test="${sb.ifxz==1}">
										<c:if test="${sb.indx<35&&sb.indx!=5&&sb.indx!=6&&sb.indx!=9&&sb.indx!=30}">
											共${sb.stdscore}分，视完成情况得分。
										</c:if>
										<c:if test="${sb.indx>34}">
											${sb.std}
										</c:if>
										<c:if test="${sb.indx==5}">
											每进行教育培训一次得${fb:doubleto2(sb.stdscore/2)}分，累计得分不超过${fb:doubleto2(sb.stdscore)}分。
										</c:if>
										<c:if test="${sb.indx==6}">
											按要求与总行和所属机构或上级中心签订责任书得${fb:doubleto2(sb.stdscore*0.6)}分，与属地一级分行及所辖处室签订责任书得${fb:doubleto2(sb.stdscore*0.4)}分。
										</c:if>
										<c:if test="${sb.indx==9}">
											 共${sb.stdscore}分，发生安全责任事故不得分。 
										</c:if>
										<c:if test="${sb.indx==30}">
											共${sb.stdscore}分，发生安全责任事故不得分。 
										</c:if>
									</c:if>
								</div></td>
					            <td <c:if test="${sb.ifxz==0}">class="grey"</c:if> width="100px" height="25" align="left" valign="middle" ><div align="left">
					            	<c:if test="${sb.ifxz==1}">
					            		<c:if test="${sb.indx==5}">
											培训要有记录，包括并不限于：培训动态、培训图片、培训课件。 
										</c:if>
					            		<c:if test="${sb.indx==10}">
											每月组织一次自查，每次自查得${fb:doubleto2(sb.stdscore/12)}分。 
										</c:if>
										<c:if test="${sb.indx==14}">
											每组织一次演练得${fb:doubleto2(sb.stdscore/2)}分，累计得分不超过${fb:doubleto2(sb.stdscore)}分。 
										</c:if>
										<c:if test="${sb.indx==17}">
											预案体系完整，每组织演练一次得${fb:doubleto2(sb.stdscore/2)}分，累计得分不超过${fb:doubleto2(sb.stdscore)}分。
										</c:if>
										<c:if test="${sb.indx==29}">
											每组织一次培训得${fb:doubleto2(sb.stdscore/2)}分，累计得分不超过${fb:doubleto2(sb.stdscore)}分。
										</c:if>
										<c:if test="${sb.indx==31}">
											未及时向总行和相关部门报送案件事故和突发事件情况一次扣${fb:doubleto2(sb.stdscore/3)}分，扣完为止。
										</c:if>
					            	</c:if>
					            </div></td>
								<td <c:if test="${sb.ifxz==0}">class="grey"</c:if> width="70px" height="25" align="center" valign="middle" ><div align="center">${sb.qudao}</div></td>
								<c:if test="${sb.rowsp!='0'}">
        							<td rowspan="${sb.rowsp}" width="70px" height="25" align="center" valign="middle" >
        							<c:if test="${sb.item=='ypfj'&&sb.score==1}">一票否决</c:if>
        							<c:if test="${sb.item!='ypfj'}">${fb:doubleto1(sb.score)}</c:if>
        							<br/>
        							<c:if test="${ifcanpingfen!='no'&&sb.ifpinfen>0}">
        							<a	href="<%=path%>/score_detail.action?pnumber=kong&year=${year}&rater=${newnumber}&item=${sb.item}&jigouid=${jigouid}">点击评分</a>
        							</c:if>
        							</td>
        						</c:if>							
						</c:if>		
							</tr>
        				</c:forEach>
        				<c:if test="${ifcanpingfen!='no'}">				
							<tr class="btbj" id="hang" style="height:20px">									
								<td colspan="8">
								<div align="center">
								<select name="thisunder" id="xuanze">
        				  			<option value="wu">请选择下一级审批人</option>
        							<c:forEach items="${list}" var="user" varStatus="status">
        							<option value="${user.newnumber}">${user.name}</option>
        							</c:forEach>
        		         		</select>
        		         	 <input id="newnumber" name="newnumber" type="hidden" value="${newnumber}"/>
        		         		<input name="ifcanpingfen" type="hidden" value="${ifcanpingfen}"/>
        		         		<input name="year" type="hidden" value="${year}"/>
        		         		<input name="pnumber" type="hidden" value="${pnumber}"/>
        		         		<input name="jigouid" type="hidden" value="${jigouid}"/>
								<button type="button" onclick="tijiao()">提  交</button>
								<input type="button" value="返  回" onclick="javascript:history.go(-1);"/>
								 
								</div>
								</td>
							</tr>
							</c:if>
		</table>
		</td>
			</tr>	
		</table>	
</form>	
  </body>
</html>
<%} %>
