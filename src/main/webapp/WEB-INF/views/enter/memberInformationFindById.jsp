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
<title>아이디 찾기</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<section class="sectionLogin">
		<div class="wrap-memberInformationFind">
			<h3 class="loginTitle"><!-- 로그인 --></h3>
			<div class="loginBox memberInformationFindBox" >
				<form:form commandName="member" enctype="multipart/form=data" method="POST">
					<form:input path="phone" placeholder="전화번호" value="" />
					<form:input path="email" placeholder="이메일주소" value="" />
					<input type="submit" value="찾기" class="loginBoxbtn">
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
</html>
