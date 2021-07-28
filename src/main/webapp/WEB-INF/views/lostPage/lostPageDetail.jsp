<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lostPage</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<jsp:include page="../include/nav.jsp" />

	<div class="wrap-all-lostPage">

		<div class="title-lostPageDetail"> <!-- 상단 제목 문구 -->
			<h2>(실종) ${detail.title}</h2>
		</div>

		<div class="wrap-lostPage"> 
			
			<div class="lostPage-contents">
				<ul class="post-photo-top"> <!-- 게시글 사진 나오는 부분 -->
					<li>사진</li>
					<li>사진</li>
					<li>사진</li>
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
			
			<div> <!-- 버튼들 모음 -->
				  <!-- 로그인한 사람이 본인 글에 들어왔을때만 보이는 버튼들 추가 -->
				<input type="button" name="toList" id="toList" onclick="location='lostPage'" value="목록으로">
				<c:if test="${memberAuthInfo.userName==detail.writer}">
					<input type="button" name="delete" id="delete" onclick="" value="글 삭제">
					<input type="button" name="meet" id="meet" value="발견완료로 변경">
				</c:if>
			</div>
			
			<div class="wrap-lostPage-comment">
				<h4>댓글을 남겨주세요 !</h4>
				<p>*댓글을 남겨주세요! 여러분의 작은 관심이 희망의 끈이 됩니다. 욕설/명예훼손의 글은 동의 없이 삭제됩니다.</p>
				<div class="lostPage-comment">
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
				</div>
				<div> <!-- 댓글등록 버튼 -->
				<input type="button" name="uploadComment" id="uploadComment" onclick="uploadComment()" value="댓글등록">
			</div>
			</div>
		</div>
	</div>

	<jsp:include page="../include/footer.jsp" />
</body>
</html>
