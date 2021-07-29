<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lostPage</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<jsp:include page="../include/nav.jsp" />

	<div class="wrap-all-lostPageWirte">

		<div class="title-lostPageWrite"> <!-- 상단 찾아주세요 문구 -->
			<h2>찾아주세요</h2>
		</div>
		<div class="input-lostPageWrite"> 
			<form:form commandName="<%-- lostPageWriteCommand --%>" name="input-lostPageWrite">
				<table id="input-lostPageWrite"> <!-- 입력칸 부분 -->
					<tr>
						<td>* 글번호(자동생성)</td>
						<td><form:input path="postNum" value="16266847"/></td>
					</tr>
					<tr>
						<td>* 글제목</td>
						<td><form:input path="postTitle" placeholder="글제목"/></td>
					</tr>
					<tr>
						<td>  동물이름</td>
						<td><form:input path="animalName" placeholder="동물이름 ex.마루, 초코..."/></td>
					</tr>
					<tr>
						<td>  품종</td>
						<td><form:input path="kind" id="kind" placeholder="품종"/></td>
					</tr>
					<tr>
						<td>* 성별</td>
						<td><form:input path="gender" id="gender" placeholder="남아/여아(중성화수술 여부 까지 적어주세요)"/></td>
					</tr>
					<tr>
						<td>* 실종위치</td>
						<td><form:input path="lostArea" id="lostArea" placeholder="실종위치"/></td>
					</tr>
					<tr>
						<td>* 실종시각</td>
						<td><form:input path="lostTime" id="lostTime" placeholder="실종시각"/></td>
					</tr>
					<tr>
						<td>* 특징</td>
						<td><form:input path="char" id="char" placeholder="특징(30자 이내)"/></td>
					</tr>
					<tr>
						<td>* 상세내용</td>
						<td><form:input path="memo" rows="10" cols="100" placeholder="상세내용"/></td>
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
						<!-- 회원가입할 때 받았으니 제거
						<input type="checkbox" name="term" id="term" value="infoAgree"> 개인정보 수집 이용 동의 (필수)<br>
						 -->
					</div>
				</div>
				<div> <!-- 작성완료 버튼 -->
					<input type="submit" value="작성완료">
				</div>
			</form:form>
		</div>
	</div>

	<jsp:include page="../include/footer.jsp" />
</body>
</html>
