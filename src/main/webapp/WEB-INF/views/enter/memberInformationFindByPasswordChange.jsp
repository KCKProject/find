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
			<div class="loginBox memberInformationFindBox memberInformationFindBox2">
				<form>
					<c:if test="${empty members}"> 
						<p><i class="fas fa-frown-open"></i>정보가 일치하지 않습니다.<i class="fas fa-frown-open"></i></p><br>
						<input type="button" value="로그인 화면으로 돌아가기 " onclick="location.href='./login'">
					</c:if>
					<c:forEach var="m" items="${members}">
						<p><strong style="color: #1ABC9C;">${m.userName}</strong>님 새로운 비밀번호로 변경 하시겠습니까? </p><br>
						<a href="<c:url value='/enter/memberInformationFindByPasswordChanges/${m.userId}'/>">
							<input type="button" value="비밀번호 변경" class="loginBoxbtn">
						</a>
					</c:forEach>
				</form>
			</div>

		</div>
	</section>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>
