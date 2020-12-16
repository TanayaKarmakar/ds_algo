package com.designpatterns.structural.compound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flock implements Quackable {
	private List<Quackable> quackers;
	
	public Flock() {
		quackers = new ArrayList<>();
	}
	
	public void add(Quackable quackable) {
		quackers.add(quackable);
	}

	@Override
	public void quack() {
		Iterator<Quackable> quackItr = quackers.iterator();
		while(quackItr.hasNext()) {
			Quackable quackable = quackItr.next();
			quackable.quack();
		}

	}

	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}

}
