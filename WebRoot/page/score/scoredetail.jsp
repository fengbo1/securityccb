<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

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
.red{
font-family: 黑体;
font-size: 14px;
font-weight:lighter;
background-color:red;
}
.grey{
font-family: 黑体;
font-size: 14px;
font-weight:lighter;
background-color:#858585;
}
textarea{
			width:98%;
					height:130px;
					font-size:16px;
					font-family:"宋体";		
			}
-->
</style>

<script type="text/javascript">
 $(document).ready(function(){ 

$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
});

 function check(obj,max){
	  var score = obj.value;
	  var arry= new Array();
	  arry=score.split(".");
	  if(arry.length>2)
	  {
		alert("输入分数不符合规则！");
		setTimeout(function(){obj.focus();},10);
		return false;
		}
	  else if(Number(score)>Number(max))
	  {
		alert("输入分数超过限制！");
		setTimeout(function(){obj.focus();},10);
		return false;
		}
	  }
 function ypfj(para)
 {
	var message="";
	if(para=='ypfj')
	{
		message = "一票否决后机构年度考核分数将低于60分！";
		}
	else
	{
		message = "请确认是否要取消一票否决！";
		}
	if (window.confirm(message)) {
		with(document.forms[0]) {
			action='subitemscore.action?para='+para;
			method="post";
			submit();
		}
	}
}

 function tijiao() {
	 var remark = document.getElementById("remark").value;
	 var ifberen = document.getElementById("ifberen").value;
	  if(remark==""&&ifberen=="1")
	  {
		  alert("请填写评分依据");
		  document.getElementById("remark").focus();return;
		}

	 
	 var message = "请确认是否提交评分？";
	 if (window.confirm(message)) {
			with(document.forms[0]) {
				action='subitemscore.action?para=wu';
				method="post";
				submit();
			}
		} 

	 
 }

 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body >
