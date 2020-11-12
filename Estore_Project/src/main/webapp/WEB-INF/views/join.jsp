<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file ="/WEB-INF/views/include/header.jsp" %> 

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
<form action="/user/join" method="post" id="frm">

  <div class="row">
    <div class="col">
    <label for="userid">Email : </label>
    <input type="text" class="form-control" placeholder="Enter Email" id="username" name="username">
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
    <label for="pwd_check">Password : </label>
    <input type="password" class="form-control" placeholder="Enter password" id="password" name="password">
  </div>
  
 <br>
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
 
  <br>
   <div class="form-group">
    <label for="addr">ADDR :  </label>
     <input type="text" class="form-control" placeholder="Enter address" id="addr" name="addr" size=20>
    
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
  <script src="/assets/js/user/user.js"></script>
</form>
  </div>
  
</body>
</html>