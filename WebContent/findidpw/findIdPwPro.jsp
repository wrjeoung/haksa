<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	if('${selected}'==1) {
		if('${check}' ==  1 )
		{
			alert("������ ID�� ["+'${id}'+"] �Դϴ�.");
		}
		else
		{
			alert("�Է��Ͻ� ������ �ٸ��� �ʽ��ϴ�.\nȮ�� �� �ٽ� �õ��� �ּ���!");
		}
	}
	else if('${selected}'==2) {
		if('${check}' ==  1 )
		{
			alert("���Բ� ������ �߼� �Ǿ����ϴ�.");
		}
		else if('${check}' ==  0 )
		{
			alert("ȸ������ ������ ã�� �� �����ϴ�.");
		}
		else if('${check}' ==  -1 )
		{
			alert("�˼��մϴ�.\n ���� ������ ���� �Ͽ����ϴ�.");
		}
	}
	history.back();
</script>