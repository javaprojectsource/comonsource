package kr.co.javaproject.commonSource;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/**
 * SecurityUtil 
 * <p>Map 처리에 대한 Util</p>
 * @author www.javaproject.co.kr 
 * 소스의 자유로운 사용,변경,재 배포가 가능합니다.
 * 자바프로젝트사이트는 본 소스를 사용함에 있어 모든 결과물에 대한 책임은 지지 않습니다.
 * 소스에 대한 버그 사항은 사이트 게시판을 통해 남겨주세요.   
 */
public class SecurityUtil {
		
	 private static Key key = null;
	  
	  static {
	   if(key == null) {
	    // Key 초기화
	   KeyGenerator keyGenerator;
	    try {
	     keyGenerator = KeyGenerator.getInstance("TripleDES");
	     keyGenerator.init(168);
	     key = keyGenerator.generateKey();
	    } catch (NoSuchAlgorithmException e) {
	     e.printStackTrace();
	    }
	   }
	  }
	  
	  /**
	   * 암호화을 한다.
	   * <p>  사용법 : SecurityUtil.encode("abc")</p> 
	   * @param inStr
	   * @return
	   */
	  public static String encode(String inStr) {
	   StringBuffer sb = null;
	   try {
	    Cipher cipher = Cipher.getInstance("TripleDES/ECB/PKCS5Padding");
	    cipher.init(Cipher.ENCRYPT_MODE, key);
	    byte[] plaintext = inStr.getBytes("UTF8");
	    byte[] ciphertext = cipher.doFinal(plaintext);
	    
	    sb = new StringBuffer(ciphertext.length * 2);
	    for(int i = 0; i < ciphertext.length; i++) {
	     String hex = "0" + Integer.toHexString(0xff & ciphertext[i]); 
	     sb.append(hex.substring(hex.length()-2));
	    }
	   }catch(Exception e) {
	    e.printStackTrace();
	   }
	   return sb.toString();
	  }
	  
	  /**
	   * 복호화를 한다
	   * <p>  사용법 : SecurityUtil.decode("safsdaf4ewgsdf")</p>
	   * @param inStr
	   * @return
	   */
	  public static String decode(String inStr) {
	   String text = null;
	   try {
	    byte[] b = new byte[inStr.length()/2];
	    Cipher cipher = Cipher.getInstance("TripleDES/ECB/PKCS5Padding");
	    cipher.init(Cipher.DECRYPT_MODE, key);
	    for(int i = 0; i < b.length; i++) {
	     b[i] = (byte)Integer.parseInt(inStr.substring(2*i, 2*i+2), 16);
	    }
	    byte[] decryptedText = cipher.doFinal(b);
	    text = new String(decryptedText,"UTF8");
	   }catch(Exception e) {
	    e.printStackTrace();
	   }
	   return text;
	  }
	
}
