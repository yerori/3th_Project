<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
#nav nav-tabs{
	align:left;
}
a{
	color:black;
	font-size:20;
}
a:hover {
	font-weight:bold;
	text-decoration:underline;
}
#star a{ text-decoration: none; color: gray; } #star a.on{ color: red; }

</style>
    <!-- slider Area Start-->
    <div class="slider-area ">
        <!-- Mobile Menu -->
        <div class="single-slider slider-height2 d-flex align-items-center" data-background="/assets/img/hero/category.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center">
                            <h2>product Details</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- slider Area End-->

  <!--================Single Product Area =================-->

  <div class="product_image_area">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-12">
          <div class="product_img_slide owl-carousel">
            <div class="single_product_img">
              <img src="/resources/upload/product/${product.pimg }" alt="#" class="img-fluid">
            </div>
            <div class="single_product_img">
              <img src="/resources/upload/product/${product.pimg }" alt="#" class="img-fluid">
            </div>
            <div class="single_product_img">
              <img src="/resources/upload/product/${product.pimg }" alt="#" class="img-fluid">
            </div>
          </div>
        </div>
        <div class="col-lg-8">
          <div class="single_product_text text-center">
          <input type="hidden" name="sid" id="sid" value="${product.sid }">
            <input type="hidden" name="sname" id="sname" value="${product.sname }">
            <input type="hidden" name="pnum" id="pnum" value="${product.pnum }">
            <h3>${product.pname }</h3>
            <p>${product.pdetail }</p>
            <div class="card_area">
            
            	<div class="product_count_area">

                   <div class="product_count_area">
                   	  <p>${product.price } won</p>
                   </div>               
                </div>
                
                
            
                <div class="product_count_area">
                    
                    <p>Quantity</p>
                    <div class="product_count d-inline-block">
                        <span class="product_count_item inumber-decrement"> <i class="ti-minus"></i></span>
                        <input class="product_count_item input-number" id="count" type="text" value="1" min="0" max="10">
                        <span class="product_count_item number-increment"> <i class="ti-plus"></i></span>
                    </div>
                    
                </div>
              <div class="add_to_cart">
              	  <!-- 비회원/회원 장바구니 보이게  -->
              	  <sec:authorize access="isAuthenticated()"> 
              	  <sec:authorize  access="hasRole('ROLE_USER')">                	  
	                  <input type="button" value="장바구니" class="btn_3" id="btnAddCart"
	                  onclick="javascript:addCart('${product.pname }','${product.price }', '${product.sid }')">
                  </sec:authorize>
                  
                  <sec:authentication property="principal.username" var="userName" />
                   <sec:authorize access="hasRole('ROLE_MANAGER')"> 
                    <c:if test="${userName==product.sid}">		 
	                  <!-- 판매자만 보이게 -->
	                  <input type="button" value="수정하기" class="genric-btn success-border radius" 
	                  onclick="location.href='/product/productUpdate?pnum=${product.pnum}'">
	                  <input type="button" value="삭제하기" class="genric-btn danger-border radius"
	                  onclick="location.href='/product/productDelete?pnum=${product.pnum }'">
	                 </c:if> 
	                 
	                 <div>

	                  </div>                  
	                  
                  </sec:authorize>
                  
              <sec:authorize access="hasRole('ROLE_ADMIN')"> 
                    <c:if test="${userName=='admin@admin.com' }">		 
	                  <!-- 판매자만 보이게 -->
	                  <input type="button" value="삭제하기" class="genric-btn danger-border radius"
	                  onclick="location.href='/admin/productDelete?pnum=${product.pnum }'">
	                 </c:if> 
	                 
	                 <div>

	                  </div>                  
	                  
                  </sec:authorize>  
                  
                  
                  
                  
                 </sec:authorize>            
              </div>
            </div>
          </div>
        </div>
      </div>
      <hr>
      <!-- 리뷰 / qna 버튼 생성 -->
      <div class="container">
          <div class="row product-btn d-flex justify-content-end align-items-end">
              <!-- Section Tittle -->
              <div class="col-xl-4 col-lg-5 col-md-5">
              </div>
              <div class="col-xl-8 col-lg-7 col-md-7">
                  <div class="properties__button f-right">
                      <!--Nav Button  -->
                      <nav>                                                                                                
                          <div class="nav nav-tabs" id="nav-tab" role="tablist">
                              <a class="nav-item nav-link" id="qnatab" data-toggle="tab" onclick="javascript:qnaShowFunction()" role="tab" aria-controls="nav-contact" aria-selected="true">QnA</a>
                              <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" onclick="javascript:revShowFunction()" role="tab" aria-controls="nav-contact" aria-selected="false">Review</a>
                          </div>
                      </nav>
                      <!--End Nav Button  -->
                     </div>
                 </div>
             </div>                
		</div>	
		<sec:authorize  access="hasRole('ROLE_USER')">	
			<div class="button-group-area" id="buttonarea">
				<Button type="button" id="qnaBtn" class="genric-btn success large">Write a QnA</Button>
			</div>
		</sec:authorize>
		<br>
		<div id="listarea"></div>
		<div id="insertarea"></div>
				
    </div>
  </div> 
  

<script>

//Qna
$(document).ready(function(){
	$("#qnaBtn").hide(); //qna버튼 숨기기
})

