<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
占位￠
<select id="chushi" name="chushi">
	<option value=" "> 请选择 </option>
	<c:forEach var="chushi" items="${chushilist}" varStatus="status">  
    <option value="${chushi.chushiid}">${chushi.chushi}</option>  
     </c:forEach>  
</select>￠
