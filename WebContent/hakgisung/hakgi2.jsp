<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>학사정보시스템</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- 부트스트랩 -->
<link href="dist/css/bootstrap.css" rel="stylesheet" media="screen">

<!-- Custom styles for this template -->
<link href="dist/customcss/starter-template.css" rel="stylesheet">
</head>
<body>
	<!-- header -->
	<%@ include file="/common/header.jsp"%>
	<!-- end of header -->
 

	<div class="container">
		<div class="page-header">
		  <h3>>학기별 성적조회</h3>
		</div>
		
		<script>
		var target = document.getElementById("year");
		target.options[target.selectedIndex].text
		</script>
		<form class="form-inline" role="form">
			<div class="form-group" style="margin-right:15px;">
				<p><strong>년도</strong></p>
			</div>
			<div class="form-group" style="margin-right:30px;">
				<select class="form-control" name ="year" style="width:100px;">
   				<c:forEach var="list2" items="${list2}"> 
				  <option value="${list2.year}">${list2.year}</option>
				</c:forEach>
				</select>
			</div>
			
			<div class="form-group" style="margin-right:15px;">
			<p><strong>학기</strong></p>
			</div>
			<div class="form-group" style="margin-right:30px;">
				<select class="form-control" name ="hakgi" style="width:100px;">
				
			<c:forEach var="list3" items="${list3}"> 
				  <option value="${list3.hakgi}">${list3.hakgi}</option>
			</c:forEach>
				</select>
			</div>
			<div class="form-group" style="margin-right:30px;">
				<input class="btn btn-primary" type="button" name="list" value="조회" onclick="javascript:location.href='hakgi2.do'"/>
			</div>

<p></p>		
			
			
			
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

		<p></p>
		<p class="text-success"><strong>[학기별성적 List]</strong></p>
		
		<table class="table table-bordered">
				<thead>
		          <tr>
		            <th>과목코드</th>
		            <th>분반</th>
		            <th>과목명</th>
		            <th>이수구분</th>
		            <th>학점</th>
		            <th>성적등급</th>
		            <th>비고</th>
		          </tr>
		        </thead>
		        <tbody>
		        <tr>
		        
		          <c:forEach var="list4" items="${list4}"> 
		            <td>${list4.gwamokcode}</td>
		            <td>${list4.ban}</td> 
		            <td>${list4.gwamok_nm}</td>
		            <td>${list4.isugubun}</td>
		            <td>${list4.hakjum}</td>
		            <td>${list4.levels}</td>
		            <td>${list4.bigo}  </td> 
		          </tr>  
		            </c:forEach>
		        </tbody>
	      </table>
		
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