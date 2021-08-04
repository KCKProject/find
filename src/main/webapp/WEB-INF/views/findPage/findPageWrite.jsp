<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/style.css">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="../resources/script/script.js" defer></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>찾아가세요 글쓰기</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />

	<div class="wrap-all-findPageWirte">

		<div id="contentsTitle">
			<h3 class="contentsTitle">찾아가세요</h3>
			<div class="titleLine"></div>
		</div>
		
		<div class="wrapWritePage"> 
		<%--  enctype="multipart/form-data" 필요 --%>
			<form:form commandName="findBoardWriteCommand" name="input-findPageWrite">
				<table id="input-findPageWrite"> <!-- 입력칸 부분 -->
					<tr>
						<td><span>*</span>글제목</td>
						<td><form:input path="title" placeholder="글제목"/></td>
					</tr>
					<tr>
						<td><span style="color: white;">*</span>품종</td>
						<td><form:input path="kind" placeholder="품종"/></td>
					</tr>
					<tr>
						<td><span>*</span>성별</td>
						<td><form:input path="gender" placeholder="남아/여아(중성화수술 여부 까지 적어주세요)"/></td>
					</tr>
					<tr>
						<td><span>*</span>발견위치</td>
						<td><form:input path="location" placeholder="발견위치"/></td>
					</tr>
					<tr>
						<td><span>*</span>발견시각</td>
						<td><form:input path="findDate" placeholder="발견시각"/></td>
					</tr>
					<tr>  
					
						<td><span>*</span>특징</td>
						<td><form:input path="character" placeholder="특징(30자 이내)"/></td>
					</tr>
					<tr>
						<td><span>*</span>상세내용</td>
						<td><form:textarea path="memo" rows="100px" cols="30px" placeholder="상세내용"/></td>
					</tr>
					<%-- <tr>
						<td>  사진첨부</td>
						<td><form:file path="photo"/></td>
					</tr> --%>
				</table>

			<!-- 	<div> 첨부파일
					<div class="photofile-btn"></div>
				</div> -->
				<div> <!-- 약관 -->
					<div class="writeTerms">
						<label class="checkbox"><input type="checkbox" name="term" id="term" value="agree" class="AllOkay"><span class="icon"></span><span class="text">전체동의</span></label> 
						<label class="checkbox"><input type="checkbox" name="term" id="term" value="phoneAgree" class="okay"><span class="icon"></span><span class="text">연락처 노출 동의 
									<br>(회원가입 시 등록 한 연락처를 연락받을 번호로 기재 합니다. <span style="color: red; font-size: 20px;">*</span>미체크시 별도의 연락수단 상세내용에 기재 요망)<br> </span></label> 
						<label class="checkbox"><input type="checkbox" name="term" id="term" value="emailAgree" class="okay"><span class="icon"></span><span class="text">이메일 노출 동의 
									<br>(회원가입 시 등록 한 이메일을 연락받을 메일로 기재 합니다.)</span></label> 
					</div>
				</div>
				<div > <!-- 작성완료 버튼 -->
					<input type="submit" value="작성완료" class="completeBtn">
				</div>
			</form:form>
		</div>
	</div>
	
	<jsp:include page="../include/footer.jsp" />
	
	<script>
		$(function(){
		    $("[type=checkbox][name=term]").on("change", function(){
		        var check = $(this).prop("checked");
		        //전체 체크
		        if($(this).hasClass("AllOkay")){
		            $("[type=checkbox][name=term]").prop("checked", check);
	
		        //단일 체크
		        }else{ //3
		            var all = $("[type=checkbox][name=term].AllOkay");
		            var allcheck = all.prop("checked")
		            if(check != allcheck){ 
		                var len = $("[type=checkbox][name=term]").not(".AllOkay").length;
		                var ckLen = $("[type=checkbox][name=term]:checked").not(".AllOkay").length; 
		                if(len === ckLen){
		                    all.prop("checked", true);
		                }else{
		                    all.prop("checked", false);
		                }
		            }
		        }
		    });
		});
	</script>
</body>
</html>
