<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	if('${selected}'==1) {
		if('${check}' ==  1 )
		{
			alert("고객님의 ID는 ["+'${id}'+"] 입니다.");
		}
		else
		{
			alert("입력하신 정보가 바르지 않습니다.\n확인 후 다시 시도해 주세요!");
		}
	}
	else if('${selected}'==2) {
		if('${check}' ==  1 )
		{
			alert("고객님께 메일이 발송 되었습니다.");
		}
		else if('${check}' ==  0 )
		{
			alert("회원님의 정보를 찾을 수 없습니다.");
		}
		else if('${check}' ==  -1 )
		{
			alert("죄송합니다.\n 메일 전송이 실패 하였습니다.");
		}
	}
	history.back();
</script>