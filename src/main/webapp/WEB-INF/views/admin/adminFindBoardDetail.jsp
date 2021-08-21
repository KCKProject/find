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
<title>찾아가세요 글 상세 보기</title>
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
			<div class="wrapContents adminBoardDetail">
				<label>
					글제목 : ${findBoard.title}
				</label>
				<br>
				<label>
					작성자 : ${findBoard.writer} | 작성일 : <fmt:formatDate value="${findBoard.writeDate}" pattern="yyyy-MM-dd"/>
				</label>
				<br>
				<h3>Board Contents</h3>
					<div class="adminBoardDetailContents">
						<label>
							<div>
								<p><i class="fas fa-paperclip adminBoardDetailContentsIcon"></i> kind : ${findBoard.kind}</p>
								<p><i class="fas fa-paperclip adminBoardDetailContentsIcon"></i> location : ${findBoard.location}</p>
								<p><i class="fas fa-paperclip adminBoardDetailContentsIcon"></i> character : ${findBoard.character}</p>
								<p><i class="fas fa-paperclip adminBoardDetailContentsIcon"></i> gender : ${findBoard.gender}</p>
								<p><i class="fas fa-paperclip adminBoardDetailContentsIcon"></i> email : ${findBoard.email}</p>
								<p><i class="fas fa-paperclip adminBoardDetailContentsIcon"></i> phone : ${findBoard.phone}</p>
								<p><i class="fas fa-paperclip adminBoardDetailContentsIcon"></i> lostDate : ${findBoard.findDate}</p>
								<p><i class="fas fa-paperclip adminBoardDetailContentsIcon"></i> memo : ${findBoard.memo}</p>
								<p><i class="fas fa-paperclip adminBoardDetailContentsIcon"></i> meet : ${findBoard.meet} (1 = 발견완료 | 0 = 미발견)</p>
								<p><i class="fas fa-paperclip adminBoardDetailContentsIcon"></i> review : ${findBoard.review}</p>
								<p><i class="fas fa-paperclip adminBoardDetailContentsIcon"></i> hit : ${findBoard.hit}</p>
							</div>
						</label>
					</div>
				<br>
				<div class="adminBoardDetailBtn">
					<a href="<c:url value='/admin/adminBoard'/>">
						<button class="btn btn-swap"> MORE <span>전체 글 보기 >></span> </button>
					</a>
					<a href="<c:url value='/admin/adminBoard'/>">
						<button class="btn btn-swap" onclick="delFind(${findBoard.boardNum})"> DELETE <span>글 삭제 >></span> </button>
					</a>
					<%-- <a href="<c:url value='/admin/adminBoard'/>">
						<button class="btn btn-swap"> EDIT <span>글 수정 >></span> </button>
					</a> --%>
					<c:if test="${findBoard.meet != null}">
						<c:choose>
							<c:when test="${findBoard.meet eq 0}">
								<button class="btn btn-swap" name="meet" id="meet" onclick="location='<c:url value="/admin/changeFindMeet/${findBoard.boardNum}&${findBoard.meet}"/>'">CONFIRM<span>완료 >></span></button>
							</c:when>
							<c:when test="${findBoard.meet eq 1}">
								<button class="btn btn-swap" name="meet" id="meet" onclick="location='<c:url value="/admin/changeFindMeet/${findBoard.boardNum}&${findBoard.meet}"/>'">CONFIRM<span>미완료 >></span></button>
							</c:when>
						</c:choose>
					</c:if>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
	function delFind(boardNum) {
		var chk = confirm("정말 삭제하시겠습니까?");
		if (chk) {
			location.href="<c:url value='/admin/findBoardDelete/'/>"+boardNum;
		}
	}
</script>	

</body>
</html>