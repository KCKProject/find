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
	<%-- 	<jsp:include page="include/nav.jsp" /> header에 병합 --%>
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
	                    <a href="https://www.peopet.co.kr/"><img src="resources/img/banner/banner05.png"></a>
	                </div>
	            </li>
	            <li class="slideitem">
	                <div>
	                    <label for="slide01" class="left"></label>
	                    <label for="slide03" class="right"></label>
	                    <a href="https://m.blog.naver.com/hm-0-z/222448908633"><img src="resources/img/banner/banner03.png"></a>
	                </div>
	            </li>
	            <li class="slideitem">
	                <div>
	                    <label for="slide02" class="left"></label>
	                    <label for="slide04" class="right"></label>
	                    <a><img src="resources/img/banner/banner01.png" onclick="window.scrollTo(1000,1000);"></a>
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
				<ul>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex01.png" alt="ex01">
							<span class="mainLostImgLiContents"><p>이름 | 강아지 <br> 실종장소 | 경기대후문근처 <br> 실종시각 | 2021-07-29 15시 <br><br> 특징 | 잘 웃고 오른쪽 발 만지면 싫어해요. 사례금 있어요 꼭 좀 찾아주세요</p></span>
						</button>
					</li>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex02.png" alt="ex02">
							<span class="mainLostImgLiContents"><p>이름 | 강아지 <br> 실종장소 | 경기대후문근처 <br> 실종시각 | 2021-07-29 15시 <br><br> 특징 | 잘 웃고 오른쪽 발 만지면 싫어해요. 사례금 있어요 꼭 좀 찾아주세요</p></span>
						</button>
					</li>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex03.png" alt="ex03">
							<span class="mainLostImgLiContents"><p>이름 | 강아지 <br> 실종장소 | 경기대후문근처 <br> 실종시각 | 2021-07-29 15시 <br><br> 특징 | 잘 웃고 오른쪽 발 만지면 싫어해요. 사례금 있어요 꼭 좀 찾아주세요</p></span>
						</button>
					</li>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex04.png" alt="ex04">
							<span class="mainLostImgLiContents"><p>이름 | 강아지 <br> 실종장소 | 경기대후문근처 <br> 실종시각 | 2021-07-29 15시 <br><br> 특징 | 잘 웃고 오른쪽 발 만지면 싫어해요. 사례금 있어요 꼭 좀 찾아주세요</p></span>
						</button>
					</li>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex05.png" alt="ex05">
							<span class="mainLostImgLiContents"><p>이름 | 강아지 <br> 실종장소 | 경기대후문근처 <br> 실종시각 | 2021-07-29 15시 <br><br> 특징 | 잘 웃고 오른쪽 발 만지면 싫어해요. 사례금 있어요 꼭 좀 찾아주세요</p></span>
						</button>
					</li>

                </ul>
                <ul>
					<li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex06.png" alt="ex06">
							<span class="mainLostImgLiContents"><p>이름 | 강아지 <br> 실종장소 | 경기대후문근처 <br> 실종시각 | 2021-07-29 15시 <br><br> 특징 | 잘 웃고 오른쪽 발 만지면 싫어해요. 사례금 있어요 꼭 좀 찾아주세요</p></span>
						</button>
					</li>
					<li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex07.png" alt="ex07">
							<span class="mainLostImgLiContents"><p>이름 | 강아지 <br> 실종장소 | 경기대후문근처 <br> 실종시각 | 2021-07-29 15시 <br><br> 특징 | 잘 웃고 오른쪽 발 만지면 싫어해요. 사례금 있어요 꼭 좀 찾아주세요</p></span>
						</button>
					</li>
					<li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex08.png" alt="ex08">
							<span class="mainLostImgLiContents"><p>이름 | 강아지 <br> 실종장소 | 경기대후문근처 <br> 실종시각 | 2021-07-29 15시 <br><br> 특징 | 잘 웃고 오른쪽 발 만지면 싫어해요. 사례금 있어요 꼭 좀 찾아주세요</p></span>
						</button>
					</li>
					<li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex09.png" alt="ex09">
							<span class="mainLostImgLiContents"><p>이름 | 강아지 <br> 실종장소 | 경기대후문근처 <br> 실종시각 | 2021-07-29 15시 <br><br> 특징 | 잘 웃고 오른쪽 발 만지면 싫어해요. 사례금 있어요 꼭 좀 찾아주세요</p></span>
						</button>
					</li>
					<li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex10.png" alt="ex10">
							<span class="mainLostImgLiContents"><p>이름 | 강아지 <br> 실종장소 | 경기대후문근처 <br> 실종시각 | 2021-07-29 15시 <br><br> 특징 | 잘 웃고 오른쪽 발 만지면 싫어해요. 사례금 있어요 꼭 좀 찾아주세요</p></span>
						</button>
					</li>

				</ul>

                <div class="mainMore">
					<!-- 연결링크 재설정필요 -->
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
				<ul>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex01.png" alt="ex01">
							<span class="mainLostImgLiContents"><p>이름 | 강아지 <br> 실종장소 | 경기대후문근처 <br> 실종시각 | 2021-07-29 15시 <br><br> 특징 | 잘 웃고 오른쪽 발 만지면 싫어해요. 사례금 있어요 꼭 좀 찾아주세요</p></span>
						</button>
					</li>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex02.png" alt="ex02">
							<span class="mainLostImgLiContents"><p>이름 | 강아지 <br> 실종장소 | 경기대후문근처 <br> 실종시각 | 2021-07-29 15시 <br><br> 특징 | 잘 웃고 오른쪽 발 만지면 싫어해요. 사례금 있어요 꼭 좀 찾아주세요</p></span>
						</button>
					</li>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex03.png" alt="ex03">
							<span class="mainLostImgLiContents"><p>이름 | 강아지 <br> 실종장소 | 경기대후문근처 <br> 실종시각 | 2021-07-29 15시 <br><br> 특징 | 잘 웃고 오른쪽 발 만지면 싫어해요. 사례금 있어요 꼭 좀 찾아주세요</p></span>
						</button>
					</li>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex04.png" alt="ex04">
							<span class="mainLostImgLiContents"><p>이름 | 강아지 <br> 실종장소 | 경기대후문근처 <br> 실종시각 | 2021-07-29 15시 <br><br> 특징 | 잘 웃고 오른쪽 발 만지면 싫어해요. 사례금 있어요 꼭 좀 찾아주세요</p></span>
						</button>
					</li>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex05.png" alt="ex05">
							<span class="mainLostImgLiContents"><p>이름 | 강아지 <br> 실종장소 | 경기대후문근처 <br> 실종시각 | 2021-07-29 15시 <br><br> 특징 | 잘 웃고 오른쪽 발 만지면 싫어해요. 사례금 있어요 꼭 좀 찾아주세요</p></span>
						</button>
					</li>
				</ul>

				<div class="mainMore">
					<!-- 연결링크 재설정필요 -->
					<button class="btn btn-swap" name="more" id="more"
						onclick="location='findPage'">
						more <span>찾아가세요 >></span>
					</button>
				</div>
			</div>
		</div>
		</div>
	</section>
	<jsp:include page="include/footer.jsp"></jsp:include>
	<button class="jellybutton" type="button" onclick="goTop()">TOP</button>
</body>
</html>