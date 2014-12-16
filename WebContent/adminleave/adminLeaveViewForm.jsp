<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>자퇴신청</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<body>
<%@ include file="/common/header.jsp" %>
<div class="col-md-12 column">
	<div class="page-header">
		<h3>>자퇴신청</h3>
	</div>
	
	<form class="form-inline" role="form">
		<table class="table table-bordered" style="font: normal 15px/150% Arial,Helvetica, sans-serif;">
			<thead class="text-center">
				<tr>
					<td scope="row" bgcolor="#F4F4F4">변동구분</td>
					<td>${leave.leavegubun }</td>
					<td scope="row" bgcolor="#F4F4F4">신청학년</td>
					<td>${leave.leavehak } / ${leave.leavehak2 } / ${leave.leavehak3 }</td>
				</tr>
				<tr>
					<td scope="row" bgcolor="#F4F4F4">신청일자</td>
					<td>${leave.leaveday }</td>
					<td scope="row" bgcolor="#F4F4F4">결재결과</td>
					<td>${leave.leavegyul }</td>
				</tr>
			</thead>
			<tbody>
				<tr style="height: 100px;">
					<td scope="row" colspan="7">
						${leave.leavesayu2 }
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>

</body>
</html>