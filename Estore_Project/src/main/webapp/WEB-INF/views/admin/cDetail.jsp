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
function sDelete(cnum){
	if(confirm(cnum+"번째 게시글을 삭제하시겠습니까?")){
		$.get("/admin/cDelete", {"cnum" : cnum},
			function (resp){
				if(resp=="success"){
					alert("삭제 되었습니다.");
						location.href="/admin/cList";
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
              	 <h5>Num : ${contact.cnum }</h5>
              	 <h3>Writer : ${contact.name }</h3>
              	 <p>Date : ${contact.create_date }</p>
                  
                 <p>Email : ${contact.email }</p>
                 <p>Title : ${contact.title }</p>
                 <p>Content : ${contact.content }</p>
                 
             </div>                            
          </div>
          <section class="button-area">
			<div class="container box_1170 border-top-generic" align="center">
				<div class="button-group-area">
					<a href="javascript:sDelete(${contact.cnum })" class="genric-btn primary">Delete</a>
				</div>			
			</div>
		</section>
	</div>  
</section>
  

 
 
<%@include file ="/WEB-INF/views/include/footer.jsp" %>