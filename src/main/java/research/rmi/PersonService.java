package research.rmi;

import java.rmi.Remote;

//接口必须实现 Remote
public interface PersonService extends Remote {

	public Person getPerson() throws Exception;
}
