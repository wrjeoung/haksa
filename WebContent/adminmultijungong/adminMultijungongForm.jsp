<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	/* function chk_up(){
		chk.action = "adminmultijungongUpdateCom.do";
		chk.submit();
	}
	function chk_up2(){
		chk.action = "adminmultijungongUpdateCan.do";
		chk.submit();
	}
	function chk_del(){
		chk.action = "adminmultijungongDelete.do";
		chk.submit();
	} */
	
	function chk_del(){
		var count=0;
		var rnum=document.getElementsByName('rnum');
		for(i=0;i<rnum.length;i++){
			if(rnum[i].checked) { count += 1; }
		}
		if(count==0){alert("체크된 항목이 없습니다.");
		}else{
			chk.action = "adminmultijungongDelete.do";
			chk.submit();
		}
	}
	function chk_up(){
		var count=0;
		var rnum=document.getElementsByName('rnum');
		for(i=0;i<rnum.length;i++){
			if(rnum[i].checked) { count += 1; }
		}
		if(count==0){ alert("체크된 항목이 없습니다.");
		}else{
			chk.action = "adminmultijungongUpdateCom.do";
			chk.submit();
		}
	}
	function chk_up2(){
		var count=0;
		var rnum=document.getElementsByName('rnum');
		for(i=0;i<rnum.length;i++){
			if(rnum[i].checked) { count += 1; }
		}
		if(count==0){ alert("체크된 항목이 없습니다."); 
		}else{
			chk.action = "adminmultijungongUpdateCan.do";
			chk.submit();
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>전공신청관리</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<body>
<%@ include file="/common/header.jsp" %>
<div class="container">
	<div class="page-header">
		<h3>>전공신청관리</h3>
	</div>
<p></p>
<p class="text-success"><strong>[전공신청관리]</strong></p>
<form name="chk">
<table class="table table-bordered">
	<thead>
	<tr>
			<th>변동구분</th>
			<th>신청학년</th>
			<th>지원전공</th>
			<th>신청일자</th>
			<th>처리<br/>구분</th>
			<th>결재결과</th>
			<th>변동사유</th>
			<th>신청자명</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${list }">
			<c:url var="viewURL" value="adminmultijungongView.do">
				<c:param name="num" value="${vo.num }"/>
			</c:url>
			<tr>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.multigubun } / ${vo.multigubun2 }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.multiyear1 } / ${vo.multiyear2 } / ${vo.multiyear3 }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.multijungong }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.multiday }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.multichuri }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.multigyul }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.multisayu }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.name }</td>
				<td><input type="checkbox" name="rnum" value="${vo.num }"></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
	<div align="center">
		<button type="button" class="btn btn-default" onclick="chk_up()">신청완료</button>
		<button type="button" class="btn btn-default" onclick="chk_up2()">되돌리기</button>
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