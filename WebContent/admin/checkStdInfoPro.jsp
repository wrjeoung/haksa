<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
if('${isStdInfoExist}'== "true") 
{	
	location.href="modifyStdInfo.do";
}
else
{
	alert("�Է��Ͻ� �й��� ���������ʽ��ϴ�.\n�ٽ� Ȯ���� �ּ���.");
	history.back();
}
</script>

