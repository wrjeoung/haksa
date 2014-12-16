<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>휴학신청</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<body>
<%@ include file="/common/header.jsp" %>
<div class="container">
	<div class="col-md-12 column">
		<div class="page-header">
			<h3>>휴학신청</h3>
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
					<thead class="text-center">
						<tr>
							<td scope="row" bgcolor="#F4F4F4">휴학구분</td>
							<td>${huhak.hugubun }</td>
							<td scope="row" bgcolor="#F4F4F4">휴학세부구분</td>
							<td>${huhak.husegubun }</td>
							<td scope="row" bgcolor="#F4F4F4">성적인정여부</td>
							<td>${huhak.hugrade }</td>
						</tr>
						<tr>	
							<td scope="row" bgcolor="#F4F4F4">복학예상년도</td>
							<td>${huhak.hubokyear }</td>
							<td scope="row" bgcolor="#F4F4F4">복학예상학기</td>
							<td>${huhak.hubokhak }</td>
							<td scope="row" bgcolor="#F4F4F4">비상연락처</td>
							<td>${huhak.hunumber }</td>
						</tr>
					</thead>
					<tbody>
						<tr style="height: 100px;">
							<td scope="row" colspan="7">
								${huhak.husayu }
							</td>
						</tr>
					</tbody>
				</table>
				<button type="button" class="btn btn-primary" onclick="javascript:location.href='huhakinfomodify.do?num=${huhak.num }'";>수정</button>
				
			</form>
	</div>
</div>
</body>
</html>