<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
    
    <script type="text/javascript">
    	function isLogin() {
    		alert("로그인 후 사용 가능 합니다.")
    	}
    </script>
  </head>
  <body>
              ####
  	${loginCheck } ###
  	${memId }
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
          <ul class="nav navbar-nav">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">My홈 <b class="caret"></b></a>
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
              </ul>
            </li>            
            <li><a href="#contact">수강신청</a></li>
            <li><a href="#contact">수강과목철회</a></li>
            <li><a href="#contact">공지사항</a></li>
          </ul>
          <form class="navbar-form navbar-right" action="loginPro.do" method="post">
            <div class="form-group">
              <input type="text" placeholder="학번" class="form-control" name="studentNumber">
            </div>
            <div class="form-group">
              <input type="password" placeholder="비밀번호" class="form-control" name="password">
            </div>
            <button type="submit" class="btn btn-success">Sign in</button>
          </form>
        </div><!--/.nav-collapse -->
        
      </div>
    </div>

    <div class="container">
      <div class="starter-template">
        <h1>Bootstrap starter template</h1>
        <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p>
      </div>
    </div><!-- /.container -->
 
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
    <script src="dist/js/bootstrap.min.js"></script>
    
    <!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
    <!-- <script src="js/respond.js"></script> -->
    
  </body>
</html>