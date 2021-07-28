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
	                    <a><img src="resources/img/banner01.png"></a>
	                </div>
	            </li>
	            <li class="slideitem">
	                <div>
	                    <label for="slide01" class="left"></label>
	                    <label for="slide03" class="right"></label>
	                    <a><img src="resources/img/banner02.png"></a>
	                </div>
	            </li>
	            <li class="slideitem">
	                <div>
	                    <label for="slide02" class="left"></label>
	                    <label for="slide04" class="right"></label>
	                    <a><img src="resources/img/banner03.png"></a>
	                </div>
	            </li>
	            <li class="slideitem">
	                <div>
	                    <label for="slide03" class="left"></label>
	                    <label for="slide01" class="right"></label>
	                    <a><img src="resources/img/banner04.png"></a>
	                </div>
	            </li>
	        </ul>
	    </div>
			
		<!-- 		
		<div class="banner">
			<a href="#mainReview">
				<img alt="배너" src="resources/img/banner.png" />
			</a>
		</div> -->
		
		
		<div class="mainContentsWrap">
		<div class="mainLost">
			<p>다시 가족의 품으로 돌아갈 수 있도록 수원 시민 여러분의 도움이 필요합니다.</p>
			<div class="mainLostImg">
				<!-- 게시판 글 끌어오기 -->
				<ul>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex01.png" alt="ex01">
							<span class="mainLostImgLiContents"><p>마우스 올리면 해당 게시물의 내용이 나오도록 내용 불러오기 크기는 추후 조정 해야 할 것 같아요 지금은 좀 작은거같은데 보고 의견 얘기 해 주세용</p></span>
						</button>
					</li>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex02.png" alt="ex02">
							<span class="mainLostImgLiContents"><p>마우스 올리면 해당 게시물의 내용이 나오도록 내용 불러오기 크기는 추후 조정 해야 할 것 같아요 지금은 좀 작은거같은데 보고 의견 얘기 해 주세용</p></span>
						</button>
					</li>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex03.png" alt="ex03">
							<span class="mainLostImgLiContents"><p>마우스 올리면 해당 게시물의 내용이 나오도록 내용 불러오기 크기는 추후 조정 해야 할 것 같아요 지금은 좀 작은거같은데 보고 의견 얘기 해 주세용</p></span>
						</button>
					</li>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex04.png" alt="ex04">
							<span class="mainLostImgLiContents"><p>마우스 올리면 해당 게시물의 내용이 나오도록 내용 불러오기 크기는 추후 조정 해야 할 것 같아요 지금은 좀 작은거같은데 보고 의견 얘기 해 주세용</p></span>
						</button>
					</li>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex05.png" alt="ex05">
							<span class="mainLostImgLiContents"><p>마우스 올리면 해당 게시물의 내용이 나오도록 내용 불러오기 크기는 추후 조정 해야 할 것 같아요 지금은 좀 작은거같은데 보고 의견 얘기 해 주세용</p></span>
						</button>
					</li>

                </ul>
                <ul>
					<li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex06.png" alt="ex06">
							<span class="mainLostImgLiContents"><p>마우스 올리면 해당 게시물의 내용이 나오도록 내용 불러오기 크기는 추후 조정 해야 할 것 같아요 지금은 좀 작은거같은데 보고 의견 얘기 해 주세용</p></span>
						</button>
					</li>
					<li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex07.png" alt="ex07">
							<span class="mainLostImgLiContents"><p>마우스 올리면 해당 게시물의 내용이 나오도록 내용 불러오기 크기는 추후 조정 해야 할 것 같아요 지금은 좀 작은거같은데 보고 의견 얘기 해 주세용</p></span>
						</button>
					</li>
					<li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex08.png" alt="ex08">
							<span class="mainLostImgLiContents"><p>마우스 올리면 해당 게시물의 내용이 나오도록 내용 불러오기 크기는 추후 조정 해야 할 것 같아요 지금은 좀 작은거같은데 보고 의견 얘기 해 주세용</p></span>
						</button>
					</li>
					<li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex09.png" alt="ex09">
							<span class="mainLostImgLiContents"><p>마우스 올리면 해당 게시물의 내용이 나오도록 내용 불러오기 크기는 추후 조정 해야 할 것 같아요 지금은 좀 작은거같은데 보고 의견 얘기 해 주세용</p></span>
						</button>
					</li>
					<li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex10.png" alt="ex10">
							<span class="mainLostImgLiContents"><p>마우스 올리면 해당 게시물의 내용이 나오도록 내용 불러오기 크기는 추후 조정 해야 할 것 같아요 지금은 좀 작은거같은데 보고 의견 얘기 해 주세용</p></span>
						</button>
					</li>

				</ul>

                <div class="mainMore">
					<!-- 연결링크 재설정필요 -->
                    <button class="btn btn-swap" name="more" id="more" onclick="location='lostPage'">
                        more <span>찾아주세요 >></span>
                    </button>
                </div>

				<!-- <div class="mainLostMore">
					<input type="button" name="more" id="more"
						onclick="location='lostPage'" value="더보기 >>">
				</div> -->
			</div>
		</div>
		<div class="mainReview">
			<p>찾았어요! 후기</p>
			<div class="mainReviewImg">
				<ul>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex01.png" alt="ex01">
							<span class="mainLostImgLiContents"><p>마우스 올리면 해당 게시물의 내용이 나오도록 내용 불러오기 크기는 추후 조정 해야 할 것 같아요 지금은 좀 작은거같은데 보고 의견 얘기 해 주세용</p></span>
						</button>
					</li>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex02.png" alt="ex02">
							<span class="mainLostImgLiContents"><p>마우스 올리면 해당 게시물의 내용이 나오도록 내용 불러오기 크기는 추후 조정 해야 할 것 같아요 지금은 좀 작은거같은데 보고 의견 얘기 해 주세용</p></span>
						</button>
					</li>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex03.png" alt="ex03">
							<span class="mainLostImgLiContents"><p>마우스 올리면 해당 게시물의 내용이 나오도록 내용 불러오기 크기는 추후 조정 해야 할 것 같아요 지금은 좀 작은거같은데 보고 의견 얘기 해 주세용</p></span>
						</button>
					</li>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex04.png" alt="ex04">
							<span class="mainLostImgLiContents"><p>마우스 올리면 해당 게시물의 내용이 나오도록 내용 불러오기 크기는 추후 조정 해야 할 것 같아요 지금은 좀 작은거같은데 보고 의견 얘기 해 주세용</p></span>
						</button>
					</li>
                    <li>
						<button class="mainLostImgLi" name="more" id="more" onclick="location='lostPage'">
							<img src="./resources/img/eximg/ex05.png" alt="ex05">
							<span class="mainLostImgLiContents"><p>마우스 올리면 해당 게시물의 내용이 나오도록 내용 불러오기 크기는 추후 조정 해야 할 것 같아요 지금은 좀 작은거같은데 보고 의견 얘기 해 주세용</p></span>
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
</body>
</html>