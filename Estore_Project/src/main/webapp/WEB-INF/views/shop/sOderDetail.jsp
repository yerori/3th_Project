<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/managerHeader.jsp" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 
  <section class="confirmation_part section_padding">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="confirmation_tittle"></div>
        </div>
        <div class="col-lg-6 col-lx-4">
          <div class="single_confirmation_details">
            <h4>order info</h4>
            <ul>
              <li>
                <p>order number</p><span>: ${info.ordernum }</span>
              </li>
              <li>
                <p>date</p><span>: ${info.create_date }</span>
              </li>
              <li>
                <p>total</p><span>: ${info.total } won</span>
              </li>
              <li>
                <p>payment method</p><span>: ${info.pay }</span>
              </li>
            </ul>
          </div>
        </div>
        <div class="col-lg-6 col-lx-4">
          <div class="single_confirmation_details">
            <h4>Billing Address</h4>
            <ul>
              <li>
                &nbsp;
              </li>
              <li>
               &nbsp;
              </li>
              <li>
                <p>address : <span>${info.address }</span></p>
              </li>
              <li>
                 &nbsp;
              </li>
              <li>
                &nbsp;
              </li>
            </ul>
          </div>
        </div>
      </div>
    
       <div class="row">
        <div class="col-lg-12">
          <div class="order_details_iner">
            <h3>Order Details</h3>
            <table class="table table-borderless">
              <thead>
                <tr>
                  <th scope="col">Product</th>
                  <th scope="col">Quantity</th>
                  <th scope="col">Total</th>
                  <th scope="col">주문상태</th>
                </tr>
              </thead>
              <tbody>
               <c:set var="total" value="0" />
               <c:forEach items="${list }" var="list" varStatus="vs"> 
               
                <tr>  
               	  
                  <th><span>${list.pname }</span></th>
                  <th>${list.pcount }</th>
                  <th> <span>${list.price }</span></th>
                  <th>
					 
				  	<div >				  	  
				  	  <c:set var="option" value="${list.orderstate }" />
				  	   <input type="hidden" id="onum${vs.index }" name="onum" value="${list.onum }"> 
				  	  	<select id="state${vs.index }" onchange="updateOption(${vs.index })" >
							<option value="주문완료" <c:if test="${option eq '주문완료'}">selected</c:if>>주문완료</option>
							<option value="상품준비중" <c:if test="${option eq '상품준비중'}">selected</c:if>>상품준비중</option>
							<option value="발송완료" <c:if test="${option eq '발송완료'}">selected</c:if>>발송완료</option>
							<option value="배송완료" <c:if test="${option eq '배송완료'}">selected</c:if>>배송완료</option>
						</select>
									
					</div>
					<span id="update${vs.index }"></span>

				  </th>
				  
                </tr>
                <c:set var = "total" value="${total + list.pcount }" />
			   </c:forEach>
              </tbody>
              <tfoot>
                <tr>
                  <th scope="col"></th>
                  <th scope="col">${total }</th>
                  <th scope="col">${info.total }</th>
                  <th scope="col"></th>
                </tr>
              </tfoot>
            </table>

          </div>
                      
            <div>
            <button onclick="location.href='/shop/sOrderList'"  class="btn_3">수정완료</button>
            </div>
            
        </div>
      </div>
    </div>
    <div>
	</div>
</section>
</section><!-- header 섹션 -->
<%@include file ="/WEB-INF/views/include/footer.jsp" %>

<script>

	var index="";
	var option="";
	var onum="";
	function updateOption(index){
		this.index = index;
		this.option = $("#state"+ index + " option:selected").val();	
		this.onum=$("#onum"+ index).val();
		console.log('순서'+index+', 변경옵션'+option+', onum: '+onum);

			$.ajax({
				type: "post",
				url: "/shop/sOupdate",
				data:{"onum":onum, "orderstate":option}
				
			})
			.done(function(resp){
				$("#update"+index).html("수정완료");
				//location.href="/shop/sOrderList";
			})
			.fail(function(error){
				alert(error);
			})
	}

</script>

