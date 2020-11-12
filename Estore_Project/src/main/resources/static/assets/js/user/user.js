var type = /^[0-9]{3}-[0-9]{4}-[0-9]{4}$/;

$(function(){
	$("#joinBtn").click(function(){
		alert("회원가입 버튼 누름")
		if($("#name").val()==""){
			alert("이름을 입력하세요");
			$("#name").focus();
			return false;
		}
		
		if($("#username").val()==""){
			alert("이메일을 입력하세요");
			$("#username").focus();
			return false;
		}
		
		if($("#password").val()==""){
			alert("비밀번호를 입력하세요");
			$("#password").focus();
			return false;
		}
		
		if($("#pw_check").val()==""){
			alert("비밀번호를 확인을 해주세요");
			$("#pwd").focus();
			return false;
		}
		
		if($("#addr").val()==""){
			alert("주소를 입력하세요");
			$("#pwd").focus();
			return false;
		}
		
		if($("#phone").val()==""){
			alert("전화번호를 입력하세요");
			$("#phone").focus();
			return false;
		}
		
		if(!("#phone").val().match(type)){
			alert("전화번호 입력 양식이 아닙니다.");
			$("phone").focus();
			return false;
		}
		
		$("#frm").submit();
	});
	
	
	//아이디 중복확인
	$("#email_checkBtn").click(function(){
		if(!$("#username").val().match(/@/)){
			$("#emailcheck").html("이메일 형식이 아닙니다.");
			$("#emailcheck").css("color", "red");
			$("#username").focus();
			return false;
		}
		if($("#username").val()==""){
			alert("이메일을 입력하세요");
			$("#username").focus();
			return false;
		}
		$.ajax({
			type:"post",
			url:"/user/emailCheck",
			data : {"username": $("#username").val()}
	})
	.done(function(resp){
		if(resp.trim()=="no"){
			$("#emailcheck").html("사용이 불가능한 이메일입니다.");
			$("#username").css("background-color", "red");
			$("#emailcheck").focus();
            $("#emailcheck").val("");
		}else{
			$("#emailcheck").html("사용이 가능 이메일입니다.");
			$("#emailcheck").css("color","blue");
		}
	})
		
	});	
	
	//비밀번호 확인
	$("#pw_checkBtn").click(function(){
		if($("#password").val()==$("#password2").val()){
			$("#pwcheck").html("비밀번호로 사용할 수 있습니다.");
			$("#pwcheck").css("color","blue");
			
		}
		else{
			$("#pwcheck").html("비밀번호가 다릅니다.");
			$("#pwcheck").css("color","red");
		}	
		
	});	
	
});
	







































