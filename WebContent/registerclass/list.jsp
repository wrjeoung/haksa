<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>수강신청 리스트</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- 부트스트랩 -->
<link href="dist/css/bootstrap.css" rel="stylesheet" media="screen">

<!-- Custom styles for this template -->
<link href="dist/customcss/starter-template.css" rel="stylesheet">
<script>
	function showTimeTable(){
		var Table = document.getElementById("registerList");
		//alert("행의 수 : " + Table.rows.length);
		
		for(var i=1; i<Table.rows.length; i++){
			//var sName = document.getElementById("subjectname"+i);
			//alert("sName : " + sName);
			//console.log("sName : " + sName);
			var r = Table.rows[i];
			var CollLen = r.cells.length;
			//alert("CollLen : " + CollLen);
			
			var tempText1="";
			var tempText2="";
			tempText1 += r.cells[1].innerHTML;
			tempText2 += r.cells[7].innerHTML;
			
			//alert("tempText1 : " + tempText1);
			//alert("tempText2 : " + tempText2);
			
			setTimeTable(tempText1, tempText2);
			/*
			for(var j=0; j<CollLen; j++){
				var text = r.cells[j].innerHTML;
				tempText += text+",";
			}
			alert("tempText : " + tempText);
			*/			
		}
		//$(registerList).removeAttr("style");
	}
	
	function setTimeTable(sname, lectime){
		var subjectname = sname;
		var lecturetime = lectime;
		console.log("subjectname : " + subjectname + " lecturetime : " + lecturetime);
		
		if( lecturetime.search("월1,월2,월3") != -1){
			console.log("찾음");
			document.getElementById("t1M").innerHTML = sname;
			document.getElementById("t2M").innerHTML = sname;
			document.getElementById("t3M").innerHTML = sname;
		}else if( lecturetime.search("월4,월5") != -1){
			console.log("찾음");
			document.getElementById("t4M").innerHTML = sname;
			document.getElementById("t5M").innerHTML = sname;
		}else if( lecturetime.search("월6,월7,월8") != -1){
			console.log("찾음");
			document.getElementById("t6M").innerHTML = sname;
			document.getElementById("t7M").innerHTML = sname;
			document.getElementById("t8M").innerHTML = sname;
		}else if( lecturetime.search("화1,화2,화3") != -1){
			console.log("찾음");
			document.getElementById("t1T").innerHTML = sname;
			document.getElementById("t2T").innerHTML = sname;
			document.getElementById("t3T").innerHTML = sname;
		}else if( lecturetime.search("화4,화5") != -1){
			console.log("찾음");
			document.getElementById("t4T").innerHTML = sname;
			document.getElementById("t5T").innerHTML = sname;
		}else if( lecturetime.search("화6,화7,화8") != -1){
			console.log("찾음");
			document.getElementById("t6T").innerHTML = sname;
			document.getElementById("t7T").innerHTML = sname;
			document.getElementById("t8T").innerHTML = sname;
		}else if( lecturetime.search("수1,수2,수3") != -1){
			console.log("찾음");
			document.getElementById("t1W").innerHTML = sname;
			document.getElementById("t2W").innerHTML = sname;
			document.getElementById("t3W").innerHTML = sname;
		}else if( lecturetime.search("수4,수5") != -1){
			console.log("찾음");
			document.getElementById("t4W").innerHTML = sname;
			document.getElementById("t5W").innerHTML = sname;
		}else if( lecturetime.search("수6,수7,수8") != -1){
			console.log("찾음");
			document.getElementById("t6W").innerHTML = sname;
			document.getElementById("t7W").innerHTML = sname;
			document.getElementById("t8W").innerHTML = sname;
		}else if( lecturetime.search("목1,목2,목3") != -1){
			console.log("찾음");
			document.getElementById("t1Th").innerHTML = sname;
			document.getElementById("t2Th").innerHTML = sname;
			document.getElementById("t3Th").innerHTML = sname;
		}else if( lecturetime.search("목4,목5") != -1){
			console.log("찾음");
			document.getElementById("t4Th").innerHTML = sname;
			document.getElementById("t5Th").innerHTML = sname;
		}else if( lecturetime.search("목6,목7,목8") != -1){
			console.log("찾음");
			document.getElementById("t6Th").innerHTML = sname;
			document.getElementById("t7Th").innerHTML = sname;
			document.getElementById("t8Th").innerHTML = sname;
		}else if( lecturetime.search("금1,금2,금3") != -1){
			console.log("찾음");
			document.getElementById("t1F").innerHTML = sname;
			document.getElementById("t2F").innerHTML = sname;
			document.getElementById("t3F").innerHTML = sname;
		}else if( lecturetime.search("금4,금5") != -1){
			console.log("찾음");
			document.getElementById("t4F").innerHTML = sname;
			document.getElementById("t5F").innerHTML = sname;
		}else if( lecturetime.search("금6,금7,금8") != -1){
			console.log("찾음");
			document.getElementById("t6F").innerHTML = sname;
			document.getElementById("t7F").innerHTML = sname;
			document.getElementById("t8F").innerHTML = sname;
		}
		else{
			console.log("못찾음");
		}
	}
