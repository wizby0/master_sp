<%@page contentType="text/html; charset=EUC-KR" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>JBlog ī�װ� ����</title>
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
		
		<table background="images/kubrickbg.jpg" width="760" height="40" border="0" cellpadding="0" cellspacing="0">
			<tr><td height="10" colspan="10">&nbsp;</td></tr>
			<tr><td height="10" width="20">&nbsp;</td>
				<td width="530" valign="top">
					<!-- �޴� ���� --> 
					<a href="getBlog.do?blogId=${userId }"><b>�⺻����</b></a>&nbsp;&nbsp;
					<b>ī�װ�</b>&nbsp;&nbsp;
					<a href="insertPostView.do?blogId=${userId }"><b>���ۼ�</b></a>&nbsp;&nbsp; 
					<a href="javascript:popup();"><b>��α׻���</b></a>&nbsp;&nbsp;
					<!-- �޴� �� -->
				</td>
			</tr>
			<tr><td height="5">&nbsp;</td></tr>
			<tr><td height="10">&nbsp;</td><td>
				<!-- �۾� ȭ��  ���� -->
				<table width="720" border="0" cellpadding="1" cellspacing="1">
					<tr bgcolor="#9DCFFF">
						<th width="50"><font color="white">��ȣ</font></th>
						<th width="150"><font color="white">ī�װ���</font></th>
						<th width="100"><font color="white">���̱� ����</font></th>
						<th width="350"><font color="white">����</font></th>
						<th width="70"><font color="white">����</font></th>
					</tr>
					<c:forEach var="category" items="${categoryList }" varStatus="status">
					<tr>
						<td align="center">${status.count }</td>
						<td>${category.categoryName }</td>
						<td align="center">${category.displayType }</td>
						<td>${category.description }</td>
						<td align="center">&nbsp;<img height="9" src="images/delete.jpg" border="0"></td>
					</tr>
					</c:forEach>
					</table> 
					
					<c:if test="${categoryFlag == null }">		
					<form action="insertCategory.do" method="post">
					<input type="hidden" name="blogId" value="${userId }">
						<table width="720" border="0" cellpadding="1" cellspacing="1">
							<tr><td height="5">&nbsp;</td></tr>
							<tr><td height="5">&nbsp;</td></tr>
							<tr><td height="5"><b>���ο� ī�װ� �߰�</b></td>	</tr>
							<tr><td height="5">&nbsp;</td></tr>
							<tr>
								<td width="150">ī�װ��� :</td>
								<td><input type="text" size="40" name="categoryName"></td>
							</tr>
							<tr>
								<td width="150">���̱� ���� :</td>
								<td><input type="radio"	name="displayType" value="������" checked>������&nbsp;&nbsp;
									<input type="radio" name="displayType" value="�۳���">�۳���&nbsp;&nbsp;
								</td>
							</tr>
							<tr>
								<td width="150">���� :</td>
								<td><input type="text" size="50" name="description"></td>
							</tr>
							<tr>
								<td colspan="10" align="center"><br>&nbsp;<input type="submit" value="ī�װ� �߰�"></td>
							</tr>
						</table>
					</form> 
					</c:if> 
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