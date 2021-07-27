<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<nav>
    <div class="navInner">
        <div class="mainMenu">
            <ul>
                <li><a href="<c:url value='/lostPage/lostPage'/>">찾아주세요</a></li>
                <li><a href="<c:url value='/findPage/findPage'/>">찾아가세요</a></li>
                <li>Q&A</li>
            </ul>
        </div>
        <div class="search">
            <form action="#" >
                <input type="text" path="search" placeholder="검색어를 입력해주세요"/>
                <button><img src="resources/img/img-include/검색.png" style="width: 10px; background-color: white;"></button>
            </form>
        </div>
         <a href="#" class="navToggleBtn">
            <i class="fas fa-bars"></i></a> 
    </div>
</nav>