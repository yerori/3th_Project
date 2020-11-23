<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
p{
width:100%;
}

</style>
 <script>
function sDelete(email, sname){
	if(confirm(sname+"이란 Shop을 삭제하시겠습니까?")){
		$.get("/admin/sDelete", {"email" : email},
			function (resp){
				if(resp=="success"){
					alert("삭제 되었습니다.");
						location.href="/admin/sInfo";
				}
			}
		)
	}
}
</script>
 

<section class="about_us padding_top">
      <div class="container">
          <div class="row justify-content-center">
              <div class="about_us_content">
                  <h5>Shop Seller : ${shop.name }</h5>
                 <h3>Shop Name : ${shop.email }</h3>
                 <p>Shop Address : ${shop.addr }</p>
                 <p>Shop Phone : ${shop.phone }</p>
             </div>                            
          </div>
          <section class="button-area">
			<div class="container box_1170 border-top-generic" align="center">
				<div class="button-group-area">
					<a href="javascript:sDelete('${shop.email }', '${shop.sname }')" class="genric-btn primary">Delete</a>
				</div>			
			</div>
		</section>
	</div>  
</section>
  

 
 
<%@include file ="/WEB-INF/views/include/footer.jsp" %>