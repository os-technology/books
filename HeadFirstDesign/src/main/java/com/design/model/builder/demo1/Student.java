package com.design.model.builder.demo1;

public class Student {

	private String name;
	private int age;
	private int height;
	private int sex;// 0：男性，1：女性，其他值非法

	private String schoolName;
	private String profession;
	private int gradeNo;// 年级编号

	// 扩展信息
	private String idCard;// 身份证
	private String stuNo;// 学号
	private String labName;// 实验室名称
	private String dormitoryAddress;// 宿舍地址

	private Student(Builder builder) {
		this.name = builder.name;
		this.age = builder.age;
		this.height = builder.height;
		this.sex = builder.sex;

		this.schoolName = builder.schoolName;
		this.profession = builder.profession;
		this.gradeNo = builder.gradeNo;

		this.idCard = builder.idCard;
		this.stuNo = builder.stuNo;
		this.labName = builder.labName;
		this.dormitoryAddress = builder.dormitoryAddress;
	}

	public static class Builder {
		private String name;
		private int age;
		private int height;
		private int sex; // 0表示男性，1表示女性，其它值非法

		private String schoolName;
		private String profession;
		// 要求分班的时候，名字相同的同学不能分配到一个班级
		private int gradeNo;// 年级编号

		// 扩展信息
		private String idCard;// 身份证号
		private String stuNo;// 学号
		private String labName;// 实验室名称
		private String dormitoryAddress;// 宿舍地址

		public Builder(String name, int age, int height, int sex) {
			super();
			this.name = name;
			this.age = age;
			this.height = height;
			this.sex = sex;
		}

		public Builder setSchoolName(String schoolName) {
			this.schoolName = schoolName;
			return this;
		}

		public Builder setProfession(String profession) {
			this.profession = profession;
			return this;
		}

		public Builder setGradeNo(int gradeNo) {
			this.gradeNo = gradeNo;
			return this;
		}

		public Builder setIdCard(String idCard) {
			this.idCard = idCard;
			return this;
		}

		public Builder setStuNo(String stuNo) {
			this.stuNo = stuNo;
			return this;
		}

		public Builder setLabName(String labName) {
			this.labName = labName;
			return this;
		}

		public Builder setDormitoryAddress(String dormitoryAddress) {
			this.dormitoryAddress = dormitoryAddress;
			return this;
		}

		// 构造器入口
		public Student buildInfo() {
			return new Student(this);
		}

	}

	@Override
	public String toString() {
		return "Students [name=" + name + ", age=" + age + ", height=" + height + ", sex=" + sex + ", schoolName="
				+ schoolName + ", profession=" + profession + ", gradeNo=" + gradeNo + "]";
	}

}
