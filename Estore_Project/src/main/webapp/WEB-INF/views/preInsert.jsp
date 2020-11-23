<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.col-lg-12{
padding-left:150px;
padding-right:150px;
}
.panel-body{
	margin:10px;
}

$color1: #f4f4f4;
$color2: #3197EE;

body {
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
}

.radio {
  margin: 0.5rem;
  input[type="radio"] {
    position: absolute;
    opacity: 0;
    + .radio-label {
      &:before {
        content: '';
        background: $color1;
        border-radius: 100%;
        border: 1px solid darken($color1, 25%);
        display: inline-block;
        width: 1.4em;
        height: 1.4em;
        position: relative;
        top: -0.2em;
        margin-right: 1em; 
        vertical-align: top;
        cursor: pointer;
        text-align: center;
        transition: all 250ms ease;
      }
    }
    &:checked {
      + .radio-label {
        &:before {
          background-color: $color2;
          box-shadow: inset 0 0 0 4px $color1;
        }
      }
    }
    &:focus {
      + .radio-label {
        &:before {
          outline: none;
          border-color: $color2;
        }
      }
    }
    &:disabled {
      + .radio-label {
        &:before {
          box-shadow: inset 0 0 0 4px $color1;
          border-color: darken($color1, 25%);
          background: darken($color1, 25%);
        }
      }
    }
    + .radio-label {
      &:empty {
        &:before {
          margin-right: 0;
        }
      }
    }
  }
}
</style>

</head>
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>
<body>
<form >
 <!-- slider Area Start-->
        <div class="slider-area ">
            <!-- Mobile Menu -->
            <div class="single-slider slider-height2 d-flex align-items-center" data-background="/assets/img/hero/category.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="hero-cap text-center">
                                <h2>Join Form</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div><br><br><br>
<div class="panel-body">
    <div class="row">
        <div class="col-lg-12">
            <h4>이용약관</h4>
            <div class="panel-body" style="border: 1px solid #ccc">
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
        </div>
        </br>
        <h4>개인정보</h4>
        <div class="panel-body" style="border: 1px solid #ccc">
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
        </div>
        <br/>
            <div class="form-group" align="center">
                <label class="checkbox-inline">
                    <input id="agreechkbox" type="checkbox" name="agreechkbox" value="true" checked>동의합니다.
                </label>
                </div>
                <div class="container" align="center">
			  <div class="radio">
			    <input id="radio-1" name="radio" type="radio" value="user" checked>
			    <label for="radio-1" class="radio-label">일반 회원으로 회원가입</label>
			    <input id="radio-2" name="radio" value="seller" type="radio">
			    <label  for="radio-2" class="radio-label">일반 셀러로 회원가입</label>
			  </div>
			<button type="button" class="btn_3" id="preBtn">
				회원가입하기
			</button>
			
		    </div>
        </div>    
    </div>
</div>
<script src="/assets/js/join/insert.js"></script>
</form>
</body>
   <%@include file ="/WEB-INF/views/include/footer.jsp" %>
</html>