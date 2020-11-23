<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/managerHeader.jsp" %>
   <style>
   a{
   color:black;}
</style>
<br><br>
   <section class="confirmation_part section_padding">
    <div class="container"> 
       <h4 align="center">Total Order</h4>
       <div class="row">
        <div class="col-lg-12">
            <table class="table table-borderless">
            <thead>
              <tr>
                <th scope="col">Ordernum</th>
                <th scope="col">UserName(주문자이름)</th>
                <th scope="col">UserID(주문자아이디)</th>
                <th scope="col">Total Count</th>
                <th scope="col">Total price</th>
                <th scope="col">orderDate</th>
                <th scope="col">orderState</th>
              </tr>
            </thead>
            <tbody>
             <c:forEach items="${sOlist }" var="list" varStatus="vs">
              <tr style = "cursor:pointer;" onClick = "location.href='/shop/orderDetail/${list.ordernum}'" >
                <td>
           		 <h5>${list.ordernum }</h5>
                </td>
                
                <td>
           		 <h5>${list.name}</h5>
                </td>
                
                <td>
           		 <h5>${list.userid}</h5>
                </td>
                                
                <td>
           		 <h5>${list.sum}</h5>
                </td>
                
                <td>
           		 <h5>${list.total}</h5>
                </td>
                
                <td>
           		 <h5>${list.create_date }</h5>
                </td>
                
                <td>
                  <h5>${list.orderstate }</h5>
                </td>
              </tr>
              
             </c:forEach>
            </tbody>
          </table>
          
          <div id="pageArea" align="center">
          	${pageHtml }
          </div>
          
          <div>
          	<form name="search" id="search">
          		<select name="field" id="field">
					<option value="name">주문자명</option>
					<option value="userid">주문자아이디</option>
				</select>
				<input type="text" name="word" id="word">
				<input type="button" value="찾기" id="btnSearch" class="btn btn-default">
          	</form>          
          </div>    
                
        </div>
      </div>
	</div>
</section>

<script>
function getData(pageNum, field, word){
	$.get("/shop/oSearch",
			{"pageNum":pageNum, "field":field, "word":word},
			function(resp){
				//alert(resp.list);
				var countStr = "<p>검색 제품 수: "+resp.count+"</p>";
				$("#count").html(countStr);
				
				var htmlStr = "";
	            $.each(resp.list, function(key, val){
	                htmlStr+="<tr style = 'cursor:pointer;'>";
	                htmlStr+="<td><h5>"+val.ordernum+"</h5></td>";
	                htmlStr+="<td><a href='/shop/orderDetail/"+val.ordernum+"'><h5>"+val.name+"</h5></a></td>";
	                htmlStr+="<td><a href='/shop/orderDetail/"+val.ordernum+"'><h5>"+val.userid+"</h5></a></td>";
	                htmlStr+="<td><h5>"+val.sum+"</h5></td>";
	                htmlStr+="<td><h5>"+val.price+"</h5></td>";
	                htmlStr+="<td><h5>"+val.create_date+"</h5></td>";
	                htmlStr+="<td><h5>"+val.orderstate +"</h5></td>";
	             });
				$("table tbody").html(htmlStr);
				
				var pageStr="<div align='center'>"+resp.pageHtml+"</div>";
				$("#pageArea").html(pageStr);
					
				
			}//get function
	)//get
}//function

$("#btnSearch").click(function(){
	getData("1",$("#field").val(),$("#word").val());
});

	
</script>



<%@include file ="/WEB-INF/views/include/footer.jsp" %>
