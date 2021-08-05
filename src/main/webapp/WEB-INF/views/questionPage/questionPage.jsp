<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/css/style.css">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="../resources/script/script.js" defer></script>
<title>Q&A 게시판</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />

	<div class="wrapQuestionPage">
		<div class="qaBx">
			<c:if test="${empty questions}">
				<ul>
					<li>등록된 QnA가 없습니다.</li>
				</ul>
			</c:if>
			<c:if test="${!empty questions}">
				<table>
				<!-- q&a 데이터 많지 않아서 jsp 에서 애초에 저 데이터까지 받아와놓고 css로 안보이게해놧다가 보여주게 해도 될듯 합니당 -->
					<tr class="qaBxListTitle">
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th style="color: white;">상세보기</th>
					</tr>
					<c:forEach var="q" items="${questions}">

						<c:if test="${q.open==1}">
							<tr>
								<td>${q.boardNum}</td>
								<td>${q.title}</td>
								<td>${q.writer}</td>
								<td><fmt:formatDate value="${q.writeDate}"
										pattern="yyyy-MM-dd" /></td>
								<td>
									<a class="dnBtnQa"><i class="fas fa-angle-double-down"></i></a>
									<a class="upBtnQa"><i class="fas fa-angle-up"></i></a>
								</td>
							</tr>
							<tr class="qacontentsBx">
								<td colspan="5" class="qacontents" style="text-align: left; padding: 20px 150px;'">${q.contents}</td>
							</tr>
						</c:if>

					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>

	<jsp:include page="../include/footer.jsp" />
	<button class="jellybutton topbtn" type="button" onclick="goTop()">TOP</button>
		<!-- Service Center 버튼 -->
		<!-- 내용 미정 -->
	<div class="centerbtn">		
		<div class="jellybutton centerHiddenContents" name="centerHidden" id="centerHidden"><p>Service Center<br>! 아이디와 비밀번호 분실 시<br>! 작성자와 직접 컨택 원할 시<br> ! 사이트 이용 안내 필요 시</p></div>
		<button class="jellybutton sidebtn1" name="center" id="center" onclick="location='<c:url value="주소"/>'">CENTER</button>
	</div>
</body>
</html>
