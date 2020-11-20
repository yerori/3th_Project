<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
   <head>
      <script src="//code.jquery.com/jquery.min.js"></script>
      
       <!--<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" type="text/css" />-->
      <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script> 
      <meta charset="utf-8">
      <title>JS Bin</title>
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
	<h3>All Notices</h3><br>
	<table class="table" id="table">
	  <thead class="thead-dark">	  	
	    <tr align="center">
	      <th scope="col" align="center">NUM</th>
	      <th scope="col">TITLE</th>
	      <th scope="col">HIT COUNT</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach items="${nlist }" var="list">
	   		<tr>
				<td align="center">${list.nnum }</td>
				<td align="center"><a href ='/notice/view/${list.nnum }'>${list.title }</a></td>
				<td align="center">${list.hitcount }</td>
				</tr>
			</c:forEach>        
	  </tbody>
	</table>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<section class="button-area">
		<div class="container box_1170 border-top-generic">
			<div class="button-group-area">
				<a href="/notice/insert" class="genric-btn primary">Write notice</a>
			</div>			
		</div>
	</section>
	</sec:authorize> 
</div> 


<%@include file ="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>