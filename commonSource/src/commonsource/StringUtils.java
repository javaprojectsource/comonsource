package commonsource;
/**
 * StringUtil 
 * <p>String ó���� ���� Util</p>
 * @author www.javaproject.co.kr 
 * �ҽ��� �����ο� ���,����,�� ������ �����մϴ�.
 * �ڹ�������Ʈ����Ʈ�� �� �ҽ��� ����Կ� �־� ��� ������� ���� å���� ���� �ʽ��ϴ�.
 * �ҽ��� ���� ���� ������ ����Ʈ �Խ����� ���� �����ּ���.   
 */
public class StringUtils {
	
	
	/**
	 *  Null üƮ�� �Ѵ�
	 * <p>  ���� : if(StringUtils.isNull(str)) { }</p>
	 * @param val �� üũ�� ��  ��
	 * @return
	 */
	public static boolean isNull(String val){
		return (val==null);
	}
	
	/**
	 * String ������ ��ȯ�Ѵ�.
	 * <p>���� : String s = StringUtils.stringValue(str);</p>
	 * @param val String value�� ��ȯ �� ��
	 * @return
	 */
	public static String stringValue(String val) {
		return stringValue(val,"");
	}
	
	/**
	 * String ������ ��ȯ�ϰ�  null�� ��� String ���� ���� �Ѵ�
	 * <p>���� : String s = StringUtils.stringValue(str,"abc");</p>
	 * @param val
	 * @param val2
	 * @return
	 */
	public static String stringValue(String val,String val2){
		return  (val==null)?val2:val;
	}
	
	/**
	 * String ���� int ������ ��ȯ�Ѵ�
	 *  <p>���� : int a = StringUtils.intValue(str);</p>
	 * @param val
	 * @return
	 */
	public static int intValue(String val){
		return intValue(val,0);
	}
	
	
	/**
	 * String ���� int ������ ��ȯ�Ѵ�
	 * <p>���� : int a = StringUtils.intValue(str,5);</p>
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
