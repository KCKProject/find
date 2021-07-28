<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<spring:url value='/resources/css/style.css?'/>">
<title>회원가입</title>
<script type="text/javascript" src="<spring:url value='/resources/script/script.js'/>"></script>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<section class="sectionSignUp">
		<div class="signUpInner">
			<h3 class="signUpTitle">회원가입</h3>
			<div class="signUpBox">
				<form:form commandName="signUpCommand" class="signUpCommand">
					<div class="signUpCommandWrap">
						<div class="signUpCommandTitle">
							<p><strong>*</strong> 아이디</p>
							<p><strong>*</strong> 비밀번호</p>
							<p><strong>*</strong> 비밀번호 확인</p>
							<p><strong>*</strong> 이름</p>
							<p><strong>*</strong> 연락처</p>
							<p><strong>*</strong> 이메일</p>
						</div>
						<div class="signUpCommandBox">
							<p>
								<form:input path="userId" placeholder="아이디" requried="requried"/>
								<form:errors path="userId"/>
							</p>
							<p>
								<form:password path="userPassword" placeholder="비밀번호(영문,숫자,특수문자 조합 6~15자리)" />
								<form:errors path="userPassword"/>
							</p>
							<p>
								<form:password path="userPwdChk" placeholder="비밀번호 확인" />
								<form:errors path="userPwdChk"/>
							</p>
							<p>
								<form:input path="userName" placeholder="이름" />
								<form:errors path="userName"/>
							</p>
							<p>
								<form:input path="phone" placeholder="연락처" />
								<form:errors path="phone"/>
							</p>
							<p>
								<form:input path="email" type="email" placeholder="이메일(@를 포함한 주소 입력)"/>
								<form:errors path="email"/>
							</p>
						</div>
					</div>
					<div class="signUpTerms">
					
						<div class="checkbox">
							<input type="checkbox" name="term" id="ageAgree" value="ageAgree"> 
							<span class="icon"></span>
							<span class="text"><label for="ageAgree">만 14세 이상입니다.(필수)</label></span>
						</div>
						<div class="checkbox">
							<input type="checkbox" name="term" id="infoAgree" value="infoAgree"> 
							<span class="icon"></span>
							<span class="text"><label for="infoAgree">개인정보 수집 이용 동의 (필수)</label></span>
						</div>
						<div class="checkbox">
							<input type="checkbox" name="term" id="term" value="addAgree" required oninvalid="this.setCustomValidity('필수 체크사항')" oninput="setCustomValidity('')"> 
							<span class="icon"></span>
							<span class="text"><label for="term">추가추가</label></span>
						</div>
						
						<!--
						<label>
							<input type="checkbox" name="term" id="term" value="addAgree" required oninvalid="this.setCustomValidity('필수 체크사항')" oninput="setCustomValidity('')">추가추가
						</label>
						<input type="checkbox" name="term" id="term" value="ageAgree" required oninvalid="this.setCustomValidity('필수 체크사항입니다')" oninput="setCustomValidity('')"> 만 14세 이상입니다.(필수)<br>
						 <input type="checkbox" name="term" id="term" value="serviceAgree" required> 수원시 분실동물 찾기 서비스 이용약관 동의 (필수)<br> 
						<input type="checkbox" name="term" id="term" value="infoAgree" required oninvalid="this.setCustomValidity('필수 체크사항입니다')" oninput="setCustomValidity('')"> 개인정보 수집 이용 동의 (필수)<br> -->
					</div>
					<div class="signUpBoxbtn">
						<input type="submit" value="회원가입" onclick="signUpChk()">
					</div>
				</form:form>
			</div>			
		</div>
	</section>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>