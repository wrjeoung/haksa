<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
Date nowDate=new Date();		
//└현재날짜와 시간을 얻어온다.
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년MM월dd일");
//└날짜형식을 yyyy년MM월dd일 형식으로 사용하기 위해서 simpledateformat 객체 생성
SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy");
String formatDate=dateFormat.format(nowDate);
//└현재의 날짜와 시간에 yyyy년MM월dd일 형식을 format()메소드를 사용해서 적용
String formatDate2=dateFormat2.format(nowDate);
//out.println(formatDate);
//out.println(formatDate2);
%>
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
<%@ include file="/common/header.jsp"%>
<div class="container">
	<div class="page-header">
		<h3>>자퇴신청</h3>
	</div>

<p></p>
<p class="text-success"><strong>[자퇴신청 List]</strong></p>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>변동구분</th>
			<th>신청년도</th>
			<th>학년</th>
			<th>학기</th>
			<th>결재결과</th>
			<th>제적사유</th>
			<th>신청일자</th>
			<th>처리구분</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.leavegubun }</td>
				<td>${list.leavehak }</td>
				<td>${list.leavehak2 }</td>
				<td>${list.leavehak3 }</td>
				<td>${list.leavegyul }</td>
				<td>${list.leavesayu } / ${list.leavesayu2 }</td>
				<td>${list.leaveday }</td>
				<td>${list.leavechuri }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<form action="insertLeavePro.do" method="post" enctype="multipart/form-data" onSubmit="" name="">
	<table border="1" width="1100" cellspacing="0" cellpadding="0" align="center">
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">변동구분</td><td width="520" align="left" colspan="4">
			&nbsp;<select name="leavegubun"><option value="자퇴제적">자퇴제적</option></select></td>
		</tr>
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">신청학년</td>
			<td width="520" align="left">&nbsp;<input type="text" name="leavehak" value="<%=formatDate2%>">년도
			&nbsp;<select name="leavehak2"><option value="1학년">1학년</option><option value="2학년">2학년</option><option value="3학년">3학년</option><option value="4학년">4학년</option></select>
			&nbsp;<select name="leavehak3"><option value="1학기">1학기</option><option value="2학기">2학기</option></select></td>
			<td width="280" bgcolor="#BDBDBD">결재결과</td>
			<td width="520" align="left">
			&nbsp;<input type="text" name="leavegyul" size="20">
			</td>
		</tr>
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">제적사유</td>
			<td width="520" align="left">&nbsp;<select name="leavesayu"><option>선택</option></select>
			&nbsp;<input type="text" name="leavesayu2" size="40"></td>
			<td width="280" bgcolor="#BDBDBD">신청일자</td>
			<td width="520" align="left">&nbsp;<input type="text" name="leaveday" value="<%=formatDate %>" size="20"></td>
		</tr>
	</table>
	<input type="text" value="${member.studentNumber }" name="name"/>
	<input style="margin-left: 700px" type="submit" value="신청">
</form>
<!-- /.container -->

	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
	<script src="//code.jquery.com/jquery.js"></script>
	<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
	<script src="dist/js/bootstrap.min.js"></script>

	<!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
	<!-- <script src="js/respond.js"></script> -->
</body>
</html>