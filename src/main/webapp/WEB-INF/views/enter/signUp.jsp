<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입e</title>
</head>
<body>
	<header>
		<div class="headerInner">
			<div id="mainTitle">
				<img src="<spring:url value='/resources/img/hand.png'/>" />
				<p>수원시 분실동물 찾기 서비스</p>
			</div>
		</div>
	</header>
	<section>
		<div class="signUpInner">
			<h3>회원가입</h3>
			<div class="signUpBox">
				<form action="#" method="POST" name="signUpForm">
					<table id="signUpTbl">
						<tr>
							<td>* 회원번호(자동생성)</td>
							<td><input type="text" name="memNum" value="16266847" readonly></td>
						</tr>
						<tr>
							<td>* 아이디</td>
							<td><input type="text" name="memId" id="memId" placeholder="아이디"></td>
						</tr>
						<tr>
							<td>* 비밀번호</td>
							<td><input type="password" name="userPwd" id="userPwd" placeholder="비밀번호(영문,숫자,특수문자 조합 6~15자리)"></td>
						</tr>
						<tr>
							<td>* 비밀번호 확인</td>
							<td><input type="password" name="userPwdChk" id="userPwdChk" placeholder="비밀번호 확인"></td>
						</tr>
						<tr>
							<td>* 이름</td>
							<td><input type="text" name="memName" id="memName" placeholder="이름"></td>
						</tr>
						<tr>
							<td>* 이메일</td>
							<td><input type="email" name="email" id="email" placeholder="이메일(@를 포함한 주소 입력)"></td>
						</tr>
						<tr>
							<td>* 연락처</td>
							<td><input type="text" name="phone" id="phone" placeholder="연락처"></td>
						</tr>
					</table>
					<div class="signUpTerms">
						<input type="checkbox" name="term" id="term" value="agree"> 전체동의<br>
						<input type="checkbox" name="term" id="term" value="ageAgree"> 만 14세 이상입니다.(필수)<br>
						<input type="checkbox" name="term" id="term" value="serviceAgree"> 수원시 분실동물 찾기 서비스 이용약관 동의 (필수)<br>
						<input type="checkbox" name="term" id="term" value="infoAgree"> 개인정보 수집 이용 동의 (필수)<br>
					</div>
					<input type="submit" value="회원가입">
				</form>
			</div>			
		</div>
	</section>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>