package research.redis;

import java.io.Serializable;

public class MyBean implements Serializable{

	private static final long serialVersionUID = 2055764086525015348L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
