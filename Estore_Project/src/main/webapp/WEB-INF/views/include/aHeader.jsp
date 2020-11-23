 <%@include file ="/WEB-INF/views/include/header.jsp" %>
 

 
  <!-- slider Area Start-->
  <div class="slider-area ">
    <!-- Mobile Menu -->
    <div class="single-slider slider-height2 d-flex align-items-center" data-background="/assets/img/hero/category.jpg">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="hero-cap text-center">
                        <h2>Admin Page</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>
  <!-- slider Area End-->
    
   <!-- feature part here -->
    <section class="feature_part section_padding">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-2 col-sm-5" onclick="location.href='/admin/sInfo'" style="cursor:pointer">
                    <div class="single_feature_part">
                        <a href="/admin/sInfo"><img src="/assets/img/icon/feature_icon_1.svg" alt="#"></a>
                        <h4>All Shop</h4>
                    </div>
                </div>
                
                <div class="col-lg-2 col-sm-5" onclick="location.href='/admin/aUser'" style="cursor:pointer">
                    <div class="single_feature_part">
                        <a href="/notice/list"><img src="/assets/img/icon/icon_4.png" alt="#"></a>
                        <h4>All User</h4>
                    </div>                  
                </div>
                
                <div class="col-lg-2 col-sm-5" onclick="location.href='/admin/aOList'" style="cursor:pointer">
                    <div class="single_feature_part">
                        <img src="/assets/img/icon/icon_2.png" alt="#">
                        <h4>All Order</h4>
                    </div>
                </div>
                
                <div class="col-lg-2 col-sm-5" onclick="location.href='/admin/aProduct'" style="cursor:pointer">
                  <div class="single_feature_part">
                        <a href="/product/productList"><img src="/assets/img/icon/feature_icon_2.svg" alt="#"></a>
                        <h4>All Product</h4>
                    </div>
                </div>
                

                
                <div class="col-lg-2 col-sm-5" onclick="location.href='/admin/cList'" style="cursor:pointer">
                    <div class="single_feature_part">
                        <a href="/admin/cList"><img src="/assets/img/icon/feature_icon_4.svg" alt="#"></a>
                        <h4>Contact</h4>
                    </div>                  
                </div>
            </div>
        </div>
    </section>
    <!-- feature part end -->