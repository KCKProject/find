<%-- <%@ page session="false" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/style.css?">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="resources/script/script.js" defer></script>
<title>FIND:분실동물 찾기 서비스</title>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	<section class="section mainSection">
		
	    <div class="slidebox">
	        <input type="radio" name="slide" id="slide01" checked>
	        <input type="radio" name="slide" id="slide02">
	        <input type="radio" name="slide" id="slide03">
	        <input type="radio" name="slide" id="slide04">
	        <ul class="slidelist">
	            <li class="slideitem">
	                <div>
	                    <label for="slide04" class="left"></label>
	                    <label for="slide02" class="right"></label>
	                    <a href="https://www.peopet.co.kr/" target='_blank'><img src="resources/img/banner/banner05.png"></a>
	                </div>
	            </li>
	            <li class="slideitem">
	                <div>
	                    <label for="slide01" class="left"></label>
	                    <label for="slide03" class="right"></label>
	                    <a href="#"><img src="resources/img/banner/banner03.png"></a>
	                </div>
	            </li>
	            <li class="slideitem">
	                <div>
	                    <label for="slide02" class="left"></label>
	                    <label for="slide04" class="right"></label>
	                    <a><img src="resources/img/banner/banner01.png" onclick="window.scrollTo(1300,1300);"></a>
	                </div>
	            </li>
	            <li class="slideitem">
	                <div>
	                    <label for="slide03" class="left"></label>
	                    <label for="slide01" class="right"></label>
	                    <a><img src="resources/img/banner/banner07.png"></a>
	                </div>
	            </li>
	        </ul>
	    </div>
			
		 <!-- 		
		<div class="banner">
			<a href="#mainReview">
				<img alt="배너" src="resources/img/banner.png" />
			</a>
		</div>  -->
		
		
		<div class="mainContentsWrap">
		<div class="mainLost">
			<p>다시 가족의 품으로 돌아갈 수 있도록 수원 시민 여러분의 도움이 필요합니다.</p>
			<h3 class="contentsTitle">찾아주세요</h3>
			<div class="titleLine"></div>
			<div class="mainLostImg">
				<!-- 게시판 글 끌어오기 -->
				<div class="mainBoard">
					<ul>
						<c:forEach var="l" items="${losts}" begin="0" end="4" step="1">
							<li>
								<button class="mainLostImgLi" name="more" id="more" onclick="location='<c:url value="/lostPage/lostPageDetail/${l.boardNum}"/>'">
									<img src="./resources/imgUpload/${l.storedFileName}" alt="사진">
									<span class="mainLostImgLiContents">
										<p>
											<br>
											품종 | ${l.kind} <br> 실종장소 | ${l.location}
											<br> 실종시각 | ${l.lostDate}
											<br><br> 특징 | ${l.character}
										</p>
									</span>
								</button>
							</li>
						</c:forEach>
					</ul>
					<ul>
						<c:forEach var="l" items="${losts}" begin="5" end="9" step="1">
							<li>
								<button class="mainLostImgLi" name="more" id="more" onclick="location='<c:url value="/lostPage/lostPageDetail/${l.boardNum}"/>'">
									<img src="./resources/imgUpload/${l.storedFileName}" alt="사진">
									<span class="mainLostImgLiContents">
										<p>
											<br>
											품종 | ${l.kind} <br> 실종장소 | ${l.location}
											<br> 실종시각 | ${l.lostDate}<br><br> 특징 | ${l.character}
										</p>
									</span>
								</button>
							</a></li>
						</c:forEach>
					</ul>
				</div>
                <div class="mainMore">
                    <button class="btn btn-swap" name="more" id="more" onclick="location='<c:url value="/lostPage/lostPageList"/>'">
                        more <span>찾아주세요 >></span>
                    </button>
                </div>
			</div>
		</div>
		
		<div class="mainReview">
			<h3 class="contentsTitle">찾았어요! 후기</h3>
			<div class="titleLine"></div>
			<div class="mainReviewImg">
				<div class="mainBoard">
					<ul>
						<c:forEach var="r" items="${reviews}">
							<li>
								<button class="mainLostImgLi" name="more" id="more" onclick="location='<c:url value="/lostPage/lostPageDetail/${r.boardNum}"/>'">
									<img src="./resources/imgUpload/${r.storedFileName}" alt="사진">
									<span class="mainLostImgLiContents">
										<p>
											<br>
											이름 | ${r.animal} <br> 실종장소 | ${r.location}
											<br> 실종시각 | ${r.lostDate}<br><br> 후기 | ${r.review}
										</p>
									</span>
								</button>
							</li>
						</c:forEach>
					</ul>
				</div>
				
				<!-- 후기 게시판은 따로 없으니 버튼을 없앨까요? -->
				<%-- <div class="mainMore">
					<button class="btn btn-swap" name="more" id="more" onclick="location='<c:url value="/findPage/findPageList"/>'">
						more <span>찾아가세요 >></span>
					</button>
				</div> --%>
			</div>
		</div>
		</div>
	</section>
	<jsp:include page="include/footer.jsp"></jsp:include>
	<button class="jellybutton" type="button" onclick="goTop()">TOP</button>
</body>
</html>