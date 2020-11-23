<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<input type="hidden" id="userid" name="userid" value="<sec:authentication property='principal.username'/>">
    <!-- slider Area Start-->
    <div class="slider-area ">
      <!-- Mobile Menu -->
      <div class="single-slider slider-height2 d-flex align-items-center" data-background="/assets/img/hero/category.jpg">
          <div class="container">
              <div class="row">
                  <div class="col-xl-12">
                      <div class="hero-cap text-center">
                          <h2>Confirmation</h2>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </div>
  <!-- slider Area End-->
	<br><br><br>
  <!--================ confirmation part start =================-->
  <section class="confirmation_part section_padding">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="confirmation_tittle">
            <span>Thank you. Your order has been received.</span>
          </div>
        </div>
      </div>
    </div>
    
    <div class="confirmation_part section_padding">
            <div class="col-lg-12">
          <div class="confirmation_tittle">
    	<button class="genric-btn success radius" onclick="location.href='/user/uOrderList'">주문내역 확인하기</button>
    	<button class="genric-btn success-border radius" onclick="location.href='/product/productList'">상품 더보기</button>
    	</div>
    	</div>
    </div>
  </section>
  <!--================ confirmation part end =================-->
  


  
   <%@include file ="/WEB-INF/views/include/footer.jsp" %>