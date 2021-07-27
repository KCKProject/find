<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				onclick="location='lostPageWrite'" value="글쓰기 >>">
		</div>

		<div class="wrap-lostPage"> 
			<ul>
				<li> <!-- 여러개있을거라 우선 li태그로 했어요  -->
					<div class="post-photo-top"> <!-- 게시글 사진 나오는 부분 -->
						<div>사진</div>
					</div>
					<div class="post-contents-bottom"> <!-- 게시글 내용 나오는 부분 -->
						<div>
							<p>이름 : 마루 | 성별 : 남</P>
						</div>
						<div>
							<p>잃어버린 위치 : 경기대학교 후문 사거리 근처</p>
						</div>
						<div>
							<p>특징 : 사람 잘 따라요. 오른쪽 다리 만지면 싫어함</p>
						</div>
						<div>
							<p>사례금 100만원</p>
						</div>
					</div>
				</li>
			</ul>
			
		</div>
		<div class="page"> <!-- 페이징 작업 예정 -->
		</div>

	</div>
	<jsp:include page="../include/footer.jsp" />
</body>
</html>
