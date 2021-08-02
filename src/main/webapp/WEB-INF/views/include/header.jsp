<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
		<div class="search">
			<form action="#">
				<input type="text" path="search" placeholder="검색어를 입력해주세요" />
				<button>
					<i class="fas fa-search"></i>
				</button>
			</form>
		</div>
	</div>
	<div class="headerbottom">
		<div class="mainTitle">
			<i class="fab fa-accusoft"></i>	
			<p><a href="<c:url value='/'/>">수원시 분실동물 찾기 서비스</a></p>
		</div>
	</div>


	<nav>
		<div class="navInner">
			<div class="mainMenu">
				<ul>
					<!-- <li style="background-color: white;"> </li> -->
					<a href="<c:url value='/lostPage/lostPageList'/>"><li>찾아주세요</li></a>
                	<a href="<c:url value='/findPage/findPageList'/>"><li>찾아가세요</li></a>
					<a href="<c:url value='/questionPage/questionPage'/>"><li>Q&A</li></a>
				</ul>
			</div>
			<a href="#" class="navToggleBtn"> <i class="fas fa-bars"></i></a>
		</div>
	</nav>

</header>