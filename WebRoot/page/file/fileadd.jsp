<%@taglib prefix="s" uri="/struts-tags"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<%   
      String path = request.getContextPath();
      String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";      
      String type = request.getParameter("type") ;
     
 %>
<html>  
    <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>

    <head>  
    	<meta http-equiv="cache-control" content="no-cache">
       
        <title></title>  
<script type="text/javascript">
function tijiao() {
var type1=document.getElementById('type1').value;
if(type1!="ya"){
var department=document.getElementById('type2').value;
	if(department==""){
	alert("请选择文件级别。")
	return false ;
	}
}

var title=document.getElementById('title').value;

	if(title==""||title==null){
	alert("请输入标题。")
	return false;
	}	
}
</script>
<script type="text/javascript">
function jsadd(){
var input = document.createElement('input');  //创建input节点
input.setAttribute('type', 'file'); 
input.setAttribute('name', 'file');  //定义类型是
document.getElementById('mform').appendChild(input ); //添加到form中显示
}
</script>  



<script type="text/javascript"> 
add = function(){  
    var div = document.getElementById("add");  
    var input = document.createElement("input")  
    input.setAttribute("type","file")  
    input.setAttribute("name","file")  
    document.getElementById('mform').appendChild(input);  
    var del = document.createElement("input")  
    del.setAttribute("type","button")  
    del.setAttribute("value","删除")  
      
    var br = document.createElement("br");  
      
    div.appendChild(input)  
    div.appendChild(del)  
    div.appendChild(br)  
      
    del.onclick = function(){  
        div.removeChild(input)  
        div.removeChild(del)  
        div.removeChild(br)  
    }  
}  
</script>  
<style type="text/css">
.aa {
	color: #FFF;
	font-weight: bold;
	text-align: center;
}
</style>


    </head>     
    <body>   
   制度文件->新增
    <form id="mform" action="<%=path%>/fileadd.action" method="post" enctype="multipart/form-data" onsubmit="return tijiao()">  
    <table height="80" align="center" cellpadding="0"		cellspacing="2" border: 0px;">
	   <tr>
			<td	style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="11" align="center" bordercolor="#FFFFFF">
						<%if(type.substring(0,2).equals("tb")){ %>		<b>通知通告新增</b>	<%} %>
						<%if(type.substring(0,2).equals("zd")){ %>		<b>制度文件新增</b>	<%} %>
						<%if(type.equals("ya")){ %>		<b>应急预案新增</b>	<%} %>					
			</td>
			<td>  <input type="hidden" value="<%=type %>" id="type1" name="type1" /></td> <!-- 判断是制度还是通报还是预案 -->
      <td> <input type="hidden" value="${position}" id="position" name="position" /> </td>    <!-- -->				
	</tr>
	
      
	
	<tr class="aa">
	<td width="300" height="40" bgcolor="#188BE8">请输入标题：</td>
	<td width="300" bgcolor="#F0F0F0"><textarea rows="1"  cols="60" id="title" name="title"></textarea></td>     
    </tr>
    
    
    
    <tr class="aa">
      <%if(!type.equals("ya")){%>
       <td width="300" height="40" bgcolor="#188BE8">请选择文件发布单位：</td>
       <td width="300" height="40" bgcolor="#F0F0F0"">
        <select name="type2" id="type2" >
            <option value="">请选择</option>
            <option value="zh">总行</option>
             <option value="fh">分行</option>
              <option value="zx">中心</option>
               <option value="wb">外部单位</option>              
            
        </select></td>        
       </td><%} %>
    </tr>       
       
      <tr class="aa">
       <td width="300" height="40" bgcolor="#188BE8">请选择文件发布日期:</td>
       <td width="300" height="40" bgcolor="#F0F0F0"><input size="9" type="text" name="date" id="date" class="Wdate" onClick="WdatePicker()" ></td>			
     </tr>

      <tr class="aa">
      <td width="300" height="40" bgcolor="#188BE8">
      <input type="button" value="添加附件" onClick="add()" />  
      </td>
      <td width="300" height="40" bgcolor="#F0F0F0">
      <div id="add"></div>
      </td>
      
      </tr>
      
       <tr class="aa" >
       <td width="745" height="40" bgcolor="#188BE8" colspan="3" align="center">
      <input type="submit" id="submit"  value="提 交">
      <input type="button" value="返 回"onclick="javascript:history.go(-1);"/>
      </td>
      </tr>
  </table>   
    
    </form> 
     
    </body>  
</html>