${daohang }
  <form action="subitemscore.action?para=wu" method="post" name="fm1" id="form1">
   
      
   
					<table height="80" align="center" cellpadding="0"	cellspacing="2" border="0px">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="7" align="center" bordercolor="#FFFFFF"><b>${itemc}评分</b>						
							</td>
							
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
					
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
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>分值</p>
								</div></td>	
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>自评得分</p>
								</div></td>	
						</tr>
						<c:forEach items="${listsb}" var="sb" varStatus="status">
        						<tr <c:if test="${sb.beijing==2}">class="red"</c:if>
        						<c:if test="${sb.beijing!=2&&sb.ifxz==1}">class="btbj"</c:if>
        						<c:if test="${sb.ifxz==0}">class="grey"</c:if>
        						 id="hang" style="height:20px">
        						 <c:if test="${sb.ifxz==0&&sb.itemc!='reason'}">
									<td rowspan="2" class="grey" width="50px" height="25" align="center" valign="middle" ><div align="center">${sb.indx0+1}</div></td>
								</c:if>
								<c:if test="${sb.ifxz!=0}">
									<td <c:if test="${sb.ifxz==0}">class="grey"</c:if> width="50px" height="25" align="center" valign="middle" ><div align="center">${sb.indx0+1}</div></td>
								</c:if>		
								<td width="400px" height="25" align="left" valign="middle" ><div align="left">${sb.cont}</div></td>
								<td width="300px" height="25" align="left" valign="middle" ><div align="left">
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
					            <td width="100px" height="25" align="left" valign="middle" ><div align="left">
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
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">${sb.qudao}</div></td>
								<td width="70px" height="25" align="center" valign="middle" ><div align="center">
								<c:if test="${sb.qudaoe==0||sb.qudaoe==1}">
								${sb.stdscore}
								</c:if>
								</div></td>
								<td width="150px" height="25" align="center" valign="middle" >
								<div align="center">
								<c:if test="${sb.qudaoe==1||sb.ifxz==0}">
									<c:if test="${sb.ifxz==0}">
									-
									</c:if>
									<c:if test="${sb.ifxz==1}">
									${fb:doubleto1(sb.score)}
									</c:if>
								</c:if>
								<c:if test="${sb.qudaoe==0&&sb.ifxz==1}">
								<input style="width:60px" type="text" name="scores" onblur="check(this,'${sb.stdscore}');" onkeyup="this.value=value.replace(/[^\d.]/g,'')"  onafterpaste="this.value=value.replace(/[^\d.]/g,'')" maxlength="5" value="${fb:doubleto1(sb.score)}"/>
								<input type="hidden" name="scoreids" value="${sb.id}"/>
								</c:if>
								<c:if test="${sb.qudaoe==2&&sb.ifxz==1}">
								<input style="width:60px" type="text" name="scores" onblur="check(this,'${sb.stdscore}');" onkeyup="this.value=value.replace(/[^\d.]/g,'')"  onafterpaste="this.value=value.replace(/[^\d.]/g,'')" maxlength="5" value="${fb:doubleto1(sb.score)}"/>
								<input type="hidden" name="scoreids" value="${sb.id}"/>
								</c:if>
								<c:if test="${sb.qudaoe==3}">
								扣<input style="width:60px" type="text" name="scores" onblur="check(this,'${sb.stdscore}');" onkeyup="this.value=value.replace(/[^\d.]/g,'')"  onafterpaste="this.value=value.replace(/[^\d.]/g,'')" maxlength="5" value="${fb:doubleto1(sb.score*(-1))}"/>
								<input type="hidden" name="scoreids" value="${sb.id}"/>
								</c:if>
								<c:if test="${sb.qudaoe==4}">
								<c:if test="${sb.score!=1}">
								<button type="button" onclick="ypfj('ypfj')">一票否决</button>
								</c:if>
								<c:if test="${sb.score==1}">
								<button type="button" onclick="ypfj('qxypfj')">取消一票否决</button>
								</c:if>
								</c:if>
								</div>
								</td>
							</tr>
        				</c:forEach>
		
		</table>
		<br/><br/>
		<table height="80" align="center" cellpadding="0"	cellspacing="2" border="0px">
					<tr>
							<td
								style="width:1000px;color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								 align="center" bordercolor="#FFFFFF"><b>请填写评分依据，500字内<c:if test="${ifberen=='1'}">（必填）</c:if></b>						
							</td>
						</tr>
        				<tr class="btbj" id="hang" style="height:20px">			
        					
        					<td  align="center">
        						<textarea id="remark" name="remark">${remark}</textarea>
        					</td>
        					</tr>			
							<tr class="btbj" id="hang" style="height:20px">									
								<td >
								<div align="center">
								<input name="year" type="hidden" value="${year}"/>
								<input name="item" type="hidden" value="${item}"/>
								
        		         		<input id="xiugaibz" name="xiugaibz" type="hidden" value="${xiugaibz}"/>
        		         		<input id="ifberen" name="ifberen" type="hidden" value="${ifberen}"/>
								<input name="pnumber" type="hidden" value="${pnumber}"/>
								<input id="newnumber" name="newnumber" type="hidden" value="${newnumber}"/>
     							 <input id="jigouid" name="jigouid" type="hidden" value="${jigouid}"/>
     							 <input id="chaxunbz" name="chaxunbz" type="hidden" value="${chaxunbz}"/>
     							 <input id="lasttime" name="lasttime" type="hidden" value="${lasttime}"/>
     							 <input id="thisunder" name="thisunder" type="hidden" value="${thisunder}"/>
								<button type="button" value="提交" onclick="tijiao()">提  交</button>
								<input type="button" value="返  回" onclick="javascript:history.go(-1);"/>
								 
								</div>
								</td>
							</tr>
		</table>
		<br/><br/><br/>
		<table height="80" align="center" cellpadding="0"	cellspacing="2" border="0px">
			<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="8" align="center" bordercolor="#FFFFFF"><b>工作日志参考</b>						
							</td>
							
						</tr>
			
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
						</tr>
						<c:forEach items="${listr}" var="r" varStatus="status">
        					<tr class="btbj" id="hang" style="height:20px">
								<td  height="25" align="center" valign="middle" nowrap>
									<div align="center">${status.index+1}
									</div>
								</td>
								<td  height="25" align="center" valign="middle" nowrap>
									<div align="center">${r.remark2}
									</div>
								</td>
								<td  height="25" align="center" valign="middle" nowrap>
									<div align="center"><fmt:formatDate value="${r.date}" pattern="yyyy-MM-dd"/>
									</div>
								</td>
								<td  height="25" align="center" valign="middle" nowrap>
									<div align="center">
									${fb:khxmitemtostring(r.type)}
									</div>
								</td>
								<td  width="200px" height="25" align="center" valign="middle" nowrap>
									<div align="left">${r.content1}
									</div>
								</td>
								<td height="25" align="center" valign="middle" nowrap>
									<div align="center">${r.people}
									</div>
								</td>
								<td height="25" align="center" valign="middle" nowrap>
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
							</tr>   
        				</c:forEach>
		</table>
</form>	
  </body>

</html>
<%} %>
