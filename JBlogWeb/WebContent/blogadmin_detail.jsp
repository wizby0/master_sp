<%@page contentType="text/html; charset=EUC-KR" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JBlog �⺻���� ����</title>
<script type="text/javascript">
	function popup() {
		window.open('./blogadmin_request_remove.jsp', 'popup1',
					'width=500, height=200, location=no, status=no, menubar=no, scrollbars=no, resizale=no, left=350, top=150');
	}
</script>
</head>
<body background="images/kubrickbgcolor.jpg">
	<center>
		<table background="images/kubrickheader.jpg" width="760" height="200" border="0" cellpadding="0" cellspacing="0">
			<tr><td height="60">&nbsp;</td></tr>
			<!-- ��α� ����� �±� ���� -->
			<tr><td height="60" align="center"><h1><font color="white">${blog.title }</font></h1></td></tr>
			<tr><td height="20" align="center"><h3><font color="white">${blog.tag }</font></h3></td></tr>
			<!-- ��α� ����� �±� �� -->
			<tr><td align="right"><a href="logout.do">�α׾ƿ�</a>&nbsp;&nbsp;<a href="blogMain.do">��α� ����</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
		</table>
		
		<table background="images/kubrickbg.jpg" width="760" height="300" border="0" cellpadding="0" cellspacing="0">
			<tr><td height="10" colspan="10">&nbsp;</td></tr>
			<tr>
				<td height="10" width="20">&nbsp;</td>
				<td width="530" valign="top">
					<!-- �޴� ���� --> 
					<b>�⺻����</b>&nbsp;&nbsp;
					<a href="getCategoryList.do?blogId=${userId }"><b>ī�װ�</b></a>&nbsp;&nbsp;
					<a href="insertPostView.do?blogId=${userId }"><b>���ۼ�</b></a>&nbsp;&nbsp; 
					<a	href="javascript:popup();"><b>��α׻���</b></a>&nbsp;&nbsp;
					<!-- �޴� �� -->
				</td>
			</tr>
			<tr><td height="5">&nbsp;</td></tr>
			<tr><td height="10">&nbsp;</td>
				<td>
					<!-- �۾� ȭ��  ���� -->
					<form action="updateBlog.do" method="post">
					<input type="hidden" size="40" name="blogId" value="${userId }">
						<table width="720" border="0" cellpadding="1" cellspacing="1">
							<tr>
								<td width="150">��α� ���� :</td>
								<td><input type="text" size="40" name="title" value="${blog.title }"></td>
							</tr>
							<tr>
								<td width="150">��α� �±� :</td>
								<td><input type="text" size="50" name="tag" value="${blog.tag }"></td>
							</tr>
							<tr>
								<td width="150">�ΰ��̹��� :</td>
								<td><img height="80" src="images/j2eelogo.jpg" border="0"></td>
							</tr>
							<tr>
								<td width="150">&nbsp;</td>
								<td><input type="file" size="40" name="uploadFile" value="ã�ƺ���" disabled="disabled"></td>
							</tr>
							<tr>
								<td height="40" colspan="10" align="center">
									<input type="submit" value="�����ϱ�">
								</td>
							</tr>
						</table>
					</form> 
					<!-- �۾� ȭ��  �� -->
				</td>
			</tr>
			<tr><td height="10" colspan="10">&nbsp;</td></tr>
		</table>
		<table background="images/kubrickfooter.jpg" width="760" height="63" border="0" cellpadding="0" cellspacing="0">
			<tr><td align="center">J2EE �̾߱� is powered by JBlog</td></tr>
		</table>
	</center>
</body>
</html>