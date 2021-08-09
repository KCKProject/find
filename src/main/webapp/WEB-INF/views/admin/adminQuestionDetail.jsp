<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../resources/css/style.css">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="../../resources/script/script.js" defer></script>
<title>QnA 상세 보기</title>
</head>
<body>
	<jsp:include page="../admin-include/adminHeader.jsp"></jsp:include>
	<jsp:include page="../admin-include/adminNav.jsp"></jsp:include>
	<div class="adminWrap">
		<div class="left">
			<div>
				<p class="adminTitle">Q&A 관리</p>
			</div>
			<ul>
					<a href="<c:url value='/admin/adminQuestionPage'/>"><li>Q&A 관리</li></a>
			</ul>
		</div>

		<span class="line"></span>

		<div class="right">
				<div class="wrapContents">
					<label>
						글제목 : ${qnABoard.title}
					</label>
					<br>
					<label>
						작성자 : ${qnABoard.writer}
					</label>
					<br>
					<label>
						작성일 : <fmt:formatDate value="${qnABoard.writeDate}" pattern="yyyy-MM-dd"/>
					</label>
					<br>
					<label>
						내용 : ${qnABoard.contents}
					</label>
					<br>
					<div class="adminBoardDetailBtn">
						<a href="<c:url value='/admin/adminQuestionPage'/>">
							<button class="btn btn-swap"> MORE <span>전체 글 보기 >></span> </button>
						</a>
						<a href="<c:url value='/admin/adminQuestionPage'/>">
							<button class="btn btn-swap" onclick="delQnA(${qnABoard.boardNum})"> DELETE <span>글 삭제 >></span> </button>
						</a>
						<a href="<c:url value='/admin/adminQuestionPage'/>">
							<button class="btn btn-swap"> EDIT <span>글 수정 >></span> </button>
						</a>
						<!-- 발견완료 체크유무에 따른(=meet 컬럼 값에 따른) 버튼 종류의 차이 -->
						<c:if test="${qnABoard.open != null}">
							<c:choose>
								<c:when test="${qnABoard.open eq 0}">
									<button class="btn btn-swap" name="meet" id="meet" onclick="location='<c:url value="/admin/changeOpen/${qnABoard.boardNum}&${qnABoard.open}"/>'">PUBLIC<span>공개 >></span></button>
								</c:when>
								<c:when test="${qnABoard.open eq 1}">
									<button class="btn btn-swap" name="meet" id="meet" onclick="location='<c:url value="/admin/changeOpen/${qnABoard.boardNum}&${qnABoard.open}"/>'">CLOSED<span>비공개 >></span></button>
								</c:when>
							</c:choose>
						</c:if>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			function delQnA(boardNum) {
				var chk = confirm("정말 삭제하시겠습니까?");
				if (chk) {
					location.href="<c:url value='/admin/questionDelete/'/>"+boardNum;
				}
			}
		</script>
	
</body>
</html>