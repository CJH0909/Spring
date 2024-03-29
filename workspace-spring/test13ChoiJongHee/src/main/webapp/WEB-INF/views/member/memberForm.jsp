<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" /> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript">
	function fn_duplicatecheck() {
		let _id = $("#_member_id").val()
		if (_id == '') {
			alert("ID를 입력하세요.")
			return
		}
		$.ajax({
			type: "post",
			url: "${contextPath}/member/duplicateCheck.do",
			dataType: "text",
			data: {id: _id},
			success: function (data, textStatus) {
				if (data == 'false') {
					alert("사용할 수 있는 ID입니다.")
					$('#btnDuplicateCheck').prop("disabled", true)
					$('#_member_id').prop("disabled", true)
					$('#member_id').val(_id)
				}
				else {
					alert("사용할 수 없는 ID입니다.")
				}
			},
			error: function (data, textStatus) {
				alert("에러가 발생했습니다.")
			}
		})

	}
	
	$(document).ready(function(){            
	    var now = new Date();
	    var year = now.getFullYear();
	    var mon = (now.getMonth() + 1) > 9 ? ''+(now.getMonth() + 1) : '0'+(now.getMonth() + 1); 
	    var day = (now.getDate()) > 9 ? ''+(now.getDate()) : '0'+(now.getDate());           
	    //년도 selectbox만들기               
	    for(var i = 1900 ; i <= year ; i++) {
	        $('#year').append('<option value="' + i + '">' + i + '</option>');    
	    }

	    // 월별 selectbox 만들기            
	    for(var i=1; i <= 12; i++) {
	        var mm = i > 9 ? i : "0"+i ;            
	        $('#mon').append('<option value="' + mm + '">' + mm + '</option>');    
	    }
	    
	    // 일별 selectbox 만들기
	    for(var i=1; i <= 31; i++) {
	        var dd = i > 9 ? i : "0"+i ;            
	        $('#day').append('<option value="' + dd + '">' + dd+ '</option>');    
	    }
	    $("#year  > option[value="+year+"]").attr("selected", "true");        
	    $("#mon  > option[value="+mon+"]").attr("selected", "true");    
	    $("#day  > option[value="+day+"]").attr("selected", "true");       
	})
	
		function fn_selectemail2(){
			let select= $('#email2_select').val();
			console.log(select);
			if(select=='1'){
				$('#email2').val('');
			}else{
				$('#email2').val(select);
			}
		}
	</script>
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입정보 입력</h3>
	<form action="${contextPath}/member/addMember.do" method="post">
	<div id="memberForm">
			<table>
				<tbody>
					<tr class="dot_line">
						<td class="fixed_join">아이디</td>
						<td>
							<input type="text" name="_member_id"  id="_member_id" size="20"/>
							<input type="hidden" name="member_id" id="member_id" />
							<input type="button" id="btnDuplicateCheck" value="가입확인" onclick="fn_duplicatecheck()" />
						</td>
					</tr>
					<tr class="dot_line">
						<td class="fixed_join">비밀번호</td>
						<td>
							<input type="password" name="member_pwd"  id="member_pw" size="20"/>
						</td>
					</tr>
					<tr class="dot_line">
						<td class="fixed_join">이름</td>
						<td>
							<input type="text" name="member_name"  id="member_name" size="20"/>
						</td>
					</tr>
					<tr class="dot_line">
						<td class="fixed_join">닉네임</td>
						<td>
							<input type="text" name="member_nickname"  id="member_name" size="20"/>
						</td>
					</tr>
					<tr class="dot_line">
						<td class="fixed_join">성별</td>
						<td>
							<input type="radio" name="member_gender"  id="member_gender_female" value="female" checked="checked">여성
							<input type="radio" name="member_gender"  id="member_gender_maile" value="male" style="margin-left: 150px;">남성
						</td>
					</tr>
					
					<tr class="dot_line">
						<td class="fixed_join">이메일</td>
						<td>
							<input type="text" name="member_email1" class="email_box" />&nbsp;@&nbsp;
							<input type="text" name="member_email2" id="email2" class="email_box" value="" />
							<select id="email2_select" onchange="fn_selectemail2()">
								<option value="1">직접입력</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="naver.com">naver.com</option>
								<option value="yahho.co.kr">yahho.co.kr</option>
								<option value="paran.com">paran.com</option>
								<option value="nate.com">nate.com</option>
								<option value="google.com">google.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="empal.com">empal.com</option>
								<option value="korea.com">korea.com</option>
								<option value="freechal.com">freechal.com</option>								
							</select>
						</td>
					</tr>
					
					<tr class="dot_line">
						<td class="fixed_join">생년월일</td>
						<td>
							<select name="member_birth_y" id="year"></select>년
							<select name="member_birth_m" id="mon" ></select>월
							<select name="member_birth_d" id="day"></select>일
						</td>
					</tr>
					<tr class="dot_line">
						<td class="fixed_join">휴대폰번호</td>
						<td>
							<select name="member_hp1" class="_number1">
								<option value="010">010</option>
								<option value="031">011</option>
								<option value="063">016</option>
							</select>&nbsp;-&nbsp;
							<input type="text" name="member_hp2" class="_number2" />&nbsp;-&nbsp;
							<input type="text" name="member_hp3" class="_number2"/> </br>
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