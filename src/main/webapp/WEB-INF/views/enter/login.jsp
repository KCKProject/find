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
<title>로그인</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<section class="sectionLogin">
		<div class="loginInner">
			<h3 class="loginTitle"><!-- 로그인 --></h3>
			<div class="loginBox">
				<form:form commandName="memberLoginCommand">
					<form:input path="userId" placeholder="아이디" />
					<form:password path="userPassword" placeholder="비밀번호" />
					<input type="submit" value="로그인" class="loginBoxbtn">
				</form:form>
			</div>
			<div class="loginBoxLower">
				<p>
					<a href="<c:url value='/enter/signUp'/>">아직 회원이 아니신가요?</a>
				</p>
			</div>
		</div>
	</section>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>