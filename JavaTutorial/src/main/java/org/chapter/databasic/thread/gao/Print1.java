package org.chapter.databasic.thread.gao;

public class Print1 implements Runnable{
	private Data d;
	public Print1(Data d){
		this.d=d;
	}
	public void run() {
		while(!d.isEnd()){
			d.print1();
		}
		System.out.println("cq1");
	}
}