<%@page contentType="text/html; charset=EUC-KR" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>JBlog</title>
</head>
<body>
	<center>
		<form action="getBlogList.do" method="post">
			<table width="720" height=200 border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="100%" colspan="10" align="center"><img src="images/logo.jpg" border="0"></td>
				</tr>
				<tr>
					<td width="70%" colspan="2" align="center">
						<c:if test="${userId == null }">
							<a href="login.jsp"><b>�α���</b></a>&nbsp;&nbsp;
	      				</c:if> 
	      				<c:if test="${userId != null }">
							<c:if test="${blog == null }">
								<a href="blogcreate.jsp"><b>��α׵��</b></a>&nbsp;&nbsp;
		      				</c:if>
							<c:if test="${blog != null }">
								<a href="blogMain.do?blogId=${userId }"><b>�� ��α׷� ����</b></a>&nbsp;&nbsp;
							</c:if>
						</c:if>
						<input type="text" name="searchKeyword"	size="50">
						<input type="submit" value="�˻�">
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="radio" name="searchCondition" value="TITLE" checked="checked">��α� ����&nbsp;&nbsp;
						<input type="radio"	name="searchCondition" value="TAG">�±�&nbsp;&nbsp; 
						<input type="radio" name="searchCondition" value="BLOGGER">��ΰ�
					</td>
				</tr>
			</table>
		</form>
		<br><br><br>
		<c:if test="${!empty blogList }">
			<table width="600" border="0" cellpadding="1" cellspacing="1">
				<tr bgcolor="#9DCFFF">
					<th height="30"><font color="white">��α� ����</font></th>
					<th><font color="white">�±�</font></th>
					<th><font color="white">��ΰ�</font></th>					
					<c:if test="${userRole == 'Admin' }">
						<th width="100"><font color="white">����</font></th>
						<th width="100"><font color="white">����</font></th>
					</c:if>
				</tr>
				<c:forEach items="${blogList }" var="blog">
				<tr>
					<td align="left"><a href="blogMain.do?blogId=${blog.blogId }">${blog.title }</a></td>
					<td align="center">${blog.tag }</td>
					<td align="center">${blog.userName }</td>
					<c:if test="${userRole == 'Admin' }">
						<td align="center">${blog.status }</td>
						<c:if test="${blog.status == '������û' }">
							<td align="center"><a href="deleteBlog.do?blogId=${blog.blogId }"><img height="9" src="images/delete.jpg" border="0"></a></td>
						</c:if>
						<c:if test="${blog.status != '������û' }">
							<td align="center">&nbsp;</td>
						</c:if>
					</c:if>
				</tr>
				</c:forEach>
			</table>
		</c:if>

	</center>
</body>
</html>