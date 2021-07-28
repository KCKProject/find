<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findPage</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<jsp:include page="../include/nav.jsp" />

	<div class="wrap-all-findPage">

		<div class="write-btn">
			<!-- 글쓰기 버튼 -->
			<input type="button" name="write" id="write"
				onclick="location='findPageWrite'" value="글쓰기>>">
		</div>

		<div class="wrap-findPage"> 
			
			<li> <!-- 여러개있을거라 우선 li태그로 했어요  -->
				<div class="post-photo-top"> <!-- 게시글 사진 나오는 부분 --> 
					<div>사진</div>
				</div>
				<div class="post-contents-bottom"> <!-- 게시글 내용 나오는 부분 -->
					<div>
						<p>이름 : 마루 | 성별 : 남</P>
					</div>
					<div>
						<p>발견 위치 : 경기대학교 후문 사거리</p>
					</div>
					<div>
						<p>발견 시각 : 07-19 15:30</p>
					</div>
					<div>
						<p>특징 : 어쩌구 저쩌구</p>
					</div>
				</div> 
			</li>
			
		</div>
		<div class="page"> <!-- 페이징 작업 예정 -->
		</div>

	</div>

	<jsp:include page="../include/footer.jsp" />
</body>
</html>
