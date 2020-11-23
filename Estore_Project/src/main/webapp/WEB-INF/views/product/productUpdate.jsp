<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/product/productUpdate" method="post" enctype="multipart/form-data" data-ajax="false">
    <!-- slider Area Start-->
    <div class="slider-area ">
        <!-- Mobile Menu -->
        <div class="single-slider slider-height2 d-flex align-items-center" data-background="/assets/img/hero/category.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center">
                           <h2>Product Update</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- slider Area End-->

  <!--================Single Product Area =================-->
  <div class="product_image_area">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-8">
             <div class="mt-10">
              <!-- 이미지 업로드 -->
             	<label for="pimg">이미지 등록</label>
            	<input type="file" name="uploadFile" id="pimg" value="${product.pimg }">
            	<span><img src="/resources/upload/product/${product.pimg }" class="img-fluid">${product.pimg }</span>  
            </div>
         
      		<div class="input-group-icon mt-10">
				<div class="icon"><i class="fa fa-plane" aria-hidden="true"></i></div>
					<div class="form-select" >
						<select id="ptype" name="ptype">
							<option value="">상품 종류 선택</option>
							<option value="폰케이스">폰케이스</option>
							<option value="캔들/디퓨저">캔들 / 디퓨저</option>
							<option value="비누">비누</option>
							<option value="커피">커피</option>
							<option value="디저트">디저트</option>
							<option value="반지">반지</option>
							<option value="귀걸이">귀걸이</option>
							<option value="목걸이">목걸이</option>
							
						</select>
					</div>
			</div>		
		
			<div class="mt-10">
				<input type="hidden" id="pnum" name="pnum" value="${product.pnum }">
				<input type="text" id="pname" name="pname" value="${product.pname}"
				placeholder="상품명" onfocus="this.placeholder = ''" class="single-input">
			</div>
			
			<div class="mt-10">
				<textarea class="single-textarea" id="pdetail" name="pdetail"
				placeholder="상품설명" onfocus="this.placeholder = ''"> ${product.pdetail}</textarea>
			</div>
			
			<div class="mt-10">
				<input type="text" id="price" name="price" value="${product.price}"
				placeholder="가격" onfocus="this.placeholder = ''" class="single-input">
			</div>
			
			<br><br>
			<!-- 등록버튼 -->
            <div class="add_to_cart" align="center">
			  <input type="submit" value="수정완료" class="genric-btn success large">
			</div>
      </div>
    </div>    
  </div>
  </div>  
</form>

<script>
	$("#ptype option").each(function(){
		if($(this).val()=="${product.ptype}"){
			$(this).prop("selected", true);
		}
	});
</script>


 <%@include file ="/WEB-INF/views/include/footer.jsp" %>

