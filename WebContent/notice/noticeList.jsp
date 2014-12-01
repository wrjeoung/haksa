<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>학사정보시스템</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
  
    
  <body>
	<!-- header -->
	<%@ include file="/common/header.jsp"%>
	<!-- end of header -->
	
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h1 class="text-center text-default">
				공지사항
			</h1>
		
			
			<form class="form-inline" role="form">
			
			<table class="table table-hover text-center">
				<thead>
					<tr>
						<th class="text-center">
							글번호
						</th>
						<th class="text-center">
							제목
						</th>
						<th class="text-center">
							등록일
						</th>
						<th class="text-center">
							조회수
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Default
						</td>
					</tr>
					<tr class="active">
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Approved
						</td>
					</tr>
					<tr class="success">
						<td>
							2
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							02/04/2012
						</td>
						<td>
							Declined
						</td>
					</tr>
					<tr class="warning">
						<td>
							3
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							03/04/2012
						</td>
						<td>
							Pending
						</td>
					</tr>
					<tr  class="danger">
						<td>
							4
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							04/04/2012
						</td>
						<td>
							Call in to confirm
						</td>
					</tr>
				</tbody>
			</table>
		
			<div class="text-center">
	  			<div class="form-group">
		    		<select class="form-control">
					  <option>제목</option>
					  <option>내용</option>
					</select>
	  			</div>		

	  			<div class="form-group" style="margin-left:20px; width:40%">
	  				<label class="sr-only" for="searchcondition">검색조건</label>
		    		<input type="text" class="form-control" id="searchcondition" placeholder="검색어">
	  			</div>
	  			<div class="form-group" style="margin-left:50px;">
	  				<button type="button" class="btn btn-default" onclick="javascript:location.href='main.do';">검색</button>
	  			</div>
  			</div>	
  				
			<div class="text-center">
				<ul class="pagination pagination-sm">
				<li class="disabled"><span>«</span></li>
				<li class="active">
					<a href="#">1</a>
				</li>
				<li>
					<a href="#">2</a>
				</li>
				<li>
					<a href="#">3</a>
				</li>
				<li>
					<a href="#">4</a>
				</li>
				<li>
					<a href="#">5</a>
				</li>
				<li><span>&raquo;</span></li>
				</ul>
			</div>
		</form>
		</div>
	</div>
</div>
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
    <script src="dist/js/bootstrap.min.js"></script>
   </body>
</html>

