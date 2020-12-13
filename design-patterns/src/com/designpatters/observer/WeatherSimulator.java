package com.designpatters.observer;

public class WeatherSimulator {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
		weatherData.setMeasures(10.8f, 12.9f, 27.0f);
		weatherData.setMeasures(13.8f, 18.4f, 21.0f);
	}

}
