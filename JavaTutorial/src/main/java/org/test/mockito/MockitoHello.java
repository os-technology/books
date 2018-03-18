package org.test.mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * mockito学习
 * 
 * @author yujinshui
 * @createTime 2016年8月20日 下午9:19:37
 */
public class MockitoHello {
	private List<User> list = new ArrayList<User>();

	public MockitoHello getMockito() {
		return null;
	}

	public String getName() {
		return null;
	}

	public String changeName(String name, User user) {
		user.setUsername(name);

		return user.getUsername();
	}

	public int addUser(User... user) {
		for (User u : user) {
			list.add(u);
		}
		return list.size();
	}

}

class User {
	private String username;
	private String age;
	private String gender;
	private String happy;

	public User(String username, String age, String gender, String happy) {
		super();
		this.username = username;
		this.age = age;
		this.gender = gender;
		this.happy = happy;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the happy
	 */
	public String getHappy() {
		return happy;
	}

	/**
	 * @param happy
	 *            the happy to set
	 */
	public void setHappy(String happy) {
		this.happy = happy;
	}

}
