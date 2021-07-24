<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<footer>
	<div class="footerInner">
		<div class="footerUpper">
			<div class="footerMenu">
				<!-- 살릴 메뉴 정하기 -->
				<ul>
					<li>회사소개</li>
					<li>고객센터</li>
					<li>이용약관</li>
					<li>개인정보처리방침</li>
					<li>제휴문의</li>
					<li>공지사항</li>
					<li>작업가이드</li>
					<li>오려내기</li>
					<li>오프린트미 앱</li>
				</ul>
			</div>
			<div class="footerLink">
				<ul>
					<!-- 아이콘 변경 가능 -->
					<li><img src="<spring:url value='/resources/img/phone-call.png'/>"></li>
					<li><img src="<spring:url value='/resources/img/mail.png'/>" alt="메일주소"></li>
					<li><img src="<spring:url value='/resources/img/map.png'/>" alt="주소"></li>
				</ul>
			</div>
		</div>
		<div class="footerlower">
			<p>
				2021 KCK KOREA CODING KING<br>
				<img src="<spring:url value='/resources/img/hand.png'/>">
				Always be with you<br>
				COPYRIGHT ©2021 KCK All Rights Reserved.©
			</p>
		</div>
	</div>
</footer>