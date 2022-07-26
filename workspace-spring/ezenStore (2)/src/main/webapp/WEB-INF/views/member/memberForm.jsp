<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" /> 
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
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
		function fn_changeSmssts(obj){
			let checked = obj.checked;
			if(checked){
				$('#smssts_yn').val('Y');
			}
			else{
				$('#smssts_yn').val('N');
			}
			let YN = $('#smssts_yn').val();
			console.log(YN);
		}
		function fn_selectemail2(){
			let select= $('#email2_select').val();
			console.log(select);
			if(select=='1'){
				$('#email2').val('');
			}else{
				$('#email2').val(select);
			}
		}
		function fn_changeEmailsts(obj){
			let checked = obj.checked;
			if(checked){
				$('#emailsts_yn').val('Y');
			}
			else{
				$('#emailsts_yn').val('N');
			}
			let YN = $('#emailsts_yn').val();
			console.log(YN);
		}
		function fn_findAdrr() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var roadAddr = data.roadAddress; // 도로명 주소 변수
	                var extraRoadAddr = ''; // 참고 항목 변수

	                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraRoadAddr += data.bname;
	                }
	                // 건물명이 있고, 공동주택일 경우 추가한다.
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                if(extraRoadAddr !== ''){
	                    extraRoadAddr = ' (' + extraRoadAddr + ')';
	                }

	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('zipcode').value = data.zonecode;
	                document.getElementById("roadaddress").value = roadAddr;
	                document.getElementById("jibunaddress").value = data.jibunAddress;
	                
	                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
	                if(roadAddr !== ''){
	                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
	                } else {
	                    document.getElementById("sample4_extraAddress").value = '';
	                }

	                var guideTextBox = document.getElementById("guide");
	                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
	                if(data.autoRoadAddress) {
	                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
	                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
	                    guideTextBox.style.display = 'block';

	                } else if(data.autoJibunAddress) {
	                    var expJibunAddr = data.autoJibunAddress;
	                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
	                    guideTextBox.style.display = 'block';
	                } else {
	                    guideTextBox.innerHTML = '';
	                    guideTextBox.style.display = 'none';
	                }
	            }
	        }).open();
	    }
	</script>	
</head>
<body>
	<h3>가입입력사항</h3>
	<form action="${contextPath}/member/addMember.do" method="post">
		<div id="detail_table">
			<table>
				<tbody>
					<tr class="dot_line">
						<td class="fixed_join">아이디</td>
						<td>
							<input type="text" name="_member_id"  id="_member_id" size="20"/>
							<input type="hidden" name="member_id" id="member_id" />
							<input type="button" id="btnDuplicateCheck" value="중복체크" onclick="fn_duplicatecheck()" />
						</td>
					</tr>
					<tr class="dot_line">
						<td class="fixed_join">비밀번호</td>
						<td>
							<input type="password" name="member_pw"  id="member_pw" size="20"/>
						</td>
					</tr>
					<tr class="dot_line">
						<td class="fixed_join">이름</td>
						<td>
							<input type="text" name="member_name"  id="member_name" size="20"/>
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
						<td class="fixed_join">생년월일</td>
						<td>
							<select name="member_birth_y" id="year"></select>년
							<select name="member_birth_m" id="mon" ></select>월
							<select name="member_birth_d" id="day"></select>일
							<input type="radio" name="member_birth_gn" id="member_birth_g" class="_member_birth" value="G" checked="checked">양력
							<input type="radio" name="member_birth_gn" id="member_birth_n" class="_member_birth" value="N">음력
						</td>
					</tr>
					<tr class="dot_line">
						<td class="fixed_join">휴대폰번호</td>
						<td>
							<select name="hp1" class="_number1">
								<option value="010">010</option>
								<option value="031">011</option>
								<option value="063">016</option>
							</select>&nbsp;-&nbsp;
							<input type="text" name="hp2" class="_number2" />&nbsp;-&nbsp;
							<input type="text" name="hp3" class="_number2"/> </br>
							<input type="checkbox"  id="_smssts_yn" onchange="fn_changeSmssts(this)"/>BeyondTrust에서 발송하는 e-mail을 수신합니다.
							<input type="hidden" name="smssts_yn" id="smssts_yn" value="N" />
						</td>
					</tr>
					<tr class="dot_line">
						<td class="fixed_join">이메일</td>
						<td>
							<input type="text" name="email1" class="email_box" />&nbsp;@&nbsp;
							<input type="text" name="email2" id="email2" class="email_box" value="" />
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
							</select></br> 
						<input type="checkbox" id="_emailsts_yn" value="N" onchange="fn_changeEmailsts(this)"/>BeyondTrust에서 발송하는 e-mail을 수신합니다.
						<input type="hidden" name="emailsts_yn"  id="emailsts_yn" value="N" />
						</td>
					</tr>	
					<tr class="dot_line">
						<td class="fixed_join">주소</td>
						<td>
							<input type="text" name="zipcode" id="zipcode" placeholder="우편번호" />
							<input type="button" value="우편번호 찾기" onclick="fn_findAdrr()" /></br>
							지번주소:</br>
							<input type="text" name="jibunaddress" id="jibunaddress" class="addr" /></br>
							도로명 주소:</br>
							<input type="text" name="roadaddress" id="roadaddress" class="addr"/></br>
							나머지 주소:</br>
							<input type="text" name="namujiaddress" id="namujiaddress" class="addr"/>
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













