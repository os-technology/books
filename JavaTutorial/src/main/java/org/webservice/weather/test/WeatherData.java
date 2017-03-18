package org.webservice.weather.test;

import org.webservice.weather.beans.WeatherWSStubBean;
import org.webservice.weather.beans.WeatherWebServiceBean;
import org.webservice.weather.client.WeatherWSStubClient;
import org.webservice.weather.client.WeatherWebServiceStubClient;

/**
 * 天气数据测试主函数
 * 
 * @author admin
 * 
 */
public class WeatherData {

	public static void main(String[] args) {
//		weatherWSStubClientTest();
		WeatherWebServiceStubClientTest();

	}

	private static void WeatherWebServiceStubClientTest() {
		String[] weather = new WeatherWebServiceStubClient().getWeatherInfoByCityName("北京");// TODO
		WeatherWebServiceBean w = new WeatherWebServiceBean();
		w.getInstance(weather);
		System.out.println(w.getAttrProvince());
	}

	private static void weatherWSStubClientTest() {
		String[] str = new WeatherWSStubClient().getWeatherInfo("北京");
		// for(int i=0;i<str.length;i++){
		// System.out.println(getName(str[i])+":"+getCode(str[i]));
		// }
		WeatherWSStubBean s = WeatherWSStubBean.getInstance(str);
		System.out.println(s.getTodayInfo());
		System.out.println(s.getTomorrowInfo());
		System.out.println(s.getThreeInfo());

		// Date date = new Date();
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// System.out.println(sdf.format(date));
	}

}
