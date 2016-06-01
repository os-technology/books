package org.chapter.databasic.thread;

public class JoinTest implements Runnable {

	public static int a = 0;

	public void run() {
		for (int k = 0; k < 5; k++) {
			a = a + 1;
		}
	}
private void runnableImpl(){
	 Thread t = new Thread(new RunnableImpl());  
     t.start();  
     try {  
         t.join(1000); 
         System.out.println("joinFinish");  
     } catch (InterruptedException e) {  
         e.printStackTrace();       
     }  
}
	public static void main(String[] args) throws Exception {
//		Runnable r = new JoinTest();
//		Thread t = new Thread(r);
//		t.start();
//		 t.join();
//		System.out.println(a);
		JoinTest t = new JoinTest();
		t.runnableImpl();
	}
}
