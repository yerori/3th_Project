<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/uHeader.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<br><br>
   <section class="confirmation_part section_padding">
    <div class="container">    
       <div class="row">
        <div class="col-lg-12">
            <table class="table table-borderless">
              <thead>
                <tr>
                <th scope="col">Order Date</th>
                <th scope="col">Order Num</th>
                <th scope="col">Order Count</th>
                <th scope="col">Order Total Price</th>
                <th scope="col">orderState</th>
                </tr>
              </thead>
              <tbody>
            <c:forEach items="${uOlist }" var="list" varStatus="vs">
              <tr>
             	<td>
           		 <h5>${list.create_date }</h5>
                </td>
              
                <td>
           		 <h5>${list.ordernum }</h5>
                </td>
                
                <td>
           		 <h5>${list.sum }</h5>
                </td>
                
                <td>
           		 <h5>${list.total}</h5>
                </td>
   
                <td>
                  <h5 onclick="location.href='/user/uOdetail/${list.ordernum }'">조회</h5>
                </td>
              </tr>
              
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

</section><!-- 헤더 섹션닫음 -->

  
  

  

  
  <%@include file ="/WEB-INF/views/include/footer.jsp" %>
