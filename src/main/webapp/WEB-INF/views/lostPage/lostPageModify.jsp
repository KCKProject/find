<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../resources/css/style.css">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="../resources/script/script.js" defer></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>찾아주세요 수정하기</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />

	<div class="wrapboardPage">

		<div id="contentsTitle">
			<h3 class="contentsTitle">찾아주세요</h3>
			<div class="titleLine"></div>
		</div>
		
		<div class="wrapWritePage"> 
		<%--  enctype="multipart/form-data" 필요 --%>
			<form:form action="/lostPage/lostPageWrite" commandName="lostBoard" enctype="multipart/form-data" method="POST">
				<table id="input-lostPageWrite"> <!-- 입력칸 부분 -->
					<tr>
						<td><span>*</span>글제목</td>
						<td><form:input path="title" value="${detail.title}"/></td>
					</tr>
					<tr>
						<td><span style="color: white;">*</span>동물이름</td>
						<td><form:input path="animal" value="${detail.animal}"/></td>
					</tr>
					<tr>
						<td><span style="color: white;">*</span>품종</td>
						<td><form:input path="kind" value="${detail.kind}"/></td>
					</tr>
					<tr>
						<td><span>*</span>성별</td>
						<td><form:input path="gender" value="${detail.gender}"/></td>
					</tr>
					<tr>
						<td><span>*</span>실종위치</td>
						<td><form:input path="location" value="${detail.location}"/></td>
					</tr>
					<tr>
						<td><span>*</span>실종시각</td>
						<td><form:input path="lostDate" value="${detail.lostDate}"/></td>
					</tr>
					<tr>  
						<td><span>*</span>특징</td>
						<td><form:input path="character" value="${detail.character}"/></td>
					</tr>
					<tr>
						<td><span>*</span>연락처</td>
						<td><form:input path="memo" value="${detail.phone}"/></td>
					</tr>
					<tr>
						<td><span>*</span>이메일</td>
						<td><form:input path="memo" value="${detail.email}"/></td>
					</tr>
					<tr>
						<td><span>*</span>상세내용</td>
						<td><textarea name="memo" rows="10" cols="65">${detail.memo}</textarea></td>
					</tr>
					<tr>
						<td>  사진첨부</td>
						<td><input type="file" name="img" id="img" value="${detail.originalFile}"/></td>
					</tr>
				</table>
				
				<div > <!-- 수정완료 버튼 -->
					<input type="submit" value="수정완료" class="completeBtn">
				</div>
			</form:form>
		</div>
	</div>
	
	<jsp:include page="../include/footer.jsp" />
	
	<button class="jellybutton topbtn" type="button" onclick="goTop()">TOP</button>
		<!-- Service Center 버튼 -->
		<!-- 내용 미정 -->
	<div class="centerbtn">		
		<div class="jellybutton centerHiddenContents guideHiddenContents" name="centerHidden" id="centerHidden"><p>GUIDE<BR>1. '*'는 필수 입력 사항 입니다.<br>2. 실종 위치 및 시각은 최대한 <BR>구체적으로 적어주세요.<br>ex) 15시 20분경 경기대 후문<br>3. 내용은 자유롭게 기재 하되, <BR>최대한 많은 내용을 기재 해 주셔야 발견 될 확률이 높습니다.</p></div>
		<button class="jellybutton sidebtn1" name="center" id="center">GUIDE</button>
	</div>
</body>
</html>