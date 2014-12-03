<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>학사정보시스템</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- 부트스트랩 -->
    <link href="dist/css/bootstrap.css" rel="stylesheet" media="screen">
    
    <!-- Custom styles for this template -->
    <link href="dist/customcss/starter-template.css" rel="stylesheet">
	
  <script type="text/javascript">
  	function valcheck() {
  		var pw = document.getElementById("password");
  		var pw2 = document.getElementById("password2");
  		if(pw.value == "") {
  			alert("비밀번호를 입력하세요.");
  			pw.focus();
  			return false;
  		}
  		
  		if(pw2.value == "") {
  			alert("비밀번호를 입력하세요.");
  			pw2.focus();
  			return false;
  		}
  		
  		if(pw.value != pw2.value) {
  			alert("입력하신 비밀번호가 다릅니다.\n다시입력 하세요.");
  			pw.value="";
  			pw2.value="";
  			pw.focus();
  			return false;
  		}
   }
  	

  </script>
</head>
 <body >
<!-- header -->
<%@ include file="/common/header.jsp"%>
<!-- end of header -->

<div align="center" style="margin-top: 100px">
	<form class="form-signin" style="width: 30%" action="pwModifyPro.do" method="post" onsubmit="return valcheck();" >
        <h2 class="form-signin-heading">변경할 비밀번호를 입력하세요.</h2>
        <input type="password" name="password" id="password" class="form-control" placeholder="Password">
        <input type="password" name="password2" id="password2" class="form-control" placeholder="Password Confirm" style="margin-top: 10px">
        <button class="btn btn-lg btn-primary btn-block" type="submit" style="margin-top: 10px">확인</button>
    </form>
   </div>

   <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
   <script src="//code.jquery.com/jquery.js"></script>
   <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
   <script src="dist/js/bootstrap.min.js"></script>
   
   <!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
   <!-- <script src="js/respond.js"></script> -->
   
 </body>
</html>