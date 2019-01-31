<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>acceptance_data</title>
		<link href="<%=path%>/css/add.css" type="text/css"
			rel="stylesheet" />
				<style type="text/css">
			textarea{
					width:600px;
					height:150px;
					font-size:16px;
					font-family:"宋体";
			}
			.rd{
					color:red;
			}
		</style>
		<script type="text/javascript">
		function showbox(para){

			var jifen = "";
			var gljg = document.getElementById("gljg");
			var yhpc = document.getElementById("yhpc");
			var yjya = document.getElementById("yjya");
			var barygl = document.getElementById("barygl");
			var jfgl = document.getElementById("jfgl");
			var xfgl = document.getElementById("xfgl");
			var aqbm = document.getElementById("aqbm");
			var aqjy = document.getElementById("aqjy");

			if(gljg.checked)
			{
				jifen+="【管理机构】中：&nbsp;&nbsp;&nbsp;";
				jifen+="年内要对安全管理人员进行2次以上安全保卫业务教育培训，<br/>";
				jifen+="每进行教育培训一次得1分，累计得分不超过2分。是否需系统自动计分？";
				jifen+="<input type='radio' name='gljg' value='yes' checked/>是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				jifen+="<input type='radio' name='gljg' value='no'/>否";
				jifen+="<br/>";
				jifen+="<br/>";
				jifen+="<br/>";
				}
			if(yhpc.checked)
			{
				jifen+="【隐患排查】中：&nbsp;&nbsp;&nbsp;";
				jifen+="定期组织自查，发现问题，及时处理。每月组织一次自查，<br/>";
				jifen+="每次自查得1/3分。是否需系统自动计分？";
				jifen+="<input type='radio' name='yhpc' value='yes' checked/>是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				jifen+="<input type='radio' name='yhpc' value='no'/>否";
				jifen+="<br/>";
				jifen+="<br/>";
				jifen+="<br/>";
			}
			if(yjya.checked)
			{
				jifen+="【应急预案】中：&nbsp;&nbsp;&nbsp;";
				jifen+="适时组织有关人员进行实际演练，遇有情况能够妥善应对，<br/>";
				jifen+="每组织一次演练得1.5分，累计得分不超过3分。是否需系统自动计分？";
				jifen+="<input type='radio' name='yjya' value='yes' checked/>是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				jifen+="<input type='radio' name='yjya' value='no'/>否";
				jifen+="<br/>";
				jifen+="<br/>";
				jifen+="<br/>";
			}
			if(barygl.checked)
			{
				jifen+="【保安人员管理】中：&nbsp;&nbsp;&nbsp;";
				jifen+="各种应对突发事件预案健全完善，定期组织训练演练，<br/>";
				jifen+="预案体系完整，每组织演练一次得1分，累计得分不超过2分。是否需系统自动计分？";
				jifen+="<input type='radio' name='barygl' value='yes' checked/>是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				jifen+="<input type='radio' name='barygl' value='no'/>否";
				jifen+="<br/>";
				jifen+="<br/>";
				jifen+="<br/>";
			}
			if(jfgl.checked)
			{
				jifen+="【技防管理】中：&nbsp;&nbsp;&nbsp;";
				jifen+="各种应对突发事件预案健全完善，定期组织训练演练，<br/>";
				jifen+="预案体系完整，每组织演练一次得1分，累计得分不超过2分。是否需系统自动计分？";
				jifen+="<input type='radio' name='jfgl' value='yes' checked/>是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				jifen+="<input type='radio' name='jfgl' value='no'/>否";
				jifen+="<br/>";
				jifen+="<br/>";
				jifen+="<br/>";
			}
			if(xfgl.checked)
			{
				jifen+="【消防管理】中：&nbsp;&nbsp;&nbsp;";
				jifen+="消防预案健全完善，定期组织训练演练，<br/>";
				jifen+="预案体系完整，每组织演练一次得1分，累计得分不超过2分。是否需系统自动计分？";
				jifen+="<input type='radio' name='xfgl' value='yes' checked/>是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				jifen+="<input type='radio' name='xfgl' value='no'/>否";
				jifen+="<br/>";
				jifen+="<br/>";
				jifen+="<br/>";
			}
			if(aqbm.checked)
			{
				jifen+="【安全保密】中：&nbsp;&nbsp;&nbsp;";
				jifen+="经常进行安全保密教育，员工保密意识强，<br/>";
				jifen+="每组织安全保密教育一次得1分，累计得分不超过3分。是否需系统自动计分？";
				jifen+="<input type='radio' name='aqbm' value='yes' checked/>是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				jifen+="<input type='radio' name='aqbm' value='no'/>否";
				jifen+="<br/>";
				jifen+="<br/>";
				jifen+="<br/>";
			}
			if(aqjy.checked)
			{
				jifen+="【安全教育】中：&nbsp;&nbsp;&nbsp;";
				jifen+="经常开展法制和安全教育，认真做好重点人员帮教工作，<br/>";
				jifen+="每组织一次培训得1分，累计得分不超过2分。是否需系统自动计分？";
				jifen+="<input type='radio' name='aqjy' value='yes' checked/>是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				jifen+="<input type='radio' name='aqjy' value='no'/>否";
				jifen+="<br/>";
				jifen+="<br/>";
				jifen+="<br/>";
			}
			
			document.getElementById("jifen").innerHTML=jifen;
			}

		function tijiao()
		{
			var zzld=document.getElementById("zzld");
			var gljg=document.getElementById("gljg");
			var zrls=document.getElementById("zrls");
			var gzzd=document.getElementById("gzzd");
			var yhpc=document.getElementById("yhpc");
			var yjya=document.getElementById("yjya");
			var barygl=document.getElementById("barygl");
			var jfgl=document.getElementById("jfgl");
			var xfgl=document.getElementById("xfgl");
			var jtaq=document.getElementById("jtaq");
			var aqbm=document.getElementById("aqbm");
			var aqjy=document.getElementById("aqjy");
			var xxbs=document.getElementById("xxbs");
			var wwgl=document.getElementById("wwgl");
			var zdtfsj=document.getElementById("zdtfsj");
			var jljf=document.getElementById("jljf");

			var ltmd = '<%=request.getParameter("ltmd")%>';
			var date=document.getElementById("date").value;
			ltmd = ltmd.replace(/-/g,"/");
			date = date.replace(/-/g,"/");
			var ltmd = new Date(ltmd);
			var date = new Date(date);
			if(isNaN(date))
			{
				alert('请选择完成日期。');
				document.getElementById("date").focus();
				return;
			}
			else if(date<ltmd)
			{
				alert('完成日期只能上推三个月，补录时间不能超过三个月。');
				document.getElementById("date").focus();
				return;
			}

			var checkboxs = "";
			checkboxs = ifchk(zzld)+ifchk(gljg)+ifchk(zrls)+ifchk(gzzd)
						+ifchk(yhpc)+ifchk(yjya)+ifchk(barygl)+ifchk(jfgl)
						+ifchk(xfgl)+ifchk(jtaq)+ifchk(aqbm)+ifchk(aqjy)
						+ifchk(xxbs)+ifchk(wwgl)+ifchk(zdtfsj)+ifchk(jljf);

			
			var message = "请确定是否新增？";
			if (window.confirm(message)) {
				with(document.forms[0]) {
					action='write_record.action?checkboxs='+checkboxs;
					method="post";
					submit();
				}
			}
		}
		/*选中1，未选中0*/
		function ifchk(obj)
		{
			if(obj.checked)
			{
				return "1";
			}
			else
			{
				return "0";
			}
		}

		function checkdate()
		{
			var ltmd = '<%=request.getParameter("ltmd")%>';
			var date=document.getElementById("date").value;
			ltmd = ltmd.replace(/-/g,"/");
			date = date.replace(/-/g,"/");
			var ltmd = new Date(ltmd);
			var date = new Date(date);
			if(date<ltmd)
			{
				alert('完成日期只能上推三个月，补录时间不能超过三个月。');
				document.getElementById("date").focus();
			}
			
		}
		</script> 
		<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
	</head>
	<body>
	工作日志->新增
		<form name="filename" action="" method="post" enctype="multipart/form-data">
			<div class="layout" >
				<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
				align="center">
					<b>新增工作日志</b>
				</div>

				<div id="content">
					
					<div class="four_columns">
						<div class="two_columns_text">
							完成日期:&nbsp;
						</div>
						<div class="four_columns_input">
						 	<input type="text" name="date" id="date" class="Wdate" onClick="WdatePicker()" onchange="checkdate()">
						</div>
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns">
						
					<div class="two_columns_text">
							工作内容:&nbsp;
					</div>
					<div class="two_columns_input">
						<textarea name="content1" ></textarea>
					</div>
						
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							相关责任人:&nbsp;
					</div>
					<div class="two_columns_input">
						<input name="people" type="text"/>
					</div>
					<div class="clear"></div>
				</div>
				<br/>
					<div class="two_columns_text">
							对应考核项:&nbsp;
					</div>
					<div class="two_columns_input">
						<input  type="checkbox" id="zzld">组织领导&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input  type="checkbox" id="gljg" onclick="showbox('gljg')">管理机构&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input  type="checkbox" id="zrls">责任落实&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      	<input  type="checkbox" id="gzzd">规章制度&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      	<input  type="checkbox" id="yhpc" onclick="showbox('yhpc')">隐患排查&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    	<input  type="checkbox" id="yjya" onclick="showbox('yjya')">应急预案<br/>
                    	<input  type="checkbox" id="barygl" onclick="showbox('barygl')">保安人员管理&nbsp;&nbsp;&nbsp;&nbsp;                              
                   	   	<input  type="checkbox" id="jfgl" onclick="showbox('jfgl')">技防管理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                   	   	<input  type="checkbox" id="xfgl" onclick="showbox('xfgl')">消防管理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                   	   	<input  type="checkbox" id="jtaq">交通安全&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                    	<input  type="checkbox" id="aqbm" onclick="showbox('aqbm')">安全保密<br/>
						<input  type="checkbox" id="aqjy" onclick="showbox('aqjy')">安全教育&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                      	<input  type="checkbox" id="xxbs">信息报送&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                    	<input  type="checkbox" id="wwgl">外委管理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
                    	<input type="checkbox"  id="zdtfsj">突发事件处置&nbsp;&nbsp;&nbsp;&nbsp;                     
                      	<input  type="checkbox" id="jljf">奖励加分<br>  
                      	<p style="font-size:16px;font-family: '黑体'">提示：一条工作日志可复选多个对应考核项目。</p>
					</div>
					<div class="clear"></div>
				</div>
				<br/>
				<div class="two_columns">
						
					<div class="two_columns_text">
							是否自动积分:&nbsp;
					</div>
					<div class="two_columns_input" id="jifen">
						
					</div>
						
					<div class="clear"></div>
				</div>
				<br/>
				<div class="two_columns">
					<div class="two_columns_text">
							附件:&nbsp;
					</div>
					<div class="two_columns_input">
						①<input type="file" name="file1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						②<input type="file" name="file2"><br/>
						③<input type="file" name="file3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						④<input type="file" name="file4"> <br/>
						⑤<input type="file" name="file5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						⑥<input type="file" name="file6"> <br/>
						⑦<input type="file" name="file7">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						⑧<input type="file" name="file8"> <br/> 
					</div>
					<div class="clear"></div>
				</div>
				<div class="two_columns">
					<div class="two_columns_text">
							备注:&nbsp;
					</div>
					<div class="two_columns_input">
						<input type="text" name="remark" style="width:600px"/>
					</div>
					<div class="clear"></div>
				</div>
				<div style="padding-left:440px" >
					<input type="hidden" name="position" value="${position}"/>
    				<input type="button" value="提交" onclick="tijiao()"/>
    				<input type="button" value="返 回"onclick="javascript:history.go(-1);"/><br>
					<div class="clear"></div>
				</div>
				</div>
			</div>
		</form>
	</body>

</html>


