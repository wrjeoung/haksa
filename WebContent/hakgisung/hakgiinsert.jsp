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
	<form action=insertHakgiPro.do " method="post"
		enctype="multipart/form-data" onSubmit="" name="test">
		<table border="1" width="400" cellspacing="0" cellpadding="0"
			align="center">

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">과목코드</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="subjectnum" size="20"></td>
			</tr>

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">분반</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="classis" size="20"></td> 
			</tr>

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">교과목명</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="subjectname" size="20"></td>
			</tr>

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">이수구분</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="course" size="20"></td>
			</tr>

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">학점</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="credit" size="20"></td>
			</tr>

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">비고</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="etc" size="20"></td>
			</tr>

			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">학번</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="stnumber" /> 
				</td>
			</tr>
  
 			<tr align="center">
				<td width="100" bgcolor="#BDBDBD">백분율</td>
				<td width="100" align="left">&nbsp;<input type="text"
					name="percentage" size="20"></td>
			</tr>
 
		</table>
		<div align="center"> 
<input type="submit" value="신청">
		</div>
	</form>