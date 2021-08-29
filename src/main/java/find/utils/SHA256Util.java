package find.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

import org.springframework.stereotype.Component;

public class SHA256Util {
	
	public static String getSalt() {
		Random random = new Random();     
	    byte[] salt = new byte[10];

	    random.nextBytes(salt);     

	    StringBuffer sb = new StringBuffer();

	    for(int i=0; i<salt.length; i++) {
	     	sb.append(String.format("%02x", salt[i]));
	    }     

	    return sb.toString();
	}

	public static String SHA256Encrypt(String password, String salt) throws Exception{
		System.out.println("들어옴");
		
//		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
//		byte[] bytes = new byte[16];
//		random.nextBytes(bytes);
//		String salt = new String(Base64.getEncoder().encode(bytes));
//
//		MessageDigest md = MessageDigest.getInstance("SHA-256");
//		md.update(salt.getBytes());
//		md.update(password.getBytes());
//		String hex = String.format("%064x", new BigInteger(1, md.digest()));
//		
//		return hex;
	
		String result = "";
	    byte[] bytes = (password+salt).getBytes();

	    try {
	    	MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(bytes);

	        byte[] b = md.digest();
	  
	        StringBuffer sb = new StringBuffer();

	        for(int i=0; i<b.length; i++) {
	        	sb.append(Integer.toString((b[i] & 0xFF) + 256, 16).substring(1));
	        }
	        result = sb.toString();
	     } catch (Exception e) {
	    	 System.out.println("EncBySHA256 Error:" + e.toString());
	     }
	    return result;
		
// 원래 방법
//		String retVal = "";
//		  try {
//		  	MessageDigest md = MessageDigest.getInstance("SHA-256");
//		  	md.update(password.getBytes());
//
//		  	byte byteData[] = md.digest();
//		  	StringBuffer sb = new StringBuffer();
//		    
//		    for(int i=0; i<byteData.length; i++) {
//		      sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
//		    }
//
//		    StringBuffer hexString = new StringBuffer();
//		    for(int i=0; i<byteData.length;i++) {
//		    String hex = Integer.toHexString(0xff & byteData[i]);
//		    if(hex.length() == 1) {
//		      hexString.append('0');
//		    }
//		      hexString.append(hex);
//		    }
//
//		  	retVal = hexString.toString();
//		  } catch(NoSuchAlgorithmException e){
//		  	System.out.println("EncBySHA256 Error:" + e.toString());
//		  }
//		  return retVal;
	}

}
