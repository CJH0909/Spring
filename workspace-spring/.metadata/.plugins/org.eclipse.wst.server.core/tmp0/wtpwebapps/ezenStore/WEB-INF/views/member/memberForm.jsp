<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>  
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		function fn_duplicatecheck(){
			let _id = $("#_member_id").val()
			if(_id==''){
				alert("아이디를 입력하세요")
				return
			}
			$.ajax({
				type:"post",
				url: "${contextPath}/member/duplicateCheck.do",
				dataType: "text",
				data: {id: _id},
				success: function(data, textStatus){
					alert(data)
					if(data =="as123"){
						alert("사용할 수 있는 아이디입니다")
						$('#btnDuplicateCheck').prop("disabled", true)
						$('#_member_id').prop("disabled",true)
						$('#member_id').val(_id)
					}
					else{
						alert("중복된 아이디입니다")
					}
				},
				error: function(data,textStatus){
					alert("에러발생")
				}
			})
		}
	</script>
</head>
<body>
	<h3>회원가입정보 입력</h3>
	<form action="${contextMember}/member/addMember.do" method="post">
		<div id="detail_table">
				<table>
					<tbody>
						<tr class="dot_line">
							<td class ="fixed_join">아이디</td>
							<td>
								<input type="text" name="_member_id" id="_member_id" size="20"/>
								<input type="hidden" name="member_id" id="member_id"/>
								<input type="button" id="btnDuplicateCheck" value="중복확인" onclick="fn_duplicatecheck()"/>
							</td>
						</tr>
					</tbody>
				</table>
		</div>
		
		<div class="clear">
			<br />
			<table align="center">
				<tr>
					<td>
						<input type="submit" value="회원가입" />
						<input type="reset" value="다시입력" />
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>