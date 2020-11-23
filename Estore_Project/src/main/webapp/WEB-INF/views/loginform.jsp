<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>

<!doctype html>
<html lang="zxx">
<head>
</head>
<style>
#google{
	width:200px;
	height:50px;
}
#btn{
	width:200px;
	height:60px;
}
#naver{
width:200px;
	height:40px;
}
</style>
<body>
</body>
  <!--================login_part Area =================-->

   <section class="login_part section_padding ">
    
       <div class="container">
           <div class="row align-items-center">
               <div class="col-lg-6 col-md-6">
                   <div class="login_part_text text-center">
                           <h2>New to our Shop?</h2>
                           <p>There are advances being made in science and technology
                                everyday, and a good example of this is the</p>
                           <a href="preInsert" class="btn_3">Create an User Account</a><br>  
                   </div>
               </div>
               <div class="col-lg-6 col-md-6">
                   <div class="login_part_form">
                       <div class="login_part_form_iner">                     
                           <h3>Please Sign in now</h3>
                           <form class="row contact_form" method='post' action="/login" novalidate="novalidate">
                               <div class="col-md-12 form-group p_star">
                                   <input type="text" class="form-control" id="username" name="username" value=""
                                       placeholder="Username">
                               </div>
                               <div class="col-md-12 form-group p_star">
                                   <input type="password" class="form-control" id="password" name="password" value=""
                                       placeholder="Password">
                               </div>
                               <div class="col-md-12 form-group">
                               	   <div align="right">
                                   <button type="submit" value="submit" class="btn_3" id="btn">
                                       log in
                                   </button> 
                                   <img src="/resources/button/green.PNG" onclick="location.href='/oauth2/authorization/naver'" id="naver">
                                   <img src="/resources/button/normal.png" onclick="location.href='/oauth2/authorization/google'" id="google">
                                   </div>
                               </div>                              
                           </form>
                       </div>
                   </div>
               </div>
           </div>
       </div>
   </section>
    	
    <!--================login_part end =================-->
   <br>
   <!-- 목록 출력 영역 -->
  
 <%@include file ="/WEB-INF/views/include/footer.jsp" %>

</body>
    
</html>