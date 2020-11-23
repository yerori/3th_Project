<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!-- slider Area Start-->
        <!-- slider Area Start-->
        <div class="slider-area ">
            <!-- Mobile Menu -->
            <div class="single-slider slider-height2 d-flex align-items-center" data-background="/assets/img/hero/category.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="hero-cap text-center">
                                <h2>Contact Submit!</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div><br><br><br>
  <!-- slider Area End-->
	<br><br><br>
  <!--================ confirmation part start =================-->
  <section class="confirmation_part section_padding">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="confirmation_tittle">
            <span>Thank you. Your Contact has been received.</span>
          </div>
        </div>
      </div>
    </div>
    <form method="get" action="/">
    <div class="confirmation_part section_padding">
            <div class="col-lg-12">
          <div class="confirmation_tittle">
    	<button class="genric-btn success-border radius" onclick="/">Main</button>
    	</div>
    	</div>
    </div>
    </form>
  </section>
  <!--================ confirmation part end =================-->
  


  
   <%@include file ="/WEB-INF/views/include/footer.jsp" %>