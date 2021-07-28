<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>

function del(boardNum) {
	var chk = confirm("정말 삭제하시겠습니까?");
	if (chk) {
		location.href="<c:url value='/lostPage/delete/'/>"+boardNum;
	}
}	
</script>
