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
	
		<div class="page-header">
		  <h3>수강신청과목 추가</h3>
		</div>
		
		<div class="col-md-12 column">  
			<form class="form-inline" role="form" name="myform" action="adminRegisterAddPro.do" method="post">
				<table class="table table-bordered" style="font: normal 15px/150% Arial, Helvetica, sans-serif;">
			        <tr>
			          <td width="100" align="center" bgcolor="#F4F4F4">학수번호</td>
			          <td width="500" bgcolor="#FFFFFF">
			          	<input type="text" id="subjectnum" name="subjectnum" value="" style="width:100%" maxlength="50"/>
			          </td>
			        </tr>
		        	
		        	<tr>
			          <td width="100" align="center" bgcolor="#F4F4F4">과목명</td>
			          <td width="500" bgcolor="#FFFFFF">
			          	<input type="text" id="subjectname" name="subjectname" value="" style="width:100%" maxlength="50"/>
			          </td>
			        </tr>
			        
			        <tr>
			          <td width="100" align="center" bgcolor="#F4F4F4">교과과정</td>
			          <td width="500" bgcolor="#FFFFFF">
			          	<input type="text" id="curriculum" name="curriculum" value="" style="width:100%" maxlength="50"/>
			          </td>
			        </tr>
			        
			        <tr>
			          <td width="100" align="center" bgcolor="#F4F4F4">이수</td>
			          <td width="500" bgcolor="#FFFFFF">
			          	<input type="text" id="course" name="course" value="" style="width:100%" maxlength="50"/>
			          </td>
			        </tr>
			        
			        <tr>
			          <td width="100" align="center" bgcolor="#F4F4F4">학점</td>
			          <td width="500" bgcolor="#FFFFFF">
			          	<input type="text" id="credit" name="credit" value="" style="width:100%" maxlength="50"/>
			          </td>
			        </tr>
			        
			        <tr>
			          <td width="100" align="center" bgcolor="#F4F4F4">정원</td>
			          <td width="500" bgcolor="#FFFFFF">
			          	<input type="text" id="fixednum" name="fixednum" value="" style="width:100%" maxlength="50"/>
			          </td>
			        </tr>
			        
			        <tr>
			          <td width="100" align="center" bgcolor="#F4F4F4">강의시간</td>
			          <td width="500" bgcolor="#FFFFFF">
			          	<input type="text" id="lecturetime" name="lecturetime" value="" style="width:100%" maxlength="50"/>
			          </td>
			        </tr>
			        
			        <tr>
			          <td width="100" align="center" bgcolor="#F4F4F4">담당교수</td>
			          <td width="500" bgcolor="#FFFFFF">
			          	<input type="text" id="professor" name="professor" value="" style="width:100%" maxlength="50"/>
			          </td>
			        </tr>
			        
			        <tr>
			          <td width="100" align="center" bgcolor="#F4F4F4">강의실</td>
			          <td width="500" bgcolor="#FFFFFF">
			          	<input type="text" id="classroom" name="classroom" value="" style="width:100%" maxlength="50"/>
			          </td>
			        </tr>
			        
			        <tr>
			          <td width="100" align="center" bgcolor="#F4F4F4">비고</td>
			          <td width="500" bgcolor="#FFFFFF">
			          	<input type="text" id="etc" name="etc" value="" style="width:100%" maxlength="50"/>
			          </td>
			        </tr>
			        
			        <tr>
			          <td width="100" align="center" bgcolor="#F4F4F4">학과</td>
			          <td width="500" bgcolor="#FFFFFF">
			          	<input type="text" id="major" name="major" value="" style="width:100%" maxlength="50"/>
			          </td>
			        </tr>
			        
			        <tr>
			          <td width="100" align="center" bgcolor="#F4F4F4">학년</td>
			          <td width="500" bgcolor="#FFFFFF">
			          	<input type="text" id="grade" name="grade" value="" style="width:100%" maxlength="50"/>
			          </td>
			        </tr>
			        
			        <tr>
			          <td width="100" align="center" bgcolor="#F4F4F4">여분</td>
			          <td width="500" bgcolor="#FFFFFF">
			          	<input type="text" id="extranum" name="extranum" value="" style="width:100%" maxlength="50"/>
			          </td>
			        </tr>
				</table>
				
				<div align="center">
					<input type="submit" class="btn btn-primary" value="추가"/>
					<button type="button" class="btn btn-primary" onclick="javascript:location.href='adminRegisterMain.do'";>목록</button>
				</div>
		   	</form>
		</div>
	</div>
</div>		
  </body>
</html>

