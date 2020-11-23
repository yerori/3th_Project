<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/uHeader.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <style>
 </style>
  <script src="//code.jquery.com/jquery-latest.min.js"></script>
  <section class="checkout_area section_padding">
        <div class="container">
			<div class="section-top-border">
				<h3 class="mb-30">Latest Order(최근 1달)</h3>					
			</div>
			
	  <div class="cart_inner">
        <div class="table-responsive">
          <table class="table">
            <thead>
              <tr>
                <th scope="col">날짜</th>
                <th scope="col">상품정보</th>
                <th scope="col">상태</th>
                <th scope="col">Review</th>
              </tr>
            </thead>
            
            <tbody>
            
            <c:forEach items="${uMonthList }" var="list" varStatus="vs">  
            
              <tr>
                <td><!-- 날짜 -->
                  <input type="hidden" value="${list.pnum }" id="pnum${vs.index }" name="pnum">
                  <input type="hidden" value="${list.onum }" id="onum${vs.index }" name="onum">
                  <input type="hidden" value="${list.sid }" id="sid${vs.index }" name="sid">
                  
                  <h5>${list.create_date }</h5>
                </td>              
              
                <td><!-- 상품정보 -->
                  <div class="media">
                    <div class="d-flex">
                      <img src="assets/img/arrivel/arrivel_1.png" alt="" />
                    </div>
                    <div class="media-body">
                      <p>${list.pname }</p>
                    </div>
                  </div>
                </td>

                <td><!-- 상태 -->
					<h5>${list.orderstate }</h5>
                </td>
               
                <td><!-- 리뷰 -->
                  <c:if test="${list.review=='X' }"> 
                  	<h5 onclick="javascript:insertFunction(${vs.index })">작성하기</h5>
                  </c:if>
                  <c:if test="${list.review=='O' }">
                  	<h5>작성완료</h5>
                  </c:if>
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
function insertFunction(index){
	
	var index = index;
	var pnum = $("#pnum"+index).val();
	var onum = $("#onum"+index).val();
	var sid = $("#sid"+index).val();
	var insertData = {"pnum":pnum, "onum":onum, "sid":sid}
	location.href="/review/insert?pnum="+pnum+"&onum="+onum+"&sid="+sid;
}
</script>
 
<%@include file ="/WEB-INF/views/include/footer.jsp" %>