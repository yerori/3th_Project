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
     <!-- slider Area Start-->
        <div class="slider-area ">
            <!-- Mobile Menu -->
            <div class="single-slider slider-height2 d-flex align-items-center" data-background="/assets/img/hero/category.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="hero-cap text-center">
                                <h2>Notice List</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div><br><br><br>
        <!-- slider Area End-->
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