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
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${list }">
			<tr>
			<td><fmt:formatDate value="${vo.bokhak_reg_date }" pattern="yyyy"/>
							</td>
							<td>${vo.bokhakgi }</td>
							<td>${vo.bokgubun }</td>
							<td><fmt:formatDate value="${vo.bokhak_reg_date }" pattern="yyyy-MM-dd HH:mm"/>
							</td>
							<td>${vo.bokyear }</td>
							<td>${vo.bokyehakgi }</td>
							<td>${vo.bokchuri }</td>
							<td>${vo.boksayu }</td>
							<td><input type="checkbox" name="rnum" value="${vo.num }">?=${vo.num }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</form>
</div>
<form action="insertBokhakPro.do" method="post" enctype="multipart/form-data" onsubmit="" name="test">
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
			<td width="520" align="left">&nbsp;<input type="text" name="bokyear" size="20"></td>
			<td width="280" bgcolor="#BDBDBD">복학<br/>예정학기</td>
			<td width="520" align="left">&nbsp;<select name="bokyehakgi"><option>1학기</option><option>2학기</option></select>
			</td>
		</tr>
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">반려사유</td>
			<td width="520" align="left" colspan="4">&nbsp;<input type="text" name="boksayu" size="115"></td>
		</tr>
	</table>
	<div align="center">
	<button type="button" onclick="chk_del()">삭제</button>
	<input type="hidden" name="name" value="${member.studentNumber }">
	<input type="submit" value="신청">
	</div>
</form>
</body>
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
<script src="//code.jquery.com/jquery.js"></script>
<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
<script src="dist/js/bootstrap.min.js"></script>
</html>