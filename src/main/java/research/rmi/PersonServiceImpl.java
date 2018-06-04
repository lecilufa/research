package research.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//接口实现类 必须继承UnicastRemoteObject  并且必须有一个无参的构造函数
public class PersonServiceImpl  extends UnicastRemoteObject implements PersonService {

	//无参的构造函数
	protected PersonServiceImpl() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 9127060906143500L;

	@Override
	public Person getPerson() throws Exception {
		
		Person p = new Person();
		p.setAge(16);
		p.setId(0314);
		p.setName("Nico");
		
		System.out.println("调用");//能看到这句打印就说明 service是在服务器执行，不在客户端执行
		                          //这就和rest json 是一个道理了  客户端只是调用 程序是在服务器执行
		                          //rmi和rest json概念上都是远程调用  只是形式上不同罢了
		
		Thread.sleep(1000);  //RMI调用是多线程的
            
		
		return p;
	}

}
