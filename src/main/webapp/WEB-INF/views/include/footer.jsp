<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<ul>
					<li><a href="<spring:url value='/servicePage/servicePage'/>" target='_blank'>서비스소개</a></li>
					<li><a href="<spring:url value='/servicePage/servicePage'/>" target='_blank'>제휴문의</a></li>
					<li><a href="<spring:url value='/admin'/>">관리자페이지</a></li>
				</ul>
			</div>
			<div class="footerIcon">
				<ul>
					<li>
						<button class="copy-Phone">
							<i class="fas fa-phone-volume"></i>
							<span><BR>Phone. 010-3214-5324</span>
						</button>
					</li>
					<li>
						<button class="copy-email">
							<i class="fas fa-envelope"></i>
							<span><br>EMAIL. KCK0827@gmail.com</span>
						</button>
					</li>
					<li>
						<button class="copy-address">
							<i class="fas fa-map-marked-alt"></i>
							<span><br>ADDRESS. 경기도 수원시 팔달구 매산동 매산로 12-1</span>
						</button>
					</li>
				</ul>
			</div>
		</div>
		<div class="footerlower">
			<p>
				2021 KCK KOREA CODING KING<br><br>
				<i class="fab fa-accusoft"></i>		
				Always be<br> 
				with you
				<br><br> COPYRIGHT ©2021 KCK All Rights Reserved.
			</p>
		</div>
	</div>
</footer>