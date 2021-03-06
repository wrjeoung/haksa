<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
Date nowDate=new Date();		
//└현재날짜와 시간을 얻어온다.
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
//└날짜형식을 yyyy년MM월dd일 형식으로 사용하기 위해서 simpledateformat 객체 생성
SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy년MM월dd일");
String formatDate=dateFormat.format(nowDate);
//└현재의 날짜와 시간에 yyyy년MM월dd일 형식을 format()메소드를 사용해서 적용
String formatDate2=dateFormat2.format(nowDate);
//out.println(formatDate);
//out.println(formatDate2);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>주전공신청</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<script type="text/javascript">
	/* function chk_del() {
		chk.action="jujungongDelete.do"
		chk.submit();
	} */
	
	function chk_del(){
	    var count = 0;
	    var rnum = document.getElementsByName('rnum');
	    for(i=0; i<rnum.length;i++){
	        if(rnum[i].checked) { count += 1; }
	    }
	    if(count==0){ alert("체크된 항목이 없습니다."); 
	    }else{
	    	chk.action="jujungongDelete.do"
	    	chk.submit();
	    }
	}
</script>
<body>
<%@ include file="/common/header.jsp"%>
<div class="container">
	<div class="page-header">
		<h3>>주전공신청</h3>
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
<p class="text-success"><strong>[주전공신청]</strong></p>
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
				<%-- <td><input type="checkbox" name="rnum" value="${vo.num }"></td> --%>
				
				<c:if test="${vo.jujungongchuri=='신청' }">
				<td><input type="checkbox" name="rnum" value="${vo.num}"></td>
				</c:if>
				<c:if test="${vo.jujungongchuri=='신청완료' }">
				<td></td>
				</c:if>
			
			</tr>
		</c:forEach>
	</tbody>
</table>
</form>
</div>
<c:if test="${member.state!='졸업' && member.state!='자퇴' }">
<form action="insertJujungongPro.do" method="post" enctype="multipart/form-data" onSubmit="" name="">
	<table border="1" width="1100" cellspacing="0" cellpadding="0" align="center">
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">변동구분</td><td width="520" align="left">
			&nbsp;<select name="jujungonggubun"><option value="주전공신청">주전공신청</option></select></td>
			<td width="280" bgcolor="#BDBDBD">결재결과</td><td width="520" align="left">
			&nbsp;<input type="text" name="jujungonggyul" size="20"></td>
		</tr>
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">신청학년</td><td width="520" align="left">
			&nbsp;<input type="text" name="jujungongyear1" size="20" value="<%=formatDate%>">&nbsp;년도
			&nbsp;<select name="jujungongyear2">
			<option value="1학년">1학년</option>
			<option value="2학년">2학년</option>
			<option value="3학년">3학년</option>
			<option value="4학년">4학년</option></select></td>
			<td width="280" bgcolor="#BDBDBD">신청일자</td><td width="520" align="left">
			&nbsp;<input type="text" name="jujungongday" value="<%=formatDate2 %>">
			</td>
		</tr>
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD" rowspan="4">지원전공</td>
			<td width="520" align="left" colspan="3">
			&nbsp;1지망:
			<select name="jujungong1">
			<c:forEach var="list" items="${list }">
				<option value="${list.jungong }">${list.jungong }</option>
				<option value="${list.jungong2 }">${list.jungong2 }</option>
				<option value="${list.jungong3 }">${list.jungong3 }</option>
				<option value="${list.jungong4 }">${list.jungong4 }</option>
			</c:forEach></select><br/>
			&nbsp;2지망:
			<select name="jujungong2">
			<c:forEach var="list2" items="${list }">
				<%-- <option>${list2.jungong }</option> --%>
				<option value="${list2.jungong2 }">${list2.jungong2 }</option>
				<option value="${list2.jungong3 }">${list2.jungong3 }</option>
				<option value="${list2.jungong4 }">${list2.jungong4 }</option>
			</c:forEach></select><br/>
			&nbsp;3지망:
			<select name="jujungong3">
			<c:forEach var="list3" items="${list }">
				<%-- <option>${list3.jungong }</option>
				<option>${list3.jungong2 }</option> --%>
				<option value="${list3.jungong3 }">${list3.jungong3 }</option>
				<option value="${list3.jungong4 }">${list3.jungong4 }</option>
			</c:forEach></select><br/>
			&nbsp;4지망:
			<select name="jujungong4">
			<c:forEach var="list4" items="${list }">
				<%-- <option>${list4.jungong }</option>
				<option>${list4.jungong2 }</option>
				<option>${list4.jungong3 }</option> --%>
				<option value="${list4.jungong4 }">${list4.jungong4 }</option>
			</c:forEach></select><br/>
			</td>
		</tr>
	</table>
	<div align="center">
	<input type="hidden" value="${member.studentNumber }" name="name">
	<input type="submit" class="btn btn-default" value="신청">
	<button type="button" class="btn btn-default" onclick="chk_del()">취소</button>
	</div>
</form>
</c:if>
</body>
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
    <script src="dist/js/bootstrap.min.js"></script>
</html>