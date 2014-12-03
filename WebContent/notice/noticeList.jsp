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
					<c:forEach var="list" items="${list}">
						<c:url var="viewURL" value="noticeView.do">
							<c:param name="num" value="${list.num}" />
							<c:param name="currentPage" value="${currentPage}" />
						</c:url>
						
						<tr class="active" style="cursor:pointer;" onclick="javascript:location.href='${viewURL}'";>
						<td>
							<c:out value="${list.num}"/>
						</td>
						<td>${list.subject}</td>
						<td>
							<c:if test="${list.isToday eq true }">
								<fmt:formatDate value="${list.reg_date}" pattern="HH:mm"/>
							</c:if>
							<c:if test="${list.isToday eq false }">
								<fmt:formatDate value="${list.reg_date}" pattern="yyyy-MM-dd"/>
							</c:if>
						</td>
						<td>${list.readcount}</td>
			      	    </tr>			
					</c:forEach>
					
					<c:if test="${totalCount <= 0}">
						<tr class="warning">
							<td colspan="4">등록된 게시물이 없습니다.</td>
						</tr>						
					</c:if>						
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
	  			
	  			<div class="form-group" style="margin-left:50px;">
					<c:url var="viewURL" value="noticeWrite.do">
						<c:param name="currentPage" value="${currentPage}" />
					</c:url>
	  				<button type="button" class="btn btn-default" onclick="javascript:location.href='${viewURL}'";>글쓰기</button>
	  			</div>	  			
  			</div>	
  				
			<div class="text-center">
				<ul class="pagination pagination-sm">
				${pagingHtml}
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

