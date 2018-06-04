package com.ckk;

import java.util.HashMap;
import java.util.Map;

public class Redis分页 {

	public static void main(String[] args) {
		
		Map<Integer,String> map = new HashMap<>();
		
		map.put(1, "m1");
		map.put(2, "m2");
		map.put(3, "m3");
		map.put(4, "m4");
		map.put(5, "m5");
		map.put(6, "m6");
		map.put(7, "m7");
		map.put(8, "m8");
		map.put(9, "m9");
		

		//模拟分页算法
		int page = 1;
		
		int pageCount = 6;
		
		int statPos = (page -1)* pageCount + 1;
		int endPos = page * pageCount;
		
		if(endPos > map.size()){
			endPos = map.size();
		}
		
		for(int i=statPos; i<=endPos;i++){
			
			String val = map.get(i);			
			System.out.println(val);
		}
		
		
	}
}
