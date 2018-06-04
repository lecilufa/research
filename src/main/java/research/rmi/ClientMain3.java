package research.rmi;

import java.rmi.Naming;

//模拟客户端多线程发请求
//可以看到服务器处理是多线程处理的
public class ClientMain3 {

	public static void main(String[] args) throws Exception {
		
		for(int i=0; i<5; i++){
			
			
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					try {
						PersonService p =(PersonService)Naming.lookup("rmi://localhost:6600/PersonService");
						
						Person person = p.getPerson();
						
						System.out.println(person);
						
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			});
			
			t.start();
		}
	}

}
