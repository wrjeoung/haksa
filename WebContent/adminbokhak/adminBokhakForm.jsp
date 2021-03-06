<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>복학신청관리</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<script type="text/javascript">
	/* function chk_up(){
		chk.action = "adminbokhakUpdateCom.do";
		chk.submit();
	}
	function chk_up2(){
		chk.action = "adminbokhakUpdateCan.do";
		chk.submit();
	}
	function chk_del(){
		chk.action = "adminbokhakDelete.do";
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
			chk.action = "adminbokhakDelete.do";
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
			chk.action = "adminbokhakUpdateCom.do";
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
			chk.action = "adminbokhakUpdateCan.do";
			chk.submit();
		}
	}
</script>
<body>
<%@ include file="/common/header.jsp" %>
<div class="container">
	<div class="page-header">
		<h3>>복학신청관리</h3>
	</div>
<p></p>
<p class="text-success"><strong>[복학신청 List]</strong></p>
<form name="chk">
	<table class="table table-bordered">
		<thead>
			<tr>
			<th class="text-center">신청년도</th>
			<th class="text-center">신청학기</th>
			<th class="text-center">변동구분</th>
			<th class="text-center">신청일자</th>
			<th class="text-center">복학<br/>예정년도</th>
			<th class="text-center">복학<br/>예정학기</th>
			<th class="text-center">처리<br/>구분</th>
			<th class="text-center">반려사유</th>
			<th class="text-center">신청자명</th>
			<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${list }">
			<c:url var="viewURL" value="adminbokhakView.do">
				<c:param name="num" value="${vo.num }"/>
			</c:url>
				<tr>
					<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";><fmt:formatDate value="${vo.bokhak_reg_date }" pattern="yyyy"/>
							</td>
							<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.bokhakgi }</td>
							<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.bokgubun }</td>
							<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";><fmt:formatDate value="${vo.bokhak_reg_date }" pattern="yyyy-MM-dd HH:mm"/>
							</td>
							<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.bokyear }</td>
							<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.bokyehakgi }</td>
							<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.bokchuri }</td>
							<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.boksayu }</td>
							<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.name }</td>
							<td><input type="checkbox" name="rnum" value="${vo.num }">
							<input type="hidden" name="name" value="${vo.name }"></td>
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