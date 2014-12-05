<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<title>학사정보시스템</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- 부트스트랩 -->
<link href="dist/css/bootstrap.css" rel="stylesheet" media="screen">

<!-- Custom styles for this template -->
<link href="dist/customcss/starter-template.css" rel="stylesheet">

<script type="text/javascript">
    	function validation() {
    		
    		var loginForm=document.getElementById("loginForm");
    		console.log(loginForm.studentNumber.value);
    		
    		if(!loginForm.studentNumber.value){
    			alert("학번을 입력하세요.");
    			loginForm.studentNumber.focus();
    			return false;
    		}
    		if(!loginForm.password.value){
    			alert("비밀번호를 입력하세요.");
    			loginForm.password.focus();
    			return false;
    		}
    	}
    </script>
</head>


<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
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
						<li><a href="hakgi.do">학기별 성적조회</a></li>
						<li><a href="graduation.do">졸업사정 조회</a></li>
						<li><a href="feelsu.do">필수과목이수조회</a></li>
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
			<form class="navbar-form navbar-right">
				<div class="form-group">
					<input type="text" placeholder="학번" class="form-control">
				</div>
				<div class="form-group">
					<input type="password" placeholder="비밀번호" class="form-control">
				</div>
				<button type="submit" class="btn btn-success">Sign in</button>
			</form>
		</div>
		<!--/.nav-collapse -->

	</div>
</div>

 <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Univ.</a>
        </div>
        	
		        <div class="collapse navbar-collapse">
		        <c:if test="${memId != null}">
		          <ul class="nav navbar-nav">
		            <li class="dropdown">
		              <a href="#" class="dropdown-toggle" data-toggle="dropdown">My홈 <b class="caret"></b></a>
		              <ul class="dropdown-menu">
		                <li class="dropdown-header">학생정보</li>
		                <li><a href="infomodify.do">개인정보변경</a></li>
		                <li><a href="pwCheck.do">비밀번호변경</a></li>
		                <li class="divider"></li>
		                <li class="dropdown-header">성적조회 / 졸업사정조회</li>
		                <li><a href="hakgi.do">학기별 성적조회</a></li>
		                <li><a href="graduation.do">졸업사정 조회</a></li>
		                <li><a href="feelsu.do">필수과목이수조회</a></li>
		                <li class="divider"></li>
		                <li class="dropdown-header">등록장학</li>
		                <li><a href="#">등록금내역 조회</a></li>
		                <li><a href="#">장학금수혜내역 조회</a></li>
		              </ul>
		            </li>
		            <li class="dropdown">
		              <a href="#" class="dropdown-toggle" data-toggle="dropdown">수업 <b class="caret"></b></a>
		              <ul class="dropdown-menu">
		                <li class="dropdown-header">교육과정 조회</li>
		                <li><a href="#">교과목 조회</a></li>
		                <li class="divider"></li>
		                <li class="dropdown-header">강의 평가</li>
		                <li><a href="#">강의 우수강사 조회</a></li>
		              </ul>
		            </li>
		            <li class="dropdown">
		              <a href="#" class="dropdown-toggle" data-toggle="dropdown">신청 <b class="caret"></b></a>
		              <ul class="dropdown-menu">
		                <li class="dropdown-header">학적변동</li>
		                <li><a href="insertHuhakForm.do">휴학신청</a></li>
		                <li><a href="insertBokhakForm.do">복학신청</a></li>
		                <li><a href="insertJunkwaForm.do">전과신청</a></li>
		                <li><a href="insertLeaveForm.do">자퇴신청</a></li>
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
		              </ul>
		            </li>
		            <li class="dropdown">
		            	<a href="#" class="dropdown-toggle" data-toggle="dropdown">수강신청<b class="caret"></b></a>
		            	<ul class="dropdown-menu">
		            		<li class="dropdown-header">신청</li>
		            		<li><a href="registerclass.do">전공신청</a></li>
		                	<li><a href="culturalclass.do">교양신청</a></li>
		                	<li class="dropdown-header">내역</li>
		                	<li><a href="">수강신청내역</a></li>
		            	</ul>
		            </li>
		            <li><a href="#contact">수강과목철회</a></li>
		            <li><a href="noticeList.do">공지사항</a></li>
		          </ul>
	          </c:if>
	          
	          <form class="navbar-form navbar-right" name="loginForm" id="loginForm" action="loginOutPro.do" method="post" onsubmit="return validation();">
	          	<c:if test="${memId == null}">
		            <div class="form-group">
		              <input type="text" placeholder="학번" class="form-control" name="studentNumber" id="studentNumber">
		            </div>
		            <div class="form-group">
		              <input type="password" placeholder="비밀번호" class="form-control" name="password" id="password">
		            </div>
	            </c:if>
	            <c:choose>
	            	<c:when test="${memId == null }">
	            		<button type="submit" class="btn btn-success">Sign in</button>
	            	</c:when>
	            	<c:otherwise>
	            		<button type="submit" class="btn btn-success">Sign out</button>
	            	</c:otherwise>
	            </c:choose>
	          </form>
	       
	      </div><!--/.nav-collapse -->
      </div>
    </div>
    
    
   

