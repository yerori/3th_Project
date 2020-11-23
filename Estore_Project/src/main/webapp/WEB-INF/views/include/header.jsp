<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>

<html class="no-js" lang="en" xmlns:th="http://www.w3.org/1999/xhtml" xmlns:sec="http://www.w3.org/1999/xhtml">
 <script src="//code.jquery.com/jquery-latest.min.js"></script>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Estore </title>
        
        
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="manifest" href="site.webmanifest">
		<link rel="shortcut icon" type="image/x-icon" href="/assets/img/favicon.ico">

		<!-- CSS here -->
            <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
            <link rel="stylesheet" href="/assets/css/owl.carousel.min.css">
            <link rel="stylesheet" href="/assets/css/flaticon.css">
            <link rel="stylesheet" href="/assets/css/slicknav.css">
            <link rel="stylesheet" href="/assets/css/animate.min.css">
            <link rel="stylesheet" href="/assets/css/magnific-popup.css">
            <link rel="stylesheet" href="/assets/css/fontawesome-all.min.css">
            <link rel="stylesheet" href="/assets/css/themify-icons.css">
            <link rel="stylesheet" href="/assets/css/slick.css">
            <link rel="stylesheet" href="/assets/css/nice-select.css">
            <link rel="stylesheet" href="/assets/css/style.css">
      
      	<script>
		
		function type(search){
			var ptype = search;
			
			location.href="/product/productList?word="+ptype;
		}

		function search(){
			var search = $("#searchProduct").val();

			location.href="/product/productSearch?word="+search;
		}		
							
	</script>              
                    
           <style>
           	#welcom a{
           		size: 40px;
           	}
           </style>    
   </head>
   
  <body> 
       <!-- Preloader Start -->
<!--     <div id="preloader-active">
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="preloader-inner position-relative">
                <div class="preloader-circle"></div>
                <div class="preloader-img pere-text">
                    <img src="/assets/img/logo/logo.png" alt="">
                </div>
            </div>
        </div>
    </div> -->
    <!-- Preloader Start -->

    <header>
        <!-- Header Start -->
       <div class="header-area">
            <div class="main-header ">
                <div class="header-top top-bg d-none d-lg-block">
                   <div class="container-fluid">
                       <div class="col-xl-12">
                            <div class="row d-flex justify-content-between align-items-center">
                                <div class="header-info-left d-flex">
                                   
                                    <ul class="contact-now">     
                                        <li>+82 051-753-5600</li>
                                    </ul>
                                </div>
                                <div class="header-info-right">
                                   <ul>
                                    	    <%-- <li>
		                                   	<sec:authorize access="isAuthenticated()">
												<span id="welcom"><a>Welcome! <sec:authentication property="principal.username"/></a></span>
											</sec:authorize>
                                   	   
                                   	   </li>  
                                   	            --%>                               
                                       <sec:authorize access="hasRole('ROLE_USER') and isAuthenticated()">
												<li><a href="/user/mypage">My Page</a></li>   
										</sec:authorize>
										
										<sec:authorize access="hasRole('ROLE_MANAGER') and isAuthenticated()">
												<li><a href="/shop/mypage">My Page</a></li>   
										</sec:authorize>  
                                       
                                       	<sec:authorize access="hasRole('ROLE_ADMIN') and isAuthenticated()">
											<li><a href="/admin/mypage">My Page</a></li>   
										</sec:authorize>  
                                       
                                       
		                                 <sec:authorize access="hasRole('ROLE_USER') and isAuthenticated()">
											<li><a href="/cart/cartList">Cart</a></li>   
										</sec:authorize>                                 

		                                 <sec:authorize access="hasRole('ROLE_MANAGER') and isAuthenticated()">
											<li><a href="/product/productInsert">Add Item</a></li>   
										</sec:authorize>  
										
										                                      
                               
	                                    <sec:authorize access="isAuthenticated()">  
		                                  	  <li><a href="/logout">Logout</a> </li>
	                                  	</sec:authorize>                          
	                                    

                                   </ul>
                                </div>
                            </div>
                       </div>
                   </div>
                </div>
               <div class="header-bottom  header-sticky">
                    <div class="container-fluid">
                        <div class="row align-items-center">
                            <!-- Logo -->
                            <div class="col-xl-1 col-lg-1 col-md-1 col-sm-3">
                                <div class="logo">
                                  <a href="/"><img src="/assets/img/logo/logo.png" alt=""></a>
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-8 col-md-7 col-sm-5">
                                <!-- Main-menu -->
                                <div class="main-menu f-right d-none d-lg-block">
                                    <nav>                                                
                                        <ul id="navigation">                                                                                                                                     
                                            <li><a href="/">Home</a></li>
                                            
                                            <li><a href="/about">About Us</a></li>
                                            
                                            <li><a href="/product/productList">Category</a>
                                            
                                           	 <ul class="submenu">
                                                    <li><a href="javascript:type('폰케이스')">폰케이스</a></li>
                                                    <li><a href="javascript:type('캔들/디퓨저')">캔들/디퓨저</a></li>
                                                    <li><a href="javascript:type('비누')">비누</a></li>
                                                    <li><a href="javascript:type('디저트')">디저트</a></li>
                                                    <li><a href="javascript:type('커피')">커피</a></li>
                                                    <li><a href="javascript:type('반지')">반지</a></li>
                                                    <li><a href="javascript:type('귀걸이')">귀걸이</a></li>
                                                    <li><a href="javascript:type('목걸이')">목걸이</a></li>
                                                </ul>
                   							</li>
                                            <li><a href="/notice/list"">Community</a>
	                                            <ul class="submenu">
	                                                 <li><a href="/notice/list">Notice</a></li>
	                                                 <li><a href="/qna/list">QnA</a></li>
	                                                 <li><a href="/review/list">Review</a></li>
	                                            </ul>
         
                                             <li><a href="/contact/form">Contact</a></li> 
                                        </ul>
                                    </nav>
                                </div>
                            </div> 
                            <div class="col-xl-5 col-lg-3 col-md-3 col-sm-3 fix-card">
                                <ul class="header-right f-right d-none d-lg-block d-flex justify-content-between">
                                    <li class="d-none d-xl-block">
                                        <div class="form-box f-right ">
                                            <input type="text" name="Search" id="searchProduct" placeholder="Search products">
                                            <div class="search-icon" onclick="search()">
                                                <i class="fas fa-search special-tag"></i>
                                            </div>
                                        </div>
                                     </li>
   
                                    
                                    <li>
                                        <div class="shopping-card">
                                            <a href="/cart/cartList"><i class="fas fa-shopping-cart"></i></a>
                                        </div>
                                    </li>
                              	<sec:authorize access=" isAnonymous()">                              
	                                  	  <li class="d-none d-lg-block">
	                                  	    <a href="/loginform" class="btn header-btn">Sign in</a>
	                                  	  </li>
                                  </sec:authorize>	  
                                  	 
                                  	  
                              		<sec:authorize access="isAuthenticated()">  
	                                  	  <li class="d-none d-lg-block"> 
	                                  	    <a href="/logout" class="btn header-btn">Sign out</a>
	                                  	  </li>
                                  	</sec:authorize> 
                                  	
                                </ul>
                            </div>
                            <!-- Mobile Menu -->
                            <div class="col-12">
                                <div class="mobile_menu d-block d-lg-none"></div>
                            </div>
                        </div>
                    </div>
               </div>
            </div>
       </div>
        <!-- Header End -->
    </header>
