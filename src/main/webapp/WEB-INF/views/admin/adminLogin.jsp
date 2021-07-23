<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지_로그인</title>
</head>
<header>
	<h2> <img src="" alt=""> 수원시 분실동물 찾기 서비스 관리자 페이지</h2>
</header>
<body>
    <h2>관리자 로그인</h2>
    <div class="wrap">
        <div class="login">
        	<form:form commandName="adminLoginCommand">
            <div class="admin_id">
                <form:input path="adminId"/>     
            </div>
            <div class="admin_pwd">
                <form:password path="adminPassword"/>
            </div>
            <div class="admin_submit">
                <input type="submit" value="로그인"/>
            </div>
            </form:form>
        </div>
    </div>
</body>
</html>