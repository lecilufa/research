package research.multiThread;

public class MyServiceImpl {

	
	/**
	 * 同步块的特点
	 * 
	 * @param obj	只有当传入的obj为同一个对象时 ,同步块才算是同步执行，否则异步执行
	 */
	public void block(Object obj){
		
		synchronized(obj){
			try {
				System.out.println("aa");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("bb");
	}
	
	
	
	/**
	 * 同步方法的特点
	 * 
	 * 只有被同一个service实例调用时才会算是同步方法,否则异步执行
	 * 被不同的service实例调用，不算同步
	 * 
	 * @param aa   同步方法已经 和传入参数没有任何挂钩， 唯一判定是否是同步执行的标准是 ：  此方法在多线程环境下被同一个service 实例调用
	 */
	public synchronized void method(Object aa){
		
		try {
			System.out.println("aa");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("bb");
	}
	
	
	
	/**
	 * 静态同步方法的特点
	 * 
	 * 只要调用这个方法就是同步，已经和具体用哪个对象无关了
	 */
	public static synchronized void staticMethod(){
		
		try {
			System.out.println("aa");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("bb");
	}
	
	
	
	
	
	
	
}
