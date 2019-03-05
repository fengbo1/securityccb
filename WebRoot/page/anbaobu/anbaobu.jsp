
<%

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String name = (String)request.getSession().getAttribute("name");	
	String position = (String)request.getSession().getAttribute("position");	
	String newnumber = (String)request.getSession().getAttribute("newnumber");
	String role = (String)request.getSession().getAttribute("role");
	String quanxian = (String)request.getSession().getAttribute("quanxian");	
	String IP=request.getRemoteAddr();
	session.setAttribute("IP",IP);   
    System.out.print("quanxian:"+quanxian);
 	
		Date date = new Date();
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("YYYY");
		String yyyy = bartDateFormat.format(date)+"、A";
		String yyyear = bartDateFormat.format(date);
 
%>

<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/cccx.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/styles.css" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js"></script>
  
<script language="javascript"> 

function startTime()
{
	
var today=new Date();
var h=today.getHours();
var m=today.getMinutes();
var s=today.getSeconds();
// add a zero in front of numbers<10
m=checkTime(m);
s=checkTime(s);
document.getElementById('txt').innerHTML=h+":"+m+":"+s;
t=setTimeout('startTime()',500);
}

function checkTime(i)
{
if (i<10) 
  {i="0" + i;}
  return i;
}
 function close(){ 
	if((event.clientX>document.body.clientWidth&&event.clientY<0)||event.altKey) {
//		alert("安全退出!"); 
		window.location.href="<%=path%>/index.jsp";
		return "请确认是否退出？";
} else { 
//        alert("安全退出!"); 
        window.location.href="<%=path%>/index.jsp";
        //return "刷新触发";
        return "请确认是否退出？";
}          
return "是否离开当前页面";  //返回提示页面显示的信息
 }
 
</script>

<script type="text/javascript">

function frame(o)
{
	var id = document.getElementById("id").value;
	var obj = " ";
	obj=o;

     if(obj=="kaiguan")//
	{
	   document.getElementById("frame").src="<%=path%>/page/beforeanbaobu.jsp";
		}
	else if(obj=="jgkaohe")//
	{
		 document.getElementById("frame").src="<%=path%>/showkhps.action?&newnumber=${newnumber}&position=${position}";
		}
	else if(obj=="fxcjc")//
	{
		 document.getElementById("frame").src="<%=path%>/jigouall.action";
		}
	else if(obj=="j_khjd")
	{
	   document.getElementById("frame").src="<%=path%>/showkhjd.action?&newnumber=<%=newnumber%>&position=<%=position%>";
		}
	else if(obj=="khcx")
	{
	   document.getElementById("frame").src="<%=path%>/khpscx.action?&newnumber=<%=newnumber%>&position=<%=position%>";
		}
	else if(obj=="pwdmodify")
	{
	document.getElementById("frame").src="<%=path%>/usertomodify.action?id="+id;
	}
	else if(obj=="j_import")//导入导出
		{
		   document.getElementById("frame").src="<%=path%>/showimport.action?&position=<%=position%>";
		}
	else if(obj=="fankui")
		{
		 document.getElementById("frame").src="<%=path%>/page/system/fankuilistbefore.jsp";
		}
		else if(obj=="jigou")
		{
		 document.getElementById("frame").src="<%=path%>/page/anbaobu/jigoubefore.jsp";
		}		
	}

</script>

</head>
			 
<body onload="startTime()">
	<div id="zhuti" style="position:absolute">
		<div id="top">
			<img src="picture/logo.gif" width="276" height="50"
				style="margin-top:0px" />
		</div>
		<div class=x_beijing>
			<div class=x_anniu>
				<div>
					<b class="b1"></b><b class="b2 d1"></b><b class="b3 d1"></b><b
						class="b4 d1"></b>
					<div class="b d1 k">
						<div class=x_gr>
							<!-- 登陆用户信息 -->
							<p style="padding:0px;margin:0px">${name }</p>
							<p style="font-size:14px;padding:2px 0px 0px 0px;margin:0px 0px 0px 0px">欢迎访问<br/>安全管理与考核系统V1.0</p>
							<p style="padding:0px;margin:0px">
								<input align="right" name="logout" type="button" value="修改密码" onclick="frame('pwdmodify')" />&nbsp;
								<input align="right" name="logout" type="button" value="安全退出" onclick="location='<%=path%>/page/userinfo/logout.jsp'" />
								<input type="hidden" id="id" name="id" value="${id}"/>
							</p>
							<p style="padding:0px 0px 0px 0px;margin:0px"><%=new SimpleDateFormat("yyyy年MM月dd日")	.format(new java.util.Date())%></p>
							<p id="txt" style="font-size:14px;padding:0px 0px 0px 0px;margin:0px 0px 0px 0px"></p>
							<p style="font-size:14px;padding:2px 0px 0px 0px;margin:0px 0px 0px 0px">支持电话：028-86027534</p>
						</div>
					</div>
					<b class="b4b d1"></b><b class="b3b d1"></b><b class="b2b d1"></b><b
						class="b1b"></b>
				</div>
				<div class="menu" style="margin-top:5px;background-color:#188AE7;">
					<ul class="expmenu">
					<li class="a">
							<div class="header">
								<span class="label">年度考核</span>
							</div>
							<ul class="menu">
							<c:if test="${role=='3'}">
								<li class="frame" onclick="frame('kaiguan')">考核开关</li>
								</c:if>
								<li class="frame" onclick="frame('jgkaohe')">待处理考核事项</li>
								<li class="frame" onclick="frame('khcx')">考核情况查询</li>
								<c:if test="${role=='3'}">
								<li onclick="frame('j_khjd')">考核进度</li>
								<li onclick="frame('j_import')">导入</li>	
								</c:if>
							</ul></li>								
					<li class="a">
							<div class="header" onclick="frame('fxcjc')">
								<span class="label">非现场检查</span>
							</div>
					</li>
					<li class="a">
							<div class="header">
								<span class="label">系统管理</span>
							</div>
							<ul class="menu">
								<li class="frame" onclick="frame('fankui')">留言反馈</li>
								<li class="frame" onclick="frame('jigou')">机构管理</li>
						</ul></li>		
					</ul>
				</div>
			</div>
			<div class=x_xianshi style="overflow:auto">
				<div style="overflow:auto">
					<b class="b1"></b><b class="b2 d1"></b><b class="b3 d1"></b><b
						class="b4 d1"></b>
					<div class="b d1 k3" style="overflow:auto">
						<iframe id="frame" class="mainpage"	src="#" marginwidth='0'
							marginheight='0' frameborder='0'></iframe>
					</div>
					<b class="b4b d1"></b><b class="b3b d1"></b><b class="b2b d1"></b><b
						class="b1b"></b>
				</div>
			</div>
		</div>
	</div>
</body>
</html>