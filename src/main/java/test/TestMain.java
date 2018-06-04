package test;

public class TestMain {

	public static void main(String[] args) {
		
		//此例充分证明了 类在被用到时才会被加载
		//被用到的情况有
		//Obj obj = new Obj();  创建对象
		//Obj.say();			调用他的静态方法
		
//		Obj.say();
//		Obj.say();
//		
//		System.out.println(Obj.class);
		
		System.out.println(System.currentTimeMillis());
	}

}
