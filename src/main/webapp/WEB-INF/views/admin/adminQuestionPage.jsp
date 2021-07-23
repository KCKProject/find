<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지_회원관리</title>
</head>
<body>
	<jsp:include page="../decoration/adminHeader.jsp"></jsp:include>
	<jsp:include page="../decoration/adminNav.jsp"></jsp:include>
    <div class="wrap">
        <table border="1">
            <tr>
                <td rowspan="2">
                    <h2>Q&A 관리</h2>
                </td>
                <td>
                    <p>Q&A 개</p>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="date" name="startDate" id="startDate"> ~
                    <input type="date" name="endDate" id="endDate">
                    <input type="checkbox" name="all" id="all">전체
                    <input type="checkbox" name="userDate" id="userDate">기간
                    <input type="checkbox" name="userName" id="userName">이름
                    <input type="text" name="search" id="search" placeholder="검색어를 입력해주세요"><a href=""><img src="" alt=""></a>
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <table>
                        <tr>
                            <td>번호</td>
                            <td>작성자</td>
                            <td>글제목</td>
                            <td>작성일</td>
                            <td>공개</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>홍길동</td>
                            <td>~~방법은?</td>
                            <td>2020-07-20</td>
                            <td>공개</td>
                        </tr>
                    </table>
                    <input type="button" value="글쓰기">
                    <div>	
                        <span onclick="alert('이전 페이지가 없습니다.');"><<</span>			
                    <c:set var ="page" value = "${(param.p==null)? 1: param.p}"/>
                    <c:set var ="startNum" value = "${page-(page-1)%5}"/>
                    <span>
                        <c:forEach var = "i" begin= "0" end = "4">
                            <a href="?p=${startNum+i}&t=&q=" >${startNum+i}</a>
                        </c:forEach>
                    </span>		
                        <span onclick="alert('다음 페이지가 없습니다.');">>></span>			
                    </div>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>