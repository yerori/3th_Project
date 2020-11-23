<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/managerHeader.jsp" %>
 
 <br><br><br>
      <section class="confirmation_part section_padding">
        <div class="container">

            <div class="row justify-content-center">
                <div class="col-lg-5  col-sm-4" >
                    <div class="blog_right_sidebar">
                        <aside class="single_sidebar_widget search_widget">
                            <div class="form-group">
                                <div class="input-group mb-3">
                                   <a href="/shop/sOrderList"> <h3>Today Order</h3></a>
                                 </div>
                                 <div class="input-group mb-3">
                                 	<h4>New Order : ${count }</h4>
                                 </div>
                                 <div class="input-group mb-3">                                 
                                 	<h4>Total Profit : ${sum }</h4>
                                 </div>
                            </div>
    					</aside>
                    </div>
               </div>
               
               <div class="col-lg-5  col-sm-4" >
                    <div class="blog_right_sidebar">
                        <aside class="single_sidebar_widget search_widget">
                            <div class="form-group">
                                <div class="input-group mb-3">                                    
                                    <h3>This Week</h3>
                                 </div>
                            	 <div class="input-group mb-3">
                                 	<h4>Order Count : ${wCount }</h4>
                                 </div>
                                 <div class="input-group mb-3">
                                 	<h4>Order Profit : ${wSum }</h4>
                                 </div>
                            </div>
    					</aside>
                    </div>
               </div>
               
           </div>
           
                       <div class="row justify-content-center">
                <div class="col-lg-5  col-sm-4" >
                    <div class="blog_right_sidebar">
                        <aside class="single_sidebar_widget search_widget">
                            <div class="form-group">
                                <div class="input-group mb-3">
                                    <h3>QnA</h3>
                                 </div>
                                 <div class="input-group mb-3">
                                 	<h4>Today New Qna: ${tQcount }</h4>
                                 </div>
                                 <div class="input-group mb-3">
                                 	<a href="/shop/sQnA"><h4>No Reply: ${noReply }</h4></a>
                                 </div>
                            </div>
    					</aside>
                    </div>
               </div>
               
               <div class="col-lg-5  col-sm-4" >
                    <div class="blog_right_sidebar">
                        <aside class="single_sidebar_widget search_widget">
                            <div class="form-group">
                         	   <div class="input-group mb-3">
                                    <h3>Review</h3>
                                 </div>
                              <div class="input-group mb-3">
								<h4>Today New Review: ${todayReview }</h4>
								</div>
								<div class="input-group mb-3">
								<h4>This Week Review: ${weekReview }</h4>
								</div>
                            </div>
    					</aside>
                    </div>
               </div>               
           </div>          
        </div>
     </section>

 
<%@include file ="/WEB-INF/views/include/footer.jsp" %>