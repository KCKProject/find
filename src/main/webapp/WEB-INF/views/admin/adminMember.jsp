<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/style.css">
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="resources/script/script.js" defer></script>
<title>관리자 페이지_회원관리</title>
</head>
<body>
	<jsp:include page="../admin-include/adminHeader.jsp"></jsp:include>
	<jsp:include page="../admin-include/adminNav.jsp"></jsp:include>
	<div class="adminWrap">
		<div class="left">
			<div>
				<p class="adminTitle">회원 관리</p>
			</div>
			<div>
				<ul>
					<a href="<c:url value='/admin/adminMember'/>"><li>회원관리</li></a>
				</ul>
			</div>
		</div>

		<span class="line"></span>

		<div class="right">
			<div>
				<p>
					회원 
					<%-- <c:forEach items="${members}" var="i" varStatus="status">
						<c:if test="${status.last}">
							${i.memberNumber}명
						</c:if>
					</c:forEach> --%>
					${pageMaker.totalCount}명
					<!-- 읽어서 받아올수 있게 만들기 -->
					<!-- <input type="text" name="search" id="search"
						placeholder="검색어를 입력해주세요"> <a href=""> <img
						src="../resources/img/search.png" alt="검색" width="15px"
						height="15px"></a> -->
						<input type="text" name="keyword" id="keywordInput" value="${scri.keyword}" placeholder="검색어를 입력해주세요"/>

 						<button id="searchBtn" onclick=""><img
						src="../resources/img/search.png" alt="검색" width="15px"
						height="15px"></button>
				</p>
			</div>
			<!-- <div>
				<input type="date" name="startDate" id="startDate"> ~ <input type="date" name="endDate" id="endDate"> 
				<label class="checkbox"><input type="checkbox" name="all" id="all"><span class="icon"></span><span class="text">전체</span></label>
				<label class="checkbox"><input type="checkbox" name="userDate" id="userDate"><span class="icon"></span><span class="text">기간</span></label> 
				<label class="checkbox"><input type="checkbox" name="done" id="done"><span class="icon"></span><span class="text">이름</span></label> 

			</div> -->
			<div>
				<table class="adminContents">
					<!-- <td></td> -->

					<c:if test="${!empty members}">
						<tr class="adminContentsListTitle">
							<td>번호</td>
							<td>이름</td>
							<td>아이디</td>
							<td>연락처</td>
							<td>이메일</td>
						</tr>
						<c:forEach var="m" items="${members}">
							<tr>
								<td>${m.memberNumber}</td>
								<td><a
									href="<c:url value="/admin/detail/${m.memberNumber}"/>">${m.userName}</a>
								</td>
								<td>${m.userId }</td>
								<td>${m.phone }</td>
								<td>${m.email }</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
				<div class="paging">
					 <ul>
  						<c:if test="${pageMaker.prev}">
					   		<li><a href="${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
					  	</c:if>
					  	<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
					   		<li><a href="${pageMaker.makeSearch(idx)}">${idx}</a></li>
					  	</c:forEach>
					  	<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					   		<li><a href="${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
					  	</c:if> 
					 </ul>
				</div>
			</div>
		</div>
	</div>

	<%-- 	<div class="wrap">
		<table border="1">
			<tr>
				<td rowspan="2">
					<h2>회원관리</h2>
				</td>
				<td>
					<p>회원 : 명</p>
				</td>
			</tr>
			<tr>
				<td><input type="date" name="startDate" id="startDate">
					~ <input type="date" name="endDate" id="endDate"> <input
					type="checkbox" name="all" id="all">전체 <input
					type="checkbox" name="userDate" id="userDate">기간 <input
					type="checkbox" name="userName" id="userName">이름 <input
					type="text" name="search" id="search" placeholder="검색어를 입력해주세요"><a
					href=""><img src="" alt=""></a></td>
			</tr>
			<div>
			<table>
			<tr>
				<td></td>
				<td><c:if test="${!empty members}">
						<table>
							<tr>
								<td>번호</td>
								<td>이름</td>
								<td>아이디</td>
								<td>연락처</td>
								<td>이메일</td>
							</tr>
							<c:forEach var="m" items="${members}">
								<tr>
									<td>${m.memberNumber}</td>
									<td><a
										href="<c:url value="/admin/detail/${m.memberNumber}"/>">${m.userName}</a>
									</td>
									<td>${m.userId }</td>
									<td>${m.phone }</td>
									<td>${m.email }</td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
					<div>
						<span onclick="alert('이전 페이지가 없습니다.');">이전</span>
						<c:set var="page" value="${(param.p==null)? 1: param.p}" />
						<c:set var="startNum" value="${page-(page-1)%5}" />
						<span> <c:forEach var="i" begin="0" end="4">
								<a href="?p=${startNum+i}&t=&q=">${startNum+i}</a>
							</c:forEach>
						</span> <span onclick="alert('다음 페이지가 없습니다.');">다음</span>
					</div></td>
			</tr>
		</table>
	</div> --%>
	<script>
 	$(function(){
	  	$('#searchBtn').click(function() {
	  			self.location = "" + '${pageMaker.makeSearch(1)}' + encodeURIComponent($('#keywordInput').val());
    	});
	 });   
	</script>
</body>
</html>