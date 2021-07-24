<%-- <%@ page session="false" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FIND:분실동물 찾기 서비스</title>
</head>
<body>
<jsp:include page="include/header.jsp"></jsp:include>
<jsp:include page="include/nav.jsp"/>
<section>
	<div class="banner">
		<img src="${pageContext.request.contextPath}/resources/img/banner.jpg" />
	</div>
	<div class="mainLost">
		<p>
			다시 가족의 품으로 돌아갈 수 있도록 수원 시민 여러분의 도움이 필요합니다.
		</p>
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
				<input type="button" name="more" id="more" onclick="location='lostPage'" value="더보기 >>">
			</div>
		</div>
	</div>
	<div class="mainReview">
		<p>
			찾았어요! 후기
		</p>
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
	<div class="mainLink">
		<div class="mainLinkFirst">
			<a href="www.naver.com">동물 사이트 바로가기</a>
		</div>
		<div class="mainLinkSecond">
			<a href="www.naver.com">동물 저시기 사이트 바로가기</a>
		</div>
	</div>
</section>
<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>