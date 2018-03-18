package org.springmvc.entity;

public class User {

	private Integer id;

	private String username;
	private String password;
	private Integer age;
	private String email;

	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", email="
				+ email + "]";
	}

	public User(String username, String password, Integer age, String email) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.email = email;
	}

	public User(Integer id, String username, String password, Integer age, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.email = email;
	}

	public User() {

	}
}
