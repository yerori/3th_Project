<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
p{
 	 font-size: 20px;
}
.title{
	font-weight:bold;
}
a{
	color:black;
}

.frm{
	margin:30px;
}

.table{
	width:82%;
}
#col-md-6 form-group p_star{
	width:100px;
	height:100px;
}
</style>

<script>
function rdelete(rnum){
	if(confirm(rnum+"번째 리뷰를 삭제하시겠습니까?")){
		$.get("/review/delete", {"rnum" : rnum},
			function (resp){
				if(resp=="success")
					alert("삭제 되었습니다.");
						location.href="/review/list";
			}
		)
	}
}
</script>
 <!-- slider Area Start-->
        <div class="slider-area ">
            <!-- Mobile Menu -->
            <div class="single-slider slider-height2 d-flex align-items-center" data-background="/assets/img/hero/category.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="hero-cap text-center">
                                <h2>Review Detail</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div><br><br><br>
<div class="frm" align="center">
<div class="col-lg-8">
		<h3>Product</h3><br>
			<div class="col-md-6 form-group p_star" >
			<img src="/resources/upload/product/${product.pimg }" alt="#" class="img-fluid">
			<br><br><br>
				<p >Product Type : ${product.ptype } </p>
				<p>Product Name : ${product.pname } </p>
				
			</div> 	
			</div>
        <div class="about_us_content" id="title" >
            <h5>Review Num : ${review.rnum }</h5>
          <h3>Title : ${review.title }</h3>
          <h3>Writer : ${review.email }</h3>
          <p>${review.content}</p>
          <h3>Rate : <c:forEach var="rating" items="${ratingOptions}" varStatus="status" begin="1" end="${review.rate}" >★</c:forEach>
              </h3>
              
        </div>     
	<br>
	<sec:authorize access="isAuthenticated()"> 
		 <sec:authentication property="principal.username" var="userName" />
			<c:if test="${userName==review.email or userName=='admin@admin.com'}">
			<div class="button-group-area">
				<a href="/review/update/${review.rnum}" class="genric-btn primary">Update</a>
				<a href="javascript:rdelete(${review.rnum })" class="genric-btn primary">Delete</a>
				</div>
			</c:if>
	</sec:authorize>
</div>
<%@include file ="/WEB-INF/views/include/footer.jsp" %>