package kr.co.javaproject.commonSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * MapUtil 
 * <p>Map 처리에 대한 Util</p>
 * @author www.javaproject.co.kr 
 * 소스의 자유로운 사용,변경,재 배포가 가능합니다.
 * 자바프로젝트사이트는 본 소스를 사용함에 있어 모든 결과물에 대한 책임은 지지 않습니다.
 * 소스에 대한 버그 사항은 사이트 게시판을 통해 남겨주세요.   
 */
public class MapUtils {
	
	/**
	 * mybatis 의 List<Map> 형태를 특정 컬럼 기준으로 Map<String ,List> 형테로 변환한다.
	 * <p>컬럼 기준으로 그룹핑 할때 할때 유용하게 쓰임. </p>
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
