<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>

<form action="/estore/product/productInsert" method="post" enctype="multipart/form-data">
    <!-- slider Area Start-->
    <div class="slider-area ">
        <!-- Mobile Menu -->
        <div class="single-slider slider-height2 d-flex align-items-center" data-background="/resources/assets/img/hero/category.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center">
                            <h2>상품 등록</h2>
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
        <div class="col-lg-12">
          <div class="product_img_slide owl-carousel">
            <div class="single_product_img">
              <!-- 이미지 업로드 -->
              <input type="file" name="pimg" mulitple />
              <img src="" alt="#" class="img-fluid">
            </div>
          </div>
        </div>
        <div class="col-lg-8">
          <div class="single_product_text text-center">
          	<h2>상품명: </h2>
            <input type="text" id="pname" name="pname">
            <h4>상품 설명 </h4>
            <input type="text" id="pdetail" name="pdetail" size="100">
			<h4>가격:</h4>
			<input type="text" id="price" name="price">
        </div>
      </div>
    </div>
  </div>
  <input type="submit" value="등록" class="btn_1">
  
</form>

 <%@include file ="/WEB-INF/views/include/footer.jsp" %>

