<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" +request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Page</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/themes/base/jquery.ui.all.css">
	<script type="text/javascript" src="<%=basePath %>/script/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>/script/util/util.js"></script>
	<script type="text/javascript" src="<%=basePath %>/script/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="<%=basePath %>/script/ui/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="<%=basePath %>/script/ui/jquery.ui.button.js"></script>
	<script type="text/javascript">
		function buttonInit() {
			$("button, a").button().click(function(event) {
				event.preventDefault();
			});
		}
		$(document).ready(function() {
			buttonInit();
		});
	</script>
</head>
<body>
<button>button</button>
<a href="#">Anchor</a>
</body>
</html>