<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<body>
	<%@ include file="/common/header.jsp"%>
	<div class="container">
		<div class="col-md-12 column">
			<div class="page-header">
				<h3>>장학금신청</h3>
			</div>
			
			<form class="form-inline" role="form">
				<table class="table table-bordered" style="font: normal 15px/150% Arial,Helvetica, sans-serif;">
					<colgroup>
						<col width="90px"/>
						<col width="245px"/>
						<col width="90px"/>
						<col width="245px"/>
						<col width="90px"/>
						<col width="245"/>
					</colgroup>
					<thead class="text-center">
						<tr>
							<td scope="row" addr="은행" bgcolor="#F4F4F4">은행</td>
							<td>
							${janghak.janghakbank }
							</td>
							<td scope="row" bgcolor="#F4F4F4">계좌번호</td>
							<td>${janghak.janghakbanknum }</td>
							<td scope="row" bgcolor="#F4F4F4">예금주</td>
							<td>${janghak.janghakname }</td>
						</tr>
						<tr>
							<td scope="row" bgcolor="#F4F4F4">장학구분</td>
							<td>${janghak.janghakmenu }</td>
							<td scope="row" bgcolor="#F4F4F4">신청일자</td>
							<td scope="row" colspan="3">
							<fmt:formatDate value="${janghak.janghak_reg_date }" pattern="yyyy-MM-dd HH:mm"/>
							</td>
						</tr>
					</thead>
					<tbody>
						<tr style="height: 100px;">
							<td scope="row" colspan="7">
								${janghak.janghakmy }
							</td>
						</tr>
					</tbody>
				</table>
				<button type="button" class="btn btn-primary" onclick="javascript:location.href='adminjanghakinfomodify.do?num=${janghak.num }'";>수정</button>
			</form>
		</div>
	</div>
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
    <script src="dist/js/bootstrap.min.js"></script>
    </body>
</body>
</html>