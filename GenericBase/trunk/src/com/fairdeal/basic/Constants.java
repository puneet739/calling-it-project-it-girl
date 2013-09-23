package com.fairdeal.basic;

public class Constants {

	public enum EncryptionAlgo{
		SHAEncryption(1), Base64Encryption(2), plain(0);
	
		private int type;
		
		private EncryptionAlgo(int type){
			this.type=type;
		}
		
		public int getType(){
			return type;
		}
	
	}
	
	
}
