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
    
<style type="text/css">
#table-6 {
	width: 100%
	border: 1px solid #B0B0B0;
}
#table-6 tbody {
/* Kind of irrelevant unless your .css is alreadt doing something else */
	margin: 0;
	padding: 0;
	border: 0;
	outline: 0;
	font-size: 100%;
	vertical-align: baseline;
	background: transparent;
}
#table-6 thead {
	text-align: left;
}
#table-6 thead th {
	background: -moz-linear-gradient(top, #F0F0F0 0, #DBDBDB 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #F0F0F0), color-stop(100%, #DBDBDB));
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#F0F0F0', endColorstr='#DBDBDB', GradientType=0);
	border: 1px solid #B0B0B0;
	color: #444;
	font-size: 16px;
	font-weight: bold;
	padding: 3px 10px;
}
#table-6 td {
	padding: 3px 10px;
}
#table-6 tr:nth-child(even) {
	background: #F2F2F2;
}
</style>    

<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
<script src="//code.jquery.com/jquery.js"></script>
<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
<script src="dist/js/bootstrap.min.js"></script>
    
<script type="text/javascript">
	$(document).ready(function () {
	    $("[id$='searchWord']").keypress(function () { // enterkey 처리
	        if (event.keyCode == 13) {
	            $("[id$='btnSearch']").click();
	            return false;
	        }
	    });
	
	    $("[id$='btnSearch']").click(function () {
	        return true;
	    });

	});
	
   	function search() {
   		var searchWord = document.getElementById("searchWord");
   		var searchType = document.getElementById("searchType");
   		
   		document.location.href = "noticeList.do?searchType="+searchType.options.selectedIndex+"&searchWord="+searchWord.value;
   	}
</script>  

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
				
				<table id="table-6" class="table text-center">
					<colgroup>
						<col width="7%" />
						<col width="40%" />
						<col width="15%" />
						<col width="7%" />
					</colgroup>
									
					<thead>
						<tr >
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
								<c:if test="${searchType != null}">
									<c:param name="searchType" value="${searchType}" />
								</c:if>
								<c:if test="${searchWord != null}">
									<c:param name="searchWord" value="${searchWord}" />
								</c:if>								
							</c:url>
							
							<tr style="cursor:pointer;" onclick="javascript:location.href='${viewURL}'";>
							<td>
								<c:out value="${list.rnum}"/>
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
			    		<select id="searchType" class="form-control">
							<c:if test="${searchType == 0 || searchType == null}">		
								<option SELECTED>제목</option>
								<option>내용</option>
							</c:if>
							<c:if test="${searchType == 1}">		
								<option>제목</option>
								<option SELECTED>내용</option>
							</c:if>														
						</select>
		  			</div>		
	
		  			<div class="form-group" style="margin-left:20px; width:40%">
		  				<label class="sr-only" for="searchWord">검색조건</label>
			    		<input type="text" class="form-control" name="searchWord" id="searchWord" placeholder="검색어" value="${searchWord}">
		  			</div>
		  			<div class="form-group" style="margin-left:50px;">
		  				<button type="button" class="btn btn-default" id="btnSearch" onclick="search()">검색</button>
		  				<button type="button" class="btn btn-default" onclick="javascript:location.href='noticeList.do'">전체보기</button>
		  			</div>
		  			
		  			<div class="form-group" style="margin-left:50px;">
						<c:url var="viewURL" value="noticeWrite.do">
							<c:param name="currentPage" value="${currentPage}" />
							<c:if test="${searchType != null}">
								<c:param name="searchType" value="${searchType}" />
							</c:if>
							<c:if test="${searchWord != null}">
								<c:param name="searchWord" value="${searchWord}" />
							</c:if>
						</c:url>
					<c:if test="${memId != null && memId eq admin}">
		  				<button type="button" class="btn btn-default" onclick="javascript:location.href='${viewURL}'";>글쓰기</button>
		  			</c:if>
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
</body>
</html>

