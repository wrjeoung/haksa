<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>자퇴신청관리</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<script type="text/javascript">
	/* function chk_up(){
		chk.action = "adminleaveUpdateCom.do";
		chk.submit();
	}
	function chk_up2(){
		chk.action = "adminleaveUpdateCan.do";
		chk.submit();
	}
	function chk_del(){
		chk.action = "adminleaveDelete.do";
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
				chk.action = "adminleaveDelete.do";
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
				chk.action = "adminleaveUpdateCom.do";
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
				chk.action = "adminleaveUpdateCan.do";
				chk.submit();
			}
		}
	
</script>
<body>
<%@ include file="/common/header.jsp" %>
<div class="container">
	<div class="page-header">
		<h3>>자퇴신청관리</h3>
	</div>
	<p></p>
<p class="text-success"><strong>[자퇴신청 List]</strong></p>
<form name="chk">
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
			<th>신청자명</th>
			<th></th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${list }">
			<c:url var="viewURL" value="adminleaveView.do">
				<c:param name="num" value="${list.num }"/>
			</c:url>
			<tr>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.leavegubun }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.leavehak }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.leavehak2 }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.leavehak3 }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.leavegyul }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.leavesayu } / ${list.leavesayu2 }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.leaveday }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.leavechuri }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.name }</td>
				<td><input type="checkbox" name="rnum" value="${list.num }"></td>
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