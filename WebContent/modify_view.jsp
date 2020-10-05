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
	<div>hello</div>
	<table width="500" border="1">
		<form action="modify.do" method="post">
			<input type="hidden" name="id" value="${content.id}" />
			<tr>
				<td>게시물 번호</td>
				<td>${content.id}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${content.readCount}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${content.name}" /></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${content.title}" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="content">${content.content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정완료" /> &nbsp; <a
					href="list.do">목록보기</a>&nbsp;<a
					href="delete.do?id=${content_view.id}">삭제</a>&nbsp;</td>
			</tr>
		</form>
	</table>
	
</body>
</html>