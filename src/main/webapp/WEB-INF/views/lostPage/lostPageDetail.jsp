<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../resources/css/style.css">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="../../resources/script/script.js" defer></script>
<title>lostPage</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />

	<div class="wrapboardPage">
	
		<div id="contentsTitle">
			<h3 class="contentsTitle">(실종) ${detail.title}</h3>
			<div class="boardDetailPageLine"></div>
		</div>

		<div class="wrap-lostPage"> 
			
			<div class="boardPage-contents">
				<ul>
					<li class="post-photo-top"></li>
					<li class="post-photo-top"></li>
					<li class="post-photo-top"></li>
				</ul>
				<div class="post-contents-bottom"> <!-- 게시글 내용 나오는 부분 -->
					<div class="userid-writetime-anumber-view">
						<p>${detail.writer}님 | ${detail.writeDate} | 등록번호 ${detail.boardNum} | 조회 228</P>
					</div>
					<div class="animalName">
						<p>이름 | ${detail.animal}</p>
					</div>
					<div class="kind">
						<p>품종 | ${detail.kind}</p>
					</div>
					<div class="gender">
						<p>성별 | ${detail.gender}</p> <!-- ex)남아 중성화수술 함 -->
					</div>
					<div class="location">
						<p>실종 위치 | ${detail.location}</p>
					</div>
					<div class="lostDate">
						<p>실종 시각 | ${detail.lostDate}</p>
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
				</div>
			</div>
			
			<div class="wrap-btns"> <!-- 버튼들 모음 -->
				  <!-- 로그인한 사람이 본인 글에 들어왔을때만 보이는 버튼들 추가 -->
				<button class="btn btn-swap" name="toList" id="toList" onclick="location='<c:url value="/lostPage/lostPageList"/>'" >목록으로<span>목록으로 >></span></button>
				<c:if test="${memberAuthInfo.userName eq detail.writer}">
					<button class="btn btn-swap" name="delete" id="delete" onclick="del(${detail.boardNum})">글삭제<span>글삭제 >></span></button>
					<!-- 발견완료 체크유무에 따른(=meet 컬럼 값에 따른) 버튼 종류의 차이 -->
					<c:choose>
						<c:when test="${detail.meet eq 0}">
							<button class="btn btn-swap" name="meet" id="meet" onclick="location='<c:url value="/lostPage/changeMeet/${detail.boardNum}&${detail.meet}"/>'">발견완료<span>변경 >></span></button>
						</c:when>
						<c:when test="${detail.meet eq 1}">
							<button class="btn btn-swap" name="meet" id="meet" onclick="location='<c:url value="/lostPage/changeMeet/${detail.boardNum}&${detail.meet}"/>'">미발견<span>변경 >></span></button>
						</c:when>
					</c:choose>
				</c:if>
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
	                    <button class="btn btn-swap" name="uploadComment" id="uploadComment" onclick="uploadComment()">
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
	<button class="jellybutton sidebtn1" name="write" id="write" onclick="location='<c:url value="/lostPage/lostPageWrite"/>'">WIRTE</button>
	<script>

	function del(boardNum) {
		var chk = confirm("정말 삭제하시겠습니까?");
		if (chk) {
			location.href="<c:url value='/lostPage/delete/'/>"+boardNum;
		}
	}	
</script>
</body>
</html>
