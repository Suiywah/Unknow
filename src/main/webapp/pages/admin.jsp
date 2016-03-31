<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style type="text/css">
		body {
			width: 90%;
			margin: auto;
			font-family: "Trebuchet MS,Tahoma,Verdana,Arial,sans-serif";
		}
		
		ul {
			list-style: none;
		}
	</style>
<title>人员添加</title>
</head>
<body>
	<div class="user_register_form">
		<form action="admin/register" method="POST">
			<ul>
				<li><label for="people_name">姓名</label><input type="text" name="name" id="people_name" /></li>
				<li><label for="people_id">身份证号</label><input type="text" name="id" id="people_id" /></li>
				<li><label for="people_address">地址</label><input type="text" name="address" id="people_address" /></li>
				<li><label for="gender">性别</label><select name="gender" id="gender">
					<option value="男">男</option>
					<option value="女">女</option>
				</select></li>
				<li><label for="people_card_life_begin">身份证有效起始日期</label><input type="text" name="begin" id="people_card_life_begin"></li>
				<li><label for="people_card_life_end">身份证有效截至日期</label><input type="text" name="end" id="people_card_life_end"></li>
				<li><label for="born">出生日期</label><input type="text" name="born" id="born" /></li>
			</ul>
			<input type="submit" value="提交">
		</form>
	</div>
</body>
</html>