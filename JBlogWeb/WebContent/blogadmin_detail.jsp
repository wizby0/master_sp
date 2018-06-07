<%@page contentType="text/html; charset=EUC-KR" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JBlog 기본정보 관리</title>
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
		
		<table background="images/kubrickbg.jpg" width="760" height="300" border="0" cellpadding="0" cellspacing="0">
			<tr><td height="10" colspan="10">&nbsp;</td></tr>
			<tr>
				<td height="10" width="20">&nbsp;</td>
				<td width="530" valign="top">
					<!-- 메뉴 시작 --> 
					<b>기본설정</b>&nbsp;&nbsp;
					<a href="getCategoryList.do?blogId=${userId }"><b>카테고리</b></a>&nbsp;&nbsp;
					<a href="insertPostView.do?blogId=${userId }"><b>글작성</b></a>&nbsp;&nbsp; 
					<a	href="javascript:popup();"><b>블로그삭제</b></a>&nbsp;&nbsp;
					<!-- 메뉴 끝 -->
				</td>
			</tr>
			<tr><td height="5">&nbsp;</td></tr>
			<tr><td height="10">&nbsp;</td>
				<td>
					<!-- 작업 화면  시작 -->
					<form action="updateBlog.do" method="post">
					<input type="hidden" size="40" name="blogId" value="${userId }">
						<table width="720" border="0" cellpadding="1" cellspacing="1">
							<tr>
								<td width="150">블로그 제목 :</td>
								<td><input type="text" size="40" name="title" value="${blog.title }"></td>
							</tr>
							<tr>
								<td width="150">블로그 태그 :</td>
								<td><input type="text" size="50" name="tag" value="${blog.tag }"></td>
							</tr>
							<tr>
								<td width="150">로고이미지 :</td>
								<td><img height="80" src="images/j2eelogo.jpg" border="0"></td>
							</tr>
							<tr>
								<td width="150">&nbsp;</td>
								<td><input type="file" size="40" name="uploadFile" value="찾아보기" disabled="disabled"></td>
							</tr>
							<tr>
								<td height="40" colspan="10" align="center">
									<input type="submit" value="수정하기">
								</td>
							</tr>
						</table>
					</form> 
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