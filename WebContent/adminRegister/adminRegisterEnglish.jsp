<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>관리자 - 수강신청</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- 부트스트랩 -->
<link href="dist/css/bootstrap.css" rel="stylesheet" media="screen">

<!-- Custom styles for this template -->
<link href="dist/customcss/starter-template.css" rel="stylesheet">

<script>
	function deleteCheck()
	{
		var checkth = document.getElementById("checkth");
		var checktd = document.getElementsByName("checktd");
		
		$(checkth).removeAttr("style");
		
	    for(var i=0; i<checktd.length; i++){
	    	$(checktd[i]).removeAttr("style");
	    }
	}
	
	function deleteList()
	{
		var checkBox = document.getElementsByName("chk");
		var checkedNumList=""; 
			
		for(var i = 0; i<checkBox.length;i++)
		{
			if(checkBox[i].checked)
			{
				var subjectnum = document.getElementById("subjectnum"+i);
				checkedNumList += subjectnum.childNodes[0].nodeValue+",";
			}
		}
		alert("삭제되었습니다.");
		document.location.href = "adminRegisterDelete.do?checkedNumList="+checkedNumList;
	}
</script>

</head>
<body>
	<!-- header -->
	<%@ include file="/common/header.jsp"%>
	<!-- end of header -->

	<div class="container">
		<div class="page-header">
		  <h3>>관리자 - 수강신청</h3>
		</div>
		
		<form class="form-inline" role="form">
			<input type="hidden" id="hidden" value="">
			<p></p>
			<p class="text-success"><strong>[수강신청과목 List]</strong></p>			
			<table class="table table-bordered">
				<thead>
		          <tr>
	          	    <th id="checkth" style="display:none;"></th>
		            <th>학수번호</th>
		            <th>과목명</th>
		            <th>교과과정</th>
		            <th>이수</th>
		            <th>학점</th>
		            <th>정원</th>
		            <th>여분</th>
		            <th>강의시간</th>
		            <th>담당교수</th>
		            <th>강의실</th>
		            <th>비고</th>
		            <th>학과</th>
		            <th>학년</th>
		          </tr>
		        </thead>
		        <tbody>
		        	<c:forEach var="list" items="${list}" varStatus="vs">
		        		<tr>
		        			<td id="checktd" name="checktd" style="display:none;">
	        					<input type="checkbox" name="chk" id="chk">
		        			</td>
		        			<td id="subjectnum${vs.index}">${list.subjectnum}</td>
			        		<td>${list.subjectname}</td>
			        		<td>${list.curriculum}</td>
			        		<td>${list.course}</td>
			        		<td>${list.credit}</td>
			        		<td>${list.fixednum}</td>
			        		<td>${list.fixednum - list.extranum}</td>
			        		<td>${list.lecturetime}</td>
			        		<td>${list.professor}</td>
			        		<td>${list.classroom}</td>
			        		<td>${list.etc}</td>
			        		<td>${list.major}</td>
			        		<td>${list.grade}</td>
		        		</tr>
		        	</c:forEach>
		        </tbody>
	      </table>
	      <div class="text-center">
				<ul class="pagination pagination-sm">
				${pagingHtml}
				<button type="button" class="btn btn-default" style="margin-left:50px;" onclick="deleteCheck()">삭제</button>
				<button type="button" class="btn btn-default" onclick="deleteList()">완료</button>
			</div>
			<p class="text-success">
				<strong>[수강신청과목 추가]</strong>
				<button type="button" class="btn btn-default"  style="margin-left:50px;" onclick="javascript:location.href='adminRegisterAdd.do'";>추가</button>
				
			</p>
		</form>
	</div>
	<!-- /.container -->

	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
	<script src="//code.jquery.com/jquery.js"></script>
	<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
	<script src="dist/js/bootstrap.min.js"></script>
	<!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
	<!-- <script src="js/respond.js"></script> -->
</body>
</html>