<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../resources/css/style.css">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="../../resources/script/script.js" defer></script>
<title>마이페이지</title>
</head>
<body>

	<jsp:include page="../include/header.jsp" />

	<section class="myInfoUpdatePage myPage">
		<h1>비밀번호 수정</h1>
		

		<div class=myInfoDetail>			
    		<div class="changePassword">
				<div class="changePasswordContents">
					<form:form commandName="myPasswordUpdateCommand" method="POST" onsubmit="return pwdcheck()">
						<div>
							현재 비밀번호 <!-- <input type="text"> -->
							<form:input type="hidden" path="userPasswordCurrentChk" id="userPasswordCurrentChk" value="${myPasswordUpdate.userPassword}"/>
							<form:input type="password" path="userPasswordCurrent" value="" id="userPasswordCurrent"/>
							<br><form:errors path="userPasswordCurrent"/>
						</div>
						<div>
							변경 비밀번호<!--  <input type="text"> -->
							<form:input type="password" path="userPasswordNew" value="" id="userPasswordNew" />
							<br><form:errors path="userPasswordNew"/>
						</div>
						<div>
							비밀번호 확인<!--  <input type="text"> -->
							<form:input type="password" path="userPasswordNewConfirm" value="" id="userPasswordNewConfirm" />
							<br><form:errors path="userPasswordNewConfirm"/>
						</div>
						<div>
							<input type="submit" value="비밀번호 변경" class="changePasswordBtn">
						</div>
					</form:form>
				</div>	
			</div> 
			
		
			<div class="myPasswordUpdatePageBtn">
				<a href="<c:url value='/myPage/myInfoUpdate/${memberAuthInfo.getMemberNumber()}'/>" class="changeInfoBtn"><span class="clickText">click</span><i class="fas fa-user-edit editIcon"></i>나의정보 변경</a>
				<a href="<c:url value='/myPage/myPage/${memberAuthInfo.getUserId()}'/>" class="changeInfoBtn"><i class="fas fa-user-alt editIcon"></i>마이페이지<span class="clickText">click</span></a>
			</div>

<!-- 		<div class="myInfoUpdateNotice">
				<h3>NOTICE</h3>
				<p><i class="fas fa-info"></i>아이디는 수정 불가 합니다.</p>
				<p><i class="fas fa-info"></i>연락처 오기재시 연결이 어려우니 필히 재확인 부탁드립니다.</p>
				<p><i class="fas fa-info"></i>이름은 자유롭게 기재 가능 합니다(실명이 아니어도 가능 합니다.)</p>
			</div> -->	
		</div>

	</section>

	<jsp:include page="../include/footer.jsp" />	
	<button class="jellybutton topbtn" type="button" onclick="goTop()">TOP</button>
</body>
<script>
function pwdcheck(){	
	if(document.getElementById("userPasswordCurrent").value==""){
		alert("현재 사용중인 비밀번호를 입력해주세요.");
		return false;
	}
	if(document.getElementById("userPasswordNew").value==""){
		alert("변경하실 비밀번호를 입력해주세요.");
		return false;
	}
	if(documnet.getElementById("userPasswordNewConfirm").value==""){
		alert("비밀번호 확인을 입력해주세요.");
		return false;
	}
	if(document.getElementById("userPasswordNew").value != document.getElementById("userPasswordNewConfirm").value){
		alert("변경하실 비밀번호가 일치하지 않습니다.");
		return false;
	}
	
	
	/* if(document.getElementById("userPasswordCurrent").value != document.getElementById("userPasswordCurrentChk").value){
		alert("현재 비밀번호가 틀립니다.");
		return false;
	}	
	if(document.getElementById("userPasswordNew").value == document.getElementById("userPasswordCurrentChk").value){
		alert("변경할 비밀번호와 기존 비밀번호가 같습니다.");
		return false;
	}
	else{
		alert("변경완료 되었습니다.");
	} */
}
</script>
</html>