<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 상세 보기</title>
</head>
<body>
	<div class="wrap">
		<label>
			글제목 : ${qnABoard.title}
		</label>
		<br>
		<label>
			작성자 : ${qnABoard.writer}
		</label>
		<br>
		<label>
			작성일 : <fmt:formatDate value="${qnABoard.writeDate}" pattern="yyyy-MM-dd"/>
		</label>
		<br>
		<label>
			내용 : ${qnABoard.contents}
		</label>
		<br>
		<a href="<c:url value='/admin/adminQuestionPage'/>">전체 글 보기</a>
	</div>
</body>
</html>