//추가하기 폼
$("#qnaBtn").on("click",function(){
	$("#listarea").hide();
	$("#qnaBtn").hide();

	var htmlStr = "";
	htmlStr += "<div class='col-lg-8'>"
	htmlStr += "<h3>Write a QnA</h3><br>";
	htmlStr += "<div class='col-md-6 form-group p_star'>";
	htmlStr += "<p>QnA Title </p>";
	htmlStr += "</div>";
	htmlStr += "<input type='text' id='title' name='title' class='single-input'><br>";
	htmlStr += "<div class='col-md-6 form-group p_star'>";
	htmlStr += "<p>QnA Content </p>";
	htmlStr += "</div> ";
	htmlStr += "<textarea class='single-textarea1' id='content' name='content'></textarea><br>";
	htmlStr += "<div class='col-md-6 form-group p_star'>";
	htmlStr += "<p>QnA Password </p>";
	htmlStr += "</div>";
	htmlStr += "<input type='password' id='password' name='password' class='single-input'><br>";
	htmlStr += "<div class='col-md-6 form-group p_star'>";
 	htmlStr += "<div class='button-group-area'>";
	htmlStr += "<Button type='button' id='insertBtn' class='genric-btn success large'>Write a QnA</Button>";

	$("#insertarea").html(htmlStr);

	$("#insertBtn").on("click",function(){
		var qnaData = {
			"pnum":$("#pnum").val(),
			"title" : $("#title").val(),
			"content" : $("#content").val(),
			"password" : $("#password").val()
		}
		
		$.ajax({
			type:"post",
			url:"/qna/insert",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify(qnaData)		
		})
		.done(function(success){
			alert("QnA가 등록되었습니다.");
			location.href="/user/uQnA";
		})

		.fail(function(error){
			alert("QnA 실패"+error);
		})
	})
				
});

//qna 전체보기
function qnaShowFunction(){
	$("#qnaBtn").show(); //qna버튼 나타내기
	
	$.ajax({
		type:"get",
		url:"/qna/plist",
		data:{"pnum":$("#pnum").val()}		
	})
	
	.done(function(resp){
		if(resp==""){
		}
		else {
		var htmlStr = "";
		htmlStr += "<table class='table'>";
		htmlStr += "<tr>";
		htmlStr += "<th scope='col'> Num </th>";
		htmlStr += "<th scope='col'> Writer</a></th>";
		htmlStr += "<th scope='col'> Title </th>";
		htmlStr += "<th scope='col'> Date </th></tr>";
		$.each(resp, function(key, val){
			
			var afterStr = val.email.split('@'); //@앞까지만 writer로 지칭
			htmlStr += "<tr>";
			htmlStr += "<td>"+val.qnum+"</td>";
			htmlStr += "<td>"+afterStr[0]+"</td>";
			htmlStr += "<td>"+val.title+"["+val.replyCnt+"]</td>";		
			htmlStr += "<td>"+val.create_date+"</td>";
			htmlStr += "</tr>";
		});//each
		
		htmlStr += "</table>";
		$("#listarea").html(htmlStr);	
		}
	})//done
	
	.fail(function(error){
		alert("실패 "+ error);
	})//fail
} //list


//상세보기
function qnaViewFunction(qnum){
	
	//$("#viewarea").attr("tabindex", -1).focus(); //포커스 함수
	location.href="/qna/pwform/"+qnum;
}


//버튼 시큐리티
//리뷰

//리뷰 전체보기
function revShowFunction(){
	$("#qnaBtn").hide(); //qna버튼 숨기기
	
	$.ajax({
		type:"get",
		url:"/review/plist",
		data:{"pnum":$("#pnum").val()}		
	})
	
	.done(function(resp){
		var htmlStr = "";
		htmlStr += "<table class='table'>";
		htmlStr += "<tr>";
		htmlStr += "<th scope='col'> Num </th>";
		htmlStr += "<th scope='col'> Writer</a></th>";
		htmlStr += "<th scope='col'> Title </th>";
		htmlStr += "<th scope='col'> Date </th>";
		htmlStr += "<th scope='col'> Rate </th></tr>";
		
		// resp > ratingOptions
		// ratingOptions.rlist = resp.rlist
		$.each(resp.rlist, function(key, val){		
	 		var afterStr = val.email.split('@'); //@앞까지만 writer로 지칭
			htmlStr += "<tr>";
			htmlStr += "<td>"+val.rnum+"</td>";
			htmlStr += "<td>"+afterStr[0]+"</td>";
			htmlStr += "<td>"+val.title+"</td>";
			htmlStr += "<td>"+val.create_date+"</td>";
			htmlStr += "<td>"+resp[val.rate]+"</td>";
			htmlStr += "</tr>"; 
		});
		
		htmlStr += "</table>";
		$("#listarea").html(htmlStr);		
	})
	
	.fail(function(error){
		alert("실패 "+ error);
	})

} //list


//카트
function addCart(pname, price, sid){
	var data={
		"pnum":$("#pnum").val(),
		"pname":pname,
		"price":price,
		"count":$("#count").val(),
		"sid":sid,
		"sname":$("#sname").val()	
	};

	$.ajax({
		type:"post",
		url:"/cart/cartInsert",
		contentType:'application/json;charset=utf-8',
		data:JSON.stringify(data)
	})
	.done(function(resp){
		if(resp=="success"){
			alert("장바구니에 추가되었습니다.");
			location.href="/cart/cartList";
		}

	})
	.fail(function(error){
		alert("error..ㅠㅠ")
	})

}


</script>
  
<%@include file ="/WEB-INF/views/include/footer.jsp" %>
  