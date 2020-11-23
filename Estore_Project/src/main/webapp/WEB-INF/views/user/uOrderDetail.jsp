<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/uHeader.jsp" %>
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
                <p>address : ${info.address }</p>
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
                  <th>${list.orderstate }</th>
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
        </div>
      </div>
    </div>
    <div>
    
	</div>
</section>

<%@include file ="/WEB-INF/views/include/footer.jsp" %>
