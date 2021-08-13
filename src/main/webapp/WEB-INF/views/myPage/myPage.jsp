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

<title>마이페이지</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<section class="myPage">
	
		<h1>마이페이지</h1>
		
		<div class="wrapMyInfo">
			<div class="myInfo">	
				<div class="myGrade">
					<div>
						<i class="fas fa-dove"></i>
					</div>
					<div>
						<p>"강아지"님의 회원등급은 NEW 입니다.</p>
						<P>"강아지"님의 반려동물의 사진과 정보를 등록 해 주세요.</P>
						<a>등록 하러 가기 > </a>
					</div>
				</div>
				<div class="myActivities">
					<div class="myActivitiesTitle">
						<p>나의 활동</p>
					</div>
					<div class="wrapMyActivitiesContents">
						<div class="myActivitiesContents">
							<p>반려동물 정보<br>미등록</p>
							<p>내가 작성한 글<br>1개</p>
						</div>
						<div class="myActivitiesContents">
							<p>내가 작성한 리뷰<br>1개</p>
							<p>내가 작성한 댓글<br>1개</p>
						</div>
					</div>
				</div>	
			</div>
		</div>
		
		<h3>내가 작성한 글</h3>
		<div class="wrapMyPost">
			<div class="myPost">
				<div><p>1</p><p>8/27 수원시청역 근처에서 잃어버렸어요</p><p>2021-08-28</p></div>
				<div><p>2</p><p>8/27 수원시청역 근처에서 잃어버렸어요</p><p>2021-08-28</p></div>
				<div><p>3</p><p>8/27 수원시청역 근처에서 잃어버렸어요</p><p>2021-08-28</p></div>
			</div>
		</div>
	</section>
	<jsp:include page="../include/footer.jsp" />

</body>
</html>