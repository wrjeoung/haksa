<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>복학신청</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<script type="text/javascript">
	function chk_del(){
		chk.action="bokhakDelete.do";
		chk.submit();
	}
</script>
<body>
<%@ include file="/common/header.jsp"%>
<div class="container">
	<div class="page-header">
		<h3>>복학신청</h3>
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
<p></p>
<p class="text-success"><strong>[복학신청 List]</strong></p>

</div>
<form action="bokhakinfoPro.do" method="post" enctype="multipart/form-data" onsubmit="" name="test">
	<input type="hidden" name="num" value="${bokhak.num }"/>
	<table border="1" width="1100" cellspacing="0" cellpadding="0" align="center">
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">신청학기</td>
			<td width="520" align="left">
			&nbsp;<select name="bokhakgi"><option>1학기</option><option>2학기</option></select>
			</td>
			<td width="280" bgcolor="#BDBDBD">변동구분</td>
			<td width="520" align="left">
			&nbsp;<select name="bokgubun"><option>조기복학</option><option>복학</option></select>
			</td>
		</tr>
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">복학<br/>예정년도</td>
			<td width="520" align="left">&nbsp;<input type="text" name="bokyear" size="20" value="${bokhak.bokyear }"></td>
			<td width="280" bgcolor="#BDBDBD">복학<br/>예정학기</td>
			<td width="520" align="left">&nbsp;<select name="bokyehakgi"><option>1학기</option><option>2학기</option></select>
			</td>
		</tr>
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">반려사유</td>
			<td width="520" align="left" colspan="4">&nbsp;<input type="text" name="boksayu" size="115" value="${bokhak.boksayu }"></td>
		</tr>
	</table>
	<div align="center">
	<input type="hidden" name="name" value="${member.studentNumber }">
	<input type="submit" class="btn btn-default" value="신청">
	<!-- <button type="button" class="btn btn-default" onclick="chk_del()">삭제</button> -->
	</div>
</form>
</body>
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
<script src="//code.jquery.com/jquery.js"></script>
<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
<script src="dist/js/bootstrap.min.js"></script>
</html>