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
	<form action="write.do" method="post">
		이름: <input type="text" name="name" required /><br />
		<br /> 제목: <input type="text" name="title" required /><br />
		<br /> 내용:
		<div>
			<textarea name="content" cols="30" rows="10" required></textarea>
			<br />
		</div>
		<input type="submit" value="제출" />&nbsp;<input type="reset"
			value="초기화">
	</form>

</body>
</html>