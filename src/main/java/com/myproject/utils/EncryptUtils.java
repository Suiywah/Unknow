/**
 * 
 */
package com.myproject.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

/**
 * @author feipt
 *
 */
public class EncryptUtils {
	private static Logger log = Logger.getLogger(EncryptUtils.class);
	
	private static String toHex(byte[] digest) {
		int i;
		StringBuffer buf = new StringBuffer("");
		for (int offset = 0; offset < digest.length; offset++) {
			i = digest[offset];
			if (i < 0)
				i += 256;
			if (i < 16)
				buf.append("0");
			buf.append(Integer.toHexString(i));
		}
		return buf.toString();
	}
	
	public static String shaEncode(String str) {
		if(str == null || str.isEmpty()) {
			log.warn("encrypt object is null or empty.");
			return null;
		}
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			log.error("Get MessageDigest instance occur an error", e);
			e.printStackTrace();
		}
		byte[] inByte = str.getBytes();
//		md.reset();
//		md.update(inByte);
		byte[] b = md.digest(inByte);
//		return TestEncryptUtils.byteToHexString(b);
		return toHex(b);
	}
}
