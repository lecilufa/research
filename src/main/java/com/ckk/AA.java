package com.ckk;

import static org.hamcrest.CoreMatchers.containsString;

import java.util.HashMap;

public class AA {
	
	public String name;

	public AA(String name) {
		super();
		this.name = name;
	}


	@Override
	public boolean equals(Object obj) {
		return this.name == ((AA)obj).name;
	}
	
	
	@Override
	public int hashCode() {
		
		return this.name.hashCode();
	}
	
	public static void main(String[] args) {
		
		HashMap<AA,String> map = new HashMap<>();
		
		AA a1 = new AA("1");
		AA a2 = new AA("1");
		
		map.put(a1, "a1");
		map.put(a2, "a2");
		
		String s = map.get(a1);
		
		System.out.println(s);
		System.out.println(a1.hashCode());
		
	}
}
