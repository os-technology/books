package org.test.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MockitoHelloTest {
	private MockitoHello mockitoHello;
	String name;
	User user1;
	User user2;

	@Before
	public void init() {
		mockitoHello = mock(MockitoHello.class);

		name = "张三";
		user1 = new User("Json", "23", "男", "爬山");
		user2 = new User("Mary", "20", "女", "游泳");

		when(mockitoHello.changeName(name, user1)).thenReturn(name);
		when(mockitoHello.addUser(user2)).thenReturn(1);
		 when(mockitoHello.addUser(user1, user2)).thenReturn(2);
		when(mockitoHello.getName()).thenReturn(name);
	}

	@Test
	public void changeNameTest() {
		String name = "张三";
		String output = mockitoHello.changeName("张1", user1);
		assertEquals(name, output);
	}

	@Test
	public void addUserTest() {

		int size = mockitoHello.addUser(user1, user2);
		assertEquals(2, size);
	}

}
