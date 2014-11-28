<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Univ.</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">My홈 <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li class="dropdown-header">학생정보</li>
							<li><a href="#">개인정보변경</a></li>
							<li><a href="#">비밀번호변경</a></li>
							<li class="divider"></li>
							<li class="dropdown-header">성적조회 / 졸업사정조회</li>
							<li><a href="#">학기별 성적조회</a></li>
							<li><a href="#">졸업사정 조회</a></li>
							<li><a href="#">필수과목이수조회</a></li>
							<li class="divider"></li>
							<li class="dropdown-header">등록장학</li>
							<li><a href="#">등록금내역 조회</a></li>
							<li><a href="#">장학금수혜내역 조회</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">수업 <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li class="dropdown-header">교육과정 조회</li>
							<li><a href="#">교과목 조회</a></li>
							<li class="divider"></li>
							<li class="dropdown-header">강의 평가</li>
							<li><a href="#">강의 우수강사 조회</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">신청 <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li class="dropdown-header">학적변동</li>
							<li><a href="#">휴학신청</a></li>
							<li><a href="#">복학신청</a></li>
							<li><a href="#">전과신청</a></li>
							<li><a href="#">자퇴신청</a></li>
							<li class="divider"></li>
							<li class="dropdown-header">전공관리</li>
							<li><a href="#">주전공배정신청</a></li>
							<li><a href="#">전공신청/포기</a></li>
							<li class="divider"></li>
							<li class="dropdown-header">등록장학</li>
							<li><a href="#">교내장학금신청</a></li>
							<li class="divider"></li>
							<li class="dropdown-header">학점인정/포기선청</li>
							<li><a href="#">학점포기신청</a></li>
						</ul></li>
					<li><a href="registerclass.do">수강신청</a></li>
					<li><a href="#contact">수강과목철회</a></li>
					<li><a href="#contact">공지사항</a></li>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</div>

	<div class="container">
		<div class="page-header">
		  <h3>>수강신청</h3>
		</div>
		
		<form class="form-inline" role="form">
			<div class="form-group" style="margin-right:15px;">
				<p><strong>학과  : </strong></p>
			</div>
			<div class="form-group" style="margin-right:30px;">
				<p class="text-info"><strong>정보통신공학과</strong></p>
			</div>
			<div class="form-group" style="margin-right:15px;">
				<p><strong>학번  : </strong></p>
			</div>
			<div class="form-group" style="margin-right:30px;">
				<p class="text-info"><strong>20202020202020</strong></p>
			</div>
			<div class="form-group" style="margin-right:15px;">
				<p><strong>학년  : </strong></p>
			</div>
			<div class="form-group" style="margin-right:30px;">
				<p class="text-info"><strong>4</strong></p>
			</div>
			<div class="form-group" style="margin-right:15px;">
				<p><strong>성명  : </strong></p>
			</div>
			<div class="form-group" style="margin-right:30px;">
				<p class="text-info"><strong>홍길동</strong></p>
			</div>
			<div class="form-group" style="margin-right:15px;">
				<p><strong>학적상태  : </strong></p>
			</div>
			<div class="form-group" style="margin-right:30px;">
				<p class="text-info"><strong>재학</strong></p>
			</div>
			<div class="form-group" style="margin-right:15px;">
				<p><strong>신청가능학점  : </strong></p>
			</div>
			<div class="form-group" style="margin-right:30px;">
				<p class="text-info"><strong>19 학점</strong></p>
			</div>
			
			<p></p>			
			
			<div class="form-group" style="margin-right:15px;">
				<p><strong>전공/교양</strong></p>
			</div>
			<div class="form-group" style="margin-right:30px;">
				<select class="form-control" style="width:100px;">
				  <option>전공</option>
				  <option>교양</option>
				</select>
			</div>
			<div class="form-group" style="margin-right:30px;">
				<input class="btn btn-primary" type="button" name="list" value="조회" onclick="javascript:location.href=''"/>
			</div>
			<p></p>
			<p class="text-success"><strong>[개설교과목 List]</strong></p>
			
			<table class="table table-bordered">
				<thead>
		          <tr>
		            <th>No</th>
		            <th>학수번호</th>
		            <th>과목명</th>
		            <th>이수</th>
		            <th>학점</th>
		            <th>정원</th>
		            <th>여분</th>
		            <th>강의시간</th>
		            <th>담당교수</th>
		            <th>강의실</th>
		            <th>비고</th>
		            <th>신청</th>
		          </tr>
		        </thead>
		        <tbody>
		          <tr>
		            <td>Mark</td>
		            <td>Otto</td>
		            <td>@TwBootstrap</td>
		            <td>Mark</td>
		            <td>Otto</td>
		            <td>@TwBootstrap</td>
		            <td>Mark</td>
		            <td>Otto</td>
		            <td>@TwBootstrap</td>
		            <td>Mark</td>
		            <td>Otto</td>
		            <td>
		            	<input style="height:30px;" class="btn btn-primary" type="button" name="list" value="신청" onclick="javascript:location.href=''"/>
		            </td>
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