<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	if(confirm(rnum+"번째 게시글을 삭제하시겠습니까?")){
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
<div class="frm" align="center">
<div class="col-lg-8">
		<h3>Product</h3><br>
			<div class="col-md-6 form-group p_star">
			<img src="/resources/upload/product/${product.pimg }" alt="#" class="img-fluid">
				<p>Product Type : ${product.ptype } </p>
				<p>Product Name : ${product.pname } </p>
				
			</div> 	
			</div>
        <div class="about_us_content" id="title">
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
			<c:if test="${userName==list.email }"> --%>
			<div class="button-group-area">
				<a href="/review/update/${review.rnum}" class="genric-btn primary">Update</a>
				<a href="javascript:rdelete(${review.rnum })" class="genric-btn primary">Delete</a>
				</div>
			</c:if>
	</sec:authorize>
</div> 
 
<%@include file ="/WEB-INF/views/include/footer.jsp" %>