<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/managerHeader.jsp" %>

<br><br><br>
  <section class="confirmation_part section_padding">

	<div class="container">
	
	  <h4 align="center">My Product</h4>
	
	  <div align="right">
	  	<input type="button" value="Add Item" class="genric-btn default"
	  		onclick="location.href='/product/productInsert'">
	  </div>
		
      <div class="cart_inner">
        <div class="table-responsive">
          <table class="table">
            <thead>
              <tr>
                <th scope="col">Type</th>
                <th scope="col">Product</th>
                <th scope="col">Price</th>
              </tr>
            </thead>
            <tbody>
             <c:forEach items="${list }" var="list" varStatus="vs">    
              <tr style = "cursor:pointer;" onClick = "location.href='/product/productDetail/${list.pnum}' ">
                <td>${list.ptype }</td>
                <td >
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
                </td>


              </tr>
              
             </c:forEach>

            </tbody>
          </table>
        </div>
      </div>
    </div>
</section>

<script>
	function sDel(pnum){
		
	}
	
</script>

 
<%@include file ="/WEB-INF/views/include/footer.jsp" %>
