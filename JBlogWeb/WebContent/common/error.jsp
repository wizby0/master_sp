<%@ page contentType="text/html; charset=euc-kr"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<title>Error</title>
</head>
<script language="javascript">
</script>
<body>
<!-- 타이틀 시작 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td bgcolor="red" width="93%">문제 발생!(기본 에러 화면)</td>
	</tr>
</table>
<!-- 타이틀 끝 -->
<table width="100%" border="0" cellspacing="5" cellpadding="5" align="center">
	<tr><td>Message:</td><td><br><br></td></tr>
	<tr>
		<td width="50">&nbsp;</td>
		<td width="400">${exception.message}</td>
		<td width="50">&nbsp;</td>
	</tr>
</table>
</body>
</html>

