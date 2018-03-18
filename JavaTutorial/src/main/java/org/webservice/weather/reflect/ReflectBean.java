package org.webservice.weather.reflect;

import java.beans.PropertyDescriptor;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.webservice.weather.beans.WeatherWSStubBean;

public class ReflectBean {
	public static void classPropertyToList(Object object) {
		BeanUtilsBean bean = BeanUtilsBean.getInstance();
		PropertyUtilsBean pub = bean.getPropertyUtils();

		PropertyDescriptor[] propertyDes = pub.getPropertyDescriptors(object);
		for (int i = 0; i < propertyDes.length; i++) {
			PropertyDescriptor property = propertyDes[i];
			String pro = property.getPropertyType().getCanonicalName();
			System.out.println(property.getName());
		}

	}

	public static void main(String[] args) {
		WeatherWSStubBean ws = new WeatherWSStubBean();
		classPropertyToList(ws);

	}

}
