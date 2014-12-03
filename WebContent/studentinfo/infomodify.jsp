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
	function pwcheck() {
		var pw = document.getElementById("password");
		if (pw.value == "") {
			alert("비밀번호를 입력하세요.");
			pw.focus();
			return false;
		}
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
				<form class="form-inline" role="form">
					<h3 class="form-signin-heading">기본정보.</h3>
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td style="background-color: #A9A9A9">학번</td>
								<td>${ member.studentNumber}</td>
								<td style="background-color: #A9A9A9">성명</td>
								<td>${ member.name }</td>
							</tr>
							<tr>
								<td style="background-color: #A9A9A9">생년월일</td>
								<td>${ member.birthday }</td>
								<td style="background-color: #A9A9A9">학부(과), 전공</td>
								<td>${ member.major }</td>
							</tr>
							<tr>
								<td style="background-color: #A9A9A9">학년</td>
								<td>${ member.grade }</td>
								<td style="background-color: #A9A9A9">입학구분(입학년도)</td>
								<td>${ member.entrace_date}</td>
							</tr>
							<tr>
								<td style="background-color: #A9A9A9">학적상태</td>
								<td colspan="4">${ member.state }</td>
							</tr>
						</tbody>
					</table>
					<br />
					<h3 class="form-signin-heading">개인정보.</h3>
					
		
					

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