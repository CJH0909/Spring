<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%> <!-- spring:message 태그 이용할 수 있도록 설정  -->
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="site.title" text="Member Info"/></title>
</head>
<body>
	<a href="${contextPath }/inter/locale.do?locale=ko">한국어</a> <!--한국어를 요청  -->
	<a href="${contextPath }/inter/locale.do?locale=en">Eng</a>	<!-- 영어를 요청 -->
	<h1><spring:message code="site.title" text="Member Info"/></h1>
	
	<p>
		<spring:message code="site.name" text="name"></spring:message>
		<spring:message code="name" text="name"></spring:message>
	</p>
</body>
</html>