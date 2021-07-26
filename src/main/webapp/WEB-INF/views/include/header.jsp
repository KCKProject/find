<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<header>
	<div class="headerInner">
		<div class="mainTitle">
			<img alt="로고" src="resources/img/img-include/로고.png" height="50px"
				width="50px">
			<p>수원시 분실동물 찾기 서비스</p>
		</div>
		<div class="enter">
			<p>
				<!-- 로그인 시 로그아웃으로 변경되도록 기능 설정시 수정 -->
				<a href="<c:url value='/enter/login'/>">로그인</a> <a>|</a> <a
					href="<c:url value='/enter/signUp'/>">회원가입</a>
			</p>
		</div>
	</div>


	<nav>
		<div class="navInner">
			<div class="mainMenu">
				<ul>
					<li> </li>
					<li>찾아주세요</li>
					<li>찾아가세요</li>
					<li>Q&A</li>
				</ul>
			</div>
			<div class="search">
				<form action="#">
					<input type="text" path="search" placeholder="검색어를 입력해주세요" />
					<button>
						<img src="resources/img/img-include/검색.png"
							style="width: 10px; background-color: white;">
					</button>
				</form>
			</div>
			<a href="#" class="navToggleBtn"> <i class="fas fa-bars"></i></a>
		</div>
	</nav>

</header>