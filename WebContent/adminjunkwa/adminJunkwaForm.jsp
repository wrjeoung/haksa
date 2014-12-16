<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>전과신청관리</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<script type="text/javascript">
	function chk_up(){
		chk.action = "adminjunkwaUpdateCom.do";
		chk.submit();
	}
	function chk_up2(){
		chk.action = "adminjunkwaUpdateCan.do";
		chk.submit();
	}
	function chk_del(){
		chk.action = "adminjunkwaDelete.do";
		chk.submit();
	}
</script>
<body>
<%@ include file="/common/header.jsp" %>
<div class="container">
	<div class="page-header">
		<div class="page-header">
			<h3>>전과신청관리</h3>
		</div>
<p></p>
<p class="text-success"><strong>[전과신청관리]</strong></p>
<form name="chk">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th class="text-center">년도</th>
			<th class="text-center">학기</th>
			<th class="text-center">신청학부(과)</th>
			<th class="text-center">신청일</th>
			<th class="text-center">처리구분</th>
			<th class="text-center">처리일</th>
			<th class="text-center">비고</th>
			<th class="text-center">신청자명</th>
			<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${list }">
			<c:url var="viewURL" value="adminjunkwaView.do">
				<c:param name="num" value="${vo.num }"/>
			</c:url>
			<tr>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.junkwayear }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.junkwahakgi }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.junkwahakkwa }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";><fmt:formatDate value="${vo.junkwa_reg_date }" pattern="yyyy-MM-dd HH:mm" />
				</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.junkwachuri }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.junkwachuday }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.junkwabygo }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.name }</td>
				<td><input type="checkbox" name="rnum" value="${vo.num}" ></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div align="center">
		<button type="button" class="btn btn-default" onclick="chk_up()">신청완료</button>
		<button type="button" class="btn btn-default" onclick="chk_up2()">신청</button>
		<button type="button" class="btn btn-default" onclick="chk_del()">삭제</button>
	</div>
</form>
</div>
</body>
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
    <script src="dist/js/bootstrap.min.js"></script>
</html>