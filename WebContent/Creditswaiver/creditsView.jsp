<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>학점포기신청</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<body>
<%@ include file="/common/header.jsp" %>
<div class="container">
	<div class="col-md-12 column">
		<h3>>학점포기신청</h3>
	</div>
	<form class="form-inline" role="form">
			<input type="hidden" id="hidden" value="">
			<div class="form-group" style="margin-right:15px;">
				<p><strong>학과  : </strong></p>
			</div>
			<div class="form-group" style="margin-right:30px;">
				<p class="text-info"><strong>${member.major}</strong></p>
			</div>
			<div class="form-group" style="margin-right:15px;">
				<p><strong>학번  : </strong></p>
			</div>
			<div class="form-group" style="margin-right:30px;">
				<p class="text-info"><strong>${member.studentNumber}</strong></p>
			</div>
			<div class="form-group" style="margin-right:15px;">
				<p><strong>학년  : </strong></p>
			</div>
			<div class="form-group" style="margin-right:30px;">
				<p class="text-info"><strong>${member.grade}</strong></p>
			</div>
			<div class="form-group" style="margin-right:15px;">
				<p><strong>성명  : </strong></p>
			</div>
			<div class="form-group" style="margin-right:30px;">
				<p class="text-info"><strong>${member.name}</strong></p>
			</div>
			<div class="form-group" style="margin-right:15px;">
				<p><strong>학적상태  : </strong></p>
			</div>
			<div class="form-group" style="margin-right:30px;">
				<p class="text-info"><strong>${member.state}</strong></p>
			</div>
			<div class="form-group" style="margin-right:15px;">
				<p><strong>신청가능학점  : </strong></p>
			</div>
			<div class="form-group" style="margin-right:30px;">
				<p class="text-info"><strong>19 학점</strong></p>
			</div>
	</form>
	<form class="form-inline" role="form">
		<table class="table table-bordered" style="font: normal 15px/150% Arial,Helvetica, sans-serif;">
			<input type="hidden" value="${hakgi.subjectnum }" name="subjectnum"/>
			<tr>
				<td scope="row" bgcolor="#F4F4F4">과목코드</td>
				<td>${hakgi.subjectnum }</td>
				<td scope="row" bgcolor="#F4F4F4">분반</td>
				<td>${hakgi.classis }</td>
				<td scope="row" bgcolor="#F4F4F4">과목명</td>
				<td>${hakgi.subjectname }</td>
			</tr>
			<tr>
				<td scope="row" bgcolor="#F4F4F4">이수구분</td>
				<td>${hakgi.course }</td>
				<td scope="row" bgcolor="#F4F4F4">학점</td>
				<td>${hakgi.credit }</td>
				<td scope="row" bgcolor="#F4F4F4">비고</td>
				<td>${hakgi.etc }</td>
			</tr>
		</table>
		<c:url var="deleteURL" value="creditswaiverdelete.do">
			<c:param name="subjectnum" value="${hakgi.subjectnum}" />
		</c:url>
		
		<button type="button" class="btn btn-primary" onclick="javascript:location.href='${deleteURL}'";>삭제</button>
	</form>
</div>
	<!-- /.container -->

	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
	<script src="//code.jquery.com/jquery.js"></script>
	<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
	<script src="dist/js/bootstrap.min.js"></script>

	<!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
	<!-- <script src="js/respond.js"></script> -->
</body>
</html>