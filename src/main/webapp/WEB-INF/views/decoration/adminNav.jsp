<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<ul>
	<li> <a href="<c:url value='/admin/adminBoard'/>">게시판 관리</a></li>
	<li> <a href="<c:url value='/admin/adminMember'/>">회원관리</a></li>
	<li> <a href="<c:url value='/admin/adminQuestionPage'/>">Q&A관리</a></li>
</ul>