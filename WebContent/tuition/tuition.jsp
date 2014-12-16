<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

<style>
.page-table {
  padding-bottom: 9px;
  margin: 40px 0 20px;
  border-bottom: 1px solid #eeeeee;
}
</style>


	<div class="container">
		<div class="page-header">
		  <h3>>등록금내역조회</h3>
	</div>


<form action="insertHuhakPro.do" method="post" enctype="multipart/form-data" onSubmit="" name="test">
<div class="page-table">
	<table border="1" align="center">
		<tr align="center" colspan="2">
			<td width="70" bgcolor="#BDBDBD" rowspan="2">년도</td> 
			<td width="100" bgcolor="#BDBDBD" rowspan="2">학기</td>
			<td width="180" bgcolor="#BDBDBD" colspan="3">등록금</td>
			<td width="180" bgcolor="#BDBDBD" colspan="3">감면금액</td>
			<td width="180" bgcolor="#BDBDBD" colspan="3">납입금액</td>
			<td width="120" bgcolor="#BDBDBD" rowspan="2">등록금합계</td>
			<td width="80" bgcolor="#BDBDBD" rowspan="2">등록여부</td>
			<td width="350" bgcolor="#BDBDBD" rowspan="2">등록일자</td>
			<tr align ="center">
			<td width="160" bgcolor="#BDBDBD">입학금</td>
			<td width="100" bgcolor="#BDBDBD">수업료</td>
			<td width="180" bgcolor="#BDBDBD">기성회비</td>
			<td width="180" bgcolor="#BDBDBD">입학금</td>
			<td width="150" bgcolor="#BDBDBD">수업료</td> 
			<td width="180" bgcolor="#BDBDBD">기성회비</td>
			<td width="180" bgcolor="#BDBDBD">입학금</td>
			<td width="100" bgcolor="#BDBDBD">수업료</td>
			<td width="180" bgcolor="#BDBDBD">기성회비</td>
			</tr>
		<th>
  <tr align="center">
			<c:forEach var="list" items="${list}"> 
		            <td>${list.year}</td>
		        	<td>${list.semester}</td>
		        	<td>${list.tition_admission}</td>
		        	<td>${list.tition_lesson}</td>
		        	<td>${list.tition_dues}</td>
		        	<td>${list.reduction_admission}</td>
		        	<td>${list.reduction_lesson}</td>
		        	<td>${list.reduction_dues}</td>
		        	<td>${list.pay_admission}</td>
		        	<td>${list.pay_lesson}</td>
		        	<td>${list.pay_dues}</td>
		        	<td>${list.tuition_tot}</td>
		        	<td>${list.tuition_yn}</td>
		        	<td>${list.tuition_il}</td>
		          </tr>
		        </c:forEach>
		
		</th>

	</table>
		
		</div>
		</form>
		
		</div>
		</body>
		</html>


		