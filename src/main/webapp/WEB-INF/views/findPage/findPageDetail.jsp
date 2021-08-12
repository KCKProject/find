<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찾아가세요</title>
<link rel="stylesheet" href="../../resources/css/style.css">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="../../resources/script/script.js" defer></script>
</head>
<body>
	<jsp:include page="../include/header.jsp" />

	<div class="wrapboardPage">

		<div id="contentsTitle">
			<h3 class="contentsTitle">(발견) ${detail.title}</h3>
			<div class="boardDetailPageLine"></div>
		</div>

		<div class="wrap-findPage">

			<div class="boardPage-contents">
				<ul>
					<li class="post-photo-top"></li>
					<li class="post-photo-top"></li>
					<li class="post-photo-top"></li>
				</ul>
				<div class="post-contents-bottom">
					<!-- 게시글 내용 나오는 부분 -->
					<c:if test="${detail.meet==1}">
						<div>
							<p class="finishText">발견완료</p>
						</div>
					</c:if>
					
					<div class="userid-writetime-anumber-view">
						<p>${detail.writer}님|${detail.writeDate}| 등록번호
							${detail.boardNum} | 조회 ${detail.hit}</P>
					</div>
					<div class="kind">
						<p>품종 | ${detail.kind}</p>
					</div>
					<div class="gender">
						<p>성별 | ${detail.gender}</p>
						<!-- ex)남아 중성화수술 함 -->
					</div>
					<div class="location">
						<p>실종 위치 | ${detail.location}</p>
					</div>
					<div class="findDate">
						<p>실종 시각 | ${detail.findDate}</p>
					</div>
					<div class="character">
						<p>특징 | ${detail.character}</p>
					</div>
					<div class="phone">
						<p>연락처 | ${detail.phone}</p>
					</div>
					<div class="memo">
						<p>${detail.memo}</p>
					</div>
					
					<c:if test="${detail.meet==1}">
						<c:if test="${not empty detail.review }">
			 				<div class="reviewContents">
								<p><i class="fas fa-quote-left"></i>${detail.review}<i class="fas fa-quote-right"></i></p>
							</div> 
						</c:if>
					</c:if>	
					
				</div>
			</div>


			<div class="wrap-btns">
				<!-- 버튼들 모음 -->
				<!-- 로그인한 사람이 본인 글에 들어왔을때만 보이는 버튼들 추가 -->
				<button class="btn btn-swap" name="toList" id="toList"
					onclick="location='<c:url value="/findPage/findPageList"/>'">
					목록으로<span>목록으로 >></span>
				</button>
				<c:if test="${memberAuthInfo.userName eq detail.writer}">
					<button class="btn btn-swap" name="delete" id="delete"
						onclick="del(${detail.boardNum})">
						글삭제<span>글삭제 >></span>
					</button>
					<button class="btn btn-swap" name="modify" id="modify"
						onclick="location='<c:url value="findPage/findPageModify/${detail.boardNum}"/>'">
						글수정<span>글수정 >></span>
					</button>

					<!-- 발견완료 체크유무에 따른(=meet 컬럼 값에 따른) 버튼 종류의 차이 -->
					<c:choose>
						<c:when test="${detail.meet eq 0}">
							<button class="btn btn-swap" name="meet" id="meet"
								onclick="location='<c:url value="/findPage/changeMeet/${detail.boardNum}&${detail.meet}"/>'">
								발견완료<span>변경 >></span>
							</button>
						</c:when>
						<c:when test="${detail.meet eq 1}">
							<button class="btn btn-swap" name="meet" id="meet"
								onclick="location='<c:url value="/findPage/changeMeet/${detail.boardNum}&${detail.meet}"/>'">
								미발견<span>변경 >></span>
							</button>
						</c:when>
					</c:choose>
				</c:if>
			</div>
			<div class="review">
				<form method="POST" action="/KCK_find/findPage/findPageWrite/review">
					<h2>후기를 남겨주세요! 찾은 장소나 위치, 그리고 찾게 된 경로 등을 상세히 적어 주시면 많은 도움이 됩니다.</h2>
					<input type="hidden" name="boardNum" value="${detail.boardNum}" />
					<textarea name="review" rows="10" cols="30">${detail.review}</textarea>
					<input type="submit" value="작성완료" class="completeBtn"> 
				</form>
			</div>



			<div class="wrap-lostPage-comment">
				<div class="lostPage-comment-top">
					<h4>댓글을 남겨주세요 !</h4>
					<p>*댓글을 남겨주세요! 여러분의 작은 관심이 희망의 끈이 됩니다. 욕설/명예훼손의 글은 동의 없이 삭제됩니다.</p>
				</div>
				<div class="lostPage-comment-bottom">
					<ul>
						<li>
							<p>털이 하얘서 금방 찾을 수 있을거에요 !! 힘내세요 ㅠㅠ</p>
							<p>프젝님 | 2021-05-21</p>
						</li>
						<li>
							<p>털이 하얘서 금방 찾을 수 있을거에요 !! 힘내세요 ㅠㅠ</p>
							<p>프젝님 | 2021-05-21</p>
						</li>
						<li>
							<p>힘내세요 ㅠㅠ</p>
							<p>프젝님 | 2021-05-21</p>
						</li>
						<li>
							<p>프로젝트 마감일정 0825</p>
							<p>프젝님 | 2021-05-21</p>
						</li>
						<li>
							<p>수원시청 뒤쪽 ㅠㅠㅠㅠㅠㅠ</p>
							<p>프젝님 | 2021-05-21</p>
						</li>
					</ul>
					<div>
						<textarea rows="10" cols="10"></textarea>
					</div>
					<div class="mainMore">
						<!-- 댓글등록 버튼 -->
						<button class="btn btn-swap" name="uploadComment"
							id="uploadComment" onclick="uploadComment()">
							upload <span>댓글등록 >></span>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="../include/footer.jsp" />
	<button class="jellybutton topbtn" type="button" onclick="goTop()">TOP</button>
	<!-- 글쓰기 버튼 -->
	<!-- 예정) 로그인안한 회원은 로그인 페이지로 연결되도록 수정할 예정 -->
	<c:if test="${memberAuthInfo == null }">
		<div class="centerbtn">
			<div class="jellybutton centerHiddenContents" name="centerHidden"
				id="centerHidden">
				<p>
					INFO<br>! 로그인 후 글쓰기 가능 합니다.<br>! 아이디 | 비밀번호 분실 시 로그인<br>페이지
					하단의 찾기 버튼 클릭
				</p>
			</div>
			<button class="jellybutton sidebtn1" name="write" id="write">WRITE</button>
		</div>
	</c:if>
	<c:if test="${memberAuthInfo != null }">
		<button class="jellybutton sidebtn1" name="write" id="write" onclick="location='<c:url value="/findPage/findPageWrite"/>'">WRITE</button>
	</c:if>
	
	<!-- 리뷰버튼 -->
	<c:if test="${memberAuthInfo.userName eq detail.writer}">
		<c:if test="${detail.meet eq 1}">
			<div class="centerbtn">
				<div class="jellybutton centerHiddenContents reviewHiddenContents" name="centerHiddenContents" id="centerHiddenContents">
					<p>
						INFO<br>! 리뷰를 작성해주세요 <br>! 리뷰 버튼 클릭 시 리뷰 작성  혹은 수정 가능 합니다.
					</p>
				</div>
				<button class="jellybutton sidebtn7" name="review" id="review" onclick="window.scrollTo(800,800)">REVIEW</button>
			</div>
		</c:if>
	</c:if>

	<script>
		function del(boardNum) {
			var chk = confirm("정말 삭제하시겠습니까?");
			if (chk) {
				location.href="<c:url value='/findPage/delete/'/>"+boardNum;
			}
		}
		
		function onClickHandler(meet) {
			alert(meet)
		}
	</script>
</body>
</html>