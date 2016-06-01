package com.design.model.observer.demo1weather;

public class WeatherState {

	public static void main(String[] args) {
		WeatherData wd = new WeatherData();

		CurrentConditionDisplay ccd = new CurrentConditionDisplay(wd);
		ConditionDisplay2 cd2 = new ConditionDisplay2(wd);

		wd.setMeasurements(80, 65, 30.4f);

	}

}
