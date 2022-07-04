<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${contextPath }/mem6.do">
		<h1 style="text-align: center;">삭제</h1>
		<table align="center">
			<tr>
				<td width="200">
					<p align="right">아이디</p>
				</td>
				<td width="400">
					<input type="text" name="id" />
				</td>
			</tr>
			<tr>
				<td width="200">
					<p align="right">&nbsp;</p>
				</td>
				<td width="400">
					<input type="submit" value="가입하기" />
					<input type="reset" value="다시입력" />
				</td>				
			</tr>									
		</table>
	</form>
</body>
</html>