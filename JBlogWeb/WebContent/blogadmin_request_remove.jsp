<%@page contentType="text/html;charset=euc-kr" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>JBlog ��α� ������û</title>
	<script type="text/javascript">
		function goMain() {
			opener.location.href = './index.jsp';
			window.close();
		}
	</script>
</head>
<body>
	<center>
		<form method="post" action="requestBlogDelete.do">
			<input type="hidden" name="blogId" value="${userId }"></input>
			<table width="450" height="100" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="50" rowspan="3" align="center"><img src="images/worning.jpg" border="0"></td>
					<td width="350"><b><font color="red">��α� ������ �����ڿ��� ��û�Ͻðڽ��ϱ� ?</font></b><br></td>
				</tr>
				<tr>
					<td width="350"><br><br>
					�����Ͻø� ������ Ȯ���� ���� ó�� �˴ϴ�. <br>�׸��� ��α� ���� ��� �����ʹ� <font color="red">����</font>�˴ϴ�.</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<br>
						<input type="submit" value="����" onclick="goMain();" />
						<input type="button" value="���" onclick="window.close();" />
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>


