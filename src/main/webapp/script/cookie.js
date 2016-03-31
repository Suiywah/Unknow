/**
 * 设置和读取用户的Cookie
 */

function checkCookie(c_name) {
	if(document.cookie.length > 0) {
		var c_start = document.cookie.indexOf(c_name + "=");
		if(c_start == -1) {
			c_start = c_start + c_name.length + 1;
			var c_end = document.cookie.indexOf(";", c_start);
			if(c_end == -1) {
				c_end = document.cookie.length;
			}
			return unescape(document.cookie.substring(c_start, c_end));
		}
	}
	return "";
}

function setCookie(c_name, value, expireDays) {
	var exdate = new Date();
	exdate.setDate(exdate.getDate() + expireDays);
	document.cookie = c_name + "=" + escape(value) + (expireDays == null ? "" : "; expires=" + exdate.toGMTString());
}

function checkCookie() {
	var username = checkCookie('username')
}