<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath }" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
</head>
<body>
	<form action ="${contextPath }/mem4.do?action=updateMember" method="post">
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
					<p align="right">비밀번호</p>
				</td>
				<td width="400">
					<input type="password" name="pwd" />
				</td>
			</tr>
			<tr>
				<td width="200">
					<p align="right">이름</p>
				</td>
				<td width="400">
					<input type="text" name="name" />
				</td>
			</tr>
			<tr>
				<td width="200">
					<p align="right">이메일</p>
				</td>
				<td width="400">
					<input type="text" name="email" />
				</td>
			</tr>
			<tr>
				<td width="200">
					<p align="right">&nbsp;</p>
				</td>
				<td width="400">
					<input type="submit" value="수정하기" />
					<input type="reset" value="다시입력" />
				</td>		
		</table>
		
	</form>
</body>
</html>