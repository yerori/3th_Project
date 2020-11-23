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
 <!-- slider Area Start-->
        <div class="slider-area ">
            <!-- Mobile Menu -->
            <div class="single-slider slider-height2 d-flex align-items-center" data-background="/assets/img/hero/category.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="hero-cap text-center">
                                <h2>Review List</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div><br><br><br>
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
					<td align="center">${list.rnum }</td>
					<td align="center"><a href ='/review/detail/${list.rnum }/${list.pnum}'>${list.title }</a></td>	
					<td align="center"><c:forEach var="rating" items="${ratingOptions}" varStatus="status" begin="1" end="${list.rate}" >★</c:forEach></td>					
				</tr>
			</c:forEach>   
	  	</tbody>
	</table>
</div>	  
		


 <%@include file ="/WEB-INF/views/include/footer.jsp" %>
</body>

</html>