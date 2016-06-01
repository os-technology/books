package com.design.model.observer.demo1weather;

import java.util.Observable;
import java.util.Observer;

//布告板1
public class CurrentConditionDisplay implements Observer, DisplayElement {

	private float temperature;
	private float humidity;// 湿度
	private Observable observable;

	public CurrentConditionDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Current Conditions:" + temperature + "F degrees and " + humidity + "% humidity");
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weather = (WeatherData) o;
			this.temperature = weather.getTemperature();
			this.humidity = weather.getHumidity();
			display();
		}

	}

}
