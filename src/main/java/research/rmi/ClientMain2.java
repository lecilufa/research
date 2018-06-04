package research.rmi;

import java.rmi.Naming;

//可以和浏览器请求网页做比较 是一样的道理
//调用p.getPerson()相当于发请求，  调用过程需要时间，有了响应之后 就能看到System.out.println(person)
//和BS模型一模一样
public class ClientMain2 {

	public static void main(String[] args) throws Exception {
		
		for(int i=0; i<5; i++){
			PersonService p =(PersonService)Naming.lookup("rmi://localhost:6600/PersonService");
			
			Person person = p.getPerson();
			
			System.out.println(person);
		}
	}

}
