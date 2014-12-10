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
	function find_selected(selected){
		
		var name = document.getElementById("name");
		var email = document.getElementById("email");
		var hp1 = document.getElementById("hp1");
		var hp2 = document.getElementById("hp2");
		var hp3 = document.getElementById("hp3");
		
		if(name.value == "")	{
			alert("가입자 이름을 입력해 주세요.");
			name.focus();
			return;
		}
		if(email.value == "")	{
			alert("가입자 이메일 주소를 입력해주세요.");
			email.focus();
			return;
		}
		if(hp1.value == "")	{
			alert("가입자 휴대폰 번호를 입력해주세요.");
			hp1.focus();
			return;
		}
		if(hp2.value == "")	{
			alert("가입자 휴대폰 번호를 입력해주세요.");
			hp2.focus();
			return;
		}
		if(hp3.value == "")	{
			alert("가입자 휴대폰 번호를 입력해주세요.");
			hp3.focus();
			return;
		}
		
		document.form.action = "findIdPwPro.do?selected="+selected;
		document.form.submit();
	}
</script>
</head>
<body>
	<!-- header -->
	<%@ include file="/common/header.jsp"%>
	<!-- end of header -->
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form id="form" name="form" class="form-inline" role="form" onclick="return false;" method="post">
					
					<h3 class="form-signin-heading">아이디 / 패스워드 찾기.</h3>

					<table class="table table-bordered">
						<tbody>
							<tr>
								<td style="background-color: #A9A9A9">이름</td>
								<td><input type="text" class="form-control" id="name" name="name"></td>
							</tr>
							<tr>
								<td style="background-color: #A9A9A9">이메일</td>
								<td><input type="text" class="form-control" id="email" name="email"></td>
							</tr>
							<tr>
								<td style="background-color: #A9A9A9">핸드폰</td>
								<td>
									<div class="form-group">
										<input type="text" class="form-control" id="hp1" name="hp1" maxlength="4">
									</div>-
									<div class="form-group">
										<input type="text" class="form-control" id="hp2" name="hp2" maxlength="4">
									</div>-
									<div class="form-group">
										<input type="text" class="form-control" id="hp3" name="hp3" maxlength="4">
									</div>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="form-group">
						<button type="button" class="btn btn-primary" onclick="find_selected('1')">아이디찾기</button>
						<button type="button" class="btn btn-primary" onclick="find_selected('2')">비밀번호찾기</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
	<script src="//code.jquery.com/jquery.js"></script>
	<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
	<script src="dist/js/bootstrap.min.js"></script>

	<!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
	<!-- <script src="js/respond.js"></script> -->
</body>
</html>