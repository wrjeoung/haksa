<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
var loginCheck='${loginCheck}';
var menuId='${menuId}';

// loginCheck = 1 �α��� ���� ��ġ
// menuId = null�� ��� �α׾ƿ� ����.

if(loginCheck!=1 && menuId==null)
{
	alert("��й�ȣ�� Ȯ���ϼ���.");
}
location.href="main.do";
</script>