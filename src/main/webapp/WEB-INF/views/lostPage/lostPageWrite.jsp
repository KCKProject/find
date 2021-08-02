<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lostPage</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<jsp:include page="../include/nav.jsp" />

	<div class="wrap-all-lostPageWirte">

		<div class="title-lostPageWrite"> <!-- 상단 찾아주세요 문구 -->
			<h2>찾아주세요</h2>
		</div>
		<div class="input-lostPageWrite"> 
		<%--  enctype="multipart/form-data" 필요 --%>
			<form:form commandName="lostBoardWriteCommand" name="input-lostPageWrite">
				<table id="input-lostPageWrite"> <!-- 입력칸 부분 -->
					<tr>
						<td>* 글제목</td>
						<td><form:input path="title" placeholder="글제목"/></td>
					</tr>
					<tr>
						<td>  동물이름</td>
						<td><form:input path="animal" placeholder="동물이름 ex.마루, 초코..."/></td>
					</tr>
					<tr>
						<td>  품종</td>
						<td><form:input path="kind" placeholder="품종"/></td>
					</tr>
					<tr>
						<td>* 성별</td>
						<td><form:input path="gender" placeholder="남아/여아(중성화수술 여부 까지 적어주세요)"/></td>
					</tr>
					<tr>
						<td>* 실종위치</td>
						<td><form:input path="location" placeholder="실종위치"/></td>
					</tr>
					<tr>
						<td>* 실종시각</td>
						<td><form:input path="lostDate" placeholder="실종시각"/></td>
					</tr>
					<tr>  
					
						<td>* 특징</td>
						<td><form:input path="character" placeholder="특징(30자 이내)"/></td>
					</tr>
					<tr>
						<td>* 상세내용</td>
						<td><form:input path="memo" rows="10" cols="100" placeholder="상세내용"/></td>
				
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
						<input type="checkbox" name="term" id="term" value="agree" class="AllOkay"> 전체동의<br> 
						<input type="checkbox" name="term" id="term" value="phoneAgree" class="okay"> 연락처 노출 동의<br>
									(회원가입 시 등록 한 연락처를 연락받을 번호로 기재 합니다. 미체크시 별도의 연락수단 상세내용에 기재 요망)<br> 
						<input type="checkbox" name="term" id="term" value="emailAgree" class="okay"> 이메일 노출 동의<br>
									(회원가입 시 등록 한 이메일을 연락받을 메일로 기재 합니다.)<br>
					</div>
				</div>
				<div> <!-- 작성완료 버튼 -->
					<input type="submit" value="작성완료">
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
