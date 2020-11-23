<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/managerHeader.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 
<br><br>
   <section class="confirmation_part section_padding">
    <div class="container">    
       <div class="row">
        <div class="col-lg-12">
            <table class="table table-borderless">
              <thead>
                <tr >
                <th scope="col">Product</th>
                <th scope="col">Title</th>
                <th scope="col">Date</th>
                </tr>
              </thead>
              <tbody>
	              <c:forEach items="${sQlist }" var="list" varStatus="vs">
		              <tr onclick="location.href='/qna/detail/${list.qnum }'" style="cursor:pointer">
		             	<td>
		           		 <h5>${list.pname }</h5>
		                </td>
		                
		            	<td>
		           		 <h5>${list.title } [<span>${list.replyCnt}</span>]</h5>
		                </td>
		                
						<td>
		           		 <h5>${list.create_date }</h5>
		                </td>
		              </tr>
	              </c:forEach>
              </tbody>
              

            </table>
          </div>
        </div>
      </div>

</section><!-- 헤더 섹션닫음 --> 

<%@include file ="/WEB-INF/views/include/footer.jsp" %>
