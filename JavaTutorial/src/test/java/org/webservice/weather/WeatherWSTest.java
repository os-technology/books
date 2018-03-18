package org.webservice.weather;

import org.junit.Test;
import org.webservice.weather.beans.WeatherWSStubBean;
import org.webservice.weather.client.WeatherWSStubClient;

public class WeatherWSTest {
    @Test
    public void getWeatherDataTest() {
        String city = "威海";

        String[] str = new WeatherWSStubClient().getWeatherArray(city);
        // for(int i=0;i<str.length;i++){
        // System.out.println(getName(str[i])+":"+getCode(str[i]));
        // }
        WeatherWSStubBean s = WeatherWSStubBean.getInstance(str);
        System.out.println(city + "天气如下：");
//		this.weatherData(s);
        System.out.println(s.todayData());
        System.out.println(s.tomorrowData());
        System.out.println(s.threeData());
        System.out.println(s.fourData());
        System.out.println(s.fiveData());


        System.out.println(s.getTodayInfo());
        System.out.println(s.getTomorrowInfo());
        System.out.println(s.getThreeInfo());
        System.out.println(s.getFourInfo());
        System.out.println(s.getFiveInfo());

    }

    private void weatherData(WeatherWSStubBean s) {
        System.out.println(s.getAirState());
        System.out.println(s.getIndex());
        System.out.println(s.tomorrowData());

    }

}
