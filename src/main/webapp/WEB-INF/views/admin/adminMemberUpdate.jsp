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
				<p class="adminTitle">회원 관리</p>
			</div>
			<div>
				<ul>
					<a href="<c:url value='/admin/adminMember'/>"><li>회원관리</li></a>
				</ul>
			</div>
		</div>

		<span class="line"></span>

		<div class="right">
			<div>
				<p>회원 정보 수정</p>
			</div>
				<div class="wrapEditMemberPage"><!-- clsaa="wrapwritepage" -->
					<table>
						<div>
							<p>수정 전 정보</p>
						</div>
						<tr>
							<td><span>*</span>회원 이름</td>
							<td><input type="text" placeholder="${member.userName}" readonly></td>
						</tr>
						<tr>
							<td><span>*</span>전화번호</td>
							<td><input type="text" placeholder="${member.phone}" readonly></td>
						</tr>
						<tr>
							<td><span>*</span>이메일</td>
							<td><input type="text" placeholder="${member.email}" readonly></td>
						</tr>
					</table>
					<br>
					<br>
					<br>

					<form:form commandName="memberUpdateCommand" enctype="multipart/form=data" method="POST">
						<table>
							<div>
								<p>수정할 내용</p>
							</div>
							<tr>
								<td><span>*</span>회원 이름</td>
								<td><form:input path="userName" placeholder="수정할 이름"/></td>
							</tr>
							<tr>
								<td><span>*</span>전화번호</td>
								<td><form:input path="phone" placeholder="수정할 전화번호"/></td>
							</tr>
							<tr>
								<td><span>*</span>이메일</td>
								<td><form:input path="email" placeholder="수정할 이메일"/></td>
							</tr>
						</table>
					<br>
					<div class="adminBoardDetailBtn">
						<a href="<c:url value='/admin/adminMember'/>">
							<input type="button" class="btn btn-swap" value=" MORE"/> 
						</a>
							<button class="btn btn-swap" type="submit">EDIT</button>
					</div>
					</form:form>
				</div>
			</div>
		</div>