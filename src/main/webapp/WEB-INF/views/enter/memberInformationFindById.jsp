<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<spring:url value='/resources/css/style.css'/>">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="<spring:url value='/resources/script/script.js'/>" defer></script>
<title>아이디 찾기</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<section class="sectionLogin">
		<div class="wrap-memberInformationFind">
			<h3 class="loginTitle"><!-- 로그인 --></h3>
			<div class="loginBox memberInformationFindBox memberInformationFindBox-id" >
				<form:form commandName="member" enctype="multipart/form=data" method="POST" onsubmit="chk()">
					<form:input path="phone" placeholder="전화번호(ex. 010-1111-1111 형식으로 기재)" id="phone" value="" required="" />
					<form:input path="email" placeholder="이메일주소" id="email" value="" required="" />
					<input type="submit" value="찾기" class="loginBoxbtn">
				</form:form>
			</div>
		</div>
	</section>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>

<script type="text/javascript">
function chk(){
	if(document.getElementById("phone").value ==""){
		alert("전화번호를 입력해주세요.");
		return false;
	}
	if(document.getElementById("email").value ==""){
		alert("이메일 주소를 입력해주세요.");
		return false;
	}
}
</script>
</html>
