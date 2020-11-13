<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <!-- CSS here -->
      <link rel="stylesheet" href="assets/css/bootstrap.min.css">
      <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
      <link rel="stylesheet" href="assets/css/flaticon.css">
      <link rel="stylesheet" href="assets/css/slicknav.css">
      <link rel="stylesheet" href="assets/css/animate.min.css">
      <link rel="stylesheet" href="assets/css/magnific-popup.css">
      <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
      <link rel="stylesheet" href="assets/css/themify-icons.css">
      <link rel="stylesheet" href="assets/css/slick.css">
      <link rel="stylesheet" href="assets/css/nice-select.css">
      <link rel="stylesheet" href="assets/css/style.css">

</head>
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>
<body>
<form>
<div class="shipping_box">
	<ul class="list">
	  <li>
	    일반 회원으로 회원가입
	    <input type="radio" aria-label="Radio button for following text input" value="user">
	  </li>
	  <li>
	    일반 셀러로 회원가입
	    <input type="radio" aria-label="Radio button for following text input" value="seller">
	  </li>
	 
	</ul>
	 <button type="button" class="btn_3" id="preBtn">
        회원가입하기
     </button>
</div>
<script src="/assets/js/user/insert.js"></script>
</form>
</body>
   <%@include file ="/WEB-INF/views/include/footer.jsp" %>
</html>