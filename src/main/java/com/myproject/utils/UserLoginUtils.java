/**
 * 
 */
package com.myproject.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author feipt
 *
 */
public class UserLoginUtils {

	/**
	 * 获取请求设备的IP地址
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ipAddr = request.getHeader("x-forwarded-for");
		if(ipAddr == null  || ipAddr.length() == 0 || "unknow".equalsIgnoreCase(ipAddr)) {
			ipAddr = request.getHeader("Proxy-Client-IP");
		}
		if(ipAddr == null  || ipAddr.length() == 0 || "unknow".equalsIgnoreCase(ipAddr)) {
			ipAddr = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ipAddr == null  || ipAddr.length() == 0 || "unknow".equalsIgnoreCase(ipAddr)) {
			ipAddr = request.getRemoteAddr();
			if(ipAddr.equals("127.0.0.1") || ipAddr.equals("0:0:0:0:0:0:0:1")) {
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddr = inet.getHostAddress();
			}
		}
		//对于多个代理的情况，第一个IP为客户端真实IP，多个IP按照‘,’分割
		if(ipAddr != null && ipAddr.length() > 15) {
			if(ipAddr.indexOf(",") > 0) {
				ipAddr = ipAddr.substring(0, ipAddr.indexOf(","));
			}
		}
		return ipAddr;
	}
}
