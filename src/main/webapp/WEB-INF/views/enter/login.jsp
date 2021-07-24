<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<form action="#" method="POST" name="loginForm">
					<input type="text" name="userId" id="userId" placeholder="아이디">
					<input type="password" name="userPwd" id="userPwd" placeholder="비밀번호">
					<input type="submit" value="로그인">
				</form>
			</div>
			<div class="loginBoxLower">
				<p>
					<a href="">아직 회원이 아니신가요?</a>
				</p>
			</div>
		</div>
	</section>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>