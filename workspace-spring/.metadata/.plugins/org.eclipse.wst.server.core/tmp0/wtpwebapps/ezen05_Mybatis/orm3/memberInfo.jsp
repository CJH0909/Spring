<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보출력</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="5%"><b>이름</b></td>
			<td width="11%"><b>이메일</b></td>
			<td width="5%"><b>가입일</b></td>
		</tr>		
		<c:choose>
			<c:when test="${memberDTO== null }">
				<tr>
					<td colspan="5">
						<b>등록된 회원이 없습니다.</b>
					</td>
				</tr>
			</c:when>
			<c:when test="${memberDTO != null }">		<!-- 표현언어에서 바인딩된 속성이름으로 바로 접근 -->
					<tr align="center">
						<td>${memberDTO.id }</td>
						<td>${memberDTO.pwd }</td>	
						<td>${memberDTO.name }</td>
						<td>${memberDTO.email }</td>
						<td>${memberDTO.joindate }</td>						
					</tr>
			</c:when>
		</c:choose>
	</table>
</body>
</html>