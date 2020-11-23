var type = /^[0-9]{3}-[0-9]{4}-[0-9]{4}$/;

$(function(){
	//회원가입 선택
	$("#preBtn").click(function(){
		if($("#agreechkbox").prop("checked")==false){
			alert("필수 약관 동의를 체크해주세요.");
			return false;
		}
		if($("input:radio[value='user']").prop("checked")==true){
			location.href="/uInsert";
		}
		
		else if($("input:radio[value='seller']").prop("checked")==true){
			location.href="/sInsert";
		}			
	});
	
	$("#joinBtn").click(function(){
	
		if($("#name").val()==""){
			alert("이름을 입력하세요");
			$("#name").focus();
			return false;
		}
		
		if($("#email").val()==""){
			alert("이메일을 입력하세요");
			$("#email").focus();
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
		if(!$("#phone").val().match(type)){
			alert("전화번호 입력 양식이 아닙니다.");
			$("phone").focus();
			return false;
		}
		
		$("#frm").submit();
			alert("성공적으로 회원가입이 완료되었습니다.")
	});
	
	
	//아이디 중복확인
	$("#email_checkBtn").click(function(){
		if(!$("#email").val().match(/@/)){
			$("#emailcheck").html("이메일 형식이 아닙니다.");
			$("#emailcheck").css("color", "red");
			$("#email").focus();
			return false;
		}
		if($("#email").val()==""){
			alert("이메일을 입력하세요");
			$("#email").focus();
			return false;
		}
		$.ajax({
			type:"get",
			url:"/emailCheck",
			data : {"email": $("#email").val()}
	})
	.done(function(resp){
		if(resp.trim()=="no"){
			$("#emailcheck").html("사용이 불가능한 이메일입니다.");
			$("#emailcheck").css("color", "red");
			$("#emailcheck").focus();
            $("#emailcheck").val("");		

		}else{			
			$("#emailcheck").html("사용 가능한 이메일입니다.");
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
	
	$("#addr_checkBtn").click(function() {
         new daum.Postcode({
             oncomplete: function(data) {
	
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
             
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
               
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }
 
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                console.log(data.zonecode);
                console.log(fullRoadAddr);
                
				document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
				document.getElementById('addr').value = fullRoadAddr;
				document.getElementById('addr2').focus();
				
            }
         })
		.open();
     });

});
	







































