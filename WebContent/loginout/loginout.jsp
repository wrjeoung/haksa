<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
var loginCheck='${loginCheck}';
var loginState='${loginState}';


// loginCheck = 1 - id, pass �α��� ���� ��ġ.
// loginState = 1 - ���� �α��� ����.
alert("loginState : "+loginState+" loginCheck : "+loginCheck);
if(loginCheck!=1 && loginState!=1)
{
	alert("���� �� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.\n�ٽ� Ȯ���� �ּ���.");
}
location.href="main.do";
</script>