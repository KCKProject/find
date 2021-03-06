<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/style.css">
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script src="https://kit.fontawesome.com/2d323a629b.js" crossorigin="anonymous"></script>
<title>관리자 페이지_QnA관리</title>
</head>
<body>
	<jsp:include page="../admin-include/adminHeader.jsp"></jsp:include>
	<jsp:include page="../admin-include/adminNav.jsp"></jsp:include>
	<div class="adminWrap">
		<div class="left">
			<div>
				<p class="adminTitle">Q&A 관리</p>
			</div>
			<div>
				<ul>
					<a href="<c:url value='/admin/adminQuestionPage'/>"><li>Q&A 관리</li></a>
				</ul>
			</div>
		</div>

		<span class="line"></span>

		<div class="right">
			<div>
				<p> Q&A 
				<%-- <c:forEach items="${questions}" var="i" varStatus="status">
					<c:if test="${status.last}">
							${i.boardNum}
					</c:if>
				</c:forEach> --%>
				${pageMaker.totalCount}개 <!-- 읽어서 받아올수 있게 만들기 -->
				<input type="text" name="keyword" id="keywordInput" value="${scri.keyword}" placeholder="글제목으로 검색"/>
				<button id="searchBtn" onclick=""><img
				src="../resources/img/search.png" alt="검색" width="15px"
				height="15px"></button>
				</p>
			</div>
				<div>
					<a href="<c:url value='questionPageWrite'/>"><button class="qnaBtn">QnA등록</button></a>
				</div>
			<div>
				<table class="adminContents">
					<c:if test="${!empty questions}">
							<tr class="adminContentsListTitle">
								<td>번호</td>
								<td>글제목<span class="clickText clickTextDisplay">click</span></td>
								<td>작성자</td>
								<td>작성일</td>
								<td>공개여부</td>
							</tr>

							<c:forEach var="m" items="${questions}">
								<tr>
									<td>${m.boardNum}</td>
									<td>
										<a href="<c:url value="/admin/questionDetail/${m.boardNum}"/>">${m.title}</a>
									</td>
									<td>${m.writer}</td>
									<td><fmt:formatDate value="${m.writeDate}" pattern="yyyy-MM-dd"/></td>
									<c:if test="${m.open ==1}">
										<td>공개</td>
									</c:if>
									<c:if test="${m.open ==0}">
										<td>비공개</td>
									</c:if>
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
<%-- 			<div class="wrap">
				<table border="1">
					<tr>
						<td rowspan="2">
							<h2>Q&A 관리</h2>
						</td>
						<td>
							<p>Q&A 개</p>
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
					<tr>
						<td></td>
						<td>
							<table>
								<tr>
									<td>번호</td>
									<td>작성자</td>
									<td>글제목</td>
									<td>작성일</td>
									<td>공개</td>
								</tr>
								<tr>
									<td>1</td>
									<td>홍길동</td>
									<td>~~방법은?</td>
									<td>2020-07-20</td>
									<td>공개</td>
								</tr>
							</table> <input type="button" value="글쓰기">
							<div>
								<span onclick="alert('이전 페이지가 없습니다.');"><<</span>
								<c:set var="page" value="${(param.p==null)? 1: param.p}" />
								<c:set var="startNum" value="${page-(page-1)%5}" />
								<span> <c:forEach var="i" begin="0" end="4">
										<a href="?p=${startNum+i}&t=&q=">${startNum+i}</a>
									</c:forEach>
								</span> <span onclick="alert('다음 페이지가 없습니다.');">>></span>
							</div>
						</td>
					</tr>
				</table>
			</div> --%>
</body>
<script>
$(function(){
  	$('#searchBtn').click(function() {
  			self.location = "" + '${pageMaker.makeSearch(1)}' + encodeURIComponent($('#keywordInput').val());
	});
 }); 
</script>
</html>