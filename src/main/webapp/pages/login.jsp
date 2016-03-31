<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" +request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/themes/base/jquery.ui.all.css">
	<script type="text/javascript" src="<%=basePath %>/script/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>/script/util/util.js"></script>
	<script type="text/javascript" src="<%=basePath %>/script/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="<%=basePath %>/script/ui/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="<%=basePath %>/script/ui/jquery.ui.button.js"></script>
	<title>用户登录</title>
    <script type="text/javascript">
    	function loginCheck() {
    		$("#userName").blur(function() {
    			var v = $(this).val();
    			if (v != "") {
    				var valResult = mailAddrValidate(v);
    				console.log(valResult);
    			}
    		});
    	}
    	
    	function buttonInit() {
    		$("input[type=button], button").button().click(function(event) {
    			event.preventDefault();
    		});
    	};
    	
    	function checkSubmit() {
    		var username = $("#userName").val();
    		console.log("用户名：" + username);
    		if (username != undefined || username == null || username == "") {   			
    		}
    	}
    
        $(document).ready(function(){
        	//loginCheck();
        	buttonInit();
        });
    
    </script>
</head>
<body>
	<div style="padding: 0.7em">
		<p>
			<span style="float:left; margin-right: .3em;"></span>
			<strong>警告：</strong>Sample
		</p>
	</div>
	<div id="login-form">
	    <form method="post">
	    	<table>
	    	<tr><td><label id="userNameText" for="userName">用户名</label></td><td><input type="text" name="userName" id="userName" /></td></tr>
	    	<tr><td><label for="password">密码</label></td><td><input type="password" name="password" id="password" /></td></tr>
	    	<tr><td colspan="2"><input type="button" value="登录" onclick="checkSubmit()" /></td></tr>
	    	</table>
	    </form>
	    <p>This is test<p>
    </div>
</body>
</html>