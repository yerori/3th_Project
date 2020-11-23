<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/aHeader.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<br><br>
   <section class="confirmation_part section_padding">
    <div class="container">    
    <h4 align="center">All Contact</h4><br><br>
       <div class="row">
        <div class="col-lg-12">
            <table class="table table-borderless">
              <thead>
                <tr >
                <th scope="col">No</th>
                <th scope="col">Title</th>
                <th scope="col">Writer</th>
                <th scope="col">Email</th>
                <th scope="col">Date</th>
                </tr>
              </thead>
              <tbody>
	              <c:forEach items="${contact }" var="contact" varStatus="vs">
		              <tr onclick="location.href='/admin/cDetail/${contact.cnum }'" style="cursor:pointer">
		             	<td>
		           		 <h5>${contact.cnum }</h5>
		                </td>
		                
		                <td>
		           		 <h5>${contact.title }</h5>
		                </td>
		                
		            	<td>
		           		 <h5>${contact.name }</h5>
		                </td>
		                
		                <td>
		           		 <h5>${contact.email }</h5>
		                </td>
		                
						<td>
		           		 <h5>${contact.create_date }</h5>
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