<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
p{
width:100%;
}

.col-lg-8{
align:left;
}

</style>
 <script>
function ndelete(nnum){
	if(confirm(nnum+"번째 게시글을 삭제하시겠습니까?")){
		$.get("/notice/delete", {"nnum" : nnum},
			function (resp){
				if(resp=="success"){
					alert("삭제 되었습니다.");
						location.href="/notice/list";
				}
			}
		)
	}
}
</script>
 
   <!-- slider Area Start-->
        <div class="slider-area " align="left">
            <!-- Mobile Menu -->
            <div class="single-slider slider-height2 d-flex align-items-center" data-background="/assets/img/hero/category.jpg">
                <div class="container" align="left">
                    <div class="row" align="left">
                        <div class="col-xl-12"  align="left">
                            <div class="hero-cap text-center" align="left">
                                <h2 align="left">Notice Detail</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<section class="about_us padding_top">
      <div class="container">
          <div class="row justify-content-center">
              <div class="about_us_content">
                  <h5>Notice Num : ${notice.nnum }</h5>
                 <h3>${notice.title }</h3>
                 <div class="single_product_img">
                  	<c:if test="${not empty notice.nimg }"> 
                       <img src="/resources/upload/notice/${notice.nimg }" alt="#" class="img-fluid">
                       </c:if>
                        <br><br><br>   
                     	<p>${notice.content}</p>
                 </div>
             </div>                            
          </div>
          <sec:authorize access="hasRole('ROLE_ADMIN')">
          <section class="button-area">
			<div class="container box_1170 border-top-generic" align="center">
				<div class="button-group-area">
					<a href="/notice/update/${notice.nnum}" class="genric-btn primary">Update</a>
					<a href="javascript:ndelete(${notice.nnum })" class="genric-btn primary">Delete</a>
				</div>			
			</div>
		</section>
		</sec:authorize>
	</div>  
</section>
  
 

 
 
<%@include file ="/WEB-INF/views/include/footer.jsp" %>