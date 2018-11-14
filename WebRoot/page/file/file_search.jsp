<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String position= (String) request.getSession().getAttribute("position");
String type= (String) request.getSession().getAttribute("type");
String newnumber= (String) request.getSession().getAttribute("newnumber");    

%>
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

</style>
<script language="javascript">
function del_sure(){
 var gnl=confirm("请确定是否删除?");
 if (gnl==true){
  return true;
 }
 else{
  return false;
 }
}
</script>

<script language="javascript">
function new_open(aaa,bbb)
{
     
	 window.open("<%=path%>/page/file/downfile.jsp?url="+aaa+"&title="+bbb,"","height=300,width=500,top=400,left=600"); 
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
 								 <s:if test='type=="zdzh"'>制度文件->总行</s:if>
								<s:if test='type=="zdfh"'>制度文件->分行</s:if>
								<s:if test='type=="zdzx"'>制度文件->中心</s:if>
								<s:if test='type=="zdwb"'>制度文件->外部单位</s:if>
								<s:if test='type=="tbzh"'>通知通告->总行</s:if>
								<s:if test='type=="tbfh"'>通知通告->分行</s:if>
								<s:if test='type=="tbzx"'>通知通告->中心</s:if>
								<s:if test='type=="tbwb"'>通知通告->外部单位</s:if>
								<s:if test='type=="ya"'>应急预案</s:if>
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF">
								<b>
								<s:if test='type=="zdzh"'>制度文件（总行）</s:if>
								<s:if test='type=="zdfh"'>制度文件（分行）</s:if>
								<s:if test='type=="zdzx"'>制度文件（中心）</s:if>
								<s:if test='type=="zdwb"'>制度文件（外部单位）</s:if>
								<s:if test='type=="tbzh"'>通知通告（总行）</s:if>
								<s:if test='type=="tbfh"'>通知通告（分行）</s:if>
								<s:if test='type=="tbzx"'>通知通告（中心）</s:if>
								<s:if test='type=="tbwb"'>通知通告（外部单位）</s:if>
								<s:if test='type=="ya"'>应急预案</s:if>
								文件搜索
								</b>						
							</td>
							
						</tr>
		
						<tr>
						<c:if test="${fb:canoperate(newnumber)}">
					    </c:if>
					    <td colspan="5" align="center">	<form action="<%=path%>/filesearch.action?position=<%=position %>>" method="post" name="fm1">
						请输入查询内容：<input type="text" name="keyword" > <input type="submit"value="搜 索" />					
						
						</form>
						</td>
					    
					    </tr>
					      <tr height="5px"><td></td></tr>
						<tr height="50px" class="表格表头背景1" id="hang">
					
							<td  width="60px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>发布日期</p>
								</div></td>
							<td  width="130px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>文件类型</p>
								</div></td>
							<td  width="600px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>文件标题</p>
								</div></td>	
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>上传时间</p>
								</div></td>
							<!-- 	<c:if test="${fb:canoperate(newnumber)}">
					    	<td  width="40px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>删除</p>
								</div></td></c:if>--> 
																		
						</tr>
							<s:iterator value="mylist" status="L">							
							<tr class="btbj" id="hang" style="height:20px">								
								<td width="60px" height="25" align="center" valign="middle" nowrap>
									<div align="center"><s:property value="%{#L.getIndex()+1}"/>
									</div>
								</td>
								<td width="100px" height="25" align="center" valign="middle" nowrap>
									<div align="center"><s:date name="date" format="yyyy-MM-dd"/>
									
									</div>
								</td>
									<td width="130px" height="25" align="center" valign="middle" nowrap>
									<div align="center">
									
								<s:if test='type=="zdzh"'>制度文件（总行）</s:if>
								<s:if test='type=="zdfh"'>制度文件（分行）</s:if>
								<s:if test='type=="zdzx"'>制度文件（中心）</s:if>
								<s:if test='type=="zdwb"'>制度文件（外部单位）</s:if>
								<s:if test='type=="tbzh"'>通知通告（总行）</s:if>
								<s:if test='type=="tbfh"'>通知通告（分行）</s:if>
								<s:if test='type=="tbzx"'>通知通告（中心）</s:if>
								<s:if test='type=="tbwb"'>通知通告（外部单位）</s:if>
								<s:if test='type=="ya"'>应急预案</s:if>
									
									</div>
								</td>
								<td width="600px" height="25" align="center" valign="middle" nowrap>
									<div align="center">
									<a href="#" onclick="new_open('<s:property value="url"/>','<s:property value="title"/>')"/><s:property value="title"/></a>									
									</div>
								</td>
								<td width="100px" height="25" align="center" valign="middle" nowrap>
									<div align="center"><s:date name="nowdate" format="yyyy-MM-dd"/>
									</div>
								</td>
							<!--  	<c:if test="${fb:canoperate(newnumber)}">
								<td width="40px" height="25" align="center" valign="middle" nowrap>
									<div align="center">
									<a href="<%=path%>/filedel.action?type=<s:property value="type"/>&id=<s:property value="id"/>" onclick="javascript:return del_sure();"><span>删除</a>
									</div>
								</td></c:if>	-->		
								
					
							</tr>
						</s:iterator>		
		</table>
		
  </body>

</html>
