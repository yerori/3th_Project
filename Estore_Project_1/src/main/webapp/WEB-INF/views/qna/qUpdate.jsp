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

<form  id="frm" method="post" action="/qna/update">
<input type="hidden" name="qnum" id="qnum" value="${qna.qnum }">
	<div class="col-lg-8">
		<h3>Update My QnA</h3><br>
		<div class="col-md-6 form-group p_star">
			<p>QnA Title </p>
		</div>    
		<input type="text" id="title" name="title" 
			value=${qna.title } class="single-input">
		<br>
		<div class="col-md-6 form-group p_star">
			<p>QnA Content </p>
		</div> 			
		<textarea class="single-textarea1" id="content" name="content">${qna.content }</textarea>
		<br>				
	</div>
	<br>
	<!-- 등록버튼 -->
	<div class="container box_1170 border-top-generic" >
		<div class="button-group-area">
			<Button type="submit" class="genric-btn success large">Update</Button>
		</div>			
	</div> 
</form>

<%@include file ="/WEB-INF/views/include/footer.jsp" %>