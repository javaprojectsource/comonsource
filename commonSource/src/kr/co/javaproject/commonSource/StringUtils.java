package kr.co.javaproject.commonSource;
/**
 * StringUtil 
 * String 처리에 대한 Util
 * @author www.javaproject.co.kr 
 * 소스의 자유로운 사용,변경,재 배포가 가능합니다.
 * 자바프로젝트사이트는 본 소스 사용함에 있어 모든 결과물에 대한 책임은 지지 않습니다.
 * 소스에 대한 버그 사항은 사이트 게시판을 통해 남겨주세요.   
 */
public class StringUtils {
	
	
	/**
	 *  Null 체트를 한다
	 *  사용법 : if(StringUtils.isNull(str)) { }
	 * @param val 널 체크를 할  값
	 * @return
	 */
	public static boolean isNull(String val){
		return (val==null);
	}
	
	/**
	 * String 값으로 변환한다.
	 * 사용법 : String s = StringUtils.stringValue(str);
	 * @param val String value로 변환 할 값
	 * @return
	 */
	public static String stringValue(String val) {
		return stringValue(val,"");
	}
	
	/**
	 * String 값으로 변환하고  null일 경우 String 값을 세팅 한다
	 * 사용법 : String s = StringUtils.stringValue(str,"abc");
	 * @param val
	 * @param val2
	 * @return
	 */
	public static String stringValue(String val,String val2){
		return  (val==null)?val2:val;
	}
	
	/**
	 * String 겂을 int 값으로 변환한다
	 * 사용법 : int a = StringUtils.intValue(str);
	 * @param val
	 * @return
	 */
	public static int intValue(String val){
		return intValue(val,0);
	}
	
	
	/**
	 * String 겂을 int 값으로 변환한다
	 * 사용법 : int a = StringUtils.intValue(str,5);
	 * @param val
	 * @return
	 */
	public static int intValue(String val,int val2){
		try{
			return Integer.parseInt(val);
		}catch(Exception e){
			return val2;
		}
	}		
}