</script>
</head>
<body>
	<!-- header -->
	<%@ include file="/common/header.jsp"%>
	<!-- end of header -->
	
	<div class="container">
		<div class="page-header">
		  <h3>>수강신청 내역</h3>
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
			
			<table class="table table-bordered" id="registerList">
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
		          </tr>
		        </thead>
		        <tbody id="tbody">
		        	<c:forEach var="list" items="${list}" varStatus="vs">
		        		<tr>
		        			<td>${list.subjectnum}</td>
			        		<td id="subjectname${vs.index}">${list.subjectname}</td>
			        		<td>${list.curriculum}</td>
			        		<td>${list.course}</td>
			        		<td>${list.credit}</td>
			        		<td>${list.fixednum}</td>
			        		<td>${list.fixednum - list.extranum}</td>
			        		<td id="lecturetime${vs.index}">${list.lecturetime}</td>
			        		<td>${list.professor}</td>
			        		<td>${list.classroom}</td>
			        		<td>${list.etc}</td>
		        		</tr>
		        	</c:forEach>		        	
		        </tbody>
	      </table>
	      <div class="text-center">
				<ul class="pagination pagination-sm">
				<!--  
				${pagingHtml}
				-->
			</div>
			
			<p class="text-success">
				<strong>[수강신청표 보기]</strong>
				<button type="button" class="btn btn-default"  style="margin-left:50px;" onclick="showTimeTable()";>보기</button>
			</p>
			
		</form>
		<p></p>
		
		<table cellspacing="5" align="center" border="1" bordercolor="#5CD1E5" width="550" height="600" id="timetable">
			<p></p>
			<!-- style="display:none" -->
        	<caption>
	            <font size="5" face="굴림"><font color="#fece00">Ti</font>
	            <font color="#fe8c14">me </font>
	            <font color="#8cca2d">Ta</font>
	            <font color="#4daace">ble</font></font>
	        </caption>
        	<tr align="center">
	            <td width="50"></td>
	            <td width="100" bgcolor="#5CD1E5">월</td>
	            <td width="100" bgcolor="#5CD1E5">화</td>
	            <td width="100" bgcolor="#5CD1E5">수</td>
	            <td width="100" bgcolor="#5CD1E5">목</td>
	            <td width="100" bgcolor="#5CD1E5">금</td>
	        </tr>
	        
	        <tr align="center">
	        	<td bgcolor="#5CD1E5">1</td>
	            <td id="t1M"></td>
	            <td id="t1T"></td>
	            <td id="t1W"></td>
	            <td id="t1Th"></td>
	            <td id="t1F"></td>
	        </tr>
	        
	        <tr align="center">
	            <td bgcolor="#5CD1E5">2</td>
	            <td id="t2M"></td>
	            <td id="t2T"></td>
	            <td id="t2W"></td>
	            <td id="t2Th"></td>
	            <td id="t2F"></td>
	        </tr>
	        
	        <tr align="center">
	        	<td bgcolor="#5CD1E5">3</td>
	            <td id="t3M"></td>
	            <td id="t3T"></td>
	            <td id="t3W"></td>
	            <td id="t3Th"></td>
	            <td id="t3F"></td>
	        </tr>
	        
	        <tr align="center">
	        	<td bgcolor="#5CD1E5">4</td>
	        	<td id="t4M"></td>
	            <td id="t4T"></td>
	            <td id="t4W"></td>
	            <td id="t4Th"></td>
	            <td id="t4F"></td>
	        </tr>
 
	        <tr align="center">
	            <td bgcolor="#5CD1E5">5</td>
	            <td id="t5M"></td>
	            <td id="t5T"></td>
	            <td id="t5W"></td>
	            <td id="t5Th"></td>
	            <td id="t5F"></td>
	        </tr>
 
	        <tr align="center">
	            <td bgcolor="#5CD1E5">6</td>
	            <td id="t6M"></td>
	            <td id="t6T"></td>
	            <td id="t6W"></td>
	            <td id="t6Th"></td>
	            <td id="t6F"></td>
	        </tr>
	 
	        <tr align="center">
	            <td bgcolor="#5CD1E5">7</td>
	            <td id="t7M"></td>
	            <td id="t7T"></td>
	            <td id="t7W"></td>
	            <td id="t7Th"></td>
	            <td id="t7F"></td>
	        </tr>
	 
	        <tr align="center">
	            <td bgcolor="#5CD1E5">8</td>
	            <td id="t8M"></td>
	            <td id="t8T"></td>
	            <td id="t8W"></td>
	            <td id="t8Th"></td>
	            <td id="t8F"></td>
	        </tr>
	        <!--  
	        <c:forEach var="ta" items="${list}" varStatus="status">   	
	        </c:forEach> -->
		</table>
		<p></p><p></p><p></p><p></p>
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