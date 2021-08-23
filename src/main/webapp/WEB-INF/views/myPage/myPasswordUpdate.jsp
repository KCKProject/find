<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>마이페이지</title>
</head>
<body>

	<jsp:include page="../include/header.jsp" />

	<section class="myInfoUpdatePage myPage">
		<h1>비밀번호 수정</h1>
		

		<div class=myInfoDetail>
<%-- 			<div class="myInfoDetailContents">
				<div>
					<div>
						<p>아이디</p>
						<p>이름</p>
						<p>연락처</p>
						<p>이메일</p>
					</div>
				</div>
				<div>
					<div>
						<p>${memberAuthInfo.getUserId()}</p>
						<p>${memberAuthInfo.getUserName()}</p>
						<p>${memberAuthInfo.getPhone()}</p>
						<p>${memberAuthInfo.getEmail()}</p>
					</div>
				</div>
			</div> --%>
			
    		<div class="changePassword">
				<div class="changePasswordContents">
					<div>
						현재 비밀번호 <input type="text">
					</div>
					<div>
						변경 비밀번호 <input type="text">
					</div>
					<div>
						비밀번호 확인 <input type="text">
					</div>
					<div>
						<input type="submit" value="비밀번호 변경" class="changePasswordBtn">
					</div>
				</div>	
			</div> 
			
<%-- 	 		<div class="myInfoUpdate"> 
				<form:form commandName="myInfoUpdateCommand" enctype="multipart/form=data" method="POST">
					<table>
						<tr>
							<td><i class="fas fa-user myInfoUpdateIcon"></i>현재 비밀번호</td>
							<td><form:input path="userName" value=""  /></td>
						</tr>
						<tr>
							<td><i class="fas fa-mobile-alt myInfoUpdateIcon"></i>변경 비밀번호</td>
							<td><form:input path="phone" value=""  /></td>
						</tr>
						<tr>
							<td><i class="fas fa-mail-bulk myInfoUpdateIcon"></i>변경 비밀번호</td>
							<td><form:input path="email" value="" /></td>
						</tr>
					</table>

						<button class="btn btn-swap" type="submit"> EDIT <span>수정완료 >></span> </button>
				</form:form>			
			</div>  --%>
			
			<div class="myPasswordUpdatePageBtn">
				<a href="<c:url value='/myPage/myInfoUpdate/${memberAuthInfo.getMemberNumber()}'/>" class="changeInfoBtn"><span class="clickText">click</span><i class="fas fa-user-edit editIcon"></i>나의정보 변경</a>
				<a href="<c:url value='/myPage/myPage/${memberAuthInfo.getUserId()}'/>" class="changeInfoBtn"><i class="fas fa-user-alt editIcon"></i>마이페이지<span class="clickText">click</span></a>
			</div>

<!-- 		<div class="myInfoUpdateNotice">
				<h3>NOTICE</h3>
				<p><i class="fas fa-info"></i>아이디는 수정 불가 합니다.</p>
				<p><i class="fas fa-info"></i>연락처 오기재시 연결이 어려우니 필히 재확인 부탁드립니다.</p>
				<p><i class="fas fa-info"></i>이름은 자유롭게 기재 가능 합니다(실명이 아니어도 가능 합니다.)</p>
			</div> -->	
		</div>

	</section>

	<jsp:include page="../include/footer.jsp" />	
	<button class="jellybutton topbtn" type="button" onclick="goTop()">TOP</button>


</body>
</html>