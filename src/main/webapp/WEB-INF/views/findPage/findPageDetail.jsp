<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>findPage</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<jsp:include page="../include/nav.jsp" />

	<div class="wrapboardPage">

		<div class="title-findPageDetail"> <!-- 상단 제목 문구 -->
			<h2>(실종) 포메 5살 남아 수원시청 부근</h2>
		</div>

		<div class="wrap-findPage"> 
			
			<div class="findPage-contents">
				<ul class="post-photo-top"> <!-- 게시글 사진 나오는 부분 -->
					<li>사진</li>
					<li>사진</li>
					<li>사진</li>
				</ul>
				<div class="post-contents-bottom"> <!-- 게시글 내용 나오는 부분 -->
					<div class="userid-writetime-anumber-view">
						<p>쿠키금동님 | 2021.07.11. 04:47 | 등록번호 46,243 | 조회 228</P>
					</div>
					<div class="animalName">
						<p>이름 | 초코</p>
					</div>
					<div class="kind">
						<p>품종 | 포메라니안</p>
					</div>
					<div class="gender">
						<p>성별 | 남아 중성화수술 함</p>
					</div>
					<div class="findArea">
						<p>실종 위치 | 수원시청 바로 뒤</p>
					</div>
					<div class="findTime">
						<p>실종 시각 | 14일 18시 경</p>
					</div>
					<div class="char">
						<p>특징 | 오른쪽 발등에 하얀털</p>
					</div>
					<div class="phone">
						<p>연락처 | 010-1234-5678</p>
					</div>
					<div class="memo">
						<p>7/10 새벽 3시경 열린 문틈 사이로 나갔습니다 하루종일 골목골목이랑 인근 상가들 다 물어봤지만 새벽이라 본 사람이 없어서 차로 넓게도 돌아봤는데 안보이네요,,, 
							근처 있을줄 알았는데 쿠키 제발 찾아주세요ㅠㅠ</p>
					</div>
				</div>
			</div>
			
			<div> <!-- 목록으로 버튼 -->
				<input type="button" name="toList" id="toList" onclick="location='findPage'" value="ëª©ë¡ì¼ë¡">
			</div>
			
			<div class="wrap-findPage-comment">
				<h4>댓글을 남겨주세요 !</h4>
				<p>*댓글을 남겨주세요! 여러분의 작은 관심이 희망의 끈이 됩니다. 욕설/명예훼손의 글은 동의 없이 삭제됩니다.</p>
				<div class="findPage-comment">
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
				</div>
				<div> <!-- 댓글등록 버튼 -->
				<input type="button" name="uploadComment" id="uploadComment" onclick="uploadComment()" value="ëê¸ë±ë¡">
			</div>
			</div>
		</div>
	</div>

	<jsp:include page="../include/footer.jsp" />
</body>
</html>
