<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/css/style.css">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="../resources/script/script.js" defer></script>
<title>Q&A 게시판</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />

	<div class="wrapQuestionPage">
		<div class="qaBx">
			<c:if test="${empty questions}">
				<ul>
					<li>등록된 QnA가 없습니다.</li>
				</ul>
			</c:if>
			<c:if test="${!empty questions}">
				<table>
				<!-- q&a 데이터 많지 않아서 jsp 에서 애초에 저 데이터까지 받아와놓고 css로 안보이게해놧다가 보여주게 해도 될듯 합니당 -->
					<tr class="qaBxListTitle">
						<!-- <th>번호</th> -->
						<th class="qaBxContentsTitle">제목</th>
						<th class="qaBxContentsWriter">작성자</th>
						<th class="qaBxContentsWriteDate">작성일</th>
						<th class="qaBxContentsMoreBtn" style="color: white; width: 50px;">상세</th>
					</tr>
					<c:forEach var="q" items="${questions}">
						<c:if test="${q.open==1}">
							<tr>
								<%-- <td>${q.boardNum}</td> --%>
								<td class="qaBxContentsTitle">${q.title}</td>
								<td class="qaBxContentsWriter">${q.writer}</td>
								<td class="qaBxContentsWriteDate"><fmt:formatDate value="${q.writeDate}"
										pattern="yyyy-MM-dd" /></td>
								<td class="qaBxContentsMoreBtn">
									<a class="dnBtnQa"><i class="fas fa-angle-double-down"></i></a>
									<a class="upBtnQa"><i class="fas fa-angle-up"></i></a>
								</td>
							</tr>
							<tr class="qacontentsBx">
								<td colspan="5" class="qacontents" style="text-align: left; padding: 20px 150px;'">${q.contents}</td>
							</tr>
						</c:if>
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
		</div>
	</div>
	<jsp:include page="../include/footer.jsp" />
	<button class="jellybutton topbtn" type="button" onclick="goTop()">TOP</button>
		<!-- Service Center 버튼 -->
		<!-- 내용 미정 -->
	<div class="centerbtn">		
		<div class="jellybutton centerHiddenContents" name="centerHidden" id="centerHidden"><p>Service Center<br>하단의 서비스소개 클릭 후 서비스페이지 상단 메뉴바 Contact 클릭 시 관리자 연락처 확인 가능 </p></div>
		<button class="jellybutton sidebtn1" name="center" id="center">CENTER</button>
	</div>
</body>
</html>
