package com.designpatters.observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float pressure;
	private float humidity;
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		this.weatherData.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println("CurrentConditionsDisplay : Current Temperature : " + temperature + 
				" | Current Pressure : " + pressure + ""
						+ " | Current Humidity : " + humidity);

	}

	@Override
	public void update(float temperature, float pressure, float humidity) {
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		display();
	}

}
