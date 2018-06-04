package research.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerMain {

	public static void main(String[] args) throws Exception {
		
		
		PersonService p = new PersonServiceImpl();
		
		//注册通讯端口
		LocateRegistry.createRegistry(6600);
		//绑定接口到某个URL
		Naming.rebind("rmi://localhost:6600/PersonService", p);
	}
}
