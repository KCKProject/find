<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>questionPage</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<jsp:include page="../include/nav.jsp" />

	<div class="wrap-all-questionPage">

		<div class="wrap-questionPage"> 
			
			<div class="bx-question">
				<c:if test="${empty questions}">
					<ul>
						<li>등록된 QnA가 없습니다.</li>
					</ul>
				</c:if>
				<c:if test="${!empty questions}">
					<table>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
						</tr>
						<c:forEach var="q" items="${questions}">
							<tr>
								<td>${q.boardNum}</td>
								<td>${q.title }</td>
								<td>${q.writer}</td>
								<td><fmt:formatDate value="${q.writeDate}" pattern="yyyy-MM-dd"/></td>
							</tr>
							<!-- <tr>
								<td>1</td>
								<td>반려동물 분실 시 대처 방법</td>
								<td>김00</td>
								<td>2021-07-19</td>
							</tr>
							<tr>
								<td>2</td>
								<td>반려동물 분실 시 대처 방법</td>
								<td>김00</td>
								<td>2021-07-19</td>
							</tr>
							<tr>
								<td>3</td>
								<td>반려동물 분실 시 대처 방법</td>
								<td>김00</td>
								<td>2021-07-19</td>
							</tr>
							<tr>
								<td>4</td>
								<td>반려동물 분실 시 대처 방법</td>
								<td>김00</td>
								<td>2021-07-19</td>
							</tr>
							<tr>
								<td>5</td>
								<td>반려동물 분실 시 대처 방법</td>
								<td>김00</td>
								<td>2021-07-19</td>
							</tr> -->
						</c:forEach>
					</table>
				</c:if>
			</div>
		</div>
	</div>

	<jsp:include page="../include/footer.jsp" />
</body>
</html>
