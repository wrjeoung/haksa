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
	function setSplitNumber() {
		var cellphone='${member.cellphone}'.split('-');
		var tel='${member.tel}'.split('-');
		document.getElementById("hp1").value=cellphone[0];
		document.getElementById("hp2").value=cellphone[1];
		document.getElementById("hp3").value=cellphone[2];
		
		document.getElementById("tel1").value=tel[0];
		document.getElementById("tel2").value=tel[1];
		document.getElementById("tel3").value=tel[2];
	}
</script>
</head>
<body onload="setSplitNumber()">
	<!-- header -->
	<%@ include file="/common/header.jsp"%>
	<!-- end of header -->
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form class="form-inline" role="form" action="infomodifyPro.do">
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
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td style="background-color: #A9A9A9; width: 200px">전화번호</td>
								<td>
									<div class="form-group">
										<input type="text" class="form-control" id="tel1" name="tel1" maxlength="4">
									</div>-
									<div class="form-group">
										<input type="text" class="form-control"	id="tel2" name="tel2" maxlength="4">
									</div>-
									<div class="form-group">
										<input type="text" class="form-control"	id="tel3" name="tel3" maxlength="4">
									</div>
								</td>
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
							<tr>
								<td style="background-color: #A9A9A9">이메일</td>
								<td><input type="text" class="form-control" id="email" name="email" value="${member.email }"></td>
							</tr>
							<tr>
								<td style="background-color: #A9A9A9">주소</td>
								<td><input type="text" class="form-control"	id="address" name="address" value="${member.address }"></td>
							</tr>
						</tbody>
					</table>
					<button type="submit" class="btn btn-primary">수정완료</button>
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