<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />  
<%
	request.setCharacterEncoding("utf-8");
%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript">
		function backToList(obj) {
			obj.action = "${contextPath}/board/listArticles.do"
			obj.submit()
		}

	</script>
</head>
<body>
	<h1 style="text-align: center;">새 글 쓰기</h1>
	<form name="ariticleForm" method="post" action="${contextPath}/board/addArticle.do">
		<table border="0" align="center">
			<tr>
				<td align="right">작성자 </td>
				<td colspan="2" align="center">
					<input type="text" name="member_nickname" />
				</td>
			</tr>
			<tr>
				<td align="right">글제목: </td>
				<td colspan="2" align="center"><input type="text" size="67" maxlength="500" name="title" placeholder="글제목" /></td>
			</tr>		
			<tr>
				<td align="right" valign="top"><br/>글내용: </td>
				<td colspan="2"><textarea name="content" rows="20" cols="100" maxlength="4000" placeholder="이곳에 글을 쓰세요."></textarea></td>
			</tr>
			<tr>
				<td align="right"></td>
				<td colspan="2">
					<input type="submit" value="등록" />
					<input type="button" value="목록보기"  onclick="backToList(this.form)"/>
				</td>
			</tr>
		</table>
	
	</form>
</body>
</html>




























