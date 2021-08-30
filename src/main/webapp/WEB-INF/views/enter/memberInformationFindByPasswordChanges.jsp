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
				<form:form commandName="member" method="POST" onsubmit="return pwdcheck()">
					<c:forEach var="m" items="${members}">
						<p><strong style="color: #1ABC9C;">${m.userName}</strong>님 새로 사용할 비밀번호를 입력해주세요. </p><br>
						<form:input type="hidden" path="userPasswordCurrentChk" id="userPasswordCurrentChk" value="${m.userPassword}"/>
						
					</c:forEach>
					<div>
						변경 비밀번호<!--  <input type="text"> --><br>
						<form:input type="password" path="userPasswordNew" value="" id="userPasswordNew" />
						<form:errors path="userPasswordNew" id="userPasswordNew"/>
					</div>
					<div>
						비밀번호 확인<!--  <input type="text"> --><br>
						<form:input type="password" path="userPasswordNewConfirm" value="" id="userPasswordNewConfirm" />
					</div>
						<input type="submit" value="비밀번호 변경" class="loginBoxbtn">
				</form:form>
			</div>
		</div>
	</section>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
<script>
function pwdcheck(){
	if(document.getElementById("userPasswordNew").value==""){
		alert("변경하실 비밀번호를 입력해주세요.");
		return false;
	}
	if(documnet.getElementById("userPasswordNewConfirm").value==""){
		alert("비밀번호 확인을 입력해주세요.")
		return false;
	}
	if(document.getElementById("userPasswordNew").value != document.getElementById("userPasswordNewConfirm").value){
		alert("변경하실 비밀번호가 일치하지 않습니다.");
		return false;
	}
	var pwdRule =/^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{6,15}$/;
	if(!pwdRule.test(document.getElementById("userPasswordNew").value)){
     	alert("영문, 숫자, 특수문자 포함 6~15자로 만들어주세요.");
   		return false;
	}
	return true;
/* 	else{
		alert("변경완료 되었습니다.");
	} */
}
</script>
</html>
