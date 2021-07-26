<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<nav>
    <div class="navInner">
        <div class="mainMenu">
            <ul>
                <li>찾아주세요</li>
                <li>찾아가세요</li>
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