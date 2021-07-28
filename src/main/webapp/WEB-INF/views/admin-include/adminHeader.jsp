<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="headerAdmin">
	<p> <img src="<spring:url value='/resources/img/img-include/로고.png'/>" alt="로고"> 수원시 분실동물 찾기 서비스 관리자 페이지</p>
	<p> <a href="<c:url value='/admin/logout'/>"><br><br>로그아웃</a>
</div>