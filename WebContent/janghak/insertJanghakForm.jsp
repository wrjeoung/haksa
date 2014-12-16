<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>장학금신청</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<script type="text/javascript">
	function chk_del(){
		chk.action="janghakDelete.do";
		chk.submit();
	}
</script>
<body>
<%@ include file="/common/header.jsp"%>
<div class="container">
	<div class="page-header">
		<h3>>장학금신청</h3>
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
<p class="text-success"><strong>[장학금신청 List]</strong></p>
<form name="chk">
<table class="table table-bordered">
	<thead>
		<tr>
			<th>은행</th>
			<th>계좌번호</th>
			<th>예금주</th>
			<th>장학구분</th>
			<th>신청일자</th>
			<th>처리구분</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="list" items="${list }">
			<c:url var="viewURL" value="janghakView.do">
				<c:param name="num" value="${list.num }"/>
			</c:url>
			<tr>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.janghakbank }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.janghakbanknum }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.janghakname }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.janghakmenu }</td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";><fmt:formatDate value="${list.janghak_reg_date }" pattern="yyyy-MM-dd HH:mm"/></td>
				<td style="cursor: pointer;" onclick="javascript:location.href='${viewURL}'";>${list.janghakchuri }</td>
				<%-- <td><input type="checkbox" name="rnum" value="${list.num }"></td> --%>
				

				<c:if test="${list.janghakchuri=='신청' }">
				<td><input type="checkbox" name="rnum" value="${list.num}"></td>
				</c:if>
				<c:if test="${list.janghakchuri=='신청완료' }">
				<td></td>
				</c:if>
				
			</tr>
		
		</c:forEach>
	</tbody>
</table>
</form>
</div>

<form action="insertJanghakPro.do" method="post" enctype="multipart/form-data" onsubmit="" name="">
	<table border="1" width="1100" cellspacing="0" cellpadding="0" align="center">
		<tr align="center">
			<td width="75" bgcolor="#BDBDBD">계좌정보</td>
			<td width="105" bgcolor="#BDBDBD">은행</td>
			<td width="80" align="left">
			&nbsp;<select name="janghakbank">
			<option value="농협">농협</option>
			<option value="KB국민은행">KB국민은행</option>
			<option value="우리은행">우리은행</option>
			<option value="신한은행">신한은행</option>
			<option value="하나은행">하나은행</option>
			<option value="외환은행">외환은행</option></select>
			</td>
			<td width="80" bgcolor="#BDBDBD">계좌번호</td>
			<td width="80" align="left">&nbsp;<input type="text" name="janghakbanknum" size="40"></td>
			<td width="80" bgcolor="#BDBDBD">예금주</td>
			<td width="80" align="left">&nbsp;<input type="text" name="janghakname" size="20" value="${member.name}"/></td>
		</tr>
	</table>
	<br/>
	
	<table border="1" width="1100" cellspacing="0" cellpadding="0" align="center">
		<tr>
			<td width="100" bgcolor="#BDBDBD" rowspan="48" align="center">
				신청
			</td>
			<td width="140" bgcolor="#BDBDBD" rowspan="6" align="center">
				가계곤란<br/>장학신청
			</td>
			<td width="40" bgcolor="#BDBDBD" rowspan="2">
				<input type="radio" name="janghakmenu" value="기초생활수급자">기초생활수급자
				<td width="10" bgcolor="#BDBDBD">
					안내사항
					<td width="280">
						이건뭐지?
					</td>
				</td>
				<tr>
					<td width="10" bgcolor="#BDBDBD">
					제출서류
						<td>3.기초생활수급자 증명서 또는 차상위증명서 1부<br/>
						*상기 증명서가 학생 본의 명의가 아닌 직계가족 명의일 경우 가족관계증명 서류 첨부</td>
					</td>
				</tr>
				<tr>
					<td width="30" bgcolor="#BDBDBD" rowspan="2">
					<input type="radio" name="janghakmenu" value="차상위계층자">차상위계층자
					<td width="10" bgcolor="#BDBDBD">
						안내사항
						<td width="280">
						
						</td>
					</td>
						<tr>
							<td width="10" bgcolor="#BDBDBD">
								제출서류
								<td></td>
							</td>
						</tr>
					</td>
				</tr>
				<tr>
					<td width="40" bgcolor="#BDBDBD" rowspan="2">
					<input type="radio" name="janghakmenu" value="일반가계곤란">일반가계곤란
					<td width="30" bgcolor="#BDBDBD">
						안내사항
						<td width="280">
						
						</td>
					</td>
						<tr>
							<td width="30" bgcolor="#BDBDBD">
								제출서류
								<td></td>
							</td>
						</tr>
					</td>
				</tr>
			</td>

			<td width="140" bgcolor="#BDBDBD" align="center" rowspan="3">
				성적우등<br/>장학신청
			</td>

			<td width="40" bgcolor="#BDBDBD" align="left" rowspan="2">
				<input type="radio" name="janghakmenu" value="성적우등">성적우등<br/>&nbsp;&nbsp;&nbsp;장학신청
			</td>
			
			<td width="30" bgcolor="#BDBDBD">
				안내사항
				<td></td>
			</td>
			<tr>
				<td width="30" bgcolor="#BDBDBD">
					제출서류
					<td></td>
				</td>
			</tr>
			<tr>
				<td colspan="4">(가계 소득 관련 증빙 서류 제출을 원하지 않을 경우 선택)<br/>
				<font color="blue">※선발 결과에 따라 가게곤란 장학과 성적우등 장학 중 본인에게 유리한 장학 선택하게 됨</font></td>
			</tr>
			<td width="140" bgcolor="#BDBDBD" align="center">
				자기<br/>소개
			</td>
			<td colspan="3" width="120" height="100">
			※가정환경,경제적여건,등록금 조달 과정,졸업 후 모교,사회 및 국가발전 기여계획 등(2000자 내외)<br/>
			&nbsp;&nbsp;<textarea rows="5" cols="145" name="janghakmy">입력해주세요</textarea>
			</td>
		</tr>
	</table>
	<div align="center">
	<input type="hidden" value="${member.studentNumber }" name="name"/>
	<input type="submit" class="btn btn-default" value="신청">
	<button type="button" class="btn btn-default" onclick="chk_del()">삭제</button>
	</div>
</form>
</body>
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
<script src="//code.jquery.com/jquery.js"></script>
<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
<script src="dist/js/bootstrap.min.js"></script>
</html>