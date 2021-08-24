<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찾아주세요</title>
<link rel="stylesheet" href="../../resources/css/style.css">
<script src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin="anonymous"></script>
<script src="../../resources/script/script.js" defer></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="../include/header.jsp" />

	<div class="wrapboardPage">
	
		<div id="contentsTitle">
			<h3 class="contentsTitle">(실종) ${detail.title}</h3>
			<div class="boardDetailPageLine"></div>
		</div>

		<div class="wrap-lostPage"> 
			
			<div class="boardPage-contents">
				<ul>
					<li class="post-photo-top">
						<img src="../../resources/imgUpload/${detail.storedFileName}" style="cursor:pointer"/>
					</li>
					<li class="post-photo-top"></li>
					<li class="post-photo-top"></li>
				</ul>
				<div class="post-contents-bottom"> 
					<!-- 게시글 내용 나오는 부분 -->
					<c:if test="${detail.meet==1}">
						<div>
							<p class="finishText">발견완료</p>
						</div>
					</c:if>
					<div class="userid-writetime-anumber-view">
						<p>${detail.writer}님 | ${detail.writeDate} | 등록번호 ${detail.boardNum} | 조회 ${detail.hit}</P>
					</div>
					<div class="animalName">
						<p>이름 | ${detail.animal}</p>
					</div>
					<div class="kind">
						<p>품종 | ${detail.kind}</p>
					</div>
					<div class="gender">
						<p>성별 | ${detail.gender}</p> <!-- ex)남아 중성화수술 함 -->
					</div>
					<div class="location">
						<p>실종 위치 | ${detail.location}</p>
					</div>
					<div class="lostDate">
						<p>실종 시각 | ${detail.lostDate}</p>
					</div>
					<div class="character">
						<p>특징 | ${detail.character}</p>
					</div>
					<div class="phone">
						<p>연락처 | ${detail.phone}</p>
					</div>
					<div class="email">
						<p>이메일 | ${detail.email}</p>
					</div>
					<div class="memo">
						<p style="white-space: pre-line;">${detail.memo}</p>
					</div>

					<c:if test="${detail.meet==1 and not empty detail.review}">
						<div class="reviewContents">
							<p style="white-space: pre-line;">
								<i class="fas fa-quote-left"></i>${detail.review}<i class="fas fa-quote-right"></i>
							</p>
						</div>
					</c:if>
				</div>
			</div>
			
			<div class="wrap-btns">
				<!-- 버튼들 모음 -->
				<!-- 로그인한 사람이 본인 글에 들어왔을때만 보이는 버튼들 추가 -->
				<button class="btn btn-swap" name="toList" id="toList" onclick="location='<c:url value="/lostPage/lostPageList"/>'" >목록으로<span>목록으로 >></span></button>
				<c:if test="${memberAuthInfo.userId eq detail.writer}">
					<button class="btn btn-swap" name="delete" id="delete" onclick="del(${detail.boardNum})">글삭제<span>글삭제 >></span></button>
					<button class="btn btn-swap" name="modify" id="modify" onclick="location='<c:url value="/lostPage/lostPageWrite/modify/${detail.boardNum}"/>'">글수정<span>글수정 >></span></button>
					
					<!-- 발견완료 체크유무에 따른(=meet 컬럼 값에 따른) 버튼 종류의 차이 -->
					<c:choose>
						<c:when test="${detail.meet eq 0}">
							<button class="btn btn-swap" name="meet" id="meet"
								onclick="location='<c:url value="/lostPage/changeMeet/${detail.boardNum}&${detail.meet}"/>'">
								발견완료<span>변경 >></span>
							</button>
						</c:when>
						<c:when test="${detail.meet eq 1}">
							<button class="btn btn-swap" name="meet" id="meet"
								onclick="location='<c:url value="/lostPage/changeMeet/${detail.boardNum}&${detail.meet}"/>'">
								미발견<span>변경 >></span>
							</button>
						</c:when>
					</c:choose>
				</c:if>
			</div>
			
			<div class="review">
				<form method="POST" action="/KCK_find/lostPage/lostPageWrite/review">
					<h2>후기를 남겨주세요! 찾은 장소나 위치, 그리고 찾게 된 경로 등을 상세히 적어 주시면 많은 도움이 됩니다.</h2>
					<input type="hidden" name="boardNum" value="${detail.boardNum}" />
					<textarea name="review" rows="10" cols="30" onkeyup="javascript:fnChkByte(this,'2000')">${detail.review}</textarea>
