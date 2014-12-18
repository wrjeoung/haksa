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

<script type="text/javascript">
	function inputCheck() {
		
		if(document.getElementById("studentNumber").value == "")
		{
			document.getElementById("studentNumber").focus();
			alert("학번을 입력하세요!");
			return false;
		}
		if(document.getElementById("name").value == "")
		{
			document.getElementById("name").focus();
			alert("성명을 입력하세요!");
			return false;
		}
		if(document.getElementById("birthday").value == "")
		{
			document.getElementById("birthday").focus();
			alert("생년월일 입력하세요!");
			return false;
		}
		if(document.getElementById("major").value == "")
		{
			document.getElementById("major").focus();
			alert("학부(과),전공을 입력하세요!");
			return false;
		}
		if(document.getElementById("tel1").value == "")
		{
			document.getElementById("tel1").focus();
			alert("전화번호를 입력하세요!");
			return false;
		}
		if(document.getElementById("tel2").value == "")
		{
			document.getElementById("tel2").focus();
			alert("전화번호를 입력하세요!");
			return false;
		}
		if(document.getElementById("tel3").value == "")
		{
			document.getElementById("tel3").focus();
			alert("전화번호를 입력하세요!");
			return false;
		}
		if(document.getElementById("hp1").value == "")
		{
			document.getElementById("hp1").focus();
			alert("핸드폰번호 입력하세요!");
			return false;
		}
		if(document.getElementById("hp2").value == "")
		{
			document.getElementById("hp2").focus();
			alert("핸드폰번호 입력하세요!");
			return false;
		}
		if(document.getElementById("hp3").value == "")
		{
			document.getElementById("hp3").focus();
			alert("핸드폰번호 입력하세요!");
			return false;
		}
		if(document.getElementById("email").value == "")
		{
			document.getElementById("email").focus();
			alert("이메일을 입력하세요!");
			return false;
		}
		if(document.getElementById("address").value == "")
		{
			document.getElementById("address").focus();
			alert("주소를 입력하세요!");
			return false;
		}
		return true;
	}
	
