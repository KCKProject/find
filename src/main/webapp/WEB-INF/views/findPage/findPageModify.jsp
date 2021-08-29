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
						<td><strong>*</strong>글제목</td>
						<td>
							<form:input path="title" value="${detail.title}"/>
							<form:errors path="title"/>
						</td>
					</tr>
					<tr>
						<td><strong style="color: white;">*</strong>품종</td>
						<td><form:input path="kind" value="${detail.kind}"/></td>
					</tr>
					<tr>
						<td><strong style="color: white;">*</strong>성별</td>
						<td><form:input path="gender" value="${detail.gender}"/></td>
					</tr>
					<tr>
						<td><strong>*</strong>발견위치</td>
						<td>
							<form:input path="location" value="${detail.location}"/>
							<form:errors path="location"/>
						</td>
					</tr>
					<tr>
						<td><strong>*</strong>발견시각</td>
						<td>
							<form:input path="findDate" value="${detail.findDate}"/>
							<form:errors path="findDate"/>
						</td>
					</tr>
					<tr>  
						<td><strong>*</strong>특징</td>
						<td>
							<form:input path="character" value="${detail.character}" onkeyup="javascript:fnChkByte(this,'25')"/>
							<form:errors path="character"/>
						</td>
					</tr>
					<tr>
						<td><span style="color: white;">*</span>연락처</td>
						<td><form:input path="phone" value="${detail.phone}"/></td>
					</tr>
					<tr>
						<td><span style="color: white;">*</span>이메일</td>
						<td><form:input path="email" value="${detail.email}"/></td>
					</tr>
					<tr>
						<td><span style="color: white;">*</span>상세내용</td>
						<td>
							<textarea id="memo" name="memo" rows="10" cols="65" onkeyup="javascript:fnChkByte(this,'2000')">${detail.memo}</textarea><br>
							<span id="byteInfo">0</span> / 2000bytes
						</td>
					</tr>
					<tr>
						<td>  사진첨부</td>
						<td>
							<p name="add"><i class="fas fa-plus"></i> 파일추가 (jpg, png, jpeg)</p>
						</td>
					</tr>
					<c:forEach var="i" items="${imgs}" varStatus="statusNum">
						<tr>
							<td></td>
							<td>
								<input type="hidden" name="originalFile" id="originalFile" value="${i.storedFileName}"/>
								<label for="img">
									등록된 파일 : ${i.originalFile}
								</label>								
								<a class="del" style="cursor:pointer">
									<i class="far fa-trash-alt"></i><br>
								</a>
							</td>
						</tr>
					</c:forEach>
				</table>				
				<div > <!-- 수정완료 버튼 -->
					<input type="submit" value="수정완료" class="completeBtn" onclick="return imgCheck()">
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
		$(function(){
			// 파일 추가 버튼
	    	$("table").on("click", "p[name='add']", function (){
	    		var num = $("table").find("tr").length;
	    		if(num==14){
	    			alert('파일은 3개까지 등록할 수 있습니다.');
	    		}else{
	    			var addForm = "<tr>";
	    			addForm += "<td></td>";
	    			addForm += "<td>";
	    			addForm += '<input type="file" class="newImg" id="img" name="img" accept=".jpg, .jpeg, .png"/>';
	    			addForm += '<a class="del" style="cursor:pointer">';
	    			addForm += '<i class="far fa-trash-alt"></i><br>';
	    			addForm += "</a>";
	    			addForm += "</td></tr>";
		    		$("table").append(addForm);
	    		}
	    	});
			
	    	// 등록 파일 제거
		    $('table').on("click",".del",function(){
		    	$(this).parent().parent().remove();
		    });    	
		});
		
		// 첨부파일 null 체크
		function imgCheck(){
			var num = $("table").find("tr").length;
			if(num==11){
				alert("첨부파일 최소 한개를 등록해주세요.");
				return false;
			}
			
			var ex = document.getElementsByClassName('newImg');
			if(ex.length!=0){
				for(var i=0;i<ex.length;i++){
					if(ex[i].files.length==0){
						alert('파일을 선택해주세요.');
						return false;
					}
				}
			}
			document.getElementById('form').submit();
		};
	</script>
</body>
</html>