package com.designpatters.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
	private List<Observer> observers;
	private float temperature;
	private float pressure;
	private float humidity;
	
	public WeatherData() {
		observers = new ArrayList<>();
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer observer: observers) {
			observer.update(temperature, pressure, humidity);
		}
	}

	@Override
	public void removeObserver(Observer observer) {
		int indx = observers.indexOf(observer);
		if(indx >= 0)
			observers.remove(indx);
	}
	
	public void measurementsChanged() {
		notifyObservers();
	}
	
	public void setMeasures(float temperature, float pressure, float humidity) {
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		measurementsChanged();
	}

}
