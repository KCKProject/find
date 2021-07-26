<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지_게시판 관리</title>
</head>
<body>
	<jsp:include page="../admin-include/adminHeader.jsp"></jsp:include>
	<jsp:include page="../admin-include/adminNav.jsp"></jsp:include>
    <div class="wrap">
        <table border="1">
            <tr>
                <td rowspan="2">
                    <h2>게시판 관리</h2>
                </td>
                <td>
                    <p>진행중 개 | 완료 개 | 전체 개</p> <!-- 읽어서 받아올수 있게 만들기 -->
                </td>
            </tr>
            <tr>
                <td>
                    <input type="date" name="startDate" id="startDate"> ~
                    <input type="date" name="endDate" id="endDate">
                    <input type="checkbox" name="all" id="all">전체
                    <input type="checkbox" name="proceeding" id="proceeding">진행중
                    <input type="checkbox" name="done" id="done">완료
                    <input type="text" name="search" id="search" placeholder="검색어를 입력해주세요"><a href=""><img src="" alt=""></a>
                </td>
            </tr>
            <tr>
                <td>
                    <h3>찾아주세요</h3><br>
                    <h3>찾아가세요</h3>
                </td>
                <td>
                    <table>
                        <tr>
                            <td>번호</td>
                            <td>완료</td>
                            <td>글제목</td>
                            <td>작성자</td>
                            <td>날짜</td>
                        </tr> 
                        <%-- <c:forEach var="t" items="text">   반복이용 해서 자동으로 받아오게 만들기
                        <tr>
                            <td>1</td> 
                            <td>V</td>
                            <td>글제목</td>
                            <td>작성자</td>
                            <td>날짜</td>
                        </tr>
                        </c:forEach> --%>
                    </table>
                    <div>	
                        <span onclick="alert('이전 페이지가 없습니다.');">이전</span>			
                    <c:set var = "page" value = "${(param.p==null)? 1: param.p}"/>
                    <c:set var ="startNum" value = "${page-(page-1)%5}"/>
                    <span>
                        <c:forEach var = "i" begin= "0" end = "4">
                            <a href="?p=${startNum+i}&t=&q=" >${startNum+i}</a>
                        </c:forEach>
                    </span>		
                        <span onclick="alert('다음 페이지가 없습니다.');">다음</span>			
                    </div>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>