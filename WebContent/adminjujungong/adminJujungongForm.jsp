<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>주전공신청관리</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<script type="text/javascript">
	function chk_up(){
		chk.action = "adminjujungongUpdateCom.do";
		chk.submit();
	}
	function chk_up2(){
		chk.action = "adminjujungongUpdateCan.do";
		chk.submit();
	}
	function chk_del(){
		chk.action = "adminjujungongDelete.do";
		chk.submit();
	}
</script>
<body>
<%@ include file="/common/header.jsp" %>
<div class="container">
	<div clas="page-header">
		<h3>>주전공신청관리</h3>
	</div>
<p></p>
<p class="text-success"><strong>[주전공신청관리]</strong></p>
<form name="chk">
<table class="table table-bordered">
	<thead>
		<tr>
			<th>변동구분</th>
			<th>신청학년</th>
			<th>신청일자</th>
			<th>1지망</th>
			<th>2지망</th>
			<th>3지망</th>
			<th>4지망</th>
			<th>처리<br/>구분</th>
			<th>결재결과</th>
			<th>신청자명</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${list2 }">
			<tr>
				<td>${vo.jujungonggubun }</td>
				<td>${vo.jujungongyear1 } / ${vo.jujungongyear2 }</td>
				<td>${vo.jujungongday }</td>
				<td>${vo.jujungong1 }</td>
				<td>${vo.jujungong2 }</td>
				<td>${vo.jujungong3 }</td>
				<td>${vo.jujungong4 }</td>
				<td>${vo.jujungongchuri }</td>
				<td>${vo.jujungonggyul }</td>
				<td>${vo.name }</td>
				<td><input type="checkbox" name="rnum" value="${vo.num }"></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<div align="center">
		<button type="button" onclick="chk_up()">신청완료</button>
		<button type="button" onclick="chk_up2()">신청</button>
		<button type="button" onclick="chk_del()">삭제</button>
	</div>
</form>
</div>
</body>
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
    <script src="dist/js/bootstrap.min.js"></script>
</html>