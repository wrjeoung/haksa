<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="insertJanghakForm.do" method="post" enctype="multipart/form-data" onsubmit="" name="">
	<table border="1" width="1100" cellspacing="0" cellpadding="0" align="center">
		<tr align="center">
			<td width="75" bgcolor="#BDBDBD">��������</td>
			<td width="105" bgcolor="#BDBDBD">����</td>
			<td width="80" align="left">
			&nbsp;<select name="">
			<option>����</option>
			<option>KB��������</option>
			<option>�츮����</option>
			<option>��������</option>
			<option>�ϳ�����</option>
			<option>��ȯ����</option></select>
			</td>
			<td width="80" bgcolor="#BDBDBD">���¹�ȣ</td>
			<td width="80" align="left">&nbsp;<input type="text" name="" size="40"></td>
			<td width="80" bgcolor="#BDBDBD">������</td>
			<td width="80" align="left">&nbsp;<input type="text" name="" size="20"></td>
		</tr>
	</table>
	<br/>
	
	<table border="1" width="1100" cellspacing="0" cellpadding="0" align="center">
		<tr>
			<td width="30" bgcolor="#BDBDBD" rowspan="48" align="center">
				��û
			</td>
			<td width="80" bgcolor="#BDBDBD" rowspan="6" align="center">
				������<br/>���н�û
			</td>
			<td width="100" bgcolor="#BDBDBD" rowspan="2">
				<input type="radio" name="">���ʻ�Ȱ������
				<td width="60" bgcolor="#BDBDBD">
					�ȳ�����
					<td width="280">
						�̰ǹ���?
					</td>
				</td>
				<tr>
					<td width="60" bgcolor="#BDBDBD">
					���⼭��
						<td>3.���ʻ�Ȱ������ ���� �Ǵ� ���������� 1��<br/>
						*��� ������ �л� ���� ���ǰ� �ƴ� ���谡�� ������ ��� ������������ ���� ÷��</td>
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="#BDBDBD" rowspan="2">
					<input type="radio" name="">������������
					<td width="60" bgcolor="#BDBDBD">
						�ȳ�����
						<td width="280">
						
						</td>
					</td>
						<tr>
							<td width="60" bgcolor="#BDBDBD">
								���⼭��
								<td></td>
							</td>
						</tr>
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="#BDBDBD" rowspan="2">
					<input type="radio" name="">�Ϲݰ�����
					<td width="60" bgcolor="#BDBDBD">
						�ȳ�����
						<td width="280">
						
						</td>
					</td>
						<tr>
							<td width="60" bgcolor="#BDBDBD">
								���⼭��
								<td></td>
							</td>
						</tr>
					</td>
				</tr>
			</td>

			<td width="80" bgcolor="#BDBDBD" align="center" rowspan="3">
				�������<br/>���н�û
			</td>

			<td width="100" bgcolor="#BDBDBD" align="left" rowspan="2">
				<input type="checkbox" name="">�������<br/>&nbsp;&nbsp;&nbsp;���н�û
			</td>
			
			<td width="60" bgcolor="#BDBDBD">
				�ȳ�����
				<td></td>
			</td>
			<tr>
				<td width="60" bgcolor="#BDBDBD">
					���⼭��
					<td></td>
				</td>
			</tr>
			<tr>
				<td colspan="4">(���� �ҵ� ���� ���� ���� ������ ������ ���� ��� ����)<br/>
				<font color="blue">�ؼ��� ����� ���� ���԰�� ���а� ������� ���� �� ���ο��� ������ ���� �����ϰ� ��</font></td>
			</tr>
			<td width="80" bgcolor="#BDBDBD" align="center">
				�ڱ�<br/>�Ұ�
			</td>
			<td colspan="3" width="120" height="100">
			�ذ���ȯ��,����������,��ϱ� ���� ����,���� �� ��,��ȸ �� �������� �⿩��ȹ ��(2000�� ����)<br/>
			&nbsp;<textarea rows="5" cols="145"></textarea>
			</td>
		</tr>
	</table>
	<input style="margin-left: 700px" type="submit" value="��û">
</form>
</body>
</html>