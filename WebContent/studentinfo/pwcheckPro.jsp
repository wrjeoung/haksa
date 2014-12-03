<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
var isConfirmPw='${isConfirmPw}';
console.log("pwcheckPro isconfirmpw : "+isConfirmPw);
if(isConfirmPw == 'true')
{
	location.href="pwModify.do";
}
else
{
	alert("비밀번호가 맞지 않습니다!!");
	history.back();
}
</script>
