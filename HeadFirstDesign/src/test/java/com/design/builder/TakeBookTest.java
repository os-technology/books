package com.design.builder;

import com.design.model.builder.demo3.TakeBook;

public class TakeBookTest {

	public static void main(String[] args) {
		TakeBook book = new TakeBook.Bookbag().setChinese("语文").setEnglish("英语").build();
		System.out.println(book);

	}

}
