package com.fairdeal.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAEncryption implements BaseEncryption{

	@Override
	public String doEncrypt(String baseString) {
		return encrypt(baseString);
	}
	
	/**
	 * This is the base program used to convert the plan text 
	 * to encrypted SHA based format.
	 * 
	 * @param plaintext		The String which needs to be encrypted
	 * @return				The SHA based Encrypted String. 
	 */
	private String encrypt(String plaintext) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256"); // step 2
			md.update(plaintext.getBytes("UTF-8")); // step 3
		} catch (Exception e) {

		}

		byte raw[] = md.digest(); // step 4
		StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<raw.length;i++) {
      	  hexString.append(Integer.toHexString(0xFF & raw[i]));
      	}

		return hexString.toString();
	}

}
