<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../../resources/css/style.css?">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="../../../resources/script/script.js" defer></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>찾아가세요 수정하기</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	
	<div class="wrapboardPage">

		<div id="contentsTitle">
			<h3 class="contentsTitle">찾아가세요</h3>
			<div class="titleLine"></div>
		</div>
		
		<div class="wrapWritePage"> 
			<form:form commandName="findBoardWriteCommand" enctype="multipart/form-data">
				<table id="input-lostPageWrite">
					<tr>
						<td><span style="color: white;">*</span>작성자</td>
						<td>${detail.writer}</td>
					</tr>
					<tr>
						<td><span>*</span>글제목</td>
						<td><form:input path="title" value="${detail.title}"/></td>
					</tr>
					<tr>
						<td><span style="color: white;">*</span>품종</td>
						<td><form:input path="kind" value="${detail.kind}"/></td>
					</tr>
					<tr>
						<td><span>*</span>성별</td>
						<td><form:input path="gender" value="${detail.gender}"/></td>
					</tr>
					<tr>
						<td><span>*</span>발견위치</td>
						<td><form:input path="location" value="${detail.location}"/></td>
					</tr>
					<tr>
						<td><span>*</span>발견시각</td>
						<td><form:input path="findDate" value="${detail.findDate}"/></td>
					</tr>
					<tr>  
						<td><span>*</span>특징</td>
						<td><form:input path="character" value="${detail.character}"/></td>
					</tr>
					<tr>
						<td><span>*</span>연락처</td>
						<td><form:input path="phone" value="${detail.phone}"/></td>
					</tr>
					<tr>
						<td><span>*</span>이메일</td>
						<td><form:input path="email" value="${detail.email}"/></td>
					</tr>
					<tr>
						<td><span>*</span>상세내용</td>
						<td>
							<textarea id="memo" name="memo" rows="10" cols="65" onkeyup="javascript:fnChkByte(this,'2000')">${detail.memo}</textarea>
							<span id="byteInfo">0</span> / 2000bytes
						</td>
					</tr>
					<tr>
						<td>  사진첨부</td>
						<td>
							<c:if test="${not empty detail.originalFile}">
								<p id="preImg">
								<input type="hidden" name="originalFile" value="${detail.originalFile}">
									${detail.originalFile}									
									<a onclick="hideP()" style="cursor:pointer">
										<i class="far fa-trash-alt"></i><br>
									</a>
									<br>(새 파일을 등록하면 기존 파일은 삭제됩니다.)
								</p>
							</c:if>
							<input type="file" name="img" id="img" onchange="newImg()"/>
						</td>
					</tr>
				</table>				
				<div > <!-- 수정완료 버튼 -->
					<input type="submit" value="수정완료" class="completeBtn">
				</div>
			</form:form>
		</div>
	</div>
	
	<jsp:include page="../include/footer.jsp" />
	
	<button class="jellybutton topbtn" type="button" onclick="goTop()">TOP</button>
		<!-- Service Center 버튼 -->
		<!-- 내용 미정 -->
	<div class="centerbtn">		
		<div class="jellybutton centerHiddenContents guideHiddenContents" name="centerHidden" id="centerHidden"><p>GUIDE<BR>1. '*'는 필수 입력 사항 입니다.<br>2. 실종 위치 및 시각은 최대한 <BR>구체적으로 적어주세요.<br>ex) 15시 20분경 경기대 후문<br>3. 내용은 자유롭게 기재 하되, <BR>최대한 많은 내용을 기재 해 주셔야 발견 될 확률이 높습니다.</p></div>
		<button class="jellybutton sidebtn1" name="center" id="center">GUIDE</button>
	</div>
	
	<script>
		var preImg = document.getElementById('preImg');
		function hideP(){
			preImg.remove();
		};

		function newImg(){
			preImg.remove();
		};
	</script>
</body>
</html>