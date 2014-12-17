<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		  <h3>>졸업사정 조회</h3>
		</div>
		
		
		<form class="form-inline" role="form">
			<div class="form-group" style="margin-right:15px;">
				<p><strong>전공</strong></p>
			</div>
			<div class="form-group" style="margin-right:30px;">
				<select class="form-control" style="width:100px;">

				  <option>주전공(제1전공)</option>
				  <option>다중전공</option>
				  <option>복수전공</option>
				</select>
			</div>
			<div class="form-group" style="margin-right:30px;">
				<input class="btn btn-primary" type="button" name="list" value="조회" onclick="javascript:location.href=''"/>
			</div>
			<p></p>
			
			<p class="text-success"><strong>[졸업사정조회]</strong></p>		
		<table class="table table-bordered">
				<thead>
		          <tr>
		            <th>이수명</th>
		            <th>배당</th>
		            <th>취득</th>
		            <th>수강</th>
		            <th>이수</th>
		            <th>잔여</th>
		            <th>제외값</th>
		            <th>제외사유</th>
		        </tr>
		        </thead>
		        <tbody>
		          <tr>+
		            <td>졸업학점</td>
		            <td>140</td>
		            <td>126</td>
		            <td></td>
		            <td>N</td>
		            <td>14</td>
		            <td>0</td>
		            <td> </td>
		          </tr>
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
	