</script>
</head>
<body>	<!-- header -->
	<%@ include file="/common/header.jsp"%>
	<!-- end of header -->
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form class="form-inline" role="form" action="modifyStdInfoPro.do" onsubmit="return inputCheck()">
					<h3 class="form-signin-heading">기본정보.</h3>
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td style="background-color: #A9A9A9">학번</td>
								<td>
									<div class="form-group">
										<input type="text" class="form-control" id=studentNumber name="studentNumber" value="${member.studentNumber }">
									</div>
								</td>
								<td style="background-color: #A9A9A9">성명</td>
								<td>
									<div class="form-group">
											<input type="text" class="form-control" id=name name="name" value="${member.name }">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color: #A9A9A9">생년월일</td>
								<td>
									<div class="form-group">
											<input type="text" class="form-control" id=birthday name="birthday" value="${member.birthday }">
									</div>
								</td>
								<td style="background-color: #A9A9A9">학부(과), 전공</td>
								<td>
									<div class="form-group">
										<input type="text" class="form-control" id=major name="major" value="${member.major }">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color: #A9A9A9">학년</td>
								<td>
									<div class="form-group">
											<select id="grade" name="grade" class="form-control" >
												<option value="1학년" <c:if test="${member.grade eq '1학년' }">SELECTED</c:if>>1학년</option>
												<option value="2학년" <c:if test="${member.grade eq '2학년' }">SELECTED</c:if>>2학년</option>
												<option value="3학년" <c:if test="${member.grade eq '3학년' }">SELECTED</c:if>>3학년</option>
												<option value="4학년" <c:if test="${member.grade eq '4학년' }">SELECTED</c:if>>4학년</option>
											</select>
									</div>
								</td>
								<td style="background-color: #A9A9A9">입학구분(입학년도)</td>
								<td>
									<select id="entrace_date" name="entrace_date" class="form-control">
										<option value="1999" <c:if test="${member.entrace_date eq '1999' }">SELECTED</c:if>>1999</option>
										<option value="2000" <c:if test="${member.entrace_date eq '2000' }">SELECTED</c:if>>2000</option>
										<option value="2001" <c:if test="${member.entrace_date eq '2001' }">SELECTED</c:if>>2001</option>
										<option value="2002" <c:if test="${member.entrace_date eq '2002' }">SELECTED</c:if>>2002</option>
										<option value="2003" <c:if test="${member.entrace_date eq '2003' }">SELECTED</c:if>>2003</option>
										<option value="2004" <c:if test="${member.entrace_date eq '2004' }">SELECTED</c:if>>2004</option>
										<option value="2005" <c:if test="${member.entrace_date eq '2005' }">SELECTED</c:if>>2005</option>
										<option value="2006" <c:if test="${member.entrace_date eq '2006' }">SELECTED</c:if>>2006</option>
										<option value="2007" <c:if test="${member.entrace_date eq '2007' }">SELECTED</c:if>>2007</option>
										<option value="2008" <c:if test="${member.entrace_date eq '2008' }">SELECTED</c:if>>2008</option>
										<option value="2009" <c:if test="${member.entrace_date eq '2009' }">SELECTED</c:if>>2009</option>
										<option value="2010" <c:if test="${member.entrace_date eq '2010' }">SELECTED</c:if>>2010</option>
										<option value="2011" <c:if test="${member.entrace_date eq '2011' }">SELECTED</c:if>>2011</option>
										<option value="2012" <c:if test="${member.entrace_date eq '2012' }">SELECTED</c:if>>2012</option>
										<option value="2013" <c:if test="${member.entrace_date eq '2013' }">SELECTED</c:if>>2013</option>
										<option value="2014" <c:if test="${member.entrace_date eq '2014' }">SELECTED</c:if>>2014</option>
									</select>
								</td>
							</tr>
							<tr>
								<td style="background-color: #A9A9A9">학적상태</td>
								<td colspan="4">
									<div class="form-group">
									<select id="state" name="state" class="form-control">
										<option value="재학중" <c:if test="${member.state eq '재학중' }">SELECTED</c:if>>재학중</option>
										<option value="휴학중" <c:if test="${member.state eq '휴학중' }">SELECTED</c:if>>휴학중</option>
										<option value="졸업" <c:if test="${member.state eq '졸업' }">SELECTED</c:if>>졸업</option>
									</select>
										
									</div>
								</td>
							</tr>
						</tbody>
					</table>
					<br />
					<h3 class="form-signin-heading">개인정보.</h3>
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td style="background-color: #A9A9A9; width: 200px">전화번호</td>
								<td>
									<div class="form-group">
										<input type="text" class="form-control" id="tel1" name="tel1" maxlength="4" value="${tel0 }">
									</div>-
									<div class="form-group">
										<input type="text" class="form-control"	id="tel2" name="tel2" maxlength="4" value="${tel1 }">
									</div>-
									<div class="form-group">
										<input type="text" class="form-control"	id="tel3" name="tel3" maxlength="4" value="${tel2 }">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color: #A9A9A9">핸드폰</td>
								<td>
									<div class="form-group">
										<input type="text" class="form-control" id="hp1" name="hp1" maxlength="4" value="${cellphone0 }">
									</div>-
									<div class="form-group">
										<input type="text" class="form-control" id="hp2" name="hp2" maxlength="4" value="${cellphone1 }">
									</div>-
									<div class="form-group">
										<input type="text" class="form-control" id="hp3" name="hp3" maxlength="4" value="${cellphone2 }">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color: #A9A9A9">이메일</td>
								<td><input type="text" class="form-control" id="email" name="email" value="${member.email }"></td>
							</tr>
							<tr>
								<td style="background-color: #A9A9A9">주소</td>
								<td><input type="text" class="form-control"	id="address" name="address" value="${member.address }"></td>
							</tr>
						</tbody>
					</table>
					<button type="submit" class="btn btn-primary">수정완료</button>
				</form>
			</div>
		</div>
	</div>


	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
	<script src="//code.jquery.com/jquery.js"></script>
	<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
	<script src="dist/js/bootstrap.min.js"></script>

	<!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
	<!-- <script src="js/respond.js"></script> -->
</body>
</html>