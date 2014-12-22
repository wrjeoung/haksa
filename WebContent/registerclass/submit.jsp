<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	if('${chkDupli}'=='false')
	{
		alert("수강신청을 하였습니다.");
		location.href="registerclass.do";
	}
	else
	{
		alert("동일한 과목으로 수강신청 할 수 없습니다.");
		history.back();
	}
</script>