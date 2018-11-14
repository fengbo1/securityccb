<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
占位￠
<select id="areaname" name="areaname">
	<option value=" "> 请选择 </option>
	<c:forEach var="area" items="${arealist}" varStatus="status">  
    <option value="${area.areaid}">${area.areaname}</option>  
     </c:forEach>  
</select>￠
