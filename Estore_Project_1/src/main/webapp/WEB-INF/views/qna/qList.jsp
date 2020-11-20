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
</head>
<body>
<div align="center">
	<h3>All QnA</h3><br>
	<table class="table" id="table">
		<thead class="thead-dark">	  	
			<tr align="center">
				<th scope="col" align="center">NUM</th>
				<th scope="col">TITLE</th>
				<th scope="col">DATE</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${qlist }" var="list">
		<sec:authorize access="isAuthenticated()"> 
	 	 <sec:authentication property="principal.username" var="userName" />	  
			
				<tr>				
				 <c:if test="${userName==list.email }">			
					<td align="center">${list.qnum }</td>
					<td align="center"><a href ='/qna/detail/${list.qnum }' id="detail">
					<c:out value="${list.title }"/>
					<b> [<c:out value="${list.replyCnt }"/>]</b>
					</a></td>	
					<td align="center">${list.create_date }</td>
				 </c:if> 
				 </tr>
		</sec:authorize>
		<sec:authorize access=" isAnonymous()">
		
				<tr>
			 	<c:if test="${userName!=list.email }"> 
					 <td align="center" colspan="3">접근 권한이 없는 게시글입니다.</td>  
				 </c:if>
				</tr>
				</sec:authorize>
			</c:forEach> 		
	  	</tbody>
	</table>
</div>	  
		
	


 <%@include file ="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>