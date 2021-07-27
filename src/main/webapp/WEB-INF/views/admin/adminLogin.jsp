<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/style.css">
<title>관리자페이지_로그인</title>
</head>

<body>
	<jsp:include page="../admin-include/adminHeaderBeforeLogin.jsp"/>
	<div class="adminLoginTitle">
		<h3>관리자 로그인</h3>
	</div>
	<div class="wrapAdminLogin">

		<div class="adminLogin_bx">
			<form:form commandName="adminLoginCommand">
				<div class="admin_id">
					<form:input path="adminId" placeholder="아이디" />
				</div>
				<div class="admin_pwd">
					<form:password path="adminPassword" placeholder="비밀번호"  />
				</div>
				<div class="admin_submit">
					<input type="submit" value="로그인" />
				</div>
			</form:form>
		</div>
	</div>
	
</body>
</html>