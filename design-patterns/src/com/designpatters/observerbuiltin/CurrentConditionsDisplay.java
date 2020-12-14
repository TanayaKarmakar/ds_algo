package com.designpatters.observerbuiltin;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements DisplayElement, Observer {
	private Observable weatherData;
	private float temperature;
	private float pressure;
	
	public CurrentConditionsDisplay(Observable weatherData) {
		this.weatherData = weatherData;
		this.weatherData.addObserver(this);
	}

	@Override
	public void update(Observable obj, Object arg) {
		if(obj instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)obj;
			this.temperature = weatherData.getTemperature();
			this.pressure = weatherData.getPressure();
			display();
		}

	}

	@Override
	public void display() {
		System.out.println("Current Conditions Display: Current Temperature : " 
	+ this.temperature + " | Current Pressure : " + this.pressure);

	}

}
