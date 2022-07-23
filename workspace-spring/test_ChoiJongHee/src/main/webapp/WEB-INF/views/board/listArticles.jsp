<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 목록</title>
	<style type="text/css">
		a{
			text-align: center;
		}
	</style>
</head>
<body>
	<table align="center" border="1" width="80%">
		<tr height="10" align="center" bgcolor="lightblue">
			<td>글번호</td>
			<td>닉네임</td>
			<td>제목</td>
			<td>작성일</td>
		</tr>
			<c:choose>
				<c:when test="${empty articlesList }">
					<tr height="10">
						<td colspan="4">
							<p>
								<b><span style="font-size: 9pt;">등록된 글이 없습니다.</span></b>
							</p>
						</td>
					</tr>
				</c:when>
				
				<c:otherwise>
					<c:forEach var="article" items="${articlesList }">
						<tr align="center">
							<td width="5%">${article.user_board_idx }</td>
							<td width="10%">${article.member_nickname }</td>
							<td width="35%" align="left">
								${article.title }
							</td>
							<td width="10%">
								<fmt:formatDate value="${article.postdate }"/>
							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>

	</table>
		<a class="cls1" href="${contextPath}/board/articleForm.do?"><p class="cls2">글쓰기</p></a>
</body>
</html>


























