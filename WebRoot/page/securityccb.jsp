
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
%>


<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
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
		return "请确定是否退出?";
} else { 
        window.location.href="<%=path%>/index.jsp";
        return "请确定是否退出?";
}          
return "是否离开当前页面?";  //返回提示页面显示的信息
 }
 
</script>

<script type="text/javascript">

function frame(o)
{
	var id = document.getElementById("id").value;
	var obj = " ";
	obj=o;
//系统管理
     if(obj=="chu")//机构管理，用来维护处室20180305。
	{
	   document.getElementById("frame").src="<%=path%>/chu.action?currentPage=1&position=<%=position%>";
		
		}
	else if(obj=="userinfo")//人员管理，用来维护人员20180311。
	{
	   document.getElementById("frame").src="<%=path%>/userinfo.action?currentPage=1&position=<%=position%>";
		
		}
	else if(obj=="area")//责任区管理，用来维护责任区20180311。
	{
	   document.getElementById("frame").src="<%=path%>/area.action?currentPage=1&position=<%=position%>";
		
		}
	else if(obj=="jgxq")//机构详情，用来维护机构详情。
	{
	   document.getElementById("frame").src="<%=path%>/showjgxq.action?jigouid=<%=position.substring(0,3)%>&type=xiugai";
	}
 	//安防管理
	else if(obj=="paiban")//安防中的安防排班20180319。
	{
	   document.getElementById("frame").src="<%=path%>/paibanaction.action?currentPage=1&position=<%=position%>";
		
		}
	else if(obj=="zhibanneirong")//安防中的值班内容修改 20180322。
	{
	   document.getElementById("frame").src="<%=path%>/zhibanneirong.action?currentPage=1&position=<%=position%>";
		
		} 
	else if(obj=="zhiban")//安防中的值班登记 20180322。
	{
	   document.getElementById("frame").src="<%=path%>/zhiban.action?currentPage=1&position=<%=position%>";
		
		} 
	else if(obj=="zhibanfind")//安防中的值班查询20180327。
	{
	   document.getElementById("frame").src="<%=path%>/zhibanfindarea.action?currentPage=1&position=<%=position%>";
		
		} 
	else if(obj=="address")//员工应急联络。
	{
	   document.getElementById("frame").src="<%=path%>/address.action?currentPage=1&position=<%=position%>&newnumber=<%=newnumber%>";
		
		} 
	else if(obj=="record")//工作日志20180327。
	{
	   document.getElementById("frame").src="<%=path%>/record.action?currentPage=1&position=<%=position%>&newnumber=<%=newnumber%>";
		
		} 
	
	//制度文件	
	else if(obj=="zdzh")
	{
	   document.getElementById("frame").src="<%=path%>/file.action?type=zdzh&position=<%=position%>";
		}
	else if(obj=="zdfh")
	{
	   document.getElementById("frame").src="<%=path%>/file.action?type=zdfh&position=<%=position%>";
		}
	else if(obj=="zdzx")
	{
	   document.getElementById("frame").src="<%=path%>/file.action?type=zdzx&position=<%=position%>";
		}
	else if(obj=="zdwb")
	{
	   document.getElementById("frame").src="<%=path%>/file.action?type=zdwb&position=<%=position%>";
		}
	else if(obj=="tbzh")
	{
	   document.getElementById("frame").src="<%=path%>/file.action?type=tbzh&position=<%=position%>";
		}
	else if(obj=="tbfh")
	{
	   document.getElementById("frame").src="<%=path%>/file.action?type=tbfh&position=<%=position%>";
		}
	else if(obj=="tbzx")
	{
	   document.getElementById("frame").src="<%=path%>/file.action?type=tbzx&position=<%=position%>";
		}
	else if(obj=="tbwb")
	{
	   document.getElementById("frame").src="<%=path%>/file.action?type=tbwb&position=<%=position%>";
		}
	
	//应急预案
	else if(obj=="ya")
	{
	   document.getElementById("frame").src="<%=path%>/file.action?type=ya&position=<%=position%>";
		}
	//外部单位应急联络方式
	else if(obj=="othercompany")
	{
	   document.getElementById("frame").src="<%=path%>/other.action?position=<%=position%>";
		}
	
	

	
	
	else if(obj=="pwdmodify")
	{
	document.getElementById("frame").src="<%=path%>/usertomodify.action?id="+id;
	}
	
	else if(obj=="duty")
	{
	   document.getElementById("frame").src="<%=path%>/dutyArea_chaxun.action?type=find_all";
	}
	
	else if(obj=="register")
	{
	   document.getElementById("frame").src="<%=path%>/dutyArea.action?type=find_all";
		}

	else if(obj=="record")
	{
	   document.getElementById("frame").src="<%=path%>/record.action?position=${position}";
		}
		
	//安保管理页面20180328。	
	else if(obj=="m_afjc")
	{
	   document.getElementById("frame").src="<%=path%>/m.action?type=afjc&position=<%=position%>";
		}

	else if(obj=="m_ywbz")
	{
	   document.getElementById("frame").src="<%=path%>/m.action?type=ywbz&position=<%=position%>";
		}
	else if(obj=="m_yjgl")
	{
	   document.getElementById("frame").src="<%=path%>/m.action?type=yjgls&position=<%=position%>";
	}
	else if(obj=="m_jkxj")
	{
	   document.getElementById("frame").src="<%=path%>/m.action?type=jkxj&position=<%=position%>";
		}
	else if(obj=="m_jqzb")
	{
	   document.getElementById("frame").src="<%=path%>/m.action?type=jqzb&position=<%=position%>";
		}
	else if(obj=="m_afxg")
	{
	   document.getElementById("frame").src="<%=path%>/m.action?type=afxg&position=<%=position%>";
		}
	else if(obj=="m_afpx")
	{
	   document.getElementById("frame").src="<%=path%>/m.action?type=afpx&position=<%=position%>";
		}
	
	//考核管理
		else if(obj=="j_zpsh")
	{
	   document.getElementById("frame").src="<%=path%>/showkhps.action?&newnumber=<%=newnumber%>&position=<%=position%>";
		}
		else if(obj=="j_kpcx")
		{
		   document.getElementById("frame").src="<%=path%>/khpscx.action?&newnumber=<%=newnumber%>&position=<%=position%>";
			}
	//考评项目
		else if(obj=="j_kpxm")
	{
	   document.getElementById("frame").src="<%=path%>/showkpxm.action";
		}
		else if(obj=="j_import")//导入导出
		{
		   document.getElementById("frame").src="<%=path%>/showimport.action?&position=<%=position%>";
		}
		else if(obj=="j_khjd")
		{
		   document.getElementById("frame").src="<%=path%>/showkhjd.action?&newnumber=<%=newnumber%>&position=<%=position%>";
			}
    //年度自评20180605
		else if(obj=="j_ndzp")
	{
	   document.getElementById("frame").src="<%=path%>/kpxm.action?position=<%=position%>&newnumber=<%=newnumber%>";
		}
	 //工作计划201806014
		else if(obj=="plan")
	{
	   document.getElementById("frame").src="<%=path%>/plan1.action?position=<%=position%>&newnumber=<%=newnumber%>";
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
							<p style="font-size:13px;">欢迎访问<br/>安全管理与考核系统V1.0</p>
							<p style="padding:0px;margin:0px">
								<input align="right" name="logout" type="button" value="修改密码" onclick="frame('pwdmodify')" />&nbsp;
								<input align="right" name="logout" type="button" value="安全退出" onclick="location='<%=path%>/page/userinfo/logout.jsp'" />
								<input type="hidden" id="id" name="id" value="${id}"/>
							</p>
							<p style="padding:3px 0px 0px 5px;margin:0px"><%=new SimpleDateFormat("yyyy年MM月dd日")	.format(new java.util.Date())%></p>
							<p id="txt" style="padding:3px 0px 0px 0px;margin:0px 0px 0px 0px"></p>
							<p style="font-size:14px;">支持电话：13408000301</p>

						</div>
					</div>
					<b class="b4b d1"></b><b class="b3b d1"></b><b class="b2b d1"></b><b
						class="b1b"></b>
				</div>
				<div class="menu" style="margin-top:5px;background-color:#188AE7;">
					<ul class="expmenu">
					
				  <%if(quanxian.equals("1")||role.equals("1")||role.equals("2")||role.equals("3")){ %>					
					<li class="a">
							<div class="header">
								<span class="label">年度考核</span>
							</div>
							<ul class="menu" >
							<c:if test="${fb:canpingfen()}">
							
							<c:if test="${quanxian=='1'}">
								<li onclick="frame('j_ndzp')">年度自评</li>
								</c:if>
								<c:if test="${quanxian!='1'}">
								<li onclick="frame('j_zpsh')">待处理考核事项</li>
								</c:if>
								<li onclick="frame('j_kpcx')">考核情况查询</li>
								</c:if>
								<li onclick="frame('j_kpxm')">考核目标及标准</li>
								<c:if test="${quanxian=='1'}">	
								<li onclick="frame('j_import')">导出</li>
								</c:if>															
							</ul></li> <%} %>
							<%if(quanxian.equals("2")||quanxian.equals("1")||role.equals("0")||role.equals("1")||role.equals("2")||role.equals("3")){ %>
								<li class="a">
							<div class="header">
								<span class="label">日常管理</span>
							</div>
							<ul class="menu">
								<li onclick="frame('record')">工作日志</li>
							</ul></li>
							 <%} %>
							   <li class="a">
							<div class="header">
								<span class="label">应急管理</span>
							</div>
							<ul class="menu">								
								<li onclick="frame('ya')">应急预案</li>
								<li onclick="frame('address')">员工应急联络</li>
								<li onclick="frame('othercompany')">外部单位应急联络</li>
							</ul></li>	
					<li class="a">
							<div class="header">
								<span class="label">值班管理</span>
							</div>
							<ul class="menu">
								<li class="frame" onclick="frame('paiban')">安防排班</li>
								<li class="frame" onclick="frame('zhibanneirong')">值班内容</li>								
	                        	<li class="frame" onclick="frame('zhiban')">值班登记</li>
								<li class="frame" onclick="frame('zhibanfind')">值班查询</li>
							</ul></li>			
                 						
					<li class="a">
							<div class="header">
								<span class="label">通知通告</span>
							</div>
							<ul class="menu">
								<li class="frame" onclick="frame('tbzh')">总行</li>
								<li class="frame" onclick="frame('tbfh')">分行</li>
								<li class="frame" onclick="frame('tbzx')">中心</li>
								<li class="frame" onclick="frame('tbwb')">外部单位</li>
							</ul></li>	
							 <%if(quanxian.equals("1")||role.equals("0")||role.equals("1")||role.equals("2")||role.equals("3")){ %>		
				  <li class="a">
							<div class="header">
								<span class="label">工作计划</span>
							</div>
							<ul class="menu">
								<li onclick="frame('plan')">工作计划</li>
							</ul></li>			
							<%} %>
					<li class="a">
							<div class="header">
								<span class="label">制度文件</span>
							</div>
							<ul class="menu">
								<li class="frame" onclick="frame('zdzh')">总行</li>
								<li class="frame" onclick="frame('zdfh')">分行</li>
								<li class="frame" onclick="frame('zdzx')">中心</li>
								<li class="frame" onclick="frame('zdwb')">外部单位</li>
							</ul></li>								
						
						<!--  管理员有人员管理权限-->
	                   <%if(quanxian.equals("1")){ %>
						<li class="a">
							<div class="header">
								<span class="label">系统管理</span>
							</div>
							<ul class="menu">
								<li onclick="frame('chu')">处室管理</li>
								<li onclick="frame('userinfo')">人员管理</li>
								<li onclick="frame('area')">责任区管理</li>
					            <li onclick="frame('jgxq')">机构详情</li>
							</ul></li><%} %>
					</ul>
				</div>
			</div>
			<div class=x_xianshi style="overflow:auto">
				<div style="overflow:auto">
					<b class="b1"></b><b class="b2 d1"></b><b class="b3 d1"></b><b
						class="b4 d1"></b>
					<div class="b d1 k3" >

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