<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>복학신청</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<body>
<%@ include file="/common/header.jsp" %>
<div class="container">
	<div class="col-md-12 column">
		<div class="page-header">
			<h3>>복학신청</h3>
		</div>
		
	<form class="form-inline" role="form">
		<table class="table table-bordered" style="font: normal 15px/150% Arial,Helvetica, sans-serif;">
			<thead class="text-center">
				<tr>
					<td scope="row" bgcolor="#F4F4F4">신청학기</td>
					<td>${bokhak.bokhakgi }</td>
					<td scope="row" bgcolor="#F4F4F4">변동구분</td>
					<td>${bokhak.bokgubun } </td>
				</tr>
				<tr>
					<td scope="row" bgcolor="#F4F4F4">복학예상년도</td>
					<td>${bokhak.bokyear }</td>
					<td scope="row" bgcolor="#F4F4F4">복학예정학기</td>
					<td>${bokhak.bokyehakgi }</td>
				</tr>
			</thead>
			<tbody>
				<tr style="height: 100px;">
					<td scope="row" colspan="7">
						${bokhak.boksayu }
					</td>
				</tr>
			</tbody>
		</table>
		<button type="button" class="btn btn-primary" onclick="javascript:location.href='adminbokhakinfomodify.do?num=${bokhak.num }'";>수정</button>
	</form>
	</div>
</div>
</body>
</html>