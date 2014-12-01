<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
var loginCheck='${loginCheck}';
var menuId='${menuId}';

// loginCheck = 1 로그인 정보 일치
// menuId = null인 경우 로그아웃 상태.

if(loginCheck!=1 && menuId==null)
{
	alert("비밀번호를 확인하세요.");
}
location.href="main.do";
</script>