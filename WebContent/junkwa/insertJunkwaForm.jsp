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
	String formatDate=dateFormat.format(nowDate);
		//└현재의 날짜와 시간에 yyyy년MM월dd일 형식을 format()메소드를 사용해서 적용
	
	//out.println(formatDate);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>전과신청</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<script type="text/javascript">
	function chk_del(){
		chk.action="junkwaDelete.do";
		chk.submit();
	}
</script>
<body>
<%@ include file="/common/header.jsp"%>
<div class="container">
	<div class="page-header">
		<div class="page-header">
			<h3>>전과신청</h3>
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
<p class="text-success"><strong>[전과신청 List]</strong></p>
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
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.junkwayear }</td>
				<td>${vo.junkwahakgi }</td>
				<td>${vo.junkwahakkwa }</td>
				<td><fmt:formatDate value="${vo.junkwa_reg_date }" pattern="yyyy-MM-dd HH:mm" />
				</td>
				<td>${vo.junkwachuri }</td>
				<td>${vo.junkwachuday }</td>
				<td>${vo.junkwabygo }</td>
				<%-- <td><input type="checkbox" name="rnum" value="${vo.num}" >?=${vo.num}</td> --%>
				<c:if test="${vo.junkwachuri=='신청' }">
				<td><input type="checkbox" name="rnum" value="${vo.num}"></td>
				</c:if>
				<c:if test="${vo.junkwachuri=='신청완료' }">
				<td></td>
				</c:if>
			</tr>
		</c:forEach>
	</tbody>
</table>
</form>
</div>

<form action="insertJunkwaPro.do" method="post" enctype="multipart/form-data" onsubmit="">
	<table border="1" width="1100" cellspacing="0" cellpadding="0" align="center">
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">년도/학기</td>
			<td width="520" align="left">&nbsp;<input type="text" name="junkwayear" value="<%=formatDate%>">&nbsp;/&nbsp;<select name="junkwahakgi"><option value="1학기">1학기</option><option value="2학기">2학기</option></select></td>
			<td width="280" bgcolor="#BDBDBD">신청학부(과)</td>
			<td width="520" align="left">
			<select name="junkwahakkwa">
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
			<option value="정보통신">정보통신공학과</option>
			<option value="교양">교양</option>
			</select></td>
		</tr>
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">비고</td>
			<td width="520" align="left" colspan="4">&nbsp;<input type="text" name="junkwabygo" size="115"></td>
		</tr>
	</table>
	<div align="center">
	<button type="button" onclick="chk_del()">삭제</button>
	<input type="hidden" value="${member.studentNumber }" name="name">
	<input type="submit" value="신청">
	</div>
</form>
</body>
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
    <script src="dist/js/bootstrap.min.js"></script>
</html>