package com.design.builder;

import com.design.model.builder.demo1.Student;
import com.design.model.builder.demo1.Student.Builder;

/**
 * builder模式应用场景
 * <p>
 * Effective Java里说，当遇到多个构造器参数时，考虑用构造器模式。里面有个商品的例子。这让我想到了熟悉的学生信息管理系统。<br>
 * 拿研究生来说吧，入学考试后先进行面试和体检，然后是录取，最后是入学分班。这几个阶段对学生的信息需求是不一样的。<br>
 * 
 * 我们首先基于以下假设：<br>
 * 1、体检时只需要知道我们的姓名、性别、年龄和身高等信息。<br>
 * 2、录取的时候，需要在体检基本信息的基础上添加院系、年级等信息。<br>
 * 3、入学分班后，需要添加班号（班级编号）等信息。<br>
 * 4、正式开学后，为了便于管理，又需要完善身份证、学号、实验室名称和宿舍地址等信息。<br>
 * 
 * @author shui
 *
 */

public class StudentTest {

	public static void main(String[] args) {
		Student stu = new Student.Builder("张三", 21, 180, 0).setGradeNo(2)
				.setIdCard("身份证").setProfession("专业").buildInfo();
		System.out.println(stu);

	}

}
