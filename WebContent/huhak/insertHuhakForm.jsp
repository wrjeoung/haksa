<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>휴학신청</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

</head>
	
<script type="text/javascript">
	function hugr_check(){
		if(document.test.hugr.checked==true){
			document.test.hugrade.value="성적인정";
		}else{
			document.test.hugrade.value="성적불인정";
		}
	}
	/* function chk_del(){
		chk.action = "huhakDelete.do";
		//chk.location="huhakDelete.do?rnum=${vo.num}";
		chk.submit();
	} */
	function chk_del(){
	    var count = 0;
	    var rnum = document.getElementsByName('rnum');
	    for(i=0; i<rnum.length;i++){
	        if(rnum[i].checked) { count += 1; }
	    }
	    if(count==0){ alert("체크된 항목이 없습니다."); 
	    }else{
	    	chk.action = "huhakDelete.do";
			//chk.location="huhakDelete.do?rnum=${vo.num}";
			chk.submit();
	    }
	}
	
	/* function hugr_check2(){
		if(document.test2.rnum.checked==true){
			document.test2.rnum2.value="1";
		}else{
			document.test2.rnum2.value="0";
		}
	} */
	</script>
<body>
<%@ include file="/common/header.jsp"%>
<div class="container">
	<div class="page-header">
		<h3>>휴학신청</h3>
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
</form>
<p></p>
<p class="text-success"><strong>[휴학신청 List]</strong></p>
<form name="chk">
<table class="table table-bordered">
	<thead>
		<tr>
			<th class="text-center">신청년도</th>
			<th class="text-center">신청학기</th>
			<th class="text-center">휴학구분</th>
			<th class="text-center">성적</br/>인정구분</th>
			<th class="text-center">신청일자</th>
			<th class="text-center">복학<br/>예정년도</th>
			<th class="text-center">복학<br/>예정학기</th>
			<th class="text-center">처리<br/>구분</th>
			<th class="text-center">세부사정</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${list }">
		<c:if test="${vo.huchuri!='신청완료' }">
			<c:url var="viewURL" value="huhakView.do">
				<c:param name="num" value="${vo.num }"/>
			</c:url>
			</c:if>
			<tr>
				<td><fmt:formatDate value="${vo.huhak_reg_date }" pattern="yyyy"/>
								</td>
								<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.hubokhak }</td>
								<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.hugubun }</td>
								<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.hugrade }</td>
								<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>
								<fmt:formatDate value="${vo.huhak_reg_date }" pattern="yyyy-MM-dd"/>
								</td>
								<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.hubokyear }</td>
								<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.hubokhak }</td>
								<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.huchuri }</td>
								<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${vo.husegubun }</td>
								<c:if test="${vo.huchuri=='신청' }">
								<td><input type="checkbox" name="rnum" value="${vo.num}"></td>
								</c:if>
								<c:if test="${vo.huchuri=='신청완료' }">
								<td></td>
								</c:if>
			</tr>				
			<!-- <input type="text" name="rnum2" value="0"> -->
		</c:forEach>
	</tbody>
	
</table>
</form>
</div>
<!-- 신청하기 -->
<c:if test="${member.state!='휴학중' && member.state!='졸업' && member.state!='자퇴' }">
<form action="insertHuhakPro.do" method="post" enctype="multipart/form-data" onSubmit="" name="test">
	<table border="1" width="1100" cellspacing="0" cellpadding="0" align="center">
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">휴학구분</td><td width="520" align="left">&nbsp;<select name="hugubun"><option value="일반휴학">일반휴학</option></select></td>
			<td width="280" bgcolor="#BDBDBD">휴학<br/>세부구분</td><td width="520" align="left">&nbsp;<select name="husegubun"><option value="개인사정">개인사정</option></select></td>
		</tr>
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">복학<br/>예상년도</td><td width="520" align="left">&nbsp;<div><p><input type="text" name="hubokyear" size="20"/></p></div></td>
			<td width="280" bgcolor="#BDBDBD">복학<br/>예상학기</td>
			<td width="320" align="left">
				&nbsp;<select name="hubokhak"><option value="1학기">1학기</option><option value="2학기">2학기</option></select>
			</td>
		</tr>
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">성적<br/>인정여부</td><td width="520" align="left">&nbsp;<input type="checkbox" name="hugr" onclick="hugr_check();"></td>
			<td width="280" bgcolor="#BDBDBD">비상연락처</td><td width="520" align="left">&nbsp;<input type="text" name="hunumber" size="20"></td>
		</tr>
		<tr align="center">
			<td width="280" bgcolor="#BDBDBD">사유</td>
			<td width="520" align="left" colspan="4">&nbsp;<input type="text" name="husayu" size="115"></td>
		</tr>
	</table>
	<%-- <c:url var="deleteURL" value="huhakDelete.do">
		<c:param name="rnum" value="${num }"></c:param>
	</c:url> --%>
	<div align="center">
		
	<input type="hidden" name="name" value="${member.studentNumber }">
	<input type="submit" class="btn btn-default" value="신청">
	<button type="button" class="btn btn-default" onclick="chk_del()">취소</button>
	<input type="hidden" value="성적불인정" name="hugrade">
	</div>
</form>
</c:if>
</body>
<div class="demo-description">
	</div>
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
    <script src="dist/js/bootstrap.min.js"></script>
</html>