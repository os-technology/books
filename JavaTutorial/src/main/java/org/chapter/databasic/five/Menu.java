package org.chapter.databasic.five;

import java.io.IOException;

public class Menu {

	public static void main(String[] args) throws IOException {
		char scan;
		do {
			System.out.println("1. if");
			System.out.println("2. switch");
			System.out.println("3. while");
			System.out.println("4. do-while");
			System.out.println("5 for\n");
			System.out.println("Choose one:");
			scan = (char) System.in.read();
		} while (scan > '5' || scan < '1');
		switch (scan) {
		case '1':
			System.out.println("if else is ok.");
			break;
		case '2':
			System.out.println("switch is ok.");
			break;
		case '3':
			System.out.println("while is ok.");
			break;
		case '4':
			System.out.println("do-while is ok.");
			break;
		case '5':
			System.out.println("for is ok.");
			break;
		default:
			System.out.println("This menu is not exists.");
		}

	}

}
