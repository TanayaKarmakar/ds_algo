package com.designpatters.observerbuiltin;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class WeatherData extends Observable {
	private float temperature;
	private float pressure;
	private float humidity;
	
	public float getTemperature() {
		return temperature;
	}
	public float getPressure() {
		return pressure;
	}
	public float getHumidity() {
		return humidity;
	}
	
	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float pressure, float humidity) {
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		measurementsChanged();
	}
}
