<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/style.css">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="../resources/script/script.js" defer></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>QnA 작성 페이지</title>
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
				<ul>
					<a href="<c:url value='/admin/adminQuestionPage'/>"><li>Q&A 관리</li></a>
				</ul>
			</div>
		</div>
		<span class="line"></span>
		
		<div class="right">
			<div>
				<p> Q&A 등록 페이지</p>
			</div>
			<div class="wrapWritePage">
				<form:form commandName="qnAWriteCommand" enctype="multipart/form=data" method="POST">
					<table>
						<tr>
							<td><span>*</span>글제목</td>
							<td><form:input path="title" placeholder="글제목"/></td>
						</tr>
						<tr>
							<td><span>*</span>작성자</td>
							<td><form:input path="writer" placeholder="작성자"/></td>
						</tr>
						<tr>
							<td><span>*</span>내용</td>
							<td><form:input path="contents" placeholder="내용"/></td>
						</tr>
						<tr  class="qnaOpen">
							<td><span>*</span>공개여부</td>
							<td>
								<form:select path="open">
									<form:option value="1" label="공개"/>
									<form:option value="0" label="비공개"/>
								</form:select>
							</td>
						</tr>
					</table>
					<div>
						<input type="submit" value="작성완료" class="completeBtn">
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>