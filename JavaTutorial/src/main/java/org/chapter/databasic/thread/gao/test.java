package org.chapter.databasic.thread.gao;

public class test {
	public static void main(String[] args) {
		Data d = new Data();
		new Thread(new Print1(d)).start();
//		new Thread(new Print1(d)).start();
//		new Thread(new Print1(d)).start();
		new Thread(new Print2(d)).start();
//		new Thread(new Print2(d)).start();
		// new Thread(new Print2(d)).start();
		// new Thread(new Print1(d)).start();
		// new Thread(new Print1(d)).start();
		// new Thread(new Print1(d)).start();
		// new Thread(new Print2(d)).start();
		// new Thread(new Print2(d)).start();
		// new Thread(new Print2(d)).start();
	}
}
