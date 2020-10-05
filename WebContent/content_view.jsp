<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="500" border="1">
		<input type="hidden" name="id" value="${content_view.id}" />
		<tr>
			<td>게시물번호</td>
			<td>${content_view.id}</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${content_view.readCount}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${content_view.name}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${content_view.title}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${content_view.content}</td>
		</tr>
		<tr>
			<td colspan="2"><a href="modify_view.do?id=${content_view.id}">수정하기</a> &nbsp; <a
				href="list.do">목록보기</a>&nbsp; <a
				href="delete.do?id=${content_view.id}">삭제</a> &nbsp;</td>
		</tr>
	</table>

</body>
</html>