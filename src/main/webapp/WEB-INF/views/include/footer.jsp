<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<footer>
	<div class="site">
		<a href="www.naver.com">동물 어쩌구 저쩌구 사이트 바로가기 >>></a>
	</div>
	<div class="site">
		<a href="www.naver.com">동물 어쩌구 저쩌구 사이트 바로가기 >>></a>
	</div>
	<div class="footerInner">
		<div class="footerUpper">
			<div class="footerMenu">
				<!-- 살릴 메뉴 정하기 -ok-->
				<ul>
					<li>서비스소개</li>
					<li>제휴문의</li>
					<li>공지사항</li>
					<li>고객센터</li>
				</ul>
			</div>
			<div class="footerLink">
				<ul>
					<!-- 아이콘 변경 가능 -ok -->
					<li><img src="<spring:url value='/resources/img/img-include/phone-call.png'/>" alt="전화번호"></li>
					<li><img src="<spring:url value='/resources/img/img-include/mail.png'/>" alt="메일주소"></li>
					<li><img src="<spring:url value='/resources/img/img-include/map.png'/>" alt="주소"></li>
				</ul>
			</div>
		</div>
		<div class="footerlower">
			<p>
				2021 KCK KOREA CODING KING<br>
				<br> <img src="resources/img/img-include/로고.png" alt="로고" height="50px" width="40px">
				Always be<br> with you<br>
				<br> COPYRIGHT ©2021 KCK All Rights Reserved.©
			</p>
		</div>
	</div>
</footer>