<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#frm{
	align:center;
}
#table{
	width:70%;
}
a{
	color:black;
}
a:hover {color:blue; text-decoration: underline; }
</style>
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>

</head>
<body>
<div align="center">
	<h3>All Review</h3><br>
	<table class="table" id="table">
		<thead class="thead-dark">	  	
			<tr align="center">
				<th scope="col" align="center">NUM</th>
				<th scope="col">TITLE</th>
				<th scope="col">RATE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${rlist }" var="list">
				<tr>
				<sec:authentication property="principal.username" var="userName" />	
				<c:if test="${userName==list.email }">
					<td align="center">${list.rnum }</td>
					<td align="center"><a href ='/review/detail/${list.rnum }/${list.pnum}'>${list.title }</a></td>	
					<td align="center"><c:forEach var="rating" items="${ratingOptions}" varStatus="status" begin="1" end="${list.rate}" >★</c:forEach></td>					
				</c:if>
				<c:if test="${userName!=list.email }">
					<td align="center">${list.rnum }</td> 
					<td align="center">접근 권한이 없는 게시글입니다.</td> 
				</c:if>
				</tr>
			</c:forEach>   
	  	</tbody>
	</table>
</div>	  
		
	
	
	<%-- 	<sec:authorize access="hasRole('ROLE_ADMIN') and isAuthenticated()">
			<a href="notice/insert">Write notice</a>
		</sec:authorize>   --%>
 


 <%@include file ="/WEB-INF/views/include/footer.jsp" %>
</body>

</html>