<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/managerHeader.jsp" %>
 <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
 
<div class="section-top-border">
    <div class="container">
      <div class="returning_customer" id="passCheck">
          <div class="col-md-6 form-group p_star" >
          	<label for="password">Password:</label>
            <input type="password" class="form-control" id="pass" name="pass" />
            <span id="pwerror"></span>
            <input type="button" value="check" id="btnPcheck">
          </div>
      </div>
      
            <div class="returning_customer" id="myInfo">
			<div class="col-md-6 form-group p_star" >
				<label for="userid">Email : </label>
   				<input type="text" class="form-control" id="email" name="email" value=${sInfo.email }>
			</div>
			
			<div class="col-md-6 form-group p_star" >
				<label for="name">Name : </label>
   				<input type="text" class="form-control" id="name" name="name" value=${sInfo.name }>
			</div>
			
			<div class="col-md-6 form-group p_star" >
				<label for="pwd_check">Password : </label>
   				<input type="password" class="form-control" id="password" name="password">
			</div>			
			
			<div class="col-md-6 form-group p_star" >
				<label for="name">ShopNAME : </label>
    			<input type="text" class="form-control" id="sname" name="sname" value="${sInfo.sname }">
			</div>
		
			<div class="col-md-6 form-group p_star" >
				<label for="phone">Phone : </label>
    			<input type="text" class="form-control" id="phone" name="phone" value="${sInfo.phone }">
			</div>
						
			<div class="col-md-6 form-group p_star" >
				<label for="pwd">Address : </label>
				<input type="text" class="form-control" id="zipcode" name="zipcode" readonly="readonly" value="${sInfo.zipcode }">			 	
			  	<button type="button" class="btn_3" id="addr_checkBtn"><i class="fa fa-search"></i> 우편번호 찾기</button> 			  	
			</div>
			<div class="col-md-12 form-group p_star" >
				<input class="form-control" style="top: 5px;" name="addr" id="addr" type="text" value="${sInfo.addr }"/>
			</div>
			<div class="col-md-12 form-group p_star" >
				<input class="form-control" placeholder="상세주소" name="addr2" id="addr2" type="text"  />
			</div> 	
			<div class="col-md-12 form-group p_star" >			
				<input type="button" value="수정완료" id="btnUpdateU" class="btn_3">
			</div>
	  </div>
	</div>
</div>

  </section><!-- 헤더 섹션닫음 -->
  
<script src="/assets/js/join/insert.js"></script>  
  <script src="/assets/js/shop/shopInfo.js"></script>
<%@include file ="/WEB-INF/views/include/footer.jsp" %>

    