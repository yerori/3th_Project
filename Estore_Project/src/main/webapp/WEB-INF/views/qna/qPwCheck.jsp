<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
form{
align=left;
margin:20px
}
</style>
<body>
<form>
<input type="hidden" name="qnum" id="qnum" value="${qnum }">
	<div class="col-lg-8">
		<h3>Password Check</h3><br>
			<div class="col-md-6 form-group p_star">
				<p>Please enter your QnA Password</p>
			</div>    
				<input type="password" id="password" name="password" class="single-input">
					<br>
					<!-- 등록버튼 -->
			<div class="container box_1170 border-top-generic" >
				<div class="button-group-area">
					<Button type="button" id="checkBtn" class="genric-btn success large">Enter</Button>
				</div>			
			</div>
		</div>
</form>

<script>
$("#checkBtn").on("click",function(){
	if($("#password").val()==""){
		alert("비밀번호를 입력하세요");
		$("#password").focus();
		return false;
	 }

	$.ajax({
		type:"post",
		url:"/qna/pwcheck",
		data:{"qnum":$("#qnum").val(),"password":$("#password").val()}
	})	
	
	.done(function(resp){
		if(resp=="no"){
			alert("비밀번호가 틀렸습니다. 확인해주세요");
			return false;
		}
		else {
			location.href="/qna/detail/"+$("#qnum").val();
		}
		
	})
	
	.fail(function(e){
		alert("실패"+e);
	}) 
})

</script>
<%@include file ="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>