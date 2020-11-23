$(function(){
	$("#btnUpdateU").click(function(){
		var email = $("#email").val();
		
		var dataParam={
			"password":$("#password").val(),
			"sname":$("#sname").val(),
			"phone":$("#phone").val(),
			"zipcode":$("#zipcode").val(),
			"addr":$("#addr").val(),
			"email": $("#email").val()
		}
		
		$.ajax({
			type:"PUT",
			url:"/shop/sUpdate/"+email,
			data:JSON.stringify(dataParam),
			contentType: "application/json;charset=utf-8"
		})
		.done(function(resp){
			alert("수정이 완료되었습니다");
			location.href="/shop/sInfo";
			
		})
		.fail(function(){
			alert("왜 실패죠....");
		})
	})
	
	//info 안보이게
	$("#myInfo").hide();
  	//비번체크
	$("#btnPcheck").click(function(){
		var pass = $("#pass").val();

		$.ajax({
			type:"get",
			url:"/shop/pCheck",
			data:{"password": pass}
		})
		.done(function(resp){
			if(resp=="1"){//비번일치
				
				$("#passCheck").hide();//비번일치시 비밀번호 부분 안보이게
				$("#myInfo").show();//정보부분 보이게
				
			}else{
				$("#pwerror").html("비밀번호가 틀렸습니다");
			}
		})

	})	
		
})