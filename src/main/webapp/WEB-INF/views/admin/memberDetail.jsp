<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 상세 보기</title>
</head>
<body>
	<div class="wrap">
		<label>
			아이디 : ${member.userId}
		</label>
		<br>
		<label>
			이름 : ${member.userName}
		</label>
		<br>
		<label>
			전화번호 : ${member.phone}
		</label>
		<br>
		<label>
			이메일 : ${member.email}
		</label>
		<br>
		<a href="<c:url value='/admin/adminMember'/>">전체 회원 보기</a>
	</div>
</body>
</html>