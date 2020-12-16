package com.designpatterns.structural.compound;

public interface QuackObservable {
	public void registerObserver(Observer observer);
	public void notifyObservers();
}
