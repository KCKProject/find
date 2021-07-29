<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/style.css">
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
				<p>찾아주세요</p>
			</div>
			<div>
				<p>찾아가세요</p>
			</div>
		</div>

		<span class="line"></span>

		<div class="right">
			<div>
				<p>진행중 개 | 완료 개 | 
				전체 <c:forEach items="${losts}" var="i" varStatus="status">
						<c:if test="${status.last}">
							${i.boardNum}
						</c:if>
					</c:forEach> 개 
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
			<div>
				<table class="adminContents">
					<c:if test="${!empty losts}">
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
									<a href="<c:url value="/admin/detail/${m.boardNum}"/>">${m.title}</a>
									</td>
									<td>${m.writer}</td>
									<td><fmt:formatDate value="${m.writeDate}" pattern="yyyy-MM-dd"/></td>
								</tr>
							</c:forEach>

					</c:if>
				</table>
				<div class="paging">
					<span onclick="alert('이전 페이지가 없습니다.');">이전</span>
					<c:set var="page" value="${(param.p==null)? 1: param.p}" />
					<c:set var="startNum" value="${page-(page-1)%5}" />
					<span> <c:forEach var="i" begin="0" end="4">
							<a href="?p=${startNum+i}&t=&q=">${startNum+i}</a>
						</c:forEach>
					</span> <span onclick="alert('다음 페이지가 없습니다.');">다음</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>