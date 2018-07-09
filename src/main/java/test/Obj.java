package test;

public class Obj {

	static {
		System.out.println("this is obj");
	}
	
	public static void say(){
		
		System.out.println("saying");
		
	}
	
	public static void main(String[] args) {
		new Obj();
	}
}
