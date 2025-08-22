// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

import java.util.Base64;

public class a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		/*
		 * String s, key; s = "hs"; key = "MIHN";
		 * 
		 * StringBuilder sb = new StringBuilder(); for(int i = 0; i < s.length(); i++)
		 * sb.append((char)(s.charAt(i) ^ key.charAt(i % key.length()))); String result
		 * = sb.toString(); System.out.println(result);
		 */
		System.out.println(xorEncrypt("ABCDEFG123456789", "H1Z"));
		System.out.println(xorDecrypt("CXMLdQ13DwB6AnwEfgZwCA==", "H1Z"));
		
		
		// Replace this with your encoded key.
		String base64EncodedPublicKey = "ABCDEFG123456789abcdefg";
		System.out.println(swap(base64EncodedPublicKey));
	}
	
	public static String xorEncrypt(String input, String key) {
	    byte[] inputBytes = input.getBytes();
	    int inputSize = inputBytes.length;

	    byte[] keyBytes = key.getBytes();
	    int keySize = keyBytes.length - 1;

	    byte[] outBytes = new byte[inputSize];
	    for (int i=0; i<inputSize; i++) {
	        outBytes[i] = (byte) (inputBytes[i] ^ keyBytes[i % keySize]);
	    }

	    return new String(Base64.getEncoder().encode(outBytes));
	}

	public static String xorDecrypt(String input, String key) {
	    byte[] inputBytes = Base64.getDecoder().decode(input);
	    int inputSize = inputBytes.length;

	    byte[] keyBytes = key.getBytes();
	    int keySize = keyBytes.length - 1;

	    byte[] outBytes = new byte[inputSize];
	    for (int i=0; i<inputSize; i++) {
	        outBytes[i] = (byte) (inputBytes[i] ^ keyBytes[i % keySize]);
	    }

	    return new String(outBytes);
	}
	
	//-----------------------------------------------------------------------------
	
	public static String swap(String input) {
		// Get byte sequence to play with.
		byte[] bytes = input.getBytes();
		// Swap upper and lower case letters.
		for (int i = 0; i < bytes.length; i++) {
		    if(bytes[i] >= 'A' && bytes[i] <= 'Z')
		        bytes[i] = (byte)( 'a' + (bytes[i] - 'A'));
		    else if(bytes[i] >= 'a' && bytes[i] <= 'z')
		        bytes[i] = (byte)( 'A' + (bytes[i] - 'a'));
		}
		// Assign back to string.
		return new String(bytes);
	}
}
