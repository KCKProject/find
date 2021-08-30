<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../resources/css/style.css">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="../../resources/script/script.js" defer></script>
<title>QnA 수정 페이지</title>
</head>
<body>
	<jsp:include page="../admin-include/adminHeader.jsp"></jsp:include>
	<jsp:include page="../admin-include/adminNav.jsp"></jsp:include>
	<div class="adminWrap">
		<div class="left">
			<div>
				<p class="adminTitle">Q&A 관리</p>
			</div>
			<ul>
					<a href="<c:url value='/admin/adminQuestionPage'/>"><li>Q&A 관리</li></a>
			</ul>
		</div>

		<span class="line"></span>

		<div class="right">
			<div>
				<p> Q&A 수정 페이지</p>
			</div>
				<div class="wrapWritePage">
					<form:form commandName="qnAWriteCommand" enctype="multipart/form=data" method="POST">
					<table>
						<tr>
							<td><span>*</span>글제목</td>
							<td><form:input path="title" value="${qnABoard.title}"/></td>
						</tr>
						<tr>
							<td><span>*</span>작성자</td>
							<td><form:input path="writer" value="${qnABoard.writer}"/></td>
						</tr>
						<tr>
							<td><span>*</span>내용</td>
							<td><textarea name="contents" id="contents" rows="20" cols="70">${qnABoard.contents}</textarea></td>
						</tr>
						<tr>
							<td><span>*</span>공개여부</td>
							<td>
								<form:select path="open">
									<form:option value="1" label="공개"/>
									<form:option value="0" label="비공개"/>
								</form:select>
							</td>
						</tr>
					</table>
					<br>
					<div class="adminBoardDetailBtn">
						<a href="<c:url value='/admin/adminQuestionPage'/>">
							<input type="button" class="btn btn-swap" value="MORE"/>
						</a>
							<input class="btn btn-swap" type="submit" value="EDIT">
					</div>
					</form:form>
				</div>
			</div>
		</div>