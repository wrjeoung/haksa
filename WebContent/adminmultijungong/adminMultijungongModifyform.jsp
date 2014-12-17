<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
Date nowDate=new Date();		
//└현재날짜와 시간을 얻어온다.
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
//└날짜형식을 yyyy년MM월dd일 형식으로 사용하기 위해서 simpledateformat 객체 생성
SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy년MM월dd일");
String formatDate=dateFormat.format(nowDate);
//└현재의 날짜와 시간에 yyyy년MM월dd일 형식을 format()메소드를 사용해서 적용
String formatDate2=dateFormat2.format(nowDate);
//out.println(formatDate);
//out.println(formatDate2);
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>전공신청</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<script type="text/javascript">
	function chk_del() {
		chk.action="multijungongDelete.do";
		chk.submit();
	}
</script>
<body>
<%@ include file="/common/header.jsp" %>
<div class="container">
	<div class="page-header">
		<h3>>전공신청</h3>
	</div>

<p></p>
<p class="text-success"><strong>[전공신청]</strong></p>

</div>

<form action="adminmultijungonginfoPro.do" method="post" enctype="multipart/form-data" onSubmit="" name="">
	<input type="hidden" name="num" value="${multijungong.num }"/>
	<table border="1" width="1100" cellspacing="0" cellpadding="0" align="center">
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">변동구분</td>
			<td width="520" align="left" colspan="4">
			&nbsp;<select name="multigubun"><option value="전공신청">전공신청</option></select>
			&nbsp;<select name="multigubun2"><option value="다중전공">다중전공</option>
			<option value="복수전공">복수전공</option>
			<option value="연계전공">연계전공</option></select></td>
		</tr>
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">신청학년</td>
			<td width="520" align="left" colspan="4">
				&nbsp;<input type="text" name="multiyear1" value="<%=formatDate %>">년도
				&nbsp;<select name="multiyear2"><option value="1학년">1학년</option>
				<option value="2학년">2학년</option>
				<option value="3학년">3학년</option>
				<option value="4학년">4학년</option></select>
				&nbsp;<select name="multiyear3"><option value="1학기">1학기</option>
				<option value="2학기">2학기</option></select>
			</td>
		</tr>
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">지원전공</td>
			<td width="520" align="left">
				&nbsp;<select name="multijungong">
				<option value="영어학과">영어학과</option>
				<option value="일어일본학과">일어일본학과</option>
				<option value="중어중국학과">중어중국학과</option>
				<option value="사회복지학과">사회복지학과</option>
				<option value="사회과학부">사회과학부</option>
				<option value="신문방송학과">신문방송학과</option>
				<option value="경영학부">경영학부</option>
				<option value="디지털컨텐츠학과">디지털컨텐츠학과</option>
				<option value="컴퓨터공학과">컴퓨터공학과</option>
				<option value="소프트웨어공학과">소프트웨어공학과</option>
				<option value="정보통신공학과">정보통신공학과</option>
				<option value="교양">교양</option></select>
			</td>
			<td width="280" bgcolor="#BDBDBD">결재결과</td>
			<td width="520" align="left">&nbsp;<input type="text" name="multigyul" size="20" value="${multijungong.multigyul }"></td>
		</tr>
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">변동사유</td>
			<td width="520" align="left">&nbsp;<input type="text" name="multisayu" size="40" value="${multijungong.multisayu }"></td>
			<td width="280" bgcolor="#BDBDBD">신청일자</td>
			<td width="520" align="left">
			&nbsp;<input type="text" name="multiday" value="<%=formatDate2 %>">
			</td>
		</tr>
	</table>
	<div align="center">
	<input type="hidden"  value="${member.studentNumber }" name="name">
	<input type="submit" class="btn btn-default" value="신청">
	</div>
</form>
</body>
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
    <script src="dist/js/bootstrap.min.js"></script>
</html>