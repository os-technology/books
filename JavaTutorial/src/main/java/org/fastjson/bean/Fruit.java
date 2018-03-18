package org.fastjson.bean;


import com.alibaba.fastjson.annotation.JSONField;

public class Fruit {

	//@JSONField(name = "size_1")
	private int size_1;
	//@JSONField(name = "shape_1")
	private String shape_info;
	@JSONField(name = "color_1")
	private String color_info;

	/**
	 * @return the size_1
	 */
	//@JSONField(name = "size_1")
	public int getSize_1() {
		return size_1;
	}

	/**
	 * @param size_1
	 *            the size_1 to set
	 */
	//@JSONField(name = "size_1")
	public void setSize_1(int size_1) {
		this.size_1 = size_1;
	}

	 

	/**
	 * @return the shape_info
	 */
	public String getShape_info() {
		return shape_info;
	}

	/**
	 * @param shape_info the shape_info to set
	 */
	public void setShape_info(String shape_info) {
		this.shape_info = shape_info;
	}

	/**
	 * @return the color_info
	 */
	public String getColor_info() {
		return color_info;
	}

	/**
	 * @param color_info the color_info to set
	 */
	public void setColor_info(String color_info) {
		this.color_info = color_info;
	}


	@Override
	public String toString() {
		return "Fruit{" +
				"size_1=" + size_1 +
				", shape_info='" + shape_info + '\'' +
				", color_info='" + color_info + '\'' +
				'}';
	}
}
