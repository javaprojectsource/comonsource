package commonsource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * MapUtil 
 * <p>Map ó���� ���� Util</p>
 * @author www.javaproject.co.kr 
 * �ҽ��� �����ο� ���,����,�� ������ �����մϴ�.
 * �ڹ�������Ʈ����Ʈ�� �� �ҽ��� ����Կ� �־� ��� ������� ���� å���� ���� �ʽ��ϴ�.
 * �ҽ��� ���� ���� ������ ����Ʈ �Խ����� ���� �����ּ���.   
 */
public class MapUtils {
	
	/**
	 * mybatis �� List<Map> ���¸� Ư�� �÷� �������� Map<String ,List> ���׷� ��ȯ�Ѵ�.
	 * <p>�÷� �������� �׷��� �Ҷ� �Ҷ� �����ϰ� ����. </p>
	 * @param list
	 * @param key
	 * @return
	 */
	public static Map<String, List> mapToList(List<Map<String, Object>> list,String key){
		Map<String, List> contMap = new HashMap<String, List>();
		List<Map> t = new ArrayList<Map>();
		String temp = "";
		int i = 0;
		for(Map cont : list) {
			i++;
			if(temp.equals("") || !temp.equals((String)cont.get(key))) {				
				if(!temp.equals("")&& !temp.equals((String)cont.get(key))) {
					contMap.put(temp,t);					
					t = new ArrayList<Map>();	
					t.add(cont);
				}
				if(temp.equals("")) {
					t.add(cont);
				}
				temp = (String)cont.get(key);
			} else {
				t.add(cont);
			}			
			if(i==list.size()) {
				contMap.put(temp,t);
			}
		}
		
		return contMap;
	}
}
