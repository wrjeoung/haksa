<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
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


	<br>
	<br>
	<form action=insertTuitionPro.do " method="post"
		enctype="multipart/form-data" onSubmit="" name="test">
		<table border="1" width="400" cellspacing="0" cellpadding="0"
			align="center">

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">년도</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="year" size="20"></td>
			</tr>

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">학기</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="semester" size="20"></td> 
			</tr>

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">등록(입학금)</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="tition_admission" size="20"></td>
			</tr>

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">등록(수업료)</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="tition_lesson" size="20"></td>
			</tr>

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">등록(기성회비)</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="tition_dues" size="20"></td>
			</tr>

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">감면(입학금)</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="reduction_admission" size="20"></td>
			</tr>

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">감면(수업료)</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="reduction_lesson" size="20"></td>
			</tr>

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">감면(기성회비)</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="reduction_dues" size="20"></td>
			</tr>
			
				<tr align="center">
				<td width="100" bgcolor="#BDBDBD">납입(입학금)</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="pay_admission" size="20"></td>
			</tr>

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">납입(수업료)</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="pay_lesson" size="20"></td>
			</tr>

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">납입(기성회비)</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="pay_dues" size="20"></td>
			</tr>

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">등록금합계</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="tuition_tot" size="20"></td>
			</tr>

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">등록여부</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="tuition_yn" size="20"></td>
			</tr>
 
			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">등록일자</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="tuition_il" size="20"></td>
			</tr>

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">로그인ID명</td>
				<td width="100" align="left">&nbsp;<input type="text"
					value="${member.studentNumber}" name="stnumber" />
				</td>
			</tr>
		</table>
		<div align="center"> 
<input type="submit" value="신청">
		</div>
	</form>