<%@page contentType="text/html; charset=EUC-KR" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JBlog ��α� ����</title>
</head>
<body background="images/kubrickbgcolor.jpg">
	<center>
		<table background="images/kubrickheader.jpg" width="760" height="200" border="0" cellpadding="0" cellspacing="0">
			<tr><td height="60">&nbsp;</td></tr>
			<!-- ��α� ����� �±� ���� -->
			<tr><td height="60" align="center"><h1><font color="white">${blog.title }</font></h1></td></tr>
			<tr><td height="20" align="center"><h3><font color="white">${blog.tag }</font></h3></td></tr>
			<!-- ��α� ����� �±� �� -->
			<tr align="right">
				<td>
					<c:if test="${userId == null }">
						<a href="login.jsp">�α���</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:if>
					<c:if test="${userId != null }">
						<c:if test="${blog.blogId != userId }">
							<a href="logout.do">�α׾ƿ�</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</c:if>
						<c:if test="${blog.blogId == userId }">
							<a href="logout.do">�α׾ƿ�</a>&nbsp;&nbsp;&nbsp;
							<a href="getBlog.do?blogId=${userId }">��α� ����</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</c:if>
					</c:if>
				</td>
			</tr>
		</table>

		<table background="images/kubrickbg.jpg" width="760" height="300" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top"><td height="10">&nbsp;</td></tr>
			<tr valign="top"><td width="20">&nbsp;</td>
				<td width="530">
				<!-- ����Ʈ ��� ���� --> 
				<c:forEach var="post" items="${postList }">
					<table height="10" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="420">
							<b><font color="red">${post.title }</font></b><br>
							${post.content }<br>
							<font color="green">${post.blogId }</font>���� �Խ��� �Խñ�[${post.createdDate }]
							</td>
							<td align="right">
							<a href="getPost.do?blogId=${userId }&postId=${post.postId }">EDIT</a> / <a href="deletePost.do?postId=${post.postId }">DEL</a>
							</td>
						</tr>
					</table><br>
				    <font color="#9DCFFF">---------------------------------------------------------------</font>
					<br> 
				</c:forEach>
				<!-- ����Ʈ ��� ��-->
				</td>
				<td width="20">&nbsp;</td>
				<td width="190" valign="top">
				<!-- �α���, ������ �޴�, �ΰ�, ī�װ� ���� -->
				<table cellpadding="0" cellspacing="0">
					<tr><td height="5">&nbsp;</td></tr>
					<tr><td><img height="80" src="images/j2eelogo.jpg" border="0"></td></tr>
					<tr><td height="5">&nbsp;</td></tr>
					<tr><td><b>ī�װ�</b></td></tr>
					<c:forEach var="category" items="${categoryList }">
					<tr>
						<td><a href="blogMain.do?categoryId=${category.categoryId }">${category.categoryName }</a></td>
					</tr>
					</c:forEach>
					<tr><td height="5">&nbsp;</td></tr>
					<tr><td align="center"><a href="index.jsp"><img width="80" src="images/logo.jpg" border="0"></a></td></tr>
				</table> 
				<!-- �α���, ������ �޴�, �ΰ�, ī�װ� �� -->
				</td>
			</tr>
		</table>

		<table background="images/kubrickfooter.jpg" width="760" height="63" border="0" cellpadding="0" cellspacing="0">
			<tr><td align="center">J2EE �̾߱� is powered by JBlog</td></tr>
		</table>
	</center>
</body>
</html>