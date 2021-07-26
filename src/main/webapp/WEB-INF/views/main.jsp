<%-- <%@ page session="false" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/style.css">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="resources/script/script.js" defer></script>

<title>FIND:분실동물 찾기 서비스</title>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	<%-- 	<jsp:include page="include/nav.jsp" /> header에 병합 --%>
	<main>
		<div class="banner">
			<img alt="배너" src="resources/img/banner.png" />
		</div>
		<div class="mainLost">
			<p>다시 가족의 품으로 돌아갈 수 있도록 수원 시민 여러분의 도움이 필요합니다.</p>
			<div class="mainLostImg">
				<!-- 게시판 글 끌어오기 -->
				<ul>
					<li>첫번째 게시글</li>
					<li>두번째 게시글</li>
					<li>세번째 게시글</li>
					<li>네번째 게시글</li>
					<li>다섯번째 게시글</li>
					<li>여섯번째 게시글</li>
					<li>일곱번째 게시글</li>
					<li>여덟번째 게시글</li>
					<li>아홉번째 게시글</li>
					<li>열번째 게시글</li>
				</ul>
				<div class="mainLostMore">
					<!-- 연결링크 재설정필요 -->
					<input type="button" name="more" id="more"
						onclick="location='lostPage'" value="더보기 >>">
				</div>
			</div>
		</div>
		<div class="mainReview">
			<p>찾았어요! 후기</p>
			<div class="mainReviewImg">
				<ul>
					<li>첫번째 게시글</li>
					<li>두번째 게시글</li>
					<li>세번째 게시글</li>
					<li>네번째 게시글</li>
					<li>다섯번째 게시글</li>
				</ul>
			</div>
		</div>
		<div class="admin">
			<a href="<c:url value='/admin'/>">관리자사이트</a>
		</div>
	</main>
	<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>