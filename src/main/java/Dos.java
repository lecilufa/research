

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dos {

	public static void main(String[] args) throws Exception {
		String[] cmd = new String[]{"cmd.exe","/C","mvn -f C:/nico/SVN/trunk/CDS_HR/pom.xml clean package"};
		
		//C:/Program Files (x86)/Google/Chrome/Application/chrome.exe
		
		Process process = Runtime.getRuntime().exec(cmd);
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
		String line = null;
		
		while((line = bf.readLine())!= null){
			System.out.println(line);
		}
		
		process.waitFor();
		
		process.getOutputStream().close();
	}
}
