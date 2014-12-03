<%@ page contentType="text/html; charset=utf-8" %>

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
	
		<div id="dummy" style="height:100px;">
		</div>
		
		<div class="col-md-12 column">  
			<form class="form-inline" role="form" name="myform" action="noticeWritePro.do" method="post">
				<table class="table table-bordered" style="font: normal 15px/150% Arial, Helvetica, sans-serif;">
			        <tr>
			          <td width="100" align="center" bgcolor="#F4F4F4">제목</td>
			          <td width="500" bgcolor="#FFFFFF">
			          	<input type="text" id="subject" name="subject" value="" style="width:100%" maxlength="50"/>
			          </td>
			        </tr>
		        	     
			        <tr>
			          <td width="100" align="center" bgcolor="#F4F4F4">내용</td>
			          <td bgcolor="#FFFFFF">
						<div style="border: 1px solid #dedede; padding: 3px;">
						<textarea style="overflow:hidden;resize:none; border: 0; width: 100%; height:100px" name="content" cols="50" rows="10">${data.content }</textarea>
						</div>	          
			          </td>
			        </tr>
				</table>
				
				<div align="center">
					<input type="submit" class="btn btn-primary" value="추가"/>
					<button type="button" class="btn btn-primary" onclick="javascript:location.href='noticeList.do?currentPage=${currentPage}'";>목록</button>
				</div>
				
		   	</form>
		</div>
	</div>
</div>		
  </body>
</html>

