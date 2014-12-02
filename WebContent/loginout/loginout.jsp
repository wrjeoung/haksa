<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
var loginCheck='${loginCheck}';
var loginState='${loginState}';
var memId ='${memId}';

//alert("loginState : "+loginState+" loginCheck : "+loginCheck+" memId : "+memId);
// loginCheck = 1 - id, pass 로그인 정보 일치.
// loginState = 1 - 현재 로그인 상태.
if(loginCheck!=1 && loginState!=1)
{
	alert("계정 및 비밀번호가 일치하지 않습니다.\n다시 확인해 주세요.");
}
location.href="main.do";
</script>