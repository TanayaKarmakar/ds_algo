package com.designpatterns.structural.compound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Observable implements QuackObservable {
	List<Observer> observers;
	QuackObservable duck;
	
	public Observable(QuackObservable duck) {
		observers = new ArrayList<>();
		this.duck = duck;
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void notifyObservers() {
		Iterator<Observer> oItr = observers.iterator();
		while(oItr.hasNext()) {
			Observer observer = oItr.next();
			observer.update(duck);
		}
	}
}
