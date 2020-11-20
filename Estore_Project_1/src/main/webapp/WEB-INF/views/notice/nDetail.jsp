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
function ndelete(nnum){
	if(confirm(nnum+"번째 게시글을 삭제하시겠습니까?")){
		$.get("/notice/delete", {"nnum" : nnum},
			function (resp){
				if(resp=="success")
					alert("삭제 되었습니다.");
						location.href="/notice/list";
			}
		)
	}
}
</script>
 

<section class="about_us padding_top">
      <div class="container">
          <div class="row justify-content-center">
              <div class="about_us_content">
                  <h5>Notice Num : ${notice.nnum }</h5>
                 <h3>${notice.title }</h3>
                 <div class="single_product_img">
                      <img src="../resources/upload/notice/${notice.nimg }" alt="#" class="img-fluid">
                     	<p>${notice.content}</p>
                 </div>
             </div>                            
          </div>
          <section class="button-area">
			<div class="container box_1170 border-top-generic" align="center">
				<div class="button-group-area">
					<a href="/notice/update/${notice.nnum}" class="genric-btn primary">Update</a>
					<a href="javascript:ndelete(${notice.nnum })" class="genric-btn primary">Delete</a>
				</div>			
			</div>
		</section>
	</div>  
</section>
  
 

 
 
<%@include file ="/WEB-INF/views/include/footer.jsp" %>