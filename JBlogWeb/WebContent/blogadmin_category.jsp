<%@page contentType="text/html; charset=EUC-KR" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>JBlog 카테고리 관리</title>
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
			<!-- 블로그 제목과 태그 시작 -->
			<tr><td height="60" align="center"><h1><font color="white">${blog.title }</font></h1></td></tr>
			<tr><td height="20" align="center"><h3><font color="white">${blog.tag }</font></h3></td></tr>
			<!-- 블로그 제목과 태그 끝 -->
			<tr><td align="right"><a href="logout.do">로그아웃</a>&nbsp;&nbsp;<a href="blogMain.do">블로그 메인</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
		</table>
		
		<table background="images/kubrickbg.jpg" width="760" height="40" border="0" cellpadding="0" cellspacing="0">
			<tr><td height="10" colspan="10">&nbsp;</td></tr>
			<tr><td height="10" width="20">&nbsp;</td>
				<td width="530" valign="top">
					<!-- 메뉴 시작 --> 
					<a href="getBlog.do?blogId=${userId }"><b>기본설정</b></a>&nbsp;&nbsp;
					<b>카테고리</b>&nbsp;&nbsp;
					<a href="insertPostView.do?blogId=${userId }"><b>글작성</b></a>&nbsp;&nbsp; 
					<a href="javascript:popup();"><b>블로그삭제</b></a>&nbsp;&nbsp;
					<!-- 메뉴 끝 -->
				</td>
			</tr>
			<tr><td height="5">&nbsp;</td></tr>
			<tr><td height="10">&nbsp;</td><td>
				<!-- 작업 화면  시작 -->
				<table width="720" border="0" cellpadding="1" cellspacing="1">
					<tr bgcolor="#9DCFFF">
						<th width="50"><font color="white">번호</font></th>
						<th width="150"><font color="white">카테고리명</font></th>
						<th width="100"><font color="white">보이기 유형</font></th>
						<th width="350"><font color="white">설명</font></th>
						<th width="70"><font color="white">삭제</font></th>
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
							<tr><td height="5"><b>새로운 카테고리 추가</b></td>	</tr>
							<tr><td height="5">&nbsp;</td></tr>
							<tr>
								<td width="150">카테고리명 :</td>
								<td><input type="text" size="40" name="categoryName"></td>
							</tr>
							<tr>
								<td width="150">보이기 유형 :</td>
								<td><input type="radio"	name="displayType" value="글제목" checked>글제목&nbsp;&nbsp;
									<input type="radio" name="displayType" value="글내용">글내용&nbsp;&nbsp;
								</td>
							</tr>
							<tr>
								<td width="150">설명 :</td>
								<td><input type="text" size="50" name="description"></td>
							</tr>
							<tr>
								<td colspan="10" align="center"><br>&nbsp;<input type="submit" value="카테고리 추가"></td>
							</tr>
						</table>
					</form> 
					</c:if> 
					<!-- 작업 화면  끝 -->
				</td>
			</tr>
			<tr><td height="10" colspan="10">&nbsp;</td></tr>
		</table>
		
		<table background="images/kubrickfooter.jpg" width="760" height="63" border="0" cellpadding="0" cellspacing="0">
			<tr><td align="center">J2EE 이야기 is powered by JBlog</td></tr>
		</table>		
	</center>
</body>
</html>