package research.multiThread;

public class TestMain {

	
	public static void main(String[] args) {
		
		
//		blockTest();
		
//		methodTest();
		
		staticMethod();
		
	}

	private static void staticMethod() {
				
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				
				MyServiceImpl.staticMethod();
			}
		});
		
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				
				MyServiceImpl.staticMethod();
			}
		});
		
		t1.start();
		t2.start();
		
	}

	private static void methodTest() {
		
		MyServiceImpl m1 = new MyServiceImpl();
		MyServiceImpl m2 = new MyServiceImpl();
		
		Object aa = new Object();
		Object bb = new Object();
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				
				m1.method(aa);
			}
		});
		
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				
				m1.method(bb);
//				m2.method();   //如果这里用另一个service的method方法，则不会算作同步
			}
		});
		
		t1.start();
		t2.start();
		
	}

	private static void blockTest() {
		
		MyServiceImpl myServiceImpl = new MyServiceImpl();
		
		Object aa = new Object();
		Object bb = new Object();
		
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				
				myServiceImpl.block(aa);
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				
				myServiceImpl.block(aa);
//				myServiceImpl.block(bb);    //传入不同的对象不会同步
			}
		});
		
		t1.start();
		t2.start();
		

		
	}
	
	
	
}
