<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>

#frm{
margin:20px;
}
#imgdiv{
margin:20px;
}
#content{
/* margin:10px; */
}

</style>

<form  id="frm" method="post" action="/notice/update" enctype="multipart/form-data" data-ajax="false" >
<input type="hidden" value="${notice.create_date }" id="create_date" name="create_date">
		<div class="col-lg-8">
			<h3>Detailed Notice</h3><br>
				<div class="col-md-6 form-group p_star">
					<p>Notice Num </p>
				</div>    
					<input type="text" id="title" name="title" 
						value=${notice.title } class="single-input">
						<br>
				<div class="col-md-6 form-group p_star">
					<p>Notice Content </p>
				</div> 			
				<textarea class="single-textarea1" id="content" name="content">${notice.content }</textarea>
				<br>
				<div class="col-md-6 form-group p_star">
					<p>Attachment </p>
				</div>
					<input type="text" id="nimg" name="nimg" value=${fileName } class="single-input">
					<div class="mt-10">
		              <!-- 이미지 업로드 -->		             	
		             	<input type="file" name="uploadFile" id="nimg" value="${notice.nimg }">  
				</div>
			</div>
			<br>
			<!-- 등록버튼 -->
			<section class="button-area" align="center">
				<div class="container box_1170 border-top-generic" >
					<div class="button-group-area">
						<Button type="submit" class="genric-btn success large">Update the notice</Button>
					</div>			
				</div>
			</section>
    
  
</form>

<%@include file ="/WEB-INF/views/include/footer.jsp" %>