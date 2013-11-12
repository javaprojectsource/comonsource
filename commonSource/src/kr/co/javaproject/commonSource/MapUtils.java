package kr.co.javaproject.commonSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtils {
	public static Map mapToList(List<Map<String, Object>> list,String key){
		Map contMap = new HashMap();
		List t = new ArrayList();
		String temp = "";
		int i = 0;
		for(Map cont : list) {
			i++;
			if(temp.equals("") || !temp.equals((String)cont.get(key))) {				
				if(!temp.equals("")&& !temp.equals((String)cont.get(key))) {
					contMap.put(temp,t);					
					t = new ArrayList();	
					t.add(cont);
				}
				if(temp.equals("")) {
					t.add(cont);
				}
				temp = (String)cont.get("SCHEDULE_ID");
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
