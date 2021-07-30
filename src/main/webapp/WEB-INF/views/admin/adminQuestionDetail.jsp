<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../resources/css/style.css">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="../../resources/script/script.js" defer></script>
<title>QnA 상세 보기</title>
</head>
<body>
	<jsp:include page="../admin-include/adminHeader.jsp"></jsp:include>
	<jsp:include page="../admin-include/adminNav.jsp"></jsp:include>
	<div class="adminWrap">
		<div class="left">
			<div>
				<p class="adminTitle">Q&A 관리</p>
			</div>
			<div>
				<p>Q&A 관리</p>
			</div>
		</div>

		<span class="line"></span>

		<div class="right">
				<div class="wrapContents">
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
					<a href="<c:url value='/admin/adminQuestionPage'/>">
						<button class="btn btn-swap"> more <span>전체 글 보기 >></span> </button>
					</a>
				</div>
			</div>
		</div>
</body>
</html>