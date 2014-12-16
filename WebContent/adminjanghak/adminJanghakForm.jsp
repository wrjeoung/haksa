<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript">
	function chk_up(){
		chk.action = "adminjanghakUpdateCom.do";
		chk.submit();
	}
	function chk_up2(){
		chk.action = "adminjanghakUpdateCan.do";
		chk.submit();
	}
	function chk_del(){
		chk.action = "adminjanghakDelete.do";
		chk.submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>장학금신청관리</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<body>
<%@ include file="/common/header.jsp" %>
<div class="container">
	<div class="page-header">
		<h3>>장학금신청관리</h3>
	</div>
<p></p>
<p class="text-success"><strong>[장학금신청관리]</strong></p>
<form name="chk">
	<table class="table table-bordered">
		<thead>
			<th>은행</th>
			<th>계좌번호</th>
			<th>예금주</th>
			<th>장학구분</th>
			<th>신청일자</th>
			<th>처리구분</th>
			<th>신청자명</th>
			<th></th>
		</thead>
		<tbody>
		<c:forEach var="list" items="${list }">
			<c:url var="viewURL" value="adminjanghakView.do">
				<c:param name="num" value="${list.num }"/>
			</c:url>
			<tr>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.janghakbank }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.janghakbanknum }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.janghakname }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.janghakmenu }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";><fmt:formatDate value="${list.janghak_reg_date }" pattern="yyyy-MM-dd HH:mm"/></td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.janghakchuri }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.name }</td>
				<td><input type="checkbox" name="rnum" value="${list.num }"></td>
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