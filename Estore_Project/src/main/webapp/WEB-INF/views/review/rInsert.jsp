<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>

#frm{
margin:20px;
}
#imgdiv{
margin:20px;
}
#content{
/* margin:10px; */
}

#pp{
  font-size: 20px;
}

#star a{ text-decoration: none; color: gray; } #star a.on{ color: red; }

</style>
 <!-- slider Area Start-->
        <div class="slider-area ">
            <!-- Mobile Menu -->
            <div class="single-slider slider-height2 d-flex align-items-center" data-background="/assets/img/hero/category.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="hero-cap text-center">
                                <h2>Review Insert</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div><br><br><br>
<form  id="frm" method="post" action="/review/insert" enctype="multipart/form-data" data-ajax="false">
	<input type="hidden" name="pnum" id="pnum" value=${reviewform.product.pnum }>
	<input type="hidden" value="${reviewform.onum }" id="onum" name="onum">
	<input type="hidden" value="${reviewform.sid }" id="sid" name="sid">
	<div align="center">
	<div class="col-lg-8" align="left">
		<h3>Product</h3><br>
			<div class="col-md-6 form-group p_star">
			<img src="/resources/upload/product/${reviewform.product.pimg }" alt="#" class="img-fluid">
				<p>Product Type : ${reviewform.product.ptype } </p>
				<p>Product Name : ${reviewform.product.pname } </p>
				
			</div> 	
			
			<div class="col-lg-8">
				<h3>Write a Review</h3><br>		
				<div class="col-md-6 form-group p_star">
					<p>Review Title </p>
				</div>    			
					<input type="text" id="title" name="title" class="single-input">
						<br>
				<div class="col-md-6 form-group p_star">
					<p>Review Content </p>
				</div> 			
					<textarea class="single-textarea1" id="content" name="content"></textarea>
					<br>
				<div class="col-md-6 form-group p_star">
					<p>Review Rate </p>
					<p id="star">
				        <a href="#" title="1">★</a>
				        <a href="#" title="2">★</a>
				        <a href="#" title="3">★</a>
				        <a href="#" title="4">★</a>
				        <a href="#" title="5">★</a>
					</p> 
				</div>	          
            </div>			
		</div>				
		<br>
	<!-- 등록버튼 -->
	<section class="button-area" align="center">
		<div class="container box_1170 border-top-generic" >
			<div class="button-group-area">
				<Button type="button" id="reviewBtn" class="genric-btn success large">Write</Button>
			</div>			
		</div>
	</section> 
	</div>
</form>
<script>
var rate;
$('#star a').click(function(){ 
	$(this).parent().children("a").removeClass("on"); 
	$(this).addClass("on").prevAll("a").addClass("on"); 
	rate = $(this).attr("title");
});

$("#reviewBtn").on("click",function(){
 	var reviewData = {
		"title" : $("#title").val(),
		"content" : $("#content").val(),
		"pnum" : $("#pnum" ).val(),
		"onum" : $("#onum" ).val(),
		"rate" : rate,
		"sid" : $("#sid" ).val()
	} 

	$.ajax({
		type:"post",
		url:"/review/insert",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify(reviewData)
	})
	
	.done(function(resp){
		alert("리뷰가 등록되었습니다.");
		location.href="/review/list";
	})
	
	.fail(function(error){
		alert("리뷰 등록이 실패되었습니다."+error);
		return false;
	})
})

</script>

<%@include file ="/WEB-INF/views/include/footer.jsp" %>