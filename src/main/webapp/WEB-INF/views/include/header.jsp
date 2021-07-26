<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<header>
	<div class="headerInner">
		<div class="mainTitle">
			<img alt="로고" src="resources/img/img-include/로고.png" height="50px" width="50px">
			<p>수원시 분실동물 찾기 서비스</p>
		</div>
		<div class="enter">
			<p>
				<!-- 로그인 시 로그아웃으로 변경되도록 기능 설정시 수정 -->
				<a href="<c:url value='/enter/login'/>">로그인</a> <a>|</a> <a
					href="<c:url value='/enter/signUp'/>">회원가입</a>
			</p>
		</div>
	</div>
</header>