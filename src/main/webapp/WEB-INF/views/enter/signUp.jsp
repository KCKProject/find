<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<spring:url value='/resources/css/style.css'/>">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="<spring:url value='/resources/script/script.js'/>" defer></script>
<title>회원가입</title>
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
			
 					<label class="checkbox" for="ageAgree">
                     	<input type="checkbox" name="term" id="ageAgree" value="ageAgree" >
           				<span class="icon"></span>
                     	<span class="text">만 14세 이상입니다.(필수)</span>
                 	</label>
                  	<label class="checkbox" for="infoAgree">
                     	<input type="checkbox" name="term" id="infoAgree" value="infoAgree" > 
                     	<span class="icon"></span>
                     	<span class="text">개인정보 수집 이용 동의 (필수)</span>
                  	</label>
						
					</div>
					<div class="signUpBoxbtn">
						<!-- <input type="submit" value="회원가입" onclick="signUpChk()">	 -->
						<input type="button" value="회원가입" onclick="signUpChk()">
					</div>
				</form:form>
			</div>			
		</div>
	</section>
	<jsp:include page="../include/footer.jsp"></jsp:include>
	<script type="text/javascript">
		function signUpChk(){
			var ageAgree = document.getElementById("ageAgree");
			var infoAgree = document.getElementById("infoAgree");
			if(!ageAgree.checked){
				alert("필수사항을 체크해주세요")
				return false;
			}
			if(!infoAgree.checked){
				alert("필수사항을 체크해주세요")
				return false;
			}
			document.getElementById('signUpCommand').submit();
			return false;
		}
	</script>
</body>
</html>