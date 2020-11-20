<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>

<form action="/notice/insert" method="post" enctype="multipart/form-data" data-ajax="false">
 
  <div class="product_image_area">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-8">
             <div class="mt-10">            
	             <div class="mt-10">
	              <!-- 이미지 업로드 -->
	             	<label for="pimg">이미지 등록</label>
	            	<input type="file" name="uploadFile" id="nimg"/>              
	            </div>
            </div>
         			
			<div class="mt-10">
				<input type="text" id="title" name="title" 
				placeholder="notice title" onfocus="this.placeholder = ''" class="single-input">
			</div>
			
			<div class="mt-10">
				<textarea class="single-textarea1" id="content" name="content" 
				placeholder="notice content" onfocus="this.placeholder = ''"></textarea>
			</div>
			
			
			<br><br>
			<!-- 등록버튼 -->
            <div class="add_to_cart" align="center">
			  <input type="submit" value="등록" class="genric-btn success large">
			</div>
	      </div>
	    </div>   
	  </div>  
	</div>  
</form>


 <%@include file ="/WEB-INF/views/include/footer.jsp" %>