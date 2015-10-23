/**
 * 
 */
package com.myproject.utils;

/**
 * @author feipt
 *
 */
public class HexConver {
	private final static char[] mChars = "0123456789ABCDEF".toCharArray();
	
	public static String byte2HexStr(byte[] b) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < b.length; i ++) {
			System.out.println(i);
			sb.append(mChars[b[i] & 0xFF >> 4]);
//			sb.append(mChars[b[i] & 0xFF]);
		}
		return sb.toString().trim().toUpperCase();
	}
}
