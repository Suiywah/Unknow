<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title></title>
	</head>
	<body>
	<!-- status:<%=request.getAttribute("javax.servlet.error.status_code") %> -->
	错误原因:<%=request.getAttribute("javax.servlet.error.message") %>
	</body>
</html>	