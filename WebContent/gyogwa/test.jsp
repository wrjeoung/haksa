<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>UI Laboratory</title>
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/scripts/shCore.js"></script>
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/scripts/shBrushBash.js"></script>
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/scripts/shBrushCpp.js"></script>
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/scripts/shBrushCSharp.js"></script>
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/scripts/shBrushCss.js"></script>
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/scripts/shBrushDelphi.js"></script>
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/scripts/shBrushDiff.js"></script>
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/scripts/shBrushGroovy.js"></script>
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/scripts/shBrushJava.js"></script>
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/scripts/shBrushJScript.js"></script>
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/scripts/shBrushPhp.js"></script>
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/scripts/shBrushPlain.js"></script>
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/scripts/shBrushPython.js"></script>
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/scripts/shBrushRuby.js"></script>
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/scripts/shBrushScala.js"></script>
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/scripts/shBrushSql.js"></script>
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/scripts/shBrushVb.js"></script>
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/scripts/shBrushXml.js"></script>
<link type="text/css" rel="stylesheet"
	href="http://mylko72.maru.net/jquerylab/styles/shCore.css" />
<link type="text/css" rel="stylesheet"
	href="http://mylko72.maru.net/jquerylab/styles/shThemeDefault.css" />
<script type="text/javascript">
	SyntaxHighlighter.config.clipboardSwf = 'http://mylko72.maru.net/jquerylab/scripts/clipboard.swf';
	SyntaxHighlighter.all();
</script>
<link rel="stylesheet" type="text/css"
	href="http://mylko72.maru.net/jquerylab/inc/css/common.css" />
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/inc/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript"
	src="http://mylko72.maru.net/jquerylab/inc/js/common.js"></script>
<!--[if lt IE 9]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
<style>
.layer {
	display: none;
	position: fixed;
	_position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: 100;
}

.layer .bg {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: #000;
	opacity: .5;
	filter: alpha(opacity = 50);
}

.layer .pop-layer {
	display: block;
}

.pop-layer {
	display: none;
	position: absolute;
	top: 50%;
	left: 50%;
	width: 410px;
	height: auto;
	background-color: #fff;
	border: 5px solid #3571B5;
	z-index: 10;
}

.pop-layer .pop-container {
	padding: 20px 25px;
}

.pop-layer p.ctxt {
	color: #666;
	line-height: 25px;
}

.pop-layer .btn-r {
	width: 100%;
	margin: 10px 0 20px;
	padding-top: 10px;
	border-top: 1px solid #DDD;
	text-align: right;
}

a.cbtn {
	display: inline-block;
	height: 25px;
	padding: 0 14px 0;
	border: 1px solid #304a8a;
	background-color: #3f5a9d;
	font-size: 13px;
	color: #fff;
	line-height: 25px;
}
a.cbtn:hover {
	border: 1px solid #091940;
	background-color: #1f326a;
	color: #fff;
}
.btoggle {
	margin: 0 10px 0 0;
	padding-bottom: 5px;
	border-bottom: 1px dashed #ddd;
	text-align: right;
}
</style>
</head>
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
			<h3>>교과목조회</h3>
		</div>
		<table color="red" border="2">
			<tr>
				<td>
					<form class="form-inline" role="form">
						<div class="form-group" style="margin-right: 30px;">
							<p>
								<strong>&nbsp;&nbsp;&nbsp;&nbsp;조직</strong>
							</p>
						</div>
						<div class="form-group" style="margin-right: 30px;">
							<select class="form-control" name="year" style="width: 200px;">
								<option>대학(학부/서울)</option>
								<option>대학원(학부/서울)</option>
							</select>
						</div>

						<div class="form-group" style="margin-right: 15px;">
							<p>
								<strong>교육과정</strong>
							</p>
						</div>
						<div class="form-group" style="margin-right: 30px;">
							<select class="form-control" name="hakgi" style="width: 200px;">
								<option>학부 2013~2016 교육과정</option>
								<option>학부 2014~2017 교육과정</option>
							</select>
						</div>
						<br> <br>
						<div class="form-group" style="margin-right: 15px;">
							<p>
								<strong>이수학년</strong>
							</p>
						</div>
						<div class="form-group" style="margin-right: 30px;">
							<select class="form-control" name="hakgi" style="width: 200px;">
								<option>전체 학년</option>
								<option>2학년</option>
								<option>3학년</option>
								<option>4학년</option>
							</select>
						</div>

						<div class="form-group" style="margin-right: 15px;">
							<p>
								<strong>이수학기</strong>
							</p>
						</div>
						<div class="form-group" style="margin-right: 30px;">
							<select class="form-control" name="hakgi" style="width: 200px;">
								<option>전학기</option>
								<option>1학기</option>
								<option>2학기</option>
							</select>
						</div>
						<br> <br>

						<div class="form-group" style="margin-right: 30px;">
							<p>
								<strong>&nbsp;&nbsp;과목명</strong>
							</p>
						</div>
						<div class="form-group" style="margin-right: 55px;">
							<select class="form-control" name="hakgi" style="width: 200px;">
									
								<option>미적분학</option>
								<option>JAVA</option>
								<option>생체리듬</option>
							</select>
						</div>
				</td>
			</tr>
		</table>


<br> <br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>학수번호</th>
					<th>과목명</th>
					<th>이수구분</th>
					<th>교수명</th>
					<th>학점</th>
					<th>성적등급</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>학수번호</td>
					<td>	<a href="#" 
			onclick="layer_open('layer2');return false;">미적분학1</a></td>
					<td>기초필수</td>
					<td>고광렬이</td>
					<td>4.0</td>
					<td>A+</td>
					<td></td>
				</tr>
			</tbody>
		</table>


	<div class="layer">
		<div class="bg"></div>
		<div id="layer2" class="pop-layer">
			<div class="pop-container">
				<div class="pop-conts">
					<!--content //-->
				
						<table class="table table-bordered">
			<thead>
				<tr>
					<th>학수번호</th>
					<th>과목명</th>
					<th>이수구분</th>
					<th>교수명</th>
					<th>학점</th>
					<th>성적등급</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>학수번호</td>
					<td>미적분학1</td>
					<td>기초필수</td>
					<td>고광렬이</td>
					<td>4.0</td>
					<td>A+</td>
					<td></td>
				</tr>
			</tbody>
		</table>
				

					<div class="btn-r">
						<a href="#" class="cbtn">Close</a>
					</div>
					<!--// content-->
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function layer_open(el) {

			var temp = $('#' + el);
			var bg = temp.prev().hasClass('bg');

			if (bg) {
				$('.layer').fadeIn();
			} else {
				temp.fadeIn();
			}

			if (temp.outerHeight() < $(document).height())
				temp.css('margin-top', '-' + temp.outerHeight() / 2 + 'px');
			else
				temp.css('top', '0px');
			if (temp.outerWidth() < $(document).width())
				temp.css('margin-left', '-' + temp.outerWidth() / 2 + 'px');
			else
				temp.css('left', '0px');

			temp.find('a.cbtn').click(function(e) {
				if (bg) {
					$('.layer').fadeOut();
				} else {
					temp.fadeOut();
				}
				e.preventDefault();
			});

			$('.layer .bg').click(function(e) {
				$('.layer').fadeOut();
				e.preventDefault();
			});

		}
	</script>

</body>
</html>