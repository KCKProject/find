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
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script src="../resources/script/script.js" defer></script>
<title>찾아가세요</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />

	<div class="wrapboardPage">

		<div id="contentsTitle">
			<div>
				<h3 class="contentsTitle">찾아가세요</h3>
				<div class="titleLine"></div>
			</div>
			<div id="contentsMenu">
				<p style="cursor: pointer">
					 <c:if test="${empty cri.keyword}"> 
						<span id="find"><i class="far fa-square"></i>발견 완료</span>  
						<span id="hide"><i class="far fa-square"></i>미발견</span>
					 </c:if>
					 <c:if test="${cri.keyword == 1}"> 
						<span id="find"><i class="far fa-check-square"></i>발견 완료</span>  
						<span id="hide"><i class="far fa-square"></i>미발견</span>
					 </c:if>
					 <c:if test="${cri.keyword == 0 && !empty cri.keyword}"> 
						<span id="find"><i class="far fa-square"></i>발견 완료</span>  
						<span id="hide"><i class="far fa-check-square"></i>미발견</span>
					 </c:if>
				</p>
			</div>
		</div>

		<div class="wrapBoardlist"> 
		<!-- 게시글이 존재하지 않을 때 -->
		<c:if test="${empty finds}">
			<ul>
				<li>발견된 동물이 없습니다!</li>
			</ul>
		</c:if>
		<!-- 게시글이 1개 이상 존재할 때 -->
		<ul>
			 <!-- 게시물 li로 나열  -->
			<c:forEach var="f" items="${finds}">
				<li><a href="<c:url value="/findPage/findPageDetail/${f.boardNum}"/>">
					<div class="post-photo-top"> <!-- 게시글 사진 나오는 부분 --> 
						<div class="img_box">
							<img src="../resources/imgUpload/${f.storedFileName}"/>
						</div>
					</div>
					<div class="post-contents-bottom"> <!-- 게시글 내용 나오는 부분 -->
						<!-- 작성자가 본인 글에서 발견 버튼 클릭 시에만 생성 -->
						<c:if test="${f.meet==1}">
							<div>
								<p class="finishText">발견완료</p>
							</div>
						</c:if>
						<c:if test="${f.meet!=1}">
							<div><p><br><p></div>
						</c:if>
						<div>
							<p>동물 종류 : ${f.kind}</P>
						</div>
						<div>
							<p>성별 : ${f.gender}</P>
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
		<div class="paging">
			 <ul>
				<c:if test="${pageMaker.prev}">
			   		<li><a href="${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
			  	</c:if>
			  	<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
			   		<li><a href="${pageMaker.makeQuery(idx)}">${idx}</a></li>
			  	</c:forEach>
			  	<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			   		<li><a href="${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
			  	</c:if> 
			 </ul>
		</div>
	</div>
	<jsp:include page="../include/footer.jsp" />
	
	<button class="jellybutton topbtn" type="button" onclick="goTop()">TOP</button>

	<c:if test="${memberAuthInfo == null }">
		<div class="centerbtn">		
			<div class="jellybutton centerHiddenContents" name="centerHidden" id="centerHidden"><p>INFO<br>! 로그인 후 글쓰기 가능 합니다.<br>! 아이디 | 비밀번호 분실 시 로그인<br>페이지 하단의 찾기 버튼 클릭</p></div>
			<button class="jellybutton sidebtn1" name="write" id="write" >WRITE</button>
		</div>
	</c:if>
	<c:if test="${memberAuthInfo != null }">	
		<button class="jellybutton sidebtn1" name="write" id="write" onclick="location='<c:url value="/findPage/findPageWrite"/>'">WRITE</button>
	</c:if>
<script>	
	$(function(){
	  	$('#find').click(function() {
	  		self.location = "" + '${pageMaker.makeSearch(1)}' + encodeURIComponent(1);
		});
	  	
	  	$('#hide').click(function() {
  			self.location = "" + '${pageMaker.makeSearch(1)}' + encodeURIComponent(0);
		});
	});
</script>
</body>
</html>
