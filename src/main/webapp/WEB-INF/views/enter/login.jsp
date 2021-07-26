<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<header>
		<div class="headerInner">
			<div id="mainTitle">
				<img src="<spring:url value='/resources/img/hand.png'/>" />
				<p>수원시 분실동물 찾기 서비스</p>
			</div>
		</div>
	</header>
	<section>
		<div class="loginInner">
			<h3>로그인</h3>
			<div class="loginBox">
				<form:form commandName="memberLoginCommand">
					<form:input path="userId" placeholder="아이디" />
					<form:password path="userPassword" placeholder="비밀번호" />
					<input type="submit" value="로그인">
				</form:form>
			</div>
			<div class="loginBoxLower">
				<p>
					<a href="<c:url value='/enter/register'/>">아직 회원이 아니신가요?</a>
				</p>
			</div>
		</div>
	</section>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>