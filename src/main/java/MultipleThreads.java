
public class MultipleThreads {

	
	public synchronized void aa(){
		
		try {
			System.out.println("aa");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		MultipleThreads m1 = new MultipleThreads();
		MultipleThreads m2 = new MultipleThreads();
		
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				
				m1.aa();
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				
				m2.aa();
			}
		});
		
		t1.start();
		t2.start();
		
	}
	
}
