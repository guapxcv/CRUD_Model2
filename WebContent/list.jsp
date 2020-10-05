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
	<table width="500" cellpadding = "0" cellspacing = "0" border = "1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>조회수</td>
			<td>날짜</td>
		</tr>
		<c:forEach items="${list}" var = "dto" varStatus="i">
		<tr>
			<td>${(i.index)+1}</td>
			<td>${dto.name}</td>
			<td><a href="content_view.do?id=${dto.id}&readCount=${dto.readCount}">${dto.title}</a></td>
			<td>${dto.readCount}</td>
			<td>${dto.date}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan = "5"><a href="write_view.do">글작성</a></td>
		</tr>
	</table>

</body>
</html>