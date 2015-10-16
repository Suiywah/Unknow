/**
 * 
 */
package com.myproject.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author feipt
 *
 */
public class TestEncryptUtils {
	
	public static String byteToHexString(byte[] src) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < src.length; i ++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if(hv.length() < 2) {
				sb.append(0);
			}
			sb.append(hv);
		}
		return sb.toString().toUpperCase();
	}
	
	public static String getMd5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			//32位加密
			return buf.toString();
			// 16位的加密
			//return buf.toString().substring(8, 24);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "311101c779ba86a3333b3fa8844b31dd08f46fe99df3de1abc8350e23b4531911123123";
		String result = EncryptUtils.shaEncode(str);
		System.out.println(result.length());
		System.out.println(result);
//		System.out.println(getMd5("abcd"));
	}

}
