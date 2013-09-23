package com.fairdeal.encryption;

import java.io.Console;

import com.fairdeal.basic.Constants;


public enum EncryptionFactory {
	mInstance;
	
	public static EncryptionFactory getinstance(){
		return mInstance;
	}

	/**
	 * This is the base function used to fetch the encryptedString. 
	 * @param baseString		The String which need to be encrypted. 
	 * @param encryptionType	The Encryption type you need to use
	 * @return					The final Encrypted String. 
	 */
	public String getEncrypt(String baseString, Constants.EncryptionAlgo algo){
		
		BaseEncryption encryptionMode = null;
		
		encryptionMode = getEncryptionAlgo(algo);
		String encryptedString = encryptionMode.doEncrypt(baseString);
		
		return encryptedString;
	}
	
	/**
	 * This will decide which encryption algo needs to be used here. 
	 * @param encryptionType
	 * @return
	 */
	public BaseEncryption getEncryptionAlgo(Constants.EncryptionAlgo algo){
		
		if (algo == Constants.EncryptionAlgo.SHAEncryption) {
			return new SHAEncryption();
		} else{
			if (algo == Constants.EncryptionAlgo.Base64Encryption) {
				return new Base64Encryption();
			} 
		}
		return new PlainEncryption();
	}

}
