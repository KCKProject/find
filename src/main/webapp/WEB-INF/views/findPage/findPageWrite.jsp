<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>findPage</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<jsp:include page="../include/nav.jsp" />

	<div class="wrap-all-findPageWirte">

		<div class="title-findPageWrite"> <!-- 상단 찾아주세요 문구 -->
			<h2>찾아가세요</h2>
		</div>
		<div class="input-findPageWrite"> 
			<form action="#" method="POST" name="input-findPageWrite">
				<table id="input-findPageWrite"> <!-- 입력칸 부분 -->
					<tr>
						<td>* 글번호(자동생성)</td>
						<td><input type="text" name="postNum" value="16266847"
							readonly></td>
					</tr>
					<tr>
						<td>* 글제목</td>
						<td><input type="text" name="postTitle" id="postTitle"
							placeholder="글제목"></td>
					</tr>
					<tr>
						<td>  동물이름</td>
						<td><input type="text" name="animalName" id="animalName"
							placeholder="동물이름 ex.마루, 초코..."></td>
					<tr>
						<td>  품종</td>
						<td><input type="text" name="kind" id="kind"
							placeholder="품종"></td>
					</tr>
					<tr>
						<td>  성별</td>
						<td><input type="text" name="gender" id="gender"
							placeholder="남아/여아(중성화수술 여부 까지 적어주세요)"></td>
					</tr>
					<tr>
						<td>* 실종위치</td>
						<td><input type="text" name="findArea" id="findArea"
							placeholder="실종위치"></td>
					</tr>
					<tr>
						<td>* 실종시각</td>
						<td><input type="text" name="findTime" id="findTime"
							placeholder="실종시각"></td>
					</tr>
					<tr>
						<td>* 특징</td>
						<td><input type="text" name="char" id="char"
							placeholder="특징(30자 이내)"></td>
					</tr>
					<tr>
						<td>* 상세내용</td>
						<td><textarea name="memo" id="memo" rows="150" cols="50" 
							placeholder="상세내용"></textarea></td>
					</tr>
				</table>

				<div> <!-- 첨부파일 -->
					<div class="photofile-btn"></div>
				</div>
				<div> <!-- 약관 -->
					<div class="writeTerms">
						<input type="checkbox" name="term" id="term" value="agree"> 전체동의<br> 
						<input type="checkbox" name="term" id="term" value="phoneAgree"> 연락처 노출 동의<br>
									(회원가입 시 등록 한 연락처를 연락받을 번호로 기재 합니다. 미체크시 별도의 연락수단 상세내용에 기재 요망)<br> 
						<input type="checkbox" name="term" id="term" value="emailAgree"> 이메일 노출 동의<br>
									(회원가입 시 등록 한 이메일을 연락받을 메일로 기재 합니다.)<br> 
						<input type="checkbox" name="term" id="term" value="infoAgree"> 개인정보 수집 이용 동의 (필수)<br>
					</div>
				</div>
				<div> <!-- 작성완료 버튼 -->
					<input type="submit" value="작성완료">
				</div>
			</form>
		</div>
		
	</div>

	<jsp:include page="../include/footer.jsp" />
</body>
</html>
