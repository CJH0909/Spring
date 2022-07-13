<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSON 데이터 보내기</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript">
	$(function() {
		$("#checkJSON").click(function() {
			let member = {
								id:"shin",
								pwd:"0824",
								name:"신사임당",
								email:"shin0713@gmail.com"
					}
			$.ajax({
				type: "post",
				url: "${contextPath}/rest/info",
				contentType: "application/json",
				data: JSON.stringify(member),
				success: function(data, textStatus){
				},
				error: function(data, textStatus){
					alert("에러가 발생했습니다.")
				},
				complete: function(data, textStatus){
					alert("완료")
				},
			})
		})
	})
	</script>
</head>
<body>	
	<input type="button" id="checkJSON" value="JSON 데이터 보내기"><br /><br />
	
</body>
</html>