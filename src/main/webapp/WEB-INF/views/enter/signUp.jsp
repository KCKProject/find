<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
				<form:form commandName="signUpCommand">
					<p>
						<label>* 아이디  
							<form:input path="userId" placeholder="아이디" />
						</label>
					</p>
					<p>
						<label>* 비밀번호
							<form:password path="userPassword" placeholder="비밀번호(영문,숫자,특수문자 조합 6~15자리)" />
						</label>
					</p>
					<p>
						<label>* 비밀번호 확인
							<form:password path="userPwdChk" placeholder="비밀번호 확인" /></td>
							<form:errors path="userPwdChk"/>
						</label>
					</p>
					<p>
						<label>* 이름
							<form:input path="userName" placeholder="이름" />
						</label>
					</p>
					<p>
						<label>* 연락처
							<form:input path="phone" placeholder="연락처" />
						</label>
					</p>
					<p>
						<label>* 이메일
							<form:input path="email" type="email" placeholder="이메일(@를 포함한 주소 입력)"/>
						</label>
					</p>
					<!-- <table id="signUpTbl">
						<tr>
							<th>항목</th>
							<th>입력란</th>
						</tr>
						<tr>
							<td>* 아이디</td>
							<td><form:input path="userId" placeholder="아이디" /></td>
						</tr>
						<tr>
							<td>* 비밀번호</td>
							<td><form:password path="userPassword" placeholder="비밀번호(영문,숫자,특수문자 조합 6~15자리)" /></td>
						</tr>
						<tr>
							<td>* 비밀번호 확인</td>
							<td><form:password path="userPwdChk" placeholder="비밀번호 확인" /></td>
							<form:errors path="userPwdChk"/>
						</tr>
						<tr>
							<td>* 이름</td>
							<td><form:input path="userName" placeholder="이름" /></td>
						</tr>
						<tr>
							<td>* 연락처</td>
							<td><form:input path="phone" placeholder="연락처" /></td>
						</tr>
						<tr>
							<td>* 이메일</td>
							<td><form:input path="email" type="email" placeholder="이메일(@를 포함한 주소 입력)"/></td>
						</tr>						
					</table> -->
					<div class="signUpTerms">
						<input type="checkbox" name="term" id="term" value="agree"> 전체동의<br>
						<input type="checkbox" name="term" id="term" value="ageAgree"> 만 14세 이상입니다.(필수)<br>
						<input type="checkbox" name="term" id="term" value="serviceAgree"> 수원시 분실동물 찾기 서비스 이용약관 동의 (필수)<br>
						<input type="checkbox" name="term" id="term" value="infoAgree"> 개인정보 수집 이용 동의 (필수)<br>
					</div>
					<input type="submit" value="회원가입">
				</form:form>
			</div>			
		</div>
	</section>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>