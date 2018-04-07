package com.design.model.observer.demo1weather;

import java.util.ArrayList;
import java.util.Observable;

public class WeatherData extends Observable {

	private float temperature;// 温度
	private float humidity;// 湿度
	private float pressure;// 压强

	public WeatherData() {

	}

	// measurements测量值
	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}

	public void setMeasurements(float tempature, float humidity, float pressure) {
		this.temperature = tempature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}
}
