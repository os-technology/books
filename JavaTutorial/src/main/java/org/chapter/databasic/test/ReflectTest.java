package org.chapter.databasic.test;

import java.lang.reflect.Field;

class ReflectTest {
	public static void main(String[] args) throws Exception {

		System.out.println("");

		Child c = new Child();

		Child1 newc = convert(c.getClass(), Child1.class);
		System.out.println(newc.getCdefid());
		System.out.println(newc.getCpbid());
		System.out.println(newc.getCpriid());
		System.out.println(newc.getCproid());
		System.out.println(newc.getFdefid());
		System.out.println(newc.getFpriid());
		System.out.println(newc.getFproid());
		System.out.println(newc.getFpbid());

		Class<?> clazz;
		try {
			clazz = Class.forName("one.Child");
			Object o = clazz.newInstance();
			Field[] fs = clazz.getFields();
			for (Field f : fs) {
				System.out.println(f.getName());
				System.out.println(f.get(o));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static <T1, T2> T2 convert(Class<T1> formClass, Class<T2> toClass) throws Exception {
		Object fromObject = formClass.newInstance();
		Object toObject = toClass.newInstance();
		for (Field f : formClass.getFields()) {
			f.setAccessible(true);
			String name = f.getName();
			Field tf = toClass.getField(name);
			tf.setAccessible(true);
			tf.set(toObject, (String) f.get(fromObject));

		}
		return (T2) toObject;
	}

}

interface behavior {
	// String iid="iid";
}

abstract class Parent {
	public String getFpbid() {
		return fpbid;
	}

	public void setFpbid(String fpbid) {
		this.fpbid = fpbid;
	}

	public String getFproid() {
		return fproid;
	}

	public void setFproid(String fproid) {
		this.fproid = fproid;
	}

	public String getFpriid() {
		return fpriid;
	}

	public void setFpriid(String fpriid) {
		this.fpriid = fpriid;
	}

	public String getFdefid() {
		return fdefid;
	}

	public void setFdefid(String fdefid) {
		this.fdefid = fdefid;
	}

	public String fpbid = "fpbid";
	protected String fproid = "fproid";
	String fdefid = "fdefid";
	private String fpriid = "fpriid";
}

class Child extends Parent implements behavior {
	public String cpbid = "cpbid";
	protected String cproid = "cproid";
	String cdefid = "cdefid";
	private String cpriid = "cpriid";

	public String getCpbid() {
		return cpbid;
	}

	public void setCpbid(String cpbid) {
		this.cpbid = cpbid;
	}

	public String getCproid() {
		return cproid;
	}

	public void setCproid(String cproid) {
		this.cproid = cproid;
	}

	public String getCdefid() {
		return cdefid;
	}

	public void setCdefid(String cdefid) {
		this.cdefid = cdefid;
	}

	public String getCpriid() {
		return cpriid;
	}

	public void setCpriid(String cpriid) {
		this.cpriid = cpriid;
	}

}

abstract class Parent1 {
	public String getFpbid() {
		return fpbid;
	}

	public void setFpbid(String fpbid) {
		this.fpbid = fpbid;
	}

	public String getFproid() {
		return fproid;
	}

	public void setFproid(String fproid) {
		this.fproid = fproid;
	}

	public String getFpriid() {
		return fpriid;
	}

	public void setFpriid(String fpriid) {
		this.fpriid = fpriid;
	}

	public String getFdefid() {
		return fdefid;
	}

	public void setFdefid(String fdefid) {
		this.fdefid = fdefid;
	}

	public String fpbid = "";
	protected String fproid = "";
	String fdefid = "";
	private String fpriid = "";
}

class Child1 extends Parent1 implements behavior {
	public String cpbid = "";
	protected String cproid = "";
	String cdefid = "";
	private String cpriid = "";

	public String getCpbid() {
		return cpbid;
	}

	public void setCpbid(String cpbid) {
		this.cpbid = cpbid;
	}

	public String getCproid() {
		return cproid;
	}

	public void setCproid(String cproid) {
		this.cproid = cproid;
	}

	public String getCdefid() {
		return cdefid;
	}

	public void setCdefid(String cdefid) {
		this.cdefid = cdefid;
	}

	public String getCpriid() {
		return cpriid;
	}

	public void setCpriid(String cpriid) {
		this.cpriid = cpriid;
	}

}
