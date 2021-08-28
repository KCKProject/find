<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<spring:url value='/resources/css/style.css'/>">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="<spring:url value='/resources/script/script.js'/>" defer></script>
<title>비밀번호 찾기</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<section class="sectionLogin">
		<div class="wrap-memberInformationFind">
			<h3 class="loginTitle"><!-- 로그인 --></h3>
			<div class="loginBox memberInformationFindBox">
				<form:form commandName="member" method="POST">
					<form:input path="userId" id="userId" placeholder="아이디" requried="requried" />
					<form:select path="pwdQ" id="pwdQ" requried="requried">
						<form:option value="">=== 선택해주세요 ===</form:option>	
						<form:option value="1">어릴적 내가 살던 동네 이름은?</form:option>
						<form:option value="2">나의 초등학교 이름은?</form:option>
						<form:option value="3">나의 보물 1호는?</form:option>
						<form:option value="4">가장 존경하는 선생님의 성함은?</form:option>
						<form:option value="5">내가 가장 좋아하는 요리는?</form:option>
						<form:option value="6">가장 좋아하는 영화 제목은?</form:option>
						<form:option value="7">가장 좋아하는 동물은?</form:option>
						<form:option value="8">나의 어릴적 별명은?</form:option>
						<form:option value="9">가장 좋아하는 노래 제목은?</form:option>
						<form:option value="10">가장 좋아하는 숫자는?</form:option>
					</form:select>
					<form:input path="pwdA" id="pwdA" placeholder="답변" requried="requried" />
					<input type="submit" value="찾기" class="loginBoxbtn" onclick="return chk();">
				</form:form>
			</div>
		
		
<%-- 			<h3 class="loginTitle"><!-- 로그인 --></h3>
			<div class="loginBox">
				<form:form commandName="memberInformationFind">
					<form:select size="3" path="userQuetion">
						<option value="question1">어릴적 내가 살던 동네 이름은?</option>
						<option value="question2">나의 초등학교 이름은?</option>
						<option value="question3">나의 보물 1호는?</option>
						<option value="question4">가장 존경하는 선생님의 성함은?</option>
						<option value="question5">내가 가장 좋아하는 요리는?</option>
					</form:select>
					<form:input path="userAnswer" placeholder="답변" />
					<input type="submit" value="찾기" class="loginBoxbtn">
				</form:form>
			</div> --%>

		</div>
	</section>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
<script>
function chk(){
	if(document.getElementById("userId").value ==""){
		var first = document.getElementById("userId").value;
		alert(first);
		alert("아이디를 입력해주세요.");
		return false;
	}
	if(document.getElementById("pwdA").value ==""){
		alert("답변을 입력해주세요.");
		return false;
	}
	if(document.getElementById("pwdQ").value ==""){
		var third = document.getElementById("pwdQ").value;
		alert(third);
		alert("질문을 선택해주세요.");
		return false;
	}
	document.getElementById('member').submit();
}
</script>
</html>
