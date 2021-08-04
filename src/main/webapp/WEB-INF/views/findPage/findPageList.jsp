<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/style.css">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="../resources/script/script.js" defer></script>
<title>찾아가세요</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />

	<div class="wrapboardPage">

		<%-- 하단에 있음
		<div class="write-btn">
			<!-- 글쓰기 버튼 -->
			<input type="button" name="write" id="write"
				onclick="location='<c:url value="/findPage/findPageWrite"/>'" value="글쓰기>>">
		</div> --%>

		<div id="contentsTitle">
			<h3 class="contentsTitle">찾아가세요</h3>
			<div class="titleLine"></div>
		</div>

		<div class="wrapBoardlist"> 
		<!-- 게시글이 존재하지 않을 때 -->
		<c:if test="${empty find}">
			<ul>
				<li>발견된 동물이 없습니다!</li>
			</ul>
		</c:if>
		
		<!-- 게시글이 1개 이상 존재할 때 -->
		<ul>
			 <!-- 게시물 li로 나열  -->
			<c:forEach var="f" items="${find}">
				<li><a href="<c:url value="/findPage/findPageDetail/${f.boardNum}"/>">
					<div class="post-photo-top"> <!-- 게시글 사진 나오는 부분 --> 
						<div>사진</div>
					</div>
					<div class="post-contents-bottom"> <!-- 게시글 내용 나오는 부분 -->
						<!-- 작성자가 본인 글에서 발견 버튼 클릭 시에만 생성 -->
						<c:if test="${f.meet==1}">
							<div>
								<p class="finishText">발견완료</p>
							</div>
						</c:if>
						<div>
							<p>동물 종류 : ${f.kind} | 성별 : ${f.gender}</P>
						</div>
						<div>
							<p>발견 위치 : ${f.location}</p>
						</div>
						<div>
							<p>발견 시각 : ${f.findDate}</p>
						</div>
						<div>
							<p>특징 : ${f.character}</p>
						</div>
					</div> 
				</a></li>
			</c:forEach>
		</ul>
		</div>
		<div class="page"> <!-- 페이징 작업 예정 -->
		</div>

	</div>

	<jsp:include page="../include/footer.jsp" />
	<button class="jellybutton topbtn" type="button" onclick="goTop()">TOP</button>
		<!-- 글쓰기 버튼 -->
		<!-- 예정) 로그인안한 회원은 로그인 페이지로 연결되도록 수정할 예정 -->
	<button class="jellybutton sidebtn1" name="write" id="write" onclick="location='<c:url value="/lostPage/lostPageWrite"/>'">WIRTE</button>
	
</body>
</html>
