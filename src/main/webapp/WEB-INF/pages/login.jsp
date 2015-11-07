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
<script type="text/javascript" src="<%=basePath %>/script/jquery-1.11.3.min.js"></script>
<title>用户登录</title>
	<style type="text/css">
		.ui-state-default, .ui-widget-content .ui-state-default, .ui-widget-header .ui-state-default {
			border: 1px solid #cccccc;
    		background: #f6f6f6 url("../image/ui-bg_glass_100_f6f6f6_1x400.png") 50% 50% repeat-x;
    		font-weight: bold;
    		color: #1c94c4;
		}
		.ui-state-error {
			border: 1px solid #cd0a0a;
			background: #b81900 url("../images/ui-bg_diagonals-thick_18_b81900_40x40.png") 50% 50% repeat;
			color: 0xffffff;
		}
		.ui-state-error .ui-icon {
		 	background-image: url("../images/ui-icons_ffd27a_256x240.png");
		}
</style>
    <script type="text/javascript">
    	function userNameValidate(userName) {
    		var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
    		var result = re.test(userName);
    		return result;
    	}
    
        $(document).ready(function(){
            $("#userName").blur(function() {
                var v = $(this).val();
                console.info(v);
                $.ajax({
                	url: "<%=basePath %>/login/prelogin",
                	data:{
                		"user": v 
                	},
                	dataType: "json",
                	type:"GET",
                	success: function(json) {
                		console.info(json.exist);
                		console.info("success");
                	},
                	error: function() { console.info("error")}	
                });
                });
        });
    
    </script>
</head>
<body>
	<div class="ui-state-error ui-corner-all" style="padding: 0.7em">
		<p>
			<span class="ui-icon ui-icon-alert" style="float:left; margin-right: .3em;"></span>
			<strong>警告：</strong>Sample
		</p>
	</div>
	<div id="login-form">
	    <form method="post">
	    	<table>
	    	<tr><td><label id="userNameText" for="userName">用户名</label></td><td><input type="text" name="userName" id="userName" /></td></tr>
	    	<tr><td><label for="password">密码</label></td><td><input type="password" name="password" id="password" /></td></tr>
	    	<tr><td colspan="2"><input type="button" value="登录" onclick="document.form.subimt()" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" /></td></tr>
	    	</table>
	    </form>
	    <p>This is test<p>
    </div>
</body>
</html>