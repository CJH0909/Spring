<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>헤더</title>
</head>
<body>
	<table border="0" width="100%">
		<tr>
			<td>
				<a href="${contextPath }/main.do"></a>
				<img alt="이미지" src="${contextPath }/resources/images/health.PNG" width="250px" hwight="250px" />
			</td>
			<td><font size="30">잠이 보약</font></td>
		</tr>
	</table>
</body>
</html>