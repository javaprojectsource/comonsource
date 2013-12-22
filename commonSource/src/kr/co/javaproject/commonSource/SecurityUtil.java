package kr.co.javaproject.commonSource;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/**
 * SecurityUtil 
 * <p>Map ó���� ���� Util</p>
 * @author www.javaproject.co.kr 
 * �ҽ��� �����ο� ���,����,�� ������ �����մϴ�.
 * �ڹ�������Ʈ����Ʈ�� �� �ҽ��� ����Կ� �־� ��� ������� ���� å���� ���� �ʽ��ϴ�.
 * �ҽ��� ���� ���� ������ ����Ʈ �Խ����� ���� �����ּ���.   
 */
public class SecurityUtil {
		
	 private static Key key = null;
	  
	  static {
	   if(key == null) {
	    // Key �ʱ�ȭ
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
	   * ��ȣȭ�� �Ѵ�.
	   * <p>  ���� : SecurityUtil.encode("abc")</p> 
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
	   * ��ȣȭ�� �Ѵ�
	   * <p>  ���� : SecurityUtil.decode("safsdaf4ewgsdf")</p>
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
