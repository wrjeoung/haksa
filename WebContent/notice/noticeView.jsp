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
			<div class="page-header">
			  <h3>공지사항</h3>
			</div>		
			
			<form class="form-inline" role="form">
				<table  class="table table-bordered" style="font: normal 15px/150% Arial, Helvetica, sans-serif;">
					<colgroup>
						<col width="90px" />
						<col width="245px" />
						<col width="90px" />
						<col width="245px" />
					</colgroup>
				
					<thead class="text-center">
						<tr>
						  <td scope="row" abbr="제목" bgcolor="#F4F4F4">  제목</td>
						  <td >
						    &nbsp;&nbsp;${notice.subject}
						  </td>
						  <td scope="row" bgcolor="#F4F4F4">  등록날짜</td>
						  <td scope="row">
						    &nbsp;&nbsp;<fmt:formatDate value="${notice.reg_date}" pattern="yyyy-MM-dd HH:mm"/>
						  </td>					  
						</tr>
					</thead>
					<tbody>					
						<tr style="height:100px;">
						  <td align="left" scope="row" colspan="4">
							<pre>${notice.content}</pre>
						</td>
						</tr >
					</tbody>
				</table>
				
				<c:url var="listURL" value="noticeList.do">
					<c:param name="currentPage" value="${currentPage}" />
					<c:if test="${param.searchType != null}">
						<c:param name="searchType" value="${param.searchType}" />
					</c:if>
					<c:if test="${param.searchWord != null}">
						<c:param name="searchWord" value="${param.searchWord}" />
					</c:if>						
				</c:url>	
				
				<c:url var="delteURL" value="noticeDelete.do">
					<c:param name="currentPage" value="${currentPage}" />
					<c:if test="${param.searchType != null}">
						<c:param name="searchType" value="${param.searchType}" />
					</c:if>
					<c:if test="${param.searchWord != null}">
						<c:param name="searchWord" value="${param.searchWord}" />
					</c:if>
					<c:if test="${param.num != null}">
						<c:param name="num" value="${param.num}" />
					</c:if>												
				</c:url>
				
				<c:url var="modifyURL" value="noticeModify.do">
					<c:param name="currentPage" value="${currentPage}" />
					<c:if test="${param.searchType != null}">
						<c:param name="searchType" value="${param.searchType}" />
					</c:if>
					<c:if test="${param.searchWord != null}">
						<c:param name="searchWord" value="${param.searchWord}" />
					</c:if>
					<c:if test="${param.num != null}">
						<c:param name="num" value="${param.num}" />
					</c:if>												
				</c:url>
				
				<c:url var="viewURL" value="noticeView.do">
					<c:param name="currentPage" value="${currentPage}" />
					<c:if test="${param.searchType != null}">
						<c:param name="searchType" value="${param.searchType}" />
					</c:if>
					<c:if test="${param.searchWord != null}">
						<c:param name="searchWord" value="${param.searchWord}" />
					</c:if>						
				</c:url>													
				
				<div align="left">
					<c:if test="${prevNum != null}">
						<button type="button" class="btn btn-default" onclick="javascript:location.href='${viewURL}&num=${prevNum}'";>이전글</button>
					</c:if>
					<c:if test="${nextNum != null}">
						<button type="button" class="btn btn-default" onclick="javascript:location.href='${viewURL}&num=${nextNum}'";>다음글</button>
					</c:if>
				</div>
				
				<div align="right">
  					<button type="button" class="btn btn-primary" onclick="javascript:location.href='${listURL}'";>목록</button>
  				<c:if test="${memId != null && memId eq admin}">
  					<button type="button" class="btn btn-primary" onclick="javascript:alert('삭제되었습니다.');javascript:location.href='${delteURL}'";>삭제</button>
  					<button type="button" class="btn btn-primary" onclick="javascript:location.href='${modifyURL}'";>수정</button>
  				</c:if>
				</div>
				
			</form>
			
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
    <script src="dist/js/bootstrap.min.js"></script>
   </body>
</html>

