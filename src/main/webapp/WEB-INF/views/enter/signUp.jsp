<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
								<form:input path="userId" placeholder="아이디" check_result="fail" requried="requried" onkeyup="javascript:fnChkByte(this,'12')"/>
								<form:errors path="userId"/>
								<br>
								<a class="idChk" onclick="idChk()" style="cursor:pointer">중복 체크</a>
								<i class="fas fa-check" id="idOk" style="display:none"></i>
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
								<form:input path="phone" placeholder="-(하이픈)을 포함한 전체 전화번호를 입력해주세요" />
								<form:errors path="phone"/>
							</p>
							<p>
								<form:input path="email" type="email" placeholder="@를 포함한 이메일 주소를 입력해주세요"/>
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
		function idChk(){
			/* $('#idOk').hide();
			$('.idChk').show();
			$('#userId').attr("check_result", "fail"); */
			
			var userId=$("#userId").val();
			console.log(userId);
			//var $('.signUpCommandBox').children
			$.ajax({
				type : "GET",
				url : "signUpIdChk",
				data : {"userId" : userId},
				success : function(result){
					var msg;
					console.log("result : "+result);
					
					switch(result){					
						case 1 : //동일 아이디 존재
							msg = "아이디가 이미 존재합니다.";
							break;
						case 0 : //아이디 사용 가능
							msg = "해당 아이디는 사용 가능합니다.";
							$("#idChk").hide();
							$('.idChk').show();
							break;
					}
				alert(msg);
				},
				error : function(){
					console.log("ajax 통신 실패")
				}
			});
		};
		
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