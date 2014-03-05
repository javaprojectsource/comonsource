package commonsource;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileUtils
 * <p>File 처리에 대한 Util</p>
 * @author www.javaproject.co.kr 소스의 자유로운 사용,변경,재 배포가 가능합니다. 자바프로젝트사이트는 본 소스를
 *         사용함에 있어 모든 결과물에 대한 책임은 지지 않습니다. 소스에 대한 버그 사항은 사이트 게시판을 통해 남겨주세요.
 */
public class FileUtils {
	/**
	 * 파일을 복사 한다
	 * <p>
	 * 사용법 : FileUtils.copy(file ,target)
	 * </p>
	 * 
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
	 * 파일을 복사한다.
	 * <p>
	 * 사용법 : FileUtils.copy(source ,target)
	 * </p>
	 * 
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
	 * 파일을 삭제 한다.
	 * <p>
	 * 사용법 : FileUtils.delete(fileFullPath)
	 * </p>
	 * 
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
	 * 파일을 이동한다.
	 * 
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
	 * 디렉토리를 생성한다.
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
	
	/**
	 * 파일의 확장자를 체크하여 필터링된 확장자를 포함한 파일인 경우에 예외를 발생한다.
	 * @param file
	 * */
	public void badFileExtIsReturnException(File file) {
		String fileName = file.getName();
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1,
				fileName.length());
		final String[] BAD_EXTENSION = { "jsp", "php", "asp", "html", "perl" };

		try {
			int len = BAD_EXTENSION.length;
			for (int i = 0; i < len; i++) {
				if (ext.equalsIgnoreCase(BAD_EXTENSION[i])) {
					// 불량 확장자가 존재할떄 IOExepction 발생
					throw new IOException("BAD EXTENSION FILE UPLOAD");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 파일의 확장자를 체크하여 필터링된 확장자를 포함한 파일인 경우에 true를 리턴한다.
	 * @param file
	 * */
	public boolean badFileExtIsReturnBoolean(File file) {
		String fileName = file.getName();
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1,
				fileName.length());
		final String[] BAD_EXTENSION = { "jsp", "php", "asp", "html", "perl" };

		int len = BAD_EXTENSION.length;
		for (int i = 0; i < len; i++) {
			if (ext.equalsIgnoreCase(BAD_EXTENSION[i])) {
				return true; // 불량 확장자가 존재할때..
			}
		}
		return false;
	}
	
	
}




