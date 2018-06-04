package research.xml;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Abc {

	private int id;
	
	private String name;
	
	private String pwd;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	@Override
	public String toString() {
		return "Abc [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
