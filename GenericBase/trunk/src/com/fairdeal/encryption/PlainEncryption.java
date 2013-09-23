package com.fairdeal.encryption;

public class PlainEncryption implements BaseEncryption {

	@Override
	public String doEncrypt(String baseString) {
		return baseString;
	}

}
