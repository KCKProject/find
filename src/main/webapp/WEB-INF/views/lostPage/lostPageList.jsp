<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lostPage</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<jsp:include page="../include/nav.jsp" />

	<div class="wrap-all-lostPage">

		<div class="write-btn">
			<!-- 글쓰기 버튼 -->
			<input type="button" name="write" id="write"
				onclick="location='<c:url value="/lostPage/lostPageWrite"/>'" value="글쓰기 >>">
		</div>

		<div class="wrap-lostPage"> 
		<!-- 게시글이 존재하지 않을 때 -->
		<c:if test="${empty losts}">
			<ul>
				<li>실종된 동물이 없습니다!</li>
			</ul>
		</c:if>
		
		<!-- 게시글이 1개 이상 존재할 때 -->
		<ul>
			 <!-- 게시물 li로 나열  -->
			<c:forEach var="l" items="${losts}">
				<li>
					<div class="post-photo-top"> <!-- 게시글 사진 나오는 부분 -->
						<div><a href="<c:url value="/lostPage/lostPageDetail/${l.boardNum}"/>">사진</a></div>
					</div>
					<div class="post-contents-bottom"> <!-- 게시글 내용 나오는 부분 -->
						<!-- 작성자가 본인 글에서 발견 버튼 클릭 시에만 생성 -->
						<c:if test="${l.meet==1}">
							<div>
								<p>발견완료</p>
							</div>
						</c:if>
						<div>
							<p>이름 : ${l.animal} | 성별 : ${l.gender}</P>
						</div>
						<div>
							<p>잃어버린 위치 : ${l.location}</p>
						</div>
						<div>
							<p>특징 : ${l.character}</p>
						</div>
						<div>
							<p>사례금 100만원</p>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>		
		</div>
		<div class="page"> <!-- 페이징 작업 예정 -->
		</div>

	</div>
	<jsp:include page="../include/footer.jsp" />
</body>
</html>