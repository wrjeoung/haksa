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
</head>
<body>
	<!-- header -->
	<%@ include file="/common/header.jsp"%>
	<!-- end of header -->



	<div class="container">
		<div class="page-header">
			<h3>>필수과목이수조회</h3>
		</div>
		<p></p>

		<p class="text-success">
			<strong>>필수과목이수조회</strong>
		</p>
		<p></p>
		<p class="text-success">
			<strong>!</strong> <font color="red">당 조회는 학생들의 수강신청에 도움을 주고자
				당해학기에 개설되는 강좌로 작성성되었으므로 수강신청 정정기간이 종료되기전 개설강좌에 변동이 있을경우 바뀔 수 있습니다.</font>
		<p></p>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>전공구분</th>
					<th>주전공명</th>
					<th>학년-학기</th>
					<th>과목명(학수번호)</th>
					<th>이수구분</th>
					<th>택필구분</th>
					<th>전체이수구분</th>
				</tr>
			</thead>
			<tbody>
				<tr style="margin-top: 150px">
					<td rowspan="4">전공구분</td>
					<td rowspan="4">주전공명</td>
					<td rowspan="2">2학년 1학기</td>
					<td>공업수학1</td>
					<td>이수</td>
					<td> </td>
					<td>01</td>
				</tr>

				<tr>
					<td>전문학술영어</td>
					<td>이수</td>
					<td> </td>
					<td>01</td>
				</tr>
				
				<tr>
					<td rowspan="2">2학년 2학기</td>
					<td>공업수학2</td>
					<td>이수</td>
					<td> </td>
					<td>01</td>
				</tr>
				
				<tr>
					<td>글로벌리더쉽(HELP2)</td>
					<td>이수</td>
					<td> </td>
					<td>01</td>
				</tr>
			</tbody>
		</table>