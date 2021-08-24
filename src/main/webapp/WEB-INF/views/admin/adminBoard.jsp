<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/style.css">
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script src="https://kit.fontawesome.com/2d323a629b.js"
   crossorigin="anonymous"></script>
<script src="resources/script/script.js" defer></script>
<title>관리자 페이지_게시판 관리</title>
</head>
<body>
   <jsp:include page="../admin-include/adminHeader.jsp"></jsp:include>
   <jsp:include page="../admin-include/adminNav.jsp"></jsp:include>
   <div class="adminWrap">
      <div class="left">
         <div>
            <p class="adminTitle">게시판 관리</p>
         </div>
         <div>
            <ul>
               <a href="<c:url value='/admin/adminBoard'/>"><li>찾아주세요</li></a>
               <a href="<c:url value='/admin/adminFindBoard'/>"><li>찾아가세요</li></a>
            </ul>
         </div>
      </div>

      <span class="line"></span>

      <div class="right">
         <div>
            <p>미완료 ${pageMaker.incompleteCount}개 | 완료 ${pageMaker.completeCount}개 | 
            전체${pageMaker.totalCount}개 
	            <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}" placeholder="글제목으로 검색"/>
				<button id="searchBtn" onclick=""><img
				src="../resources/img/search.png" alt="검색" width="15px"
				height="15px"></button>
			</p>
            <!-- 읽어서 받아올수 있게 만들기 -->
         </div>
     <%--     <div>
          	<form:form commandName="dateSearchCommand" method="GET">
            	<form:input path="from" type="date" value="2021-07-01" id="from"/> ~ 
            	<form:input path="to" type="date" value="" id="to"/>
            	<input type="submit" value="조회" />
            </form:form>
            <input type="text" id="form" value="${dsc.from}"/>
            <input type="text" id="to" value="${dsc.to}"/>
            <button id="searchBtn" onclick=""><img
						src="../resources/img/search.png" alt="검색" width="15px"
						height="15px"></button>
			
           <!--  <label class="checkbox"><input type="checkbox" name="all" id="all"><span class="icon"></span><span class="text">전체</span></label>
            <label class="checkbox"><input type="checkbox" name="proceeding" id="proceeding"><span class="icon"></span><span class="text">진행중</span></label> 
            <label class="checkbox"><input type="checkbox" name="done" id="done"><span class="icon"></span><span class="text">완료</span></label>  -->
         </div> --%>
         <div> <!-- 찾아주세요 -->
            <c:if test="${!empty losts}">
               <table class="adminContents">
                     <tr class="adminContentsListTitle">
                        <td>번호</td>
                        <td>글제목<span class="clickText clickTextDisplay">click</span></td>
                        <td>완료</td>
                        <td>작성자</td>
                        <td>날짜</td>
                     </tr>
                     <c:forEach var="m" items="${losts}">
                        <tr>
                           <td>${m.boardNum}</td>
                           <td>
                           		<a href="<c:url value="/admin/lostBoardDetail/${m.boardNum}"/>">${m.title}</a>
                           	</td>
	                           <c:if test="${m.meet ==1}">
	                              <td>완료</td>
	                           </c:if>
	                           <c:if test="${m.meet ==0}">
	                              <td>미완료</td>
	                           </c:if>
                           <td>${m.writer}</td>
                           <td><fmt:formatDate value="${m.writeDate}" pattern="yyyy-MM-dd"/></td>
                        </tr>
                     </c:forEach>
               </table>
               <div class="paging">
                  <ul>
                       <c:if test="${pageMaker.prev}">
                           <li><a href="${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
                       </c:if>
                       <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
                           <li><a href="${pageMaker.makeSearch(idx)}">${idx}</a></li>
                       </c:forEach>
                       <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                           <li><a href="${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
                       </c:if> 
                   </ul>
               </div>
            </c:if>
         </div> <!-- 찾아주세요 -->
         <div> <!-- 찾아가세요 -->
            <c:if test="${!empty finds}">
               <table class="adminContents">
                  <tr class="adminContentsListTitle">
                     <td>번호</td>
                     <td>글제목<span class="clickText clickTextDisplay">click</span></td>
                     <td>완료</td>
                     <td>작성자</td>
                     <td>날짜</td>
                  </tr>

                  <c:forEach var="f" items="${finds}">
                     <tr>
                        <td>${f.boardNum}</td>
                        <td class="adminBoardClickHere">
                        	<a href="<c:url value="/admin/findBoardDetail/${f.boardNum}"/>">${f.title}</a>
                        </td>
                        	<c:if test="${f.meet ==1}">
	                           <td>완료</td>
	                        </c:if>
	                        <c:if test="${f.meet ==0}">
	                           <td>미완료</td>
	                        </c:if>
                        <td>${f.writer}</td>
                        <td><fmt:formatDate value="${f.writeDate}" pattern="yyyy-MM-dd"/></td>
                     </tr>
                  </c:forEach>
               </table>
            <div class="paging">
               <ul>
                    <c:if test="${pageMaker.prev}">
                        <li><a href="${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
                    </c:if>
                    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
                        <li><a href="${pageMaker.makeSearch(idx)}">${idx}</a></li>
                    </c:forEach>
                    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                        <li><a href="${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
                    </c:if> 
                </ul>
            </div>
            </c:if>
         </div> <!-- 찾아주세요 -->
      </div>
   </div>
</body>
<script>
/* document.getElementById('to').valueAsDate = new Date(); */
$(function(){
  	$('#searchBtn').click(function() {
  			self.location = "" + '${pageMaker.makeSearch(1)}' + encodeURIComponent($('#keywordInput').val());
	});
 }); 
</script>
</html>