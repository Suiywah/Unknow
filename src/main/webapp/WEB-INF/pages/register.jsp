<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script type="text/javascript" src="script/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(document).ready(
		function() {
			alert(a);
			$("#userName").blur(function() {alert(this.val())});
			
		}
		);
</script>
</head>
<body>
<div class="container login_container" id="container">
<form action="register/email" method="post">
	<label for="userName">用户名：</label><input type="text" name="userName" id="userName"/>
	<label for="email">邮箱</label><input type="text" name="email" id="email">
	<label for="password">用户密码：</label><input type="password" name="password" id="password">
	<input type="submit" value="提交">
</form>
</div>
</body>
</html>