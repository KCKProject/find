<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../resources/css/style.css">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="../../resources/script/script.js" defer></script>
<title>회원 정보 상세 보기</title>
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
				<p>회원 정보</p>
			</div>
			<div class="wrapContents adminMemberDetail">

				<h3>Member Contents</h3>
				<div class="adminMemberDetailContents">
					<label>
						<div>
							<p>
								<i class="fas fa-paperclip adminBoardDetailContentsIcon"></i>
								아이디 : ${member.userId}
							</p>
							<p>
								<i class="fas fa-paperclip adminBoardDetailContentsIcon"></i>
								이름 : ${member.userName}
							</p>
							<p>
								<i class="fas fa-paperclip adminBoardDetailContentsIcon"></i>
								전화번호 : ${member.phone}
							</p>
							<p>
								<i class="fas fa-paperclip adminBoardDetailContentsIcon"></i>
								이메일 : ${member.email}
							</p>
						</div>
					</label>
				</div>



				<div class="adminBoardDetailBtn">
					<a href="<c:url value='/admin/adminMember'/>">
						<button class="btn btn-swap"> MORE <span>전체 화원 보기</span> </button>
					</a>
				<%-- 	<a href="<c:url value='/admin/adminMember'/>">
						<button class="btn btn-swap"> DELETE <span>글 삭제 >></span> </button>
					</a>
					 --%>
					<a href="<c:url value='/admin/memberUpdate/${member.memberNumber}'/>">
						<button class="btn btn-swap"> EDIT <span>정보 변경 >></span> </button>
					</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>