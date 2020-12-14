package com.designpatters.observerbuiltin;

public class WeatherSimulator {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		weatherData.setMeasurements(10.8f, 19.8f, 17.5f);
	}

}
