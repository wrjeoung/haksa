<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>휴학신청</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<script type="text/javascript">
	function hugr_check(){
		if(document.test.hugr.checked==true){
			document.test.hugrade.value="성적인정";
		}else{
			document.test.hugrade.value="성적불인정";
		}
	}

</script>
<body>
<%@ include file="/common/header.jsp"%>
<div class="container">
	<div class="page-header">
		<h3>>휴학신청</h3>
	</div>

<p></p>
<p class="text-success"><strong>[휴학신청 List]</strong></p>
<table class="table table-bordered">
	<thead>
		<tr>
			<th class="text-center">신청년도</th>
			<th class="text-center">신청학기</th>
			<th class="text-center">휴학구분</th>
			<th class="text-center">신청일자</th>
			<th class="text-center">복학<br/>예정년도</th>
			<th class="text-center">복학<br/>예정학기</th>
			<th class="text-center">처리<br/>구분</th>
			<th class="text-center">세부사정</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td><fmt:formatDate value="${vo.huhak_reg_date }" pattern="yyyy"/>
								</td>
								<td>${vo.hubokhak }</td>
								<td>${vo.hugubun }</td>
								<td>
								<fmt:formatDate value="${vo.huhak_reg_date }" pattern="yyyy-MM-dd HH:mm"/>
								</td>
								<td>${vo.hubokyear }</td>
								<td>${vo.hubokhak }</td>
								<td>${vo.huchuri }</td>
								<td>${vo.husegubun }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
<!-- 신청하기 -->
<form action="insertHuhakPro.do" method="post" enctype="multipart/form-data" onSubmit="" name="test">
	<table border="1" width="1100" cellspacing="0" cellpadding="0" align="center">
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">휴학구분</td><td width="520" align="left">&nbsp;<select name="hugubun"><option value="일반휴학">일반휴학</option></select></td>
			<td width="280" bgcolor="#BDBDBD">휴학<br/>세부구분</td><td width="520" align="left">&nbsp;<select name="husegubun"><option value="개인사정">개인사정</option></select></td>
		</tr>
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">복학<br/>예상년도</td><td width="520" align="left">&nbsp;<input type="text" name="hubokyear" size="20"></td>
			<td width="280" bgcolor="#BDBDBD">복학<br/>예상학기</td>
			<td width="320" align="left">
				&nbsp;<select name="hubokhak"><option value="1학기">1학기</option><option value="2학기">2학기</option></select>
			</td>
		</tr>
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">성적<br/>인정여부</td><td width="520" align="left">&nbsp;<input type="checkbox" name="hugr" onclick="hugr_check();"></td>
			<td width="280" bgcolor="#BDBDBD">비상연락처</td><td width="520" align="left">&nbsp;<input type="text" name="hunumber" size="20"></td>
		</tr>
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">사유</td>
			<td width="520" align="left" colspan="4">&nbsp;<input type="text" name="husayu" size="115"></td>
		</tr>
	</table>
	<input style="margin-left: 700px" type="submit" value="신청">
	<input type="text" value="성적불인정" name="hugrade">
</form>
</body>
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
    <script src="dist/js/bootstrap.min.js"></script>
</html>