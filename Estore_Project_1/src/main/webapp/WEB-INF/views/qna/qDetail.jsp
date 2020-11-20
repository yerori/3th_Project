<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
p{
 	 font-size: 20px;
}
.title{
	font-weight:bold;
}
a{
	color:black;
}

.frm{
	margin:30px;
}

.table{
	width:82%;
}
</style>

<script>
function qdelete(qnum){
	if(confirm(qnum+"번째 게시글을 삭제하시겠습니까?")){
		$.get("/qna/delete", {"qnum" : qnum},
			function (resp){
				if(resp=="success")
					alert("삭제 되었습니다.");
						location.href="/";
			}
		)
	}
}
</script>
<div class="frm">
        <div class="about_us_content" id="title">
            <h5>QnA Num : ${qna.qnum }</h5>
          <h3>Title : ${qna.title }</h3>
          <h3>Writer : ${qna.email }</h3>
              <p>${qna.content}</p>
        </div>     
	<br>
		<div class="button-group-area">
			<a href="/qna/update/${qna.qnum}" class="genric-btn primary">Update</a>
			<a href="javascript:qdelete(${qna.qnum })" class="genric-btn primary">Delete</a>
					
	</div>
	<br><br><br><br>

	<div class="billing_details" id="writearea" align="center">
		<div class="col-lg-8" align="left">
			<h3>Write Comment</h3>
			<form class="row contact_form" action="#" method="post" novalidate="novalidate">              
				<div class="col-md-12 form-group">
					<textarea class="form-control" name="message" id="message" rows="1"
						placeholder="Enter the Comment"></textarea>
				</div>
				<div class="container box_1170 border-top-generic" align="center">
					<div class="button-group-area">
						<Button type="button" id="insertBtn" class="genric-btn success large">Write</Button>
					</div>			
				</div>
			</form>
		</div>
	</div><br><br><br>
	<div id="listarea"></div>	
 </div> 
<script>

$("#insertBtn").on("click",function(){
	if($("#message").val()=="") {
		alert("댓글 내용을 입력하세요");
	}
	var comData = {"qnum":${qna.qnum}, 
					"uemail":${qna.email }, 
					"content":$("#message").val()}	

	$.ajax({
		type:"post",
		url:"/comment/insert",
		contentType : "application/json;charset=UTF-8",
		data:JSON.stringify(comData)
	})
	
	.done(function(resp){
		alert("댓글이 성공적으로 등록되었습니다.");
		list();
	})
	.fail(function(error){
		alert(error+"댓글 실패");
	})
})
var list = function (){
	$.ajax({
		type:"get",
		url:"/comment/list",
		data:{"qnum":${qna.qnum }}
	})
	.done(function(resp){
		var htmlStr = "";
		htmlStr += "<table class='table'>";
		htmlStr += "<tr>";
		htmlStr += "<th scope='col'> Num </th>";
		htmlStr += "<th scope='col'> Content </a></th>";
		htmlStr += "<th scope='col'> Created Date </th>";
		htmlStr += "<th scope='col'> Delete </th></tr>";

		$.each(resp, function(key, val){	
			htmlStr += "<tr>";
			htmlStr += "<td>"+val.cqnum+"</td>";
			htmlStr += "<td>"+val.content+"</td>";			
			htmlStr += "<td>"+val.create_date+"</td>";
			htmlStr += "<td><a onclick='javascript:delFunc("+val.cqnum+")' id='delX'>"+"X"+"</a></td>";
			htmlStr += "</tr>";
		});
		
		htmlStr += "</table>";
		$("#listarea").html(htmlStr);		
	})
	
	.fail(function(error){
		alert("댓글 로드 실패 "+ error);
	})
}

//삭제
function delFunc(cqnum){
	if(confirm(cqnum+"번째 게시글을 삭제하시겠습니까?")){
		$.get("/comment/delete", {"cqnum" : cqnum},
			function (resp){
				if(resp=="success")
					alert("삭제 되었습니다.");
					list();
			}
		)
	}
}

list();
</script>

 
 
<%@include file ="/WEB-INF/views/include/footer.jsp" %>