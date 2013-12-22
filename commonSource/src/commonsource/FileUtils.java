package commonsource;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * FileUtils 
 * <p>File ó���� ���� Util</p>
 * @author www.javaproject.co.kr 
 * �ҽ��� �����ο� ���,����,�� ������ �����մϴ�.
 * �ڹ�������Ʈ����Ʈ�� �� �ҽ��� ����Կ� �־� ��� ������� ���� å���� ���� �ʽ��ϴ�.
 * �ҽ��� ���� ���� ������ ����Ʈ �Խ����� ���� �����ּ���.   
 */
public class FileUtils {
	/**
	 * ������ ���� �Ѵ� 
	 * <p>����  : FileUtils.copy(file ,target)</p>
	 * @param source
	 * @param target
	 * @return
	 */
	 @SuppressWarnings("finally")
	public static boolean copy(File source, String target) {
	        boolean copyAt = false;

	        BufferedInputStream bis = null;
	        BufferedOutputStream bos = null;
	        try {
	            bis = new BufferedInputStream(new FileInputStream(source));
	            bos = new BufferedOutputStream(new FileOutputStream(target));
	            int byteNumer;
	            try {
	                while ((byteNumer = bis.read()) != -1) {
	                    bos.write(byteNumer);
	                }
	                copyAt = true;
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                bis.close();
	                bos.flush();
	                bos.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            } finally {
	                return copyAt;
	            }
	        }
	    }
	 
	 /**
	  * ������ �����Ѵ�.
	  * <p>����  : FileUtils.copy(source ,target)</p>
	  * @param source
	  * @param target
	  * @return
	  */
	 public static boolean copy(String source, String target) {
	        File sourceFile = new File(source);
	        if (sourceFile.exists()) {
	            return FileUtils.copy(sourceFile, target);
	        } else {
	            return false;
	        }
	    }
	 
	 /**
	  * ������ ���� �Ѵ�.
	  * <p>����  : FileUtils.delete(fileFullPath)</p>
	  * @param fileNm
	  * @return
	  */
	 public static boolean delete(String fileNm) {
	        File file = new File(fileNm);
	        if (file.exists()) {
	            file.delete();
	            return true;
	        } else {
	            return false;
	        }
	    }
	 
	 /**
	  * ������ �̵��Ѵ�.
	  * @param source
	  * @param target
	  * @return
	  */
	  public static boolean move(String source, String target) {
	        File sourceFile = new File(source);

	        if (sourceFile.exists()) {
	            FileUtils.createDir(target);
	            if (FileUtils.copy(source, target)) {
	                sourceFile.delete();
	                return true;
	            } else {
	                return false;
	            }
	        } else {
	            return false;
	        }
	    }
	  
	  
	  /**
	   * �巺�丮�� �����Ѵ�. 
	   * 
	   * @param path
	   */
	  public static void createDir(File path) {
	        if (!path.exists()) {
	            path.mkdirs();
	        }
	  }
	  
	  /**
	   * 
	   * @param path
	   */
	  public static void createDir(String path) {
		  createDir(new File(path));
	  }	  	
}
