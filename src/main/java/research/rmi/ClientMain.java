package research.rmi;

import java.rmi.Naming;

public class ClientMain {

	public static void main(String[] args) throws Exception {
		
		//通过URL远程调用接口  注意接口的执行是在服务端 不在客户端  
		PersonService p =(PersonService)Naming.lookup("rmi://localhost:6600/PersonService");
		
		//客户端只能得到执行的结果， 看不到执行的过程  这和rest json同理
		Person person = p.getPerson();
		
		System.out.println(person);
	}

}
