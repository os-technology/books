package com.design.model.observer.demo1weather;

import java.util.Observable;
import java.util.Observer;

//布告板2
public class ConditionDisplay2 implements Observer, DisplayElement {

	private float temperature;// 温度
	private float humidity;// 湿度
	private float pressure;// 压强
	private Observable observable;

	public ConditionDisplay2(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println("ConditionDisplay2 Conditions:" + temperature + "F degrees and " + humidity
				+ "% humidity and " + pressure + "Kpa");

	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weather = (WeatherData) o;
			this.temperature = weather.getTemperature();
			this.humidity = weather.getHumidity();
			this.pressure = weather.getPressure();
			display();
		}

	}

}