<!-- 					<span id="byteInfo">0</span> / 2000bytes -->
					<input type="submit" value="작성완료" class="completeBtn"> 
				</form>
			</div>
			
			<div class="wrap-comment">
				<div class="lostPage-comment-top">
					<h4>댓글을 남겨주세요 !</h4>
					<p>*댓글을 남겨주세요! 여러분의 작은 관심이 희망의 끈이 됩니다. 욕설/명예훼손의 글은 동의 없이 삭제됩니다.</p>
				</div>
				
				<!-- 댓글 리스트 -->
				<div class="lostPage-comment-bottom">
					<div id="lostPage-comment-bottom">
						<ul>
							<c:forEach var="c" items="${cList}">
								<li>									
									<p class="con">${c.content}</p>
									<p>${c.writer} | ${c.writeDate}</p>									
								</li>
								<div>
									<input type="hidden" class="cNum" value="${c.cNum}">												
									<c:if test="${c.writer==memberAuthInfo.userId}">
	           						<button class="commentBtn commentMod"><i class="fas fa-pencil-alt"></i><p>수정</p></button>
	           						<button class="commentBtn commentDel"><i class="fas fa-trash-alt"></i><p>삭제</p></button>
	           						</c:if>
	           					</div>
							</c:forEach>
						</ul>
					</div>
					
					<!-- 댓글 변경 영역 -->
					<div id="comment-modify" style="display:none; width:90%">
						<input type="text" id="modifyContent" style="width:110%"></input>
						<button class="commentBtn commentModFin" id="commentModFin" style="display:none"><i class="fas fa-check"></i><p>완료</p></button>
					</div>
					
					<!-- 댓글 등록 영역 -->
					<div>
						<textarea rows="10" cols="10" id="content"></textarea>
					</div>					
					<div class="mainMore">
						<!-- 댓글등록 버튼 -->

	                    <a class="btn btn-swap" name="uploadComment" id="uploadComment">
	                        upload <span>등록 >></span>
	                    </a>
                	</div>
				</div> 
			</div>
		</div>
	</div>

	<jsp:include page="../include/footer.jsp" />
	<button class="jellybutton topbtn" type="button" onclick="goTop()">TOP</button>
	<!-- 글쓰기 버튼 -->
	<!-- 예정) 로그인안한 회원은 로그인 페이지로 연결되도록 수정할 예정 -->
	<c:if test="${memberAuthInfo == null }">
		<div class="centerbtn">		
			<div class="jellybutton centerHiddenContents" name="centerHidden" id="centerHidden">
				<p>
					INFO<br>! 로그인 후 글쓰기 가능 합니다.<br>
					! 아이디 | 비밀번호 분실 시 로그인<br>
					페이지 하단의 찾기 버튼 클릭
				</p>
			</div>
			<button class="jellybutton sidebtn1" name="write" id="write" >WRITE</button>
		</div>
	</c:if>
	<c:if test="${memberAuthInfo != null }">
		<button class="jellybutton sidebtn1" name="write" id="write" onclick="location='<c:url value="/lostPage/lostPageWrite"/>'">WRITE</button>
	</c:if>
	
	<!-- 리뷰버튼 -->
	<c:if test="${memberAuthInfo.userId eq detail.writer}">
		<c:if test="${detail.meet eq 1}">
			<div class="centerbtn">
				<div class="jellybutton centerHiddenContents reviewHiddenContents" name="centerHiddenContents" id="centerHiddenContents">
					<p>
						INFO<br>! 리뷰를 작성해주세요 <br>
						! 리뷰 버튼 클릭 시 리뷰 작성  혹은 수정 가능 합니다.
					</p>
				</div>
				<button class="jellybutton sidebtn7 reviewToggleBtn" name="review" id="review" onclick="window.scrollTo(800,800)">REVIEW</button>
			</div>
		</c:if>
	</c:if>
	
	
	<script>
	$(document).ready(function() {
		// 댓글 쓰기 버튼 클릭 시
		$("#uploadComment").on("click", function(){
			if(!'${memberAuthInfo.userId}'){
				alert("로그인 후 이용가능합니다.");
			}else{
				var text=$("#content").val();
				var bno=${detail.boardNum};
				var writer="${memberAuthInfo.userId}";
				$.ajax({
					type : "POST",
					url : "writeComment",
					data : {"writer" : writer,
                			"bno" : bno,
                       		"text" : text},
					success : function(result){
		                var msg;

		                switch(result) {
		                case 1 :  //성공
		                msg = "댓글이 등록되었습니다.";
		                // 내용을 작성한 textarea를 다 지워줌
		                $("#content").val("");
		                selectRlist(); // selectRlist()함수 호출
		                break;
   
		                case 0 :  //등록실패
		                	msg = "댓글 등록에 실패했습니다.";
		                    break;
		                }
	                    alert(msg);
	                },
	                error : function(){
	                	console.log("ajax 통신 실패");
	                }
				});
			}
		});
		
		// 댓글 수정
		$("#lostPage-comment-bottom").on("click", ".commentMod", function modifyClick(){
			var div = $("#comment-modify");
			var num = div.children().length;
			var li = $(this).prev().prev();
			var ul = li.parent();
			var mod_con = ul.find("#modifyContent");
			var move = ul.find("#commentModFin");
			
			if(!num){
				div.prepend(mod_con);
				div.prepend(move);
				selectRlist();
				
				modifyClick();
			}
			
			
			var li = $(this).prev().prev();
			var con = li.children('.con').text();
			var p = li.children('p');
			var cArea = $("#modifyContent");
			var fin = $("#commentModFin");			
			var ul = li.parent();			
			var allLi = ul.children('li');
			var input = allLi.children('input');			
			
			if(move.text()===""){
				li.prepend(cArea);
				p.hide();
				$(this).after(fin);
				$(this).hide();
				fin.show();
				cArea.show();
				cArea.val(con);
			}
});
		
		$("#lostPage-comment-bottom").on("click", ".commentModFin", function(){
			
			var content = $('#modifyContent').val();
			var input = $(this).prev().prev();
			var cNum = input.val();
			var c = $("#modifyContent");
			var div = $("#comment-modify");
			var but = $("#commentModFin");
			
			$.ajax({
				type : "POST",
				url : "modifyComment",
				data : { "cNum" : cNum,
						 "content" : content},
				success : function(result){
					var msg;
					
					switch(result){
					case 1: //성공
						msg = "댓글이 수정되었습니다.";
						div.prepend(c);
						div.prepend(but);
						//c.hide();
						selectRlist();
						break;
					
					case 0: //실패
						msg = "댓글 수정에 실패했습니다.";
						break;
					}
				alert(msg);
				},
				error: function(){
					console.log("ajax 통신 실패");
				}
			});
		});
	
		// 댓글 삭제
		$("#lostPage-comment-bottom").on("click", ".commentDel", function(){
			var chk = confirm("정말 삭제하시겠습니까?");
			if (chk) {
				var input = $(this).prev().prev();
				var cNum = input.val();
				alert('cNum : '+cNum);
				
				$.ajax({
					type : "GET",
					url : "deleteComment",
					data : {"cNum":cNum},
					success : function(result){
						if(result==1){
							alert("삭제 되었습니다.");
							selectRlist()
						}
					}
				});
			}
		});
		
		// 댓글 목록 조회 함수
	    function selectRlist() {
	    	var bNo = "${detail.boardNum}";
	        
	        $.ajax({
	        	url : "commentList",
	            type : "POST",
	            data : {"bNo" : bNo},
	            dataType : "json",
	            success : function(cList){
	            	var output = "<ul>";
	            	for(var i in cList){
	            		output += "<li>";
	            		output += "<p class='con'>"+cList[i].content+"</p>";
	            		output += "<p>"+cList[i].writer+" | "+cList[i].writeDate+"</p>";
	            		output += "</li>";
	            		output += '<input type="hidden" value="'+cList[i].cNum+'">'
	            		if(cList[i].writer=="${memberAuthInfo.userId}"){
	            			output += '<button class="commentBtn commentMod"><i class="fas fa-pencil-alt"></i><p>수정</p></button>'; 
	            			output += '<button class="commentBtn commentDel"><i class="fas fa-trash-alt"></i><p>삭제</p></button>';
	            		}	            		
	            	}
	            	output += "</ul>";
	            	$("#lostPage-comment-bottom").html(output);
	            },
	            error : function(){
	            	console.log("댓글 목록 조회 ajax 통신 실패");
	            }
	        });
	    }
	});
	
	///////////////////////////////////////////////////////////
	
	// 게시글 삭제
	function del(boardNum) {
		var chk = confirm("정말 삭제하시겠습니까?");
		if (chk) {
			location.href="<c:url value='/lostPage/delete/'/>"+boardNum;
			alert("게시글이 삭제되었습니다.");
		}
	}
	
	function onClickHandler(meet) {
		alert(meet)
	}

	// 이미지 클릭시 원본 크기로 팝업 보기
	var img = document.getElementsByTagName("img");
    for (var x = 0; x < img.length; x++) {
      img.item(x).onclick=function() {window.open(this.src)}; 
    }
	</script>
</body>
</html>
