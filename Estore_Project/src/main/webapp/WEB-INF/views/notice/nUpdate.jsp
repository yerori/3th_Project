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

</style>
<div align="center">
<form  id="frm" method="post" action="/notice/update" enctype="multipart/form-data" data-ajax="false" >
<input type="hidden" value="${notice.create_date }" id="create_date" name="create_date">
    <!-- slider Area Start-->
        <div class="slider-area ">
            <!-- Mobile Menu -->
            <div class="single-slider slider-height2 d-flex align-items-center" data-background="/assets/img/hero/category.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="hero-cap text-center">
                                <h2>Notice Update</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div><br><br><br>
		<div class="col-lg-8" align="left">
			<h3>Update Notice</h3><br> 
				<input type="hidden" id="nnum" name="nnum" value=${notice.nnum } class="single-input">
					<div class="col-md-6 form-group p_star">
					<p>Notice Title </p>
				</div> 	
					<input type="text" id="title" name="title" 
						value="${notice.title }" class="single-input">
						<br>
				<div class="col-md-6 form-group p_star">
					<p>Notice Content </p>
				</div> 			
				<textarea class="single-textarea1" id="content" name="content">${notice.content }</textarea>
				<br>
				<div class="col-md-6 form-group p_star">
					<p>Attachment </p>
				</div>
					<div class="col-md-6 form-group p_star">
					<p>${fileName } </p>
				</div> 		
					<div class="mt-10">
		              <!-- 이미지 업로드 -->		             	
		             	<input type="file" name="uploadFile" id="nimg" value="${notice.nimg }">  
				</div>
			</div>
			<br>
			<!-- 등록버튼 -->
			<section class="button-area" align="center">
				<div class="container box_1170 border-top-generic" >
					<div class="button-group-area">
						<Button type="submit" class="genric-btn success large">Update the notice</Button>
					</div>			
				</div>
			</section>
    
  
</form>
</div>

<%@include file ="/WEB-INF/views/include/footer.jsp" %>