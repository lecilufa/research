package com.ckk;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

public class Ab {
	
	
	

	public String getMe(){
			
		return "依赖包";
	}
	
	public static void main(String[] args) throws Exception {
		
		Properties pro = new Properties();
		pro.load(Ab.class.getResourceAsStream("/log4j.properties"));
		
		//System.out.println(Ab.class.getResource("/").getPath());
		
		
		//pro.store(new FileOutputStream(new File(Ab.class.getResource("/").getPath() + "abc.properties" )), "");
		
		System.out.println("************ 运行自己的java文件 *****************");
		
		System.out.println("************************************************************** " + pro.getProperty("log4j.rootLogger"));
		
	}
}
