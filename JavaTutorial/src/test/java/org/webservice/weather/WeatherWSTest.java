package org.webservice.weather;

import org.junit.Test;
import org.webservice.weather.beans.WeatherWSStubBean;
import org.webservice.weather.client.WeatherWSStubClient;

public class WeatherWSTest {
	@Test
	public void getWeatherDataTest() {
		String[] str = new WeatherWSStubClient().getWeatherArray("北京");
		// for(int i=0;i<str.length;i++){
		// System.out.println(getName(str[i])+":"+getCode(str[i]));
		// }
		WeatherWSStubBean s = WeatherWSStubBean.getInstance(str);
		System.out.println(s.getTodayInfo());
		System.out.println(s.getTomorrowInfo());
		System.out.println(s.getThreeInfo());

	}
}
