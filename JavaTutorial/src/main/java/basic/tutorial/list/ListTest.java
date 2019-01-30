package basic.tutorial.list;

import java.util.LinkedList;

public class ListTest {
	
	
	public static void linklist(){
		LinkedList<String> list = new LinkedList<String>();
		list.add("1");
		list.add("2");
		list.addFirst("a");
		list.addLast("z");
		System.out.println(list.toString());
		
		
	}

	public static void main(String[] args) {
		linklist();

	}

}
