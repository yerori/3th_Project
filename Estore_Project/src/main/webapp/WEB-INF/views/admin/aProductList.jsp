<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/aHeader.jsp" %>
  <style>
   a{
   color:black;}
</style>
<br><br><br>
  <section class="confirmation_part section_padding">

	<div class="container">
	
	  <h4 align="center">All Product</h4>
	   <div id="count" align="left">등록 제품 수: ${count }</div>
		
      <div class="cart_inner">
        <div class="table-responsive">
          <table class="table">
            <thead>
              <tr>
                <th scope="col">ShopName</th>
                <th scope="col">Type</th>
                <th scope="col">Product</th>
                <th scope="col">Price</th>
              </tr>
            </thead>
            <tbody>
             <c:forEach items="${list }" var="list" varStatus="vs">    
              <tr style = "cursor:pointer;" onClick = "location.href='/product/productDetail/${list.pnum}' ">
                <td>${list.sname }</td>
                <td>${list.ptype }</td>
                <td >
                  <div class="media">
                    <div class="d-flex">
                      <img src="/resources/upload/product/${list.pimg }" alt="" /><!-- 이미지경로 -->
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
          
          <div id="pageArea" align="center">
          	${pageHtml }
          </div>
          
          <div>
          	<form name="search" id="search">
          		<select name="field" id="field">
          		   <option value="sname">가게명</option>
					<option value="pname">제품명</option>					
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

	var src= "/resources/upload/product/";
	$.get("/admin/pSearch",
			{"pageNum":pageNum, "field":field, "word":word},
			function(resp){
				//alert(resp.list);
				var countStr = "<p>검색 제품 수: "+resp.count+"</p>";
				$("#count").html(countStr);
				
				var htmlStr = "";
				$.each(resp.list, function(key, val){
					htmlStr+="<tr>";
					htmlStr+="<td>"+val.sname+"</td>";
					htmlStr+="<td>"+val.ptype+"</td>";

					htmlStr+="<div class='media'>";
					htmlStr+="<div class='d-flex'>";
					htmlStr+="<img src='"+src+val.pimg+"'/> </div>";
					htmlStr+="<div class='media-body'>";
					htmlStr+="<p>"+val.pname+"</p>";
					htmlStr+="</div></div>";					
					htmlStr+="<td>"+val.pname+"</td>";
					htmlStr+="<td><h5>"+val.price +"</h5></td>";
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
