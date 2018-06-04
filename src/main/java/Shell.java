

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Shell {

	public static void main(String[] args) throws Exception {
		String[] cmd = new String[]{"/bin/sh","-c","./aa.sh"};
		
		//String[] cmd = new String[]{"/bin/sh","-c","ps -aux"};
		
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
