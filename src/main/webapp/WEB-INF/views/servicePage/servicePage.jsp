<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/style.css">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="../resources/script/script.js" defer></script>
<title>::servicePage::</title>
</head>
<body id="bodyServicePate">

	<div class="wrapServicePage">
		<header>
			<div class="headerTop">
				<div class="enter">
					<p>
						<!-- 로그인 시 로그아웃으로 변경되도록 기능 설정시 수정 -->
						<c:if test="${memberAuthInfo == null }">
							<a href="<c:url value='/enter/login'/>">로그인</a>
							<a>|</a>
							<a href="<c:url value='/enter/signUp'/>">회원가입</a>
						</c:if>
						<c:if test="${memberAuthInfo != null }">
							${memberAuthInfo.getUserName()}님 환영합니다.
							<a href="<c:url value='/enter/logout'/>">로그아웃</a>
						</c:if>
					</p>
				</div> 
			</div>
			<div class="headerbottom">
				<div class="mainTitle">
					<i class="fab fa-accusoft"></i>	
					<p><a href="<c:url value='/'/>">수원시 분실동물 찾기 서비스</a></p>
				</div>
			</div>
		</header>
	</div>
	<section class="sectionServicePage">
		<div>
			<h3>C K C</h3>
			<P><i class="fab fa-accusoft"></i><P>
			<P>KOREA CODING KING</P>
		</div>
		<div class="serviceIntroduce">
			<h3>서비스 소개</h3>
			<p>
			최근 애견·애묘 등 반려동물과 함께하는 인구가 증가하고 있다. <BR>
			국내 반려인구는 2015년에 이미 1,000만 시대에 진입했고 올해는 1500만 명을 넘어섰다. <BR>
			이는 국민 서너 명 중 한명 꼴로 가정에서 반려동물을 기르고 있는 셈이다.  <BR>
			이러한 흐름에 발맞춰 최근에는 반려동물 관련 서비스 산업 또한 고급화와 다양화 되고 있다. <BR>
			최근에는 수가 늘어난 반려인들은 연결해 반려동물 분실 시 정보를 공유해 도움을 요청할 수 있는 여러 앱, 웹 서비스들이 등장 하였다.<BR>
			하지만 사이트 별 상이한 카테고리와 광범위한 지역 설정으로 인해 상용화에 어려움을 겪고 있다. <BR>
			이에 해당 서비스를 진행하는 바, 수원 내 분실동물만을 다루어 사용자 접근성은 높이고 ui는 직관적으로 하여 사용성을 높임.
			</p>
		</div>
		<div class="alliance">
			<h3>제휴문의</h3>
			<p>
			The Lorm alphabet is a method of tactile signing named after Hieronymus Lorm, <BR>
			who developed it in the late 19th century. Letters are spelled by tapping or stroking <BR>
			different parts of the listener's hand.[1] The Lorm alphabet is mostly used in German-speaking countries, <BR>
			the Netherlands, Czech Republic, Poland and Georgia.
			</p>
		</div>
		<div class="serviceCenter">
			<h3>고객센터</h3>
			<p>
			The Lorm alphabet is a method of tactile signing named after Hieronymus Lorm, <BR>
			who developed it in the late 19th century. Letters are spelled by tapping or stroking <BR>
			different parts of the listener's hand.[1] The Lorm alphabet is mostly used in German-speaking countries, <BR>
			the Netherlands, Czech Republic, Poland and Georgia.
			</p>
		</div>
		<div class="notice">
			<h3>공지사항</h3>
			<p>
			The Lorm alphabet is a method of tactile signing named after Hieronymus Lorm, <BR>
			who developed it in the late 19th century. Letters are spelled by tapping or stroking <BR>
			different parts of the listener's hand.[1] The Lorm alphabet is mostly used in German-speaking countries, <BR>
			the Netherlands, Czech Republic, Poland and Georgia.
			</p>
		</div>
	
	
	</section>
	<div class="btnServicePage">
		<div class="sidebtn0" type="button" onclick="goTop()">TOP</div>
		<div class="sidebtn3" onclick="window.scrollTo(3500,3500);">공지사항</div>
		<!-- sidebtn1,2는 qna페이지에서 설명글로 씀 -->
		<div class="sidebtn4" onclick="window.scrollTo(2500,2500);">고객센터</div>
		<div class="sidebtn5" onclick="window.scrollTo(1700,1700);">제휴문의</div>
		<div class="sidebtn6" onclick="window.scrollTo(850,850);">서비스소개</div>
	</div>
</body>
</html>