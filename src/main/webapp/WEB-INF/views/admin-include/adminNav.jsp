<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav class="adminNav">
	<ul>
		<a href="<c:url value='/admin/adminBoard'/>"><li>게시판 관리</li></a>
		<a href="<c:url value='/admin/adminMember'/>"><li>회원관리</li></a>
		<a href="<c:url value='/admin/adminQuestionPage'/>"><li>QnA관리</li></a>
	</ul>
</nav>