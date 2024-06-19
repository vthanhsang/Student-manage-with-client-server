package Client;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EnCryption {
	public static String hashPassword(String password) {
	    String hashedPassword = null;
	    try {
	      MessageDigest md = MessageDigest.getInstance("SHA-256");
	      md.update(password.getBytes());
	      byte[] bytes = md.digest();
	      StringBuilder sb = new StringBuilder();
	      for (int i = 0; i < bytes.length; i++) {
	        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	      }
	      hashedPassword = sb.toString();
	    } catch (NoSuchAlgorithmException e) {
	      e.printStackTrace();
	    }
	    return hashedPassword;
	  }
}
