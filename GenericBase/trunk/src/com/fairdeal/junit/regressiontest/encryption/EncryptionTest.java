package com.fairdeal.junit.regressiontest.encryption;


import static org.junit.Assert.*;
import org.junit.Test;

import com.fairdeal.basic.Constants;
import com.fairdeal.encryption.EncryptionFactory;

public class EncryptionTest {
	
	@Test
	public void basicTest()throws Exception{
		String testString = "123456";	
		String expectedOutput="8d969eef6ecad3c29a3a629280e686cfc3f5d5a86aff3ca122c923adc6c92";
		String encryptedString= EncryptionFactory.getinstance().getEncrypt(testString, Constants.EncryptionAlgo.SHAEncryption);
		assertEquals(expectedOutput, encryptedString);
	}

	@Test
	public void basicTest2()throws Exception{
		String testString = "123456";	
		String expectedOutput="123456";
		String encryptedString= EncryptionFactory.getinstance().getEncrypt(testString, Constants.EncryptionAlgo.plain);
		assertEquals(expectedOutput, encryptedString);
	}
	
}
