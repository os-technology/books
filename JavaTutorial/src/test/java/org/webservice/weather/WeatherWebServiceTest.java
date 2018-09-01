package org.webservice.weather;

import org.junit.Test;
import org.webservice.weather.beans.WeatherWebServiceBean;
import org.webservice.weather.client.WeatherWebServiceStubClient;

public class WeatherWebServiceTest {
	@Test
	public void weatherDataTest(){
		String[] weather = new WeatherWebServiceStubClient().getWeatherInfoByCityName("北京");
		WeatherWebServiceBean w = new WeatherWebServiceBean(weather);
		System.out.println(w.getAttrProvince());
	}
}
