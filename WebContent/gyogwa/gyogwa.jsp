<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


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
</head>
<body>
	<!-- header -->
	<%@ include file="/common/header.jsp"%>
	<!-- end of header -->

	<div class="container">
		<div class="page-header">
			<h3>>교과목조회</h3>
		</div>
		<table color="red" border="2">
			<tr>
				<td>
					<form class="form-inline" role="form">
						<div class="form-group" style="margin-right: 30px;">
							<p>
								<strong>&nbsp;&nbsp;&nbsp;&nbsp;조직</strong>
							</p>
						</div>
						<div class="form-group" style="margin-right: 30px;">
							<select class="form-control" name="year" style="width: 200px;">
								<option>대학(학부/서울)</option>
								<option>대학원(학부/서울)</option>
							</select>
						</div>

						<div class="form-group" style="margin-right: 15px;">
							<p>
								<strong>교육과정</strong>
							</p>
						</div>
						<div class="form-group" style="margin-right: 30px;">
							<select class="form-control" name="hakgi" style="width: 200px;">
								<option>학부 2013~2016 교육과정</option>
								<option>학부 2014~2017 교육과정</option>
							</select>
						</div>
						<br> <br>
						<div class="form-group" style="margin-right: 15px;">
							<p>
								<strong>이수학년</strong>
							</p>
						</div>
						<div class="form-group" style="margin-right: 30px;">
							<select class="form-control" name="hakgi" style="width: 200px;">
								<option>전체 학년</option>
								<option>2학년</option>
								<option>3학년</option>
								<option>4학년</option>
							</select>
						</div>

						<div class="form-group" style="margin-right: 15px;">
							<p>
								<strong>이수학기</strong>
							</p>
						</div>
						<div class="form-group" style="margin-right: 30px;">
							<select class="form-control" name="hakgi" style="width: 200px;">
								<option>전학기</option>
								<option>1학기</option>
								<option>2학기</option>
							</select>
						</div>
						<br> <br>

						<div class="form-group" style="margin-right: 30px;">
							<p>
								<strong>&nbsp;&nbsp;과목명</strong>
							</p>
						</div>
						<div class="form-group" style="margin-right: 55px;">
							<select class="form-control" name="hakgi" style="width: 200px;">
									
								<option>미적분학</option>
								<option>JAVA</option>
								<option>생체리듬</option>
							</select>
						</div>
				</td>
			</tr>
		</table>
		<br> <br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>학수번호</th>
					<th>과목명</th>
					<th>이수구분</th>
					<th>교수명</th>
					<th>학점</th>
					<th>성적등급</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>학수번호</td>
					<td>미적분학1</td>
					<td>기초필수</td>
					<td>고광렬이</td>
					<td>4.0</td>
					<td>A+</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>


