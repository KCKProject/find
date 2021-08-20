<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../resources/css/style.css">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="../../resources/script/script.js" defer></script>

<title>마이페이지</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<section class="myPage">
	
		<h1>마이페이지</h1>		
		<div class="wrapMyInfo">
			<div class="myInfo">	
				<div class="myGrade">
					<div>
						<i class="fas fa-dove"></i>
					</div>
					<div>
						<p>${memberAuthInfo.getUserId()}님 환영합니다.</p>
						<p class="changeMyInfodToggle">나의 정보 확인 & 변경 >><span class="clickText">click</span></p>
					</div>
				</div>
				<div class="myActivities">
					<div class="myActivitiesTitle">
						<p>나의 활동</p>
					</div>
					<div class="wrapMyActivitiesContents">
						<div class="myActivitiesContents">
							<p>나의 정보<br>등록완료</p>
							<p>찾아주세요 글<br>1개</p>
						</div>
						<div class="myActivitiesContents">
							<p>현재 미완료 글<br>1개</p>
							<p>찾아가세요 글<br>1개</p>
						</div>
					</div>
				</div>		
			</div>
		</div>

		<div class="wrapMyInfoDetail">
			<h3>내 정보</h3>
			<div class=myInfoDetail>
				<div class="myInfoDetailContents">
					<div>
						<div>
							<p>아이디</p>
							<p>이름</p>
							<p>연락처</p>
							<p>이메일</p>
						</div>
					</div>
					<div>
						<div>
							<p>${memberAuthInfo.getUserId()}</p>
							<p>${memberAuthInfo.getUserName()}</p>
							<p>${memberAuthInfo.getPhone()}</p>
							<p>${memberAuthInfo.getEmail()}</p>
						</div>
					</div>
				</div>
			</div>


			<div class="changePassword">
				<div class="changePasswordContents">
					<i class="fas fa-times exitchangePasswordBtn"></i>
					<div>
						현재 비밀번호 <input type="text">
					</div>
					<div>
						변경 비밀번호 <input type="text">
					</div>
					<div>
						비밀번호 확인 <input type="text">
					</div>
					<div>
						<input type="submit" value="비밀번호 변경" class="changePasswordBtn">
					</div>
				</div>	
			</div>
			<a class="changePasswordToggle changeInfoBtn"><span class="clickText">click</span><i class="fas fa-unlock-alt editIcon"></i>비밀번호 변경</a>
			<a href="<c:url value='/myPage/myInfoUpdate/${memberAuthInfo.getMemberNumber()}'/>" class="changeInfoBtn"><i class="fas fa-user-edit editIcon"></i>나의정보 수정<span class="clickText">click</span></a>
		</div>
s
		<div class="wrapMyPost">
			<h3>내가 작성한 글<span>찾아주세요</span></h3>
			<div class="myPost">
				<div class="myPostBx">
					<div>
						<c:if test="${!empty lostPosts}">
							<c:forEach var="p" items="${lostPosts}">
								<div>
									<p>
										<c:if test="${p.meet==1}"><i class="fas fa-stamp" style="color: gray;"></i></c:if>
										<c:if test="${p.meet==0}"><i class="fas fa-stamp" style="color: #ed4848;"></i></c:if>
									</p>
									<p>${p.title}</p>
									<p>${p.writeDate}</p>
								</div>
							</c:forEach>
						</c:if>
						<c:if test="${empty lostPosts}">
							<div>
								<p></p>
								<p>찾아주세요 게시글이 없습니다.</p>
								<p></p>
							</div>
						</c:if>
					</div>
				</div>
			</div>
			
			<h3>내가 작성한 글<span>찾아가세요</span></h3>
			<div class="myPost">
				<div class="myPostBx">	
					<div>
						<c:if test="${!empty findPosts}">		
							<c:forEach var="p" items="${findPosts}">
								<div>
									<p>
										<c:if test="${p.meet==1}"><i class="fas fa-stamp" style="color: gray;"></i></c:if>
										<c:if test="${p.meet==0}"><i class="fas fa-stamp" style="color: #ed4848;"></i></c:if>
									</p>
									<p>${p.title}</p>
									<p>${p.writeDate}</p>
								</div>
							</c:forEach>
						</c:if>
						<c:if test="${empty lostPosts}">
							<div>
								<p></p>
								<p>찾아가세요 게시글이 없습니다.</p>
								<p></p>
							</div>
						</c:if>	
					</div>	
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="../include/footer.jsp" />
	
	<button class="jellybutton topbtn" type="button" onclick="goTop()">TOP</button>

</body>
</html>