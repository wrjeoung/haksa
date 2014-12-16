<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>수강과목 철회</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- 부트스트랩 -->
<link href="dist/css/bootstrap.css" rel="stylesheet" media="screen">
<!-- Custom styles for this template -->
<link href="dist/customcss/starter-template.css" rel="stylesheet">
<script>

	function hiddenSet(subjectn, subjectname){
		var hidden = document.getElementById("hidden");
		hidden.value = subjectn;
		console.log("hidden.value : " + hidden.value);

		var modalbody = document.getElementById("modal-body");
		var str = "";
		str += subjectname+"을(를) 수강 철회 하시겠습니까?";
		modalbody.innerHTML = str;
	}

	function registerCancle(stnum){
		var stnumber = stnum;
		var hidden = document.getElementById("hidden");

		console.log("stnumber : " + stnumber);
		console.log("hidden : " + hidden.value);

		var str = "registerCanclePro.do?subjectnum=" + hidden.value + "&stnumber=" + stnumber;
		console.log("str : " + str);

		$('#layerpop').modal('hide')
		location.href= str; 
	}
</script>
</head>
<body>
	<!-- header -->
	<%@ include file="/common/header.jsp"%>
	<!-- end of header -->
	
	<div class="container">
		<div class="page-header">
		  <h3>>수강과목 철회</h3>
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
			<p></p>
			<p class="text-success"><strong>[수강신청 List]</strong></p>
			
			<table class="table table-bordered">
				<thead>
		          <tr>
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
		            <th>철회</th>
		          </tr>
		        </thead>
		        <tbody>
		        	<c:forEach var="list" items="${list}">
		        		<tr>
		        			<td>${list.subjectnum}</td>
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
			        		<td>
						<button class="btn btn-primary" data-target="#layerpop" data-toggle="modal" onclick="hiddenSet('${list.subjectnum}','${list.subjectname}')">철회</button><br/>
			        		</td>
		        		</tr>
		        	</c:forEach>
		        </tbody>
	     	 </table>
	     	 <div class="text-center">
				<ul class="pagination pagination-sm">
				${pagingHtml}
			</div>
			
			<div class="modal fade" id="layerpop" >
				<div class="modal-dialog">
					<div class="modal-content">
						<!-- header -->
						<div class="modal-header">
							<!-- 닫기(x) 버튼 -->
					        <button type="button" class="close" data-dismiss="modal">×</button>
					        <!-- header title -->
					    	<h4 class="modal-title">수강철회</h4>
				    	</div>
					    <!-- body -->
					    <div class="modal-body" id="modal-body">
					    	수강 철회 하시겠습니까?
					    </div>
					    <!-- Footer -->
					    <div class="modal-footer">
					    	<button type="button" class="btn btn-primary" onclick="registerCancle('${member.studentNumber}')" >철회</button>
					        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					    </div>
				    </div>
			    </div>
		    </div>
		</form>
	</div>
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
	<script src="//code.jquery.com/jquery.js"></script>
	<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
	<script src="dist/js/bootstrap.min.js"></script>
	<!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
	<!-- <script src="js/respond.js"></script> -->
</body>
</html>