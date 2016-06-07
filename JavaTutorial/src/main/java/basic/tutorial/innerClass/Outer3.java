package basic.tutorial.innerClass;

/**
 * 由于内部类可以直接访问其外部类的成分，<br/>
 * 因此当内部类与其外部类中存在同名属性或方 法时，也将导致命名冲突。<br/>
 * 所以在多层调用时要指明，
 * 
 * @author admin
 * 
 */
public class Outer3 {
	private int size;

	public class Inner {
		private int size;

		public void doStuff(int size) {
			size++;// 本地的size;
			this.size++;// 内部类的size
			Outer3.this.size++;// 外部类的 size
		}
	}
}