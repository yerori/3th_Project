<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>
 <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
 <style>
 #emailcheck, #pwcheck{
 font-weight:bold;
 }
 </style>
<body>
<div class="container">
 <!-- slider Area Start-->
        <div class="slider-area ">
            <!-- Mobile Menu -->
            <div class="single-slider slider-height2 d-flex align-items-center" data-background="/assets/img/hero/category.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="hero-cap text-center">
                                <h2>Seller Join Form</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div><br><br><br>
<form action="/shop/insert" method="post" id="frm">

  <div class="row">
    <div class="col">
    <label for="userid">Email : </label>
    <input type="text" class="form-control" placeholder="Enter Email" id="email" name="email">
 	</div> 
 	<div class="col align-self-end">
  	<button type="button" id="email_checkBtn" class="btn_3" name="email_checkBtn">Email Check</button>  	
  	</div>
  </div>
  <br>
  <div>
 	<span id="emailcheck"></span>
 	</div>
  <br>
   <div class="form-group">
    <label for="name">NAME : </label>
    <input type="text" class="form-control" placeholder="Enter name" id="name" name="name" size="20">
  </div>
   <br>
   <div class="form-group">
    <label for="name">STORE NAME : </label>
    <input type="text" class="form-control" placeholder="Enter name" id="sname" name="sname" size="20">
  </div>
  <br>
    <div class="form-group">
    <label for="pwd_check">Password : </label>
    <input type="password" class="form-control" placeholder="Enter password" id="password" name="password">
  </div>
  
 <div class="row">
    <div class="col">
    <label for="pwd">Password Confirm : </label>
    <input type="password" class="form-control" placeholder="Enter password" id="password2" name="password2">
 	</div> 
 	<div class="col align-self-end">
  	<button type="button" id="pw_checkBtn" class="btn_3" name="pw_checkBtn">Password Check</button>  	
  	</div>
  </div>
  <br>
  <div>
 	<span id="pwcheck"></span>
 	</div>
 	<br>
 	
 	 <div class="row">
    <div class="col">
    <label for="pwd">Address : </label>
    <input type="text" class="form-control" placeholder="Enter Address" id="zipcode" name="zipcode" readonly="readonly">
 	</div> 
 	<div class="col align-self-end">
  	<button type="button" class="btn_3" id="addr_checkBtn"><i class="fa fa-search"></i> 우편번호 찾기</button> 	
  	</div>
  </div>
  <br> 	
	<div class="form-group">
	    <input class="form-control" style="top: 5px;" placeholder="도로명 주소" name="addr" id="addr" type="text" readonly="readonly" />
	</div>
	
	<div class="form-group">
	    <input class="form-control" placeholder="상세주소" name="addr2" id="addr2" type="text"  />
	</div>
 	
  <br>
  <div class="form-group">
    <label for="phone">Phone : </label>
     <input type="text" class="form-control" placeholder="Enter phone" id="phone" name="phone">
  </div>
<Br>
<Br>

  <button type="button" id="joinBtn" class="btn_3">JOIN</button>
  <Br>
  <script src="/assets/js/join/insert.js"></script>
  
</form>
  </div>
   <%@include file ="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>