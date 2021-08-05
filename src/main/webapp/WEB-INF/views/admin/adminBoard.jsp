<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/style.css">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="resources/script/script.js" defer></script>
<title>관리자 페이지_게시판 관리</title>
</head>
<body>
	<jsp:include page="../admin-include/adminHeader.jsp"></jsp:include>
	<jsp:include page="../admin-include/adminNav.jsp"></jsp:include>
	<div class="adminWrap">
		<div class="left">
			<div>
				<p class="adminTitle">게시판 관리</p>
			</div>
			<div>
				<ul>
					<a href="<c:url value='/admin/adminBoard'/>"><li>찾아주세요</li></a>
					<a href="<c:url value='/admin/adminFindBoard'/>"><li>찾아가세요</li></a>
				</ul>
			</div>
		</div>

		<span class="line"></span>

		<div class="right">
			<div>
				<p>진행중 개 | 완료 개 | 
				전체${pageMaker.totalCount}개 
				<input type="text" name="search" id="search" placeholder="검색어를 입력해주세요"> 
				<a href=""><img src="../resources/img/search.png" alt="검색" width="15px" height="15px"></a></p>
				<!-- 읽어서 받아올수 있게 만들기 -->
			</div>
			<div>
				<input type="date" name="startDate" id="startDate"> ~ 
				<input type="date" name="endDate" id="endDate"> 
				<label class="checkbox"><input type="checkbox" name="all" id="all"><span class="icon"></span><span class="text">전체</span></label>
				<label class="checkbox"><input type="checkbox" name="proceeding" id="proceeding"><span class="icon"></span><span class="text">진행중</span></label> 
				<label class="checkbox"><input type="checkbox" name="done" id="done"><span class="icon"></span><span class="text">완료</span></label> 
			</div>
			<div> <!-- 찾아주세요 -->
				<c:if test="${!empty losts}">
					<table class="adminContents">
							<tr class="adminContentsListTitle">
								<td>번호</td>
								<td>완료</td>
								<td>글제목</td>
								<td>작성자</td>
								<td>날짜</td>
							</tr>
							<c:forEach var="m" items="${losts}">
								<tr>
									<td>${m.boardNum}</td>
									<c:if test="${m.meet ==1}">
										<td>완료</td>
									</c:if>
									<c:if test="${m.meet ==0}">
										<td>미완료</td>
									</c:if>
									<td>
									<a href="<c:url value="/admin/lostBoardDetail/${m.boardNum}"/>">${m.title}</a>
									</td>
									<td>${m.writer}</td>
									<td><fmt:formatDate value="${m.writeDate}" pattern="yyyy-MM-dd"/></td>
								</tr>
							</c:forEach>
					</table>
					<div class="paging">
						<ul>
	  						<c:if test="${pageMaker.prev}">
						   		<li><a href="${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
						  	</c:if>
						  	<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
						   		<li><a href="${pageMaker.makeQuery(idx)}">${idx}</a></li>
						  	</c:forEach>
						  	<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
						   		<li><a href="${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
						  	</c:if> 
						 </ul>
					</div>
				</c:if>
			</div> <!-- 찾아주세요 -->
			<div> <!-- 찾아가세요 -->
				<c:if test="${!empty finds}">
					<table class="adminContents">
						<tr class="adminContentsListTitle">
							<td>번호</td>
							<td>완료</td>
							<td>글제목</td>
							<td>작성자</td>
							<td>날짜</td>
						</tr>

						<c:forEach var="f" items="${finds}">
							<tr>
								<td>${f.boardNum}</td>
								<c:if test="${f.meet ==1}">
									<td>완료</td>
								</c:if>
								<c:if test="${f.meet ==0}">
									<td>미완료</td>
								</c:if>
								<td>
								<a href="<c:url value="/admin/findBoardDetail/${f.boardNum}"/>">${f.title}</a>
								</td>
								<td>${f.writer}</td>
								<td><fmt:formatDate value="${f.writeDate}" pattern="yyyy-MM-dd"/></td>
							</tr>
						</c:forEach>
					</table>
				<div class="paging">
					<ul>
  						<c:if test="${pageMaker.prev}">
					   		<li><a href="${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
					  	</c:if>
					  	<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
					   		<li><a href="${pageMaker.makeQuery(idx)}">${idx}</a></li>
					  	</c:forEach>
					  	<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					   		<li><a href="${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
					  	</c:if> 
					 </ul>
				</div>
				</c:if>
			</div> <!-- 찾아주세요 -->
		</div>
	</div>
</body>
</html>