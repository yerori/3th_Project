<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/aHeader.jsp" %>
 <style>
   a{
   color:black;}
</style>
<br><br>
   <section class="confirmation_part section_padding">
    <div class="container"> 
       <h4 align="center">All Order</h4><br>   
       <div id="count" align="left">총 가게 수: ${count }</div>
       <div class="row">
        <div class="col-lg-12">
            <table class="table table-borderless">
            <thead>
              <tr>
                <th scope="col">OrderNum</th>
                <th scope="col">UserID</th>  
                <th scope="col">UserName</th>               
                <th scope="col">Order Count</th>
                <th scope="col">Total Price</th>
                <th scope="col">OrderDate</th>
              </tr>
            </thead>
            <tbody>
             <c:forEach items="${list}" var="list" varStatus="vs">
              <tr style = "cursor:pointer;" onClick = "location.href='/admin/'" >
                <td>
           		 <h5>${list.ordernum}</h5>
                </td>
                
                <td>
           		 <h5>${list.userid}</h5>
                </td>
                
                <td>
           		 <h5>${list.name}</h5>
                </td>
                
                <td>
           		 <h5>${list.sum}</h5>
                </td>
                                
                <td>
           		 <h5>${list.total}</h5>
                </td>
                 <td>
           		 <h5>${list.create_date}</h5>
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
	$.get("/admin/aOsearch",
			{"pageNum":pageNum, "field":field, "word":word},
			function(resp){
				
				var countStr = "<p>검색 건 수: "+resp.count+"</p>";
				$("#count").html(countStr);
				
				var htmlStr = "";
				$.each(resp.olist, function(key, val){
					htmlStr+="<tr>";
					htmlStr+="<td><h5>"+val.ordernum+"</h5></td>";
					htmlStr+="<td><h5>"+val.userid+"</h5></td>";
					htmlStr+="<td><h5>"+val.name+"</h5></td>";
					htmlStr+="<td><h5>"+val.sum+"</h5></td>";
					htmlStr+="<td><h5>"+val.total+"</h5></td>";
					htmlStr+="<td><h5>"+val.create_date+"</h5></td>";
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