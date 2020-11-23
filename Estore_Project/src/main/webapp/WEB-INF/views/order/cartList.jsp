<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <!-- slider Area Start-->
  <div class="slider-area ">
    <!-- Mobile Menu -->
    <div class="single-slider slider-height2 d-flex align-items-center" data-background="assets/img/hero/category.jpg">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="hero-cap text-center">
                        <h2>Card List</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>
  <!-- slider Area End-->

  <!--================Cart Area =================-->
  <section class="cart_area section_padding">
    <div class="container">
      <div class="cart_inner">
        <div class="table-responsive">
          <table class="table">
            <thead>
              <tr>
                <th scope="col">Product</th>
                <th scope="col">Price</th>
                <th scope="col">Quantity</th>
                <th scope="col">Total</th>
                <th scope="col">Delete</th>
              </tr>
            </thead>
            <tbody>
             <c:set var="total" value="0" />
             <c:forEach items="${cList }" var="list" varStatus="vs">
              <tr>
                <td>
                  <div class="media">
                    <div class="d-flex">
                      <img src="../resources/upload/product/${list.pimg }" alt="" /><!-- 이미지경로 -->
                    </div>
                    <div class="media-body">
                      <p>${list.pname }</p><!-- 상품명 -->
                      
                    </div>
                  </div>
                </td>
                <td>
                  <h5>${list.price } won</h5><!-- 개당가격 -->
                  <input type="hidden" id="price" value="${list.price }">
                </td>
                <td>
                  <h5>${list.count }</h5><!-- 수량 -->
                </td>
                <td>                
                  <h5>${list.sum }</h5><!-- 수량*가격 -->
                </td>
                <td>                
                  <input type="button" value="삭제" class="genric-btn default-border circle arrow"
                  	onclick="javascript:cDel('${list.cnum}', '${list.pname }')"><!-- 삭제 -->
                  <input type="hidden" id="sname" name="sname" value="${list.sname }" >
                </td>
              </tr>
              
              <c:set var = "total" value="${total + list.sum }" />
             </c:forEach>
              <tr>
                <td></td>
                <td></td>
                <td>
                  <h5>subtotal</h5>
                </td>
                <td>
                  <h5><c:out value="${total }"/></h5>
                </td>
                <td></td>
              </tr>
            </tbody>
          </table>
          
          
          <div class="checkout_btn_inner float-right">
            <a class="btn_1" href="/product/productList">Continue Shopping</a>
            <a class="btn_1 checkout_btn_1" href="/order/oCheck">Proceed to checkout</a>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--================End Cart Area =================-->
  
  <script>
	function cDel(cnum, pname){
		var num=cnum;
		if(confirm(pname+"을(를) 장바구니에서 삭제하시겠습니까?")){
			location.href="/cart/cDelete?cnum="+num;

		}
	}
		
  </script>
  
  <%@include file ="/WEB-INF/views/include/footer.jsp" %>
