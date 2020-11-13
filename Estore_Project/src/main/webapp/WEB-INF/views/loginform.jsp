<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>

<!doctype html>
<html lang="zxx">
<head>
</head>
<body>
</body>
  <!--================login_part Area =================-->

   <section class="login_part section_padding ">
    
       <div class="container">
           <div class="row align-items-center">
               <div class="col-lg-6 col-md-6">
                   <div class="login_part_text text-center">
                           <h2>New to our Shop?</h2>
                           <a href="preInsert" class="btn_3">Create an User Account</a><br>  
                 <!--   		 <h2>New to our Shop Seller?</h2>
                           <a href="sInsert" class="btn_3">Create an Shop Account</a><br>  -->
                   </div>
               </div>
               <div class="col-lg-6 col-md-6">
                   <div class="login_part_form">
                       <div class="login_part_form_iner">                     
                           <h3>Please Sign in now</h3>
                           <form class="row contact_form" method='post' action="/login" novalidate="novalidate">
                             <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>  
                               <div class="col-md-12 form-group p_star">
                                   <input type="text" class="form-control" id="username" name="username" value=""
                                       placeholder="Username">
                               </div>
                               <div class="col-md-12 form-group p_star">
                                   <input type="password" class="form-control" id="password" name="password" value=""
                                       placeholder="Password">
                               </div>
                               <div class="col-md-12 form-group">
                                   <div class="creat_account d-flex align-items-center">
                                       <input type="checkbox" id="f-option" name="selector">
                                       <label for="f-option">Remember me</label>
                                   </div>
                                   <button type="submit" value="submit" class="btn_3">
                                       log in
                                   </button>
                                   <button type="button" onclick="location.href='/oauth2/authorization/google'" class="btn_3">
                                       Sign in With Google
                                   </button>								
                                   <a class="lost_pass" href="#">forget password?</a>
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