package find.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

public class SHA256Util {

	public static String SHA256Encrypt(String password) throws Exception{
		System.out.println("들어옴");
		String retVal = "";
		  try {
		  	MessageDigest md = MessageDigest.getInstance("SHA-256");
		  	md.update(password.getBytes());

		  	byte byteData[] = md.digest();
		  	StringBuffer sb = new StringBuffer();
		    
		    for(int i=0; i<byteData.length; i++) {
		      sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
		    }

		    StringBuffer hexString = new StringBuffer();
		    for(int i=0; i<byteData.length;i++) {
		    String hex = Integer.toHexString(0xff & byteData[i]);
		    if(hex.length() == 1) {
		      hexString.append('0');
		    }
		      hexString.append(hex);
		    }

		  	retVal = hexString.toString();
		  } catch(NoSuchAlgorithmException e){
		  	System.out.println("EncBySHA256 Error:" + e.toString());
		  }
		  return retVal;
	}

}
