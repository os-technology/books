package org.chapter.databasic.thread.gao;

public class Data {
	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	private static int m = 0;
	private volatile boolean end = false;
	private final String[] alp = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
			"R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

	public int getM() {
		return m;
	}

	public int getN() {
		return n;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String[] getAlp() {
		return alp;
	}

	private static int n = 0;
	private boolean flag = true;

	public synchronized void print1() {
		while (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		while (flag && !end) {
			m++;
			System.out.println("threaA...." + m);
			if (m % 2 == 0) {
				flag = false;
				notifyAll();
			}

		}
		if (end) {
			flag = false;
			notifyAll();
		}

	}

	public synchronized void print2() {
		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (n < alp.length) {
			System.out.println("threaB...." + alp[n]);
			n++;
			flag = true;
			notifyAll();
		} else {
			end = true;
			flag = true;
			notifyAll();
		}
	}
}
