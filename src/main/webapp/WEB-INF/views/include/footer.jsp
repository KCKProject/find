<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<footer>
	<div class="site">
		<a href="https://www.animal.go.kr/front/awtis/protection/protectionList.do?menuNo=1000000060">동물보호관리시스템 (전국 보호 중 동물 보러가기)</a>
	</div>
	<div class="site">
		<a href="https://www.instagram.com/suwonacc/">수원시 동물 보호센터 인스타그램 바로가기 </a>
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
					<li>
						<a href="<spring:url value='/admin'/>">관리자페이지</a>
					</li>
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
				2021 KCK KOREA CODING KING<br><br>
				<i class="fab fa-accusoft"></i>		
				Always be<br> 
				with you
				<br><br> COPYRIGHT ©2021 KCK All Rights Reserved.©
			</p>
		</div>
	</div>
</footer>